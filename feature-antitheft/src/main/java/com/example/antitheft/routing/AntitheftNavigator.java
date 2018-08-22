package com.example.antitheft.routing;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.antitheft.presentation.view.AntitheftHelpFragment;
import com.example.antitheft.presentation.view.AntitheftMainFragment;

import ru.terrakok.cicerone.android.SupportFragmentNavigator;

import static com.example.antitheft.routing.AntitheftRoutingScreens.ANTITHEFT_HELP;
import static com.example.antitheft.routing.AntitheftRoutingScreens.ANTITHEFT_MAIN;

public class AntitheftNavigator extends SupportFragmentNavigator {

    private final AppCompatActivity mActivityCompat;

    /**
     * Creates SupportFragmentNavigator.
     *
     * @param fragmentManager support fragment manager
     * @param containerId     id of the fragments container layout
     */
    public AntitheftNavigator(AppCompatActivity activityCompat, FragmentManager fragmentManager, int containerId) {
        super(fragmentManager, containerId);
        mActivityCompat = activityCompat;
    }

    @Override
    protected Fragment createFragment(String screenKey, Object data) {
        switch (screenKey) {
            case ANTITHEFT_MAIN:
                return new AntitheftMainFragment();
            case ANTITHEFT_HELP:
                return new AntitheftHelpFragment();
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
