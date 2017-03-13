package com.overtimego.draco.overtimego;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/3/7.
 */

public class UserTitleBar extends LinearLayout {
    private TextView titleTv;
    public UserTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.usertitlebar, this, true);
        titleTv = (TextView)findViewById(R.id.title_text);
    }
    public void SetTitleText(String strTitle){
        titleTv.setText(strTitle);
    }
}
