package com.example.nikeru8.myapplication.forfun;


import android.app.Application;
import android.content.Context;



/**
 * Created by nikeru8 on 2016/6/10.
 */
public class MyApp extends Application {
    private static Context context;
    private static TaipeiAttractions taipeiAttractions;

    //getter
    public static Context getContext(){
        return context;
    }
    public static TaipeiAttractions getTaipeiAttractions(){
        return taipeiAttractions;
    }

    public static void setTaipeiAttractions(TaipeiAttractions taipeiAttractions){
        MyApp.taipeiAttractions=taipeiAttractions;

    }

    public MyApp(){
        context=this;

    }



}
