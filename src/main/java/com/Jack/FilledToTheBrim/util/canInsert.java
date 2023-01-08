package com.Jack.FilledToTheBrim.util;

import com.Jack.FilledToTheBrim.FilledToTheBrim;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ShulkerBoxBlock;

public class canInsert {


    public static boolean canInsertintoShulkerBox(ItemStack stack) {

        boolean isEmptyShulkerBoxandisEnabled = nbtutil.isEmptyShulkerBox(stack) && FilledToTheBrim.IS_ENABLED;

        return !(Block.byItem(stack.getItem()) instanceof ShulkerBoxBlock || !stack.getItem().canFitInsideContainerItems()) || isEmptyShulkerBoxandisEnabled;
    }

}

