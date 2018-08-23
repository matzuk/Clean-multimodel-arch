package com.example.eugene_matsyuk.dagger_arch.routing;

import android.content.Context;
import android.content.Intent;

import com.example.antitheft.di.AntitheftFeatureComponent;
import com.example.antitheft.di.AntitheftFeatureDependenciesComponent;
import com.example.antitheft.presentation.view.AntitheftActivity;
import com.example.core.di.app.CoreUtilsComponent;
import com.example.core_db_impl.di.CoreDbComponent;
import com.example.core_network_impl.di.CoreNetworkComponent;
import com.example.purchase_impl.di.DaggerPurchaseFeatureDependenciesComponent;
import com.example.purchase_impl.di.PurchaseComponent;
import com.example.scanner.di.ScannerFeatureComponent;
import com.example.scanner.di.ScannerFeatureDependenciesComponent;
import com.example.scanner.presentation.view.ScannerActivity;

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
        initFeatureComponent(name);
        startFeatureStartPoint(name);
    }

    private void startFeatureStartPoint(String name) {
        Class<?> cls;
        switch (name) {
            case SCANNER_FEATURE:
                cls = ScannerActivity.class;
                break;
            case AV_FEATURE:
                cls = AntitheftActivity.class;
                break;
            default: throw new RuntimeException("Unexpected screen: " + name);
        }
        Intent intent = new Intent(mContext, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

    private void initFeatureComponent(String name) {
        switch (name) {
            case SCANNER_FEATURE:
                initDependenciesForScanner();
                break;
            case AV_FEATURE:
                initDependenciesForAt();
                break;
            default: throw new RuntimeException("Unexpected screen: " + name);
        }
    }

    private void initDependenciesForAt() {
        AntitheftFeatureComponent.init(
            AntitheftFeatureDependenciesComponent.create(
                CoreUtilsComponent.get(),
                CoreNetworkComponent.get(),
                CoreDbComponent.get(),
                createPurchaseComponent()
            )
        );
    }

    private PurchaseComponent createPurchaseComponent() {
        return PurchaseComponent.create(
            DaggerPurchaseFeatureDependenciesComponent.builder()
                .coreNetworkApi(CoreNetworkComponent.get())
                .build()
        );
    }

    private void initDependenciesForScanner() {
        ScannerFeatureComponent.init(
            ScannerFeatureDependenciesComponent.create(
                CoreUtilsComponent.get(),
                CoreNetworkComponent.get(),
                CoreDbComponent.get(),
                createPurchaseComponent()
            )
        );
    }

}
