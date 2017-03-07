package com.overtimego.draco.overtimego;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/3/6 0006.
 */

public class TabBarCellView extends RelativeLayout {
    private ImageView imageView;
    private TextView textView;
    //右上角标
    private Button newsButton;

    private boolean isSelected;
    //角标数字
    private int newsNum = 0;

    private int unSelectedResId = 0;
    private int selectedResId = 0;

    public TabBarCellView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.tabbarcellview, this, true);
        imageView = (ImageView)findViewById(R.id.tab_bar_imageView);
        textView = (TextView)findViewById(R.id.tab_bar_textView);
        newsButton = (Button)findViewById(R.id.tab_bar_newsButton);
    }

    /**
     * 设置控件为选中状态
     */
    public void setSelected(){
        isSelected = true;
        //选中后操作
        //this.setBackgroundResource(R.color.tab_bar_bg_selected);
        this.textView.setTextColor(Color.rgb(0, 153, 255));
        if (selectedResId!=0) {
            this.imageView.setImageResource(selectedResId);
        }

    }

    /**
     * 取消控件的选中状态
     */
    public void disSelected(){
        isSelected = false;
        //取消选中后的操作
        //this.setBackgroundResource(R.color.tab_bar_bg_normal);
        this.textView.setTextColor(Color.rgb(147, 151, 157));
        if (unSelectedResId!=0) {
            this.imageView.setImageResource(unSelectedResId);
        }

    }

    /**
     * 获取控件的选中状态
     */
    public boolean isSelected() {
        return isSelected;
    }

    /**
     * 设置标题文本内容
     * @param text
     */
    public void setText(String text){
        textView.setText(text);
    }

    /**
     * 设置角标数字
     * @param newsNum
     */
    public void setNewsNum(int newsNum){
        if (newsNum>=100) {
            //大于99显示99
            this.newsNum = 99;
        }else{
            this.newsNum = newsNum;
        }

        if (this.newsNum>0) {
            //设置角标可见
            newsButton.setVisibility(View.INVISIBLE);
            //设置角标数字
            newsButton.setText(""+this.newsNum);
        }else{
            clearNews();
        }
    }

    /**
     * 清空角标
     */
    public void clearNews(){
        this.newsNum = 0;
        newsButton.setVisibility(View.INVISIBLE);
    }

    /**
     * 获取角标数字
     * @return
     */
    public int getNewsNum() {
        return newsNum;
    }

    public void setImageViewResource(int unSelectedResId, int selectedResId){
        if (unSelectedResId!=0) {
            imageView.setImageResource(unSelectedResId);
        }
        this.unSelectedResId = unSelectedResId;
        this.selectedResId = selectedResId;
    }

}
