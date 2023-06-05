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
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.item.Item;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Identifier;
//#if MC < 11900
import net.minecraft.tag.Tag;
import tech.lemonlime.filledtothebrim.util.NbtUtil;
import tech.lemonlime.filledtothebrim.util.ShulkerBoxHelper;
//#endif
//#if MC >= 11800
//$$import net.minecraft.tag.TagKey;
//#endif

public class ModTags {


    //#if MC < 11600
    //$$ public static Tag<Item> NOT_NESTABLE;
    //$$ public static Tag<Item> NESTABLE_WHEN_EMPTY;
    //$$ public static Tag<Block> NOT_EMPTY_NESTABLE;
    //#elseif MC < 11800
    public static Tag.Identified<Item> NOT_NESTABLE;
    public static Tag.Identified<Item> NESTABLE_WHEN_EMPTY;
    public static Tag.Identified<Block> NOT_EMPTY_NESTABLE;
    //#else
    //$$    public static TagKey<Item> NOT_NESTABLE;
    //$$    public static TagKey<Item> NESTABLE_WHEN_EMPTY;
    //$$    public static TagKey<Block> NOT_EMPTY_NESTABLE;
    //#endif


    static {
        //#if MC < 11600
        //$$ NOT_NESTABLE = ItemTags.register("fttb:not_nestable");
        //$$ NESTABLE_WHEN_EMPTY = ItemTags.register("fttb:nestable_when_empty");
        //$$ NOT_EMPTY_NESTABLE = BlockTags.register("fttb:not_empty_nestable");
        //#elseif MC < 11800
        NOT_NESTABLE = ItemTags.register("fttb:not_nestable");
        NESTABLE_WHEN_EMPTY = ItemTags.register("fttb:nestable_when_empty");
        NOT_EMPTY_NESTABLE = BlockTags.register("fttb:not_empty_nestable");
        //#else
        //$$   NOT_NESTABLE = ItemTags.register("fttb:not_nestable");
        //$$   NESTABLE_WHEN_EMPTY = ItemTags.register("fttb:nestable_when_empty");
        //$$   NOT_EMPTY_NESTABLE = BlockTags.register("fttb:not_empty_nestable");
        //#endif

    }



    public static void registerTags() {

/*

        //#if MC < 11600
        //$$ Tag<Item> NOT_NESTABLE = ItemTags.register("fttb:not_nestable");
        //$$ Tag<Item> NESTABLE_WHEN_EMPTY = ItemTags.register("fttb:nestable_when_empty");
        //$$ Tag<Block> NOT_EMPTY_NESTABLE = BlockTags.register("fttb:not_empty_nestable");
        //#elseif MC < 11800
        Tag.Identified<Item> NOT_NESTABLE = ItemTags.register("fttb:not_nestable");
        Tag.Identified<Item> NESTABLE_WHEN_EMPTY = ItemTags.register("fttb:nestable_when_empty");
        Tag.Identified<Block> NOT_EMPTY_NESTABLE = BlockTags.register("fttb:not_empty_nestable");
        //#else
        //$$    TagKey<Item> NOT_NESTABLE = ItemTags.register("fttb:not_nestable");
        //$$    TagKey<Item> NESTABLE_WHEN_EMPTY = ItemTags.register("fttb:nestable_when_empty");
        //$$    TagKey<Block> NOT_EMPTY_NESTABLE = BlockTags.register("fttb:not_empty_nestable");
        //#endif
*/




    }













    public static boolean isBlockInTag(Block block, Object tag) {

        try {
            
            //#if MC < 11800
            return ((Tag<Block>) tag).contains(block);
            //#else
            //$$return block.getRegistryEntry().isIn((TagKey<Block>) tag);
            //#endif

        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isItemInTag(Item item, Object tag) {


        try {

        //#if MC < 11800
        return ((Tag<Item>)tag).contains(item);
        //#else
        //$$return item.getRegistryEntry().isIn((TagKey<Item>) tag);
        //#endif

        } catch (Exception e) {
            return (Block.getBlockFromItem(item) instanceof ShulkerBoxBlock);
        }
    }


    public static boolean syncShouldIgnore(Identifier key) {
        return key.getNamespace().equals("fttb");
    }





}
