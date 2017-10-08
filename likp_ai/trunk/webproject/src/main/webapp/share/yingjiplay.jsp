<%--


  Date: 2017/1/2
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName()  + path + "/";
%>
<html>
<head>
    <link href="../css/mui.min.css" rel="stylesheet">
    <link href="../css/base.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title>${title}</title>
    <style>
        body {
            font-size: 16px;
            background-color:white;
        }
        .head{
            position: absolute;
            width: 100%;
            height:40px ;
            z-index: 7;
            /*background-color: rgba(167,167,167,0.5);*/
        }
         #pageshowpic{
             width: 5%;
             float: left;
             padding-top: 13px;
             padding-left: 9px;
             color: white;
        }
        .head>.share{
            width: 16%;
            float: right;
            padding-left: 5.9%;
            padding-top: 6px;
            color: white;
        }
        .footer{
            bottom: 0;
            position: absolute;
            width: 100%;
            height: 50px;
            width: 100%;
            background-color: rgba(167,167,167,0.5);
        }
        #headimg{
            width: 40px;
            height: 40px;
            border-radius: 20px;
            margin-left: 20px;
            margin-top: 5px;
        }
        #userinfo1 {
            text-align: left;
            padding: 2px;
        }

         #userinfo1 > div {
             display: block;
             height: auto;
             margin-right: 56%;
             margin-top: 5px;
        }

        #userinfo1 > div > span {
            display: block;
            height: 20px;
            line-height: 20px;
            padding-left: 5px;
            color: white;
        }
        .playing{
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
        .container-row{
                     width:100%;
                     height: 100%;
                     display: -webkit-flex;
                     display: flex;
                     align-items: center;
                     justify-content: center;
                     -webkit-box-align: center;
                     -webkit-align-items: center;
                     -webkit-box-pack: center;
                     -webkit-justify-content: center;
                     background-color: rgba(0,0,0,1);
                     z-index: -2;
                 }
        .top{
            position: absolute;
            top: 0;
            width: 100%;
            background-color: black;
            z-index: 6;
        }
        .bottom{
            position: absolute;
            bottom:0;
            width: 100%;
            background-color: black;
            z-index: 6;
        }
        .H5-container{
            position: relative;
            text-align: center;
            overflow: hidden;
            z-index: 1;
        }
        .H5-container-blur{
            width: 100%;
            height: 100%;
            position: absolute;
            top:0;
            z-index: -1;
            bottom: 0;
            background-size: 100%;
            background-repeat: no-repeat;
            background-position: center ;
            -webkit-filter: blur(15px);
            -moz-filter: blur(15px);
            -o-filter: blur(15px);
            -ms-filter: blur(15px);
            filter: blur(15px);
            overflow: hidden;
        }
        .picture{
            height: 100%;
            position: relative;
        }
         .picture img{
             height: 100%;
             margin: 0 auto;
             width: auto;
             text-align: center;
             vertical-align: middle;
             margin: auto;
        }

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
        .wenzi{
            z-index: 5;
            position: absolute;
            width: 100%;
            bottom: 0;
            margin-bottom: 0;
        }
        .wenzi p{
            text-overflow: ellipsis;
            white-space: nowrap;
            background-color: black;
            text-align: center;
            margin-bottom:0;
            border: 0;
            z-index: 5;
            padding: 0;
        }
        @-webkit-keyframes enlarge {
            0% {
                opacity:0;
                -moz-transform: scale(1);
                -webkit-transform:scale(1);
                -o-transform:scale(1);
                -transform:scale(1);
            }
            25% {
                opacity:0.5;

            }
            50% {
                opacity:0.75;

            }
            75%{

            }
            100%{
                opacity:1;
                -moz-transform: scale(1.2);
                -webkit-transform:scale(1.2);
                -o-transform:scale(1.2);
                -transform:scale(1.2);
            }
        }

        @-webkit-keyframes  narrow{
            0% {
                opacity:1;
                -moz-transform: scale(1.2);
                -webkit-transform:scale(1.2);
                -o-transform:scale(1.2);
                -transform:scale(1.2);
            }
            25% {

            }
            50% {

            }
            75%{
                opacity:1;
            }
            100%{
                -moz-transform: scale(1);
                -webkit-transform:scale(1);
                -o-transform:scale(1);
                -transform:scale(1);
            }

        }
        @-webkit-keyframes leftToRight{
            0%{
                opacity:1;
                -moz-transform:translate(-30px,0px) scale(1.2);
                -webkit-transform:translate(-30px,0px) scale(1.2);
                -o-transform:translate(-30px,0px) scale(1.2);
                -transform:translate(-30px,0px) scale(1.2);
            }
            25% {

            }
            50% {

            }
            75%{
                opacity:1;
                -moz-transform: translate(0,0) scale(1);
                -webkit-transform:translate(0,0) scale(1);
                -o-transform:translate(0,0) scale(1);
                -transform:translate(0,0) scale(1);
            }
            100%{
                opacity:1;
                -moz-transform: translate(0,0) scale(1);
                -webkit-transform:translate(0,0) scale(1);
                -o-transform:translate(0,0) scale(1);
                -transform:translate(0,0) scale(1);
            }
        }
        @-webkit-keyframes RightToLeft{
            0%{
                opacity:1;
                -moz-transform:translate(30px,0px) scale(1.2);
                -webkit-transform:translate(30px,0px) scale(1.2);
                -o-transform:translate(30px,0px) scale(1.2);
                -transform:translate(30px,0px) scale(1.2);
            }
            25% {

            }
            50% {

            }
            75%{
                opacity:1;
                -moz-transform: translate(0px,0px) scale(1);
                -webkit-transform:translate(0px,0px) scale(1);
                -o-transform:translate(0px,0px) scale(1);
                -transform:translate(0px,0px) scale(1);
            }
            100%{

            }
        }
        @-webkit-keyframes noChange{
            0% {
                opacity:1;
                -moz-transform: scale(1);
                -webkit-transform:scale(1);
                -o-transform:scale(1);
                -transform:scale(1);
            }
            25% {

            }
            50% {

            }
            75%{
                opacity:1;
            }
            100%{
                -moz-transform: scale(1);
                -webkit-transform:scale(1);
                -o-transform:scale(1);
                -transform:scale(1);
            }
        }
        .anim_fade_image {
            display: none;
        }
        .anim_fade_image.active{
            display: block;
        }
        .anim_fade_image img{
            -webkit-animation-name:enlarge;
            -webkit-animation-timing-function: ease-in-out;
            -webkit-animation-iteration-count:1;
            -webkit-animation-duration: 5s;
            -webkit-animation-direction: alternate;
            animation-play-state:paused;
            -webkit-animation-play-state:paused;
        }
        .anim_fade_image.active img{
            animation-play-state: running;
            -webkit-animation-play-state: running;
        }
        .anim_fade_image>.wenzi{
            -webkit-animation-name:noChange;
            -webkit-animation-timing-function: ease-in-out;
            -webkit-animation-iteration-count:1;
            -webkit-animation-duration: 5s;
            -webkit-animation-direction: alternate;
            animation-play-state:paused;
            -webkit-animation-play-state:paused;
        }
        .anim_fade_image.active > .wenzi{
            animation-play-state: running;
            -webkit-animation-play-state: running;
        }

    </style>
</head>
<body>
<header class="head">
    <div id="pageshowpic"><img style="width: 7px;" src="../images/1@2x.png"></div>
    <div id ="pageshowwenzi"  style=" color: white;width: 20%;float: left;padding-top: 10px;font-size: 14px;margin-left: 2px;">图文模式</div>
    <div id="share" class="share"><img  style="width: 25px" src="../images/share_03.png"></div>
</header>
<div class="top"></div>
<div class="bottom"></div>
<div class="container-row">

</div>
<%--<div class="footer">--%>
    <%--<div id="userinfo1">--%>
        <%--<img id="headimg" class="headimg"--%>
             <%--src="">--%>
        <%--<div class="user-des" style="float:right;">--%>
            <%--<span id="nickname" class="nickname">用户名</span>--%>
            <%--<span id="other" style="font-size: 10px;">爱，要立可拍</span>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<img id="controll" style=" width: 24px; height: 24px; position: absolute; top: 10px; right: 10px; margin-top: 2px;"--%>
         <%--src="../image/play_yellow.png"/>--%>
<%--</div>--%>

<audio id="audio" style="opacity:0" loop hidden="hidden" src=""></audio>

<div id="musicControl"  style="position: fixed;
    top: 60px;
    right: 30px;
    border-radius: 20px; z-index: 20; display: none;">
    <img src="../image/music_white.png" style="width: 20px;
    height: 20px;">
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
            <button id="bofang" style="padding: 0;    background: rgba(0,0,0,0);border: 0; margin-right: 11px"><img style="width: 90px;"
                                                                                                                    src="../image/play_white_rectangle.png"/></button>
            <button id="fenxaing" style="padding:0;    background: rgba(0,0,0,0);border: 0;"><img style="width: 90px;"
                                                                                                  src="../image/share_white_rectangle.png"/></button>
        </div>
    </div>
    <div class="item" id="sharepicture" style="    position: absolute;display: block;top: 0; right: 0;bottom: 0;left: 0;margin-top: 0;">
        <img style="width: 270px;" src="../image/click_right_to_share_3.png"/>
    </div>
</div>
</body>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/mui.min.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script>
    var $mask = $(".mui-backdrop");
    var id ="${id}";
   // var id = "297e9e795980e37601598142cb3a001a";
    var preImg = "http://localhost:8080/Z22629";
    var media = document.getElementById("audio");
    var loadedImgnum = 0;
    var imgurl = ${imgurl};
    var title="${title}";
    var des ="珍藏生活中的感动";
    $mask.showItem = function (item) {
        $(this).children("div.item").hide();
        $(this).show();
        $(this).children("#"+item).show();
    }

    $mask.hideItem = function () {
        $(this).hide();
    }

    wx.config({
        debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
        appId: '${appId}', // 必填，公众号的唯一标识
        timestamp:'${timestamp}', // 必填，生成签名的时间戳
        nonceStr: '${nonceStr}', // 必填，生成签名的随机串
        signature: '${signature}',// 必填，签名，见附录1
        jsApiList: ['getLocation', 'downloadImage', 'onMenuShareTimeline', 'onMenuShareAppMessage', 'hideMenuItems'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });

    wx.ready(function () {
        wx.hideMenuItems({
            menuList: ['menuItem:share:qq', 'menuItem:share:weiboApp', 'menuItem:share:facebook', 'menuItem:share:QZone']
        });
        media.play();
        wx.onMenuShareTimeline({
            title: title, // 分享标题
            link: '<%=basePath%>YINGJI/newYingji?id=' + id, // 分享链接
            imgUrl: preImg + imgurl[0].path, // 分享图标
            success: function (res) {
                // alert(JSON.stringify(res));
                // 用户确认分享后执行的回调函数
            },
            fail:function(res){
                console.log(res);
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
            fail:function(res){
                console.log(res);
            },
            cancel: function () {
                // 用户取消分享后执行的回调函数
            }
        });
    });

    $("#fenxaing").on("tap", function (e) {
        e.stopPropagation();
        $mask.showItem("sharepicture");
    });

    $("#bofang").on("tap", function () {
        var child = $(".anim_fade_image.active");
        var state1 = child.find("img").css("animation-play-state");
        var state2 = child.find("img").css("-webkit-animation-play-state");
        if(state1 == "paused"&& state2 == "paused"){
            child.find("img").css({
                "animation-play-state": "running",
                "-webkit-animation-play-state": "running"
            });
        }
        media.play();
        $mask.hideItem("pause");
    });

    $("#share").on("tap", function (e) {
        e.stopPropagation();
        controlPlay();
        $mask.showItem("sharepicture");
        media.pause();
    });

    $("#pageshowwenzi").on("tap", function () {
        window.location.href="newStaticYingji?id=${id}"
    });

    $("#sharepicture").on("tap",function () {
        $mask.hideItem("sharepicture")
        controlPlay();
        media.play();
    });

    $("#controll").on("tap",function () {
      controlPlay();
       controlMusic();
    });

    $(".container-row").on("tap",function (e) {
       controlPlay();
        controlMusic();
    })
//控制图片循环播放
loadImg();
function model() {
    var ifr_width = $(window).width();
    var windowHeight = $(window).height();
    $(".H5-container").css('width', ifr_width);
    $(".H5-container").css('height', ifr_width * 0.75);
    $(".top").css("height",(windowHeight-ifr_width*0.75)/2);
    $(".bottom").css("height",(windowHeight-ifr_width*0.75)/2+1);

//    $(".wenzi").css("top",ifr_width*0.75-19);
}
//控制动画循环
function playImg() {
    var con = document.querySelectorAll(".H5-container img");
    $(con[0]).parents(".H5-container").addClass("active");
    if(con.length == 1){
      con[0].addEventListener("webkitAnimationStart",function (e) {
          con[0].addEventListener("webkitAnimationStart",function (e) {
              var parent=$(e.target).parents(".H5-container");
              var img =parent.next().find("img");
              var imgWidth = img.width();
              var imgHeight = img.height();
              if (imgWidth>imgHeight){
                  parent.find("img").css('-webkit-animation-name','RightToLeft');
              }else {
                  var num1 = Math.random(0,1);
                  var num2 = Math.random(0,1);
                  if(num1>=num2){
                      parent.find("img").css('-webkit-animation-name','enlarge');
                  }
                  else {
                      parent.find("img").css('-webkit-animation-name','narrow');
                  }
              }
          })
          con[0].addEventListener("webkitAnimationEnd",function (e) {
              controlPlay();
          })
       })
    }
    else {
        for(var i = 0;i<con.length;i++){
            con[0].addEventListener("webkitAnimationStart",function (e) {
                var parent=$(e.target).parents(".H5-container");
                var img =parent.find("img");
                var imgWidth = img.width();
                var imgHeight = img.height();
                if (imgWidth>imgHeight){
                    img.css("width",$(window).width());
                    img.css("height","auto");
                    img.css("overflow","auto");
                    img.css("top",0);
                    img.css("left",0);
                    img.css("bottom",0);
                    img.css("position","absolute");
                    parent.find("img").css('-webkit-animation-name','leftToRight');
                }
            })
            con[i].addEventListener("webkitAnimationEnd", function (e) {
                var parent=$(e.target).parents(".H5-container");
                var next = parent.next();
                console.log(next);
                if(next[0]!=null){
                    next.addClass("active");
                    var img =parent.next().find("img");
                    var imgWidth = img.width();
                    var imgHeight = img.height();
                    var type = parent.find("img").css("-webkit-animation-name");
                    //控制样式
                    if (imgWidth>imgHeight){
                        next.find("img").css("width",$(window).width());
                        next.find("img").css("height","auto");
                        next.find("img").css("overflow","auto");
                        next.find("img").css("top",0);
                        next.find("img").css("left",0);
                        next.find("img").css("bottom",0);
                        next.find("img").css("position","absolute");
                        var num1 = Math.random(0,1);
                        var num2 = Math.random(0,1);
                        if(num1>=num2){
                            next.find("img").css('-webkit-animation-name','leftToRight');
                            parent.removeClass("active");
                        }
                        else {
                            next.find("img").css('-webkit-animation-name','RightToLeft');
                            parent.removeClass("active");
                        }
                    }
                    else {
                        if(type =="leftToRight"){
                            next.find("img").css('-webkit-animation-name','enlarge');
                            parent.removeClass("active");
                        }
                        else if(type =="RightToLeft"){
                            next.find("img").css('-webkit-animation-name','narrow');
                            parent.removeClass("active");
                        }
                        else if(type =="enlarge"){
                            next.find("img").css('-webkit-animation-name','narrow');
                            parent.removeClass("active");
                        }
                        else if(type == "narrow") {
                            next.find("img").css('-webkit-animation-name','enlarge');
                            parent.removeClass("active");
                        }
                    }
                }
                if(next[0]==null){
                    $($(".H5-container")[0]).addClass("active").find("img").css({
                        "animation-play-state": "running",
                        "-webkit-animation-play-state": "running"
                    });
                    parent.removeClass("active");
                }
            })
        }
    }
}

//控制动画播放与暂停
function controlPlay() {
        var child = $(".anim_fade_image.active");
        var state1 = child.find("img").css("animation-play-state");
        var state2 = child.find("img").css("-webkit-animation-play-state");
        if(state1 =="running"&&state2 =="running"){
            $mask.showItem("pause");
            child.find("img").css({
                "animation-play-state": "paused",
                "-webkit-animation-play-state": "paused"
            });
        }
        if(state1 == "paused"&& state2 == "paused"){
            child.find("img").css({
                "animation-play-state": "running",
                "-webkit-animation-play-state": "running"
            });
        }
}

//控制音乐的播放与暂停
function controlMusic() {
            if(media.error){
                /*var errorCode = media.error.code;
                switch (errorCode){
                    case(1):{
                        mui.toast("音乐播放被终止");
                        break;
                    }
                    case(2):{
                        mui.toast("网络错误，音乐无法加载");
                        break;
                    }
                    case(3):{
                        mui.toast("解码错误，音乐无法播放");
                        break;
                    }
                    case(4):{
                        mui.toast("音乐不存在或音乐格式无效");
                        break;
                    }
                }*/
            }
        else if(media.paused){
            media.play();
        }
        else {
            media.pause();
        }
    //控制图标样式
    media.addEventListener("pause",function () {
        $("#musicControl").removeClass("playing");
    });
    media.addEventListener("play",function () {
        $("#musicControl").addClass("playing");
    });
}

function checkLoad() {
    if($(".container-row").length - loadedImgnum ==0){
        $mask.hide();
//        WeixinJSBridge.invoke('getNetworkType', {}, function(e) {
//                // 在这里拿到 e.err_msg, 这里面就包含了所有的网络类型
//                // alert(e.err_msg);
//                document.getElementById('audio').play();
//            });
        document.getElementById('audio').play();
        model();
        playImg();
    }
}

//加载图片
function loadImg() {
    $.ajax({
        url:"../userPort/yingji/detail",
        data:{id:id},
        type:"GET",
        dataType:"json",
        success:function (data) {
            console.log(data);
            var yjgl_detail = data.yingji.tlkYingjipicEntities;
            $("#audio").attr("src",data.yingji.itemMusic);
            $(".headimg").attr("src", data.user.headimgurl);
            $("#nickname").text(data.user.nickname);
            //添加封面播放图片
            var itemCover = preImg + JSON.parse(data.yingji.itemCover)[0].path;
            if(itemCover!=null){
                var biaoti = data.yingji.itemTitle;
                var html = $("<div class='H5-container anim_fade_image'><div class='wenzi'><p>"+biaoti+"</p></div>" +
                        "<div class='picture'></div><div class='H5-container-blur' style='background-image: url("+itemCover+")' " +
                        "</div></div>");
                var imgCover = $("<img />");
                imgCover.attr("src", itemCover);
                $(".container-row").append(html);
                html.find(".picture").append(imgCover);
            }
            //添加内容图片
            for(var i in yjgl_detail){
                var imsrc =preImg+ JSON.parse(yjgl_detail[i].itemImgurl)[0].path;
                var wenzi = yjgl_detail[i].itemDescription;
                if(wenzi==null){
                    wenzi="";
                }
                var imgItem = $("<img />");
                imgItem.attr("src", imsrc);
                html = $("<div class='H5-container anim_fade_image'><div class='wenzi'><p>"+wenzi+"</p></div>" +
                        "<div class='picture'></div><div class='H5-container-blur' style='background-image: url("+imsrc+")' " +
                            "</div></div>");
                $(".container-row").append(html);
                html.find(".picture").append(imgItem);
//                controlMusic();
                imgItem.on("load", function (e) {
                    loadedImgnum++;
                    checkLoad();
                });
            }
        }
    });
}

/*
    //监听css动画
    var cssevent = document.getElementById("container-row");

    cssevent.addEventListener("webkitAnimationStart", function () {


    });

    cssevent.addEventListener("webkitAnimationIteration", function () {

    });
    cssevent.addEventListener("webkitAnimationEnd", function (e) {

        });
*/
</script>
</html>
