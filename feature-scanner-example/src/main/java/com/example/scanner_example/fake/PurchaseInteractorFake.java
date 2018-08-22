package com.example.scanner_example.fake;

import com.example.purchase_api.domain.PurchaseInteractor;
import com.example.purchase_api.domain.models.PurchaseModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;

public class PurchaseInteractorFake implements PurchaseInteractor {

    @Override
    public Single<PurchaseModel> makePurchase() {
        return Single.timer(100, TimeUnit.MILLISECONDS)
            .map(aLong -> new PurchaseModel());
    }

}
