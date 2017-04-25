package com.example.yuanyuangao.myapplication;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void textFileReader1_isCorrect() throws Exception {
        ArrayList<String> myObj = new ArrayList<String>();
        Resturant r = new Resturant();
        myObj = r.test();
        String temp = "wingzone*11am-12am*wings+10$+400,tender+5$+400,shrimp+15$+300";
        assertEquals(myObj.get(0), temp);
    }
}
