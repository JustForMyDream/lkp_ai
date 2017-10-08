<%--


  Date: 2016/10/18
  Time: 9:26
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
    <title>影集</title>
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
            top: 46px;
            height: auto;
        }

        .mui-scroll-wrapper,
        .mui-scroll {
            background-color: #efeff4;
        }

        .mui-page.mui-transitioning {
            -webkit-transition: -webkit-transform 300ms ease;
            transition: transform 300ms ease;
        }

        .mui-page-left {
            -webkit-transform: translate3d(0, 0, 0);
            transform: translate3d(0, 0, 0);
        }

        .mui-ios .mui-page-left {
            -webkit-transform: translate3d(-20%, 0, 0);
            transform: translate3d(-20%, 0, 0);
        }

        .mui-navbar {
            position: fixed;
            right: 0;
            left: 0;
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

        .mui-android .mui-navbar-inner.mui-navbar-left {
            opacity: 0;
        }

        .mui-ios .mui-navbar-left .mui-left,
        .mui-ios .mui-navbar-left .mui-center,
        .mui-ios .mui-navbar-left .mui-right {
            opacity: 0;
        }

        .mui-navbar .mui-btn-nav {
            -webkit-transition: none;
            transition: none;
            -webkit-transition-duration: .0s;
            transition-duration: .0s;
        }

        .mui-navbar .mui-bar .mui-title {
            display: inline-block;
            width: auto;
        }

        .mui-page-shadow {
            position: absolute;
            right: 100%;
            top: 0;
            width: 16px;
            height: 100%;
            z-index: -1;
            content: '';
        }

        .mui-page-shadow {
            background: -webkit-linear-gradient(left, rgba(0, 0, 0, 0) 0, rgba(0, 0, 0, 0) 10%, rgba(0, 0, 0, .01) 50%, rgba(0, 0, 0, .2) 100%);
            background: linear-gradient(to right, rgba(0, 0, 0, 0) 0, rgba(0, 0, 0, 0) 10%, rgba(0, 0, 0, .01) 50%, rgba(0, 0, 0, .2) 100%);
        }

        .mui-navbar-inner.mui-transitioning,
        .mui-navbar-inner .mui-transitioning {
            -webkit-transition: opacity 300ms ease, -webkit-transform 300ms ease;
            transition: opacity 300ms ease, transform 300ms ease;
        }

        .mui-page {
            display: none;
        }

        .mui-pages .mui-page {
            display: block;
        }

        .mui-page .mui-table-view:first-child {
            margin-top: 15px;
        }

        .mui-page .mui-table-view:last-child {
            margin-bottom: 30px;
        }

        .mui-table-view {
            margin-top: 20px;
        }

        .mui-table-view span.mui-pull-right {
            color: #999;
        }

        .mui-table-view-divider {
            background-color: #efeff4;
            font-size: 14px;
        }

        .mui-table-view-divider:before,
        .mui-table-view-divider:after {
            height: 0;
        }

        .head {
            height: 40px;
        }

        #head {
            line-height: 40px;
        }

        .head-img {
            width: 40px;
            height: 40px;
        }

        #head-img1 {
            position: absolute;
            bottom: 10px;
            right: 40px;
            width: 40px;
            height: 40px;
        }

        .update {
            font-style: normal;
            color: #999999;
            margin-right: -25px;
            font-size: 15px
        }

        .mui-fullscreen {
            position: fixed;
            z-index: 20;
            background-color: #000;
        }

        .mui-ios .mui-navbar .mui-bar .mui-title {
            /*position: static;*/
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

        .rect {
            width: 33.33333%;
            display: inline-block;
            overflow: hidden;
            padding: 2px;
            position: relative;
        }

        .rect:before {
            font-family: Muiicons;
            content: "";
            background-image: url("../image/unselect_gray_small.png");
            background-size: 100%;
            position: absolute;
            top: 10px;
            right: 10px;
            display: block;
            height: 18px;
            width: 18px;
        }

        .rect.selected:before {
            background-image: url("../image/select_yellow_small.png");
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

        #mHeader {
            position: absolute;
            display: block;
            width: 30px;
            height: 30px;
            right: 15px;
            top: 15px;
            border-radius: 100%;
            background-image: url("../image/unselect_gray_small.png");
            z-index: 30;
            background-size: 100%;
        }

        #mHeader.selected {
            background-image: url("../image/select_yellow_small.png");
        }

        .mui-preview-image {
            display: none;
            -webkit-animation-duration: 0.5s;
            animation-duration: 0.5s;
            -webkit-animation-fill-mode: both;
            animation-fill-mode: both;
        }

        .mui-preview-image.mui-preview-in {
            -webkit-animation-name: fadeIn;
            animation-name: fadeIn;
        }

        .mui-preview-image.mui-preview-out {
            background: none;
            -webkit-animation-name: fadeOut;
            animation-name: fadeOut;
        }

        .mui-preview-image.mui-preview-out .mui-preview-header,
        .mui-preview-image.mui-preview-out .mui-preview-footer {
            display: none;
        }

        .mui-zoom-scroller {
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
        }

        .mui-zoom {
            -webkit-transform-style: preserve-3d;
            transform-style: preserve-3d;
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

        .mui-android-4-1 .mui-slider.mui-preview-image .mui-slider-group .mui-slider-item {
            display: inline-table;
        }

        .mui-android-4-1 .mui-slider.mui-preview-image .mui-zoom-scroller img {
            display: table-cell;
            vertical-align: middle;
        }

        .mui-preview-loading {
            position: absolute;
            width: 100%;
            height: 100%;
            top: 0;
            left: 0;
            display: none;
        }

        .mui-preview-loading.mui-active {
            display: block;
        }

        .mui-preview-loading .mui-spinner-white {
            position: absolute;
            top: 50%;
            left: 50%;
            margin-left: -25px;
            margin-top: -25px;
            height: 50px;
            width: 50px;
        }

        .mui-control-content {
            background-color: white;
            min-height: 215px;
        }

        .mui-control-content .mui-loading {
            margin-top: 50px;
        }

        .mui-preview-image img.mui-transitioning {
            -webkit-transition: -webkit-transform 0.5s ease, opacity 0.5s ease;
            transition: transform 0.5s ease, opacity 0.5s ease;
        }

        @-webkit-keyframes fadeIn {
            0% {
                opacity: 0;
            }
            100% {
                opacity: 1;
            }
        }

        @keyframes fadeIn {
            0% {
                opacity: 0;
            }
            100% {
                opacity: 1;
            }
        }

        @-webkit-keyframes fadeOut {
            0% {
                opacity: 1;
            }
            100% {
                opacity: 0;
            }
        }

        @keyframes fadeOut {
            0% {
                opacity: 1;
            }
            100% {
                opacity: 0;
            }
        }

        .quarter {
            width: 25%;
            float: left;
            overflow: hidden;
            position: relative;
            border: 2px solid #ffffff;
        }

        .quarter img {
            -webkit-user-select: none;
            -webkit-touch-callout: none;
        }

        .quarter.select:before {
            font-family: Muiicons;
            content: "\e460";
            position: absolute;
            height: 17px;
            vertical-align: middle;
            line-height: 17px;
            border-radius: 100%;
            background-color: #FAE03B;
            right: 5px;
            top: 5px;
        }

        .coverImg {
            overflow: hidden;
            padding-bottom: 3px;
            max-height: 200px;
        }

        .coverImg img {
            width: 100%;
            height: auto;
        }

        .icon-text {
            font-size: 16px;
            font-family: "微软雅黑";
            line-height: 21px;
        }

        input {
            padding: 6px 11px;
            font-family: inherit;
        }

        header {
            position: relative;
        }

        header .info {
            position: absolute;
            bottom: 0;
            width: 100%;
            padding: 5px;
            background-color: rgba(0, 0, 0, 0.2);
        }

        header .title {
            padding: 8px;
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

        .mui-content {
            background-color: #EEEEEE;
        }

        .mui-content .describe input {
            color: #9F9D9E;
            border: 0;
        }

        #imgContent img {
            width: 100%;
        }

        .bottom-btn {
            position: absolute;
            bottom: 0;
            background-color: #000;
            width: 100%;
            z-index: 20;
            padding: 10px 0;
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

        .bottom-btn > button#add {
            color: #FFF;
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

        /*****预览页面******/
        #perviewPage img {
            width: 100%;
            height: auto;
        }

        #perviewPage .yjs_top {
            height: auto;
            width: 100%;
            max-height: 200px;
            overflow: hidden;
        }

        #perviewPage .yjs_cen {
            height: auto;
            text-align: center;
            padding: 15px 15px 20px 15px;
        }

        #perviewPage .bottom_img {
            margin-top: 10px;
        }

        #perviewPage #time {
            margin-bottom: 10px;
            font-size: 13px;
        }

        #perviewPage #miaoshu {
            text-align: left;
            color: #8d8b8b;
            font-size: 14px;
        }

        #perviewPage .bottom-btn {
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

        #perviewPage #headimg {
            width: 40px;
            height: 40px;
            border-radius: 20px;
        }

        #perviewPage #userinfo {
            text-align: left;
            padding: 2px;
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

        #perviewPage #other {
            font-size: 12px;
            color: #B2B2B2;
        }

        #perviewPage .user-des {
            margin-right: 10px;
        }

        #perviewPage .user-des > span:first-child {
            font-size: 14px;
        }

        #perviewPage #miaoshu {
            text-align: center;
        }

        #perviewPage #musicControl.playing {
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

        /*****动态播放****/
        #perviewPage_active .H5-container {
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            background-color: #000;
            overflow: hidden;
        }

        #perviewPage_active .full-container {
            font-size: 14px;
            position: absolute;
            width: 100%;
            height: 100%;
            vertical-align: top;
            display: none;
        }

        #perviewPage_active .full-container.active {
            display: inline-block;
        }

        #perviewPage_active .imgwraper {
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

        #perviewPage_active .imgwraper img {
            width: auto;
            height: auto;
            max-width: 100%;
            max-height: 100%;
            transform-style: preserve-3d;
        }

        #perviewPage_active .section {
            font-size: 0;
            -webkit-transition: all 0s linear;
            transition: all 0s linear;
            white-space: nowrap;
        }

        #perviewPage_active .magictime {
            -webkit-animation-duration: 6s;
            -moz-animation-duration: 6s;
            -o-animation-duration: 6s;
            animation-duration: 6s;
        }

        #perviewPage_active .action {
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
<!--页面主结构结束-->
<!--选择图片页面开始-->
<div id="imgchoose" class="mui-page">
    <!--页面标题栏开始-->
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
        <a id="chooseimgfinish" class="mui-btn mui-btn-link mui-pull-right" href="#coverChoose">完成</a>

        <h1 class="mui-center mui-title">选择图片</h1>
    </div>
    <!--页面标题栏结束-->
    <!--页面主内容区开始-->
    <div class="mui-page-content">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll" id="show">
                <div class="mui-loading" id="loadd">
                    <div class="mui-spinner">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--页面主内容区结束-->
</div>
<!--图片编辑页面-->
<div id="coverChoose" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
        <a id="next" class="mui-btn mui-btn-link mui-pull-right" href="#setting">下一步</a>

        <h1 class="mui-center mui-title">编辑图片</h1>
    </div>
    <div class="mui-page-content" style="background-color: #ECECEC">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll">
                <div class="coverImg">
                    <img id="cover" src="http://placehold.it/370x200?text=请选择图片"/>
                </div>
                <div id="allChoosedImg" class="">
                    <div id="clear" style="clear: both;"></div>
                </div>
                <div style="text-align: center;   font-size: 12px; padding-bottom: 40px;">点击图片更换封面，长按删除图片</div>
                <div style="bottom:30px;width:100%;z-index:20">
                    <button id="coverFncbtn" style=" display: block; margin: 0 auto; background: #FDDF44;">添加图片</button>
                </div>
            </div>
        </div>
    </div>
</div>
<!--单页面结束-->
<div id="setting" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <a class="mui-action-back mui-btn mui-btn-link mui-pull-left">取消</a>
        <a id="perview" class="mui-btn mui-btn-link mui-pull-right" href="#perviewPage">预览</a>

    </div>
    <div class="mui-page-content" style="background-color: #ECECEC">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll">
                <header>
                    <div class="cover-img" style=" max-height: 400px;  overflow: hidden;">
                        <img src="../images/add_cover.jpg" style="width: 100%;"/>
                    </div>
                    <div class="info">
                        <div class="title">
                            <input type="text" value="添加标题"/>
                        </div>
                        <div class="time">
                            创建于2016.10.02
                        </div>
                    </div>
                </header>
                <div class="mui-content" id="imgContent">
                    <div class="describe" style="padding: 10px;padding-bottom: 0">
                        <input type="text" value="添加文字描述"/>
                    </div>
                    <img id="addpics" src="../images/add_pics.jpg"/>
                </div>
            </div>
        </div>
    </div>
    <div id="button-group" class="bottom-btn">
        <button id="selectmusic"><img src="../image/music_white.png"/><span>选择音乐</span></button>
        <button id="editpic"><img src="../image/view.png"/><span>修改图片</span></button>
    </div>
</div>
<!--单页面结束-->
<div id="music" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
        <a class="mui-btn mui-btn-link mui-pull-right" href="#setting">保存</a>

        <h1 class="mui-center mui-title"></h1>
    </div>
    <div class="mui-page-content" style="background-color: #ECECEC">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll">
                <ul id="musicList" class="mui-table-view">
                    <li class="mui-table-view-cell">
                        <a class="selected"
                           data-music="<%=basePath%>bgm/Peerless 2x2 - Canon (Over a Basso Ostinato)  钢琴二重奏版卡农.mp3">钢琴二重奏版卡农</a>
                    </li>
                    <li class="mui-table-view-cell">
                        <a data-music="<%=basePath%>bgm/summer.mp3">summer</a>
                    </li>
                    <li class="mui-table-view-cell">
                        <a data-music="<%=basePath%>bgm/四季 音色 - 春日.mp3">四季 音色 - 春日</a>
                    </li>
                    <li class="mui-table-view-cell">
                        <a data-music="<%=basePath%>bgm/文武贝 - 冬之韵.mp3">文武贝 - 冬之韵</a>
                    </li>
                    <li class="mui-table-view-cell">
                        <a data-music="<%=basePath%>bgm/晚秋.mp3">晚秋</a>
                    </li>
                    <li class="mui-table-view-cell">
                        <a data-music="<%=basePath%>bgm/爱情转移.mp3">爱情转移</a>
                    </li>
                    <li class="mui-table-view-cell">
                        <a data-music="<%=basePath%>bgm/秋日的私语.mp3">秋日的私语</a>
                    </li>
                    <li class="mui-table-view-cell">
                        <a data-music="<%=basePath%>bgm/骆集益 - 1945.mp3">骆集益 - 1945</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
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
<div id="picture" class="mui-popover mui-popover-action mui-popover-bottom">
    <ul class="mui-table-view">
        <li class="mui-table-view-cell">
            <a id="choosePhonePic">手机中选择</a>
        </li>
        <li class="mui-table-view-cell">
            <a id="chooseOrderpic">订单中选择</a>
        </li>
    </ul>
    <ul class="mui-table-view">
        <li class="mui-table-view-cell">
            <a href="#picture"><b>取消</b></a>
        </li>
    </ul>
</div>
<!--静态预览-->
<div id="perviewPage" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <a class="mui-action-back mui-btn-link mui-pull-left">编辑</a>
        <%--     <a class="mui-btn-link mui-pull-left">删除</a>--%>
        <a class="mui-btn mui-btn-link mui-pull-right save">保存</a>

        <h1 class="mui-center mui-title"></h1>
    </div>
    <div class="mui-page-content" style="background-color: #ECECEC">
        <div class="mui-scroll-wrapper">
            <div id="musicControl" style="position: fixed;z-index: 2;
    top: 64px;
    right: 20px;
    border-radius: 20px;">
                <img src="../image/music_white.png" style="width: 20px;
    height: 20px;">
            </div>
            <div id="playButton" style="position: fixed;z-index: 2;
    bottom: 18px;
    left: 10px;
    border-radius: 20px;">
                <img src="../image/play_yellow.png" style="width: 38px;
    height: 38px;">
            </div>
            <div class="mui-scroll">
                <div class="yjs_top">
                    <img id="top_img"/>
                </div>
                <div class="yjs_cen">
                    <h3 id="title" style="margin-bottom: 15px; font-size: 18px; font-weight: 500;color: #000;"></h3>
                    <div id="time"></div>
                    <div id="miaoshu"></div>
                </div>
                <div class="bottom" id="ibottom">

                </div>
            </div>
        </div>
    </div>
</div>
<!--动态预览-->
<div id="perviewPage_active" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <a class="mui-action-back mui-btn-link mui-pull-left">编辑</a>
        <%--        <a class="mui-btn-link mui-pull-left">删除</a>--%>
        <a class="mui-btn mui-btn-link mui-pull-right save">保存</a>

        <h1 class="mui-center mui-title"></h1>
    </div>
    <div class="mui-page-content" style="background-color: #ECECEC">
        <div class="H5-container">
            <div class="section">
            </div>
        </div>
    </div>
</div>
<audio id="audio" style="opacity:0" loop hidden="hidden"></audio>
</body>
<script src="<%=basePath%>js/mui.zoom.js"></script>
<script src="<%=basePath%>js/mui.previewimage1.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script>
    var id = "${id}";
    var orderid = "${orderid}";
    var coverfncbtn = ["添加图片", "保存修改"];
    var defaultvalueArray = ["添加标题", "添加文字描述"];
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
    //mui页面处理
    var view = viewApi.view;
    (function ($) {
        //处理view的后退与webview后退
        var oldBack = $.back;
        $.back = function () {
            if (viewApi.canBack()) { //如果view可以后退，则执行view的后退
                viewApi.back();
            } else { //执行webview后退
                oldBack();
            }
        };
        //监听页面切换事件方案1,通过view元素监听所有页面切换事件，目前提供pageBeforeShow|pageShow|pageBeforeBack|pageBack四种事件(before事件为动画开始前触发)
        //第一个参数为事件名称，第二个参数为事件回调，其中e.detail.page为当前页面的html对象
        view.addEventListener('pageBeforeShow', function (e) {
              (e.detail.page.id + ' beforeShow');
        });
        view.addEventListener('pageShow', function (e) {
              (e.detail.page.id + ' show');
            var pageId = e.detail.page.id;
            if(pageId=='imgchoose'){
                initOrderpic();
            }
            if (pageId == "coverChoose") {
                initChooseCover();
            }
            if (pageId == "setting") {
                initSetting();
            }
            if (pageId == "music") {
                playAudio();
            } else {
                audio.pause();
            }
            if (pageId == "perviewPage") {
                initPageView();
            }
            if (pageId == "perviewPage_active") {
                initperviewPage_active();
            }
        });
        view.addEventListener('pageBeforeBack', function (e) {
              (e.detail.page.id + ' beforeBack');
        });
        view.addEventListener('pageBack', function (e) {
              (e.detail.page.id + ' back');
        });
    })(mui);
    wx.config({
        debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
        appId: '${appId}', // 必填，公众号的唯一标识
        timestamp: ${timestamp}, // 必填，生成签名的时间戳
        nonceStr: '${nonceStr}', // 必填，生成签名的随机串
        signature: '${signature}',// 必填，签名，见附录1
        jsApiList: ['getLocation', 'downloadImage', 'onMenuShareTimeline', 'onMenuShareAppMessage', 'hideMenuItems', 'chooseImage', 'uploadImage'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });
    function ImgObj(id, type, src, targetId) {
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
            /*
            *
            * var uploadimg_I=0;
             function uploadImg() {
             if (uploadimg_I < yingji.getImgList().length) {
             new ImgObj(yingji.getImgList()[i].id, yingji.getImgList()[i].type, yingji.getImgList()[i].src, yingji.getImgList()[i].targetId).uploadImg();
             }
             }
            * */
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
            } else if (this.type == 'order') {
                this.uploadState = true;
                $("#" + this.id).attr("data-target", that.toString());
                uploadimg_I++;
                uploadImg(uploadimg_I)
            } else if (this.type == 'service') {
                this.uploadState = true;
                $("#" + this.id).attr("data-target", that.toString());
                uploadimg_I++;
                uploadImg(uploadimg_I)
            }else{
                uploadimg_I++;
                uploadImg(uploadimg_I)
            }
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
        var container = $("#allChoosedImg");
        var prop = yingji.prototype;
        prop._init = function () {
            container.empty(".quater");
            for (var i = 0; i < prop.imglist.length; i++) {
                var imgitem = $("<div class=\"quarter\">" + imglist[i].toHTML() + "</div>");
                $("#clear").before(imgitem);
                imgitem.css("height", imgitem.width() + "px");
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
            var obj = new ImgObj(this.uuid(), type, src, targetId);
            var imgitem = $("<div class=\"quarter\">" + obj.toHTML() + "</div>");
            $("#clear").before(imgitem);
            imgitem.css("height", imgitem.width() + "px");
            imgitem.children("img").on("load", function (e) {
                var $this = $(e.target);
                if ($this.width() < $this.height()) {
                    $this.css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
                } else {
                    $this.css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
                }
            });
        };
        /**
         * 类型判断 是否为定义的imgobject
         * */
        prop.isImgObj = function (obj) {
            return (obj.hasOwnProperty("id") && obj.hasOwnProperty("type") && obj.hasOwnProperty("src") && obj.hasOwnProperty("targetId"));
        };
        /**
         * 通过id移除img
         * */
        prop.removeImgObj = function (id) {
            var arry = [];
            $("#" + id).parents(".quarter").remove();
        };
        /**
         * 在最前面添加img
         * */
        prop.unshift = function (obj) {
            var imgitem = $("<div class=\"quarter\">" + obj.toHTML() + "</div>");
            container.prepend(imgitem);
            imgitem.css("height", imgitem.width() + "px");
            imgitem.children("img").on("load", function (e) {
                var $this = $(e.target);
                if ($this.width() < $this.height()) {
                    $this.css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
                } else {
                    $this.css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
                }
            });
        };
        /**
         * 通过id删除img
         * */
        prop.deleteImg = function (id) {
            $("#" + id).parent().remove();
        };
        /**
         * 将指定id的img移到第一位
         * */
        prop.moveToFirst = function (id) {
            var data = JSON.parse($("#" + id).attr("data-target"));
            var imgObj;
            if (data.targetId) {
                imgObj = new ImgObj(data.id, data.type, data.src, data.targetId);
            } else {
                imgObj = new ImgObj(data.id, data.type, data.src, null);
            }

              (imgObj);
            this.deleteImg(id);
            this.unshift(imgObj)
        };
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
                arry.push(JSON.parse($(imgs.get(i)).attr("data-target")));
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
    function loadYingjiDat() {
        $.ajax({
            url: "<%=basePath%>userPort/yingji/detail",
            data: {id: id},
            dataType: "json",
            success: function (data) {
                if (data.errorCode == 200) {
                    var yingjidata = data.yingji;
                    //初始化标题描述
                    $(".describe input").val(yingjidata.itemDes);
                    $(".title input").val(yingjidata.itemTitle);
                    //初始化图片
                    for (var i = 0; i < yingjidata.tlkYingjipicEntities.length; i++) {
                        yingji.addImg("service", imgpre + (JSON.parse(yingjidata.tlkYingjipicEntities[i].itemImgurl))[0].path, yingjidata.tlkYingjipicEntities[i].id);
                    }
                    //初始化音乐
                    var musiclist = $("#musicList .mui-table-view-cell>a");
                    for (var j = 0; j < musiclist.length; j++) {
                        if ($(musiclist[j]).data("music") == yingjidata.itemMusic) {
                            $(musiclist[j]).trigger("tap");
                        }
                    }
                    //初始化时间
                    var time = new Date(yingjidata.created);
                    $(".time").text("创建于" + time.getFullYear() + "." + (time.getMonth() + 1) + "." + time.getDate());
                    viewApi.go("#setting");
                    $(".mui-backdrop").hide();
                } else {
                    mui.toast("加载数据失败!");
                    history.go(-1);
                }
            }
        })
    }

    wx.ready(function () {
          ("ok");
        $(function () {
            //加载订单图片
            if (orderid != '') {
                getIndexData();
            }
            //若传入订单编号则修改
            if (id != '') {
                loadYingjiDat();

            } else {
                initChooseCover();
                $(".mui-backdrop").hide();
            }
            $("#playButton").on("tap", function () {
                viewApi.go("#perviewPage_active");
            });
            $("#pohoePic").on("tap", function () {
                choosePhonePic();
                mui("#picture").popover('toggle');
            });
            $("#coverFncbtn").on("tap", function () {
                switch ($(this).text()) {
                    case coverfncbtn[0]:
                    {
                        if (orderid == null || orderid == "") {
                            choosePhonePic(initChooseCover);
                        } else {
                            mui("#picture").popover('toggle')
                        }
                        //viewApi.go("#imgchoose");
                        break;
                    }
                    case coverfncbtn[1]:
                    {
                        $(".quarter").removeClass("select");
                        $(this).text(coverfncbtn[0]);
                        break;
                    }
                }
                var d = new Date();
            });
            $("#next").on("tap",function(e){
                if(yingji.getImgList()&&yingji.getImgList().length>0){

                }else{
                    e.preventDefault();
                    e.stopPropagation();
                    mui.toast("您还未选择图片");
                }
            });
            $("#selectmusic").on("tap", function () {
                viewApi.go("#music");
            });
            $("#editpic").on("tap", function () {
                viewApi.go("#coverChoose");
            });
            $("#allChoosedImg").on("tap", ".quarter:not(.select) img", function (e) {
                var targetId = $(this).attr("id");
                yingji.moveToFirst(targetId);
                initChooseCover();
                e.stopPropagation();
                e.preventDefault();
            }).on("touchstart", function (e) {
                e.preventDefault();
            }).on("longtap", ".quarter img", function (e) {
                $("#coverFncbtn").text(coverfncbtn[1]);
                $(".quarter").addClass("select");
                $("body").one("tap",function(){
                    $("#coverFncbtn").text(coverfncbtn[0]);
                    $(".quarter").removeClass("select");
                });
                e.stopPropagation();
                e.preventDefault();
                return false;
            }).on("tap", ".quarter.select,.quarter.select img", function (e) {
                e.stopPropagation();
                e.preventDefault();
                if ($(".quarter.select").length <= 1) {
                    mui.toast("已经最后一张了，不能再删了");
                    return false;
                }
                var targetid = $(this).children("img").attr("id");
                yingji.removeImgObj(targetid);
                // $("#" + targetid).parent().removeClass("selected");
                initChooseCover();
                $(".quarter").addClass("select");
            }).on("load", ".quarter img", function (e) {
                var $this = $(e.target);
                  ($this.attr("id"));
                if ($this.width() < $this.height()) {
                    $this.css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
                } else {
                    $this.css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
                }
            });
            $("#choosePhonePic").on("tap", function () {
                choosePhonePic();
                mui("#picture").popover('toggle');
            });
            $("#chooseOrderpic").on("tap", function () {
                viewApi.go("#imgchoose");
                mui("#picture").popover('toggle');
            });
            //标题输入
            $("header .title input").on("blur", function () {
                $("#button-group").show();
                if (!inputclick(this, defaultvalueArray[0])) {
                    mui.toast("请填写正确的标题");
                }
            }).on("tap", function () {
                $("#button-group").hide();
                if (defaultvalueArray.indexOf($(this).val()) >= 0)
                    $(this).val(null);
            });
            //描述输入
            $(".mui-content .describe input").on("blur", function () {
                $("#button-group").show();
                if (!inputclick(this, defaultvalueArray[1])) {
                    mui.toast("请填写正确的描述");
                }
            }).on("tap", function () {
                $("#button-group").hide();
                if (defaultvalueArray.indexOf($(this).val()) >= 0)
                    $(this).val(null);
            });
            $("#perview").on("tap", function () {
                var that = this;
                var cover = yingji.getImgList()[0];
                if (!inputclick($("header .title input").get(0), defaultvalueArray[0])) {
                    mui.toast("请填写正确的标题");
                    return false;
                } else if (!inputclick($(".mui-content .describe input").get(0), defaultvalueArray[1])) {
                    mui.toast("请填写正确的描述");
                    return false;
                } else if (cover == null || cover == "") {
                    mui.toast("请先选择封面");
                    return false;
                } else {
                }
            });
            $("#musicList>li.mui-table-view-cell>a").on("tap", function () {
                $("#musicList>li.mui-table-view-cell>a").removeClass("selected");
                $(this).addClass("selected");
                playAudio();
            });
            $("#chooseimgfinish").on("tap", function (e) {
                if (yingji.getImgList().length < 1) {
                    e.stopPropagation();
                    e.preventDefault();
                    mui.toast("请选择图片！");
                    return false;
                }else{
                    var pickedPic = $(".rect.selected");
                    for(var i=0;i<pickedPic.length;i++){
                        yingji.addImg("order",$(pickedPic[i]).find("img").attr("src"),$(pickedPic[i]).find("img").attr("id"));
                        $(pickedPic[i]).removeClass("selected");
                    }
                }
            });
            $(".H5-container").on("tap", function () {
                viewApi.back();
            });
            $(".save").on("tap", function () {
                submitYingji();
                audio.pause();
            });
            $("#show").on("tap",".rect",function(e){
                var $this = $(e.target);
                $this.toggleClass("selected");
            });
        });
    });
    var audio = document.getElementById("audio");
    audio.addEventListener("pause", function () {
        $("#musicControl").removeClass("playing");
    });
    audio.addEventListener("play", function () {
        $("#musicControl").addClass("playing");
    });
    function playAudio() {
        audio.src = $("#musicList>li.mui-table-view-cell>a.selected").attr("data-music");
        audio.play();
    }
    //初始化订单图片页面
    function initOrderpic(){
        var paths = $(".rect");
        paths.css("height", paths.width() + "px");
    }
    //初始化编辑页面
    function initChooseCover() {
        if (yingji.getImgList().length > 0) {
            $("#cover").attr("src", yingji.getImgList()[0].src);
            $(".bottom-btn").css("bottom", "0");
              (yingji.getImgList());
        }
    }
    function initSetting() {
        var list = yingji.getImgList();
          (list);
        var d = new Date();
        if (id == '') $(".time").text("创建于" + d.getFullYear() + "." + (d.getMonth() + 1) + "." + d.getDate());
        $(".cover-img img").attr("src", list[0].src);
        $("#imgContent img").remove();
        for (var i = 0; i < list.length; i++) {
            var imgItem = $("<img data-id='" + list[i].id + "' src='" + list[i].src + "'/>");
            $("#imgContent").append(imgItem);
        }
    }
    //初始化静态预览页面
    function initPageView() {
        var $top_img = $("#top_img");
        var $title = $("#title");
        var $time = $("#time");
        var $miaoshu = $("#miaoshu");
        $top_img.attr("src", yingji.getImgList()[0].src);
        $title.text($("header .title input").val());
        $time.text($(".time").text().substring(3));
        $miaoshu.text($(".mui-content .describe input").val());
        $("#ibottom").empty();
        var yjgl_detail = yingji.getImgList();
        for (var i = 0; i < yjgl_detail.length; i++) {
            var imsrc = yjgl_detail[i].src;
            $("#ibottom").append('<div class="bottom_img"><img src="' + imsrc + '"/></div>');
        }
        playAudio();
    }
    //初始化动态播放页面
    function initperviewPage_active() {
        var yjgl_detail = yingji.getImgList();
        $(".section").empty();
        for (var i = 0; i < yjgl_detail.length; i++) {
            var imsrc = yjgl_detail[i].src;
            var imgwraper = $("<div class=\"full-container\"><div class=\"imgwraper\"></div></div>");
            var imgItem = $("<img />");
            imgItem.attr("src", imsrc);
            $(".section").append(imgwraper);
            imgwraper.find(".imgwraper").append(imgItem);
        }
        play();
    }
    //下一张
    function next() {
          (t);
        var $target = $(".full-container.active");
        var index = $target.index();
        //播放数量大于等于总图片时停止
        if ((index + 1) >= $(".full-container").length) {
            viewApi.back();
        } else {
            addActive(index + 1);
        }
    }
    //暂停
    function pause() {
        viewApi.back();
    }
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
        var $child = $(target).addClass("active").children(".imgwraper").children("img").addClass("magictime " + "action");
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
        //获取正在播放元素的索引
        var index = $target.index();
        if (index + 1 >= $(".full-container").length || index < 0) {
            index = 0;
            addActive(index);
        }
        if (typeof t != "number") {
            t = setInterval(next, sencetime)
        }
        actionState = "playing";
        audio.play();
    }
    function perimgChanged(index) {
        $("#mHeader").attr("data-index", index);
        initImgViewer(index);
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
    function submitYingji() {
        $(".mui-backdrop").show();
        $(".mui-backdrop").find("#txt").text("上传图片中..");
        uploadimg_I=0;
        uploadImg(uploadimg_I);
    }
    var isuploaded = true;

    function uploadImg(i) {
        if (i < yingji.getImgList().length) {
            new ImgObj(yingji.getImgList()[i].id, yingji.getImgList()[i].type, yingji.getImgList()[i].src, yingji.getImgList()[i].targetId).uploadImg();
        }else{
            sendData();
        }
    }
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
            $(".mui-backdrop").find("#txt").text("后台处理数据..");
              (yingji.getImgList());
            var xhr = new XMLHttpRequest();
            xhr.open("post", "../userPort/yingji/create", true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4) {
                    if (xhr.status >= 200 && xhr.status < 400) {
                        $(".mui-backdrop").find("#txt").text("数据处理完成..");
                        var o = JSON.parse(xhr.responseText);
                        if (o.errorCode == 400) {
                            mui.toast("您太长时间未操作,请刷新页面");
                        } else if (o.errorCode == 200) {
                            mui.toast("影集创建成功!");
                            setTimeout(function () {
                                window.location.href = "yingji?id=" + o.id;
                            }, 2000);
                        }
                          (xhr.responseText);
                    } else {
                        $(".mui-backdrop").hide();
                        mui.toast("网络错误,保存失败");
                          (xhr.responseText);
                    }
                }
            };

            var data;
            var id = "${id}";
            if (id != "" && id != null) {
                data = {
                    id: id,
                    title: $("header .title input").val(),
                    des: $(".mui-content .describe input").val(),
                    music: $("#musicList>li.mui-table-view-cell>a.selected").attr("data-music"),
                    Yingjipics: yingji.getImgList()
                };
            } else {
                data = {
                    title: $("header .title input").val(),
                    des: $(".mui-content .describe input").val(),
                    music: $("#musicList>li.mui-table-view-cell>a.selected").attr("data-music"),
                    Yingjipics: yingji.getImgList()
                }
            }
            xhr.send(JSON.stringify(data));
        }
    }
    function choosePhonePic(callback) {
        wx.chooseImage({
            count: 9, // 默认9
            sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function (res) {
                  (res);
                // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
                for (var i = 0; i < res.localIds.length; i++) {
                      (i);
                    yingji.addImg("user", res.localIds[i], null);
                }
                if (callback) {
                    callback();
                }
                  (yingji.getImgList());
            },
            cancel: function () {
                mui.toast("还未选择任何图片！");
            }
        });
    }
    /*提交检测*/
    function inputclick(target, defaultval) {
        var val = $(target).val();
        if (val == null || val.trim() == "") {
            $(target).val(defaultval);
            return false;
        } else {
            for (var i = 0; i < defaultvalueArray.length; i++) {
                if (defaultvalueArray[i].indexOf(val) == 0) {
                      (defaultvalueArray[i].indexOf(val));
                    $(target).val(defaultval);
                    return false;
                }
            }
            return true;
        }
    }
    //初始化选片页面
    function getIndexData() {
        $.getJSON("../userPort/getOrderInfoById?id=" + orderid, function (data) {
              (data);
            $("#loadd").hide();
            if (data.orderproductimgEntities.length == 0) {
                var paths = "<div style='text-align: center;margin-top: 20%;'>暂无图片</div>";
                $('#show').append(paths);
                return;
            }
            var pics = data.orderproductimgEntities;
            for (var i = 0; i < pics.length; i++) {
                var pa = pics[i].itemImgurl;
                var tp = pics[i].itemImgurl;
                if (pa == "undefined" || !pa) {
                    pa = data[i].tp;
                }
                pa = JSON.parse(pa);
                tp = JSON.parse(tp);
                var paths = $("<div class='rect' ><img id ='" + pics[i].id + "' src='" + imgpre + pa[0].path + "' data-preview-src='" + imgpre + tp[0].path + "' data-preview-group='1'></div>");
                $("#show").append(paths);
/*                paths.css("height",paths.width()+"px");*/
                paths.children("img").on("load", function () {
                    if ($(this).width() < $(this).height()) {
                        $(this).css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
                    } else {
                        $(this).css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
                    }
                });
            }
            mui.previewImage({header: '<span id="mHeader"></span>'});
            $("#mHeader").on("tap", function (e) {
                if ($(this).attr("data-index")) {
                    var index = parseInt($(this).attr("data-index"));
                    var $taget = $($(".rect").get(index));
                    $taget.toggleClass("selected");
                    initImgViewer(index);
                }
                e.stopPropagation();
            });
        });
    }

</script>
</html>