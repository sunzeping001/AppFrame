package com.szp.app.network.client;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sunzeping on 17/9/17.
 * Function : the network access
 * Desc :
 */

public abstract class RetrofitNetClient<DataRespons,DataRequest> implements INetClient<DataRespons,DataRequest> {

  /**
   * Retrofit
   */
  protected Retrofit mRetrofit;
  /**
   *  请求地址url
   */
  protected String mUrl;

  public RetrofitNetClient(String url) {
    this.mUrl = url;
    mRetrofit = new Retrofit.Builder().baseUrl(mUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  /**
   * 同步返回接口数据
   */
  @Override public DataRespons syncRequest(DataRequest request) {
    DataRespons response = null;
    return response;
  }

  /**
   * 异步返回结果
   */
  @Override public void asynRequest(final DataRequest request, Callback<DataRespons> outCall) {
    //server = mRetrofit.create(server.getClass());
    //Call<DataRespons> call = server.request(request);
    //call.enqueue(outCall);
  }
}
