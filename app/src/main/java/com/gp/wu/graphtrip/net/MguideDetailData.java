package com.gp.wu.graphtrip.net;

import android.os.AsyncTask;

import com.gp.wu.graphtrip.bean.MguideDetailBean;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wu on 2017/5/7.
 */

public class MguideDetailData {
    private String url;
    private static MguideDetailData detailData;
    private List<MguideDetailBean> detailBeanList;
    private String content;
    private GetMguideDetailData getMguideDetailData;
    public static MguideDetailData getInstance(){
        if(detailData == null){
            detailData = new MguideDetailData();
        }
        return detailData;
    }
    private MguideDetailData(){
        detailBeanList = new ArrayList<>();
    }
    public void getMguideDetailData(String url, GetMguideDetailData getMguideDetailData){
        this.url = url;
        this.getMguideDetailData = getMguideDetailData;
        if(detailBeanList != null){
            detailBeanList.clear();
        }
        AsyncGetMguideDetailData  asyncGetMguideDetailData= new AsyncGetMguideDetailData();
        asyncGetMguideDetailData.execute();
    }
    private void getData(){
        Connection connect = Jsoup.connect("http:" + url);
        try {
            Connection.Response response = connect.execute();
            String html = response.body().toString();
            Document doc = Jsoup.parse(html);
            Elements el = doc.select("#poiList");
            Elements el_li = el.get(0).select(".mguide-list");
            Elements detail_content = doc.select(".detail-content");
            if(detail_content.size() > 0){
                content = detail_content.get(0).text();
            }
            if(el_li.size() > 0){
                for(Element li : el_li){
                    MguideDetailBean detailBean = new MguideDetailBean();
//                    System.out.println("tid : " + li.attr("tid"));
                    detailBean.setId(li.attr("tid"));
                    //title-left
                    Elements title_left = li.select(".title-left");
                    Elements title_left_span = title_left.get(0).getElementsByTag("span");
                    Elements title_left_a = title_left.get(0).getElementsByTag("a");
                    String title_left_span_text = title_left_span.get(0).text();
                    String title_left_a_text = title_left_a.get(0).text();
                    String title_left_a_href = title_left_a.get(0).attr("href");
//                    System.out.println("title_left_span_text : " + title_left_span_text + "\ntitle_left_a_text : " + title_left_a_text +
//                            "\ntitle_left_a_href : " + title_left_a_href);
                    detailBean.setCnname(title_left_a_text);
                    detailBean.setUrl(title_left_a_href);
                    //list-slider
                    Elements list_slider = li.select(".list-slider");
                    if(list_slider.size() > 0){
                        Elements slider_contain = list_slider.get(0).select(".slider-contain");
                        Elements slider_contain_img = slider_contain.get(0).getElementsByTag("img");
                        String slider_contain_img_src = slider_contain_img.get(0).attr("src");
//                        System.out.println("slider_contain_img_src : " + slider_contain_img_src);
                        detailBean.setPhoto(slider_contain_img_src);
                    }
                    //slider-intro
                    Elements slider_intro = li.select(".slider-intro");
                    Elements slider_intro_detail = slider_intro.get(0).select(".detail");
                    String detail = slider_intro_detail.get(0).text();
//                    System.out.println("detail : " + detail);
//                    System.out.println("=================================");
                    detailBean.setDetail(detail);
                    detailBeanList.add(detailBean);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public class AsyncGetMguideDetailData extends AsyncTask<String, String, String> {

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
            getMguideDetailData.getDetailData(detailBeanList, content);
        }
    }

    public interface GetMguideDetailData{
        void getDetailData(List<MguideDetailBean> detailBeanList, String content);
    }
}
