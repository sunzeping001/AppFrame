package com.szp.app.frame.net;

import android.util.Log;
import com.szp.app.frame.GloableVeriable;
import com.szp.app.frame.ui.home.entity.HomeRequest;
import com.szp.app.frame.ui.login.entity.LoginRequest;
import com.szp.app.frame.ui.login.entity.LoginResponse;
import com.szp.app.frame.ui.news.entity.NewsReponse;
import com.szp.app.frame.ui.news.entity.NewsRequest;
import com.szp.app.frame.ui.news.model.NewsData;
import com.szp.app.frame.ui.news.model.NewsFragmentModel;
import com.szp.app.frame.ui.toutiao.entity.ToutiaoRequest;
import com.szp.app.frame.ui.toutiao.entity.ToutiaoResponse;
import com.szp.app.frame.ui.toutiao.model.TouTiaoModel;
import com.szp.app.network.client.INetClient;
import com.szp.app.network.interf.IResultCallback;
import java.util.List;

/**
 * Created by sunzeping on 2017/9/20.
 * Function: 代理请求
 * Desc:
 */
public class NetClient implements INetClient {

  private RetrofitClient retrofitClient;

  private MockClient mockClient;

  private String url;

  public NetClient(String url) {
    this.url = url;
    retrofitClient = new RetrofitClient(url);
    mockClient = new MockClient();
  }

  /**
   * 获取头条结果
   * @param request
   * @param resultCallback
   */
  public void asynToutiaoQuery(final ToutiaoRequest request, final IResultCallback resultCallback) {
    if (GloableVeriable.MOCK) {
      mockClient.asynQuery(request, resultCallback);
    } else {
      retrofitClient.asynToutiaoQuery(request, new IResultCallback<TouTiaoModel>() {
        @Override public void onSuccess(TouTiaoModel response) {
          Log.e("szp", response.toString());
          resultCallback.onSuccess(response);
        }

        @Override public void onFail(String errorCode, String errorMsg) {
          Log.e("szp", "errorCode = " + errorCode + "errorMsg = " + errorMsg);
          resultCallback.onFail(errorCode,errorMsg);
        }
      });
    }
  }

  /**
   * 登录
   * @param request
   * @param resultCallback
   */
  public void asynLoginQuery(final LoginRequest request, final IResultCallback resultCallback) {
    if (GloableVeriable.MOCK) {
      mockClient.asynQuery(request, resultCallback);
    } else {
      retrofitClient.asynLoginQuery(request, new IResultCallback<LoginResponse>() {
        @Override public void onSuccess(LoginResponse response) {
          Log.e("szp", response.isLogin() + "");
          resultCallback.onSuccess(response);
        }

        @Override public void onFail(String errorCode, String errorMsg) {
          Log.e("szp", "errorCode = " + errorCode + "errorMsg = " + errorMsg);
          resultCallback.onFail(errorCode,errorMsg);
        }
      });
    }
  }

  /**
   * 登录
   * @param request
   * @param resultCallback
   */
  public void asynNewsQuery(final NewsRequest request, final IResultCallback resultCallback) {
    if (GloableVeriable.MOCK) {
      mockClient.asynQuery(request, resultCallback);
    } else {
      retrofitClient.asynNewsQuery(request, new IResultCallback<NewsFragmentModel>() {
        @Override public void onSuccess(NewsFragmentModel response) {
          resultCallback.onSuccess(response);
        }

        @Override public void onFail(String errorCode, String errorMsg) {
          Log.e("szp", "errorCode = " + errorCode + "errorMsg = " + errorMsg);
          resultCallback.onFail(errorCode,errorMsg);
        }
      });
    }
  }

}