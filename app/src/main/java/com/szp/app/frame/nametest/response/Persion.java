package com.szp.app.frame.nametest.response;

import java.io.Serializable;

/**
 * Created by sunzeping on 2017/10/23.
 * Function:
 * Desc:
 */
public class Persion implements Serializable {

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

  @Override public String toString() {
    return "Persion{" +
        "name='" + name + '\'' +
        ", url='" + url + '\'' +
        '}';
  }
}
