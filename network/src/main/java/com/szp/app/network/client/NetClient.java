package com.szp.app.network.client;

import com.szp.app.network.reponse.PersonBaseResponse;
import com.szp.app.network.requests.PersonRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sunzeping on 2017/9/20.
 * Function:
 * Desc:
 */
public class NetClient extends RetrofitNetClient<PersonBaseResponse,PersonRequest> {

  public NetClient(String url) {
    super(url);
  }

  @Override
  public PersonBaseResponse syncRequest(PersonRequest request) {
    PersonBaseResponse response = null;
    CommonInterface.Server server = mRetrofit.create(CommonInterface.Server.class);
    Call<PersonBaseResponse> call = server.request(request);
    try {
      Response rp = call.execute();
      response = (PersonBaseResponse) rp.body();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return response;
  }

  @Override public void asynRequest(PersonRequest request, Callback<PersonBaseResponse> outCall) {
    CommonInterface.Server server = mRetrofit.create(CommonInterface.Server.class);
    Call<PersonBaseResponse> call = server.request(request);
    call.enqueue(outCall);
  }
}
