package software.bernie.geckolib3;

import me.shedaniel.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GeckoLibCommon.MOD_ID)
public class GeckoLibForge {
    public GeckoLibForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(GeckoLibCommon.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        GeckoLibCommon.init();
    }
}