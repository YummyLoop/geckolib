package software.bernie.example.registry;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.example.block.BotariumBlock;
import software.bernie.example.block.FertilizerBlock;
import software.bernie.geckolib3.GeckoLibCommon;

public class BlockRegistry {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			GeckoLibCommon.ModID);

	public static final RegistryObject<BotariumBlock> BOTARIUM_BLOCK = BLOCKS.register("botariumblock",
			BotariumBlock::new);
	public static final RegistryObject<FertilizerBlock> FERTILIZER_BLOCK = BLOCKS.register("fertilizerblock",
			FertilizerBlock::new);
}
