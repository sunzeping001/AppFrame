package com.szp.app.frame.ui.login.entity;

import com.szp.app.network.base.BaseRequest;

/**
 * Created by sunzeping on 2017/10/25.
 * Function:
 * Desc:
 */
public class LoginRequest extends BaseRequest {

  private String name;
  private String pwd;

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getName() {

    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override public void encrypData() {
    name = name + pwd;//MD5加密
    pwd = pwd + name;//MD5加密
  }
}
