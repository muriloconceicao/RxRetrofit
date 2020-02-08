package com.murilobatista.rxretrofit.bases;

public interface BasePresenter <V extends BaseView> {
    void attachView(V view);
    void dettachView();
}