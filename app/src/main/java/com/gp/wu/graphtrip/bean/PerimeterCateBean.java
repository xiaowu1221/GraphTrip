package com.gp.wu.graphtrip.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wu on 2017/4/30.
 */

public class PerimeterCateBean implements Serializable{

    /**
     * error_code : 0
     * result : ok
     * data : [{"cateid":151,"catename":"景点观光"},{"cateid":152,"catename":"休闲娱乐"},{"cateid":153,"catename":"赛事演出"},{"cateid":154,"catename":"运动户外"},{"cateid":155,"catename":"游览线路"},{"cateid":156,"catename":"文化活动"},{"cateid":147,"catename":"购物"}]
     */

    private int error_code;
    private String result;
    private List<DataBean> data;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * cateid : 151
         * catename : 景点观光
         */

        private int cateid;
        private String catename;

        public int getCateid() {
            return cateid;
        }

        public void setCateid(int cateid) {
            this.cateid = cateid;
        }

        public String getCatename() {
            return catename;
        }

        public void setCatename(String catename) {
            this.catename = catename;
        }
    }
}
