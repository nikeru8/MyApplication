package com.example.nikeru8.myapplication.forfun;


import android.util.Log;



import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nikeru8 on 2016/6/10.
 */
public class TaipeiOpenDataUtil {


    private static class ImageUrlParser {
        public static List<String> split(String urls) {
            if (urls == null || urls.length() == 0) {
                return null;
            }

            List<String> list = new ArrayList<>();
            String url = null;
            int start = urls.indexOf("http");
            int end = 0;
            while (start >= 0) {
                end = urls.indexOf(start, start + 1);
                if (end < 0) {
                    list.add(urls.substring(start, urls.length()));
                    break;
                }
                list.add(urls.substring(start, end));
                start = end;
            }
            return list;

        }

    }


    public static final String TAG = "LoadOpenData";

    //載入資料，需要知道誰(fans)在關注下載資料
    public static void loadTaipeiAttractions(final Observer observer) {


        Call<TaipeiAttractionsBean> call = TaipeiAttractionsOpenData.apiService.getAttractionsInTaipeiBean();
        call.enqueue(new Callback<TaipeiAttractionsBean>() {
            @Override
            public void onResponse(Call<TaipeiAttractionsBean> call, Response<TaipeiAttractionsBean> response) {
                if (!response.isSuccessful()) {//沒成功的話

                    String message = "onResponse():Unsuccessful,response_code=" + response.code();

                    Log.d(TAG, message);
                    observer.OnError(message);
                    //TaipeiAttractionsBean bean = response.body();
                    return;
                }

                TaipeiAttractionsBean bean = response.body();

                //建立陣列存放每個景點->Images URLs(陣列)
                List<List<String>> imageUrlsList = new ArrayList<>();


                Log.d(TAG, "onResponse():Sucessful");
                Log.d(TAG, "count=" + bean.getResult().getCount());

                //使用傳統的for迴圈較佳
                for (int i = 0; i < bean.getResult().getCount(); i++) {
                    Log.d(TAG, "----------------" + i + "----------------");

                    TaipeiAttractionsBean.ResultBean.ResultsBean attraction =
                            bean.getResult().getAttractions().get(i);

                    //一個字串裡面有多個ImageURL,需要裁切
                    List<String> list = ImageUrlParser.split(attraction.getImageURLs());
                    //將一個景點所提供的多個圖片放入陣列imageUrlsList
                    imageUrlsList.add(list);

//LOG日誌
                    LogAttraction(attraction);
                    LogImageUrls(list);

                    //將資料寄放在MyApp,建立model,封裝bean和imageUrlsList
                    MyApp.setTaipeiAttractions(new TaipeiAttractions(bean, imageUrlsList));
                    observer.OnCompleted();//告訴fans下載完成
                }
            }

            @Override
            public void onFailure(Call<TaipeiAttractionsBean> call, Throwable t) {
                observer.OnError(t.toString());//告訴粉絲下載遇到問題
            }
        });
    }

    private static void LogAttraction(TaipeiAttractionsBean.ResultBean.ResultsBean attraction) {
//        Log.d(TAG, attraction.getStitle() + "");
//        Log.d(TAG, attraction.getCategory() + "");
//        Log.d(TAG, attraction.getIntroduction() + "");
//        Log.d(TAG, attraction.getAddress() + "");
//        Log.d(TAG, attraction.getTransportation() + "");
//        Log.d(TAG, attraction.getMRT() + "");
//        Log.d(TAG, attraction.getLatitude() + "");
//        Log.d(TAG, attraction.getLongitude() + "");
//        Log.d(TAG, attraction.getMemoTime() + "");
        Log.d(TAG, attraction.getImageURLs());


    }

    private static void LogImageUrls(List<String> list) {
        for (int j = 0; j < list.size(); j++) {
            Log.d(TAG, list.get(j).toString());
        }
    }


}
