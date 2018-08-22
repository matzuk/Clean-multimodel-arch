package com.example.scanner_example;

import android.app.Application;

import com.arellomobile.mvp.RegisterMoxyReflectorPackages;
import com.example.core.di.app.CoreUtilsComponent;
import com.example.scanner.di.ScannerFeatureComponent;
import com.example.scanner_example.di.ScannerFeatureDependenciesFakeComponent;

@RegisterMoxyReflectorPackages({"com.example.scanner"})
public class ScannerExampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // component
        ScannerFeatureComponent.init(
            ScannerFeatureDependenciesFakeComponent.create(
                CoreUtilsComponent.createOnce()
            )
        );
    }

}
