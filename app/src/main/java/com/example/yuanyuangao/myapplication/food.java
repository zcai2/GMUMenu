package com.example.yuanyuangao.myapplication;

/**
 * Created by yuanyuangao on 2017/4/8.
 */

public class food {
    String price;
    String name;
    String calorie;
    String photo;

    food(String name, String price, String calorie)
    {

        this.name=name;
        this.price=price;
        this.calorie=calorie;


    }
    public void setphoto(String input) {
    this.photo=input;
    }
    public String getPhoto() {
      return this.photo;
    }

    public String toString()
    {
        return "   "+this.name+"                       "+this.price+"                       "+this.calorie;
    }

}
