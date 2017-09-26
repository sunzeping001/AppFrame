package com.szp.app.network.client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sunzeping on 17/9/17.
 * Function : the network access
 * Desc :
 */

public abstract class RetrofitNetClient implements INetClient {

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



}
