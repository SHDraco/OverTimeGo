package com.overtimego.draco.overtimego;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    private CustomViewPager viewPager;
    private TabBarView tabBarView;
    private UserTitleBar userTitleBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去除标题栏
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        viewPager = (CustomViewPager) findViewById(R.id.main_viewpager);
        tabBarView = (TabBarView)findViewById(R.id.home_tabBarView);
        userTitleBar = (UserTitleBar)findViewById(R.id.main_title);

        tabBarView.setTabBarCellData(0, R.mipmap.icon_vip_level_1, R.mipmap.icon_vip_level_2, "页卡1");
        tabBarView.setTabBarCellData(1, R.mipmap.icon_vip_level_1, R.mipmap.icon_vip_level_2, "页卡2");
        tabBarView.setTabBarCellData(2, R.mipmap.icon_vip_level_1, R.mipmap.icon_vip_level_2, "页卡3");
        tabBarView.setTabBarCellData(3, R.mipmap.icon_vip_level_1, R.mipmap.icon_vip_level_2, "页卡4");
        tabBarView.setSelected(0);

        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);

        select(0);

        tabBarView.setOnTabBarSelectedListener(new TabBarView.OnTabBarSelectedListener() {

            @Override
            public void onCellSelected(int index) {
                select(index);
            }
        });
    }
    /***
     * 选中后的处理
     */
    public void select(int index) {

        viewPager.setCurrentItem(index);
        tabBarView.setSelected(index);

    }

    public class FragmentAdapter extends FragmentPagerAdapter {
        public final static int TAB_COUNT = 4;
        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int id) {
            switch (id) {
                case 0:
                    return new Fragment3();
                case 1:
                    return new Fragment1();
                case 2:
                    return new Fragment4();
                case 3:
                    return new Fragment2();
            }
            return null;
        }

        @Override
        public int getCount() {
            return TAB_COUNT;
        }
    }
}
