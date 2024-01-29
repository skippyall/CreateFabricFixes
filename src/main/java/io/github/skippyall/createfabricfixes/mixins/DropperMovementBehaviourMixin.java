package io.github.skippyall.createfabricfixes.mixins;

import java.util.function.Predicate;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.simibubi.create.content.contraptions.behaviour.MovementBehaviour;
import com.simibubi.create.content.contraptions.behaviour.dispenser.DropperMovementBehaviour;

import net.minecraft.world.item.ItemStack;

@Mixin(DropperMovementBehaviour.class)
public abstract class DropperMovementBehaviourMixin implements MovementBehaviour {
	@WrapOperation(method = "lambda$collectItems$1", remap = false, at = @At(value = "INVOKE", target = "Lcom/simibubi/create/foundation/item/ItemHelper;sameItemPredicate(Lnet/minecraft/world/item/ItemStack;)Ljava/util/function/Predicate;"))
	private static Predicate<ItemStack> sameItemSameTagsPredicate(ItemStack stack, Operation<Predicate<ItemStack>> operation) {
		return s -> ItemStack.isSameItemSameTags(s, stack);
	}
}
