package com.example.eugene_matsyuk.dagger_arch.di.app;

import com.example.eugene_matsyuk.dagger_arch.di.general.PerScreen;
import com.example.eugene_matsyuk.dagger_arch.presentation.main.presenter.MainPresenter;

import dagger.Subcomponent;

@Subcomponent
@PerScreen
public interface MainScreenComponent {

    MainPresenter mainPresenter();

}
