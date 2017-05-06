package com.gp.wu.graphtrip.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wu on 2017/4/30.
 */

public class PerimeterGoBean implements Serializable{

    /**
     * error_code : 0
     * result : ok
     * data : {"res":[{"id":"56501","chinesename":"星光大道","englishname":"the Stars Avenue","price":58,"lat":"22.293015","lng":"114.173904","url":"//place.qyer.com/poi/V2EJZVFjBzZTZQ/","rank":"6","count":1020,"category_name":"景点观光","tags":[{"id":"209","tag_name":"街区","tag_alias_name":"街道,大街","tag_name_py":"jiequ","state":"1","createtime":"1449576624","updatetime":"1453369085","cn_name":"街区","catename":"街区","en_name":"jiequ","catename_en":"jiequ","catename_py":"jiequ","poi_category_id":0,"parentid":0,"status":"1"}],"planto":0,"hotel_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fsearchresults.html%3Flatitude%3D22.293015%26longitude%3D114.173904%26radius%3D5%26aid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935118423820_aaid_355695-city-map-hotel-hover%26lang%3Dzh-cn%26ifl%3D%26ss%3D","discount":false,"discount_price":false,"hotel_count":612},{"id":"83130","chinesename":"太平山","englishname":"Victoria Peak","price":0,"lat":"22.274424","lng":"114.144760","url":"//place.qyer.com/poi/V2wJYFFnBzVTZA/","rank":"1","count":1020,"category_name":"景点观光","tags":[{"id":"199","tag_name":"自然风光","tag_alias_name":"","tag_name_py":"ziranfengguang","state":"1","createtime":"1449576623","updatetime":"1463725237","cn_name":"自然风光","catename":"自然风光","en_name":"ziranfengguang","catename_en":"ziranfengguang","catename_py":"ziranfengguang","poi_category_id":0,"parentid":0,"status":"1"},{"id":"2014","tag_name":"观景台","tag_alias_name":"","tag_name_py":"guanjingtai","state":"1","createtime":"1449576624","updatetime":"1449576624","cn_name":"观景台","catename":"观景台","en_name":"guanjingtai","catename_en":"guanjingtai","catename_py":"guanjingtai","poi_category_id":0,"parentid":0,"status":"1"}],"planto":0,"hotel_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fsearchresults.html%3Flatitude%3D22.274424%26longitude%3D114.144760%26radius%3D5%26aid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935118427526_aaid_355695-city-map-hotel-hover%26lang%3Dzh-cn%26ifl%3D%26ss%3D","discount":true,"discount_price":"<em>225<\/em>元起","hotel_count":493},{"id":"89891","chinesename":"金紫荆广场","englishname":"Golden Bauhinia Square","price":0,"lat":"22.284426","lng":"114.173912","url":"//place.qyer.com/poi/V2wJalFuBz9TZQ/","rank":"27","count":1020,"category_name":"景点观光","tags":[{"id":"187","tag_name":"广场","tag_alias_name":"","tag_name_py":"guangchang","state":"1","createtime":"1449576623","updatetime":"1449576623","cn_name":"广场","catename":"广场","en_name":"guangchang","catename_en":"guangchang","catename_py":"guangchang","poi_category_id":0,"parentid":0,"status":"1"},{"id":"203","tag_name":"纪念碑/雕塑/喷泉","tag_alias_name":"","tag_name_py":"jinianbeidiaosupenquan","state":"1","createtime":"1449576623","updatetime":"1449576623","cn_name":"纪念碑/雕塑/喷泉","catename":"纪念碑/雕塑/喷泉","en_name":"jinianbeidiaosupenquan","catename_en":"jinianbeidiaosupenquan","catename_py":"jinianbeidiaosupenquan","poi_category_id":0,"parentid":0,"status":"1"}],"planto":0,"hotel_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fsearchresults.html%3Flatitude%3D22.284426%26longitude%3D114.173912%26radius%3D5%26aid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935118423042_aaid_355695-city-map-hotel-hover%26lang%3Dzh-cn%26ifl%3D%26ss%3D","discount":true,"discount_price":"<em>365<\/em>元起","hotel_count":609},{"id":"59047","chinesename":"尖沙咀","englishname":"Tsim Sha Tsui","price":0,"lat":"22.297663","lng":"114.172180","url":"//place.qyer.com/poi/V2EJalFmBzJTYw/","rank":"1","count":6672,"category_name":"购物","tags":[{"id":"362","tag_name":"购物街/商圈","tag_alias_name":"","tag_name_py":"gouwujieshangquan","state":"1","createtime":"1449576616","updatetime":"1464081257","cn_name":"购物街/商圈","catename":"购物街/商圈","en_name":"gouwujieshangquan","catename_en":"gouwujieshangquan","catename_py":"gouwujieshangquan","poi_category_id":0,"parentid":0,"status":"1"}],"planto":0,"hotel_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fsearchresults.html%3Flatitude%3D22.297663%26longitude%3D114.172180%26radius%3D5%26aid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935118435224_aaid_355695-city-map-hotel-hover%26lang%3Dzh-cn%26ifl%3D%26ss%3D","discount":true,"discount_price":"<em>315<\/em>元起","hotel_count":610},{"id":"36513","chinesename":"中银大厦","englishname":"Bank of China Tower","price":0,"lat":"22.279305","lng":"114.161736","url":"//place.qyer.com/poi/V2cJZVFjBzdTZw/","rank":"8","count":1020,"category_name":"景点观光","tags":[{"id":"183","tag_name":"建筑","tag_alias_name":"","tag_name_py":"jianzhu","state":"1","createtime":"1449576623","updatetime":"1449576623","cn_name":"建筑","catename":"建筑","en_name":"jianzhu","catename_en":"jianzhu","catename_py":"jianzhu","poi_category_id":0,"parentid":0,"status":"1"}],"planto":0,"hotel_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fsearchresults.html%3Flatitude%3D22.279305%26longitude%3D114.161736%26radius%3D5%26aid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935118432169_aaid_355695-city-map-hotel-hover%26lang%3Dzh-cn%26ifl%3D%26ss%3D","discount":true,"discount_price":"<em>289<\/em>元起","hotel_count":599},{"id":"37686","chinesename":"弥敦道","englishname":"Nathan Road","price":0,"lat":"22.311335","lng":"114.170898","url":"//place.qyer.com/poi/V2cJZFFgBz5TYg/","rank":"4","count":1020,"category_name":"景点观光","tags":[{"id":"209","tag_name":"街区","tag_alias_name":"街道,大街","tag_name_py":"jiequ","state":"1","createtime":"1449576624","updatetime":"1453369085","cn_name":"街区","catename":"街区","en_name":"jiequ","catename_en":"jiequ","catename_py":"jiequ","poi_category_id":0,"parentid":0,"status":"1"}],"planto":0,"hotel_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fsearchresults.html%3Flatitude%3D22.311335%26longitude%3D114.170898%26radius%3D5%26aid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935118431911_aaid_355695-city-map-hotel-hover%26lang%3Dzh-cn%26ifl%3D%26ss%3D","discount":false,"discount_price":false,"hotel_count":611},{"id":"94404","chinesename":"兰桂坊","englishname":"Lan Kwai Fong","price":0,"lat":"22.280752","lng":"114.155762","url":"//place.qyer.com/poi/V20JZ1FiBzZTYA/","rank":"7","count":1020,"category_name":"景点观光","tags":[{"id":"209","tag_name":"街区","tag_alias_name":"街道,大街","tag_name_py":"jiequ","state":"1","createtime":"1449576624","updatetime":"1453369085","cn_name":"街区","catename":"街区","en_name":"jiequ","catename_en":"jiequ","catename_py":"jiequ","poi_category_id":0,"parentid":0,"status":"1"}],"planto":0,"hotel_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fsearchresults.html%3Flatitude%3D22.280752%26longitude%3D114.155762%26radius%3D5%26aid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935118438039_aaid_355695-city-map-hotel-hover%26lang%3Dzh-cn%26ifl%3D%26ss%3D","discount":false,"discount_price":false,"hotel_count":600},{"id":"56522","chinesename":"中环至半山自动扶梯","englishname":"Central-Mid-Levels Escalator and Walkway System","price":0,"lat":"22.283827","lng":"114.155144","url":"//place.qyer.com/poi/V2EJZVFjBzRTZg/","rank":"5","count":1020,"category_name":"景点观光","tags":[{"id":"183","tag_name":"建筑","tag_alias_name":"","tag_name_py":"jianzhu","state":"1","createtime":"1449576623","updatetime":"1449576623","cn_name":"建筑","catename":"建筑","en_name":"jianzhu","catename_en":"jianzhu","catename_py":"jianzhu","poi_category_id":0,"parentid":0,"status":"1"}],"planto":0,"hotel_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fsearchresults.html%3Flatitude%3D22.283827%26longitude%3D114.155144%26radius%3D5%26aid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935118432068_aaid_355695-city-map-hotel-hover%26lang%3Dzh-cn%26ifl%3D%26ss%3D","discount":false,"discount_price":false,"hotel_count":606},{"id":"59049","chinesename":"中环","englishname":"Central","price":0,"lat":"22.281525","lng":"114.158005","url":"//place.qyer.com/poi/V2EJalFmBzJTbQ/","rank":"2","count":6672,"category_name":"购物","tags":[{"id":"275","tag_name":"购物中心/商城","tag_alias_name":"","tag_name_py":"gouwuzhongxinshangcheng","state":"1","createtime":"1449576616","updatetime":"1464080435","cn_name":"购物中心/商城","catename":"购物中心/商城","en_name":"gouwuzhongxinshangcheng","catename_en":"gouwuzhongxinshangcheng","catename_py":"gouwuzhongxinshangcheng","poi_category_id":0,"parentid":0,"status":"1"},{"id":"336","tag_name":"时尚购物","tag_alias_name":"","tag_name_py":"shishanggouwu","state":"1","createtime":"1449576613","updatetime":"1469779079","cn_name":"时尚购物","catename":"时尚购物","en_name":"shishanggouwu","catename_en":"shishanggouwu","catename_py":"shishanggouwu","poi_category_id":0,"parentid":0,"status":"1"}],"planto":0,"hotel_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fsearchresults.html%3Flatitude%3D22.281525%26longitude%3D114.158005%26radius%3D5%26aid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935118438882_aaid_355695-city-map-hotel-hover%26lang%3Dzh-cn%26ifl%3D%26ss%3D","discount":true,"discount_price":"<em>365<\/em>元起","hotel_count":602},{"id":"94785","chinesename":"湾仔","englishname":"Wan Chai","price":0,"lat":"22.276180","lng":"114.175102","url":"//place.qyer.com/poi/V20JZ1FhBz5TYQ/","rank":"10","count":1020,"category_name":"景点观光","tags":[{"id":"209","tag_name":"街区","tag_alias_name":"街道,大街","tag_name_py":"jiequ","state":"1","createtime":"1449576624","updatetime":"1453369085","cn_name":"街区","catename":"街区","en_name":"jiequ","catename_en":"jiequ","catename_py":"jiequ","poi_category_id":0,"parentid":0,"status":"1"}],"planto":0,"hotel_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fsearchresults.html%3Flatitude%3D22.276180%26longitude%3D114.175102%26radius%3D5%26aid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935118434435_aaid_355695-city-map-hotel-hover%26lang%3Dzh-cn%26ifl%3D%26ss%3D","discount":true,"discount_price":"<em>365<\/em>元起","hotel_count":580},{"id":"94445","chinesename":"香港会议展览中心","englishname":"Hong Kong Convention and Exhibition Centre","price":0,"lat":"22.284515","lng":"114.172882","url":"//place.qyer.com/poi/V20JZ1FiBzJTYQ/","rank":"19","count":1020,"category_name":"景点观光","tags":[{"id":"183","tag_name":"建筑","tag_alias_name":"","tag_name_py":"jianzhu","state":"1","createtime":"1449576623","updatetime":"1449576623","cn_name":"建筑","catename":"建筑","en_name":"jianzhu","catename_en":"jianzhu","catename_py":"jianzhu","poi_category_id":0,"parentid":0,"status":"1"},{"id":"187","tag_name":"广场","tag_alias_name":"","tag_name_py":"guangchang","state":"1","createtime":"1449576623","updatetime":"1449576623","cn_name":"广场","catename":"广场","en_name":"guangchang","catename_en":"guangchang","catename_py":"guangchang","poi_category_id":0,"parentid":0,"status":"1"},{"id":"197","tag_name":"机构","tag_alias_name":"","tag_name_py":"jigou","state":"1","createtime":"1449576623","updatetime":"1469763599","cn_name":"机构","catename":"机构","en_name":"jigou","catename_en":"jigou","catename_py":"jigou","poi_category_id":0,"parentid":0,"status":"1"}],"planto":0,"hotel_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fsearchresults.html%3Flatitude%3D22.284515%26longitude%3D114.172882%26radius%3D5%26aid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935118432510_aaid_355695-city-map-hotel-hover%26lang%3Dzh-cn%26ifl%3D%26ss%3D","discount":true,"discount_price":"<em>365<\/em>元起","hotel_count":609},{"id":"94436","chinesename":"香港杜莎夫人蜡像馆","englishname":"Madame Tussauds Hong Kong","price":0,"lat":"22.271229","lng":"114.149918","url":"//place.qyer.com/poi/V20JZ1FiBzVTYg/","rank":"9","count":1020,"category_name":"景点观光","tags":[{"id":"175","tag_name":"博物馆","tag_alias_name":"","tag_name_py":"bowuguan","state":"1","createtime":"1449576623","updatetime":"1449576623","cn_name":"博物馆","catename":"博物馆","en_name":"bowuguan","catename_en":"bowuguan","catename_py":"bowuguan","poi_category_id":0,"parentid":0,"status":"1"},{"id":"335","tag_name":"艺术馆/展览中心","tag_alias_name":"","tag_name_py":"yishuguanzhanlanzhongxin","state":"1","createtime":"1449576623","updatetime":"1469763512","cn_name":"艺术馆/展览中心","catename":"艺术馆/展览中心","en_name":"yishuguanzhanlanzhongxin","catename_en":"yishuguanzhanlanzhongxin","catename_py":"yishuguanzhanlanzhongxin","poi_category_id":0,"parentid":0,"status":"1"}],"planto":0,"hotel_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fsearchresults.html%3Flatitude%3D22.271229%26longitude%3D114.149918%26radius%3D5%26aid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935118432862_aaid_355695-city-map-hotel-hover%26lang%3Dzh-cn%26ifl%3D%26ss%3D","discount":true,"discount_price":"<em>225<\/em>元起","hotel_count":499},{"id":"56424","chinesename":"凌霄阁","englishname":"Peak Tower","price":0,"lat":"22.271261","lng":"114.149811","url":"//place.qyer.com/poi/V2EJZVFiBzRTYA/","rank":"17","count":1020,"category_name":"景点观光","tags":[{"id":"2014","tag_name":"观景台","tag_alias_name":"","tag_name_py":"guanjingtai","state":"1","createtime":"1449576624","updatetime":"1449576624","cn_name":"观景台","catename":"观景台","en_name":"guanjingtai","catename_en":"guanjingtai","catename_py":"guanjingtai","poi_category_id":0,"parentid":0,"status":"1"}],"planto":0,"hotel_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fsearchresults.html%3Flatitude%3D22.271261%26longitude%3D114.149811%26radius%3D5%26aid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935118434725_aaid_355695-city-map-hotel-hover%26lang%3Dzh-cn%26ifl%3D%26ss%3D","discount":true,"discount_price":"<em>225<\/em>元起","hotel_count":499},{"id":"83129","chinesename":"庙街夜市","englishname":"Temple Street Night Market","price":0,"lat":"22.306519","lng":"114.169983","url":"//place.qyer.com/poi/V2wJYFFnBzRTbQ/","rank":"24","count":1020,"category_name":"景点观光","tags":[{"id":"209","tag_name":"街区","tag_alias_name":"街道,大街","tag_name_py":"jiequ","state":"1","createtime":"1449576624","updatetime":"1453369085","cn_name":"街区","catename":"街区","en_name":"jiequ","catename_en":"jiequ","catename_py":"jiequ","poi_category_id":0,"parentid":0,"status":"1"}],"planto":0,"hotel_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fsearchresults.html%3Flatitude%3D22.306519%26longitude%3D114.169983%26radius%3D5%26aid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935118431280_aaid_355695-city-map-hotel-hover%26lang%3Dzh-cn%26ifl%3D%26ss%3D","discount":false,"discount_price":false,"hotel_count":610},{"id":"100028","chinesename":"尖沙咀钟楼","englishname":"Tsim Sha Tsui Clock Tower","price":0,"lat":"22.293604","lng":"114.169495","url":"//place.qyer.com/poi/V2UJY1FmBzZTZlI3/","rank":"15","count":1020,"category_name":"景点观光","tags":[{"id":"183","tag_name":"建筑","tag_alias_name":"","tag_name_py":"jianzhu","state":"1","createtime":"1449576623","updatetime":"1449576623","cn_name":"建筑","catename":"建筑","en_name":"jianzhu","catename_en":"jianzhu","catename_py":"jianzhu","poi_category_id":0,"parentid":0,"status":"1"}],"planto":0,"hotel_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fsearchresults.html%3Flatitude%3D22.293604%26longitude%3D114.169495%26radius%3D5%26aid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935118436673_aaid_355695-city-map-hotel-hover%26lang%3Dzh-cn%26ifl%3D%26ss%3D","discount":false,"discount_price":false,"hotel_count":611}]}
     */

    private int error_code;
    private String result;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        private List<ResBean> res;

        public List<ResBean> getRes() {
            return res;
        }

        public void setRes(List<ResBean> res) {
            this.res = res;
        }

        public static class ResBean implements Serializable{
            /**
             * id : 56501
             * chinesename : 星光大道
             * englishname : the Stars Avenue
             * price : 58
             * lat : 22.293015
             * lng : 114.173904
             * url : //place.qyer.com/poi/V2EJZVFjBzZTZQ/
             * rank : 6
             * count : 1020
             * category_name : 景点观光
             * tags : [{"id":"209","tag_name":"街区","tag_alias_name":"街道,大街","tag_name_py":"jiequ","state":"1","createtime":"1449576624","updatetime":"1453369085","cn_name":"街区","catename":"街区","en_name":"jiequ","catename_en":"jiequ","catename_py":"jiequ","poi_category_id":0,"parentid":0,"status":"1"}]
             * planto : 0
             * hotel_url : //www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fsearchresults.html%3Flatitude%3D22.293015%26longitude%3D114.173904%26radius%3D5%26aid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935118423820_aaid_355695-city-map-hotel-hover%26lang%3Dzh-cn%26ifl%3D%26ss%3D
             * discount : false
             * discount_price : false
             * hotel_count : 612
             */

            private String id;
            private String chinesename;
            private String englishname;
            private int price;
            private String lat;
            private String lng;
            private String url;
            private String rank;
            private int count;
            private String category_name;
            private int planto;
            private String hotel_url;
            private boolean discount;
            private boolean discount_price;
            private int hotel_count;
            private List<TagsBean> tags;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getChinesename() {
                return chinesename;
            }

            public void setChinesename(String chinesename) {
                this.chinesename = chinesename;
            }

            public String getEnglishname() {
                return englishname;
            }

            public void setEnglishname(String englishname) {
                this.englishname = englishname;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLng() {
                return lng;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getRank() {
                return rank;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public int getPlanto() {
                return planto;
            }

            public void setPlanto(int planto) {
                this.planto = planto;
            }

            public String getHotel_url() {
                return hotel_url;
            }

            public void setHotel_url(String hotel_url) {
                this.hotel_url = hotel_url;
            }

            public boolean isDiscount() {
                return discount;
            }

            public void setDiscount(boolean discount) {
                this.discount = discount;
            }

            public boolean isDiscount_price() {
                return discount_price;
            }

            public void setDiscount_price(boolean discount_price) {
                this.discount_price = discount_price;
            }

            public int getHotel_count() {
                return hotel_count;
            }

            public void setHotel_count(int hotel_count) {
                this.hotel_count = hotel_count;
            }

            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }

            public static class TagsBean implements Serializable{
                /**
                 * id : 209
                 * tag_name : 街区
                 * tag_alias_name : 街道,大街
                 * tag_name_py : jiequ
                 * state : 1
                 * createtime : 1449576624
                 * updatetime : 1453369085
                 * cn_name : 街区
                 * catename : 街区
                 * en_name : jiequ
                 * catename_en : jiequ
                 * catename_py : jiequ
                 * poi_category_id : 0
                 * parentid : 0
                 * status : 1
                 */

                private String id;
                private String tag_name;
                private String tag_alias_name;
                private String tag_name_py;
                private String state;
                private String createtime;
                private String updatetime;
                private String cn_name;
                private String catename;
                private String en_name;
                private String catename_en;
                private String catename_py;
                private int poi_category_id;
                private int parentid;
                private String status;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getTag_name() {
                    return tag_name;
                }

                public void setTag_name(String tag_name) {
                    this.tag_name = tag_name;
                }

                public String getTag_alias_name() {
                    return tag_alias_name;
                }

                public void setTag_alias_name(String tag_alias_name) {
                    this.tag_alias_name = tag_alias_name;
                }

                public String getTag_name_py() {
                    return tag_name_py;
                }

                public void setTag_name_py(String tag_name_py) {
                    this.tag_name_py = tag_name_py;
                }

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public String getCreatetime() {
                    return createtime;
                }

                public void setCreatetime(String createtime) {
                    this.createtime = createtime;
                }

                public String getUpdatetime() {
                    return updatetime;
                }

                public void setUpdatetime(String updatetime) {
                    this.updatetime = updatetime;
                }

                public String getCn_name() {
                    return cn_name;
                }

                public void setCn_name(String cn_name) {
                    this.cn_name = cn_name;
                }

                public String getCatename() {
                    return catename;
                }

                public void setCatename(String catename) {
                    this.catename = catename;
                }

                public String getEn_name() {
                    return en_name;
                }

                public void setEn_name(String en_name) {
                    this.en_name = en_name;
                }

                public String getCatename_en() {
                    return catename_en;
                }

                public void setCatename_en(String catename_en) {
                    this.catename_en = catename_en;
                }

                public String getCatename_py() {
                    return catename_py;
                }

                public void setCatename_py(String catename_py) {
                    this.catename_py = catename_py;
                }

                public int getPoi_category_id() {
                    return poi_category_id;
                }

                public void setPoi_category_id(int poi_category_id) {
                    this.poi_category_id = poi_category_id;
                }

                public int getParentid() {
                    return parentid;
                }

                public void setParentid(int parentid) {
                    this.parentid = parentid;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }
            }
        }
    }
}
