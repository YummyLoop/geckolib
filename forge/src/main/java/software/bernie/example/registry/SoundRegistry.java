package software.bernie.example.registry;


import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib3.GeckoLibCommon;


public class SoundRegistry {
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,
			GeckoLibCommon.ModID);

	public static RegistryObject<SoundEvent> JACK_MUSIC = SOUNDS.register("jack_music",
			() -> new SoundEvent(new Identifier(GeckoLibCommon.ModID, "jack_music")));
}
