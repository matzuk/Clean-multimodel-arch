package com.example.eugene_matsyuk.dagger_arch;

import android.app.Application;
import android.content.Context;

import com.arellomobile.mvp.RegisterMoxyReflectorPackages;
import com.example.eugene_matsyuk.dagger_arch.di.app.AppComponent;
import com.example.eugene_matsyuk.dagger_arch.di.app.DaggerAppComponent;
import com.example.eugene_matsyuk.dagger_arch.routing.GlobalNavigator;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.NavigatorHolder;

import static com.example.eugene_matsyuk.dagger_arch.di.DiConstants.GLOBAL;

@RegisterMoxyReflectorPackages({"com.example.scanner", "com.example.antitheft"})
public class DaggerArchApplication extends Application {

    private static volatile Context sContext;

    @Inject
    @Named(GLOBAL)
    NavigatorHolder mNavigatorHolder;

    @Inject
    GlobalNavigator mGlobalNavigator;

    public static Context getAppContext() {
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        AppComponent.init(
            DaggerAppComponent.builder()
                .build()
        );
        AppComponent.get().inject(this);
        mNavigatorHolder.setNavigator(mGlobalNavigator);
    }

}
