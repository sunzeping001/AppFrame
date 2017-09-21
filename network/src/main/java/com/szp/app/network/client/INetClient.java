package com.szp.app.network.client;

import com.szp.app.network.base.BaseRequest;
import retrofit2.Callback;

/**
 * Created by sunzeping on 17/9/17.
 * Function :
 * Desc :
 */

public interface INetClient<DataRespons,DataRequest> {
  /**
   * 同步请求
   * @param request
   * @return
   */
  DataRespons syncRequest(DataRequest request);

  /**
   * 异步请求
   * @param request
   */
  void asynRequest(final DataRequest request, Callback<DataRespons> call);
}
