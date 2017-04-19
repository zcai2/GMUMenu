package com.example.yuanyuangao.myapplication;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
//import android.widget.ImageButton;
import android.widget.Button;
import android.widget.ImageButton;
import 	android.widget.TextView;
import android.widget.Button;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity {

    private ImageButton button1;
    private ImageButton button2;
    private TextView test;
    private int ID;
    public static ArrayList<TypedArray> imagelist= new ArrayList<TypedArray>();


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_menu);
            imagelist.add(getResources().obtainTypedArray(R.array.wingszone_image));
            imagelist.add(getResources().obtainTypedArray(R.array.pandaexpress_image));
            // 获取Button按钮
            button1 = (ImageButton) findViewById(R.id.button1);
            button2 = (ImageButton) findViewById(R.id.button2);
            // 添加Button事件，当点击此按钮，进行页面的跳转
            button1.setOnClickListener(listener1);
            button2.setOnClickListener(listener1);

        }

        private OnClickListener listener1 = new OnClickListener() {

            @Override
            public void onClick(View v) {
                // 创建Intent对象
                switch(v.getId()) {
                    case R.id.button1:
                        gmudining.currentindex=0;
                        break;
                    case R.id.button2:
                        gmudining.currentindex=1;
                        break;
                }

                Intent intent = new Intent();
                // 设置要跳转的页面
                intent.setClass(MainMenu.this, Resturant.class);
                // 开始Activity

                //test.setText("aa");
                startActivity(intent);
            }
        };

    }

