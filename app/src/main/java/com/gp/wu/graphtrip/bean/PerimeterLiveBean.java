package com.gp.wu.graphtrip.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wu on 2017/4/30.
 */

public class PerimeterLiveBean implements Serializable {

    /**
     * error_code : 0
     * result : ok
     * data : {"res":[{"hotel_id":"255325","hotel_index":1,"hotel_chinesename":"唯港荟","hotel_englishname":"Hotel ICON","hotel_qyer_star":"5","hotel_rank":"25","hotel_count":664,"hotel_reference_price":2367,"hotel_price":1490,"hotel_price_currency":"CNY","hotel_price_discount":37,"hotel_booking_url":"//www.qyer.com/goto.php?url=https%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Ficon-hong-kong.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184222166_hotelid_255325_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=255325","hotel_photo":"http://pic1.qyer.com/partner/299333/61661447/1465366729/90","hotel_lat":"22.3008075398","hotel_lng":"114.179556369"},{"hotel_id":"213769","hotel_index":2,"hotel_chinesename":"帝京酒店","hotel_englishname":"Royal Plaza Hotel","hotel_qyer_star":"5","hotel_rank":"17","hotel_count":664,"hotel_reference_price":2604,"hotel_price":1138,"hotel_price_currency":"CNY","hotel_price_discount":56,"hotel_booking_url":"//www.qyer.com/goto.php?url=https%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Froyal-plaza.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184225048_hotelid_213769_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=213769","hotel_photo":"http://pic.qyer.com/partner/57256/23820857/1410644909/90","hotel_lat":"22.3245866064","hotel_lng":"114.173473119"},{"hotel_id":"212982","hotel_index":3,"hotel_chinesename":"香港康得思酒店","hotel_englishname":"Cordis, Hong Kong","hotel_qyer_star":"5","hotel_rank":"1","hotel_count":664,"hotel_reference_price":1693,"hotel_price":1483,"hotel_price_currency":"CNY","hotel_price_discount":12,"hotel_booking_url":"//www.qyer.com/goto.php?url=https%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Flanghamplace.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184222733_hotelid_212982_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=212982","hotel_photo":"http://pic.qyer.com/partner/55057/53051508/1465444653/90","hotel_lat":"22.3177408935","hotel_lng":"114.168148934"},{"hotel_id":"212962","hotel_index":4,"hotel_chinesename":"港青酒店 - 香港基督教青年会","hotel_englishname":"The Salisbury - YMCA of Hong Kong","hotel_qyer_star":"4","hotel_rank":"137","hotel_count":664,"hotel_reference_price":1203,"hotel_price":720,"hotel_price_currency":"CNY","hotel_price_discount":40,"hotel_booking_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Fsalisbury.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184229095_hotelid_212962_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=212962","hotel_photo":"http://pic.qyer.com/partner/55019/30703658/1410638377/90","hotel_lat":"22.2949384526","hotel_lng":"114.170978665"},{"hotel_id":"213864","hotel_index":5,"hotel_chinesename":"铜锣湾维景酒店","hotel_englishname":"Metropark Hotel Causeway Bay Hong Kong","hotel_qyer_star":"4","hotel_rank":"67","hotel_count":664,"hotel_reference_price":1128,"hotel_price":902,"hotel_price_currency":"CNY","hotel_price_discount":20,"hotel_booking_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Fmetropark-causeway-bay.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184223649_hotelid_213864_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=213864","hotel_photo":"http://pic.qyer.com/partner/57591/13376090/1410645704/90","hotel_lat":"22.2811767722","hotel_lng":"114.192095696"},{"hotel_id":"235102","hotel_index":6,"hotel_chinesename":"香港洲际酒店","hotel_englishname":"InterContinental Hong Kong","hotel_qyer_star":"5","hotel_rank":"116","hotel_count":664,"hotel_reference_price":3709,"hotel_price":1836,"hotel_price_currency":"CNY","hotel_price_discount":51,"hotel_booking_url":"//www.qyer.com/goto.php?url=https%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Fintercontinental-hong-kong-hong-kong.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184225806_hotelid_235102_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=235102","hotel_photo":"http://pic3.qyer.com/partner/235442/14732827/1465363135/90","hotel_lat":"22.2936504465","hotel_lng":"114.173762798"},{"hotel_id":"230355","hotel_index":7,"hotel_chinesename":"九龙香格里拉大酒店","hotel_englishname":"Kowloon Shangri-La","hotel_qyer_star":"5","hotel_rank":"7","hotel_count":664,"hotel_reference_price":2241,"hotel_price":1951,"hotel_price_currency":"CNY","hotel_price_discount":13,"hotel_booking_url":"//www.qyer.com/goto.php?url=https%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Fkowloon-shangri-la.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184226738_hotelid_230355_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=230355","hotel_photo":"http://pic.qyer.com/partner/180560/14563030/1410866920/90","hotel_lat":"22.2970975112","hotel_lng":"114.176745414"},{"hotel_id":"231425","hotel_index":8,"hotel_chinesename":"海景嘉福洲際酒店","hotel_englishname":"InterContinental Grand Stanford Hong Kong","hotel_qyer_star":"5","hotel_rank":"57","hotel_count":664,"hotel_reference_price":1294,"hotel_price":1242,"hotel_price_currency":"CNY","hotel_price_discount":4,"hotel_booking_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Fintercontinental-grand-stanford-hong-kong.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184225796_hotelid_231425_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=231425","hotel_photo":"http://pic.qyer.com/partner/183959/40997595/1438125226/90","hotel_lat":"22.2991250106","hotel_lng":"114.179223775"},{"hotel_id":"219815","hotel_index":9,"hotel_chinesename":"香港JW万豪酒店","hotel_englishname":"JW Marriott Hotel Hong Kong","hotel_qyer_star":"5","hotel_rank":"5","hotel_count":664,"hotel_reference_price":2210,"hotel_price":1809,"hotel_price_currency":"CNY","hotel_price_discount":18,"hotel_booking_url":"//www.qyer.com/goto.php?url=https%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Fjw-marriott-hong-kong.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184229369_hotelid_219815_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=219815","hotel_photo":"http://pic.qyer.com/partner/76725/17269724/1461885687/90","hotel_lat":"22.2775456467","hotel_lng":"114.166118502"},{"hotel_id":"212972","hotel_index":10,"hotel_chinesename":"香港朗廷酒店","hotel_englishname":"The Langham Hong Kong","hotel_qyer_star":"5","hotel_rank":"59","hotel_count":664,"hotel_reference_price":1697,"hotel_price":1516,"hotel_price_currency":"CNY","hotel_price_discount":11,"hotel_booking_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Flangham.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184222138_hotelid_212972_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=212972","hotel_photo":"http://pic.qyer.com/partner/55039/38889045/1455232882/90","hotel_lat":"22.2964224988","hotel_lng":"114.169895052"},{"hotel_id":"212995","hotel_index":11,"hotel_chinesename":"富豪机场酒店","hotel_englishname":"Regal Airport Hotel","hotel_qyer_star":"5","hotel_rank":"6","hotel_count":664,"hotel_reference_price":1953,"hotel_price":898,"hotel_price_currency":"CNY","hotel_price_discount":54,"hotel_booking_url":"//www.qyer.com/goto.php?url=https%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Fregal-airport.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184226448_hotelid_212995_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=212995","hotel_photo":"https://pic.qyer.com/partner/55075/83288826/1484090032/90","hotel_lat":"22.3192122911","hotel_lng":"113.934316635"},{"hotel_id":"432854","hotel_index":12,"hotel_chinesename":"港岛英迪格酒店","hotel_englishname":"Hotel Indigo Hong Kong Island","hotel_qyer_star":"4","hotel_rank":"62","hotel_count":664,"hotel_reference_price":1815,"hotel_price":1437,"hotel_price_currency":"CNY","hotel_price_discount":21,"hotel_booking_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Findigo.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184224458_hotelid_432854_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=432854","hotel_photo":"http://pic.qyer.com/partner/478423/21981360/1418016348/90","hotel_lat":"22.2744927478","hotel_lng":"114.173369854"},{"hotel_id":"306361","hotel_index":13,"hotel_chinesename":"奕居","hotel_englishname":"The Upper House","hotel_qyer_star":"5","hotel_rank":"119","hotel_count":664,"hotel_reference_price":7102,"hotel_price":4257,"hotel_price_currency":"CNY","hotel_price_discount":40,"hotel_booking_url":"//www.qyer.com/goto.php?url=https%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Fthe-upper-house.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184223419_hotelid_306361_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=306361","hotel_photo":"http://pic.qyer.com/partner/538224/16087729/1413319255/90","hotel_lat":"22.2774773088","hotel_lng":"114.166565090"},{"hotel_id":"241867","hotel_index":14,"hotel_chinesename":"香港君悦酒店","hotel_englishname":"Grand Hyatt Hong Kong","hotel_qyer_star":"5","hotel_rank":"3","hotel_count":664,"hotel_reference_price":2446,"hotel_price":2128,"hotel_price_currency":"CNY","hotel_price_discount":13,"hotel_booking_url":"//www.qyer.com/goto.php?url=https%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Fgrand-hyatt-hong-kong.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184225233_hotelid_241867_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=241867","hotel_photo":"http://pic.qyer.com/partner/255814/21756001/1411081785/90","hotel_lat":"22.2812189652","hotel_lng":"114.172099828"},{"hotel_id":"294710","hotel_index":15,"hotel_chinesename":"香港四季酒店","hotel_englishname":"Four Seasons Hotel Hong Kong","hotel_qyer_star":"5","hotel_rank":"49","hotel_count":664,"hotel_reference_price":9075,"hotel_price":3505,"hotel_price_currency":"CNY","hotel_price_discount":61,"hotel_booking_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Ffour-seasons-hong-kong.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184222878_hotelid_294710_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=294710","hotel_photo":"http://pic2.qyer.com/partner/455762/83051185/1482276033/90","hotel_lat":"22.2865153234","hotel_lng":"114.156602025"}],"count":664,"counts":664,"pager":"<div class=\"ui_page\"><a data-bn-ipg=\"pages-3\" data-ra_arg=\"ra_null|1\" href=\"javascript:1(1)\" class='ui_page_item ui_page_item_current'>1<\/a>\n<a data-bn-ipg=\"pages-3\" data-ra_arg=\"ra_null|2\" href=\"javascript:1(2)\" class='ui_page_item'>2<\/a>\n<a data-bn-ipg=\"pages-3\" data-ra_arg=\"ra_null|3\" href=\"javascript:1(3)\" class='ui_page_item'>3<\/a>\n<a data-bn-ipg=\"pages-3\" data-ra_arg=\"ra_null|4\" href=\"javascript:1(4)\" class='ui_page_item'>4<\/a>\n<a data-bn-ipg=\"pages-3\" data-ra_arg=\"ra_null|5\" href=\"javascript:1(5)\" class='ui_page_item'>5<\/a>\n<a data-bn-ipg=\"pages-4\" data-ra_arg=\"ra_null|45\" href=\"javascript:1(45)\" class='ui_page_item' title=\"...45\">...45<\/a>\n<a data-bn-ipg=\"pages-5\" data-ra_arg=\"ra_null|2\" href=\"javascript:1(2)\" class='ui_page_item ui_page_next' title=\"下一页\">下一页<\/a>\n<\/div>"}
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
        /**
         * res : [{"hotel_id":"255325","hotel_index":1,"hotel_chinesename":"唯港荟","hotel_englishname":"Hotel ICON","hotel_qyer_star":"5","hotel_rank":"25","hotel_count":664,"hotel_reference_price":2367,"hotel_price":1490,"hotel_price_currency":"CNY","hotel_price_discount":37,"hotel_booking_url":"//www.qyer.com/goto.php?url=https%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Ficon-hong-kong.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184222166_hotelid_255325_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=255325","hotel_photo":"http://pic1.qyer.com/partner/299333/61661447/1465366729/90","hotel_lat":"22.3008075398","hotel_lng":"114.179556369"},{"hotel_id":"213769","hotel_index":2,"hotel_chinesename":"帝京酒店","hotel_englishname":"Royal Plaza Hotel","hotel_qyer_star":"5","hotel_rank":"17","hotel_count":664,"hotel_reference_price":2604,"hotel_price":1138,"hotel_price_currency":"CNY","hotel_price_discount":56,"hotel_booking_url":"//www.qyer.com/goto.php?url=https%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Froyal-plaza.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184225048_hotelid_213769_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=213769","hotel_photo":"http://pic.qyer.com/partner/57256/23820857/1410644909/90","hotel_lat":"22.3245866064","hotel_lng":"114.173473119"},{"hotel_id":"212982","hotel_index":3,"hotel_chinesename":"香港康得思酒店","hotel_englishname":"Cordis, Hong Kong","hotel_qyer_star":"5","hotel_rank":"1","hotel_count":664,"hotel_reference_price":1693,"hotel_price":1483,"hotel_price_currency":"CNY","hotel_price_discount":12,"hotel_booking_url":"//www.qyer.com/goto.php?url=https%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Flanghamplace.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184222733_hotelid_212982_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=212982","hotel_photo":"http://pic.qyer.com/partner/55057/53051508/1465444653/90","hotel_lat":"22.3177408935","hotel_lng":"114.168148934"},{"hotel_id":"212962","hotel_index":4,"hotel_chinesename":"港青酒店 - 香港基督教青年会","hotel_englishname":"The Salisbury - YMCA of Hong Kong","hotel_qyer_star":"4","hotel_rank":"137","hotel_count":664,"hotel_reference_price":1203,"hotel_price":720,"hotel_price_currency":"CNY","hotel_price_discount":40,"hotel_booking_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Fsalisbury.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184229095_hotelid_212962_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=212962","hotel_photo":"http://pic.qyer.com/partner/55019/30703658/1410638377/90","hotel_lat":"22.2949384526","hotel_lng":"114.170978665"},{"hotel_id":"213864","hotel_index":5,"hotel_chinesename":"铜锣湾维景酒店","hotel_englishname":"Metropark Hotel Causeway Bay Hong Kong","hotel_qyer_star":"4","hotel_rank":"67","hotel_count":664,"hotel_reference_price":1128,"hotel_price":902,"hotel_price_currency":"CNY","hotel_price_discount":20,"hotel_booking_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Fmetropark-causeway-bay.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184223649_hotelid_213864_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=213864","hotel_photo":"http://pic.qyer.com/partner/57591/13376090/1410645704/90","hotel_lat":"22.2811767722","hotel_lng":"114.192095696"},{"hotel_id":"235102","hotel_index":6,"hotel_chinesename":"香港洲际酒店","hotel_englishname":"InterContinental Hong Kong","hotel_qyer_star":"5","hotel_rank":"116","hotel_count":664,"hotel_reference_price":3709,"hotel_price":1836,"hotel_price_currency":"CNY","hotel_price_discount":51,"hotel_booking_url":"//www.qyer.com/goto.php?url=https%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Fintercontinental-hong-kong-hong-kong.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184225806_hotelid_235102_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=235102","hotel_photo":"http://pic3.qyer.com/partner/235442/14732827/1465363135/90","hotel_lat":"22.2936504465","hotel_lng":"114.173762798"},{"hotel_id":"230355","hotel_index":7,"hotel_chinesename":"九龙香格里拉大酒店","hotel_englishname":"Kowloon Shangri-La","hotel_qyer_star":"5","hotel_rank":"7","hotel_count":664,"hotel_reference_price":2241,"hotel_price":1951,"hotel_price_currency":"CNY","hotel_price_discount":13,"hotel_booking_url":"//www.qyer.com/goto.php?url=https%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Fkowloon-shangri-la.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184226738_hotelid_230355_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=230355","hotel_photo":"http://pic.qyer.com/partner/180560/14563030/1410866920/90","hotel_lat":"22.2970975112","hotel_lng":"114.176745414"},{"hotel_id":"231425","hotel_index":8,"hotel_chinesename":"海景嘉福洲際酒店","hotel_englishname":"InterContinental Grand Stanford Hong Kong","hotel_qyer_star":"5","hotel_rank":"57","hotel_count":664,"hotel_reference_price":1294,"hotel_price":1242,"hotel_price_currency":"CNY","hotel_price_discount":4,"hotel_booking_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Fintercontinental-grand-stanford-hong-kong.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184225796_hotelid_231425_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=231425","hotel_photo":"http://pic.qyer.com/partner/183959/40997595/1438125226/90","hotel_lat":"22.2991250106","hotel_lng":"114.179223775"},{"hotel_id":"219815","hotel_index":9,"hotel_chinesename":"香港JW万豪酒店","hotel_englishname":"JW Marriott Hotel Hong Kong","hotel_qyer_star":"5","hotel_rank":"5","hotel_count":664,"hotel_reference_price":2210,"hotel_price":1809,"hotel_price_currency":"CNY","hotel_price_discount":18,"hotel_booking_url":"//www.qyer.com/goto.php?url=https%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Fjw-marriott-hong-kong.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184229369_hotelid_219815_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=219815","hotel_photo":"http://pic.qyer.com/partner/76725/17269724/1461885687/90","hotel_lat":"22.2775456467","hotel_lng":"114.166118502"},{"hotel_id":"212972","hotel_index":10,"hotel_chinesename":"香港朗廷酒店","hotel_englishname":"The Langham Hong Kong","hotel_qyer_star":"5","hotel_rank":"59","hotel_count":664,"hotel_reference_price":1697,"hotel_price":1516,"hotel_price_currency":"CNY","hotel_price_discount":11,"hotel_booking_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Flangham.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184222138_hotelid_212972_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=212972","hotel_photo":"http://pic.qyer.com/partner/55039/38889045/1455232882/90","hotel_lat":"22.2964224988","hotel_lng":"114.169895052"},{"hotel_id":"212995","hotel_index":11,"hotel_chinesename":"富豪机场酒店","hotel_englishname":"Regal Airport Hotel","hotel_qyer_star":"5","hotel_rank":"6","hotel_count":664,"hotel_reference_price":1953,"hotel_price":898,"hotel_price_currency":"CNY","hotel_price_discount":54,"hotel_booking_url":"//www.qyer.com/goto.php?url=https%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Fregal-airport.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184226448_hotelid_212995_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=212995","hotel_photo":"https://pic.qyer.com/partner/55075/83288826/1484090032/90","hotel_lat":"22.3192122911","hotel_lng":"113.934316635"},{"hotel_id":"432854","hotel_index":12,"hotel_chinesename":"港岛英迪格酒店","hotel_englishname":"Hotel Indigo Hong Kong Island","hotel_qyer_star":"4","hotel_rank":"62","hotel_count":664,"hotel_reference_price":1815,"hotel_price":1437,"hotel_price_currency":"CNY","hotel_price_discount":21,"hotel_booking_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Findigo.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184224458_hotelid_432854_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=432854","hotel_photo":"http://pic.qyer.com/partner/478423/21981360/1418016348/90","hotel_lat":"22.2744927478","hotel_lng":"114.173369854"},{"hotel_id":"306361","hotel_index":13,"hotel_chinesename":"奕居","hotel_englishname":"The Upper House","hotel_qyer_star":"5","hotel_rank":"119","hotel_count":664,"hotel_reference_price":7102,"hotel_price":4257,"hotel_price_currency":"CNY","hotel_price_discount":40,"hotel_booking_url":"//www.qyer.com/goto.php?url=https%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Fthe-upper-house.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184223419_hotelid_306361_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=306361","hotel_photo":"http://pic.qyer.com/partner/538224/16087729/1413319255/90","hotel_lat":"22.2774773088","hotel_lng":"114.166565090"},{"hotel_id":"241867","hotel_index":14,"hotel_chinesename":"香港君悦酒店","hotel_englishname":"Grand Hyatt Hong Kong","hotel_qyer_star":"5","hotel_rank":"3","hotel_count":664,"hotel_reference_price":2446,"hotel_price":2128,"hotel_price_currency":"CNY","hotel_price_discount":13,"hotel_booking_url":"//www.qyer.com/goto.php?url=https%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Fgrand-hyatt-hong-kong.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184225233_hotelid_241867_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=241867","hotel_photo":"http://pic.qyer.com/partner/255814/21756001/1411081785/90","hotel_lat":"22.2812189652","hotel_lng":"114.172099828"},{"hotel_id":"294710","hotel_index":15,"hotel_chinesename":"香港四季酒店","hotel_englishname":"Four Seasons Hotel Hong Kong","hotel_qyer_star":"5","hotel_rank":"49","hotel_count":664,"hotel_reference_price":9075,"hotel_price":3505,"hotel_price_currency":"CNY","hotel_price_discount":61,"hotel_booking_url":"//www.qyer.com/goto.php?url=http%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Ffour-seasons-hong-kong.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184222878_hotelid_294710_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=294710","hotel_photo":"http://pic2.qyer.com/partner/455762/83051185/1482276033/90","hotel_lat":"22.2865153234","hotel_lng":"114.156602025"}]
         * count : 664
         * counts : 664
         * pager : <div class="ui_page"><a data-bn-ipg="pages-3" data-ra_arg="ra_null|1" href="javascript:1(1)" class='ui_page_item ui_page_item_current'>1</a>
         <a data-bn-ipg="pages-3" data-ra_arg="ra_null|2" href="javascript:1(2)" class='ui_page_item'>2</a>
         <a data-bn-ipg="pages-3" data-ra_arg="ra_null|3" href="javascript:1(3)" class='ui_page_item'>3</a>
         <a data-bn-ipg="pages-3" data-ra_arg="ra_null|4" href="javascript:1(4)" class='ui_page_item'>4</a>
         <a data-bn-ipg="pages-3" data-ra_arg="ra_null|5" href="javascript:1(5)" class='ui_page_item'>5</a>
         <a data-bn-ipg="pages-4" data-ra_arg="ra_null|45" href="javascript:1(45)" class='ui_page_item' title="...45">...45</a>
         <a data-bn-ipg="pages-5" data-ra_arg="ra_null|2" href="javascript:1(2)" class='ui_page_item ui_page_next' title="下一页">下一页</a>
         </div>
         */

        private int count;
        private int counts;
        private String pager;
        private List<ResBean> res;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getCounts() {
            return counts;
        }

        public void setCounts(int counts) {
            this.counts = counts;
        }

        public String getPager() {
            return pager;
        }

        public void setPager(String pager) {
            this.pager = pager;
        }

        public List<ResBean> getRes() {
            return res;
        }

        public void setRes(List<ResBean> res) {
            this.res = res;
        }

        public static class ResBean implements Serializable{
            /**
             * hotel_id : 255325
             * hotel_index : 1
             * hotel_chinesename : 唯港荟
             * hotel_englishname : Hotel ICON
             * hotel_qyer_star : 5
             * hotel_rank : 25
             * hotel_count : 664
             * hotel_reference_price : 2367
             * hotel_price : 1490
             * hotel_price_currency : CNY
             * hotel_price_discount : 37
             * hotel_booking_url : //www.qyer.com/goto.php?url=https%3A%2F%2Fwww.booking.com%2Fhotel%2Fhk%2Ficon-hong-kong.html%3Faid%3D355695%26si%3Dai%252Cco%252Cci%252Cre%252Cdi%26label%3Dguid_357e59ca-ef52-3e4f-42f8-18cb2be3ad37_datetime_14935184222166_hotelid_255325_aaid_355695-map-hotel-list%26lang%3Dzh-cn%26ifl%3D%26ss%3D&hotelid=255325
             * hotel_photo : http://pic1.qyer.com/partner/299333/61661447/1465366729/90
             * hotel_lat : 22.3008075398
             * hotel_lng : 114.179556369
             */

            private String hotel_id;
            private int hotel_index;
            private String hotel_chinesename;
            private String hotel_englishname;
            private String hotel_qyer_star;
            private String hotel_rank;
            private int hotel_count;
            private int hotel_reference_price;
            private int hotel_price;
            private String hotel_price_currency;
            private Object hotel_price_discount;
            private String hotel_booking_url;
            private String hotel_photo;
            private String hotel_lat;
            private String hotel_lng;

            public String getHotel_id() {
                return hotel_id;
            }

            public void setHotel_id(String hotel_id) {
                this.hotel_id = hotel_id;
            }

            public int getHotel_index() {
                return hotel_index;
            }

            public void setHotel_index(int hotel_index) {
                this.hotel_index = hotel_index;
            }

            public String getHotel_chinesename() {
                return hotel_chinesename;
            }

            public void setHotel_chinesename(String hotel_chinesename) {
                this.hotel_chinesename = hotel_chinesename;
            }

            public String getHotel_englishname() {
                return hotel_englishname;
            }

            public void setHotel_englishname(String hotel_englishname) {
                this.hotel_englishname = hotel_englishname;
            }

            public String getHotel_qyer_star() {
                return hotel_qyer_star;
            }

            public void setHotel_qyer_star(String hotel_qyer_star) {
                this.hotel_qyer_star = hotel_qyer_star;
            }

            public String getHotel_rank() {
                return hotel_rank;
            }

            public void setHotel_rank(String hotel_rank) {
                this.hotel_rank = hotel_rank;
            }

            public int getHotel_count() {
                return hotel_count;
            }

            public void setHotel_count(int hotel_count) {
                this.hotel_count = hotel_count;
            }

            public int getHotel_reference_price() {
                return hotel_reference_price;
            }

            public void setHotel_reference_price(int hotel_reference_price) {
                this.hotel_reference_price = hotel_reference_price;
            }

            public int getHotel_price() {
                return hotel_price;
            }

            public void setHotel_price(int hotel_price) {
                this.hotel_price = hotel_price;
            }

            public String getHotel_price_currency() {
                return hotel_price_currency;
            }

            public void setHotel_price_currency(String hotel_price_currency) {
                this.hotel_price_currency = hotel_price_currency;
            }

            public Object getHotel_price_discount() {
                return hotel_price_discount;
            }

            public void setHotel_price_discount(Object hotel_price_discount) {
                this.hotel_price_discount = hotel_price_discount;
            }

            public String getHotel_booking_url() {
                return hotel_booking_url;
            }

            public void setHotel_booking_url(String hotel_booking_url) {
                this.hotel_booking_url = hotel_booking_url;
            }

            public String getHotel_photo() {
                return hotel_photo;
            }

            public void setHotel_photo(String hotel_photo) {
                this.hotel_photo = hotel_photo;
            }

            public String getHotel_lat() {
                return hotel_lat;
            }

            public void setHotel_lat(String hotel_lat) {
                this.hotel_lat = hotel_lat;
            }

            public String getHotel_lng() {
                return hotel_lng;
            }

            public void setHotel_lng(String hotel_lng) {
                this.hotel_lng = hotel_lng;
            }
        }
    }
}
