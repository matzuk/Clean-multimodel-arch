package com.example.antitheft.domain;


import com.example.antitheft.domain.models.AntitheftModel;

import io.reactivex.Single;

public interface AntitheftInteractor {

    Single<AntitheftModel> doAntitheftWork();

}
