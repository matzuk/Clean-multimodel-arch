package com.example.purchase_impl.domain;

import com.example.purchase_api.domain.models.PurchaseModel;

import io.reactivex.Single;

public interface PurchaseRepository {

    Single<PurchaseModel> makePurchaseInStore();

}
