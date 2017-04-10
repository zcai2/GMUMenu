package com.example.yuanyuangao.myapplication;

/**
 * Created by yuanyuangao on 2017/4/8.
 */
import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import android.app.Activity;
import android.content.Context;

public class gmudining {

    public ArrayList<Rest> dininglist = new ArrayList<Rest>();
    List<String> information = new ArrayList<String>();
    public static int currentindex=0;

    public gmudining(ArrayList<String> input)
    {
        for(int i=0;i<input.size();i++)
        {String information=input.get(i);
            String[] array = information.split("\\*");
            Rest resturant= new Rest(array[0]);
            resturant.sethour(array[1]);
            resturant.setfood(array[2]);
            dininglist.add(resturant);
        }

    }

    public Rest getinformation(int index)
    {
        return dininglist.get(index);
    }

}
