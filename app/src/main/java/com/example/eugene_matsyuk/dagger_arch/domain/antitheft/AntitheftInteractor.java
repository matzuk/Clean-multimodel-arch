package com.example.eugene_matsyuk.dagger_arch.domain.antitheft;

import com.example.eugene_matsyuk.dagger_arch.domain.antitheft.models.AntitheftModel;

import io.reactivex.Single;

public interface AntitheftInteractor {

    Single<AntitheftModel> doAntitheftWork();

}
