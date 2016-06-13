package com.example.nikeru8.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class Map extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, Menu.NONE, "上一頁");

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

    public void clickMap1(View view) {


        Uri uri1 = Uri.parse("http://maps.google.com/maps?f=dsaddr=startLat%20startLng&daddr=寬巷子士林店");
        Intent it = new Intent(Intent.ACTION_VIEW,uri1);
        startActivity(it);

    }

    public void clickMap2(View view) {

        Uri uri2 = Uri.parse("http://maps.google.com/maps?f=dsaddr=startLat%20startLng&daddr=寬巷子微風店");
        Intent it = new Intent(Intent.ACTION_VIEW,uri2);
        startActivity(it);
    }

    public void clickMap3(View view) {
        Uri uri3 = Uri.parse("http://maps.google.com/maps?f=dsaddr=startLat%20startLng&daddr=寬巷子新生店");
        Intent it = new Intent(Intent.ACTION_VIEW,uri3);
        startActivity(it);
    }

    public void phone1(View view) {
        Uri uri = Uri.parse("tel:02-2393-5252");
        Intent it = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(it);

    }

    public void phone2(View view) {
        Uri uri = Uri.parse("tel:02 8780 6617");
        Intent it = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(it);
    }

    public void phone3(View view) {
        Uri uri = Uri.parse("tel:02 2393 5252");
        Intent it = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(it);
    }


}
