package com.example.yuwenqing.template.template;

import android.os.Bundle;

import com.example.yuwenqing.template.R;
import com.example.yuwenqing.template.base.BaseActivity;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends BaseActivity implements MainContact.View {

    private MainContact.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new MainPresenter(this);
    }

    @Override
    protected CompositeDisposable subscribeEvent() {
        return null;
    }


    @Override
    public void setPresenter(MainContact.Presenter presenter) {
        mPresenter=(MainPresenter)presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
