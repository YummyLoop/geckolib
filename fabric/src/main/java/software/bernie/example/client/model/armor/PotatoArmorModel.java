package software.bernie.example.client.model.armor;

import net.minecraft.util.Identifier;
import software.bernie.example.item.PotatoArmorItem;
import software.bernie.geckolib3.GeckoLibCommon;
import software.bernie.geckolib3.fabric.model.AnimatedGeoModel;

public class PotatoArmorModel extends AnimatedGeoModel<PotatoArmorItem> {
	@Override
	public Identifier getModelLocation(PotatoArmorItem object) {
		return new Identifier(GeckoLibCommon.ModID, "geo/potato_armor.geo.json");
	}

	@Override
	public Identifier getTextureLocation(PotatoArmorItem object) {
		return new Identifier(GeckoLibCommon.ModID, "textures/item/potato_armor.png");
	}

	@Override
	public Identifier getAnimationFileLocation(PotatoArmorItem animatable) {
		return new Identifier(GeckoLibCommon.ModID, "animations/potato_armor.animation.json");
	}
}
