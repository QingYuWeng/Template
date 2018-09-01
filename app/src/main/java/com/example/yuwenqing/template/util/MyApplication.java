package com.example.yuwenqing.template.util;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;


/**
 * function:
 * 1.用于获取全局上下文
 * 2.初始化LeakCanary
 * author YuWenQing
 * Email 1134328499@qq.com
 * created 2018/8/31 下午5:31
 */
public class MyApplication extends Application {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...
        instance=this;
    }

    /**
     * 获取MyApplication实例
     * @return
     */
    public static MyApplication getInstance() {
        return instance;
    }
}
