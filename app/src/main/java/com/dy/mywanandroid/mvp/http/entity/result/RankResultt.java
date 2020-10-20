package com.dy.mywanandroid.mvp.http.entity.result;

import java.util.List;

public class RankResultt {

    /**
     * data : {"curPage":1,"datas":[{"coinCount":23431,"level":235,"rank":"1","userId":20382,"username":"g**eii"},{"coinCount":20211,"level":203,"rank":"2","userId":29303,"username":"深**士"},{"coinCount":19707,"level":198,"rank":"3","userId":3559,"username":"A**ilEyon"},{"coinCount":16691,"level":167,"rank":"4","userId":2,"username":"x**oyang"},{"coinCount":12503,"level":126,"rank":"5","userId":28694,"username":"c**ng0218"},{"coinCount":12404,"level":125,"rank":"6","userId":3753,"username":"S**phenCurry"},{"coinCount":12295,"level":123,"rank":"7","userId":29185,"username":"轻**宇"},{"coinCount":12161,"level":122,"rank":"8","userId":12467,"username":"c**yie"},{"coinCount":12102,"level":122,"rank":"9","userId":27535,"username":"1**08491840"},{"coinCount":12043,"level":121,"rank":"10","userId":1534,"username":"j**gbin"},{"coinCount":11964,"level":120,"rank":"11","userId":9621,"username":"S**24n"},{"coinCount":11918,"level":120,"rank":"12","userId":28607,"username":"S**Brother"},{"coinCount":11844,"level":119,"rank":"13","userId":27,"username":"y**ochoo"},{"coinCount":11804,"level":119,"rank":"14","userId":7891,"username":"h**zkp"},{"coinCount":11778,"level":118,"rank":"15","userId":14829,"username":"l**changwen"},{"coinCount":11766,"level":118,"rank":"16","userId":12351,"username":"w**igeny"},{"coinCount":11650,"level":117,"rank":"17","userId":26707,"username":"p**xc.com"},{"coinCount":11599,"level":116,"rank":"18","userId":833,"username":"w**lwaywang6"},{"coinCount":11547,"level":116,"rank":"19","userId":12331,"username":"R**kieJay"},{"coinCount":11475,"level":115,"rank":"20","userId":7809,"username":"1**23822235"},{"coinCount":11424,"level":115,"rank":"21","userId":7710,"username":"i**Cola7"},{"coinCount":11282,"level":113,"rank":"22","userId":7590,"username":"陈**啦啦啦"},{"coinCount":11272,"level":113,"rank":"23","userId":4886,"username":"z**iyun"},{"coinCount":11199,"level":112,"rank":"24","userId":29076,"username":"f**ham"},{"coinCount":11050,"level":111,"rank":"25","userId":2068,"username":"i**Cola"},{"coinCount":10800,"level":108,"rank":"26","userId":2160,"username":"R**iner"},{"coinCount":10735,"level":108,"rank":"27","userId":25419,"username":"蔡**打篮球"},{"coinCount":10653,"level":107,"rank":"28","userId":3825,"username":"请**娃哈哈"},{"coinCount":10653,"level":107,"rank":"29","userId":25128,"username":"f**wandroid"},{"coinCount":10266,"level":103,"rank":"30","userId":25793,"username":"F**_2014"}],"offset":0,"over":false,"pageCount":1718,"size":30,"total":51517}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        /**
         * curPage : 1
         * datas : [{"coinCount":23431,"level":235,"rank":"1","userId":20382,"username":"g**eii"},{"coinCount":20211,"level":203,"rank":"2","userId":29303,"username":"深**士"},{"coinCount":19707,"level":198,"rank":"3","userId":3559,"username":"A**ilEyon"},{"coinCount":16691,"level":167,"rank":"4","userId":2,"username":"x**oyang"},{"coinCount":12503,"level":126,"rank":"5","userId":28694,"username":"c**ng0218"},{"coinCount":12404,"level":125,"rank":"6","userId":3753,"username":"S**phenCurry"},{"coinCount":12295,"level":123,"rank":"7","userId":29185,"username":"轻**宇"},{"coinCount":12161,"level":122,"rank":"8","userId":12467,"username":"c**yie"},{"coinCount":12102,"level":122,"rank":"9","userId":27535,"username":"1**08491840"},{"coinCount":12043,"level":121,"rank":"10","userId":1534,"username":"j**gbin"},{"coinCount":11964,"level":120,"rank":"11","userId":9621,"username":"S**24n"},{"coinCount":11918,"level":120,"rank":"12","userId":28607,"username":"S**Brother"},{"coinCount":11844,"level":119,"rank":"13","userId":27,"username":"y**ochoo"},{"coinCount":11804,"level":119,"rank":"14","userId":7891,"username":"h**zkp"},{"coinCount":11778,"level":118,"rank":"15","userId":14829,"username":"l**changwen"},{"coinCount":11766,"level":118,"rank":"16","userId":12351,"username":"w**igeny"},{"coinCount":11650,"level":117,"rank":"17","userId":26707,"username":"p**xc.com"},{"coinCount":11599,"level":116,"rank":"18","userId":833,"username":"w**lwaywang6"},{"coinCount":11547,"level":116,"rank":"19","userId":12331,"username":"R**kieJay"},{"coinCount":11475,"level":115,"rank":"20","userId":7809,"username":"1**23822235"},{"coinCount":11424,"level":115,"rank":"21","userId":7710,"username":"i**Cola7"},{"coinCount":11282,"level":113,"rank":"22","userId":7590,"username":"陈**啦啦啦"},{"coinCount":11272,"level":113,"rank":"23","userId":4886,"username":"z**iyun"},{"coinCount":11199,"level":112,"rank":"24","userId":29076,"username":"f**ham"},{"coinCount":11050,"level":111,"rank":"25","userId":2068,"username":"i**Cola"},{"coinCount":10800,"level":108,"rank":"26","userId":2160,"username":"R**iner"},{"coinCount":10735,"level":108,"rank":"27","userId":25419,"username":"蔡**打篮球"},{"coinCount":10653,"level":107,"rank":"28","userId":3825,"username":"请**娃哈哈"},{"coinCount":10653,"level":107,"rank":"29","userId":25128,"username":"f**wandroid"},{"coinCount":10266,"level":103,"rank":"30","userId":25793,"username":"F**_2014"}]
         * offset : 0
         * over : false
         * pageCount : 1718
         * size : 30
         * total : 51517
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;
        private List<DatasBean1> datasBean1s;
        private List<DatasBean2> datasBean2s;

        public List<DatasBean1> getDatasBean1s() {
            return datasBean1s;
        }

        public void setDatasBean1s(List<DatasBean1> datasBean1s) {
            this.datasBean1s = datasBean1s;
        }

        public List<DatasBean2> getDatasBean2s() {
            return datasBean2s;
        }

        public void setDatasBean2s(List<DatasBean2> datasBean2s) {
            this.datasBean2s = datasBean2s;
        }

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * coinCount : 23431
             * level : 235
             * rank : 1
             * userId : 20382
             * username : g**eii
             */

            private int coinCount;
            private int level;
            private String rank;
            private int userId;
            private String username;


            public int getCoinCount() {
                return coinCount;
            }

            public void setCoinCount(int coinCount) {
                this.coinCount = coinCount;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public String getRank() {
                return rank;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }

        public static class DatasBean1 {
            /**
             * coinCount : 20
             * date : 1601166928000
             * desc : 2020-09-27 08:35:28 签到 , 积分：11 + 9
             * id : 303478
             * reason : 签到
             * type : 1
             * userId : 49833
             * userName : 18296992423
             */

            private int coinCount;
            private long date;
            private String desc;
            private int id;
            private String reason;
            private int type;
            private int userId;
            private String userName;

            public int getCoinCount() {
                return coinCount;
            }

            public void setCoinCount(int coinCount) {
                this.coinCount = coinCount;
            }

            public long getDate() {
                return date;
            }

            public void setDate(long date) {
                this.date = date;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }
        }

        public static class DatasBean2 {
            /**
             * author : xiaoyang
             * chapterId : 440
             * chapterName : 官方
             * courseId : 13
             * desc : <p>最近实在是太忙了，抽空更新一问。</p>
             <p>想到一个非常有意思的问题：</p>
             <p>如果 app 启动了一个 Activity，那么在这个 Activity 展示的情况下，问题来了：</p>
             <p>1.上述场景背后至少有多少个线程？<br>2.每个线程具体的作用是什么？</p>
             * envelopePic :
             * id : 156122
             * link : https://www.wanandroid.com/wenda/show/15188
             * niceDate : 刚刚
             * origin :
             * originId : 15188
             * publishTime : 1601175018000
             * title : 每日一问 | 启动了Activity 的 app 至少有几个线程？
             * userId : 49833
             * visible : 0
             * zan : 0
             */

            private String author;
            private int chapterId;
            private String chapterName;
            private int courseId;
            private String desc;
            private String envelopePic;
            private int id;
            private String link;
            private String niceDate;
            private String origin;
            private int originId;
            private long publishTime;
            private String title;
            private int userId;
            private int visible;
            private int zan;

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public int getOriginId() {
                return originId;
            }

            public void setOriginId(int originId) {
                this.originId = originId;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }
        }
    }

}
