package com.example.scanner.presentation.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface ScannerMainView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showScannerWork();
    @StateStrategyType(OneExecutionStateStrategy.class)
    void showScannerSuccess();
    @StateStrategyType(OneExecutionStateStrategy.class)
    void showBuyWork();
    @StateStrategyType(OneExecutionStateStrategy.class)
    void showBuySuccess();

}
