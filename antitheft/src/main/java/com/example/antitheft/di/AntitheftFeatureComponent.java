package com.example.antitheft.di;

import com.example.antitheft.presentation.view.AntitheftActivity;
import com.example.core.di.general.PerFeature;

import dagger.Component;

@Component(modules = AntitheftFeatureModule.class, dependencies = AntitheftFeatureDependencies.class)
@PerFeature
public abstract class AntitheftFeatureComponent {

    private static volatile AntitheftFeatureDependencies sAntitheftFeatureDependencies;
    private static volatile AntitheftFeatureComponent sAntitheftFeatureComponent;

    public static void setAntitheftFeatureDependencies(AntitheftFeatureDependencies antitheftFeatureDependencies) {
        sAntitheftFeatureDependencies = antitheftFeatureDependencies;
    }

    public static AntitheftFeatureComponent get() {
        if (sAntitheftFeatureDependencies == null) {
            throw new RuntimeException("You must call setAntitheftFeatureDependencies(...) first before get() calling");
        }
        if (sAntitheftFeatureComponent == null) {
            synchronized (AntitheftFeatureComponent.class) {
                if (sAntitheftFeatureComponent == null) {
                    sAntitheftFeatureComponent = createComponent(sAntitheftFeatureDependencies);
                }
            }
        }
        return sAntitheftFeatureComponent;
    }

    private static AntitheftFeatureComponent createComponent(AntitheftFeatureDependencies antitheftFeatureDependencies) {
        return DaggerAntitheftFeatureComponent.builder()
            .antitheftFeatureDependencies(antitheftFeatureDependencies)
            .build();

    }

    public void resetComponent() {
        sAntitheftFeatureDependencies = null;
        sAntitheftFeatureComponent = null;
    }

    public abstract void inject(AntitheftActivity antitheftActivity);

    public abstract AntitheftScreenComponent antitheftScreenComponent();

}
