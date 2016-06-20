package com.example.nikeru8.myapplication.forfun;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;


import com.example.nikeru8.myapplication.R;

import java.security.PrivateKey;

public class fun extends AppCompatActivity implements Observer {

    private static final String TAG = "MainActivity";
    private RecyclerView m_rv_attractions;
    private AttractionsRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun);
        init();

        ActionBarView();
        TaipeiOpenDataUtil.loadTaipeiAttractions(this);//載入台北景點的資料，將model資料寄放在MyApp
    }

    public void ActionBarView() {

        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.backgroundtext2));

    }

    private void init() {
        m_rv_attractions = (RecyclerView) findViewById(R.id.rv_attractions);
        m_rv_attractions.setHasFixedSize(true);//告知畫面中的每個Item結構都相同(提高效率)

        //每個Item垂直排列
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        m_rv_attractions.setLayoutManager(llm);

        //建立&資料轉接器
        mAdapter = new AttractionsRecyclerViewAdapter();
        m_rv_attractions.setAdapter(mAdapter);


    }

    @Override
    public void OnCompleted() {
        Log.d(TAG, "OnCompleted");
        //adapter通知RecyclerView資料有所改變，請更新畫面
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnError(String message) {
        Log.d(TAG, "OnError");
        Log.d(TAG, "message");
    }

    //使用意圖開啟GoogleMap App
    public void clickMap(View view) {
        int position = (int) view.getTag();
        //Create a Uri from an intent string. Use the result to create an Intent.
        double latitude = MyApp.getTaipeiAttractions().getLatitude(position);
        double longitude = MyApp.getTaipeiAttractions().getLongitude(position);
        String title = MyApp.getTaipeiAttractions().getSubTitle(position);
        String s = String.format("geo:0,0?q=%f,%f(%s)", latitude, longitude, title);
        Uri gmmIntentUri = Uri.parse(s);


        //create an intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        //Make the Intent explicity by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");


        //Attempt to start an activity that can handle the Intent
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);

        }


    }


}
