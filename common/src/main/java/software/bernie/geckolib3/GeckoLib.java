package software.bernie.geckolib3;

import me.shedaniel.architectury.annotations.ExpectPlatform;
import net.minecraft.client.util.math.MatrixStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GeckoLib {
    public static final String ModID = "geckolib3";
    public static final Logger LOGGER = LogManager.getLogger();
    public static boolean hasInitialized;

    @ExpectPlatform
    public static void initialize() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void iniPatchouli(MatrixStack stack) {
        throw new AssertionError();
    }
}