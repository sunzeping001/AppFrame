package com.szp.app.network.client;

import com.szp.app.network.reponse.PersonBaseResponse;
import com.szp.app.network.requests.PersonRequest;

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

	interface Server{
		@Headers({"Content-type:application/json;charset=UTF-8"})
		@POST("JsonTest")
		Call<PersonBaseResponse> request(@Body PersonRequest request);
	}

}
