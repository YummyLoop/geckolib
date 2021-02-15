package software.bernie.geckolib3.fabric.model.provider;

import net.minecraft.util.Identifier;

public interface IAnimatableModelProvider<E> {
	/**
	 * This resource location needs to point to a json file of your animation file,
	 * i.e. "geckolib:animations/frog_animation.json"
	 *
	 * @return the animation file location
	 */
	Identifier getAnimationFileLocation(E animatable);
}