package com.example.scanner.di;

import com.example.core.utils.SomeUtils;
import com.example.core_db_api.data.DbClientApi;
import com.example.core_network_api.data.HttpClientApi;
import com.example.purchase_api.domain.PurchaseInteractor;

public interface ScannerFeatureDependencies {

    DbClientApi dbClient();
    HttpClientApi httpClient();
    SomeUtils someUtils();
    PurchaseInteractor purchaseInteractor();

}
