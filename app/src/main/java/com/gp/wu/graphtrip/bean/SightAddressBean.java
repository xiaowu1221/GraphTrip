package com.gp.wu.graphtrip.bean;

import java.io.Serializable;

/**
 * Created by wu on 2017/4/29.
 */

public class SightAddressBean implements Serializable{

    /**
     * error_code : 0
     * result : ok
     * data : {"id":"101047","name":"三仙台","name_en":"","address":"台东县成功镇三仙里基翬路74号\n","traffic":"1.搭台铁至花莲站下-转搭花莲客运(往台东、成功)至三仙台站下。\n2.搭台铁至台东站下-转搭鼎东客运(往静埔)至三仙台站下。\n","introduction":"三仙台位于成功东北方约3公里处(11号省道112K处)，是由突出的海岬与离岸小岛所构成的。因岛上有三块巨石，民间穿凿附会传说八仙过海时吕洞宾，何仙姑，李铁拐曾登临此处而声名大噪。\n\n三仙台地质属都峦山火山集块岩，原来是一处岬角，因海水侵蚀逐渐断了岬角颈部，而成了离岸岛。附近海域鱼类丰富，是渔场亦是有名的矶钓场所，也是各级潜水的好地方。\n\n三仙台的八拱红色跨海步桥，造型如长龙卧波，气势壮观；岛上地形景观与生态资源极为独特稀有，海岸植物种类繁多，是研究海岸植物生态的重要据点，可循规划良好的步道观赏沿途生态及地质观赏。上岛游览约需 2小时，游走其间可欣赏壶穴，海蚀洞，海蚀沟、海蚀凹璧等特殊地形，以及珍贵稀有的海滨植物。\n\n三仙台游客服务中心\n三仙台是台东最热门的风景区，到东部海岸的游客莫不到此一游，东管处在此设有游客服务中心，提供旅游谘询服务，服务中心的展示室，以三仙台岛之介绍为主轴，游客不须辛苦过桥，即可在此身历其境的了解三仙台岛的著名景观与多样生态。\n","rank":"4","type":"路线","lat":"23.123528","lng":"121.413048"}
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
         * id : 101047
         * name : 三仙台
         * name_en :
         * address : 台东县成功镇三仙里基翬路74号

         * traffic : 1.搭台铁至花莲站下-转搭花莲客运(往台东、成功)至三仙台站下。
         2.搭台铁至台东站下-转搭鼎东客运(往静埔)至三仙台站下。

         * introduction : 三仙台位于成功东北方约3公里处(11号省道112K处)，是由突出的海岬与离岸小岛所构成的。因岛上有三块巨石，民间穿凿附会传说八仙过海时吕洞宾，何仙姑，李铁拐曾登临此处而声名大噪。

         三仙台地质属都峦山火山集块岩，原来是一处岬角，因海水侵蚀逐渐断了岬角颈部，而成了离岸岛。附近海域鱼类丰富，是渔场亦是有名的矶钓场所，也是各级潜水的好地方。

         三仙台的八拱红色跨海步桥，造型如长龙卧波，气势壮观；岛上地形景观与生态资源极为独特稀有，海岸植物种类繁多，是研究海岸植物生态的重要据点，可循规划良好的步道观赏沿途生态及地质观赏。上岛游览约需 2小时，游走其间可欣赏壶穴，海蚀洞，海蚀沟、海蚀凹璧等特殊地形，以及珍贵稀有的海滨植物。

         三仙台游客服务中心
         三仙台是台东最热门的风景区，到东部海岸的游客莫不到此一游，东管处在此设有游客服务中心，提供旅游谘询服务，服务中心的展示室，以三仙台岛之介绍为主轴，游客不须辛苦过桥，即可在此身历其境的了解三仙台岛的著名景观与多样生态。

         * rank : 4
         * type : 路线
         * lat : 23.123528
         * lng : 121.413048
         */

        private String id;
        private String name;
        private String name_en;
        private String address;
        private String traffic;
        private String introduction;
        private String rank;
        private String type;
        private String lat;
        private String lng;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTraffic() {
            return traffic;
        }

        public void setTraffic(String traffic) {
            this.traffic = traffic;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
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
    }
}
