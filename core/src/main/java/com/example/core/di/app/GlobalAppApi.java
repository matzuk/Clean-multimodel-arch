package com.example.core.di.app;

import com.example.core.data.db.DbClient;
import com.example.core.data.network.HttpClient;
import com.example.core.utils.SomeUtils;

public interface GlobalAppApi {

    HttpClient httpClient();
    DbClient dbClient();
    SomeUtils someUtils();

}
