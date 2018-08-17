package com.example.eugene_matsyuk.dagger_arch.di.antitheft;

import com.example.core.data.db.DbClient;
import com.example.core.data.network.HttpClient;
import com.example.eugene_matsyuk.dagger_arch.domain.purchase.PurchaseInteractor;

public interface AntitheftFeatureDependencies {

    DbClient dbClient();
    HttpClient httpClient();
    PurchaseInteractor purchaseInteractor();

}
