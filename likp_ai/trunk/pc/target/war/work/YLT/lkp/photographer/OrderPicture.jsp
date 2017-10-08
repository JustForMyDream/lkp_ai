<%--&lt;%&ndash;--%>
<%--Created by IntelliJ IDEA.--%>
<%--User: 王玉粮--%>
<%--Date: 2017/1/16--%>
<%--Time: 20:00--%>
<%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>上传图片</title>
    <script src="../js/jquery-3.1.1.min.js"></script>
    <%@include file="../share/jsAndCss.jspf" %>
    <style>
        html,
        body {
            background-color: #efeff4;
            font-family: Microsoft YaHei Light;
        }

        .mui-views,
        .mui-view,
        .mui-pages,
        .mui-page,
        .mui-page-content {
            position: absolute;
            left: 0;
            right: 0;
            top: 0;
            bottom: 0;
            width: 100%;
            height: 100%;
            background-color: #efeff4;
        }

        .mui-pages {
            top: 4px;
            height: auto;
        }

        .mui-scroll-wrapper,
        .mui-scroll {
            background-color: #efeff4;
        }


        .mui-navbar {
            position: fixed;
            right: 0;
            left: 0;
            bottom:0;
            z-index: 10;
            height: 44px;
            /*   background-color: #f7f7f8;*/
            background-color: rgba(0, 0, 0, 0);
        }

        .mui-navbar .mui-bar {
            position: absolute;
            background: transparent;
            text-align: center;
        }

        .mui-page {
            display: none;
        }

        .mui-pages .mui-page {
            display: block;
        }

        .mui-fullscreen {
            position: fixed;
            z-index: 20;
            background-color: #000;
        }

        .mui-bar .mui-btn-link {
            height: inherit;
            color: #000;
            font-family: Microsoft YaHei Light;
            font-size: 12px;
        }

        .mui-bar .mui-icon {
            color: #000;
        }

        .mui-loading {
            padding: 30px;
        }

        .rect > img {
            display: block;
        }

        .rect > img:after {
            position: absolute;
            width: 100%;
            height: 100%;
            display: block;
            background-color: rgba(0, 0, 0, 0.1);
        }

        .mui-slider .mui-slider-group .mui-slider-item img {
            width: auto;
            height: auto;
            max-width: 100%;
            max-height: 100%;
        }

        .mui-android-4-1 .mui-slider .mui-slider-group .mui-slider-item img {
            width: 100%;
        }

        .mui-android-4-1 .mui-slider.mui-preview-image .mui-zoom-scroller img {
            display: table-cell;
            vertical-align: middle;
        }


        .mui-control-content .mui-loading {
            margin-top: 50px;
        }
        .item-wrapper {
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            width: 100%;
            background-color: rgb(34, 35, 40);
        }
        .quarter {
            width: 33.3%;
            float: left;
            overflow: hidden;
            position: relative;
            border: 2px solid #ffffff;
        }

        .quarter img {
            -webkit-user-select: none;
            -webkit-touch-callout: none;
        }
        .add{
            width: 33.3%;
            float: left;
            overflow: hidden;
            position: relative;
            border: 2px solid #ffffff;
        }
        .add img {
            -webkit-user-select: none;
            -webkit-touch-callout: none;
        }
        .quarter.select:before {
            font-family: Muiicons;
            content: "\e460";
            position: absolute;
            vertical-align: middle;
            line-height: 17px;
            border-radius: 100%;
            right: 0px;
            background-color: rgba(84,83,81,0.8);
            color: white;
        }
        .item-wrapper {
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            width: 100%;
            background-color: rgb(34, 35, 40);
        }

        .item {
            text-align: center;
            top: 50%;
            margin-top: -52px;
            width: 100%;
            position: absolute;
            color: rgb(141, 139, 139);
        }

        .ball > div {
            width: 15px;
            height: 15px;
            border-radius: 15px;
            display: inline-block;
        }

        .ball > div:nth-child(1) {
            animation: movetoright 1s infinite;
            -webkit-animation: movetoright 1s infinite;
            background-color: rgb(235, 185, 125);
        }

        .ball > div:nth-child(2) {
            animation: movetoleft 1s infinite;
            -webkit-animation: movetoleft 1s infinite;
            background-color: rgb(255, 255, 255);
        }

        @-webkit-keyframes movetoleft {
            0% {

            }
            50% {
                -webkit-transform: translate(-100%, 0%);
            }
            100% {
                -webkit-transform: translate(0%, 0%);
            }
        }

        @keyframes movetoleft {
            0% {

            }
            50% {
                transform: translate(-100%, 0%);
            }
            100% {
                transform: translate(0%, 0%);
            }
        }

        @-webkit-keyframes movetoright {
            0% {

            }
            50% {
                -webkit-transform: translate(100%, 0%);
            }
            100% {
                -webkit-transform: translate(0%, 0%);
            }
        }

        @keyframes movetoright {
            0% {

            }
            50% {
                transform: translate(100%, 0%);
            }
            100% {
                transform: translate(0%, 0%);
            }
        }

        .coverImg img {
            width: 100%;
            height: auto;
        }

        input {
            padding: 6px 11px;
            font-family: inherit;
        }

        header {
            position: relative;
        }

        header .title input {
            background-color: rgba(0, 0, 0, 0);
            border: 2px dashed #FFF;
            width: 100%;
            font-size: 18px;
            color: white;
            margin-bottom: 0;
        }

        header .info .time {
            padding: 0 15px;
            color: #FFF;
        }

        .mui-content .describe input {
            color: #9F9D9E;
            border: 0;
        }

        #imgContent img {
            width: 100%;
        }

        .bottom-btn > button {
            display: inline-block;
            border: 0;
            border-radius: 0;
            background-color: inherit;
            padding: 0px;
            width: 49.999999%;
            margin-right: -3px;
            border-right: 1px;
            border-style: solid;
            border-color: #FFF;
            font-size: 12px;
            line-height: 25px;
            color: #FFF;
            height: 25px;
            vertical-align: middle;
        }

        .bottom-btn > button > span {
            height: 14px;
            line-height: 14px;
            border: 0;
            padding: 0;
            display: inline-block;
            vertical-align: middle;
            clear: both;
        }

        .mui-navbar-inner.mui-bar.mui-bar-nav {
            background-color: #FFF;
        }

        .bottom-btn > button > img {
            height: auto;
            width: 14px;
            vertical-align: middle;
            margin-right: 7.5px;

        }

        .bottom-btn > button:nth-last-child(1) {
            border: 0;
        }

        #musicList > li.mui-table-view-cell > a.selected:after {
            font-family: Muiicons;
            font-size: 30px;
            line-height: 1;
            position: absolute;
            top: 50%;
            display: inline-block;
            -webkit-transform: translateY(-50%);
            transform: translateY(-50%);
            text-decoration: none;
            color: #bbb;
            -webkit-font-smoothing: antialiased;
            right: 15px;
            content: '\e472';
            color: #EC4450;
        }

        .mui-scroll, .mui-page-content, .mui-page {
            min-height: 100%;
        }

        .mui-action-back.mui-icon.mui-icon-left-nav.mui-pull-left > span {
            width: 0;
        }

        .ball > div {
            width: 15px;
            height: 15px;
            border-radius: 15px;
            display: inline-block;
        }

        .ball > div:nth-child(1) {
            animation: movetoright 1s infinite;
            -webkit-animation: movetoright 1s infinite;
            background-color: rgb(235, 185, 125);
        }

        .ball > div:nth-child(2) {
            animation: movetoleft 1s infinite;
            -webkit-animation: movetoleft 1s infinite;
            background-color: rgb(255, 255, 255);
        }

        /*****预览页面******/
        #perviewPage img {
            width: 100%;
            height: auto;
        }

        #perviewPage #userinfo > img, #userinfo > div {
            display: block;
            height: auto;
            float: left;
        }

        #perviewPage #userinfo > div > span {
            display: block;
            height: 20px;
            line-height: 20px;
        }


        #perviewPage .user-des > span:first-child {
            font-size: 14px;
        }

        #perviewPage_active .imgwraper img {
            width: auto;
            height: auto;
            max-width: 100%;
            max-height: 100%;
            transform-style: preserve-3d;
        }

    </style>
</head>
<body class="mui-fullscreen">
<!--页面主结构开始-->
<div id="app" class="mui-views">
    <div class="mui-view">
        <div class="mui-navbar">
        </div>
        <div class="mui-pages">
        </div>
    </div>
</div>
<!--图片编辑页面-->
<div id="coverChoose" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav" style="background-color: #303030;">
        <a id="next" class="mui-btn mui-btn-link mui-pull-right" href="#setting" style="font-size: 17px;color: #FDE23D;font-family: 微软雅黑;">完成</a>

        <h1 id="number" class="mui-center mui-title" style="right: 220px;left: -47px;"><p style='color: white;'>已选<span style='color:#FDE23D;font-size: 20px '>0</span>张原片</p></h1>
    </div>
    <div class="mui-page-content" style="background-color: #ECECEC">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll">
                <div id="coverFncbtn" class="add" ><img style="width: 100%;"  src="../image/+.png" /></div>
                <div id="allChoosedImg" class="">
                    <div id="clear" style="clear: both;"></div>
                    <%--<div class="quarter" style="height: 115.875px;">--%>
                    <%--<img id="coverFncbtn" style="height:115.875px; " src="../image/rderpicture.png"/>--%>
                    <%--</div>--%>
                </div>
                <%--<div style="bottom:30px;width:33.3%;z-index:20">--%>
                <%--<button id="coverFncbtn" style=" display: block; margin: 0 auto;padding: 0px;"><img style="width: 100%;"  src="../image/+.png" /></button>--%>
                <%--</div>--%>
            </div>
        </div>
    </div>
</div>
<div class="mui-backdrop" style="display: none;">
    <div class="item-wrapper">
        <div class="item" id="load">
            <div class="ball">
                <div></div>
                <div></div>
            </div>
            <div id="txt" style="margin-top: 10px;">loading...</div>
        </div>
    </div>
</div>
</body>
<script src="<%=basePath%>js/mui.zoom.js"></script>
<script src="<%=basePath%>js/mui.previewimage1.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script>
    var orderId = "${id}";
 //   var orderId = "${orderid}";
   // var orderId = '297e9e7958fbf8fc0158fc479868000b';
    var loadedImgnum = 0;

    var windowWidth =  $(window).width();
//      (windowWidth);
//    $(".quarter").css("height",0.33*windowWidth);
     $(".add").css("height",0.33*windowWidth-3);

    mui.init({
        gestureConfig: {
            swipeBack: false,
            tap: true, //默认为true
            doubletap: true, //默认为false
            longtap: true, //默认为false
            swipe: false, //默认为true
            drag: true, //默认为true
            hold: false,//默认为false，不监听
            release: false//默认为false，不监听
        }
    });
    mui(".mui-scroll-wrapper").scroll();
    var viewApi = mui('#app').view({
        defaultPage: '#coverChoose',
        swipeBackPageActiveArea: 60
    });
    wx.config({
        debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
        appId: '${appId}', // 必填，公众号的唯一标识
        timestamp: ${timestamp}, // 必填，生成签名的时间戳
        nonceStr: '${nonceStr}', // 必填，生成签名的随机串
        signature: '${signature}',// 必填，签名，见附录1
        jsApiList: ['getLocation', 'downloadImage', 'onMenuShareTimeline', 'onMenuShareAppMessage', 'hideMenuItems', 'chooseImage', 'uploadImage'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });
    function ImgObj(id, type, src, targetId) {
          ("imgobj");
        this.id = id;
        //type(user:用户手机选择 ,order:订单图片,Service:已上传至服务器)
        this.type = type;
        this.src = src;
        /*当type等于user时,targetid为上传至微信服务器的serviceid
         * 当type等于order是,targetid为订单图片的编号
         * 当type等于Service时,targetid为影集图片的编号
         * */
        this.targetId = targetId;
        this.uploadState = false;
        this.uploadImg = function () {
            var that = this;
            if (this.type == "user" && targetId == null) {
                wx.uploadImage({
                    localId: that.src, // 需要上传的图片的本地ID，由chooseImage接口获得
                    isShowProgressTips: 0, // 默认为1，显示进度提示
                    success: function (res) {
                        var serverId = res.serverId; // 返回图片的服务器端ID
                        that.targetId = serverId;
                          (that.src);
                        that.uploadState = true;
                        $("#" + that.id).attr("data-target", that.toString());
                        uploadimg_I++;
                        uploadImg(uploadimg_I)
                    }
                });
            } else if (this.type == "user" && targetId != null) {
                this.uploadState = true;
                $("#" + this.id).attr("data-target", that.toString());
                uploadimg_I++;
                uploadImg(uploadimg_I)
            } else{
                uploadimg_I++;
                uploadImg(uploadimg_I)
            }
            $(".mui-backdrop").show();
            $(".mui-backdrop").find("#txt").text("上传图片中..");
        };
        this.toString = function () {
            return JSON.stringify(this);
        };
        this.toHTML = function () {
            return "<img id=\"" + this.id + "\" src=\"" + this.src + "\" data-target=" + this.toString() + " />";
        }
    }
    //影集数据操作
    (function ($, window) {
        var yingji = function (options) {
            this.options = $.extend(true, {
                imglist: []
            }, options || {});
        };
        var prop = yingji.prototype;
        var container = $("#allChoosedImg");
        prop._init = function () {
            container.empty(".quater");
            for (var i = 0; i < prop.imglist.length; i++) {
                var imgitem = $("<div class=\"quarter select\">" + imglist[i].toHTML() + "</div>");
                $("#clear").before(imgitem);
                var imgheight = imgitem.width()+3;
                imgitem.css("height", imgheight + "px");
                imgitem.children("img").on("load", function (e) {
                    var $this = $(e.target);
                    if ($this.width() < $this.height()) {
                        $this.css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
                    } else {
                        $this.css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
                    }
                });
            }
        };
        /**
         * 添加一张图片
         * @param type 图片类型 user（用户手机选择） order(订单图片)
         * @param src 图片url路径
         * @param targetId type为user时为上传至微信的图片servid ,type为order时为图片id
         * */
        prop.addImg = function (type, src, targetId) {
              ("addImg");
            var obj = new ImgObj(this.uuid(), type, src, targetId);
            var imgitem = $("<div class=\"quarter select up\">" + obj.toHTML() + "</div>");
            $("#clear").before(imgitem);
            var imgheight = imgitem.width()+3;
            imgitem.css("height", imgheight + "px");
            imgitem.children("img").on("load", function (e) {
                var $this = $(e.target);
                if ($this.width() < $this.height()) {
                    $this.css({"width": "100%","height": "auto", "max_height": "auto", "max_width": "auto"});
                } else {
                    $this.css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
                }
            });
        };
        /**
         * 类型判断 是否为定义的imgobject
         * */
        /**
         * 通过id移除img
         * */
        prop.removeImgObj = function (id) {
              (id);
            var arry = [];
            if($(".quarter").hasClass("uploaded")){
            $("#" + id).parents(".quarter").remove();
              ($("#" + id));
                  ("delete");
            $.ajax({
                    url: "deletePictures",
                    data: {pictureId: id},
                    type: "post",
                    dataType: "json",
                    success:function (data) {
                    },
                    error:function () {

                    }
                });
            }
        }
        /**
         * 在最前面添加img
         * */
//        prop.unshift = function (obj) {
//            var imgitem = $("<div class=\"quarter\">" + obj.toHTML() + "</div>");
//            container.prepend(imgitem);
//            imgitem.css("height", imgitem.width() + "px");
//            imgitem.children("img").on("load", function (e) {
//                var $this = $(e.target);
//                if ($this.width() < $this.height()) {
//                    $this.css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
//                } else {
//                    $this.css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
//                }
//            });
//        };
        /**
         * 通过id删除img
         * */
        prop.deleteImg = function (id) {
            $("#" + id).parent().remove();
        };
        /**
         * 将指定id的img移到第一位
         * */
//        prop.moveToFirst = function (id) {
//            var data = JSON.parse($("#" + id).attr("data-target"));
//            var imgObj;
//            if (data.targetId) {
//                imgObj = new ImgObj(data.id, data.type, data.src, data.targetId);
//            } else {
//                imgObj = new ImgObj(data.id, data.type, data.src, null);
//            }
//
//            //   (imgObj);
//            this.deleteImg(id);
////            this.unshift(imgObj)
//        };
        /**
         * 生成随机id
         * */
        prop.uuid = function () {
            var s = [];
            var hexDigits = "0123456789abcdef";
            for (var i = 0; i < 36; i++) {
                s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
            }
            s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
            s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
            s[8] = s[13] = s[18] = s[23] = "-";
            var uuid = s.join("");
            return uuid;
        };
        prop.getImgList = function () {
            var arry = [];
            var imgs = container.find("img");
            for (var i = 0; i < imgs.length; i++) {
                  ($($(imgs.get(i))[0]).hasClass("already"));
                if($($(imgs.get(i))[0]).hasClass("already") == false){
                    arry.push(JSON.parse($(imgs.get(i)).attr("data-target")));
                }
            }
            return arry;
        };
        prop.setTargetId = function (id, targetId) {
            for (var i = 0; i < this.options.imglist.length; i++) {
                if (this.options.imglist[i].id == id) {
                    this.options.imglist[i].targetId = targetId;
                }
            }
        };
        var yingjiApi = null;
        $.yingji = function (options) {
            if (!yingjiApi) {
                yingjiApi = new yingji(options);
            }
            return yingjiApi;
        };
        $.getYingji = function () {
            return yingjiApi;
        }
    })($, window);
    var yingji = $.yingji();
    wx.ready(function () {
        $("#coverFncbtn").on("tap", function () {
              ("11111111111111");
            choosePhonePic(initChooseCover);
            var d = new Date();
        });

        $("#allChoosedImg").on("tap", ".quarter:not(.select) img", function (e) {
            var targetId = $(this).attr("id");
//            yingji.moveToFirst(targetId);
            e.stopPropagation();
            e.preventDefault();
        }).on("tap", ".quarter.select,.quarter.select img", function (e) {
            e.stopPropagation();
            e.preventDefault();
//            if ($(".quarter.select").length <= 1) {
//                mui.toast("已经最后一张了，不能再删了");
//                return false;
//            }
            var targetid = $(this).children("img").attr("id");
            yingji.removeImgObj(targetid);
            // $("#" + targetid).parent().removeClass("selected");
            getCurrentPictureNumbers();
            initChooseCover();
            $(".quarter").addClass("select");
        }).on("load", ".quarter img", function (e) {
            var $this = $(e.target);
            if ($this.width() < $this.height()) {
                $this.css({"width": "100%","height": "auto","max_height": "auto", "max_width": "auto"});
            } else {
                $this.css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
            }
        });
        $("#next").on("tap",function () {
            uploadimg_I=0;
            uploadImg(uploadimg_I);
        });
    });

    //初始化编辑页面
    function initChooseCover() {
        if (yingji.getImgList().length > 0) {
            $(".bottom-btn").css("bottom", "0");
        }
    }

    function initImgViewer(index) {
        var $that = $($(".rect").get(index));
        if ($that.hasClass("selected")) {
            $("#mHeader").addClass("selected");
        } else {
            $("#mHeader").removeClass("selected");
        }
    }
    var uploadimg_I=0;
    var isuploaded = true;

    function uploadImg(i) {
        if (i < yingji.getImgList().length) {
            new ImgObj(yingji.getImgList()[i].id, yingji.getImgList()[i].type, yingji.getImgList()[i].src, yingji.getImgList()[i].targetId).uploadImg();
        }
        else{
            sendData();
        }
    }

    var imgpre="http://www.91lkp.com:8080/Z22629";
    function sendData() {
        isuploaded = true;
        for (var i = 0; i < yingji.getImgList().length; i++) {
            if (!yingji.getImgList()[i].uploadState) {
                isuploaded = false;
            } else {
                  (yingji.getImgList()[i].targetId);
            }
        }
        if (isuploaded) {
            var upLoadPictures = [];
            for(var i = 0;i < yingji.getImgList().length;i++){
                  (yingji.getImgList()[i].type);
//                if(yingji.getImgList()[i].type == "user"){
//                      ("user");
//                }
                upLoadPictures.push(yingji.getImgList()[i]);
            }
            var data = {
                orderId:orderId
            };
            data["upLoadPictures"] = JSON.stringify(upLoadPictures);
            $(".mui-backdrop").hide();
            mui.toast("原片上传成功");
            $.ajax({
                url:"../PICTUREPAY/savePicture",
                type:"get",
                data:data,
                dataType:"json",
                success:function (data) {
                    var btnArray = ['确定','取消'];
                    mui.confirm("是否跳转到上传精修页面",'保存成功',btnArray,function (e) {
                        if(e.index == 0){
                            window.location.href="../PICTUREPAY/OrderTrimPicture?id="+orderId;
                        }
                        else {
                            loaddata();
                        }
                    })
                },
                error:function () {

                }
            });
        }
    }

//  function reload() {
//      window.location.reload(function(){
//          loaddata();
//      });
//  }
    window.onload = loaddata;
    function loaddata() {
        $.ajax({
            url: "../PICTUREPAY/getPictures",
            data: {orderId: orderId},
            type: "post",
            dataType: "json",
            success: function (data) {
                $("#allChoosedImg").children(".quarter").remove();
                getCurrentPictureNumbers();
                for (var i in data) {
                    var image = new Image();
                    var id = data[i].id
                    var img = JSON.parse(data[i].itemImgurl);
                    var imgUrl = imgpre + img[0].path;
                    var itemTplx = data[i].itemTplx;
                    image.src = imgUrl;
                      (image.width);
                    var containers = $("#allChoosedImg");
                    if(itemTplx == "原片"){
                        var html = $("<div class='quarter select uploaded'><img  class='already' id='"+id+"' src='" + imgUrl + "'  ></div>");
                          (0.33*$(window).width());
                        html.css("height", 0.33*$(window).width() + "px");
                        containers.prepend(html);
                        if(image.width>image.height){
                            $(".already").css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
                        }else {
                            $(".already").css({"width": "100%", "height":"auto","max_height": "auto", "max_width": "auto"});
                        }
                        $("#clear").before(html);
                        getCurrentPictureNumbers();
                    }
                }
            },
            error: function () {
                  ("错误");
            }
        });
    }
    function getCurrentPictureNumbers() {
        var numbers = $("#allChoosedImg").children().length - 1;
        $("#number p").remove();
        $("#number").append("<p style='color: white;'>已选<span style='color:#FDE23D;font-size: 20px '>" + numbers + "</span>张原片</p>");
    }

    function choosePhonePic(callback) {
        wx.chooseImage({
            count: 9, // 默认9
            sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function (res) {
                // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
                for (var i = 0; i < res.localIds.length; i++) {
                    yingji.addImg("user", res.localIds[i], null);
                }
                getCurrentPictureNumbers();
                if (callback) {
                    callback();
                }
            },
            cancel: function () {
                mui.toast("还未选择任何图片！");
            }
        });
    }
</script>
</html>

