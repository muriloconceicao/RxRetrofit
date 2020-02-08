package com.murilobatista.rxretrofit.presenter;

import com.murilobatista.rxretrofit.bases.BasePresenter;
import com.murilobatista.rxretrofit.view.MainView;

public interface MainPresenter extends BasePresenter<MainView> {
    void fetchPosts();
    void clearComposible();
}