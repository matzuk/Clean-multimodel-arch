package com.example.scanner.data;

import com.example.core.di.general.PerFeature;
import com.example.core.utils.SomeUtils;
import com.example.core_db_api.data.DbClientApi;
import com.example.core_network_api.data.HttpClientApi;
import com.example.scanner.domain.ScannerRepository;
import com.example.scanner.domain.models.ScannerModel;

import javax.inject.Inject;

import io.reactivex.Single;

@PerFeature
public class ScannerRepositoryImpl implements ScannerRepository {

    private final HttpClientApi mHttpClient;
    private final DbClientApi mDbClient;
    private final SomeUtils mSomeUtils;

    @Inject
    public ScannerRepositoryImpl(HttpClientApi httpClient, DbClientApi dbClient, SomeUtils someUtils) {
        mHttpClient = httpClient;
        mDbClient = dbClient;
        mSomeUtils = someUtils;
    }

    @Override
    public Single<ScannerModel> doScannerLowLevelWork() {
        return mHttpClient.doAnyRequest()
            .map(o -> new ScannerModel());
    }
}
