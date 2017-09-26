package com.szp.app.frame.nametest.entity;

import com.szp.app.network.base.BaseRequest;

/**
 * Created by sunzeping on 2017/9/21.
 * Function:
 * Desc:
 */
public class PersonRequest extends BaseRequest {
  private String name;
  private String url;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
