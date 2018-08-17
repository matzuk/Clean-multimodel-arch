package com.example.antitheft.data.repositories_impl;

import com.example.antitheft.domain.AntitheftRepository;
import com.example.antitheft.domain.models.AntitheftModel;
import com.example.core.data.db.DbClient;
import com.example.core.data.network.HttpClient;
import com.example.core.di.general.PerFeature;

import javax.inject.Inject;

import io.reactivex.Single;

@PerFeature
public class AntitheftRepositoryImpl implements AntitheftRepository {

    private final HttpClient mHttpClient;
    private final DbClient mDbClient;

    @Inject
    public AntitheftRepositoryImpl(HttpClient httpClient, DbClient dbClient) {
        mHttpClient = httpClient;
        mDbClient = dbClient;
    }

    @Override
    public Single<AntitheftModel> doAntitheftLowLevelWork() {
        return mHttpClient.doAnyRequest()
            .map(o -> new AntitheftModel());
    }

}
