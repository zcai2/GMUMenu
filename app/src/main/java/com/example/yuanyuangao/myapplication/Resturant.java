package com.example.yuanyuangao.myapplication;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Typeface;
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
        name.setTypeface(null, Typeface.BOLD);
        hour.setTypeface(null, Typeface.BOLD);
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

        ArrayAdapter x = new ArrayAdapter(this,android.R.layout.simple_spinner_item,mData);

        x.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(x);

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

        button.setOnClickListener(listener);


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

            Intent intent = new Intent();

            intent.setClass(Resturant.this, MainMenu.class);

            startActivity(intent);
        }
    };

}
