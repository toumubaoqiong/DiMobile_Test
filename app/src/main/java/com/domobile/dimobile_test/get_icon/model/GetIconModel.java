package com.domobile.dimobile_test.get_icon.model;

/*
 *  @创建者:   zhua
 *  @创建时间:  2018/3/21 20:03
 *  @描述：    GetIconModel 接口类
 */

import com.domobile.dimobile_test.net_work_request.NetRequestListener;

public interface GetIconModel {

    //请求url对应的内容
    void requestForContent(String url, NetRequestListener netRequestListener);
}
