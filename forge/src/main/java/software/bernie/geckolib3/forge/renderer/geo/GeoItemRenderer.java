package software.bernie.geckolib3.forge.renderer.geo;

import java.awt.Color;
import java.util.Collections;
import java.util.Objects;


import com.mojang.blaze3d.systems.RenderSystem;


import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderer.geo.IGeoRenderer;

public abstract class GeoItemRenderer<T extends Item & IAnimatable> extends BuiltinModelItemRenderer
		implements IGeoRenderer<T> {
	// Register a model fetcher for this renderer
	static {
		AnimationController.addModelFetcher((IAnimatable object) -> {
			if (object instanceof Item) {
				Item item = (Item) object;
				BuiltinModelItemRenderer renderer = item.getItemStackTileEntityRenderer();
				if (renderer instanceof GeoItemRenderer) {
					return ((GeoItemRenderer<?>) renderer).getGeoModelProvider();
				}
			}
			return null;
		});
	}

	protected AnimatedGeoModel<T> modelProvider;
	protected ItemStack currentItemStack;

	public GeoItemRenderer(AnimatedGeoModel<T> modelProvider) {
		this.modelProvider = modelProvider;
	}

	public void setModel(AnimatedGeoModel<T> model) {
		this.modelProvider = model;
	}

	@Override
	public AnimatedGeoModel<T> getGeoModelProvider() {
		return modelProvider;
	}

	// fixes the item lighting
	@Override
	public void render(ItemStack itemStack, ModelTransformation.Mode mode,
			MatrixStack matrixStack, VertexConsumerProvider bufferIn, int combinedLightIn, int combinedOverlayIn) {
		if (mode == ModelTransformation.Mode.GUI) {
			RenderSystem.pushMatrix();
			VertexConsumerProvider.Immediate irendertypebuffer$impl = MinecraftClient.getInstance().getBufferBuilders()
					.getEntityVertexConsumers();
			DiffuseLighting.disableGuiDepthLighting();
			this.render((T) itemStack.getItem(), matrixStack, bufferIn, combinedLightIn, itemStack);
			irendertypebuffer$impl.draw();
			RenderSystem.enableDepthTest();
			DiffuseLighting.enableGuiDepthLighting();
			RenderSystem.popMatrix();
		} else {
			this.render((T) itemStack.getItem(), matrixStack, bufferIn, combinedLightIn, itemStack);
		}
		this.render((T) itemStack.getItem(), matrixStack, bufferIn, combinedLightIn, itemStack);
	}

	public void render(T animatable, MatrixStack stack, VertexConsumerProvider bufferIn, int packedLightIn,
					   ItemStack itemStack) {
		this.currentItemStack = itemStack;
		GeoModel model = modelProvider.getModel(modelProvider.getModelLocation(animatable));
		AnimationEvent itemEvent = new AnimationEvent(animatable, 0, 0, MinecraftClient.getInstance().getTickDelta(),
				false, Collections.singletonList(itemStack));
		modelProvider.setLivingAnimations(animatable, this.getUniqueID(animatable), itemEvent);
		stack.push();
		stack.translate(0, 0.01f, 0);
		stack.translate(0.5, 0.5, 0.5);

		MinecraftClient.getInstance().textureManager.bindTexture(getTextureLocation(animatable));
		Color renderColor = getRenderColor(animatable, 0, stack, bufferIn, null, packedLightIn);
		RenderLayer renderType = getRenderType(animatable, 0, stack, bufferIn, null, packedLightIn,
				getTextureLocation(animatable));
		render(model, animatable, 0, renderType, stack, bufferIn, null, packedLightIn, OverlayTexture.DEFAULT_UV,
				(float) renderColor.getRed() / 255f, (float) renderColor.getGreen() / 255f,
				(float) renderColor.getBlue() / 255f, (float) renderColor.getAlpha() / 255);
		stack.pop();
	}

	protected RenderLayer getRenderLayer(T tile, MatrixStack stack, VertexConsumerProvider bufferIn, int packedLightIn,
			Identifier textureLocation) {
		return RenderLayer.getEntityCutoutNoCull(textureLocation);
	}

	protected Color getRenderColor(T tile, MatrixStack stack, VertexConsumerProvider bufferIn, int packedLightIn) {
		return new Color(255, 255, 255, 255);
	}

	@Override
	public Identifier getTextureLocation(T instance) {
		return this.modelProvider.getTextureLocation(instance);
	}

	@Override
	public Integer getUniqueID(T animatable) {
		return currentItemStack.hasTag() ? 1 : Objects.hash(currentItemStack);
	}
}
