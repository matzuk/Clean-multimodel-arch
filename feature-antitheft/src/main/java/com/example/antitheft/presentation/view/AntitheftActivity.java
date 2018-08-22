package com.example.antitheft.presentation.view;

import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.antitheft.R;
import com.example.antitheft.di.AntitheftFeatureComponent;
import com.example.antitheft.presentation.presenter.AntitheftPresenter;

public class AntitheftActivity extends MvpAppCompatActivity implements AntitheftView {

    @InjectPresenter
    AntitheftPresenter mAntitheftPresenter;

    @ProvidePresenter
    AntitheftPresenter provideAntitheftPresenter() {
        return AntitheftFeatureComponent.get()
            .antitheftScreenComponent()
            .antitheftPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antitheft);
        findViewById(R.id.button_purchase).setOnClickListener(v -> mAntitheftPresenter.clickToBuyWork());
        findViewById(R.id.button_at).setOnClickListener(v -> mAntitheftPresenter.clickToAtWork());
    }

    @Override
    public void showAtWork() {
        Toast.makeText(this, R.string.antitheft_screen_do_atjob_name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAtSuccess() {
        Toast.makeText(this, R.string.antitheft_screen_do_atjob_completed_name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showBuyWork() {
        Toast.makeText(this, R.string.purchase_buy_job_doing, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showBuySuccess() {
        Toast.makeText(this, R.string.purchase_buy_job_completed, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        if (isFinishing()) {
            AntitheftFeatureComponent.get().resetComponent();
        }
        super.onPause();
    }

}
