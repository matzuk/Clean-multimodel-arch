package com.example.eugene_matsyuk.dagger_arch.domain.purchase;

import com.example.eugene_matsyuk.dagger_arch.di.general.PerFeature;
import com.example.eugene_matsyuk.dagger_arch.domain.purchase.models.PurchaseModel;

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
        return Single.timer(300, TimeUnit.MILLISECONDS)
            .map(aLong -> purchaseModel);
    }

}
