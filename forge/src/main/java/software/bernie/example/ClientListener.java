/*
 * Copyright (c) 2020.
 * Author: Bernie G. (Gecko)
 */

package software.bernie.example;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;
import software.bernie.example.client.renderer.armor.PotatoArmorRenderer;
import software.bernie.example.client.renderer.entity.BikeGeoRenderer;
import software.bernie.example.client.renderer.entity.ExampleGeoRenderer;
import software.bernie.example.client.renderer.entity.ReplacedCreeperRenderer;
import software.bernie.example.client.renderer.tile.BotariumTileRenderer;
import software.bernie.example.client.renderer.tile.FertilizerTileRenderer;
import software.bernie.example.entity.ReplacedCreeperEntity;
import software.bernie.example.item.PotatoArmorItem;
import software.bernie.example.registry.BlockRegistry;
import software.bernie.example.registry.EntityRegistry;
import software.bernie.example.registry.TileRegistry;
import software.bernie.geckolib3.GeckoLibCommon;
import software.bernie.geckolib3.renderer.geo.GeoArmorRenderer;
import software.bernie.geckolib3.renderer.geo.GeoReplacedEntityRenderer;

@Mod.EventBusSubscriber(modid = GeckoLibCommon.ModID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(final FMLClientSetupEvent event) {
		if (!FMLEnvironment.production && !GeckoLibMod.DISABLE_IN_DEV) {
			RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.GEO_EXAMPLE_ENTITY.get(),
					ExampleGeoRenderer::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityRegistry.BIKE_ENTITY.get(), BikeGeoRenderer::new);

			GeoArmorRenderer.registerArmorRenderer(PotatoArmorItem.class, new PotatoArmorRenderer());
			ClientRegistry.bindTileEntityRenderer(TileRegistry.BOTARIUM_TILE.get(), BotariumTileRenderer::new);
			ClientRegistry.bindTileEntityRenderer(TileRegistry.FERTILIZER.get(), FertilizerTileRenderer::new);

			RenderLayers.setRenderLayer(BlockRegistry.BOTARIUM_BLOCK.get(), RenderLayer.getCutout());

			EntityRenderDispatcher renderManager = MinecraftClient.getInstance().getEntityRenderDispatcher();
			ReplacedCreeperRenderer creeperRenderer = new ReplacedCreeperRenderer(renderManager);
			renderManager.renderers.replace(EntityType.CREEPER, creeperRenderer);
			GeoReplacedEntityRenderer.registerReplacedEntity(ReplacedCreeperEntity.class, creeperRenderer);
		}
	}
}