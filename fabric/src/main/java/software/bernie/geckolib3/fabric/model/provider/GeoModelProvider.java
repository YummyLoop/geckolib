package software.bernie.geckolib3.fabric.model.provider;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.fabric.resource.GeckoLibCache;

public abstract class GeoModelProvider<T> {
	public double seekTime;
	public double lastGameTickTime;
	public boolean shouldCrashOnMissing = false;

	public GeoModel getModel(Identifier location) {
		return GeckoLibCache.getInstance().getGeoModels().get(location);
	}

	public abstract Identifier getModelLocation(T object);

	public abstract Identifier getTextureLocation(T object);
}