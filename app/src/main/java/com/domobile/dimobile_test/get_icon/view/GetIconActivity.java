package com.domobile.dimobile_test.get_icon.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.domobile.dimobile_test.R;
import com.domobile.dimobile_test.get_icon.presenter.GetIconPresenter;
import com.domobile.dimobile_test.get_icon.presenter.GetIconPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GetIconActivity
        extends AppCompatActivity
        implements GetIconView
{
    @BindView(R.id.ImageView_img)
    public ImageView        mImageView;
    @BindView(R.id.EditText_input)
    public EditText         mEditText;

    private GetIconPresenter mGetIconPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_icon);
        ButterKnife.bind(this);
        mGetIconPresenter = new GetIconPresenterImpl(this, this);
    }

    @Override
    public String getEditTextContent() {
        return mEditText.getText()
                        .toString();
    }

    @Override
    public void showIcon(String url) {
        if (!TextUtils.isEmpty(url)) {
            Glide.with(this)
                 .load(url)
                 .into(mImageView);
        }
    }

    @OnClick(R.id.Button_analyze)
    public void analyze(View view) {
        if(null != mGetIconPresenter){
            mGetIconPresenter.analyzeUrlToIcon();
        }
    }
}
