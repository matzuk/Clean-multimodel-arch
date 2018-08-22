package com.example.core_network_api.data;

import io.reactivex.Single;

public interface HttpClientApi {

    Single<Object> doAnyRequest();

}
