package com.domobile.dimobile_test.rate_exchange.model;


import com.domobile.dimobile_test.AppManager;
import com.domobile.dimobile_test.net_work_request.NetRequestListener;
import com.domobile.dimobile_test.net_work_request.NetWorkRequest;

/*
 *  @创建者:   zhua
 *  @创建时间:  2018/3/21 21:29
 *  @描述：    Model 实现类
 */
public class RateExchangeModelImpl
        implements RateExchangeModel
{
    private static final String TAG = "RateExchangeModelImpl";

    @Override
    public void requestData(String url, NetRequestListener<String> rateExchangeBeansNetRequestListener) {
        NetWorkRequest.getInstance(AppManager.getAppManager()).getNormal(url, NetWorkRequest.PRIORITY_NORMAL, TAG, null, rateExchangeBeansNetRequestListener);
    }
}
