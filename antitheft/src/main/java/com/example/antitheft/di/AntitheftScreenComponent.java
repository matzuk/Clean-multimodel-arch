package com.example.antitheft.di;

import com.example.antitheft.presentation.presenter.AntitheftPresenter;
import com.example.core.di.general.PerScreen;

import dagger.Subcomponent;

@Subcomponent
@PerScreen
public interface AntitheftScreenComponent {

    AntitheftPresenter antitheftPresenter();

}
