package com.overtimego.draco.overtimego;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends ListFragment {


    public Fragment1() {
        // Required empty public constructor
    }

    private List<Map<String,Object>> getData(){
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("title","today overtime");
        map.put("info1","张三");
        map.put("info2","asdadad");
        map.put("info3","4H");
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","yestoday overtime");
        map.put("info","李四 也不知道什么项目反正就是要报个加班 10.0h");
        map.put("info1","李四");
        map.put("info2","也不知道什么项目反正就是要报个加班");
        map.put("info3","0h");
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","yestoday overtime");
        map.put("info","李四 也不知道什么项目反正就是要报个加班 10.0h");
        map.put("info1","李四");
        map.put("info2","也不知道什么项目反正就是要报个加班");
        map.put("info3","0h");
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","yestoday overtime");
        map.put("info","李四 也不知道什么项目反正就是要报个加班 10.0h");
        map.put("info1","李四");
        map.put("info2","也不知道什么项目反正就是要报个加班");
        map.put("info3","0h");
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","yestoday overtime");
        map.put("info","李四 也不知道什么项目反正就是要报个加班 10.0h");
        map.put("info1","李四");
        map.put("info2","也不知道什么项目反正就是要报个加班");
        map.put("info3","0h");
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","yestoday overtime");
        map.put("info","李四 也不知道什么项目反正就是要报个加班 10.0h");
        map.put("info1","李四");
        map.put("info2","也不知道什么项目反正就是要报个加班");
        map.put("info3","0h");
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","yestoday overtime");
        map.put("info","李四 也不知道什么项目反正就是要报个加班 10.0h");
        map.put("info1","李四");
        map.put("info2","也不知道什么项目反正就是要报个加班");
        map.put("info3","0h");
        list.add(map);
        return list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        SimpleAdapter adapter = new SimpleAdapter(getActivity(),getData(),R.layout.userstate, new String[]{"title","info1","info2","info3"},
                new int[]{R.id.userstate_tv_title,R.id.userstate_tv_info1,R.id.userstate_tv_info2,R.id.userstate_tv_info3});
        // SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.fragment1,new String[]{"title","info"}, new int[]{R.id.title_tv,R.id.info_tv);
        setListAdapter(adapter);
        return inflater.inflate(R.layout.fragment1, container, false);
    }

}
