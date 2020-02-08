package com.murilobatista.rxretrofit.network;

import com.murilobatista.rxretrofit.model.PostModel;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    @GET("posts")
    Observable<List<PostModel>> getPosts();
}