package software.bernie.geckolib3;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public interface ArmorProvider {
	BipedEntityModel<LivingEntity> getArmorModelA(LivingEntity entity, ItemStack stack, EquipmentSlot slot,
												  BipedEntityModel<LivingEntity> defaultModel);

	Identifier getArmorTextureA(LivingEntity entity, ItemStack stack, EquipmentSlot slot, Identifier defaultTexture);
}