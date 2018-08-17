package com.example.eugene_matsyuk.dagger_arch.presentation.scanner.presenter;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.eugene_matsyuk.dagger_arch.domain.scanner.ScannerInteractor;
import com.example.eugene_matsyuk.dagger_arch.presentation.scanner.view.ScannerView;
import com.example.purchase_api.domain.PurchaseInteractor;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class ScannerPresenter extends MvpPresenter<ScannerView> {

    private final ScannerInteractor mScannerInteractor;
    private final PurchaseInteractor mPurchaseInteractor;

    @Inject
    public ScannerPresenter(ScannerInteractor scannerInteractor, PurchaseInteractor purchaseInteractor) {
        mScannerInteractor = scannerInteractor;
        mPurchaseInteractor = purchaseInteractor;
    }

    @SuppressLint("CheckResult")
    public void clickToAtWork() {
        mScannerInteractor.doScannerWork()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe(disposable -> getViewState().showScannerWork())
            .doOnSuccess(antitheftModel -> getViewState().showScannerSuccess())
            .subscribe(antitheftModel -> {}, throwable -> {});
    }

    @SuppressLint("CheckResult")
    public void clickToBuyWork() {
        mPurchaseInteractor.makePurchase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe(disposable -> getViewState().showBuyWork())
            .doOnSuccess(antitheftModel -> getViewState().showBuySuccess())
            .subscribe(antitheftModel -> {}, throwable -> {});
    }

}
