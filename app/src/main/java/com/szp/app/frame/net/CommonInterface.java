package com.szp.app.frame.net;

import com.szp.app.frame.nametest.entity.PersonRequest;
import com.szp.app.frame.nametest.response.PersonResponse;
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
}
