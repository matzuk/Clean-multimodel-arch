package com.example.eugene_matsyuk.dagger_arch.presentation.antitheft.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.eugene_matsyuk.dagger_arch.presentation.antitheft.view.AntitheftView;
import com.example.eugene_matsyuk.dagger_arch.presentation.main.view.MainView;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;

import static com.example.eugene_matsyuk.dagger_arch.di.DiConstants.GLOBAL;
import static com.example.eugene_matsyuk.dagger_arch.presentation.main.routing.GlobalScreenNames.AV_SCREEN;
import static com.example.eugene_matsyuk.dagger_arch.presentation.main.routing.GlobalScreenNames.SCANNER_SCREEN;

@InjectViewState
public class AntitheftPresenter extends MvpPresenter<AntitheftView> {

    @Inject
    public AntitheftPresenter() {
    }

    public void clickToAtWork() {

    }

    public void clickToBuyWork() {

    }

}
