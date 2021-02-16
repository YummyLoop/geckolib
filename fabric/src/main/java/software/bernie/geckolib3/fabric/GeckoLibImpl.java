/*
 * Copyright (c) 2020.
 * Author: Bernie G. (Gecko)
 */

package software.bernie.geckolib3.fabric;

import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.compat.PatchouliCompat;
import software.bernie.geckolib3.resource.GeckoLibCache;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class GeckoLibImpl {
	public static void initialize() {
		if (!GeckoLib.hasInitialized) {
			ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES)
					.registerReloadListener(new IdentifiableResourceReloadListener() {
						@Override
						public Identifier getFabricId() {
							return new Identifier(GeckoLib.ModID, "models");
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
		GeckoLib.hasInitialized = true;
	}

	public static void iniPatchouli(MatrixStack stack){
		PatchouliCompat.patchouliLoaded(stack);
	}
}
