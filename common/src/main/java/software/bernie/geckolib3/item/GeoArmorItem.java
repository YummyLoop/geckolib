package software.bernie.geckolib3.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.ArmorProvider;
import software.bernie.geckolib3.renderer.geo.GeoArmorRenderer;

public abstract class GeoArmorItem extends ArmorItem implements ArmorProvider {
	public GeoArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, Settings builder) {
		super(materialIn, slot, builder);
	}

	@Environment(EnvType.CLIENT)
	public BipedEntityModel<LivingEntity> getArmorModelA(LivingEntity entityLiving, ItemStack itemStack,
			EquipmentSlot armorSlot, BipedEntityModel<LivingEntity> _default) {
		Class<? extends ArmorItem> clazz = this.getClass();
		GeoArmorRenderer renderer = GeoArmorRenderer.getRenderer(clazz);
		renderer.applyEntityStats(_default).applySlot(armorSlot);
		renderer.setCurrentItem(entityLiving, itemStack, armorSlot);
		return renderer;
	}

	//@Override
	@Environment(EnvType.CLIENT) //This is necessary to work on forge
	public <A extends BipedEntityModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
														   EquipmentSlot armorSlot, A _default) {
		Class<? extends ArmorItem> clazz = this.getClass();
		GeoArmorRenderer renderer = GeoArmorRenderer.getRenderer(clazz);
		renderer.applyEntityStats(_default).applySlot(armorSlot);
		renderer.setCurrentItem(entityLiving, itemStack, armorSlot);
		return (A) renderer;
	}


	@Override
	public Identifier getArmorTextureA(LivingEntity entity, ItemStack stack, EquipmentSlot slot,
									   Identifier defaultTexture) {
		Class<? extends ArmorItem> clazz = this.getClass();
		GeoArmorRenderer renderer = GeoArmorRenderer.getRenderer(clazz);
		return renderer.getTextureLocation((ArmorItem) stack.getItem());
	}

	//@Override //This is necessary to work on forge
	public final String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		Class<? extends ArmorItem> clazz = this.getClass();
		GeoArmorRenderer renderer = GeoArmorRenderer.getRenderer(clazz);
		return renderer.getTextureLocation((ArmorItem) stack.getItem()).toString();
	}

}