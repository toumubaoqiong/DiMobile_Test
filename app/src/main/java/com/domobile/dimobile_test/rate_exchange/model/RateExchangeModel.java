package com.domobile.dimobile_test.rate_exchange.model;

import com.domobile.dimobile_test.net_work_request.NetRequestListener;

/*
 *  @创建者:   zhua
 *  @创建时间:  2018/3/21 21:28
 *  @描述：    Model 接口类
 */
public interface RateExchangeModel {

    //请求最新数据
    void requestData(String url, NetRequestListener<String> rateExchangeBeansNetRequestListener);

}
