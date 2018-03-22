package com.domobile.dimobile_test.net_work_request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.domobile.dimobile_test.net_work_request.https.HTTPSTrustManager;

import java.util.Map;

/*
 *  @创建者:   zhua
 *  @创建时间:  2018/3/21 20:28
 *  @描述：    网络请求类
 */
public class NetWorkRequest {

    private static final String TAG = "NetWorkRequest";

    private static final String LOG_URL_IS_NULL          = "CREATE REQUEST FAILED, URL CAN NOT BE NULL";
    private static final String LOG_TAG_IS_NULL          = "CREATE REQUEST FAILED, TAG CAN NOT BE NULL";
    private static final String LOG_RESPONSE_NULL        = "REQUEST FAILED, RESPONSE IS NULL";
    private static final String LOG_RESPONSE_ERROR_NULL  = "REQUEST FAILED, NO ERROR LOG";
    //超时
    private static final int    NET_WORK_DEFAUL_TIME_OUT = 60000;

    // priority of request
    private static final int PRIORITY_HIGHEST = 0;
    private static final int PRIORITY_HIGH    = 1;
    public static final int PRIORITY_NORMAL  = 2;
    private static final int PRIORITY_LOW     = 3;

    private static NetWorkRequest mNetWorkRequest;
    private static final Object mObjLock = new Object();

    private RequestQueue mQueue;

    public static NetWorkRequest getInstance(Context context) {
        if (mNetWorkRequest == null) {
            synchronized (mObjLock) {
                if (null == mNetWorkRequest) {
                    mNetWorkRequest = new NetWorkRequest(context);
                }
            }
        }
        return mNetWorkRequest;
    }

    private NetWorkRequest(Context context) {
        //信任所有证书
        HTTPSTrustManager.allowAllSSL();
        mQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public void getNormal(final String url,
                          final int priority,
                          final String tag,
                          final Map headers,
                          final NetRequestListener<String> listener)
    {

        if (url == null) {
            listener.onFailed(LOG_URL_IS_NULL);
            return;
        }
        if (TextUtils.isEmpty(tag)) {
            listener.onFailed(LOG_TAG_IS_NULL);
            return;
        }

        StringRequest request = new StringRequest(Request.Method.GET,
                                                  url,
                                                  new Response.Listener<String>() {
                                                      @Override
                                                      public void onResponse(String response) {
                                                          if (response == null) {
                                                              listener.onFailed(LOG_RESPONSE_NULL);
                                                          } else {
                                                              listener.onSuccess(response);
                                                          }
                                                      }
                                                  },
                                                  new Response.ErrorListener() {
                                                      @Override
                                                      public void onErrorResponse(VolleyError error) {
                                                          if (error == null) {
                                                              listener.onFailed(
                                                                      LOG_RESPONSE_ERROR_NULL);
                                                          } else {
                                                              Log.i("zhua", error.toString());
                                                              listener.onFailed(error.getMessage());
                                                          }
                                                      }
                                                  })
        {
            @Override
            public Priority getPriority() {
                return getTaskPriority(priority);
            }

            @Override
            public Map<String, String> getHeaders()
                    throws AuthFailureError
            {
                if(null != headers){
                    return headers;
                }

                return super.getHeaders();
            }
        };

        request.setTag(tag);
        request.setShouldCache(false);
        request.setRetryPolicy(new DefaultRetryPolicy(NET_WORK_DEFAUL_TIME_OUT,
                                                      DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                                                      DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        mQueue.add(request);
    }

    /**
     * 获取优先级
     * @param priority tag
     * @return 优先级
     */
    private Request.Priority getTaskPriority(final int priority) {
        if (priority == PRIORITY_HIGHEST) {
            return Request.Priority.IMMEDIATE;
        } else if (priority == PRIORITY_HIGH) {
            return Request.Priority.HIGH;
        } else if (priority == PRIORITY_NORMAL) {
            return Request.Priority.NORMAL;
        } else if (priority == PRIORITY_LOW) {
            return Request.Priority.LOW;
        } else {
            return Request.Priority.NORMAL;
        }
    }


}
