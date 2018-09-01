package com.example.yuwenqing.template.template;

public class MainPresenter implements MainContact.Presenter {

    private MainContact.View mainActivity;

    public MainPresenter(MainContact.View view) {
        mainActivity=(MainActivity)view;
    }

    @Override
    public void detachView() {
        mainActivity=null;
    }
}
