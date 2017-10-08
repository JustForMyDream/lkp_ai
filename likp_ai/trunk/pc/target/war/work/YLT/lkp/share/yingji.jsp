<%--
  Created by IntelliJ IDEA.
  User: cccxt
  Date: 2016/8/22
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
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
    <title>${title}</title>
    <script src="../js/jquery-3.1.1.min.js"></script>
    <%@include file="jsAndCss.jspf" %>
    <link rel="stylesheet" href="<%=basePath%>css/magic.min.css">
    <style>
        .H5-container {
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            background-color: #000;
            overflow: hidden;
        }

        .full-container {
            font-size: 14px;
            position: absolute;
            width: 100%;
            height: 100%;
            vertical-align: top;
            display: none;
        }

        .full-container.active {
            display: inline-block;
        }

        .imgwraper {
            position: absolute;
            display: -webkit-box;
            display: -webkit-flex;
            display: flex;
            -webkit-box-align: center;
            -webkit-align-items: center;
            align-items: center;
            -webkit-box-pack: center;
            -webkit-justify-content: center;
            justify-content: center;
            left: 0;
            right: 0;
            bottom: 0;
            top: 0;
            width: 100%;
            height: 100%;
            margin: 0;
            -webkit-backface-visibility: hidden;
            background-color: rgb(19, 19, 19);
        }

        .imgwraper img {
            width: auto;
            height: auto;
            max-width: 100%;
            max-height: 100%;
            transform-style: preserve-3d;
        }

        .section {
            font-size: 0;
            -webkit-transition: all 0s linear;
            transition: all 0s linear;
            white-space: nowrap;
        }

        .magictime {
            -webkit-animation-duration: 6s;
            -moz-animation-duration: 6s;
            -o-animation-duration: 6s;
            animation-duration: 6s;
        }

        .action {
            -webkit-animation-name: action;
            animation-name: action;
        }

        @-webkit-keyframes action {
            0% {
                opacity: 0;
                -webkit-transform-origin: 100% 50%;
                -webkit-transform: scale(.2) translate(200%, 0%);
            }
            20% {
                opacity: 1;
                -webkit-transform-origin: 100% 50%;
                -webkit-transform: scale(1) translate(0%, 0%);
            }
            80% {
                opacity: 1;
                -webkit-transform-origin: 0% 50%;
                -webkit-transform: scale(1) translate(0%, 0%);
            }
            100% {
                opacity: 0;
                -webkit-transform-origin: 0% 50%;
                -webkit-transform: scale(.2) translate(-200%, 0%);
            }

        }

        @keyframes action {
            0% {
                opacity: 0;
                transform-origin: 100% 50%;
                transform: scale(.2) translate(200%, 0%);
            }
            20% {
                opacity: 1;
                transform-origin: 100% 50%;
                transform: scale(1) translate(0%, 0%);
            }
            80% {
                opacity: 1;
                transform-origin: 0% 50%;
                transform: scale(1) translate(0%, 0%);
            }
            100% {
                opacity: 0;
                transform-origin: 0% 50%;
                transform: scale(.2) translate(-200%, 0%);
            }
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

        @-webkit-keyframes movetoleft {
            0% {

            }
            50% {
                -webkit-transform: translate(-200%, 0%);
            }
            100% {
                -webkit-transform: translate(0%, 0%);
            }
        }

        @keyframes movetoleft {
            0% {

            }
            50% {
                transform: translate(-200%, 0%);
            }
            100% {
                transform: translate(0%, 0%);
            }
        }

        @-webkit-keyframes movetoright {
            0% {

            }
            50% {
                -webkit-transform: translate(200%, 0%);
            }
            100% {
                -webkit-transform: translate(0%, 0%);
            }
        }

        @keyframes movetoright {
            0% {

            }
            50% {
                transform: translate(200%, 0%);
            }
            100% {
                transform: translate(0%, 0%);
            }
        }

        /*        .magictime.magic {
                    -webkit-animation-duration: 10s;
                    -moz-animation-duration: 10s;
                    -o-animation-duration: 10s;
                    animation-duration: 10s;
                }*/
        .mui-backdrop {
            display: none;
            background-color: rgba(0, 0, 0, 0.8);
        }

        .mui-backdrop > div {
            display: none;
            width: 100%;
            height: 100%;
        }

        .mui-backdrop > div#pause {
            position: absolute;
            top: 50%;
            left: 50%;
            width: inherit;
            height: inherit;
            margin-top: -118px;
            margin-left: -98px;
        }

        #sharepic p {
            color: #FFF;
        }

        header, footer {
            position: fixed;
            width: 100%;
            height: 40px;
            z-index: 20;
            background-color: rgba(0, 0, 0, 0.3);
        }

        header {
            top: 0;
            padding: 10px 15px;
        }

        header > div {
            display: block;
        }

        header > div:nth-child(1) {
            float: left;
        }

        header > div:nth-child(2) {
            float: right;
        }

        footer {
            height: 44px;
            bottom: 0;
        }

        #userinfo1 {
            text-align: left;
            padding: 2px;
        }

        #userinfo1 > img, #userinfo1 > div {
            display: block;
            height: auto;
            float: left;
        }

        #userinfo1 > div > span {
            display: block;
            height: 20px;
            line-height: 20px;
            padding-left: 45px;
        }

        #headimg {
            width: 40px;
            height: 40px;
            border-radius: 20px;
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
            background-color: rgb(255, 227, 62);
        }

        .ball > div:nth-child(2) {
            animation: movetoleft 1s infinite;
            -webkit-animation: movetoleft 1s infinite;
            background-color: rgb(255, 255, 255);
        }

        body {
            color: white;
        }
    </style>
</head>
<body>
<header style="">
    <div id="pageshow"><span class="mui-icon mui-icon-arrowleft" style="font-size: 21px"></span>图文模式</div>
    <div id="fenxiang1">分享</div>
</header>
<footer onclick="pauseOrplay()">
    <div id="userinfo1">
        <img id="headimg" class="headimg"
             src="http://wx.qlogo.cn/mmopen/kMaz9nc8bgIb2VVd2gfWzGI3XT5cPyia6bOKfZ8CtP9ZFkfWD6ibYCAR1NbgJtTxtgHZOEOHMfZJ79V7JOePs6LCiaRuqssL3ia7/0">
        <div class="user-des">
            <span id="nickname" class="nickname">用户名</span>
            <span id="other" style="font-size: 10px;">爱，要立可拍</span>
        </div>
    </div>
    <img id="controll" style=" width: 24px; height: 24px; position: absolute; top: 10px; right: 10px;"
         src="../image/play_yellow.png"/>
</footer>
<div id="musicControl" style="position: fixed;
    top: 49px;
    right: 20px;
    border-radius: 20px;    z-index: 20;">
    <img src="../image/music_white.png" style="width: 20px;
    height: 20px;">
</div>
<audio id="audio" style="opacity:0" loop hidden="hidden" src="../bgm/summer.mp3"></audio>
<div class="H5-container">
    <div class="section">
        <%-- <div class="full-container" style="background-color: #FFFFFF">
             <div style="font-size: 14px;font-family: inherit;margin: 50px 0 20px;text-align: center;">
             </div>
             <div id="userinfo" style="text-align: center;">
                 <div>
                     <img id="userimg" style="width: 80px;  border-radius: 80px;"/>
                 </div>
                 <div id="title"></div>
                 <div id="des"></div>
             </div>
             <div style="text-align: center;max-height: 200px;overflow: hidden;">
                 <img id="cover" src="<%=basePath%>images/dashang.jpg" style="    width: 100%;">
             </div>
             <div style="text-align: center;margin-top: 30px;">
                 <button id="fenxaing" style="padding: 6px 30px;background-color: #FFE43F;">分享</button>
                 <button id="bofang" style="padding: 6px 30px;background-color: #FFE43F;" onclick="play()">播放</button>
             </div>
         </div>--%>
    </div>
</div>
<div class="mui-backdrop">
    <div class="item" id="load" style="text-align: center;margin-top: 50%;">
        <div class="ball">
            <div></div>
            <div></div>
        </div>
        <div style="margin-top: 10px;">loading...</div>
    </div>
    <div class="item" id="pause">
        <div id="userinfo" style="text-align: center;">
            <div id="title" style="font-size: 18px;margin-bottom: 26px;    color: #FFF;"></div>
            <div>
                <img id="userimg" class="headimg" style="width: 80px;    margin-bottom: 11px;  border-radius: 80px;"/>
            </div>
            <div id="des" style="font-size: 14px;"></div>
        </div>
        <%--  <div style="text-align: center;max-height: 200px;overflow: hidden;">
              <img id="cover" src="<%=basePath%>images/dashang.jpg" style="    width: 100%;">
          </div>--%>
        <div style="text-align: center;margin-top: 30px;">
            <button id="bofang" style="padding: 0;    background: rgba(0,0,0,0);border: 0; margin-right: 11px"><img
                    style="width: 90px;"
                    src="../image/play_white_rectangle.png"/></button>
            <button id="fenxaing" style="padding:0;    background: rgba(0,0,0,0);border: 0;"><img style="width: 90px;"
                                                                                                  src="../image/share_white_rectangle.png"/>
            </button>
        </div>
    </div>
    <div class="item" id="sharepic" style="position: absolute; right: 7px; top: 7px;width: inherit; height: inherit;">
        <img style="width: 270px;" src="../image/click_right_to_share_3.png"/>
    </div>
</div>
</body>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script>
    //id=297e9e79585d7d9701585d99b5570006
    var media = document.getElementById("audio");
    var $mask = $(".mui-backdrop");
    var loadedImgnum = 0;
    var title = "${title}";
    var imgurl = ${imgurl};
    var des = "${des}";
    if (!des) {
        des = "爱要分享，爱要立可拍"
    }
    $mask.showItem = function (item) {
        $(this).children("div.item").hide();
        $(this).show();
        $(this).children("#" + item).show();
    };
    $mask.hideItem = function () {
        $(this).hide();
    };
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
            link: '<%=basePath%>YINGJI/yingji?id=' + id, // 分享链接
            imgUrl: preImg + imgurl[0].path, // 分享图标
            success: function (res) {
                // alert(JSON.stringify(res));
                // 用户确认分享后执行的回调函数
            },
            cancel: function () {
                // 用户取消分享后执行的回调函数
            }
        });
        wx.onMenuShareAppMessage({
            title: title, // 分享标题
            desc: des, // 分享描述
            link: '<%=basePath%>YINGJI/yingji?id=' + id, // 分享链接
            imgUrl: preImg + imgurl[0].path, // 分享图标
            type: 'link', // 分享类型,music、video或link，不填默认为link
            success: function () {
                alert(JSON.stringify(res));
                // 用户确认分享后执行的回调函数
            },
            cancel: function () {
                // 用户取消分享后执行的回调函数
            }
        });
    });
    //接收传递过来的参数
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
    var id = "${id}";
    var preImg = "http://121.40.255.15:8080/Z22629";

    /*var actions = ['magic', "puffOut", "vanishOut", "openDownLeft", "openUpLeft", "openDownLeftOut", "openDownRightOut", "openUpLeftOut", "openUpRightOut", "rotateDown"];*/
    var actions = ['action', 'spaceOutLeft', 'vanishOut', 'puffOut'];
    /*    var inaction = ['spaceInRight'];*/
    $(function () {
        $mask.showItem("load");
        loadImg();
        $("#musicControl").on("tap", function () {
            if (media.error) {
                var errorCode = media.error.code;
                switch (errorCode) {
                    case (1): {
                        mui.toast("音乐播放被终止");
                        break;
                    }
                    case 2: {
                        mui.toast("网络错误，音乐无法加载");
                        break;
                    }
                    case 3: {
                        mui.toast("解码错误，音乐无法播放");
                        break;
                    }
                    case 4: {
                        mui.toast("音乐不存在或音乐格式无效");
                        break;
                    }
                }
            } else if (media.paused) {
                media.play();
            } else {
                media.pause();
            }
        });
        media.addEventListener("pause", function () {
            $("#musicControl").removeClass("playing");
        });
        media.addEventListener("play", function () {
            $("#musicControl").addClass("playing");
        });
        $("#fenxaing").on("tap", function (e) {
            e.stopPropagation();
            $mask.showItem("sharepic");
        });
        $mask.on("tap", function (e) {
            e.stopPropagation();
            if ($(".full-container").length - loadedImgnum == 0) $mask.hideItem();
        });
        $("#bofang").on("tap", function () {
            play();
        });
        $("#fenxiang1").on("tap", function (e) {
            e.stopPropagation();
            $mask.showItem("sharepic");
            pause();
        });
        $("#pageshow").on("tap", function () {
            window.history.back();
        });
    });
    //每个场景展示时间（毫秒）
    var sencetime = 6000;
    //动画循环
    var t = null;
    //动画开始时间
    var actionstart;
    //动画暂停时间
    var pauseTime;
    //播放状态(playing,paused,stop)
    var actionState = "stop";
    function pauseOrplay() {
        if (actionState == "stop" || actionState == "paused") {
            play();
        } else {
            pause();
        }
    }
    function addActive(index) {
        if (!index) {
            index = 0;
        }
        var target = $(".full-container").removeClass("active").get(index);
        var $child = $(target).addClass("active").children(".imgwraper").children("img").addClass("magictime " + actions[0]);
        if ($child.css("animation-play-state") == "paused" || $child.css("-webkit-animation-play-state") == "paused") {
            $child.css({
                "animation-play-state": "running",
                "-webkit-animation-play-state": "running"
            });
        }
        actionstart = new Date();
    }
    //播放
    function play() {
        var $target = $(".full-container.active");
        switch (actionState) {
            case "playing": {
                break;
            }
            case "paused" : {
                $target.children(".imgwraper").children("img").css({
                    "animation-play-state": "running",
                    "-webkit-animation-play-state": "running"
                });
                //计算动画已执行的时间，定时启动动画
                setTimeout(function () {
                    next();
                    if (typeof t != "number") t = setInterval(next, sencetime)
                }, (sencetime - (pauseTime - actionstart)));
                break;
            }
            default: {
                //获取正在播放元素的索引
                var index = $target.index();
                if (index + 1 >= $(".full-container").length || index < 0) {
                    index = 0;
                    addActive(index);
                }
                if (typeof t != "number") {
                    t = setInterval(next, sencetime)
                }
                break;
            }
        }
        $mask.hideItem();
        actionState = "playing";
        media.play();
        $("#controll").attr("src", "../image/pause_grey.png");
    }
    //下一张
    function next() {
          (t);
        var $target = $(".full-container.active");
        var index = $target.index();
        //播放数量大于等于总图片时停止
        if ((index + 1) >= $(".full-container").length) {
            stop();
        } else {
            addActive(index + 1);
        }
    }
    //暂停
    function pause() {
        if (actionState == "playing") {
            clearInterval(t);
            t = null;
            actionState = "paused";
            pauseTime = new Date();
            var $target = $(".full-container.active");
            var index = $target.index();
            var $children = $target.children(".imgwraper").children("img");
            //暂停动画
            $children.css({
                "animation-play-state": "paused",
                "-webkit-animation-play-state": "paused"
            });
            $mask.showItem("pause");
            media.pause();
        }

        $("#controll").attr("src", "../image/pause_grey.png");
    }
    //停止
    function stop() {
        //停止后会将动画播放完
        if (actionState != "stop") {
            actionState = "stop";
            clearInterval(t);
            t = null;
            $mask.showItem("pause");
            $("#controll").attr("src", "../image/pause_grey.png");
            media.pause();
        }
    }
    //加载图片
    function loadImg() {
        $.ajax({
            url: "<%=basePath%>userPort/yingji/detail",
            data: {id: id},
            type: "GET",
            dataType: "json",
            success: function (data) {
                //加载图片
                  (data);
                var yjgl_detail = data.yingji.tlkYingjipicEntities;
                $("#audio").attr("src", data.yingji.itemMusic);
                $(".headimg").attr("src", data.user.headimgurl);
                $("#title").text(data.yingji.itemTitle);
                $("#des").text("出品/" + data.user.nickname);
                $("#nickname").text(data.user.nickname);
                //    $("#cover").attr("src", preImg + JSON.parse(data.yj.item_cover)[0].path)
                media.play();
                for (var i in yjgl_detail) {
                    var imsrc = preImg + JSON.parse(yjgl_detail[i].itemImgurl)[0].path;
                    var imgwraper = $("<div class=\"full-container\"><div class=\"imgwraper\"></div></div>");
                    var imgItem = $("<img />");

                    imgItem.attr("src", imsrc);
                    $(".section").append(imgwraper);
                    imgwraper.find(".imgwraper").append(imgItem);
                    imgItem.on("load", function (e) {
                        loadedImgnum++;
                        checkload();
                    });
                }

            }
        })
        ;
    }
    function checkload() {
        if ($(".full-container").length - loadedImgnum == 0) {
            $mask.hide();
            play();
        }
    }
</script>
</html>
