package com.domobile.dimobile_test.rate_exchange.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.domobile.dimobile_test.R;
import com.domobile.dimobile_test.rate_exchange.presenter.RateExchangePresenter;
import com.domobile.dimobile_test.rate_exchange.presenter.RateExchangePresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *description:汇率转换
 *author:zhua
 *creator at:2018/3/21
 */
public class RateExchangeActivity
        extends AppCompatActivity implements RateExchangeView
{
    @BindView(R.id.recycle_content)
    public RecyclerView          mRecyclerView;
    //presenter 接口
    private RateExchangePresenter mRateExchangePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_exchange);
        ButterKnife.bind(this);
        mRateExchangePresenter = new RateExchangePresenterImpl(this,this);
    }

    @OnClick(R.id.Btn_update)
    public void update(View view) {
        if(null != mRateExchangePresenter){
            mRateExchangePresenter.updateData();
        }
    }

    @Override
    public RecyclerView getRecyclView() {
        return mRecyclerView;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(null != mRateExchangePresenter){
            mRateExchangePresenter.cacheData();
        }
    }
}
