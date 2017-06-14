package com.gp.wu.graphtrip.bean;

import java.io.Serializable;

/**
 * Created by wu on 2017/4/29.
 */

public class SightAddressBean implements Serializable{

    /**
     * error_code : 0
     * result : ok
     * data : {"id":"83131","name":"维多利亚港","name_en":"Victoria Harbour","address":"九龙尖沙咀天星小轮码头\n","traffic":"搭乘港铁荃湾线至尖沙咀站，步行前往；搭乘港铁屯门线至尖东站，从L5口出站后步行前往\n","introduction":"维多利亚港简称维港，是位于中华人民共和国香港特别行政区的香港岛和九龙半岛之间的海港。东起鲤鱼门，西面海界由青衣岛至香港岛。中间尖沙咀到中环之间较窄。由于港阔水深，为天然良港，香港亦因其而拥有\u201c东方之珠\u201d、\u201c世界三大夜景\u201d之美誉。维多利亚港的名字，来自英国的维多利亚女王。一年四季都可以自由进出。早年就已经被英国人看中有成为东亚地区优良港口的潜力，后来从清政府手上夺得香港，发展其远东的海上贸易。维多利亚港一直影响香港的历史和文化，主导香港的经济和旅游业发展，是香港成为国际化大都市的关键之一。\n","rank":"1","type":{"id":"77","catename":"交通","catename_en":"transportation","catename_py":"jiaotong","parentid":"2","int1":"1","int2":"0","string1":"","string2":"","string3":"","int3":"0","float1":"25.280472","float2":"115.737564","image":null,"sub_image":""},"lat":"22.293226","lng":"114.171394"}
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
         * id : 83131
         * name : 维多利亚港
         * name_en : Victoria Harbour
         * address : 九龙尖沙咀天星小轮码头

         * traffic : 搭乘港铁荃湾线至尖沙咀站，步行前往；搭乘港铁屯门线至尖东站，从L5口出站后步行前往

         * introduction : 维多利亚港简称维港，是位于中华人民共和国香港特别行政区的香港岛和九龙半岛之间的海港。东起鲤鱼门，西面海界由青衣岛至香港岛。中间尖沙咀到中环之间较窄。由于港阔水深，为天然良港，香港亦因其而拥有“东方之珠”、“世界三大夜景”之美誉。维多利亚港的名字，来自英国的维多利亚女王。一年四季都可以自由进出。早年就已经被英国人看中有成为东亚地区优良港口的潜力，后来从清政府手上夺得香港，发展其远东的海上贸易。维多利亚港一直影响香港的历史和文化，主导香港的经济和旅游业发展，是香港成为国际化大都市的关键之一。

         * rank : 1
         * type : {"id":"77","catename":"交通","catename_en":"transportation","catename_py":"jiaotong","parentid":"2","int1":"1","int2":"0","string1":"","string2":"","string3":"","int3":"0","float1":"25.280472","float2":"115.737564","image":null,"sub_image":""}
         * lat : 22.293226
         * lng : 114.171394
         */

        private String id;
        private String name;
        private String name_en;
        private String address;
        private String traffic;
        private String introduction;
        private String rank;
        private TypeBean type;
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

        public TypeBean getType() {
            return type;
        }

        public void setType(TypeBean type) {
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

        public static class TypeBean implements Serializable{
            /**
             * id : 77
             * catename : 交通
             * catename_en : transportation
             * catename_py : jiaotong
             * parentid : 2
             * int1 : 1
             * int2 : 0
             * string1 :
             * string2 :
             * string3 :
             * int3 : 0
             * float1 : 25.280472
             * float2 : 115.737564
             * image : null
             * sub_image :
             */

            private String id;
            private String catename;
            private String catename_en;
            private String catename_py;
            private String parentid;
            private String int1;
            private String int2;
            private String string1;
            private String string2;
            private String string3;
            private String int3;
            private String float1;
            private String float2;
            private Object image;
            private String sub_image;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCatename() {
                return catename;
            }

            public void setCatename(String catename) {
                this.catename = catename;
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

            public String getParentid() {
                return parentid;
            }

            public void setParentid(String parentid) {
                this.parentid = parentid;
            }

            public String getInt1() {
                return int1;
            }

            public void setInt1(String int1) {
                this.int1 = int1;
            }

            public String getInt2() {
                return int2;
            }

            public void setInt2(String int2) {
                this.int2 = int2;
            }

            public String getString1() {
                return string1;
            }

            public void setString1(String string1) {
                this.string1 = string1;
            }

            public String getString2() {
                return string2;
            }

            public void setString2(String string2) {
                this.string2 = string2;
            }

            public String getString3() {
                return string3;
            }

            public void setString3(String string3) {
                this.string3 = string3;
            }

            public String getInt3() {
                return int3;
            }

            public void setInt3(String int3) {
                this.int3 = int3;
            }

            public String getFloat1() {
                return float1;
            }

            public void setFloat1(String float1) {
                this.float1 = float1;
            }

            public String getFloat2() {
                return float2;
            }

            public void setFloat2(String float2) {
                this.float2 = float2;
            }

            public Object getImage() {
                return image;
            }

            public void setImage(Object image) {
                this.image = image;
            }

            public String getSub_image() {
                return sub_image;
            }

            public void setSub_image(String sub_image) {
                this.sub_image = sub_image;
            }
        }
    }
}
