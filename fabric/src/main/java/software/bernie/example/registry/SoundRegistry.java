package software.bernie.example.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import software.bernie.geckolib3.GeckoLibCommon;

public class SoundRegistry {
	public static SoundEvent JACK_MUSIC = Registry.register(Registry.SOUND_EVENT, "jack_music",
			new SoundEvent(new Identifier(GeckoLibCommon.ModID, "jack_music")));
}