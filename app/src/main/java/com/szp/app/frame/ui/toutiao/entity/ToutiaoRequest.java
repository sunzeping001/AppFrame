package com.szp.app.frame.ui.toutiao.entity;

import com.szp.app.network.base.BaseRequest;

/**
 * Created by sunzeping on 2017/10/25.
 * Function:
 * Desc:
 */
public class ToutiaoRequest extends BaseRequest {

  private String requestName;

  public String getRequestName() {
    return requestName;
  }

  public void setRequestName(String requestName) {
    this.requestName = requestName;
  }

  @Override public void encrypData() {

  }
}
