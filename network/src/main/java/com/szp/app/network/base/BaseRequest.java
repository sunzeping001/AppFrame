package com.szp.app.network.base;

import java.io.Serializable;

/**
 * Created by sunzeping on 17/9/14.
 * Function : 抽象请求类
 * Desc :
 */

public abstract class BaseRequest implements Serializable{

  /**
   * 进行加密操作，由子类实现
   */
  abstract public void encrypData();

}
