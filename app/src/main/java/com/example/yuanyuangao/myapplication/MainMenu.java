package com.example.yuanyuangao.myapplication;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import 	android.widget.TextView;


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
            // get button
            button1 = (ImageButton) findViewById(R.id.button1);
            button2 = (ImageButton) findViewById(R.id.button2);
            // add button event
            button1.setOnClickListener(listener1);
            button2.setOnClickListener(listener1);

        }

        private OnClickListener listener1 = new OnClickListener() {

            @Override
            public void onClick(View v) {
                // intent object
                switch(v.getId()) {
                    case R.id.button1:
                        gmudining.currentindex=0;
                        break;
                    case R.id.button2:
                        gmudining.currentindex=1;
                        break;
                }

                Intent intent = new Intent();
                // jump to another page
                intent.setClass(MainMenu.this, Resturant.class);


                startActivity(intent);
            }
        };

    }

