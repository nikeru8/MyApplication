package com.example.nikeru8.myapplication.forfun;




import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by nikeru8 on 2016/6/9.
 */
public interface TaipeiAttractionsOpenData {


    //Call<T>代表下載的資料轉成的Java物件(景點Bean)
    @GET("opendata/datalist/apiAccess?scope=resourceAquire&rid=36847f3f-deff-4183-a5bb-800737591de5")
    Call<TaipeiAttractionsBean> getAttractionsInTaipeiBean();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://data.taipei/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public static final TaipeiAttractionsOpenData apiService=retrofit.create(TaipeiAttractionsOpenData.class);

}