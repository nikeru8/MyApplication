package com.example.nikeru8.myapplication;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private View m_view_food;
    private TextView m_food_name;
    private TextView m_view_message;
    private Button m_btn_start;
    private TypedArray mFoodImage;//資源檔陣列
    private int mFoodImageCount;//多少張圖片


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFoodImage();
    }

    private void initFoodImage() {
        mFoodImage = getFoodImage();
        mFoodImageCount = getFoodImage().length();
        m_view_food.setBackground(mFoodImage.getDrawable(0));

    }

    private TypedArray getFoodImage() {
        //取得FOOD IMAGE drawables
        TypedArray Foods = getResources().obtainTypedArray(R.array.food_images);
        return Foods;

    }

    private void initView() {
        m_view_food = findViewById(R.id.tv_food_image);
        m_food_name = (TextView) findViewById(R.id.tv_food_name);
        m_view_message = (TextView) findViewById(R.id.view_message);
        m_btn_start = (Button) findViewById(R.id.btn_start);
    }


    //Handler 處理代辦事項
    private Handler m_Handler = new Handler();
    //建立任務物件

    public void start(View view) {
        m_Handler.post(mStartRandomTask);//立即執行任務
        m_Handler.postDelayed(mStopRandomTask, 3000);//3秒後執行任務 停止隨機換圖
        m_btn_start.setEnabled(false);//案下去之後,按鈕失效變灰色

    }

    //建立任務物件
    private StartRandomTask mStartRandomTask = new StartRandomTask();
    private StopRandomTask mStopRandomTask = new StopRandomTask();




    private class StartRandomTask implements Runnable {

        @Override
        public void run() {
            //隨機產生0~圖數量-1
            int index = (int) (Math.random() * mFoodImageCount);
            //換圖
            m_view_food.setBackground(mFoodImage.getDrawable(index));
            //0.1秒後再執行一次本任務
            m_Handler.postDelayed(this, 100);
        }
    }

    private class StopRandomTask implements Runnable {
        @Override
        public void run() {
            //取消任務startRandomTask
            m_Handler.removeCallbacks(mStartRandomTask);
            //start按鈕變成可按
            m_btn_start.setEnabled(true);

        }
    }


    //拍照活動按鈕
    public void ActivityForPhoto(View view) {
        Intent intent = new Intent(this, photo.class);
        startActivity(intent);

    }
    //問券活動按鈕
    public void Ask(View view) {
Intent intent=new Intent(this,Activity1.class);
        startActivity(intent);
    }

   //餐點介紹
    public void page4(View view) {
        Intent intent=new Intent(this,Menu.class);
        startActivity(intent);
    }


}
