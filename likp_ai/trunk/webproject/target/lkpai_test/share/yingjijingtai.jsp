<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/1/2
  Time: 05:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>${title}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <!--标准mui.css-->
    <%@include file="jsAndCss.jspf" %>
    <script src="../js/jquery-3.1.1.min.js"></script>
    <link href="../css/base.css" rel="stylesheet" />
    <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <style>
        body {
            font-family: "Microsoft YaHei";
            font-size: 16px;
            background-color: #EEEEEE;
        }

        img {
            width: 100%;
            height: auto;
        }

        .yjs_top {
            height: auto;
            width: 100%;
            overflow: hidden;
        }

        .yjs_cen {
            height: auto;
            /*text-align: center;*/
            padding: 5px 15px 10px 15px;
        }

        .bottom_img {
            padding: 2px 8px;
        }

        #time {
            font-size: 12px;
            color: #3A3939;
        }

        .miaoshu {
            text-align: left;
            color: #3A3939;
            font-size: 14px;
            padding: 4px 8px;
        }

        .bottom-btn {
            position: fixed;
            bottom: 0;
            color: #000;
            width: 100%;
            display: block;
            border: 0;
            border-radius: 0;
            background-color: #FFF;
            height: 44px;
            font-size: 16px;
            padding: 0;
            border-top: 1px;
            border-top-color: #B2b2b2;
            border-top-style: solid;
        }

        #headimg {
            width: 40px;
            height: 40px;
            border-radius: 20px;
        }

        #userinfo {
            text-align: left;
            padding: 2px;
        }

        #userinfo > img, #userinfo > div {
            display: block;
            height: auto;
            float: left;
        }

        #userinfo > div > span {
            display: block;
            height: 20px;
            line-height: 20px;
        }

        #other {
            font-size: 12px;
            color: #B2B2B2;
        }

        .user-des {
            margin-right: 10px;
        }

        .user-des > span:first-child {
            font-size: 14px;
        }

        #musicControl.playing {
            -webkit-animation: cricle 10s linear infinite;
            animation: cricle 10s linear infinite;
        }

        @-webkit-keyframes cricle {
            0% {
            }
            50% {
                -webkit-transform: rotate(180deg);
            }
            100% {
                -webkit-transform: rotate(360deg);
            }
        }

        @keyframes cricle {
            0% {
            }
            50% {
                transform: rotate(180deg);
            }
            100% {
                transform: rotate(360deg);
            }
        }

        .systx {
            width: 100%;
            height: 100px;
            text-align: center;
            background-color: white;
            padding: 22px;
        }

        .systx > img {
            width: 57px;
            height: 57px;
            border-radius: 28.5px;
        }

        .sysnc {
            background-color: white;
            width: 100%;
            height: 22px;
            text-align: center;
            font-size: 12px;
        }

        .sysnc > span {
            color: #ff2c2c;
        }

        .mui-bar-nav {
            -webkit-box-shadow: none;
            box-shadow: none;
        }
        #title{
            padding: 5px 0px;
        }
        .yjms{
            padding: 5px 0px;
            font-size: 14px;
        }
        .sysnc,.systx{
            display: none;
        }
        .title_change{
            width: 50%!important;
            left: 110px !important;
        }
    </style>
</head>
<body>
<div id="musicControl" style="position: fixed;
    top: 20px;
    right: 20px;
    border-radius: 20px;">
    <img src="../image/music_white.png" style="width: 20px;
    height: 20px;">
</div>
<audio id="audio" style="opacity:0" loop hidden="hidden"></audio>
<div class="mui-navbar-inner mui-bar mui-bar-nav" style="background-color: black">
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left" style="color: white"><span style="color: white;font-size: 16px;font-family: 'Microsoft YaHei';line-height: 16px;padding: 4px 0;
    vertical-align: bottom;display: inline-block">播放模式</span></a>
    <%--<a id="rightbt" class="mui-btn mui-btn-link mui-pull-right" href="newSet?id=${id}" style="color: white">编辑</a>--%>
    <h1 class="mui-title title_change" style="color: white;"></h1>
</div>
<div class="mui-content">
    <div class="yjs_top">
        <img id="top_img"/>
    </div>
    <div class="yjs_cen">
        <h3 id="title" style="
    font-size: 18px;
    font-weight: 500;
    color: #000;"></h3>
        <div class="yjms"></div>
        <div id="time"></div>
    </div>
    <div class="bottom" id="ibottom">

    </div>
    <%--摄影师头像--%>
    <div class="systx">

    </div>
    <%--摄影师昵称--%>
    <div class="sysnc">

    </div>
    <img src="../image/support_2.jpg"/>
</div>
<%--<button id="play" class="bottom-btn">
    <div id="userinfo">
        <img id="headimg" src="http://wx.qlogo.cn/mmopen/kMaz9nc8bgIb2VVd2gfWzGI3XT5cPyia6bOKfZ8CtP9ZFkfWD6ibYCAR1NbgJtTxtgHZOEOHMfZJ79V7JOePs6LCiaRuqssL3ia7/0">
        <div class="user-des">
            <span id="nickname">用户名</span>
            <span id="other" style="font-size: 10px">爱，要立可拍</span>
        </div>
    </div>
    <img id="" style=" width: 24px; height: 24px; position: absolute; top: 10px; right: 10px;" src="../image/play_yellow.png"/>
</button>--%>
<div class="mui-backdrop">
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
<script>
    var media = document.getElementById("audio");
    var preImg = "http://121.40.255.15:8080/Z22629";
    var imgurl = ${imgurl};
    var des = "${des}";
    if (!des) {
        des = "珍藏生活中的感动"
    }
    var title = "${title}";
    var id = "${id}";
    //var id = "297e9e795900d9190159249abbb202b3";
    wx.config({
        debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
        appId: '${appId}', // 必填，公众号的唯一标识
        timestamp: ${timestamp}, // 必填，生成签名的时间戳
        nonceStr: '${nonceStr}', // 必填，生成签名的随机串
        signature: '${signature}',// 必填，签名，见附录1
        jsApiList: ['getLocation', 'downloadImage', 'onMenuShareTimeline', 'onMenuShareAppMessage', 'hideMenuItems'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });

    wx.ready(function () {
        wx.hideMenuItems({
            menuList: ['menuItem:share:qq', 'menuItem:share:weiboApp', 'menuItem:share:facebook', 'menuItem:share:QZone']
        });
        wx.onMenuShareTimeline({
            title: title, // 分享标题
            link: '<%=basePath%>YINGJI/newYingji?id=' + id, // 分享链接
            imgUrl: preImg + imgurl[0].path, // 分享图标
            success: function (res) {
                // alert(JSON.stringify(res));
                // 用户确认分享后执行的回调函数
            },
            fail: function (res) {
                  (res);
            },
            cancel: function () {
                // 用户取消分享后执行的回调函数
            }
        });
        wx.onMenuShareAppMessage({
            title: title, // 分享标题
            desc: des, // 分享描述
            link: '<%=basePath%>YINGJI/newYingji?id=' + id, // 分享链接
            imgUrl: preImg + imgurl[0].path, // 分享图标
            type: 'link', // 分享类型,music、video或link，不填默认为link
            success: function (res) {

                // 用户确认分享后执行的回调函数
            },
            fail: function (res) {
                  (res);
            },
            cancel: function () {
                // 用户取消分享后执行的回调函数
            }
        });
    });
    function getRequestPara(queryString) {
        var query = [];
        var paramString = queryString.split("&");
        for (var s in paramString) {
            var key = paramString[s].split("=")[0];
            var value = paramString[s].split("=")[1];
            query[key] = value;
        }
        return query;
    }
    var query = getRequestPara(window.location.search.substring(1));
    /*    $(function () {
     loadImg();
     $("#play").on("tap",function(){
     window.location.href="yingjishow?id="+id;
     });
     $("#musicControl").on("tap",function (){
     if(media.error){
     var errorCode = media.error.code;
     switch (errorCode){
     case (1):{
     mui.toast("音乐播放被终止");
     break;
     }
     case 2:{
     mui.toast("网络错误，音乐无法加载");
     break;
     }
     case 3:{
     mui.toast("解码错误，音乐无法播放");
     break;
     }
     case 4:{
     mui.toast("音乐不存在或音乐格式无效");
     break;
     }
     }
     }else if(media.paused){
     media.play();
     }else{
     media.pause();
     }
     });
     media.addEventListener("pause",function(){
     $("#musicControl").removeClass("playing");
     });
     media.addEventListener("play",function(){
     $("#musicControl").addClass("playing");
     });
     });*/
    loadImg();
    function loadImg() {
        var domain = "http://121.40.255.15:8080";
        var project = "/Z22629";
        var imgpre = domain + project;

        $.ajax({
            url: "<%=basePath%>userPort/yingji/detail",
            data: {id: id},
            type: "GET",
            dataType: "json",
            success: function (data) {
                $(".mui-backdrop").hide()
                $("#audio").attr("src", data.yingji.itemMusic);
                media.play();
                //加载封面
                var path = JSON.parse(data.yingji.itemCover);
                $("#top_img").attr("src", imgpre + path[0].path);

                //标题
                $("#title").text(data.yingji.itemTitle);
                $(".mui-title").text(data.yingji.itemTitle)
                document.title = data.yingji.itemTitle;
                if(data.yingji.itemDes){
                    $(".yjms").append(data.yingji.itemDes)
                }
                //时间
                var time = new Date(data.yingji.created).format("yyyy-MM-dd");
                $("#time").html("<span>by " + data.user.nickname + "</span><br/>" + time);
                $("#nickname").text(data.user.nickname);
                $("#headimg").attr("src", data.user.headimgurl)
                //加载图片和描述
                var yjgl_detail = data.yingji.tlkYingjipicEntities;
                for (var i in yjgl_detail) {
                    var imsrc = imgpre + JSON.parse(yjgl_detail[i].itemImgurl)[0].path;
                    if (yjgl_detail[i].itemDescription != null && yjgl_detail[i].itemDescription != undefined && yjgl_detail[i].itemDescription != '') {
                        yjgl_detail[i].itemDescription=yjgl_detail[i].itemDescription.replace(/\r?\n/g,"<br/>").replace(/\s/g,"&nbsp;");
                        $("#ibottom").append('<div class="miaoshu">' + yjgl_detail[i].itemDescription + '</div>');
                    } else {
                        $("#ibottom").append('<div class="miaoshu"></div>');
                    }
                    $("#ibottom").append('<div class="bottom_img"><img src="' + imsrc + '"/></div>');
                }
                //摄影师头像和昵称
                if(data.sys){
                    $(".sysnc,.systx").show();
                    var sys = data.sys;
                    var sysimg = imgpre + JSON.parse(sys.itemHeadimg)[0].path;
                    var sysnc = sys.itemNc;
                    $(".systx").append('<img src="' + sysimg + '"/>');
                    $(".sysnc").append('摄影师:<span>' + sysnc + '</span>');
                }

                //跳转事件
                $("#rightbt").on('tap', function () {
                    /*暂为空*/
                });

            }
        })
        ;
    }
</script>
</body>
</html>
