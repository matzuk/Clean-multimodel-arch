package com.example.antitheft.start;

import android.content.Context;
import android.content.Intent;

import com.example.antitheft.presentation.view.AntitheftActivity;
import com.example.core.di.general.PerFeature;
import com.example.feature_antitheft_api.AntitheftStarter;

import javax.inject.Inject;

@PerFeature
public class AntitheftStarterImpl implements AntitheftStarter {

    @Inject
    public AntitheftStarterImpl() {
    }

    @Override
    public void start(Context context) {
        Class<?> cls = AntitheftActivity.class;
        Intent intent = new Intent(context, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
