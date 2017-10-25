package com.szp.app.frame.ui.home.entity;

import com.szp.app.frame.ui.news.model.NewsData;
import com.szp.app.network.base.BaseResponse;
import java.util.List;

/**
 * Created by sunzeping on 2017/10/25.
 * Function:
 * Desc:
 */
public class HomeResponse extends BaseResponse {

  private String code;

  private String errorMsg;

  private List<NewsData> list;

  public List<NewsData> getList() {
    return list;
  }

  public void setList(List<NewsData> list) {
    this.list = list;
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
