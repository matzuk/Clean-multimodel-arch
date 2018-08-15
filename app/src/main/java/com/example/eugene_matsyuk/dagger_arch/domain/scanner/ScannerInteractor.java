package com.example.eugene_matsyuk.dagger_arch.domain.scanner;

import com.example.eugene_matsyuk.dagger_arch.domain.scanner.models.ScannerModel;

import io.reactivex.Single;

public interface ScannerInteractor {

    Single<ScannerModel> doScannerWork();

}
