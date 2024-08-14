package net.janush.codelerning.block;

import net.janush.codelerning.CodeLerning;
import net.janush.codelerning.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> Blocks =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CodeLerning.MOD_ID);

    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK = registerBlock("raw_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.RAW_IRON_BLOCK)));


    public static final RegistryObject<Block> RAW_ALEXANDRITE_ORE = registerBlock("raw_alexandrite_ore",
    () -> new DropExperienceBlock(UniformInt.of(3,6), BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.STONE)
                .strength(2f).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = Blocks.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register (IEventBus eventBus) {
        Blocks.register(eventBus);
    }
}
