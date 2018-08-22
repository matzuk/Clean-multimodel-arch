package com.example.antitheft.di;

import com.example.antitheft.presentation.view.AntitheftActivity;
import com.example.core.di.general.PerFeature;

import dagger.Component;

@Component(modules = AntitheftFeatureModule.class, dependencies = AntitheftFeatureDependencies.class)
@PerFeature
public abstract class AntitheftFeatureComponent {

    private static volatile AntitheftFeatureComponent sAntitheftFeatureComponent;

    public static void init(AntitheftFeatureDependencies antitheftFeatureDependencies) {
        sAntitheftFeatureComponent = DaggerAntitheftFeatureComponent.builder()
            .antitheftFeatureDependencies(antitheftFeatureDependencies)
            .build();
    }

    public static AntitheftFeatureComponent get() {
        if (sAntitheftFeatureComponent == null) {
            throw new RuntimeException("You must call 'init(AntitheftFeatureDependencies antitheftFeatureDependencies)' method");
        }
        return sAntitheftFeatureComponent;
    }

    public void resetComponent() {
        sAntitheftFeatureComponent = null;
    }

    public abstract void inject(AntitheftActivity antitheftActivity);

    public abstract AntitheftScreenComponent antitheftScreenComponent();

}
