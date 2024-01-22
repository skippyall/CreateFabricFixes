package io.github.skippyall.createfabricfixes.mixins;

import java.util.Iterator;

import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import com.google.common.collect.Iterators;

import io.github.fabricators_of_create.porting_lib.extensions.INBTSerializable;
import io.github.fabricators_of_create.porting_lib.transfer.ExtendedStorage;
import io.github.fabricators_of_create.porting_lib.transfer.item.ItemStackHandler;
import io.github.fabricators_of_create.porting_lib.transfer.item.ItemStackHandlerSnapshot;
import io.github.fabricators_of_create.porting_lib.transfer.item.SlotExposedStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.StorageView;
import net.fabricmc.fabric.api.transfer.v1.transaction.base.SnapshotParticipant;
import net.minecraft.nbt.CompoundTag;

@Mixin(ItemStackHandler.class)
@SuppressWarnings("UnstableApiUsage")
public abstract class ItemStackHandlerMixin extends SnapshotParticipant<ItemStackHandlerSnapshot> implements Storage<ItemVariant>, ExtendedStorage<ItemVariant>, INBTSerializable<CompoundTag>, SlotExposedStorage {
	@Shadow
	public abstract @NotNull Iterator<StorageView<ItemVariant>> iterator();

	@Override
	public Iterator<StorageView<ItemVariant>> nonEmptyViews() {
		return Iterators.filter(iterator(), view -> !view.isResourceBlank() && view.getAmount() > 0);
	}
}
