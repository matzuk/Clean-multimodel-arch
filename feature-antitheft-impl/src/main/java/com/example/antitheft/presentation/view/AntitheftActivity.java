package com.example.antitheft.presentation.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.antitheft.R;
import com.example.antitheft.di.AntitheftFeatureComponent;
import com.example.antitheft.routing.AntitheftNavigator;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

import static com.example.antitheft.routing.AntitheftRoutingScreens.ANTITHEFT_MAIN;

public class AntitheftActivity extends AppCompatActivity {

    @Inject
    NavigatorHolder mNavigatorHolder;
    @Inject
    Router mRouter;

    private Navigator mNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AntitheftFeatureComponent.get().inject(this);
        mNavigator = new AntitheftNavigator(this, getSupportFragmentManager(), R.id.details);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antitheft);
        if (savedInstanceState == null) {
            mRouter.navigateTo(ANTITHEFT_MAIN);
        }
    }

    /**
     * Attention: Use onResumeFragments() with FragmentActivity (more info)
     * https://github.com/terrakok/Cicerone/issues/31
     */
    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        mNavigatorHolder.setNavigator(mNavigator);
    }

    @Override
    public void onPause() {
        mNavigatorHolder.removeNavigator();
        if (isFinishing()) {
            AntitheftFeatureComponent.get().resetComponent();
        }
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() <= 1) {
            finish();
            return;
        }
        mRouter.exit();
    }

}
