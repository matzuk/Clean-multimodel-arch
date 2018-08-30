package com.example.adapter;

import com.example.core_db_api.di.CoreDbApi;
import com.example.core_db_impl.di.CoreDbComponent;
import com.example.core_network_api.di.CoreNetworkApi;
import com.example.core_network_impl.di.CoreNetworkComponent;

public class CoreProxy {

    public static CoreNetworkApi coreNetworkBuild() {
        return CoreNetworkComponent.get();
    }

    public static CoreDbApi coreDbBuild() {
        return CoreDbComponent.get();
    }

}
