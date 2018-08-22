package com.example.antitheft.presentation.presenter;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.antitheft.domain.AntitheftInteractor;
import com.example.antitheft.presentation.view.AntitheftView;
import com.example.purchase_api.domain.PurchaseInteractor;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.terrakok.cicerone.Router;

import static com.example.antitheft.routing.AntitheftRoutingScreens.ANTITHEFT_HELP;

@InjectViewState
public class AntitheftPresenter extends MvpPresenter<AntitheftView> {

    private final AntitheftInteractor mAntitheftInteractor;
    private final PurchaseInteractor mPurchaseInteractor;
    private final Router mRouter;

    @Inject
    public AntitheftPresenter(AntitheftInteractor antitheftInteractor,
                              PurchaseInteractor purchaseInteractor,
                              Router router) {
        mAntitheftInteractor = antitheftInteractor;
        mPurchaseInteractor = purchaseInteractor;
        mRouter = router;
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

    public void clickToHelp() {
        mRouter.navigateTo(ANTITHEFT_HELP);
    }

}
