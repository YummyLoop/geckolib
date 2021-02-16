package software.bernie.geckolib3;

import net.minecraft.client.util.math.MatrixStack;
import software.bernie.geckolib3.compat.PatchouliCompat;

public class ModCompatImpl {
    public static void iniPatchouli(MatrixStack stack){ PatchouliCompat.patchouliLoaded(stack); }
}
