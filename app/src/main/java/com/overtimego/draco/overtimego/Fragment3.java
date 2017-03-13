package com.overtimego.draco.overtimego;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {

    private Button btnGo;
    private Switch switchByCar;
    private String strByCarState;
    private ItemBase fragmItemBase;
    public Fragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = (View)inflater.inflate(R.layout.fragment3,container,false);
        btnGo = (Button)view.findViewById(R.id.fragment3_button_commit);
        switchByCar = (Switch)view.findViewById(R.id.fragment3_switch);

        final FragmentManager fragmentManager = this.getChildFragmentManager();
        fragmItemBase = (ItemBase)fragmentManager.findFragmentById(R.id.fragment_item);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickBtnGo();
            }
        });
        return view;

    }
    public void clickBtnGo(){
        if (switchByCar.isChecked()){
            strByCarState = "是";
        }else{
            strByCarState = "否";
        }
        String[] strData = fragmItemBase.getSettingData();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("报加班");
        builder.setMessage("[姓名]："+strData[0]+"\n"+"[项目]："+strData[1]+"\n"+"[时长]："+strData[2]+"\n"+"[是否坐班车]："+strByCarState);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //  Toast.makeText(MainActivity.this,"你输入"+editText.getText().toString(),Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("取消",null);
        builder.show();
    }

}
