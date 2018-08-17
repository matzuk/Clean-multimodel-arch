package com.example.eugene_matsyuk.dagger_arch.di.antitheft;

import com.example.eugene_matsyuk.dagger_arch.data.db.DbClient;
import com.example.eugene_matsyuk.dagger_arch.data.network.HttpClient;
import com.example.eugene_matsyuk.dagger_arch.domain.purchase.PurchaseInteractor;

public interface AntitheftFeatureDependencies {

    DbClient dbClient();
    HttpClient httpClient();
    PurchaseInteractor purchaseInteractor();

}
