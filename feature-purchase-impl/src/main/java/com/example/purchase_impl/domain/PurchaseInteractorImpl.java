package com.example.purchase_impl.domain;

import com.example.core.di.general.PerFeature;
import com.example.purchase_api.domain.PurchaseInteractor;
import com.example.purchase_api.domain.models.PurchaseModel;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Single;

@PerFeature
public class PurchaseInteractorImpl implements PurchaseInteractor {

    private final PurchaseRepository mPurchaseRepository;

    @Inject
    public PurchaseInteractorImpl(PurchaseRepository purchaseRepository) {
        mPurchaseRepository = purchaseRepository;
    }

    @Override
    public Single<PurchaseModel> makePurchase() {
        return mPurchaseRepository.makePurchaseInStore()
            .flatMap(this::doSomeLogic);
    }

    private Single<PurchaseModel> doSomeLogic(PurchaseModel purchaseModel) {
        return Single.timer(3000, TimeUnit.MILLISECONDS)
            .map(aLong -> purchaseModel);
    }

}
