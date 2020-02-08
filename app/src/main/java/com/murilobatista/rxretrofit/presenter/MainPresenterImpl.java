package com.murilobatista.rxretrofit.presenter;
import com.murilobatista.rxretrofit.model.PostModel;
import com.murilobatista.rxretrofit.network.Api;
import com.murilobatista.rxretrofit.network.RetrofitClient;
import com.murilobatista.rxretrofit.view.MainView;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainPresenterImpl implements MainPresenter {
    private MainView mainView;
    private CompositeDisposable compositeDisposable;

    @Override
    public void fetchPosts() {
        Retrofit retrofit = RetrofitClient.getInstance();
        Api api = retrofit.create(Api.class);
        compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(api.getPosts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<PostModel>>() {
            @Override
            public void accept(List<PostModel> postModels){
                displayPost(postModels);
            }
        }));
    }

    private void displayPost(List<PostModel> posts) {
        mainView.setPostToText(posts.get(0).title);
    }

    @Override
    public void clearComposible() {
        if(compositeDisposable != null)
            compositeDisposable.clear();
    }

    @Override
    public void attachView(MainView view) {
        mainView = view;
    }

    @Override
    public void dettachView() {
        mainView = null;
    }
}