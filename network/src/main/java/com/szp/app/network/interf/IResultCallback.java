package com.szp.app.network.interf;

/**
 * Created by sunzeping on 2017/10/23.
 * Function:
 * Desc:
 */
public interface IResultCallback<T>{

  void onSuccess(T response);

  void onFail(String errorCode, String errorMsg);

}
