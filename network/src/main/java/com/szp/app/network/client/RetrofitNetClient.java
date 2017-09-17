package com.szp.app.network.client;

import android.util.Log;

import com.szp.app.network.reponse.PersonBaseResponse;
import com.szp.app.network.requests.PersonRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sunzeping on 17/9/17.
 * Function : the network access
 * Desc :
 */

public class RetrofitNetClient implements INetClient {

	/**
	 * Retrofit
	 */
	private Retrofit mRetrofit;
	/**
	 *  请求地址url
	 */
	private String mUrl;

	public RetrofitNetClient(String url) {
		this.mUrl = url;
		mRetrofit = new Retrofit.Builder()
				.baseUrl(mUrl)
				.addConverterFactory(GsonConverterFactory.create())
				.build();

	}

	/**
	 * 同步返回接口数据
	 * @param request
	 * @return
	 */
	public PersonBaseResponse syncRequest(PersonRequest request) {
		PersonBaseResponse response = null;
		CommonInterface.PersonServer personServer = mRetrofit.create(CommonInterface.PersonServer.class);
		Call<PersonBaseResponse> call = personServer.requestPerson(request);
		try {
			Response rp = call.execute();
			response = (PersonBaseResponse)rp.body();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 异步返回结果
	 */
	public void asynRequest(final PersonRequest request){
		PersonBaseResponse response = null;
		CommonInterface.PersonServer personServer = mRetrofit.create(CommonInterface.PersonServer.class);
		Call<PersonBaseResponse> call = personServer.requestPerson(request);
		call.enqueue(new Callback<PersonBaseResponse>() {
			@Override
			public void onResponse(Call<PersonBaseResponse> call, Response<PersonBaseResponse> response) {
				Log.e("szp",response.body().toString());
			}

			@Override
			public void onFailure(Call<PersonBaseResponse> call, Throwable t) {

			}
		});


	}


}
