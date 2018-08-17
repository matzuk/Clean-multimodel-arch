package com.example.antitheft.di;

import com.example.core.di.app.GlobalAppApi;
import com.example.core.di.general.PerFeature;
import com.example.purchase_api.di.PurchaseFeatureApi;

import dagger.Component;

@Component(dependencies = {
    GlobalAppApi.class,
    PurchaseFeatureApi.class
})
@PerFeature
public abstract class AntitheftFeatureDependenciesComponent implements AntitheftFeatureDependencies {

    public static AntitheftFeatureDependenciesComponent create(GlobalAppApi globalAppApi, PurchaseFeatureApi purchaseFeatureApi) {
        return DaggerAntitheftFeatureDependenciesComponent.builder()
            .globalAppApi(globalAppApi)
            .purchaseFeatureApi(purchaseFeatureApi)
            .build();
    }

}
