package com.example.eugene_matsyuk.dagger_arch.data.repositories_impl.scanner;

import com.example.core.data.db.DbClient;
import com.example.core.data.network.HttpClient;
import com.example.core.di.general.PerFeature;
import com.example.core.utils.SomeUtils;
import com.example.eugene_matsyuk.dagger_arch.domain.scanner.ScannerRepository;
import com.example.eugene_matsyuk.dagger_arch.domain.scanner.models.ScannerModel;

import javax.inject.Inject;

import io.reactivex.Single;

@PerFeature
public class ScannerRepositoryImpl implements ScannerRepository {

    private final HttpClient mHttpClient;
    private final DbClient mDbClient;
    private final SomeUtils mSomeUtils;

    @Inject
    public ScannerRepositoryImpl(HttpClient httpClient, DbClient dbClient, SomeUtils someUtils) {
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
