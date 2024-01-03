package dev.mayaqq.estrogen.fabric.datagen.tags;

import dev.mayaqq.estrogen.registry.common.EstrogenBlocks;
import dev.mayaqq.estrogen.registry.common.EstrogenFluids;
import dev.mayaqq.estrogen.registry.common.EstrogenItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import java.util.concurrent.CompletableFuture;

public class EstrogenTags {
    public static class ItemTags extends FabricTagProvider.ItemTagProvider {

        public static final TagKey<Item> THIGHS = TagKey.create(BuiltInRegistries.ITEM.key(), new ResourceLocation("trinkets", "legs/thighs"));

        public ItemTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
        }
        @Override
        protected void addTags(HolderLookup.Provider arg) {
            getOrCreateTagBuilder(THIGHS)
                    .add(EstrogenItems.ESTROGEN_PATCHES.get());
            getOrCreateTagBuilder(dev.mayaqq.estrogen.registry.common.EstrogenTags.UWUFYING)
                    .add(EstrogenItems.UWU.get());
        }
    }

    public static class BlockTags extends FabricTagProvider.BlockTagProvider {

        public static final TagKey<Block> PICKAXE_MINABLE = TagKey.create(BuiltInRegistries.BLOCK.key(), new ResourceLocation("minecraft", "mineable/pickaxe"));

        public BlockTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider arg) {
            getOrCreateTagBuilder(PICKAXE_MINABLE)
                    .add(EstrogenBlocks.CENTRIFUGE.get());
        }
    }

    public static class FluidTags extends FabricTagProvider.FluidTagProvider {

        // vanilla
        public static final TagKey<Fluid> WATER = TagKey.create(BuiltInRegistries.FLUID.key(), mcId("water"));
        public static final TagKey<Fluid> LAVA = TagKey.create(BuiltInRegistries.FLUID.key(), mcId("lava"));

        public FluidTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider arg) {
            getOrCreateTagBuilder(WATER)
                    .add(EstrogenFluids.LIQUID_ESTROGEN.still().get()).add(EstrogenFluids.LIQUID_ESTROGEN.flowing().get())
                    .add(EstrogenFluids.HORSE_URINE.still().get()).add(EstrogenFluids.HORSE_URINE.flowing().get())
                    .add(EstrogenFluids.FILTRATED_HORSE_URINE.still().get()).add(EstrogenFluids.FILTRATED_HORSE_URINE.flowing().get())
                    .add(EstrogenFluids.TESTOSTERONE_MIXTURE.still().get()).add(EstrogenFluids.TESTOSTERONE_MIXTURE.flowing().get());

            getOrCreateTagBuilder(LAVA)
                    .add(EstrogenFluids.MOLTEN_AMETHYST.still().get()).add(EstrogenFluids.MOLTEN_AMETHYST.flowing().get())
                    .add(EstrogenFluids.MOLTEN_SLIME.still().get()).add(EstrogenFluids.MOLTEN_SLIME.flowing().get());
        }
    }

    public static class EntityTypeTags extends FabricTagProvider.EntityTypeTagProvider {
        public EntityTypeTags(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider arg) {}
    }

    private static ResourceLocation mcId(String path) {
        return new ResourceLocation("minecraft", path);
    }
}
