package com.example.eugene_matsyuk.dagger_arch.di.app;


import com.example.eugene_matsyuk.dagger_arch.di.purchase.PurchaseFeatureDependencies;

import dagger.Component;

@Component(dependencies = GlobalAppApi.class)
public abstract class PurchaseFeatureDependenciesComponent implements PurchaseFeatureDependencies {
}
