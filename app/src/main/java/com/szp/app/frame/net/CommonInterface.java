package com.szp.app.frame.net;

import com.szp.app.frame.nametest.entity.PersonRequest;
import com.szp.app.frame.nametest.response.PersonResponse;
import com.szp.app.frame.ui.home.entity.HomeRequest;
import com.szp.app.frame.ui.home.entity.HomeResponse;
import com.szp.app.frame.ui.login.entity.LoginRequest;
import com.szp.app.frame.ui.login.entity.LoginResponse;
import com.szp.app.frame.ui.news.entity.NewsReponse;
import com.szp.app.frame.ui.news.entity.NewsRequest;
import com.szp.app.frame.ui.toutiao.entity.ToutiaoRequest;
import com.szp.app.frame.ui.toutiao.entity.ToutiaoResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by sunzeping on 17/9/17.
 * Function : 定义的接口类
 * Desc :
 */

public interface CommonInterface {

  interface Server {
    @Headers({ "Content-type:application/json;charset=UTF-8" }) @POST("JsonTest")
    Call<PersonResponse> request(@Body PersonRequest request);
  }

  interface Login {
    @Headers({ "Content-type:application/json;charset=UTF-8" }) @POST("Login")
    Call<LoginResponse> request(@Body LoginRequest request);
  }

  interface Toutiao {
    @Headers({ "Content-type:application/json;charset=UTF-8" }) @POST("Toutiao")
    Call<ToutiaoResponse> request(@Body ToutiaoRequest request);
  }

  interface News {
    @Headers({ "Content-type:application/json;charset=UTF-8" }) @POST("News")
    Call<NewsReponse> request(@Body NewsRequest request);
  }
}
