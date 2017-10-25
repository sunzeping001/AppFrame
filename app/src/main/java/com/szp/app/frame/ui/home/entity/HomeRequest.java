package com.szp.app.frame.ui.home.entity;

import com.szp.app.network.base.BaseRequest;

/**
 * Created by sunzeping on 2017/10/25.
 * Function:
 * Desc:
 */
public class HomeRequest extends BaseRequest {

  private String user;
  private String name;

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override public void encrypData() {

  }
}
