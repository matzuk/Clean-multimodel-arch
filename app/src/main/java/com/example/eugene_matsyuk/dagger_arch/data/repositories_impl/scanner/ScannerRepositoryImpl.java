package com.example.eugene_matsyuk.dagger_arch.data.repositories_impl.scanner;

import com.example.eugene_matsyuk.dagger_arch.data.db.DbClient;
import com.example.eugene_matsyuk.dagger_arch.data.network.HttpClient;
import com.example.eugene_matsyuk.dagger_arch.di.general.PerFeature;
import com.example.eugene_matsyuk.dagger_arch.domain.scanner.ScannerRepository;
import com.example.eugene_matsyuk.dagger_arch.domain.scanner.models.ScannerModel;
import com.example.eugene_matsyuk.dagger_arch.utils.SomeUtils;

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
