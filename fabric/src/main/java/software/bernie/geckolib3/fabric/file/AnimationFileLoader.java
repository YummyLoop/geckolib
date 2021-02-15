package software.bernie.geckolib3.fabric.file;

import com.eliotlash.molang.MolangParser;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.client.gl.ShaderParseException;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import org.apache.commons.io.IOUtils;
import software.bernie.geckolib3.GeckoLibCommon;
import software.bernie.geckolib3.core.builder.Animation;
import software.bernie.geckolib3.fabric.util.json.JsonAnimationUtils;
import software.bernie.geckolib3.file.AnimationFile;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

public class AnimationFileLoader {

	public AnimationFile loadAllAnimations(MolangParser parser, Identifier location, ResourceManager manager) {
		AnimationFile animationFile = new AnimationFile();
		JsonObject jsonRepresentation = loadFile(location, manager);
		Set<Map.Entry<String, JsonElement>> entrySet = JsonAnimationUtils.getAnimations(jsonRepresentation);
		for (Map.Entry<String, JsonElement> entry : entrySet) {
			String animationName = entry.getKey();
			Animation animation;
			try {
				animation = JsonAnimationUtils.deserializeJsonToAnimation(
						JsonAnimationUtils.getAnimation(jsonRepresentation, animationName), parser);
				animationFile.putAnimation(animationName, animation);
			} catch (ShaderParseException e) {
				GeckoLibCommon.LOGGER.error("Could not load animation: {}", animationName, e);
				throw new RuntimeException(e);
			}
		}
		return animationFile;
	}

	/**
	 * Internal method for handling reloads of animation files. Do not override.
	 */
	private JsonObject loadFile(Identifier location, ResourceManager manager) {
		String content = getResourceAsString(location, manager);
		Gson GSON = new Gson();
		return JsonHelper.deserialize(GSON, content, JsonObject.class);
	}

	public static String getResourceAsString(Identifier location, ResourceManager manager) {
		try (InputStream inputStream = manager.getResource(location).getInputStream()) {
			return IOUtils.toString(inputStream);
		} catch (Exception e) {
			String message = "Couldn't load " + location;
			GeckoLibCommon.LOGGER.error(message, e);
			throw new RuntimeException(new FileNotFoundException(location.toString()));
		}
	}

}
