package io.github.skippyall.createfabricfixes.mixins;

import java.util.ArrayList;
import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import io.github.fabricators_of_create.porting_lib.entity.extensions.EntityExtensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;


@Mixin(value = Entity.class, priority = 1001)
public abstract class EntityReMixin implements EntityExtensions {
	@Unique
	private int capturedDropsCount = 0;

	@Shadow
	private List<ItemEntity> capturedDrops;

	@Override
	public void startCapturingDrops() {
		if (capturedDropsCount == 0)
			capturedDrops = new ArrayList<>();
		capturedDropsCount++;
	}

	@Override
	public List<ItemEntity> finishCapturingDrops() {
		List<ItemEntity> captured = capturedDrops;
		if (capturedDropsCount > 0)
			capturedDropsCount--;
		if (capturedDropsCount == 0)
			capturedDrops = null;
		return captured;
	}
}
