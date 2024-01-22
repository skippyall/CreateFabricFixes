package io.github.skippyall.createfabricfixes.mixins;

import org.spongepowered.asm.mixin.Mixin;

import io.github.fabricators_of_create.porting_lib.core.util.INBTSerializable;
import io.github.fabricators_of_create.porting_lib.transfer.item.ItemStackHandler;
import io.github.fabricators_of_create.porting_lib.transfer.item.SlottedStackStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.StorageView;
import net.minecraft.nbt.CompoundTag;

import java.util.Iterator;

@Mixin(ItemStackHandler.class)
public abstract class ItemStackHandlerMixin implements SlottedStackStorage, INBTSerializable<CompoundTag> {
	@SuppressWarnings("UnstableApiUsage")
	@Override
	public Iterable<StorageView<ItemVariant>> nonEmptyViews() {
		return SlottedStackStorage.super.nonEmptyViews();
	}

	@SuppressWarnings("UnstableApiUsage")
	@Override
	public Iterator<StorageView<ItemVariant>> nonEmptyIterator() {
		return SlottedStackStorage.super.nonEmptyIterator();
	}
}
