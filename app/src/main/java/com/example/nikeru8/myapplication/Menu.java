package com.example.nikeru8.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

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

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {

        menu.add(0, 1, android.view.Menu.NONE, "首頁");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case 1:
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(this, "首頁", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
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

                transaction=manager.beginTransaction();

                if(list.get(position)=="---------湯品---------"){

                    Fragment2 fragment2=new Fragment2();
                    transaction.replace(R.id.center,fragment2,"fragment2");
                    transaction.addToBackStack("fragment2");//添加到Activity管理要回退佔中



                }
                else if (list.get(position) == "---------肉類---------") {
                    Fragment1 fragment1=new Fragment1();
                    transaction.replace(R.id.center,fragment1,"fragment1");
                    transaction.addToBackStack("fragment1");//添加到Activity管理要回退佔中



                }
                else if (list.get(position) == "---------創意料理---------") {
                    Fragment3 fragment3=new Fragment3();
                    transaction.replace(R.id.center,fragment3,"fragment3");
                    transaction.addToBackStack("fragment3");//添加到Activity管理要回退佔中



                }
                else if (list.get(position) == "---------蔬菜、海鮮---------") {
                    Fragment4 fragment4=new Fragment4();
                    transaction.replace(R.id.center,fragment4,"fragment4");
                    transaction.addToBackStack("fragment4");//添加到Activity管理要回退佔中



                }
                else if (list.get(position) =="---------飲料、甜點---------") {
                    Fragment5 fragment5=new Fragment5();
                    transaction.replace(R.id.center,fragment5,"fragment5");
                    transaction.addToBackStack("fragment5");//添加到Activity管理要回退佔中



                }
                transaction.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });


    }


}
