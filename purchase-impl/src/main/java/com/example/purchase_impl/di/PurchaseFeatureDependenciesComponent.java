package com.example.purchase_impl.di;


import com.example.core.di.app.GlobalAppApi;

import dagger.Component;

@Component(dependencies = GlobalAppApi.class)
public abstract class PurchaseFeatureDependenciesComponent implements PurchaseFeatureDependencies {
}
