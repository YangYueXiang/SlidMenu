package com.boe.slidmenu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle drawerbar;
    private DrawerLayout main_drawer_layout;
    private LinearLayout main_left_drawer_layout;//左侧滑动栏
    private ListView listview;
    private ArrayList<String> list;
    private MyListAdapter myListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initView(){
        main_drawer_layout = findViewById(R.id.main_drawer_layout);
        //左边菜单
        main_left_drawer_layout = findViewById(R.id.main_left_drawer_layout);
        listview = findViewById(R.id.listview);
        //设置菜单内容之外其他区域的背景色
        main_drawer_layout.setScrimColor(getResources().getColor(R.color.color));
    }

    //设置开关监听
    private void initEvent(){
        drawerbar = new ActionBarDrawerToggle(this,main_drawer_layout,R.string.open,R.string.close);
        main_drawer_layout.setDrawerListener(drawerbar);
        //list设置数据，并点击选中变色
        list = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            list.add("展厅"+i);
        }
    /*    myListAdapter = new MyListAdapter(this,list);
        listview.setAdapter(myListAdapter);*/
    }

    //左边菜单开关事件
    public void openLeftLayout(View view){
        if (main_drawer_layout.isDrawerOpen(main_left_drawer_layout)) {
            main_drawer_layout.closeDrawer(main_left_drawer_layout);
        } else {
            main_drawer_layout.openDrawer(main_left_drawer_layout);
        }
    }
}
