package com.szp.app.network.client;

/**
 * Created by sunzeping on 17/9/17.
 * Function :
 * Desc :
 */

public interface INetClient<DataRespons, DataRequest> {
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
  void asynRequest(final DataRequest request);
}
