package com.example.purchase_api.domain;

import com.example.purchase_api.domain.models.PurchaseModel;

import io.reactivex.Single;

public interface PurchaseInteractor {

    Single<PurchaseModel> makePurchase();

}
