package com.overtimego.draco.overtimego;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemBase extends Fragment {
    private String[] recvStrData;
    public ItemBase() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_base, container, false);
        initItemBaseCell("姓名","项目","时长");
        recvStrData =new String[3];
        return view;

    }
    public void initItemBaseCell(String title1,String title2,String title3){

        FragmentManager fragmentManager = this.getChildFragmentManager();
        ItemBaseCell fragment1 = (ItemBaseCell)fragmentManager.findFragmentById(R.id.fragment_item1);
        fragment1.setOnDataTransmissionListener(new ItemBaseCell.OnDataTransmissionListener(){
            @Override
            public void dataTransmission(String data) {
                Toast.makeText(getContext(),"A"+data,Toast.LENGTH_SHORT).show();
                recvStrData[0] = data;
            }
        });
        fragment1.setTitleName(title1);
        ItemBaseCell fragment2 = (ItemBaseCell)fragmentManager.findFragmentById(R.id.fragment_item2);
        fragment2.setOnDataTransmissionListener(new ItemBaseCell.OnDataTransmissionListener(){
            @Override
            public void dataTransmission(String data) {
                Toast.makeText(getContext(),"B"+data,Toast.LENGTH_SHORT).show();
                recvStrData[1] = data;
            }
        });
        fragment2.setTitleName(title2);
        ItemBaseCell fragment3 = (ItemBaseCell)fragmentManager.findFragmentById(R.id.fragment_item3);
        fragment3.setOnDataTransmissionListener(new ItemBaseCell.OnDataTransmissionListener(){
            @Override
            public void dataTransmission(String data) {
                Toast.makeText(getContext(),"C"+data,Toast.LENGTH_SHORT).show();
                recvStrData[2] = data;
            }
        });
        fragment3.setTitleName(title3);
    }
    public String[] getSettingData(){
        return recvStrData;
    }
}
