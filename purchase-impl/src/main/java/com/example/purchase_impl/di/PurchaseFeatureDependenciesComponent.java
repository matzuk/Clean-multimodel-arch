package com.example.purchase_impl.di;


import com.example.core.di.app.GlobalAppApi;
import com.example.core.di.general.PerFeature;

import dagger.Component;

@Component(dependencies = GlobalAppApi.class)
@PerFeature
public abstract class PurchaseFeatureDependenciesComponent implements PurchaseFeatureDependencies {

    public static PurchaseFeatureDependenciesComponent create(GlobalAppApi globalAppApi) {
        return DaggerPurchaseFeatureDependenciesComponent.builder()
            .globalAppApi(globalAppApi)
            .build();
    }

}
