package com.example.eugene_matsyuk.dagger_arch.di.purchase;


import com.example.core.di.app.GlobalAppApi;

import dagger.Component;

@Component(dependencies = GlobalAppApi.class)
public abstract class PurchaseFeatureDependenciesComponent implements PurchaseFeatureDependencies {
}
