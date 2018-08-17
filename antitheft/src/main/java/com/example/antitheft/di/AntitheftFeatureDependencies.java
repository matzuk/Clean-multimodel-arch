package com.example.antitheft.di;

import com.example.core.data.db.DbClient;
import com.example.core.data.network.HttpClient;
import com.example.purchase_api.domain.PurchaseInteractor;

public interface AntitheftFeatureDependencies {

    DbClient dbClient();
    HttpClient httpClient();
    PurchaseInteractor purchaseInteractor();

}
