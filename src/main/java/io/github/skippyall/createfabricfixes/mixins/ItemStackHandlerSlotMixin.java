package io.github.skippyall.createfabricfixes.mixins;

import io.github.fabricators_of_create.porting_lib.transfer.item.ItemStackHandler;
import io.github.fabricators_of_create.porting_lib.transfer.item.ItemStackHandlerSlot;

import net.minecraft.world.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemStackHandlerSlot.class)
public class ItemStackHandlerSlotMixin {
	@Shadow
	private ItemStack lastStack;

	@Inject(at = @At("TAIL"), method = "<init>")
	public void createfabricfixes$init(int index, ItemStackHandler handler, ItemStack initial, CallbackInfo info){
		lastStack = initial.copy();
	}
}
