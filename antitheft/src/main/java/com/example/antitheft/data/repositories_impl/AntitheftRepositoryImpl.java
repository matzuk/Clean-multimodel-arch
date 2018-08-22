package com.example.antitheft.data.repositories_impl;

import com.example.antitheft.domain.AntitheftRepository;
import com.example.antitheft.domain.models.AntitheftModel;
import com.example.core.di.general.PerFeature;
import com.example.core_db_api.data.DbClientApi;
import com.example.core_network_api.data.HttpClientApi;

import javax.inject.Inject;

import io.reactivex.Single;

@PerFeature
public class AntitheftRepositoryImpl implements AntitheftRepository {

    private final HttpClientApi mHttpClient;
    private final DbClientApi mDbClient;

    @Inject
    public AntitheftRepositoryImpl(HttpClientApi httpClient, DbClientApi dbClient) {
        mHttpClient = httpClient;
        mDbClient = dbClient;
    }

    @Override
    public Single<AntitheftModel> doAntitheftLowLevelWork() {
        return mHttpClient.doAnyRequest()
            .map(o -> new AntitheftModel());
    }

}
