package com.domobile.dimobile_test.get_icon.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.domobile.dimobile_test.net_work_request.NetRequestListener;
import com.domobile.dimobile_test.get_icon.model.GetIconModel;
import com.domobile.dimobile_test.get_icon.model.GetIconModelImpl;
import com.domobile.dimobile_test.get_icon.view.GetIconView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hugo.weaving.DebugLog;

/*
 *  @创建者:   zhua
 *  @创建时间:  2018/3/21 20:00
 *  @描述：    presenter实现类
 */
public class GetIconPresenterImpl implements GetIconPresenter{

    private static final String TAG = "GetIconPresenterImpl";
    
    //view 接口类
    private GetIconView  mGetIconView;
    //model接口类
    private GetIconModel mGetIconModel;
    //回调接口
    private NetRequestListener<String> mStringNetRequestListener;

    private Context mContext;

    public GetIconPresenterImpl(GetIconView getIconView, Context context){
        mGetIconView = getIconView;
        mGetIconModel = new GetIconModelImpl();
        mContext = context;
    }

    @Override
    public void analyzeUrlToIcon() {
        initNetRequestListener();
        String url = null;
        if(null != mGetIconView){
            url = mGetIconView.getEditTextContent();
        }

        if(TextUtils.isEmpty(url)){//默认值
            url  = "https://tieba.baidu.com";
//            url  = "https://m.taobao.com";
        }

        if(!url.contains("https")){
            Log.i(TAG, url);
            Toast.makeText(mContext, "url 非法,请重新输入" , Toast.LENGTH_SHORT).show();
        }

        if(null != mGetIconModel){
            mGetIconModel.requestForContent(url, mStringNetRequestListener);
        }
    }

    /**
     * 初始化网络回调
     */
    private void initNetRequestListener(){

        if(null == mStringNetRequestListener){
            mStringNetRequestListener = new NetRequestListener<String>() {
                @Override
                public void onSuccess(String response) {
                    Log.i(TAG, "onSuccess-->" + response);
                    showIcon(response);
                }

                @Override
                public void onFailed(String message) {
                    Log.i(TAG, "onFailed-->" + message);
                }
            };
        }
    }

    @DebugLog
    private void showIcon(String content){
        Pattern pattern = Pattern.compile("rel=\"apple-touch-icon-precomposed\"\\s+href=\".*?\\.png");
        Matcher matcher = pattern.matcher(content);

        if(matcher.find()){
            if(null != mGetIconView){
                String url = "https://" + matcher.group().split("//")[1];

                Log.i(TAG, "onSuccess_url-->" + url);
                mGetIconView.showIcon(url);
            }
        }
    }

}
