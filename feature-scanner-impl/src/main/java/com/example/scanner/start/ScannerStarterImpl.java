package com.example.scanner.start;

import android.content.Context;
import android.content.Intent;

import com.example.core.di.general.PerFeature;
import com.example.feature_scanner_api.ScannerStarter;
import com.example.scanner.presentation.view.ScannerActivity;

import javax.inject.Inject;

@PerFeature
public class ScannerStarterImpl implements ScannerStarter {

    @Inject
    public ScannerStarterImpl() {
    }

    @Override
    public void start(Context context) {
        Class<?> cls = ScannerActivity.class;
        Intent intent = new Intent(context, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
