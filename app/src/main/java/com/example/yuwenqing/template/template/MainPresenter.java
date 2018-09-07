package com.example.yuwenqing.template.template;

public class MainPresenter implements MainContact.Presenter {

    private MainContact.View mainActivity;

    public MainPresenter(MainContact.View view) {
        mainActivity=(MainActivity)view;
        mainActivity.setPresenter(this);
    }

    @Override
    public void detachView() {
        mainActivity=null;
    }
}
