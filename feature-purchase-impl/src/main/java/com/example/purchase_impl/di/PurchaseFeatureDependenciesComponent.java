package com.example.purchase_impl.di;


import com.example.core.di.general.PerFeature;
import com.example.core_network_api.di.CoreNetworkApi;

import dagger.Component;

@Component(dependencies = CoreNetworkApi.class)
@PerFeature
public abstract class PurchaseFeatureDependenciesComponent implements PurchaseFeatureDependencies {

    public static PurchaseFeatureDependenciesComponent create(CoreNetworkApi coreNetworkApi) {
        return DaggerPurchaseFeatureDependenciesComponent.builder()
            .coreNetworkApi(coreNetworkApi)
            .build();
    }

}
