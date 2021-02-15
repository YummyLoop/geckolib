// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLibMod
// Paste this class into your mod and follow the documentation for GeckoLibMod to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package software.bernie.example.client.model.tile;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.fabric.GeckoLib;
import software.bernie.geckolib3.fabric.model.AnimatedGeoModel;

public class BotariumModel extends AnimatedGeoModel {
	@Override
	public Identifier getAnimationFileLocation(Object entity) {
		return new Identifier(GeckoLib.ModID, "animations/botarium.animation.json");
	}

	@Override
	public Identifier getModelLocation(Object animatable) {
		return new Identifier(GeckoLib.ModID, "geo/botarium.geo.json");
	}

	@Override
	public Identifier getTextureLocation(Object entity) {
		return new Identifier(GeckoLib.ModID, "textures/block/botarium.png");
	}
}