package com.example.scanner_example.fake;

import com.example.core_network_api.data.HttpClientApi;

import javax.inject.Inject;

import io.reactivex.Single;

public class HttpClientFake implements HttpClientApi {

    @Inject
    public HttpClientFake() {
    }

    @Override
    public Single<Object> doAnyRequest() {
        return Single.just(new Object());
    }

}
