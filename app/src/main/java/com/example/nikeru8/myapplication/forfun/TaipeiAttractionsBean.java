package com.example.nikeru8.myapplication.forfun;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nikeru8 on 2016/6/8.
 */
public class TaipeiAttractionsBean {

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }




    public static class ResultBean {
        /**
         * _id : 1
         * RowNumber : 1
         * info : 新北投站下車，沿中山路直走即可到達公車：216、218、223、230、266、602、小6、小7、小9、、小22、小25、小26至新北投站下車
         * longitude : 121.503
         * latitude : 25.1364
         * MRT : 新北投
         */
        private int count;
        public int getCount(){

            return count;
        }
        public void setCount(int count){
            this.count=count;
        }



        @SerializedName("results")
        private List<ResultsBean> attractions;

        public List<ResultsBean> getAttractions() {
            return attractions;
        }

        public void setResults(List<ResultsBean> attractions) {
            this.attractions = attractions;
        }

        public static class ResultsBean {
            @SerializedName("CAT2")
            private String category;
            @SerializedName("MEMO_TIME")
            private String memoTime;
            private String stitle;
            @SerializedName("xbody")
            private String introduction;
            private String address;
            @SerializedName("file")
            private String imageURLs;
            @SerializedName("info")
            private String transportation;
            private double longitude;
            private double latitude;
            private String MRT;

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getMemoTime() {
                return memoTime;
            }

            public void setMemoTime(String memoTime) {
                this.memoTime = memoTime;
            }

            public String getStitle() {
                return stitle;
            }

            public void setStitle(String stitle) {
                this.stitle = stitle;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getImageURLs() {
                return imageURLs;
            }

            public void setFile(String imageURLs) {
                this.imageURLs = imageURLs;
            }

            public String getTransportation() {
                return transportation;
            }

            public void setTransportation(String transportation) {
                this.transportation = transportation;
            }

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public String getMRT() {
                return MRT;
            }

            public void setMRT(String MRT) {
                this.MRT = MRT;
            }
        }
    }
}
