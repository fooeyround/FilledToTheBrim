/*
 * This file is part of the FilledToTheBrim project, licensed under the MIT License
 *
 * Copyright 2023  Jack
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED “AS IS�?, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package tech.lemonlime.filledtothebrim.mixin.client;


import com.google.common.collect.Multimap;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.SynchronizeTagsS2CPacket;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import tech.lemonlime.filledtothebrim.ModTags;
import net.minecraft.util.registry.Registry;


//#if MC >= 11600
import net.minecraft.util.registry.RegistryKey;
//#endif


//#if MC < 11800
//#if MC > 11600
import net.minecraft.tag.TagManager;
//#else
//$$ import net.minecraft.tag.RegistryTagManager;
//#endif
//#endif



@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {



    //#if MC < 11500



    //#elseif MC < 11600

    

//$$    @Inject(method = "onSynchronizeTags", at = @At(value = "INVOKE", target = "Lcom/google/common/collect/Multimap;isEmpty()Z"), locals = LocalCapture.CAPTURE_FAILHARD)
//$$    private void ignoreMissingCarpetTags(SynchronizeTagsS2CPacket packet, CallbackInfo ci, RegistryTagManager manager, Multimap<Identifier, Identifier> map) {
//$$
//$$        map.get(new Identifier("block")).removeIf(ModTags::syncShouldIgnore);
//$$        map.get(new Identifier("item")).removeIf(ModTags::syncShouldIgnore);
//$$
//$$
//$$
//$$    }



    //#elseif MC < 11700


    @Inject(method = "onSynchronizeTags", at = @At(value = "INVOKE", target = "Lcom/google/common/collect/Multimap;isEmpty()Z"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void ignoreMissingCarpetTags(SynchronizeTagsS2CPacket packet, CallbackInfo ci, TagManager manager, Multimap<Identifier, Identifier> map) {

        map.get(new Identifier("block")).removeIf(ModTags::syncShouldIgnore);
        map.get(new Identifier("item")).removeIf(ModTags::syncShouldIgnore);



    }

    //#elseif MC < 11800



//$$    @Inject(method = "onSynchronizeTags", at = @At(value = "INVOKE", target = "Lcom/google/common/collect/Multimap;isEmpty()Z", remap = false), locals = LocalCapture.CAPTURE_FAILHARD)
//$$    private void ignoreMissingCarpetTags(SynchronizeTagsS2CPacket packet, CallbackInfo ci, TagManager manager, Multimap<RegistryKey<? extends Registry<?>>, Identifier> map) {
//$$        map.get(Registry.BLOCK_KEY).removeIf(ModTags::syncShouldIgnore);
//$$        map.get(Registry.ITEM_KEY).removeIf(ModTags::syncShouldIgnore);
//$$
//$$    }

    //#endif


}
