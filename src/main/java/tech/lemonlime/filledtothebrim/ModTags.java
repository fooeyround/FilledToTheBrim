/*
 * This file is part of the FilledToTheBrim project, licensed under the MIT License
 *
 * Copyright 2023  Jack
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED “AS IS, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package tech.lemonlime.filledtothebrim;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.Tag;
//#if MC >= 11800
//$$import net.minecraft.tag.TagKey;
//#endif

public class ModTags {

    public static void registerTags() {}








    //#if MC < 11600
    //$$ public static final Tag<Item> NOT_NESTABLE = ItemTags.register("not_nestable");
    //$$ public static final Tag<Item> NESTABLE_WHEN_EMPTY = ItemTags.register("nestable_when_empty");
    //$$ public static final Tag<Block> NOT_EMPTY_NESTABLE = BlockTags.register("not_empty_nestable");
    //#elseif MC < 11800
    public static final Tag.Identified<Item> NOT_NESTABLE = ItemTags.register("not_nestable");
    public static final Tag.Identified<Item> NESTABLE_WHEN_EMPTY = ItemTags.register("nestable_when_empty");
    public static final Tag.Identified<Block> NOT_EMPTY_NESTABLE = BlockTags.register("not_empty_nestable");
    //#else
    //$$    public static final TagKey<Item> NOT_NESTABLE = ItemTags.register("not_nestable");
    //$$    public static final TagKey<Item> NESTABLE_WHEN_EMPTY = ItemTags.register("nestable_when_empty");
    //$$    public static final TagKey<Block> NOT_EMPTY_NESTABLE = BlockTags.register("not_empty_nestable");
    //#endif







    public static boolean isBlockInTag(Block block, Object tag) {

        //#if MC < 11600
        //$$return block.matches((Tag<Block>) tag);
        //#elseif MC < 11800
        return block.isIn((Tag<Block>) tag);
        //#else
        //$$return block.getRegistryEntry().isIn((TagKey<Block>) tag);
        //#endif
    }

    public static boolean isItemInTag(Item item, Object tag) {


        //#if MC < 11600
        //$$return item.matches((Tag<Item>) tag);
        //#elseif MC < 11800
        return item.isIn((Tag<Item>) tag);
        //#else
        //$$return item.getRegistryEntry().isIn((TagKey<Item>) tag);
        //#endif
    }






}
