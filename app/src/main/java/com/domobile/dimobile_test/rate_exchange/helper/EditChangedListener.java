package com.domobile.dimobile_test.rate_exchange.helper;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

class EditChangedListener implements TextWatcher {
    private static final String TAG = "EditChangedListener";

    public EditChangedListener(int pos,EditChange editChange){
        mPos = pos;
        mEditChange = editChange;
    }

    private int mPos;
    private EditChange mEditChange;

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.i(TAG, "输入文本之前的状态-->" + s.toString());
    }
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.i(TAG, "输入文字中的状态，count是一次性输入字符数-->"  + s.toString());
    }
    @Override
    public void afterTextChanged(Editable s) {
        Log.i(TAG, "输入文字后的状态-->" + s.toString());
        if(null != mEditChange){
//            mEditChange.synchrodata(mPos, s.toString());
        }
    }

    public interface EditChange{
        void synchrodata(int pos, String content);
    }
};