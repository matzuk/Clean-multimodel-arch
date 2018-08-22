package com.example.antitheft.presentation.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.antitheft.R;
import com.example.antitheft.di.AntitheftFeatureComponent;
import com.example.antitheft.presentation.presenter.AntitheftPresenter;

public class AntitheftMainFragment extends MvpAppCompatFragment implements AntitheftView {

    @InjectPresenter
    AntitheftPresenter mAntitheftPresenter;

    @ProvidePresenter
    AntitheftPresenter provideAntitheftPresenter() {
        return AntitheftFeatureComponent.get()
            .antitheftScreenComponent()
            .antitheftPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_antitheft, null);
        view.findViewById(R.id.button_purchase).setOnClickListener(v -> mAntitheftPresenter.clickToBuyWork());
        view.findViewById(R.id.button_at).setOnClickListener(v -> mAntitheftPresenter.clickToAtWork());
        view.findViewById(R.id.button_help).setOnClickListener(v -> mAntitheftPresenter.clickToHelp());
        return view;
    }

    @Override
    public void showAtWork() {
        Toast.makeText(getContext(), R.string.antitheft_screen_do_atjob_name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAtSuccess() {
        Toast.makeText(getContext(), R.string.antitheft_screen_do_atjob_completed_name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showBuyWork() {
        Toast.makeText(getContext(), R.string.purchase_buy_job_doing, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showBuySuccess() {
        Toast.makeText(getContext(), R.string.purchase_buy_job_completed, Toast.LENGTH_SHORT).show();
    }

}
