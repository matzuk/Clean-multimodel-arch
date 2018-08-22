package com.example.antitheft.di;

import com.example.core_db_api.data.DbClientApi;
import com.example.core_network_api.data.HttpClientApi;
import com.example.purchase_api.domain.PurchaseInteractor;

public interface AntitheftFeatureDependencies {

    DbClientApi dbClient();
    HttpClientApi httpClient();
    PurchaseInteractor purchaseInteractor();

}
