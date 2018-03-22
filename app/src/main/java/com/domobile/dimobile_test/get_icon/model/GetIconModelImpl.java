package com.domobile.dimobile_test.get_icon.model;

/*
 *  @创建者:   zhua
 *  @创建时间:  2018/3/21 20:03
 *  @描述：    GetIconModel实现类
 */

import com.domobile.dimobile_test.AppManager;
import com.domobile.dimobile_test.net_work_request.NetRequestListener;
import com.domobile.dimobile_test.net_work_request.NetWorkRequest;

import java.util.HashMap;
import java.util.Map;

import static com.domobile.dimobile_test.net_work_request.NetWorkRequest.PRIORITY_NORMAL;

public class GetIconModelImpl
        implements GetIconModel
{
    private static final String TAG = "GetIconModelImpl";

    @Override
    public void requestForContent(String url, NetRequestListener netRequestListener) {

        Map headers = new HashMap<String,String>();
        headers.put("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_3 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like Gecko) Version/10.3 Mobile/14E277 Safari/603.1.30");
        NetWorkRequest.getInstance(AppManager.getAppManager()).getNormal(url, PRIORITY_NORMAL, TAG, headers, netRequestListener);
    }
}
