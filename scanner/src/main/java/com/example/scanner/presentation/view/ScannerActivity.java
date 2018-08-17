package com.example.scanner.presentation.view;

import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.scanner.R;
import com.example.scanner.di.ScannerFeatureComponent;
import com.example.scanner.presentation.presenter.ScannerPresenter;

public class ScannerActivity extends MvpAppCompatActivity implements ScannerView {

    @InjectPresenter
    ScannerPresenter mScannerPresenter;

    @ProvidePresenter
    ScannerPresenter provideScannerPresenter() {
        return ScannerFeatureComponent.get()
            .scannerScreenComponent()
            .scannerPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        findViewById(R.id.button_purchase).setOnClickListener(v -> mScannerPresenter.clickToBuyWork());
        findViewById(R.id.button_scanner).setOnClickListener(v -> mScannerPresenter.clickToAtWork());
    }

    @Override
    public void showScannerWork() {
        Toast.makeText(this, R.string.scanner_screen_do_scanner_name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showScannerSuccess() {
        Toast.makeText(this, R.string.scanner_screen_do_scanner_completed_name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showBuyWork() {
        Toast.makeText(this, R.string.purchase_buy_job_doing, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showBuySuccess() {
        Toast.makeText(this, R.string.purchase_buy_job_completed, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        if (isFinishing()) {
            ScannerFeatureComponent.get().resetComponent();
        }
        super.onPause();
    }

}
