/*
 * This file is part of the FilledToTheBrim project, licensed under the MIT License
 *
 * Copyright 2023  Jack
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package tech.lemonlime.filledtothebrim.mixin;


//#if MC >= 11700
//$$ import net.minecraft.item.BundleItem;
//#endif
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import tech.lemonlime.filledtothebrim.util.ShulkerBoxHelper;


//#if MC < 11700
@Mixin(DummyClass.class)
//#else
//$$ @Mixin(BundleItem.class)
//#endif
public class BundleItemMixin {




//    @Redirect(method = "onStackClicked",at=@At(value = "INVOKE",target = "net/minecraft/item/Item.canBeNested()Z"))
//    private static boolean fttb$redirect$canBeNested() {
//        return ShulkerBoxHelper.canInsertIntoShulkerBox(Blocks.AIR, this.getStack),stack);
//    }





}


