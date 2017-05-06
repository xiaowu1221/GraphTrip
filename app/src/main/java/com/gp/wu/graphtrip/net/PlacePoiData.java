package com.gp.wu.graphtrip.net;

import android.os.AsyncTask;

import com.gp.wu.graphtrip.bean.PlacePoiDetailBean;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wu on 2017/4/25.
 */

public class PlacePoiData {
    private String url;
    private static PlacePoiData placePoiData;
    private PlacePoiDetailBean placePoiDetailBean;
    private List<PlacePoiDetailBean.PoiDiscountBean> poiDiscountBeanList;
    private List<PlacePoiDetailBean.PoiRouteBean> poiRouteBeanList;


    private GetPoiData getPoiData;
    public static PlacePoiData getInstance(){
        if(placePoiData == null){
            placePoiData = new PlacePoiData();
        }
        return placePoiData;
    }
    private PlacePoiData(){
        placePoiDetailBean = new PlacePoiDetailBean();
    }

    public void getPoiData(String url, GetPoiData getPoiData){
        this.url = url;
        this.getPoiData = getPoiData;
        AsyncGetPoiData asyncGetPoiData = new AsyncGetPoiData();
        asyncGetPoiData.execute();
    }

    private void getData(){
        Connection connect = Jsoup.connect("http:" + url);
//        Log.i("place_poi_data", "http:" + url);
        try {
            Connection.Response response = connect.execute();
            String html = response.body().toString();
            Document doc = Jsoup.parse(html);
            initPoiBean();
            getPoiName(doc);
            getPoiDiscount(doc);
            getPoiDetail(doc);
            getPoiRoute(doc);
            getPoiTips(doc);
            getPoiCityId(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initPoiBean(){
        placePoiDetailBean.setEnname("");
        placePoiDetailBean.setCnname("");
        placePoiDetailBean.setDetail("");
        placePoiDetailBean.setTipContent("");
        poiDiscountBeanList = new ArrayList<>();
        poiRouteBeanList = new ArrayList<>();
        placePoiDetailBean.setPoiDiscountList(poiDiscountBeanList);
        placePoiDetailBean.setPoiRouteBeanList(poiRouteBeanList);
    }
    /**
     * 景点名称
     * @param document
     */
    private void getPoiName(Document document){
        Elements el = document.select(".poi-largeTit");
        if(el.size() > 0){
            Elements en = el.get(0).getElementsByClass("en");
            if(en.size() > 0){
                String enname = en.get(0).text();
                placePoiDetailBean.setEnname(enname);
            }
            Elements cn = el.get(0).getElementsByClass("cn");
            if(cn.size() > 0){
                String cnname = cn.get(0).text();
                placePoiDetailBean.setCnname(cnname);
//                Log.i("place_poi_data", cnname);
            }
        }
    }
    /**
     *景点折扣
     */
    private void getPoiDiscount(Document document){
        Elements el = document.select(".poi-discount");
        if(el.size() > 0){
            for(Element s : el){
                Elements ele = s.getElementsByTag("li");
                if(ele.size() > 0){
                    for(Element elem : ele){
                        PlacePoiDetailBean.PoiDiscountBean poiDiscountBean = new PlacePoiDetailBean.PoiDiscountBean();
                        String href = elem.getElementsByTag("a").attr("href");
                        poiDiscountBean.setHref(href);
                        Elements title = elem.getElementsByClass("title");
                        if(title.size() > 0){
                            Elements tag = title.get(0).getElementsByClass("tag");
                            Elements location = title.get(0).getElementsByClass("fontYaHei");
                            if(tag.size() > 0){
                                poiDiscountBean.setTag(tag.get(0).text());
                            }
                            if(location.size() > 0){
                                poiDiscountBean.setLocation(location.get(0).text());
                            }
                        }
                        Elements content = elem.getElementsByClass("content");
                        if(content.size() > 0){
                            poiDiscountBean.setContent(content.get(0).text());
                        }
                        Elements price = elem.getElementsByTag("em");
                        if(price.size() > 0){
                            poiDiscountBean.setPrice(price.get(0).text());
                        }
                        poiDiscountBeanList.add(poiDiscountBean);
                    }
                }
            }
            placePoiDetailBean.setPoiDiscountList(poiDiscountBeanList);
        }
    }
    /**
     * 景点介绍
     */
    private void getPoiDetail(Document document){
        Elements el = document.select(".poi-detail");
        if(el.size() > 0){
            placePoiDetailBean.setDetail(el.get(0).text());
        }
    }
    /**
     * 景点路线
     */
    private void getPoiRoute(Document document){
        Elements el = document.select(".poi-tips");
        if(el.size() > 0){
            for(Element ele : el){
                Elements elem = ele.children();
                if(elem.size() > 0){
                    for(Element e : elem){
                        PlacePoiDetailBean.PoiRouteBean poiRouteBean = new PlacePoiDetailBean.PoiRouteBean();
                        Elements key = e.getElementsByClass("title");
                        Elements value = e.getElementsByClass("content");
                        if(key.size() > 0){
                            poiRouteBean.setKey(key.get(0).text());
                        }
                        if(value.size() > 0){
                            poiRouteBean.setValue(value.get(0).text());
                        }
                        poiRouteBeanList.add(poiRouteBean);
                    }
                }
            }
        }
    }
    /**
     * 小贴士
     */
    private void getPoiTips(Document document){
        Elements el = document.select(".poi-tipContent");
        if(el.size() > 0){
//            Log.i("place_poi_data", el.html());
            Elements title = el.get(0).getElementsByClass("content");
            if(title.size() > 0){
//                Log.i("place_poi_data", title.html());
                placePoiDetailBean.setTipContent(title.get(0).text());
//                Log.i("place_poi_data", title.text());
            }
        }
    }

    /**
     * 获取景点所属城市id
     */
    private void getPoiCityId(Document document){
        Elements el = document.getElementsByTag("script");
        String[] s = el.get(0).data().split("PLACE.CITYID");
        String string = s[1].split("=")[1].trim();
//        System.out.println(string);
        int start = string.indexOf("\"");
        int end = string.indexOf(";");
//        System.out.println(start + "" + end);
        String str = string.substring(start + 1, end - 1);
        placePoiDetailBean.setCityId(str);
    }
    public class AsyncGetPoiData extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... params) {
            getData();
            return "ok";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            getPoiData.poiData(placePoiDetailBean);
        }
    }
    public interface GetPoiData{
        void poiData(PlacePoiDetailBean placePoiDetailBean);
    }
}
