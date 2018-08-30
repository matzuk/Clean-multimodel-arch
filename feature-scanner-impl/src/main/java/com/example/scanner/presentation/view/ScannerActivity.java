package com.example.scanner.presentation.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.scanner.R;
import com.example.scanner.di.ScannerFeatureComponent;
import com.example.scanner.routing.ScannerNavigator;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

import static com.example.scanner.routing.ScannerRoutingScreens.SCANNER_MAIN;

public class ScannerActivity extends AppCompatActivity {

    @Inject
    NavigatorHolder mNavigatorHolder;
    @Inject
    Router mRouter;

    private Navigator mNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ScannerFeatureComponent.get().inject(this);
        mNavigator = new ScannerNavigator(this, getSupportFragmentManager(), R.id.details);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        if (savedInstanceState == null) {
            mRouter.navigateTo(SCANNER_MAIN);
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
            ScannerFeatureComponent.get().resetComponent();
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
