package com.example.eugene_matsyuk.dagger_arch.di.scanner;

import com.example.eugene_matsyuk.dagger_arch.data.db.DbClient;
import com.example.eugene_matsyuk.dagger_arch.data.network.HttpClient;
import com.example.eugene_matsyuk.dagger_arch.domain.purchase.PurchaseInteractor;
import com.example.eugene_matsyuk.dagger_arch.utils.SomeUtils;

public interface ScannerFeatureDependencies {

    DbClient dbClient();
    HttpClient httpClient();
    SomeUtils someUtils();
    PurchaseInteractor purchaseInteractor();

}
