package com.example.adapter;

import android.content.Context;
import android.content.Intent;

import com.example.antitheft.di.AntitheftFeatureComponent;
import com.example.antitheft.di.DaggerAntitheftFeatureComponent_AntitheftFeatureDependenciesComponent;
import com.example.core.di.app.CoreUtilsComponent;
import com.example.core_db_impl.di.CoreDbComponent;
import com.example.core_network_impl.di.CoreNetworkComponent;
import com.example.purchase_api.di.PurchaseFeatureApi;
import com.example.purchase_impl.di.DaggerPurchaseComponent_PurchaseFeatureDependenciesComponent;
import com.example.purchase_impl.di.PurchaseComponent;
import com.example.scanner.di.DaggerScannerFeatureComponent_ScannerFeatureDependenciesComponent;
import com.example.scanner.di.ScannerFeatureComponent;
import com.example.scanner.presentation.view.ScannerActivity;

import java.lang.ref.WeakReference;

public class FeatureProxy {

    public static void featureScannerStart(Context context) {
        ScannerFeatureComponent.init(
            DaggerScannerFeatureComponent_ScannerFeatureDependenciesComponent.builder()
                .coreDbApi(CoreDbComponent.get())
                .coreNetworkApi(CoreNetworkComponent.get())
                .coreUtilsApi(CoreUtilsComponent.get())
                .purchaseFeatureApi(featurePurchaseGet())
                .build()
        );
        //
        Class<?> cls = ScannerActivity.class;
        Intent intent = new Intent(context, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void featureAntitheftStart(Context context) {
        AntitheftFeatureComponent.init(
            DaggerAntitheftFeatureComponent_AntitheftFeatureDependenciesComponent.builder()
                .coreNetworkApi(CoreNetworkComponent.get())
                .coreDbApi(CoreDbComponent.get())
                .coreUtilsApi(CoreUtilsComponent.get())
                .purchaseFeatureApi(featurePurchaseGet())
                .build()
        );
        //
        Class<?> cls = ScannerActivity.class;
        Intent intent = new Intent(context, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    private static PurchaseFeatureApi featurePurchaseGet() {
        return PurchaseComponent.initAndGet(
            DaggerPurchaseComponent_PurchaseFeatureDependenciesComponent.builder()
                .coreNetworkApi(CoreNetworkComponent.get())
                .build()
        );
    }

}
