package com.example.eugene_matsyuk.dagger_arch.di.antitheft;

import com.example.eugene_matsyuk.dagger_arch.di.general.PerFeature;
import com.example.eugene_matsyuk.dagger_arch.presentation.antitheft.view.AntitheftActivity;

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

    public static void resetComponent() {
        sAntitheftFeatureDependencies = null;
        sAntitheftFeatureComponent = null;
    }

    public abstract void inject(AntitheftActivity antitheftActivity);

    public abstract AntitheftScreenComponent antitheftScreenComponent();

}
