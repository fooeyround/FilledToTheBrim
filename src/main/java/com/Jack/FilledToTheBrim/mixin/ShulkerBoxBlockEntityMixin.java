package com.Jack.FilledToTheBrim.mixin;

import com.Jack.FilledToTheBrim.util.canInsert;
import net.minecraft.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;



@Mixin(value = ShulkerBoxBlockEntity.class, priority = 69)
public class ShulkerBoxBlockEntityMixin {

    @Inject(method = "canInsert", at = @At("HEAD"), cancellable = true)
    private void canInsert(int slot, ItemStack stack, @Nullable Direction dir, CallbackInfoReturnable<Boolean> ci) {
        ci.setReturnValue(canInsert.canInsertintoShulkerBox(stack));
    }
}


