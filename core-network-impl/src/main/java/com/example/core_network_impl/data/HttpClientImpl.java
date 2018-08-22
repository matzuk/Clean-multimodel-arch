package com.example.core_network_impl.data;

import com.example.core_network_api.data.HttpClientApi;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Single;

public class HttpClientImpl implements HttpClientApi {

    @Inject
    public HttpClientImpl() {
    }

    @Override
    public Single<Object> doAnyRequest() {
        return Single.timer(300, TimeUnit.MILLISECONDS)
            .map(aLong -> new Object());
    }

}
