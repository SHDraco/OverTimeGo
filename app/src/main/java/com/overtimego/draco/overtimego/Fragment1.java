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
        map.put("info","2.0h");
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","yestoday overtime");
        map.put("info","1.5h");
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","2015/6/6");
        map.put("info","1.7h");
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","yestoday overtime");
        map.put("info","1.5h");
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","2015/6/6");
        map.put("info","1.7h");
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","yestoday overtime");
        map.put("info","1.5h");
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","2015/6/6");
        map.put("info","1.7h");
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","yestoday overtime");
        map.put("info","1.5h");
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","2015/6/6");
        map.put("info","1.7h");
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","yestoday overtime");
        map.put("info","1.5h");
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","2015/6/6");
        map.put("info","1.7h");
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","yestoday overtime");
        map.put("info","1.5h");
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","2015/6/6");
        map.put("info","1.7h");
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","yestoday overtime");
        map.put("info","1.5h");
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","2015/6/6");
        map.put("info","1.7h");
        list.add(map);
        return list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        SimpleAdapter adapter = new SimpleAdapter(getActivity(),getData(),R.layout.userstate, new String[]{"title","info"}, new int[]{R.id.title_tv,R.id.info_tv});
        // SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.fragment1,new String[]{"title","info"}, new int[]{R.id.title_tv,R.id.info_tv);
        setListAdapter(adapter);
        return inflater.inflate(R.layout.fragment1, container, false);
    }

}
