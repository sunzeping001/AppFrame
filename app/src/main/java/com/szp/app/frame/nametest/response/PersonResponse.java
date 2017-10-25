package com.szp.app.frame.nametest.response;

import com.szp.app.network.base.BaseResponse;

/**
 * Created by sunzeping on 2017/9/21.
 * Function: 人类
 * Desc:
 */
public class PersonResponse extends BaseResponse {

  private String code;

  private String errorMsg;

  private Persion persion;

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

  public Persion getPersion() {
    return persion;
  }

  public void setPersion(Persion persion) {
    this.persion = persion;
  }

  @Override public String toString() {
    return "PersonResponse{" +
        "persion=" + persion +
        ", errorMsg='" + errorMsg + '\'' +
        ", code='" + code + '\'' +
        '}';
  }
}
