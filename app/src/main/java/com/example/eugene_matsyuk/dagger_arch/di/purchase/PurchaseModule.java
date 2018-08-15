package com.example.eugene_matsyuk.dagger_arch.di.purchase;

import com.example.eugene_matsyuk.dagger_arch.data.repositories_impl.purchase.PurchaseRepositoryImpl;
import com.example.eugene_matsyuk.dagger_arch.di.general.PerFeature;
import com.example.eugene_matsyuk.dagger_arch.domain.purchase.PurchaseInteractor;
import com.example.eugene_matsyuk.dagger_arch.domain.purchase.PurchaseInteractorImpl;
import com.example.eugene_matsyuk.dagger_arch.domain.purchase.PurchaseRepository;

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
