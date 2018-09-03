package com.example.purchase_impl.di;

import com.example.core.di.general.PerFeature;
import com.example.core_network_api.di.CoreNetworkApi;
import com.example.purchase_api.di.PurchaseFeatureApi;

import java.lang.ref.WeakReference;

import dagger.Component;

@Component(
    dependencies = PurchaseFeatureDependencies.class,
    modules = PurchaseModule.class
)
@PerFeature
public abstract class PurchaseComponent implements PurchaseFeatureApi {

    private static volatile WeakReference<PurchaseComponent> sPurchaseComponentWeak;

    public static PurchaseComponent initAndGet(PurchaseFeatureDependencies purchaseFeatureDependencies) {
        if (sPurchaseComponentWeak == null || sPurchaseComponentWeak.get() == null) {
            synchronized (PurchaseComponent.class) {
                if (sPurchaseComponentWeak == null || sPurchaseComponentWeak.get() == null) {
                    PurchaseComponent purchaseComponent = DaggerPurchaseComponent.builder()
                        .purchaseFeatureDependencies(purchaseFeatureDependencies)
                        .build();
                    sPurchaseComponentWeak = new WeakReference<>(purchaseComponent);
                }
            }
        }
        return sPurchaseComponentWeak.get();
    }

    @Component(dependencies = CoreNetworkApi.class)
    @PerFeature
    interface PurchaseFeatureDependenciesComponent extends PurchaseFeatureDependencies { }

}
