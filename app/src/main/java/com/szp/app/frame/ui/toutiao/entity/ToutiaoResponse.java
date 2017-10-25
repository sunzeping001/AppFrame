package com.szp.app.frame.ui.toutiao.entity;

import com.szp.app.frame.ui.toutiao.model.TouTiaoModel;
import com.szp.app.network.base.BaseResponse;

/**
 * Created by sunzeping on 2017/10/25.
 * Function:
 * Desc:
 */
public class ToutiaoResponse extends BaseResponse {

  private String code;
  private String errorMsg;
  private TouTiaoModel touTiaoModel;

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

  public TouTiaoModel getTouTiaoModel() {
    return touTiaoModel;
  }

  public void setTouTiaoModel(TouTiaoModel touTiaoModel) {
    this.touTiaoModel = touTiaoModel;
  }
}
