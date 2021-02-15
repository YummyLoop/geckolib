/*
 * Copyright (c) 2020.
 * Author: Bernie G. (Gecko)
 */

package software.bernie.geckolib3.fabric;

import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import software.bernie.geckolib3.GeckoLibCommon;
import software.bernie.geckolib3.fabric.resource.GeckoLibCache;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class GeckoLibFabric {
	public static void initialize() {
		GeckoLibCommon.init();
		if (!GeckoLibCommon.hasInitialized) {
			ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES)
					.registerReloadListener(new IdentifiableResourceReloadListener() {
						@Override
						public Identifier getFabricId() {
							return new Identifier(GeckoLibCommon.ModID, "models");
						}

						@Override
						public CompletableFuture<Void> reload(Synchronizer synchronizer, ResourceManager manager,
								Profiler prepareProfiler, Profiler applyProfiler, Executor prepareExecutor,
								Executor applyExecutor) {
							return GeckoLibCache.getInstance().resourceReload(synchronizer, manager, prepareProfiler,
									applyProfiler, prepareExecutor, applyExecutor);
						}
					});
		}
		GeckoLibCommon.hasInitialized = true;
	}
}
