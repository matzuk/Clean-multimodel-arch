package com.example.eugene_matsyuk.dagger_arch.di.scanner;

import com.example.eugene_matsyuk.dagger_arch.di.app.GlobalAppApi;
import com.example.eugene_matsyuk.dagger_arch.di.purchase.PurchaseFeatureApi;

import dagger.Component;

@Component(dependencies = {
    GlobalAppApi.class,
    PurchaseFeatureApi.class
})
public abstract class ScannerFeatureDependenciesComponent implements ScannerFeatureDependencies {
}
