package com.domobile.dimobile_test.rate_exchange.presenter;

/*
 *  @创建者:   zhua
 *  @创建时间:  2018/3/21 21:28
 *  @描述：    presenter实现类
 */

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.domobile.dimobile_test.net_work_request.NetRequestListener;
import com.domobile.dimobile_test.rate_exchange.beans.RateExchangeBeans;
import com.domobile.dimobile_test.rate_exchange.helper.OnStartDragListener;
import com.domobile.dimobile_test.rate_exchange.helper.RecyclerListAdapter;
import com.domobile.dimobile_test.rate_exchange.helper.SimpleItemTouchHelperCallback;
import com.domobile.dimobile_test.rate_exchange.model.RateExchangeModel;
import com.domobile.dimobile_test.rate_exchange.model.RateExchangeModelImpl;
import com.domobile.dimobile_test.rate_exchange.view.RateExchangeView;

public class RateExchangePresenterImpl
        implements RateExchangePresenter, OnStartDragListener
{
    private static final String TAG = "RateExchangePresenterIm";

    //view
    private RateExchangeView           mRateExchangeView;
    //model 接口
    private RateExchangeModel          mRateExchangeModel;
    private Context                    mContext;
    //回调
    private NetRequestListener<String> mRateExchangeBeansNetRequestListener;

    //拖动操作
    private ItemTouchHelper     mItemTouchHelper;
    private RecyclerListAdapter mRecyclerListAdapter;

    public RateExchangePresenterImpl(RateExchangeView rateExchangeView, Context context) {

        mRateExchangeView = rateExchangeView;
        mContext = context;
        mRateExchangeModel = new RateExchangeModelImpl();

        init();
    }

    public void init() {
        RecyclerView recyclerView = mRateExchangeView.getRecyclView();
        mRecyclerListAdapter = new RecyclerListAdapter(mContext, this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mRecyclerListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mRecyclerListAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void updateData() {
        String url = "https://api.fixer.io/latest";
        initNetRequestListener();
        if (null != mRateExchangeModel) {
            mRateExchangeModel.requestData(url, mRateExchangeBeansNetRequestListener);
        }
    }

    public void initNetRequestListener() {
        mRateExchangeBeansNetRequestListener = new NetRequestListener<String>() {
            @Override
            public void onSuccess(String response) {
                Log.i(TAG, "onSuccess-->" + response.toString());
                updateUI(response);
            }

            @Override
            public void onFailed(String message) {
                Log.i(TAG, "onFailed-->" + message);
            }
        };
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }

    /**
     * 刷新UI
     * @param data 数据
     */
    public void updateUI(String data) {
        RateExchangeBeans rateExchangeBeans = JSON.parseObject(data, RateExchangeBeans.class);
        if(null != mRecyclerListAdapter && null != rateExchangeBeans){
            mRecyclerListAdapter.setData(rateExchangeBeans.getRates());
        }
    }

    @Override
    public void cacheData() {
        if(null != mRecyclerListAdapter){
            mRecyclerListAdapter.saveCacheData();
        }
    }
}
