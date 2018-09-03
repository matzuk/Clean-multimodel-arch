package com.example.scanner.start;

import android.content.Context;
import android.content.Intent;

import com.example.feature_scanner_api.start.ScannerFeatureApi;
import com.example.scanner.presentation.view.ScannerActivity;

public class ScannerFeatureApiImpl implements ScannerFeatureApi {

    @Override
    public Intent getScannerStartPoint(Context context) {
        Class<?> cls = ScannerActivity.class;
        Intent intent = new Intent(context, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return null;
    }

}
