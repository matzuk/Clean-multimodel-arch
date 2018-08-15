package com.example.eugene_matsyuk.dagger_arch.domain.purchase;

import com.example.eugene_matsyuk.dagger_arch.domain.purchase.models.PurchaseModel;

import io.reactivex.Single;

public interface PurchaseRepository {

    Single<PurchaseModel> makePurchaseInStore();

}
