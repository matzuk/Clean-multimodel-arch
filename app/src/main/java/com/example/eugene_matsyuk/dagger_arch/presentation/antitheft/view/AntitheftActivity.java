package com.example.eugene_matsyuk.dagger_arch.presentation.antitheft.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.eugene_matsyuk.dagger_arch.R;

public class AntitheftActivity extends MvpAppCompatActivity implements AntitheftView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antitheft);
    }

    @Override
    public void showAtWork() {

    }

    @Override
    public void showBuyWork() {

    }

    @Override
    public void showSuccessBuy() {

    }

}
