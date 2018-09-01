package com.example.yuwenqing.template.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.disposables.CompositeDisposable;

/**
 * function:
 * 1. 注册RxBus
 * 2. 取消RxBus订阅
 *
 * author YuWenQing
 * Email 1134328499@qq.com
 * created 2018/9/1 下午12:45
 */

public abstract class BaseActivity extends AppCompatActivity{

    protected CompositeDisposable mDisposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CompositeDisposable disposables=subscribeEvent();
        if(disposables!=null)
        {
            mDisposable.addAll(disposables);
        }
    }

    protected abstract CompositeDisposable subscribeEvent();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("BaseActivity", "取消订阅数量:" + mDisposable.size());
        mDisposable.dispose();   //取消RxBus订阅，这个不要乱用，可能就会造成所有的RxBus不能用
    }
}
