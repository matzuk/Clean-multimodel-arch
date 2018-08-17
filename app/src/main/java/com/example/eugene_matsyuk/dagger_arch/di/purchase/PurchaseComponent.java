package com.example.eugene_matsyuk.dagger_arch.di.purchase;

import com.example.core.di.general.PerFeature;

import dagger.Component;

@Component(
    dependencies = PurchaseFeatureDependencies.class,
    modules = PurchaseModule.class
)
@PerFeature
public abstract class PurchaseComponent implements PurchaseFeatureApi {

    public static PurchaseComponent create(PurchaseFeatureDependencies purchaseFeatureDependencies) {
        return DaggerPurchaseComponent.builder()
            .purchaseFeatureDependencies(purchaseFeatureDependencies)
            .build();
    }

}
