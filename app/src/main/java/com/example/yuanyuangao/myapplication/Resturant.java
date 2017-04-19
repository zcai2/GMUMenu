package com.example.yuanyuangao.myapplication;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import 	android.widget.Spinner;
import 	android.widget.ArrayAdapter;


public class Resturant extends AppCompatActivity {
    private TextView name;
    private TextView hour;
    private TextView food;
    private Button button;
    private Button mapbutton;
    private ArrayList<food> mData = null;
    private ImageView itemImage;
    private ImageView mapImage;
   // private ImageView itemImage2;
    private TypedArray images;
    private TypedArray maplist;
    private int ID=0;



   // public Rest wingzone= dining.dininglist.get(0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturant);
        gmudining dining= new gmudining(test());
        ID=gmudining.currentindex;
        final Rest testcase= dining.getinformation(ID);
        name= (TextView) findViewById(R.id.name);
        hour= (TextView) findViewById(R.id.hour);
        itemImage = (ImageView)findViewById(R.id.imageView);
        mapImage = (ImageView)findViewById(R.id.mapImage);
        maplist =getResources().obtainTypedArray(R.array.map_image);
        mapImage.setImageResource(maplist.getResourceId(ID, -1));
        images = MainMenu.imagelist.get(ID);
     //   itemImage.setImageResource(images.getResourceId(s.getSelectedItemPosition(), -1));
       // food= (TextView) findViewById(R.id.food);
        name.setText(testcase.getname());
        hour.setText(testcase.gethour());
       // food.setText(testcase.getfood());
        mData = new ArrayList<food>();


        for(int j=0;j<testcase.footlist.size();j++) {
            mData.add(testcase.footlist.get(j));
        }
        final Spinner s = (Spinner)findViewById(R.id.spinner);
       // s.setPrompt("Select your favorite Planet!");//获取下拉列表ID

        //将数组添加到ArrayList中
        ArrayAdapter x = new ArrayAdapter(this,android.R.layout.simple_spinner_item,mData);
        //创建和上面已建好的ArrayList相关联的ArrayAdapter，并且设置系统默认样式，第一个参数为上下文，第二参数为系统默认样式，第三个参数为ArrayList实例。
        x.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//设置下拉列表的拉下来的样式。
        s.setAdapter(x);//将此数组解析器ArrayAdapter绑定在已创建好的下拉列表上。

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                itemImage.setImageResource(images.getResourceId(s.getSelectedItemPosition(), -1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        button = (Button) findViewById(R.id.back);
      //  mapbutton = (Button) findViewById(R.id.mapbutton);


        // 添加Button事件，当点击此按钮，进行页面的跳转
        button.setOnClickListener(listener);
    //    mapbutton.setOnClickListener(listener1);

    }
    public ArrayList<String> test()
    {
        BufferedReader reader = null;
        ArrayList<String> obj = new ArrayList<String>();
        try {

            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("information.txt")));

            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                obj.add(mLine);

            }

        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
        return obj;

    }
    private View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // 创建Intent对象
            Intent intent = new Intent();
            // 设置要跳转的页面
            intent.setClass(Resturant.this, MainMenu.class);
            // 开始Activity

            //test.setText("aa");
            startActivity(intent);
        }
    };
    private View.OnClickListener listener1 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // 创建Intent对象
            Intent intent = new Intent();
            // 设置要跳转的页面
            intent.setClass(Resturant.this, MapsActivity.class);
            // 开始Activity

            //test.setText("aa");
            startActivity(intent);
        }
    };

}
