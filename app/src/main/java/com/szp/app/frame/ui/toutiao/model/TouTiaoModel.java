package com.szp.app.frame.ui.toutiao.model;

import com.szp.app.frame.ui.guanzhu.model.GuanzhuListModel;
import java.io.Serializable;

/**
 * Created by sunzeping on 17/10/21.
 * Function : 头条的数据模型
 * Desc :
 */

public class TouTiaoModel implements Serializable {
  //关注数据
  private GuanzhuListModel guanzhuModelList;
  //热点

  public GuanzhuListModel getGuanzhuModelList() {
    return guanzhuModelList;
  }

  public void setGuanzhuModelList(GuanzhuListModel guanzhuModelList) {
    this.guanzhuModelList = guanzhuModelList;
  }
}
