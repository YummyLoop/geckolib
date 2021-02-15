package software.bernie.geckolib3.fabric;

import net.minecraft.client.util.math.MatrixStack;
import software.bernie.geckolib3.fabric.compat.PatchouliCompat;

public class ModCompatImpl {
    public static void iniPatchouli(MatrixStack stack){
        PatchouliCompat.patchouliLoaded(stack);
    }
}
