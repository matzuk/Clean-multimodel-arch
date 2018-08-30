package com.example.adapter;

import com.example.core_network_api.di.CoreNetworkApi;
import com.example.core_network_impl.di.CoreNetworkComponent;

public class CoreNetworkProxy {

    public static CoreNetworkApi build() {
        return CoreNetworkComponent.get();
    }

}
