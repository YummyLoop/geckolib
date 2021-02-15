package software.bernie.geckolib3;

import me.shedaniel.architectury.annotations.ExpectPlatform;
import net.minecraft.client.util.math.MatrixStack;

public class ModCompat {
    @ExpectPlatform
    public static void iniPatchouli(MatrixStack stack){
        throw new AssertionError();
    }
}
