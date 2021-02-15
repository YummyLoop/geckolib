package software.bernie.example.client.model.item;

import net.minecraft.util.Identifier;
import software.bernie.example.item.JackInTheBoxItem;
import software.bernie.geckolib3.fabric.GeckoLib;
import software.bernie.geckolib3.fabric.model.AnimatedGeoModel;

public class JackInTheBoxModel extends AnimatedGeoModel<JackInTheBoxItem> {
	@Override
	public Identifier getModelLocation(JackInTheBoxItem object) {
		return new Identifier(GeckoLib.ModID, "geo/jack.geo.json");
	}

	@Override
	public Identifier getTextureLocation(JackInTheBoxItem object) {
		return new Identifier(GeckoLib.ModID, "textures/item/jack.png");
	}

	@Override
	public Identifier getAnimationFileLocation(JackInTheBoxItem animatable) {
		return new Identifier(GeckoLib.ModID, "animations/jackinthebox.animation.json");
	}
}
