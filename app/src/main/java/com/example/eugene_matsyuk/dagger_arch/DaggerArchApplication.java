package com.example.eugene_matsyuk.dagger_arch;

import android.app.Application;

import com.example.eugene_matsyuk.dagger_arch.di.app.AppComponent;
import com.example.eugene_matsyuk.dagger_arch.di.app.AppModule;
import com.example.eugene_matsyuk.dagger_arch.di.app.DaggerAppComponent;
import com.example.eugene_matsyuk.dagger_arch.presentation.main.routing.GlobalNavigator;

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
    }

}
