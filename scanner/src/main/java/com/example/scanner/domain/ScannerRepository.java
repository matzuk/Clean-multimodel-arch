package com.example.scanner.domain;

import com.example.scanner.domain.models.ScannerModel;

import io.reactivex.Single;

public interface ScannerRepository {

    Single<ScannerModel> doScannerLowLevelWork();

}
