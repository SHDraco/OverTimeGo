package com.overtimego.draco.overtimego;


import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemBaseCell extends Fragment {

    private ArrayAdapter<String> adapter;
    private ListView listView;
    private EditText editText;
    private TextView tvTitle;
    private List<String> data = new ArrayList<>();
    private OnDataTransmissionListener mListener;
    private int inasd;
    Handler handler;
    public ItemBaseCell() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_base_cell, container, false);
        Button buttonAdd = (Button)view.findViewById(R.id.button_item_cell_add);
        buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addListData("");
            }
        });
        listView = (ListView)view.findViewById(R.id.item_listview);
        editText = (EditText)view.findViewById(R.id.et_content);
        tvTitle = (TextView)view.findViewById(R.id.item_title);
        inasd = 0;
        initListData();

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Adapter adapter = adapterView.getAdapter();
                String str = adapter.getItem(i).toString();
                delListData(str,i);
             //   return false;   // 会执行setOnItemClickListener
                return true;    //不会执行
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Adapter adapter = adapterView.getAdapter();
                String str = adapter.getItem(i).toString();
               // Toast.makeText(getContext(),"点击第"+i+"个",Toast.LENGTH_SHORT).show();
                editText.setText(str);
                if (mListener!= null){
                    mListener.dataTransmission(str);
                }
            }
        });
        /*
        listView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
               // contextMenu.setHeaderTitle("长安菜单");
              //  contextMenu.add(0,0,0,"弹出长按菜单0");
               // contextMenu.add(0,1,0,"弹出长按菜单1");

            }
        });*/

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        break;
                    default:
                        break;

                }
            }
        };
        return view;
    }

    public boolean onContextItemSelected(MenuItem item){
        return ItemBaseCell.super.onContextItemSelected(item);
    }
    private void addListData(String strData){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("添加常用项");
        builder.setMessage("输入内容");
        final EditText editText = new EditText(getActivity());
        builder.setView(editText);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //  Toast.makeText(MainActivity.this,"你输入"+editText.getText().toString(),Toast.LENGTH_SHORT).show();
                data.add(editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("取消",null);
        builder.show();
    }
    private void delListData(String strData,final int arg){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("添加常用项");
        builder.setMessage("是否删除"+strData);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //  Toast.makeText(MainActivity.this,"你输入"+editText.getText().toString(),Toast.LENGTH_SHORT).show();
                data.remove(arg);
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("取消",null);
        builder.show();
    }

    private void initListData(){
        this.data = data;
        for(int i=0;i<5;i++){
            this.data.add(i+"");
        }
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,this.data);
        listView.setAdapter(adapter);
    }
    public interface OnDataTransmissionListener{
        public void dataTransmission(String data);
    }
    public void setOnDataTransmissionListener(OnDataTransmissionListener listener){
        this.mListener = listener;
    }

    public void setTitleName(String strTitleName){
        if (tvTitle!=null){
            tvTitle.setText(strTitleName);
        }
    }
    public String getTitleName(){
        if (tvTitle!=null){
            return (String)tvTitle.getText();
        }
        return "";
    }
}
