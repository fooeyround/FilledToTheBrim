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


import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import tech.lemonlime.filledtothebrim.ModTags;

public class ShulkerBoxHelper {


    public static boolean checkInsert(Block block, ItemStack stack) {



        //Check not_nestable first, if in there disregard.

        //Before all else, check if the block is in the not_empty_nestable (Block Tag)
        //Check nestable_when_empty after, if in there and is empty, (For Now Check if it is a box)


        if (stack.getItem().isIn(ModTags.NESTABLE_WHEN_EMPTY)) {
            return true;
        }

        if (stack.getItem().isIn(ModTags.NOT_NESTABLE)) {
            return false;
        }

        if (block.isIn(ModTags.NOT_EMPTY_NESTABLE)) {
            return false;
        }



        return false;
    }



    public static boolean canInsertintoShulkerBox(Block block, ItemStack stack) {

        if (stack.getItem().isIn(ModTags.NOT_NESTABLE)) return false;

        if (!block.isIn(ModTags.NOT_EMPTY_NESTABLE) && stack.getItem().isIn(ModTags.NESTABLE_WHEN_EMPTY)) {
            return NbtUtil.isEmptyHeldContainer(stack);
        }

        return true;
    }

}

