package com.example.nikeru8.myapplication.forfun;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.nikeru8.myapplication.R;


import java.util.List;

/**
 * Created by nikeru8 on 2016/6/10.
 */
public class AttractionsRecyclerViewAdapter extends
        RecyclerView.Adapter<AttractionsRecyclerViewAdapter.MyViewHolder> {


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//建立holder
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_attraction, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {//此方法設定View呈現的資料
        TaipeiAttractions ta = MyApp.getTaipeiAttractions();
        if (ta == null) {
            holder.m_tv_title.setText("" + position);//顯示現在是第幾項
            return;
        }
        //將postion記錄在Button的TAG
        holder.m_btn_map.setTag(position);




        //設定景點名稱與種類
        holder.m_tv_title.setText(position + "" + ta.getSubTitle(position));
        holder.m_tv_category.setText(ta.getCategory(position));

        //取得圖片網址
        Context context = holder.m_im_image.getContext();
        List<List<String>> list = MyApp.getTaipeiAttractions().getImageUrlsList();
        //如果陣列有資料
        if (list.size() > 0) {
            List<String> imagesUrls = list.get(position);
            String imageUrl = imagesUrls.get(0);

            //透過Glide在背景(新的執行緒)載入並設定圖片
            Glide.with(context)
                    .load(imageUrl)
                    .placeholder(R.drawable.no_image_box)//未下載完成顯示的圖片
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)//將下載的圖儲存(之後就不用再次下載)
                    .into(holder.m_im_image);//將圖片放到ImageView
        }


    }

    @Override
    public int getItemCount() {//此方法回答有幾個item

        TaipeiAttractions ta = MyApp.getTaipeiAttractions();
        if (ta == null) {
            return 10;
        }
        return ta.getCount();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private Button m_btn_map;
        private TextView m_tv_title;
        private TextView m_tv_category;
        private ImageView m_im_image;

        //建構子
        public MyViewHolder(View itemView) {
            super(itemView);
            m_btn_map=(Button)itemView.findViewById(R.id.btn_map);
            m_tv_title = (TextView) itemView.findViewById(R.id.tv_stitle);
            m_tv_category = (TextView) itemView.findViewById(R.id.tv_category);
            m_im_image = (ImageView) itemView.findViewById(R.id.iv_image);

        }


    }

}
