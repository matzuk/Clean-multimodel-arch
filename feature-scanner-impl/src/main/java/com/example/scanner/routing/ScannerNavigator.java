package com.example.scanner.routing;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.scanner.presentation.view.ScannerHelpFragment;
import com.example.scanner.presentation.view.ScannerMainFragment;

import ru.terrakok.cicerone.android.SupportFragmentNavigator;

import static com.example.scanner.routing.ScannerRoutingScreens.SCANNER_HELP;
import static com.example.scanner.routing.ScannerRoutingScreens.SCANNER_MAIN;

public class ScannerNavigator extends SupportFragmentNavigator {

    private final AppCompatActivity mActivityCompat;

    /**
     * Creates SupportFragmentNavigator.
     *
     * @param fragmentManager support fragment manager
     * @param containerId     id of the fragments container layout
     */
    public ScannerNavigator(AppCompatActivity activityCompat, FragmentManager fragmentManager, int containerId) {
        super(fragmentManager, containerId);
        mActivityCompat = activityCompat;
    }

    @Override
    protected Fragment createFragment(String screenKey, Object data) {
        switch (screenKey) {
            case SCANNER_MAIN:
                return new ScannerMainFragment();
            case SCANNER_HELP:
                return new ScannerHelpFragment();
            default:
                return null;
        }
    }

    @Override
    protected void showSystemMessage(String message) {

    }

    @Override
    protected void exit() {
        mActivityCompat.finish();
    }

}
