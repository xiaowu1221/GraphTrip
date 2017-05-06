package com.gp.wu.graphtrip.bean;

import java.util.List;

/**
 * Created by wu on 2017/4/25.
 */

public class PlacePoiDetailBean {
    private String cityId;      //所属城市id

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    private String cnname;      //中文名称
    private String enname;      //英文名称
    private List<PoiDiscountBean> poiDiscountList;  //折扣
    private String detail;      //介绍
    private List<PoiRouteBean> poiRouteBeanList;    //路线
    private String tipContent;

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public List<PoiDiscountBean> getPoiDiscountList() {
        return poiDiscountList;
    }

    public void setPoiDiscountList(List<PoiDiscountBean> poiDiscountList) {
        this.poiDiscountList = poiDiscountList;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<PoiRouteBean> getPoiRouteBeanList() {
        return poiRouteBeanList;
    }

    public void setPoiRouteBeanList(List<PoiRouteBean> poiRouteBeanList) {
        this.poiRouteBeanList = poiRouteBeanList;
    }

    public String getTipContent() {
        return tipContent;
    }

    public void setTipContent(String tipContent) {
        this.tipContent = tipContent;
    }

    public static class PoiDiscountBean{
        private String href;        //链接
        private String tag;         //标签
        private String location;    //取票地址
        private String content;     //亮点推荐
        private String price;       //价格

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
    public static class PoiRouteBean{
        private String key;
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getKey() {

            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
