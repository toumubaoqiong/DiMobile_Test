/*
 * Copyright (C) 2015 Paul Burke
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.domobile.dimobile_test.rate_exchange.helper;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.domobile.dimobile_test.AppManager;
import com.domobile.dimobile_test.R;
import com.domobile.dimobile_test.rate_exchange.beans.RateExchangeBeans;
import com.domobile.dimobile_test.utils.UserPreferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Simple RecyclerView.Adapter that implements {@link ItemTouchHelperAdapter} to respond to move and
 * dismiss events from a {@link android.support.v7.widget.helper.ItemTouchHelper}.
 *
 * @author Paul Burke (ipaulpro)
 */
public class RecyclerListAdapter
        extends RecyclerView.Adapter<RecyclerListAdapter.ItemViewHolder>
        implements ItemTouchHelperAdapter, EditChangedListener.EditChange
{

    private List<String> mKeys;
    private List<Double> mValues;

    private final OnStartDragListener mDragStartListener;

    public RecyclerListAdapter(Context context, OnStartDragListener dragStartListener) {
        mDragStartListener = dragStartListener;
        getCachedData();
        if(mKeys == null || mValues == null){
            mKeys =  new ArrayList<>();
            mValues =  new ArrayList<>();
        }
//        mItems.addAll(Arrays.asList(context.getResources().getStringArray(R.array.dummy_items)));
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View           view           = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        holder.textView.setText(mKeys.get(position));
        holder.editText.setText(String.valueOf(mValues.get(position)));

        // Start a drag whenever the handle view it touched
        /*holder.handleView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    mDragStartListener.onStartDrag(holder);
                }
                return false;
            }
        });*/

        holder.editText.setFocusable(false);

        holder.editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                v.requestFocus();
                v.findFocus();
            }
        });

        holder.editText.addTextChangedListener(new EditChangedListener(position,this));
    }

    @Override
    public void onItemDismiss(int position) {
        mValues.remove(position);
        mKeys.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mKeys, fromPosition, toPosition);
        Collections.swap(mValues, fromPosition, toPosition);
        Log.i("zhua","Keys-->" + mKeys.toString());
        Log.i("zhua", "Values-->" + mValues.toString());
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public int getItemCount() {

        if(null != mKeys && null != mValues){
            int keySize = mKeys.size();
            int valueSize = mValues.size();
            if(keySize == valueSize){
                return keySize;
            }
        }

        return 0;
    }

    /**
     * Simple example of a view holder that implements {@link ItemTouchHelperViewHolder} and has a
     * "handle" view that initiates a drag event when touched.
     */
    public static class ItemViewHolder extends RecyclerView.ViewHolder implements
                                                                       ItemTouchHelperViewHolder
    {
        @BindView(R.id.text)
        public TextView textView;
//        public final ImageView handleView;
        @BindView(R.id.EditText_Nume)
        public EditText editText;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
//            textView = itemView.findViewById(R.id.text);
//            handleView = (ImageView) itemView.findViewById(R.id.handle);
//            editText = itemView.findViewById(R.id.EditText_Nume);
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }
    }

    /**
     * 将获取的数据转换为list显示格式的数据
     * @param data 原数据
     */
    public void setData(RateExchangeBeans.RatesBean data){
        if(null == data){
            return;
        }

        mKeys.clear();
        mValues.clear();

        if(0 != data.getAUD()){
            mKeys.add("AUD");
            mValues.add(data.getAUD());
        }

        if(0 != data.getBGN()){
            mKeys.add("BGN");
            mValues.add(data.getBGN());
        }

        if(0 != data.getBRL()){
            mKeys.add("BRL");
            mValues.add(data.getBRL());
        }

        if(0 != data.getCAD()){
            mKeys.add("CAD");
            mValues.add(data.getCAD());
        }

        if(0 != data.getCHF()){
            mKeys.add("CHF");
            mValues.add(data.getCHF());
        }

        if(0 != data.getCNY()){
            mKeys.add("CNY");
            mValues.add(data.getCNY());
        }

        if(0 != data.getCZK()){
            mKeys.add("CZK");
            mValues.add(data.getCZK());
        }

        if(0 != data.getDKK()){
            mKeys.add("DKK");
            mValues.add(data.getDKK());
        }

        if(0 != data.getGBP()){
            mKeys.add("GBP");
            mValues.add(data.getGBP());
        }

        if(0 != data.getHKD()){
            mKeys.add("HKD");
            mValues.add(data.getHKD());
        }

        if(0 != data.getHRK()){
            mKeys.add("HRK");
            mValues.add(data.getHRK());
        }

        if(0 != data.getHUF()){
            mKeys.add("HUF");
            mValues.add(data.getHUF());
        }

        if(0 != data.getIDR()){
            mKeys.add("IDR");
            mValues.add(data.getIDR());
        }

        if(0 != data.getILS()){
            mKeys.add("ILS");
            mValues.add(data.getILS());
        }

        if(0 != data.getINR()){
            mKeys.add("INR");
            mValues.add(data.getINR());
        }

        if(0 != data.getISK()){
            mKeys.add("ISK");
            mValues.add(data.getISK());
        }

        if(0 != data.getJPY()){
            mKeys.add("JPY");
            mValues.add(data.getJPY());
        }

        if(0 != data.getKRW()){
            mKeys.add("KRW");
            mValues.add(data.getKRW());
        }

        if(0 != data.getMXN()){
            mKeys.add("MXN");
            mValues.add(data.getMXN());
        }

        if(0 != data.getMYR()){
            mKeys.add("MYR");
            mValues.add(data.getMYR());
        }

        if(0 != data.getNOK()){
            mKeys.add("NOK");
            mValues.add(data.getNOK());
        }

        if(0 != data.getNZD()){
            mKeys.add("NZD");
            mValues.add(data.getNZD());
        }

        if(0 != data.getPHP()){
            mKeys.add("PHP");
            mValues.add(data.getPHP());
        }

        if(0 != data.getPLN()){
            mKeys.add("PLN");
            mValues.add(data.getPLN());
        }

        if(0 != data.getRON()){
            mKeys.add("RON");
            mValues.add(data.getRON());
        }

        if(0 != data.getRUB()){
            mKeys.add("RUB");
            mValues.add(data.getRUB());
        }

        if(0 != data.getSEK()){
            mKeys.add("SEK");
            mValues.add(data.getSEK());
        }

        if(0 != data.getSGD()){
            mKeys.add("SGD");
            mValues.add(data.getSGD());
        }

        if(0 != data.getTHB()){
            mKeys.add("THB");
            mValues.add(data.getTHB());
        }

        if(0 != data.getTRY()){
            mKeys.add("TRY");
            mValues.add(data.getTRY());
        }

        if(0 != data.getUSD()){
            mKeys.add("USD");
            mValues.add(data.getUSD());
        }

        if(0 != data.getZAR()){
            mKeys.add("ZAR");
            mValues.add(data.getZAR());
        }

        notifyDataSetChanged();
    }

    /**
     * 缓存数据
    */
    public void saveCacheData(){
        if(null != mKeys && !mKeys.isEmpty()){
            UserPreferences.saveString(AppManager.getAppManager(), "keys_data", JSON.toJSONString(mKeys));
        }

        if(null != mValues && !mValues.isEmpty()){
            UserPreferences.saveString(AppManager.getAppManager(), "values_data", JSON.toJSONString(mValues));
        }
    }

    /**
     * 获取缓存数据
     */
    public void getCachedData(){
        String keys = UserPreferences.loadString(AppManager.getAppManager(), "keys_data", "");
        String values = UserPreferences.loadString(AppManager.getAppManager(), "values_data", "");

        if(!TextUtils.isEmpty(keys) && !TextUtils.isEmpty(values)){
            mKeys = JSON.parseArray(keys, String.class);
            mValues = JSON.parseArray(values, Double.class);
        }
    }

    @Override
    public void synchrodata(int pos, String content) {
        double oldValue = mValues.get(pos);
        double currentValue = mValues.get(pos);
        double times = oldValue/currentValue;
        mValues.add(pos, currentValue);
        for(int i = 0;i < mValues.size();i++){
            if(i == pos){
                continue;
            }
            mValues.add(i,mValues.get(i) * times);

            notifyItemChanged(i);
        }
    }
}
