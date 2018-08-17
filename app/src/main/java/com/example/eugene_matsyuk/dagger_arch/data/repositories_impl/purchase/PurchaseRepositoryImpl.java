package com.example.eugene_matsyuk.dagger_arch.data.repositories_impl.purchase;

import com.example.core.data.network.HttpClient;
import com.example.core.di.general.PerFeature;
import com.example.eugene_matsyuk.dagger_arch.domain.purchase.PurchaseRepository;
import com.example.eugene_matsyuk.dagger_arch.domain.purchase.models.PurchaseModel;

import javax.inject.Inject;

import io.reactivex.Single;

@PerFeature
public class PurchaseRepositoryImpl implements PurchaseRepository {

    private final HttpClient mHttpClient;

    @Inject
    public PurchaseRepositoryImpl(HttpClient mHttpClient) {
        this.mHttpClient = mHttpClient;
    }

    @Override
    public Single<PurchaseModel> makePurchaseInStore() {
        return mHttpClient.doAnyRequest()
            .map(o -> new PurchaseModel());
    }

}
