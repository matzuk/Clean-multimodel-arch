package com.example.scanner.presentation.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.scanner.R;
import com.example.scanner.di.ScannerFeatureComponent;
import com.example.scanner.presentation.presenter.ScannerPresenter;

public class ScannerMainFragment extends MvpAppCompatFragment implements ScannerMainView {

    @InjectPresenter
    ScannerPresenter mScannerPresenter;

    @ProvidePresenter
    ScannerPresenter provideScannerPresenter() {
        return ScannerFeatureComponent.get()
            .scannerScreenComponent()
            .scannerPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_scanner, null);
        view.findViewById(R.id.button_purchase).setOnClickListener(v -> mScannerPresenter.clickToBuyWork());
        view.findViewById(R.id.button_scanner).setOnClickListener(v -> mScannerPresenter.clickToScannerWork());
        view.findViewById(R.id.button_help).setOnClickListener(v -> mScannerPresenter.clickToHelp());
        return view;
    }

    @Override
    public void showScannerWork() {
        Toast.makeText(getContext(), R.string.scanner_screen_do_scanner_name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showScannerSuccess() {
        Toast.makeText(getContext(), R.string.scanner_screen_do_scanner_completed_name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showBuyWork() {
        Toast.makeText(getContext(), R.string.purchase_buy_job_doing, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showBuySuccess() {
        Toast.makeText(getContext(), R.string.purchase_buy_job_completed, Toast.LENGTH_SHORT).show();
    }

}
