package com.Jack.FilledToTheBrim.util;


import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import org.jetbrains.annotations.Nullable;
/*
Credit: QuickCarpet 
This Code Is Addapted From QuickCarpet


Updated for MojMap/Forge.
For simplicity, I might switch to mojmap all around.

*/


public class nbtutil {

    public static final int TAG_END = 0;
    public static final int TAG_BYTE = 1;
    public static final int TAG_SHORT = 2;
    public static final int TAG_INT = 3;
    public static final int TAG_LONG = 4;
    public static final int TAG_FLOAT = 5;
    public static final int TAG_DOUBLE = 6;
    public static final int TAG_BYTEARRAY = 7;
    public static final int TAG_STRING = 8;
    public static final int TAG_LIST = 9;
    public static final int TAG_COMPOUND = 10;
    public static final int TAG_INTARRAY = 11;
    public static final int TAG_LONGARRAY = 12;

    @Nullable
    public static CompoundTag getBlockEntityTag(ItemStack stack) {
        CompoundTag tag = stack.getTag();
        return tag == null ? null : getTagOrNull(tag, "BlockEntityTag", TAG_COMPOUND);
    }

    @Nullable
    @SuppressWarnings("unchecked")
    public static <T extends Tag> T getTagOrNull(CompoundTag tag, String key, int type) {
        if (!tag.contains(key, type)) return null;
        //noinspection unchecked
        return (T) tag.get(key);
    }

    public static boolean cleanUpShulkerBoxTag(ItemStack stack) {
        boolean changed = false;

        CompoundTag bet = getBlockEntityTag(stack);
        if (bet == null) return false;
        ListTag items = getTagOrNull(bet, "Items", TAG_LIST);
        if (items != null && items.isEmpty()) {
            bet.remove("Items");
            changed = true;
        }

        if (bet.isEmpty()) {
            stack.setTag(null);
            changed = true;
        }

        return changed;
    }

    public static boolean hasShulkerBoxItems(ItemStack stack) {
        CompoundTag bet = getBlockEntityTag(stack);
        if (bet == null) return false;
        ListTag items = getTagOrNull(bet, "Items", TAG_LIST);
        return items != null && !items.isEmpty();
    }

    public static boolean isEmptyShulkerBox(ItemStack stack) {
        Item item = stack.getItem();
        return item instanceof BlockItem && ((BlockItem) item).getBlock() instanceof ShulkerBoxBlock && !hasShulkerBoxItems(stack);
    }


}

