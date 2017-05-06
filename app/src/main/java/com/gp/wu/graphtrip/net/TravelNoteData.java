package com.gp.wu.graphtrip.net;

import android.os.AsyncTask;
import android.util.Log;

import com.gp.wu.graphtrip.bean.TravelNotesBean;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wu on 2017/5/6.
 */

public class TravelNoteData {
    private String url;
    private static TravelNoteData travelNoteData;
    private List<TravelNotesBean> notesBeanList;
    private TravelNotesBean notesBean;
    private GetTravelNotesData getTravelNotesData;
    public static TravelNoteData getInstance(){
        if(travelNoteData == null){
            travelNoteData = new TravelNoteData();
        }
        return travelNoteData;
    }

    private TravelNoteData(){
        notesBean = new TravelNotesBean();
        notesBeanList = new ArrayList<>();
    }


    public void getPoiData(String url, GetTravelNotesData getTravelNotesData){
        this.url = url;
        this.getTravelNotesData = getTravelNotesData;
        AsyncGetTravelNotesData asyncGetTravelNotesData = new AsyncGetTravelNotesData();
        asyncGetTravelNotesData.execute();
    }

    private void getData(){
        Connection connect = Jsoup.connect(url);
        Log.i("travel_note_data", url);
        try {
            Connection.Response response = connect.execute();
            String html = response.body().toString();
            Document doc = Jsoup.parse(html);
            initTravelNotesBean();
            Elements el = doc.select(".pla_main");
            Elements eli = el.select(".item");
            for(Element li : eli){
                notesBean = new TravelNotesBean();
                getPic(li);
                getFace(li);
                getTitle(li);
                getFr(li);
                getBbsText(li);
                notesBeanList.add(notesBean);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void initTravelNotesBean(){
        notesBeanList = new ArrayList<TravelNotesBean>();
    }
    private void getPic(Element li){
        Elements pic = li.select(".pic");
        Elements pic_a = pic.get(0).getElementsByTag("a");
        Elements pic_img = pic.get(0).getElementsByTag("img");
        notesBean.setPicSrc(pic_img.get(0).attr("src"));
        notesBean.setNotesHref(pic_a.get(0).attr("href"));
    }
    private void getFace(Element li){
        Elements top = li.select(".top");
        Elements face = top.get(0).select(".face");
        Elements face_a = face.get(0).getElementsByTag("a");
        Elements face_img = face.get(0).getElementsByTag("img");
        notesBean.setFaceSrc(face_img.get(0).attr("src"));
        notesBean.setFaceHref(face_a.get(0).attr("href"));
    }
    private void getTitle(Element li){
        Elements title = li.select(".title");
        Elements title_a = title.get(0).select("a");
        notesBean.setTitleText(title_a.get(0).text());
    }
    private void getFr(Element li){
        Elements fr = li.select(".top").get(0).getElementsByTag("div");
        Elements span = fr.get(0).getElementsByTag("span");
        notesBean.setNoteTime(span.get(0).text());
        notesBean.setNoteViews(span.get(1).text());
        notesBean.setNoteReplys(span.get(2).text());
        notesBean.setNoteLikes(span.get(3).text());
        notesBean.setNoteAnthor(span.get(4).text());
    }
    private void getBbsText(Element li){
        Elements bbstext1 = li.select(".bbstext1");
        notesBean.setNoteText(bbstext1.get(0).text());
    }


    public class AsyncGetTravelNotesData extends AsyncTask<String, String, String> {

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
            getTravelNotesData.getNotesData(notesBeanList);
        }
    }

    public interface GetTravelNotesData{
        void getNotesData(List<TravelNotesBean> notesBeanList);
    }
}
