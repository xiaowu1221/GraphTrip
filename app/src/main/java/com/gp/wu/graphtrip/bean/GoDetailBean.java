package com.gp.wu.graphtrip.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wu on 2017/5/7.
 */

public class GoDetailBean implements Serializable{

    /**
     * error_code : 0
     * result : ok
     * data : {"chinesename":"星光大道","englishname":"the Stars Avenue","introduction":"<p>星光大道位于香港九龙尖沙咀东部的尖沙咀海滨花园，是为表扬香港电影界的杰出人士而设置的特色景点。它仿效美国好莱坞星光大道，将逾百名电影工作者的芳名与手掌印镶嵌在特制的纪念牌匾，以年代依次排列在星光大道上，表扬他们为香港百年电影业所作的贡献。在尖沙咀海旁，还可以观赏两米高的李小龙铜像、电影发展里程碑。当你漫步在星光大道上，在观看众多名人手印同时，还可以欣赏到香港著名的维多利亚港景色、香港岛沿岸特色建筑，这里还是香港崭新的多媒体灯光音乐汇演－幻彩咏香江的理想观赏点。<\/p>\n","url":"//place.qyer.com/poi/V2EJZVFjBzZTZQ/","photo":["https://pic.qyer.com/album/user/213/10/Q0hWQxoEZw/index/90","https://pic.qyer.com/album/184/56/1856951/index/90"],"discount":[],"hotel":{"url":"https://www.booking.com/hotel/hk/apple-inn-tsim-sha-tsui.html","price":62,"currency_code":"CNY","nearby_hotel_count":613,"search_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fsearchresults.html%3Flatitude%3D22.293015%26longitude%3D114.173904%26radius%3D5000%26aid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14941688958854_aaid_355695-city-map-hotel-hover%26lang%3Dzh-cn%26ifl%3D%26ss%3D","percent":92},"planto":0}
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

    public static class DataBean implements Serializable {
        /**
         * chinesename : 星光大道
         * englishname : the Stars Avenue
         * introduction : <p>星光大道位于香港九龙尖沙咀东部的尖沙咀海滨花园，是为表扬香港电影界的杰出人士而设置的特色景点。它仿效美国好莱坞星光大道，将逾百名电影工作者的芳名与手掌印镶嵌在特制的纪念牌匾，以年代依次排列在星光大道上，表扬他们为香港百年电影业所作的贡献。在尖沙咀海旁，还可以观赏两米高的李小龙铜像、电影发展里程碑。当你漫步在星光大道上，在观看众多名人手印同时，还可以欣赏到香港著名的维多利亚港景色、香港岛沿岸特色建筑，这里还是香港崭新的多媒体灯光音乐汇演－幻彩咏香江的理想观赏点。</p>

         * url : //place.qyer.com/poi/V2EJZVFjBzZTZQ/
         * photo : ["https://pic.qyer.com/album/user/213/10/Q0hWQxoEZw/index/90","https://pic.qyer.com/album/184/56/1856951/index/90"]
         * discount : []
         * hotel : {"url":"https://www.booking.com/hotel/hk/apple-inn-tsim-sha-tsui.html","price":62,"currency_code":"CNY","nearby_hotel_count":613,"search_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fsearchresults.html%3Flatitude%3D22.293015%26longitude%3D114.173904%26radius%3D5000%26aid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14941688958854_aaid_355695-city-map-hotel-hover%26lang%3Dzh-cn%26ifl%3D%26ss%3D","percent":92}
         * planto : 0
         */

        private String chinesename;
        private String englishname;
        private String introduction;
        private String url;
        private HotelBean hotel;
        private int planto;
        private List<String> photo;
        private List<?> discount;

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

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public HotelBean getHotel() {
            return hotel;
        }

        public void setHotel(HotelBean hotel) {
            this.hotel = hotel;
        }

        public int getPlanto() {
            return planto;
        }

        public void setPlanto(int planto) {
            this.planto = planto;
        }

        public List<String> getPhoto() {
            return photo;
        }

        public void setPhoto(List<String> photo) {
            this.photo = photo;
        }

        public List<?> getDiscount() {
            return discount;
        }

        public void setDiscount(List<?> discount) {
            this.discount = discount;
        }

        public static class DiscountBean implements Serializable {
            /**
             * title : 台湾台北101大楼观景台+故宫博物院联票（实体票包邮/门市领取）
             * price : <em>180</em>元起
             * url : //z.qyer.com/deal/63095/
             */

            private String title;
            private String price;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
        public static class HotelBean implements Serializable{
            /**
             * url : https://www.booking.com/hotel/hk/apple-inn-tsim-sha-tsui.html
             * price : 62
             * currency_code : CNY
             * nearby_hotel_count : 613
             * search_url : //www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fsearchresults.html%3Flatitude%3D22.293015%26longitude%3D114.173904%26radius%3D5000%26aid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14941688958854_aaid_355695-city-map-hotel-hover%26lang%3Dzh-cn%26ifl%3D%26ss%3D
             * percent : 92
             */

            private String url;
            private int price;
            private String currency_code;
            private int nearby_hotel_count;
            private String search_url;
            private int percent;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public String getCurrency_code() {
                return currency_code;
            }

            public void setCurrency_code(String currency_code) {
                this.currency_code = currency_code;
            }

            public int getNearby_hotel_count() {
                return nearby_hotel_count;
            }

            public void setNearby_hotel_count(int nearby_hotel_count) {
                this.nearby_hotel_count = nearby_hotel_count;
            }

            public String getSearch_url() {
                return search_url;
            }

            public void setSearch_url(String search_url) {
                this.search_url = search_url;
            }

            public int getPercent() {
                return percent;
            }

            public void setPercent(int percent) {
                this.percent = percent;
            }
        }
    }

}
