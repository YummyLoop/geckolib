package software.bernie.example.registry;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.example.block.tile.BotariumTileEntity;
import software.bernie.example.block.tile.FertilizerTileEntity;
import software.bernie.geckolib3.GeckoLibCommon;

public class TileRegistry {
	public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, GeckoLibCommon.ModID);

	public static final RegistryObject<BlockEntityType<BotariumTileEntity>> BOTARIUM_TILE = TILES
			.register("botariumtile", () -> BlockEntityType.Builder
					.create(BotariumTileEntity::new, BlockRegistry.BOTARIUM_BLOCK.get()).build(null));
	public static final RegistryObject<BlockEntityType<FertilizerTileEntity>> FERTILIZER = TILES
			.register("fertilizertile", () -> BlockEntityType.Builder
					.create(FertilizerTileEntity::new, BlockRegistry.FERTILIZER_BLOCK.get()).build(null));
}