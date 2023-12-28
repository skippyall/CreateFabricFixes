package io.github.skippyall.createfabricfixes.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import io.github.fabricators_of_create.porting_lib.transfer.TransferUtil;

import net.fabricmc.fabric.api.transfer.v1.storage.StorageView;

import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;

import net.fabricmc.fabric.api.transfer.v1.transaction.TransactionContext;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(TransferUtil.class)
public class TransferUtilMixin {
	@WrapOperation(method = "clearStorage", at = @At(value = "INVOKE", target = "Lnet/fabricmc/fabric/api/transfer/v1/storage/StorageView;extract(Ljava/lang/Object;JLnet/fabricmc/fabric/api/transfer/v1/transaction/TransactionContext;)J"))
	private static long extractOnlyIfNotBlank(StorageView view, Object resource, long amount, TransactionContext t, Operation<Long> operation){
		if(view.isResourceBlank()){
			return 0;
		} else {
			return operation.call(view, resource, amount, t);
		}
	}
}
