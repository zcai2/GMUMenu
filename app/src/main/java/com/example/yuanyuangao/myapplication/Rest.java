package com.example.yuanyuangao.myapplication;

/**
 * Created by yuanyuangao on 2017/4/8.
 */
import java.util.*;

public class Rest {
    String name;
    String hour;
    ArrayList<food> footlist = new ArrayList<food>();

    public Rest(String name) {
        this.name = name;
    }

    public String getname() {
        return this.name;
    }

    public String gethour() {
        return this.hour;
    }

    public String getfood() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < footlist.size(); i++) {
            {
                sb.append(footlist.get(i));
                sb.append('\n');
            }

        }
        return sb.toString();
    }


    public void sethour(String hour) {
        this.hour = hour;
    }

    public void setfood(String food) {

        String[] foodarray = food.split("\\,");
        for (int i = 0; i < foodarray.length; i++) {
            String[] foodinformationarray =foodarray[i].split("\\+");
            food footelemt = new food(foodinformationarray[0], foodinformationarray[1], foodinformationarray[2]);
            footlist.add(footelemt);
        }
    }
}