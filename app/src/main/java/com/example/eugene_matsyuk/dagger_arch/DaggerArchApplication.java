package com.example.eugene_matsyuk.dagger_arch;

import android.app.Application;

import com.example.eugene_matsyuk.dagger_arch.di.app.AppComponent;
import com.example.eugene_matsyuk.dagger_arch.di.app.DaggerAppComponent;
import com.example.eugene_matsyuk.dagger_arch.di.purchase.DaggerPurchaseFeatureDependenciesComponent;
import com.example.eugene_matsyuk.dagger_arch.di.purchase.PurchaseComponent;
import com.example.eugene_matsyuk.dagger_arch.di.purchase.PurchaseFeatureDependenciesComponent;
import com.example.eugene_matsyuk.dagger_arch.routing.GlobalNavigator;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.NavigatorHolder;

import static com.example.eugene_matsyuk.dagger_arch.di.DiConstants.GLOBAL;

public class DaggerArchApplication extends Application {

    @Inject
    @Named(GLOBAL)
    NavigatorHolder mNavigatorHolder;

    @Inject
    GlobalNavigator mGlobalNavigator;

    @Override
    public void onCreate() {
        super.onCreate();
        AppComponent.init(DaggerAppComponent.builder()
            .context(getApplicationContext())
            .build());
        AppComponent.get().inject(this);
        mNavigatorHolder.setNavigator(mGlobalNavigator);

        // some experiments
        PurchaseFeatureDependenciesComponent purchaseFeatureDependenciesComponent = DaggerPurchaseFeatureDependenciesComponent.builder()
            .globalAppApi(AppComponent.get())
            .build();
        PurchaseComponent purchaseComponent = PurchaseComponent.create(purchaseFeatureDependenciesComponent);
    }

}
