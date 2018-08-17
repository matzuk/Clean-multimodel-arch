package com.example.eugene_matsyuk.dagger_arch.presentation.antitheft.presenter;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.eugene_matsyuk.dagger_arch.domain.antitheft.AntitheftInteractor;
import com.example.eugene_matsyuk.dagger_arch.domain.purchase.PurchaseInteractor;
import com.example.eugene_matsyuk.dagger_arch.presentation.antitheft.view.AntitheftView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class AntitheftPresenter extends MvpPresenter<AntitheftView> {

    private final AntitheftInteractor mAntitheftInteractor;
    private final PurchaseInteractor mPurchaseInteractor;

    @Inject
    public AntitheftPresenter(AntitheftInteractor antitheftInteractor, PurchaseInteractor purchaseInteractor) {
        mAntitheftInteractor = antitheftInteractor;
        mPurchaseInteractor = purchaseInteractor;
    }

    @SuppressLint("CheckResult")
    public void clickToAtWork() {
        mAntitheftInteractor.doAntitheftWork()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe(disposable -> getViewState().showAtWork())
            .doOnSuccess(antitheftModel -> getViewState().showAtSuccess())
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
