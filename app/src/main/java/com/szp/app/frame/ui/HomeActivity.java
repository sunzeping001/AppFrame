package com.szp.app.frame.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;
import com.szp.app.frame.R;
import com.szp.app.frame.activity.BaseActivity;
import com.szp.app.frame.net.CommonInterface;
import com.szp.app.frame.net.NetClient;
import com.szp.app.frame.ui.news.NewsFragment;
import com.szp.app.frame.ui.news.model.NewsData;
import com.szp.app.frame.ui.news.model.NewsFragmentModel;
import com.szp.app.frame.ui.news.newscontract.NewsContractImpl;
import com.szp.app.frame.ui.toutiao.TouTiaoFragment;
import com.szp.app.frame.ui.toutiao.entity.ToutiaoRequest;
import com.szp.app.frame.ui.toutiao.model.TouTiaoModel;
import com.szp.app.frame.ui.toutiao.presenter.TouTiaoPresenterImpl;
import com.szp.app.network.interf.IResultCallback;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {

  private RadioButton rb_home;
  private RadioButton rb_news;
  private RadioButton rb_other;
  private RadioButton rb_mine;
  //头条key
  public static final String TOUTIAO_DATA = "toutiao_data";
  //头条数据
  private TouTiaoModel touTiaoModel;

  /**
   * 选择的默认索引
   */
  private int mIndex = 0;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    getData();
    rb_home = (RadioButton) findViewById(R.id.home);
    rb_news = (RadioButton) findViewById(R.id.news);
    rb_other = (RadioButton) findViewById(R.id.other);
    rb_mine = (RadioButton) findViewById(R.id.mine);
    //设置监听事件
    rb_home.setOnClickListener(homeListener);
    rb_news.setOnClickListener(newsListener);
    rb_other.setOnClickListener(otherListener);
    rb_mine.setOnClickListener(mineListener);
  }

  /**
   * 意外恢复
   */
  @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    touTiaoModel = (TouTiaoModel) savedInstanceState.getSerializable(TOUTIAO_DATA);
  }

  /**
   * 获取外部数据
   */
  private void getData() {
  }

  @Override protected void onResume() {
    super.onResume();
    showDefalutFragment();
  }

  /**
   * 显示默认的fragment
   */
  private void showDefalutFragment() {
    if (mIndex == 0) {
      getToutiaoData();
      //setSlector();
      //jumpToToutiaoFragment();
      //mIndex = 0;
    }
  }

  /**
   * 设置点击效果
   */
  private void setSlector() {
    switch (mIndex) {
      case 0:
        rb_home.setChecked(true);
        rb_news.setChecked(false);
        rb_other.setChecked(false);
        rb_mine.setChecked(false);
        break;

      case 1:
        rb_home.setChecked(false);
        rb_news.setChecked(true);
        rb_other.setChecked(false);
        rb_mine.setChecked(false);
        break;

      case 2:
        rb_home.setChecked(false);
        rb_news.setChecked(false);
        rb_other.setChecked(true);
        rb_mine.setChecked(false);
        break;

      case 3:
        rb_home.setChecked(false);
        rb_news.setChecked(false);
        rb_other.setChecked(false);
        rb_mine.setChecked(true);
        break;
      default:
        break;
    }
  }

  private View.OnClickListener homeListener = new View.OnClickListener() {
    @Override public void onClick(View v) {
      if (mIndex == 0) {
        return;
      }
      //调用接口获取头条的数据
      getToutiaoData();

      //jumpToToutiaoFragment();
      //mIndex = 0;
      //setSlector();
    }
  };

  /**
   * 拉取头条接口获取数据
   */
  private void getToutiaoData() {
    ToutiaoRequest toutiaoRequest = new ToutiaoRequest();
    toutiaoRequest.setRequestName("toutiao");
    new NetClient("http://www.fuckbeautiful.com").asynToutiaoQuery(toutiaoRequest,
        new IResultCallback<TouTiaoModel>() {
          @Override public void onSuccess(TouTiaoModel response) {
            touTiaoModel = response;
            jumpToToutiaoFragment();
            mIndex = 0;
            setSlector();
          }

          @Override public void onFail(String errorCode, String errorMsg) {
            Toast.makeText(HomeActivity.this, "errorCode = " + errorCode + "errorMsg = " + errorMsg,
                Toast.LENGTH_SHORT).show();
          }
        });
  }

  private View.OnClickListener newsListener = new View.OnClickListener() {
    @Override public void onClick(View v) {
      if (mIndex == 1) {
        return;
      }
      jumpToNewsFragment();
      mIndex = 1;
      setSlector();
    }
  };

  private View.OnClickListener otherListener = new View.OnClickListener() {
    @Override public void onClick(View v) {
      mIndex = 2;
      setSlector();
    }
  };

  private View.OnClickListener mineListener = new View.OnClickListener() {
    @Override public void onClick(View v) {
      mIndex = 3;
      setSlector();
    }
  };

  /**
   * 跳转到首页
   */
  private void jumpToToutiaoFragment() {
    //		HomeFragment homeFragment = new HomeFragment();
    //		HomeFragmentModel homeFragmentModel = new HomeFragmentModel();
    //		List<String> listUrl = new ArrayList<>();
    //		listUrl.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507024066438&di=f51c63af6779d27b364efbb51560520c&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F50da81cb39dbb6fd493c67e70024ab18962b378f.jpg");
    //		listUrl.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507024066430&di=0c89edad06bca737233d9153762658a2&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F0824ab18972bd40704fe413d72899e510fb30930.jpg");
    //		listUrl.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507024066430&di=03df4cb59cfb1939960eda4adfb92a65&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fd833c895d143ad4b839de2028b025aafa50f0644.jpg");
    //		homeFragmentModel.setListUrl(listUrl);
    //		HomeFragmentContractImpl homeFragmentContract = new HomeFragmentContractImpl(homeFragment, homeFragmentModel);
    //		startFirstFragment(homeFragment);
    TouTiaoFragment touTiaoFragment = new TouTiaoFragment();
    TouTiaoPresenterImpl tiaoPresenter = new TouTiaoPresenterImpl(touTiaoFragment, touTiaoModel);
    startFirstFragment(touTiaoFragment);
  }

  /**
   * 跳转到首页
   */
  private void jumpToNewsFragment() {
    NewsFragment newsFragment = new NewsFragment();
    NewsFragmentModel newsFragmentModel = new NewsFragmentModel();

    List<NewsData> list = new ArrayList<>();
    NewsData model1 = new NewsData();
    model1.setUrl(
        "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507887527&di=6a320a3aa3784d44902780c1b90eaad2&imgtype=jpg&er=1&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3D7dde8a793ea85edfee81f660213d6356%2F8cb1cb13495409231cbb80579858d109b2de49cd.jpg");
    model1.setContent("习近平访问北京海淀区西二旗智学苑四号楼706室");
    list.add(model1);

    NewsData model2 = new NewsData();
    model2.setUrl(
        "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507399657473&di=e5b2ed635300e2a0d21fdfe7553120f9&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fb999a9014c086e062d68efaf08087bf40bd1cb16.jpg");
    model2.setContent("习近平访问北京海淀区西二旗智学苑四号楼705室");
    list.add(model2);

    NewsData model3 = new NewsData();
    model3.setUrl(
        "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507399657472&di=601d1d09e88f1d24ccbdf1def07e8973&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fd788d43f8794a4c231fca94504f41bd5ac6e3984.jpg");
    model3.setContent("习近平访问北京海淀区西二旗智学苑四号楼704室");
    list.add(model3);

    NewsData model4 = new NewsData();
    model4.setUrl(
        "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507399657405&di=15cdf4ca220c6b7212541255a76c45f4&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F1f178a82b9014a909461e9baa1773912b31bee5e.jpg");
    model4.setContent("习近平访问北京海淀区西二旗智学苑四号楼703室");
    list.add(model4);

    NewsData model5 = new NewsData();
    model5.setUrl(
        "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1507399657404&di=aa19eb928571370ebc181c17250b7c67&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F1f178a82b9014a90e7eb9d17ac773912b21bee47.jpg");
    model5.setContent("习近平访问北京海淀区西二旗智学苑四号楼702室");
    list.add(model5);

    newsFragmentModel.setNewsDataList(list);

    NewsContractImpl newsContract = new NewsContractImpl(newsFragment, newsFragmentModel);
    startFirstFragment(newsFragment);
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putSerializable(TOUTIAO_DATA, touTiaoModel);
  }
}
