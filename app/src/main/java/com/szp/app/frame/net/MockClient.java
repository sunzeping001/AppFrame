package com.szp.app.frame.net;

import com.szp.app.frame.nametest.entity.PersonRequest;
import com.szp.app.frame.nametest.response.Persion;
import com.szp.app.frame.nametest.response.PersonResponse;
import com.szp.app.frame.ui.guanzhu.model.GuanzhuListModel;
import com.szp.app.frame.ui.guanzhu.model.GuanzhuModel;
import com.szp.app.frame.ui.login.entity.LoginRequest;
import com.szp.app.frame.ui.login.entity.LoginResponse;
import com.szp.app.frame.ui.toutiao.entity.ToutiaoRequest;
import com.szp.app.frame.ui.toutiao.entity.ToutiaoResponse;
import com.szp.app.frame.ui.toutiao.model.TouTiaoModel;
import com.szp.app.network.base.BaseRequest;
import com.szp.app.network.base.BaseResponse;
import com.szp.app.network.client.INetClient;
import com.szp.app.network.interf.IResultCallback;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunzeping on 2017/10/23.
 * Function: mock的网络层，不走网络直接返回数据结果
 * Desc:
 */
public class MockClient implements INetClient {

  public MockClient() {
  }

  /**
   * 异步请求
   */
  public void asynQuery(BaseRequest request, IResultCallback outCall) {
    if (request instanceof PersonRequest) {
      PersonResponse response = new PersonResponse();
      response.setCode("0");
      response.setErrorMsg("成功了");
      Persion persion = new Persion();
      persion.setName("小孙哥哥");
      persion.setUrl("www.baidu.com");
      response.setPersion(persion);
      outCall.onSuccess(response);
    }

    if (request instanceof LoginRequest) {
      LoginResponse response = new LoginResponse();
      response.setCode("0");
      response.setErrorMsg("成功了");
      response.setLogin(true);
      outCall.onSuccess(response);
    }

    if(request instanceof ToutiaoRequest){
      ToutiaoResponse toutiaoResponse = new ToutiaoResponse();
      toutiaoResponse.setCode("0");
      toutiaoResponse.setErrorMsg("没有错");
      TouTiaoModel touTiaoModel = new TouTiaoModel();
      GuanzhuListModel guanzhuListModel = new GuanzhuListModel();

      List<GuanzhuModel> list = new ArrayList<>();
      for (int i = 0; i < 7; i++) {
        GuanzhuModel guanzhuModel = new GuanzhuModel();
        guanzhuModel.setTitle("小孙哥哥荣获感动中国第201" + i + "最感动人物");
        guanzhuModel.setContent("央视新闻网");
        guanzhuModel.setUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1508688610664&di=568a6b056c53abe916aa66238e6fcdab&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3Dc803822dc295d143ce7bec601b99e877%2Fac4bd11373f08202d00bff1141fbfbedab641b06.jpg");
        list.add(guanzhuModel);
      }
      guanzhuListModel.setGuanzhuModelList(list);
      touTiaoModel.setGuanzhuModelList(guanzhuListModel);
      toutiaoResponse.setTouTiaoModel(touTiaoModel);
      outCall.onSuccess(touTiaoModel);
    }
  }

  /**
   * 同步请求
   */
  public BaseResponse synQuery(BaseRequest request) {
    BaseResponse baseResponse = null;
    if (request instanceof PersonRequest) {
      PersonResponse response = new PersonResponse();
      response.setCode("0");
      response.setErrorMsg("成功了");
      Persion persion = new Persion();
      persion.setName("小孙哥哥");
      persion.setUrl("www.baidu.com");
      response.setPersion(persion);
      baseResponse = response;
    }
    return baseResponse;
  }
}
