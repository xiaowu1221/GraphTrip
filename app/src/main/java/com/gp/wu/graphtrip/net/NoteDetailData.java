package com.gp.wu.graphtrip.net;

import android.os.AsyncTask;

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

public class NoteDetailData {
    private String url;
    private static NoteDetailData detailData;
    private List<String> dataList;

    private GetNoteDetailData getNoteDetailData;
    public static NoteDetailData getInstance(){
        if(detailData == null){
            detailData = new NoteDetailData();
        }
        return detailData;
    }
    private NoteDetailData(){
        dataList = new ArrayList<>();

    }

    public void getPoiData(String url, GetNoteDetailData getNoteDetailData){
        this.url = url;
        this.getNoteDetailData = getNoteDetailData;
        if(dataList != null){
            dataList.clear();
        }
        AsyncGetNoteDetailData asyncGetNoteDetailData = new AsyncGetNoteDetailData();
        asyncGetNoteDetailData.execute();
    }
    private void getData(){
        Connection connect = Jsoup.connect("http:" + url);
        try {
            Connection.Response response = connect.execute();
            String html = response.body().toString();
            Document doc = Jsoup.parse(html);
            Elements el = doc.select(".bbs_detail_content");
            Elements ele = el.get(0).getElementsByTag("td");
            Elements pimg = ele.get(0).children();
            for(Element e : pimg){
                if(e.children().size() > 0){
//                    System.out.println(e.children().get(0).attr("data-original"));
                    dataList.add(e.children().get(0).attr("data-original"));
                }else{
//                    System.out.println(e.text());
                    dataList.add(e.text());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class AsyncGetNoteDetailData extends AsyncTask<String, String, String> {

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
            getNoteDetailData.noteDetailData(dataList);
        }
    }
    public interface GetNoteDetailData{
        void noteDetailData(List<String> dataList);
    }

}
