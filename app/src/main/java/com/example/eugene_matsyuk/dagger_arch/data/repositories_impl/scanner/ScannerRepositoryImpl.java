package com.example.eugene_matsyuk.dagger_arch.data.repositories_impl.scanner;

import com.example.eugene_matsyuk.dagger_arch.data.db.DbClient;
import com.example.eugene_matsyuk.dagger_arch.data.network.HttpClient;
import com.example.eugene_matsyuk.dagger_arch.di.general.PerFeature;
import com.example.eugene_matsyuk.dagger_arch.domain.antitheft.AntitheftRepository;
import com.example.eugene_matsyuk.dagger_arch.domain.antitheft.models.AntitheftModel;

import javax.inject.Inject;

import io.reactivex.Single;

@PerFeature
public class ScannerRepositoryImpl implements AntitheftRepository {

    private final HttpClient mHttpClient;
    private final DbClient mDbClient;

    @Inject
    public ScannerRepositoryImpl(HttpClient httpClient, DbClient dbClient) {
        mHttpClient = httpClient;
        mDbClient = dbClient;
    }

    @Override
    public Single<AntitheftModel> doAntitheftLowLevelWork() {
        return mHttpClient.doAnyRequest()
            .map(o -> new AntitheftModel());
    }

}
