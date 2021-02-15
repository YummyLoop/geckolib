package software.bernie.geckolib3.forge.item;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.ArmorProvider;
import software.bernie.geckolib3.renderer.geo.GeoArmorRenderer;

public abstract class GeoArmorItem extends ArmorItem {
	public GeoArmorItem(ArmorMaterial materialIn, EquipmentSlot slot, Settings builder) {
		super(materialIn, slot, builder);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public <A extends BipedEntityModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack,
			EquipmentSlot armorSlot, A _default) {
		Class<? extends ArmorItem> clazz = this.getClass();
		GeoArmorRenderer renderer = GeoArmorRenderer.getRenderer(clazz);
		renderer.applyEntityStats(_default).applySlot(armorSlot);
		renderer.setCurrentItem(entityLiving, itemStack, armorSlot);
		return (A) renderer;
	}

	@Override
	public final String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		Class<? extends ArmorItem> clazz = this.getClass();
		GeoArmorRenderer renderer = GeoArmorRenderer.getRenderer(clazz);
		return renderer.getTextureLocation((ArmorItem) stack.getItem()).toString();
	}

}