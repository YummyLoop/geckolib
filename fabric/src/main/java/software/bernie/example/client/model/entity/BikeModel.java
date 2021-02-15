package software.bernie.example.client.model.entity;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.GeckoLibCommon;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BikeModel extends AnimatedGeoModel {
	@Override
	public Identifier getAnimationFileLocation(Object entity) {
		return new Identifier(GeckoLibCommon.ModID, "animations/bike.animation.json");
	}

	@Override
	public Identifier getModelLocation(Object entity) {
		return new Identifier(GeckoLibCommon.ModID, "geo/bike.geo.json");
	}

	@Override
	public Identifier getTextureLocation(Object entity) {
		return new Identifier(GeckoLibCommon.ModID, "textures/model/entity/bike.png");
	}
}