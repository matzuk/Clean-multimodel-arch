package com.example.core.data.network;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class HttpClient {

    @Inject
    public HttpClient() {
    }

    public Single<Object> doAnyRequest() {
        return Single.timer(300, TimeUnit.MILLISECONDS)
            .map(aLong -> new Object());
    }

}
