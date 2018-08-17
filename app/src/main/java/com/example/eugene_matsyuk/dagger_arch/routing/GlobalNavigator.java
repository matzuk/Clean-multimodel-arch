package com.example.eugene_matsyuk.dagger_arch.routing;

import android.content.Context;
import android.content.Intent;

import com.example.eugene_matsyuk.dagger_arch.di.antitheft.AntitheftFeatureComponent;
import com.example.eugene_matsyuk.dagger_arch.di.antitheft.AntitheftFeatureDependenciesComponent;
import com.example.eugene_matsyuk.dagger_arch.di.antitheft.DaggerAntitheftFeatureDependenciesComponent;
import com.example.eugene_matsyuk.dagger_arch.di.app.AppComponent;
import com.example.eugene_matsyuk.dagger_arch.di.scanner.DaggerScannerFeatureDependenciesComponent;
import com.example.eugene_matsyuk.dagger_arch.di.scanner.ScannerFeatureComponent;
import com.example.eugene_matsyuk.dagger_arch.di.scanner.ScannerFeatureDependenciesComponent;
import com.example.eugene_matsyuk.dagger_arch.presentation.antitheft.view.AntitheftActivity;
import com.example.eugene_matsyuk.dagger_arch.presentation.scanner.view.ScannerActivity;
import com.example.purchase_impl.di.DaggerPurchaseFeatureDependenciesComponent;
import com.example.purchase_impl.di.PurchaseComponent;
import com.example.purchase_impl.di.PurchaseFeatureDependenciesComponent;

import javax.inject.Inject;
import javax.inject.Singleton;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;

import static com.example.eugene_matsyuk.dagger_arch.routing.GlobalScreenNames.AV_SCREEN;
import static com.example.eugene_matsyuk.dagger_arch.routing.GlobalScreenNames.SCANNER_SCREEN;

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
        Class<?> cls;
        String name = command.getScreenKey();
        switch (name) {
            case SCANNER_SCREEN:
                cls = ScannerActivity.class;
                initDependenciesForScanner();
                break;
            case AV_SCREEN:
                cls = AntitheftActivity.class;
                initDependenciesForAt();
                break;
            default: throw new RuntimeException("Unexpected screen: " + name);
        }

        Intent intent = new Intent(mContext, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

    private void initDependenciesForAt() {
        AntitheftFeatureDependenciesComponent antitheftFeatureDependenciesComponent = DaggerAntitheftFeatureDependenciesComponent.builder()
            .globalAppApi(AppComponent.get())
            .purchaseFeatureApi(createPurchaseComponent())
            .build();
        AntitheftFeatureComponent.setAntitheftFeatureDependencies(antitheftFeatureDependenciesComponent);
    }

    private PurchaseComponent createPurchaseComponent() {
        PurchaseFeatureDependenciesComponent purchaseFeatureDependenciesComponent = DaggerPurchaseFeatureDependenciesComponent.builder()
            .globalAppApi(AppComponent.get())
            .build();
        return PurchaseComponent.create(purchaseFeatureDependenciesComponent);
    }

    private void initDependenciesForScanner() {
        ScannerFeatureDependenciesComponent scannerFeatureDependenciesComponent = DaggerScannerFeatureDependenciesComponent.builder()
            .globalAppApi(AppComponent.get())
            .purchaseFeatureApi(createPurchaseComponent())
            .build();
        ScannerFeatureComponent.setScannerFeatureDependencies(scannerFeatureDependenciesComponent);
    }


}
