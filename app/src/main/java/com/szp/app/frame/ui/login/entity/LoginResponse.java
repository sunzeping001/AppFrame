package com.szp.app.frame.ui.login.entity;

import com.szp.app.network.base.BaseResponse;

/**
 * Created by sunzeping on 2017/10/25.
 * Function: 登录返回结果
 * Desc:
 */
public class LoginResponse extends BaseResponse {

  private String code;
  private String errorMsg;
  private boolean isLogin;

  public boolean isLogin() {
    return isLogin;
  }

  public void setLogin(boolean login) {
    isLogin = login;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }
}
