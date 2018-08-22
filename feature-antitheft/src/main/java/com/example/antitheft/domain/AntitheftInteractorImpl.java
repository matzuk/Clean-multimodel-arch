package com.example.antitheft.domain;

import com.example.antitheft.domain.models.AntitheftModel;
import com.example.core.di.general.PerFeature;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Single;

@PerFeature
public class AntitheftInteractorImpl implements AntitheftInteractor {

    private final AntitheftRepository mAntitheftRepository;

    @Inject
    public AntitheftInteractorImpl(AntitheftRepository antitheftRepository) {
        mAntitheftRepository = antitheftRepository;
    }

    @Override
    public Single<AntitheftModel> doAntitheftWork() {
        return mAntitheftRepository.doAntitheftLowLevelWork()
            .flatMap(this::doSomeLogic);
    }

    private Single<AntitheftModel> doSomeLogic(AntitheftModel antitheftModel) {
        return Single.timer(3000, TimeUnit.MILLISECONDS)
            .map(aLong -> antitheftModel);
    }

}
