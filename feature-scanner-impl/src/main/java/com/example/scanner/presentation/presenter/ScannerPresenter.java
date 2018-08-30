package com.example.scanner.presentation.presenter;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.purchase_api.domain.PurchaseInteractor;
import com.example.scanner.domain.ScannerInteractor;
import com.example.scanner.presentation.view.ScannerMainView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.terrakok.cicerone.Router;

import static com.example.scanner.routing.ScannerRoutingScreens.SCANNER_HELP;

@InjectViewState
public class ScannerPresenter extends MvpPresenter<ScannerMainView> {

    private final ScannerInteractor mScannerInteractor;
    private final PurchaseInteractor mPurchaseInteractor;
    private final Router mRouter;

    @Inject
    public ScannerPresenter(ScannerInteractor scannerInteractor,
                            PurchaseInteractor purchaseInteractor,
                            Router router) {
        mScannerInteractor = scannerInteractor;
        mPurchaseInteractor = purchaseInteractor;
        mRouter = router;
    }

    @SuppressLint("CheckResult")
    public void clickToScannerWork() {
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

    public void clickToHelp() {
        mRouter.navigateTo(SCANNER_HELP);
    }

}
