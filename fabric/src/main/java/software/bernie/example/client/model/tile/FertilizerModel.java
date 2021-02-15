// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLibMod
// Paste this class into your mod and follow the documentation for GeckoLibMod to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package software.bernie.example.client.model.tile;

import net.minecraft.util.Identifier;
import software.bernie.example.block.tile.FertilizerTileEntity;
import software.bernie.geckolib3.GeckoLibCommon;
import software.bernie.geckolib3.fabric.model.AnimatedGeoModel;

public class FertilizerModel extends AnimatedGeoModel<FertilizerTileEntity> {
	@Override
	public Identifier getAnimationFileLocation(FertilizerTileEntity animatable) {
		if (animatable.getWorld().isRaining()) {
			return new Identifier(GeckoLibCommon.ModID, "animations/fertilizer.animation.json");
		} else {
			return new Identifier(GeckoLibCommon.ModID, "animations/botarium.animation.json");
		}
	}

	@Override
	public Identifier getModelLocation(FertilizerTileEntity animatable) {
		if (animatable.getWorld().isRaining()) {
			return new Identifier(GeckoLibCommon.ModID, "geo/fertilizer.geo.json");
		} else {
			return new Identifier(GeckoLibCommon.ModID, "geo/botarium.geo.json");
		}
	}

	@Override
	public Identifier getTextureLocation(FertilizerTileEntity entity) {
		if (entity.getWorld().isRaining()) {
			return new Identifier(GeckoLibCommon.ModID + ":textures/block/fertilizer.png");
		} else {
			return new Identifier(GeckoLibCommon.ModID + ":textures/block/botarium.png");
		}
	}
}