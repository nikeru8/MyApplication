package com.example.nikeru8.myapplication;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Context context;
    private Spinner spinner;
    private List<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.commit();


        init();
        initalAdapter();
    }

    private void init() {

        spinner = (Spinner) findViewById(R.id.spinner);
        context = this;

    }

    private void initalAdapter() {
        list = new ArrayList<String>();
        list.add("---------湯品---------");
        list.add("---------肉類---------");
        list.add("---------創意料理---------");
        list.add("---------蔬菜、海鮮---------");
        list.add("---------飲料、甜點---------");
        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, list);


        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (list.get(position) == "---------湯品---------") {


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });


    }


}
