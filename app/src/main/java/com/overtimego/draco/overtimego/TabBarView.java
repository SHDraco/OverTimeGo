package com.overtimego.draco.overtimego;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/3/6 0006.
 */

public class TabBarView extends LinearLayout {
    private TabBarCellView[] tabBarCellViews;

    /**
     * 默认选中的单元序号
     */
    private int defaultSelectedIndex = 0;

    private OnTabBarSelectedListener onTabBarSelectedListener;

    public TabBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.tabbarview, this, true);
        tabBarCellViews = new TabBarCellView[4];
        tabBarCellViews[0] = (TabBarCellView)findViewById(R.id.tabBarCellView0);
        tabBarCellViews[1] = (TabBarCellView)findViewById(R.id.tabBarCellView1);
        tabBarCellViews[2] = (TabBarCellView)findViewById(R.id.tabBarCellView2);
        tabBarCellViews[3] = (TabBarCellView)findViewById(R.id.tabBarCellView3);



        //设置cell监听
        for (int i = 0; i < tabBarCellViews.length; i++) {
            final int j = i;
            tabBarCellViews[i].setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (onTabBarSelectedListener!=null) {
                        onTabBarSelectedListener.onCellSelected(j);
                    }
                }
            });
        }


        setSelected(defaultSelectedIndex);
    }


    public void setTabBarCellData(int index, int resIdNormal, int resIdSelected, String title){
        if (index>=0&&index<4) {
            tabBarCellViews[index].setImageViewResource(resIdNormal, resIdSelected);
            tabBarCellViews[index].setText(title);
        }

    }

    /**
     * 设置第index个单元被选中
     * @param index [0,4)
     */
    public void setSelected(int index){
        if (index>=0&&index<4) {
            for (int i = 0; i < tabBarCellViews.length; i++) {
                if (index!=i) {
                    tabBarCellViews[i].disSelected();
                }
            }
            tabBarCellViews[index].setSelected();
        }
    }

    /**
     * 设置默认选中的单元
     * @param defaultSelectedIndex 单元序号
     */
    public void setDefaultSelectedIndex(int defaultSelectedIndex) {
        this.defaultSelectedIndex = defaultSelectedIndex;
    }

    /**
     * 设置tabBar事件监听
     * @param onTabBarSelectedListener
     */
    public void setOnTabBarSelectedListener(OnTabBarSelectedListener onTabBarSelectedListener) {
        this.onTabBarSelectedListener = onTabBarSelectedListener;
    }

    public interface OnTabBarSelectedListener{
        /**
         * 当某个单元被选中
         * @param index
         */
        public void onCellSelected(int index);
    }
}
