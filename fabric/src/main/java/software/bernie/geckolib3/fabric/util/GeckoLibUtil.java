package software.bernie.geckolib3.fabric.util;

import net.minecraft.item.ItemStack;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Objects;

public class GeckoLibUtil {
	public static int getIDFromStack(ItemStack stack) {
		return stack.hasTag() ? 1 : Objects.hash(stack);
	}

	public static AnimationController getControllerForStack(AnimationFactory factory, ItemStack stack,
			String controllerName) {
		return factory.getOrCreateAnimationData(getIDFromStack(stack)).getAnimationControllers().get(controllerName);
	}
}