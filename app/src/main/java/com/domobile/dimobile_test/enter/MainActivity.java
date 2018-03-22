package com.domobile.dimobile_test.enter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.domobile.dimobile_test.R;
import com.domobile.dimobile_test.get_icon.view.GetIconActivity;
import com.domobile.dimobile_test.rate_exchange.view.RateExchangeActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity
        extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.Button_GetIcon ,R.id.Button_RateExchange})
    public void click(View view) {

        if(view.getId() == R.id.Button_GetIcon ){
            Intent intent = new Intent(this, GetIconActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, RateExchangeActivity.class);
            startActivity(intent);
        }
    }
}
