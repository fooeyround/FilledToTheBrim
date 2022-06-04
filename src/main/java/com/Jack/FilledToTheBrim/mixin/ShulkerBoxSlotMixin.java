package com.Jack.FilledToTheBrim.mixin;


import com.Jack.FilledToTheBrim.util.canInsert;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.ShulkerBoxSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;



@Mixin(value = ShulkerBoxSlot.class, priority = 69)
public class ShulkerBoxSlotMixin {


    @Inject(method = "canInsert", at = @At("HEAD"), cancellable = true)
    private void canInsert(ItemStack stack, CallbackInfoReturnable<Boolean> ci) {
        ci.setReturnValue(canInsert.canInsertintoShulkerBox(stack));

    }
}
