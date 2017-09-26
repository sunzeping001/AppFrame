package com.szp.app.frame.net;

import com.szp.app.frame.nametest.entity.PersonRequest;
import com.szp.app.frame.nametest.response.PersonResponse;
import com.szp.app.network.base.BaseRequest;
import com.szp.app.network.client.RetrofitNetClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sunzeping on 2017/9/20.
 * Function:
 * Desc:
 */
public class NetClient extends RetrofitNetClient {

  public NetClient(String url) {
    super(url);
  }

  /**
   * 异步请求
   */
  public void asynPersonQuery(PersonRequest request, Callback outCall) {
    CommonInterface.Server server = mRetrofit.create(CommonInterface.Server.class);
    Call<PersonResponse> call = server.request(request);
    call.enqueue(outCall);
  }

  /**
   * 同步请求
   */
  public PersonResponse synPersonQuery(PersonRequest request) {
    PersonResponse response = null;
    CommonInterface.Server personServer = mRetrofit.create(CommonInterface.Server.class);
    Call<PersonResponse> call = personServer.request(request);
    try {
      Response rp = call.execute();
      response = (PersonResponse) rp.body();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return response;
  }

}