package com.szp.app.frame.net;

import com.szp.app.frame.nametest.entity.PersonRequest;
import com.szp.app.frame.nametest.response.Persion;
import com.szp.app.frame.nametest.response.PersonResponse;
import com.szp.app.frame.ui.guanzhu.model.GuanzhuListModel;
import com.szp.app.frame.ui.guanzhu.model.GuanzhuModel;
import com.szp.app.frame.ui.login.entity.LoginRequest;
import com.szp.app.frame.ui.login.entity.LoginResponse;
import com.szp.app.frame.ui.news.entity.NewsRequest;
import com.szp.app.frame.ui.news.model.NewsData;
import com.szp.app.frame.ui.news.model.NewsFragmentModel;
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

		if (request instanceof ToutiaoRequest) {
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

		if (request instanceof NewsRequest) {
			NewsFragmentModel newsFragmentModel = new NewsFragmentModel();

			List<NewsData> list = new ArrayList<>();
			NewsData model1 = new NewsData();
			model1.setUrl(
					"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507887527&di=6a320a3aa3784d44902780c1b90eaad2&imgtype=jpg&er=1&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3D7dde8a793ea85edfee81f660213d6356%2F8cb1cb13495409231cbb80579858d109b2de49cd.jpg");
			model1.setContent("习近平访问北京海淀区西二旗智学苑3号楼706室");
			list.add(model1);

			NewsData model2 = new NewsData();
			model2.setUrl(
					"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507399657473&di=e5b2ed635300e2a0d21fdfe7553120f9&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fb999a9014c086e062d68efaf08087bf40bd1cb16.jpg");
			model2.setContent("习近平访问北京海淀区西二旗智学苑3号楼705室");
			list.add(model2);

			NewsData model3 = new NewsData();
			model3.setUrl(
					"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507399657472&di=601d1d09e88f1d24ccbdf1def07e8973&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fd788d43f8794a4c231fca94504f41bd5ac6e3984.jpg");
			model3.setContent("习近平访问北京海淀区西二旗智学苑3号楼704室");
			list.add(model3);

			NewsData model4 = new NewsData();
			model4.setUrl(
					"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507399657405&di=15cdf4ca220c6b7212541255a76c45f4&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F1f178a82b9014a909461e9baa1773912b31bee5e.jpg");
			model4.setContent("习近平访问北京海淀区西二旗智学苑3号楼703室");
			list.add(model4);

			NewsData model5 = new NewsData();
			model5.setUrl(
					"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507399657404&di=aa19eb928571370ebc181c17250b7c67&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F1f178a82b9014a90e7eb9d17ac773912b21bee47.jpg");
			model5.setContent("习近平访问北京海淀区西二旗智学苑3号楼702室");
			list.add(model5);
			newsFragmentModel.setNewsDataList(list);
			outCall.onSuccess(newsFragmentModel);
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
