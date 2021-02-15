/*
 * Copyright (c) 2020.
 * Author: Bernie G. (Gecko)
 */

package software.bernie.example.registry;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.example.entity.BikeEntity;
import software.bernie.example.entity.GeoExampleEntity;
import software.bernie.geckolib3.GeckoLibCommon;

public class EntityRegistry {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			GeckoLibCommon.ModID);

	public static final RegistryObject<EntityType<GeoExampleEntity>> GEO_EXAMPLE_ENTITY = buildEntity(
			GeoExampleEntity::new, GeoExampleEntity.class, .7F, 1.3F);
	public static final RegistryObject<EntityType<BikeEntity>> BIKE_ENTITY = buildEntity(BikeEntity::new,
			BikeEntity.class, 0.5f, 0.6F);

	public static <T extends Entity> RegistryObject<EntityType<T>> buildEntity(EntityType.EntityFactory<T> entity,
			Class<T> entityClass, float width, float height) {
		String name = entityClass.getSimpleName().toLowerCase();
		return ENTITIES.register(name,
				() -> EntityType.Builder.create(entity, SpawnGroup.CREATURE).setDimensions(width, height).build(name));
	}
}
