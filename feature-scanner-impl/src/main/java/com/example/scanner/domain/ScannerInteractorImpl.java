package com.example.scanner.domain;

import com.example.core.di.general.PerFeature;
import com.example.scanner.domain.models.ScannerModel;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Single;

@PerFeature
public class ScannerInteractorImpl implements ScannerInteractor {

    private final ScannerRepository mScannerRepository;

    @Inject
    public ScannerInteractorImpl(ScannerRepository scannerRepository) {
        mScannerRepository = scannerRepository;
    }

    @Override
    public Single<ScannerModel> doScannerWork() {
        return mScannerRepository.doScannerLowLevelWork()
            .flatMap(this::doSomeLogic);
    }

    private Single<ScannerModel> doSomeLogic(ScannerModel scannerModel) {
        return Single.timer(3000, TimeUnit.MILLISECONDS)
            .map(aLong -> scannerModel);
    }

}
