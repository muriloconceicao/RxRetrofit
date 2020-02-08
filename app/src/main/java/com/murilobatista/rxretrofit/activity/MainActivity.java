package com.murilobatista.rxretrofit.activity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.murilobatista.rxretrofit.R;
import com.murilobatista.rxretrofit.presenter.MainPresenter;
import com.murilobatista.rxretrofit.presenter.MainPresenterImpl;
import com.murilobatista.rxretrofit.view.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {
    private MainPresenter mainPresenter;
    @BindView(R.id.txtPostTitle) TextView txtPostTitle;

    @OnClick(R.id.btnFetch)
    public void onBtnFetchClick() {
        fetchPosts();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter = new MainPresenterImpl();
        mainPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.clearComposible();
        mainPresenter.dettachView();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.clearComposible();
    }

    @Override
    public void setPostToText(String post) {
        txtPostTitle.setText(post);
    }

    @Override
    public Context getContext() {
        return this;
    }

    private void fetchPosts() {
        mainPresenter.fetchPosts();
    }
}