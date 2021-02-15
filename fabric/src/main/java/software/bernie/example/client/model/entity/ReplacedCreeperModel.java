package software.bernie.example.client.model.entity;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.GeckoLibCommon;
import software.bernie.geckolib3.fabric.model.AnimatedGeoModel;

public class ReplacedCreeperModel extends AnimatedGeoModel {
	@Override
	public Identifier getModelLocation(Object object) {
		return new Identifier(GeckoLibCommon.ModID, "geo/creeper.geo.json");
	}

	@Override
	public Identifier getTextureLocation(Object object) {
		return new Identifier(GeckoLibCommon.ModID, "textures/model/entity/creeper.png");
	}

	@Override
	public Identifier getAnimationFileLocation(Object animatable) {
		return new Identifier(GeckoLibCommon.ModID, "animations/creeper.animation.json");
	}
}