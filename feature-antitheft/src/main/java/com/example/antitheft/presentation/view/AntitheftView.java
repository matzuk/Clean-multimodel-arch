package com.example.antitheft.presentation.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface AntitheftView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showAtWork();
    @StateStrategyType(OneExecutionStateStrategy.class)
    void showAtSuccess();
    @StateStrategyType(OneExecutionStateStrategy.class)
    void showBuyWork();
    @StateStrategyType(OneExecutionStateStrategy.class)
    void showBuySuccess();

}
