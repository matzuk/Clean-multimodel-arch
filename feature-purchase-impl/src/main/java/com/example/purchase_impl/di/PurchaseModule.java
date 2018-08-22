package com.example.purchase_impl.di;

import com.example.core.di.general.PerFeature;
import com.example.purchase_api.domain.PurchaseInteractor;
import com.example.purchase_impl.data.PurchaseRepositoryImpl;
import com.example.purchase_impl.domain.PurchaseInteractorImpl;
import com.example.purchase_impl.domain.PurchaseRepository;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PurchaseModule {

    @PerFeature
    @Binds
    public abstract PurchaseRepository providePurchaseRepository(PurchaseRepositoryImpl purchaseRepository);

    @PerFeature
    @Binds
    public abstract PurchaseInteractor providePurchaseInteractor(PurchaseInteractorImpl purchaseInteractor);

}
