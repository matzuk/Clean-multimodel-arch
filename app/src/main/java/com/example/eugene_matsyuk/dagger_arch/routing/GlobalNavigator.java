package com.example.eugene_matsyuk.dagger_arch.routing;

import android.content.Context;

import com.example.adapter.FeatureProxy;

import javax.inject.Inject;
import javax.inject.Singleton;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;

import static com.example.eugene_matsyuk.dagger_arch.routing.GlobalScreenNames.AV_FEATURE;
import static com.example.eugene_matsyuk.dagger_arch.routing.GlobalScreenNames.SCANNER_FEATURE;

@Singleton
public class GlobalNavigator implements Navigator {

    private final Context mContext;

    @Inject
    public GlobalNavigator(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void applyCommands(Command[] commands) {
        for (Command command : commands) {
            applyCommand(command);
        }
    }

    private void applyCommand(Command command) {
        if (command instanceof Forward) {
            forward((Forward) command);
            return;
        }
        throw new RuntimeException("Unexpected action");
    }

    private void forward(Forward command) {
        String name = command.getScreenKey();
        startFeatureStartPoint(name);
    }

    private void startFeatureStartPoint(String name) {
        switch (name) {
            case SCANNER_FEATURE:
                FeatureProxy.featureScannerStart(mContext);
                return;
            case AV_FEATURE:
                FeatureProxy.featureAntitheftStart(mContext);
                return;
            default: throw new RuntimeException("Unexpected screen: " + name);
        }
    }

}
