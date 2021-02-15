package software.bernie.geckolib3.forge;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import software.bernie.geckolib3.GeckoLibCommon;
import software.bernie.geckolib3.resource.ResourceListener;

public class GeckoLib {

	/**
	 * This method MUST be called in your mod's constructor or during
	 * onInitializeClient in fabric, otherwise models and animations won't be
	 * loaded.
	 */
	synchronized public static void initialize() {
		if (!GeckoLibCommon.hasInitialized) {
			DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ResourceListener::registerReloadListener);
		}
		GeckoLibCommon.hasInitialized = true;
	}
}
