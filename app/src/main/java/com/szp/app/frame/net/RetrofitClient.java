package com.szp.app.frame.net;

import com.szp.app.frame.ui.login.entity.LoginRequest;
import com.szp.app.frame.ui.login.entity.LoginResponse;
import com.szp.app.frame.ui.news.entity.NewsReponse;
import com.szp.app.frame.ui.news.entity.NewsRequest;
import com.szp.app.frame.ui.news.model.NewsFragmentModel;
import com.szp.app.frame.ui.toutiao.entity.ToutiaoRequest;
import com.szp.app.frame.ui.toutiao.entity.ToutiaoResponse;
import com.szp.app.frame.ui.toutiao.model.TouTiaoModel;
import com.szp.app.network.client.RetrofitNetClient;
import com.szp.app.network.interf.IResultCallback;
import java.net.ConnectException;
import java.net.SocketException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sunzeping on 2017/10/23.
 * Function:
 * Desc:
 */
public class RetrofitClient extends RetrofitNetClient{

  public RetrofitClient(String url) {
    super(url);
  }

  /**
   * 获取登录信息请求
   */
  public void asynLoginQuery(LoginRequest request, final IResultCallback resultCallback) {
    CommonInterface.Login server = mRetrofit.create(CommonInterface.Login.class);
    Call<LoginResponse> call = server.request(request);
    call.enqueue(new Callback<LoginResponse>() {
      @Override
      public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
        String code = response.body().getCode();
        String msg = response.body().getErrorMsg();
        boolean isLogin = response.body().isLogin();
        if("0".equals(code) && isLogin){
          resultCallback.onSuccess(response);
        } else {
          resultCallback.onFail(code,msg);
        }
      }

      @Override public void onFailure(Call<LoginResponse> call, Throwable t) {
        if (t instanceof ConnectException) {
          resultCallback.onFail("110", "连接超时...");
        } else if (t instanceof SocketException) {
          resultCallback.onFail("120", "服务器异常...");
        }
      }
    });
  }

  /**
   * 获取登录信息请求
   */
  public void asynToutiaoQuery(ToutiaoRequest request, final IResultCallback resultCallback) {
    CommonInterface.Toutiao server = mRetrofit.create(CommonInterface.Toutiao.class);
    Call<ToutiaoResponse> call = server.request(request);
    call.enqueue(new Callback<ToutiaoResponse>() {
      @Override
      public void onResponse(Call<ToutiaoResponse> call, Response<ToutiaoResponse> response) {
        String code = response.body().getCode();
        String msg = response.body().getErrorMsg();
        TouTiaoModel touTiaoModel = response.body().getTouTiaoModel();
        if("0".equals(code)){
          resultCallback.onSuccess(touTiaoModel);
        } else {
          resultCallback.onFail(code,msg);
        }
      }

      @Override public void onFailure(Call<ToutiaoResponse> call, Throwable t) {
        if (t instanceof ConnectException) {
          resultCallback.onFail("110", "连接超时...");
        } else if (t instanceof SocketException) {
          resultCallback.onFail("120", "服务器异常...");
        }
      }
    });
  }

  /**
   * 获取登录信息请求
   */
  public void asynNewsQuery(NewsRequest request, final IResultCallback resultCallback) {
    CommonInterface.News server = mRetrofit.create(CommonInterface.News.class);
    Call<NewsReponse> call = server.request(request);
    call.enqueue(new Callback<NewsReponse>() {
      @Override
      public void onResponse(Call<NewsReponse> call, Response<NewsReponse> response) {
        String code = response.body().getCode();
        String msg = response.body().getErrorMsg();
        NewsFragmentModel newsFragmentModel = response.body().getNewsFragmentModel();
        if("0".equals(code)){
          resultCallback.onSuccess(newsFragmentModel);
        } else {
          resultCallback.onFail(code,msg);
        }
      }

      @Override public void onFailure(Call<NewsReponse> call, Throwable t) {
        if (t instanceof ConnectException) {
          resultCallback.onFail("110", "连接超时...");
        } else if (t instanceof SocketException) {
          resultCallback.onFail("120", "服务器异常...");
        }
      }
    });
  }







}
