package com.example.adapter;

import com.example.core_network_impl.di.CoreNetworkComponent;
import com.example.purchase_api.di.PurchaseFeatureApi;
import com.example.purchase_impl.di.DaggerPurchaseComponent_PurchaseFeatureDependenciesComponent;
import com.example.purchase_impl.di.PurchaseComponent;

public class FeaturePurchaseProxy {

    public static PurchaseFeatureApi build() {
        return PurchaseComponent.create(
            DaggerPurchaseComponent_PurchaseFeatureDependenciesComponent.builder()
                .coreNetworkApi(CoreNetworkComponent.get())
                .build()
        );
    }

}
