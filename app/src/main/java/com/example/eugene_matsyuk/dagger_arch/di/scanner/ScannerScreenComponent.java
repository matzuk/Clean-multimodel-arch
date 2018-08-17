package com.example.eugene_matsyuk.dagger_arch.di.scanner;

import com.example.eugene_matsyuk.dagger_arch.di.general.PerScreen;
import com.example.eugene_matsyuk.dagger_arch.presentation.scanner.presenter.ScannerPresenter;

import dagger.Subcomponent;

@Subcomponent
@PerScreen
public interface ScannerScreenComponent {

    ScannerPresenter scannerPresenter();

}
