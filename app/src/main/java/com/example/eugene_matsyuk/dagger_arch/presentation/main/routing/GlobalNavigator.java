package com.example.eugene_matsyuk.dagger_arch.presentation.main.routing;

import android.content.Context;
import android.content.Intent;

import com.example.eugene_matsyuk.dagger_arch.presentation.antitheft.view.AntitheftActivity;
import com.example.eugene_matsyuk.dagger_arch.presentation.scanner.view.ScannerActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;

import static com.example.eugene_matsyuk.dagger_arch.presentation.main.routing.GlobalScreenNames.AV_SCREEN;
import static com.example.eugene_matsyuk.dagger_arch.presentation.main.routing.GlobalScreenNames.SCANNER_SCREEN;

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
                break;
            case AV_SCREEN:
                cls = AntitheftActivity.class;
                break;
            default: throw new RuntimeException("Unexpected screen: " + name);
        }

        Intent intent = new Intent(mContext, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }


}
