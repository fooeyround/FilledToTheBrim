/*
 * This file is part of the FilledToTheBrim project, licensed under the MIT License
 *
 * Copyright 2023  Jack
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED “AS IS�?, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package tech.lemonlime.filledtothebrim.util;


import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import org.jetbrains.annotations.Nullable;

/*
Credit: QuickCarpet
*/


public class NbtUtil {

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
    public static NbtCompound getBlockEntityTag(ItemStack stack) {
        NbtCompound tag = stack.getTag();
        return tag == null ? null : getTagOrNull(tag, "BlockEntityTag", TAG_COMPOUND);
    }

    @Nullable
    public static <T extends NbtElement> T getTagOrNull(NbtCompound tag, String key, int type) {
        if (!tag.contains(key, type)) return null;
        //noinspection unchecked
        return (T) tag.get(key);
    }

    public static boolean cleanUpShulkerBoxTag(ItemStack stack) {
        boolean changed = false;

        NbtCompound bet = getBlockEntityTag(stack);
        if (bet == null) return false;
        NbtList items = getTagOrNull(bet, "Items", TAG_LIST);
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
        NbtCompound bet = getBlockEntityTag(stack);
        if (bet == null) return false;
        NbtList items = getTagOrNull(bet, "Items", TAG_LIST);
        return items != null && !items.isEmpty();
    }

    public static boolean isEmptyShulkerBox(ItemStack stack) {
        Item item = stack.getItem();
        return item instanceof BlockItem && ((BlockItem) item).getBlock() instanceof ShulkerBoxBlock && !hasShulkerBoxItems(stack);
    }


}

