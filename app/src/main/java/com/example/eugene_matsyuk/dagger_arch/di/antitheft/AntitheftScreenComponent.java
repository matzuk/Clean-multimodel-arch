package com.example.eugene_matsyuk.dagger_arch.di.antitheft;

import com.example.core.di.general.PerScreen;
import com.example.eugene_matsyuk.dagger_arch.presentation.antitheft.presenter.AntitheftPresenter;

import dagger.Subcomponent;

@Subcomponent
@PerScreen
public interface AntitheftScreenComponent {

    AntitheftPresenter antitheftPresenter();

}
