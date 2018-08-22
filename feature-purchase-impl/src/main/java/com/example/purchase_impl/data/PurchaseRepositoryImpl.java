package com.example.purchase_impl.data;

import com.example.core.di.general.PerFeature;
import com.example.core_network_api.data.HttpClientApi;
import com.example.purchase_api.domain.models.PurchaseModel;
import com.example.purchase_impl.domain.PurchaseRepository;

import javax.inject.Inject;

import io.reactivex.Single;

@PerFeature
public class PurchaseRepositoryImpl implements PurchaseRepository {

    private final HttpClientApi mHttpClient;

    @Inject
    public PurchaseRepositoryImpl(HttpClientApi mHttpClient) {
        this.mHttpClient = mHttpClient;
    }

    @Override
    public Single<PurchaseModel> makePurchaseInStore() {
        return mHttpClient.doAnyRequest()
            .map(o -> new PurchaseModel());
    }

}
