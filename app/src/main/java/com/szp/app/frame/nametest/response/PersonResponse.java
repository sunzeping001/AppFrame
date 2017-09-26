package com.szp.app.frame.nametest.response;

import com.szp.app.network.base.BaseResponse;
import java.io.Serializable;

/**
 * Created by sunzeping on 2017/9/21.
 * Function:
 * Desc:
 */
public class PersonResponse extends BaseResponse {
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
