<%--


  Date: 2017/1/23
  Time: 4:16
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
    <title>作品</title>
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
            background-color: rgb(238,238,238);
        }

        .mui-pages {
            top: 44px;
            height: auto;
        }

        .mui-scroll-wrapper,
        .mui-scroll {
            background-color:  rgb(238,238,238);
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
            color: #FFF;
            font-size: 15px;
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

        .mui-bar .mui-btn-link {
            height: inherit;
            color: #FFF;
            font-family: Microsoft YaHei Light;
            font-size: 12px;
        }

        .mui-bar .mui-icon {
            color: #FFF;
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
            position: relative;
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
            background-color: #000;
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
        li.mui-table-view-cell:nth-of-type(1):after{
            height: 2px;
            background: linear-gradient(#d9d9da 1%, #969595 69%, #4d4d4d 80%);
        }

        .mui-scroll, .mui-page-content, .mui-page {
            min-height: 100%;
        }

        .mui-action-back.mui-icon.mui-icon-left-nav.mui-pull-left > span {
            width: 0;
        }
        .mui-bar-nav{
            box-shadow: none;
        }
        .item-wrapper {
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            width: 100%;
            background-color: rgb(34, 35, 40);
        }

        .loaditem {
            text-align: center;
            width: 100%;
            color: rgb(141, 139, 139);
            margin: 40% auto;
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
        .fromPhoneSelect{
            position: absolute;
            width: 100%;
            height: 44px;
            bottom: 0;
        }
        .fromPhoneSelect p{
            text-align: center;
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
        .cover-select{
            position: absolute;
        }
        .muisic-botton{
            width: 100%;
            color: rgb(156,160,160);
            background-color: white;
            text-align: center;
            line-height: 35px;
        }
        .cover-select{
            bottom: 10px;
            right: 10px;
            background-color: #000;
            color: #FFF;
            font-size: 12px;
            line-height: 12px;
            padding: 5px 6px;
        }

        .replacepic {
            padding: 10px;
            background-color: white;
            width: 100%;
            height: 110px;

        }

        .describe{
            width: calc(100% - 90px);
            margin: -3px;
            height: 100%;
            display: inline-block;
            vertical-align: top;
        }

        .waitpic {
            width: 90px;
            display: inline-block;
            overflow: hidden;
        }
        .waitpic>img {
            height: 100%;
            vertical-align: middle;
        }

        .click {
            text-align: center;
            line-height: 30px;
            font-size: 12px;
            color: rgb(151,151,151);
        }

        .piclist,.mulpiclist {
            width: 100%;
            height: auto;
            padding: 2%
        }

        .listitem ,.mullistitem{
            /*width: 23.958%;*/
            width: 25%;
            display: inline-block;
            overflow: hidden;
            position: relative;
        }
        .listitem>img{
            width: 100%;
        }

        .phoneclick {
            text-align: center;
            line-height: 40px;
            width: 100%;
            height: 40px;
            position: fixed;
            bottom: 0;
            background-color: white;
            color: black;
            border-top: 0.5px solid #979797;
            font-size: 15px;
        }
        .item{
            padding: 5px 12px 0;
        }
        .title{

        }
        .title  input{
            border-radius: 0;
            border:0;
            margin: 0;
            padding: 10px;
            text-align: center;
        }
        .item textarea{
            display: inline-block;
            height: 80px;
            margin: 0 -2px;
            vertical-align: top;
        }
        .item .img{
            display: inline-block;
            margin: 0 -2px;
            vertical-align: top;
        }
        .item textarea{
            padding: 0;
            width: calc(100% - 80px);
            border:0;
            border-radius: 0;
            font-family: inherit;
        }
        .itemInnerWrapper{
            padding: 10px;
            position: relative;
            background-color: #FFF;
        }
        .removeItem{
            position: absolute;
            top: 2px;
            left: 77px;
            padding: 0;
            border-radius: 100%;
            border: 0;
            background-color: rgba(0,0,0,0.5);
            color: #ffffff;
        }
        .removeItem>.mui-icon{
            font-size: 20px;
        }
        .itemInnerWrapper > textarea{
            padding-left: 12px;
        }
        .add-content{
            text-align: center;
            margin:10px 0;
            width: 100%;
            bottom: 5px;
        }
        .add-content>button{
            background-color: rgb( 151,151,151);
            border:0;
            padding:0 12px;
            border-radius: 6px;
            margin: 0 auto;
        }
        .add-content>button>.mui-icon{
            height: 20px;
            width: 20px;
            font-size: 20px;
            line-height: 20px;
            border:0;
            padding: 0;
            color: #ffffff;
        }
        .mui-checkbox input[type=checkbox]:before{
            color:rgba(170,170,170,0.5)
        }
        .mui-checkbox input[type=checkbox]:checked:before{
            color:rgb(235,185,125)
        }
        .img-warp{
            display: inline-block;
            width: 80px;
            height: 80px;
            overflow: hidden;
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
        <a id="finish" class="mui-btn mui-btn-link mui-pull-right">完成</a>

        <h1 class="mui-center mui-title">创建作品</h1>
    </div>
    <div class="mui-page-content" style="background-color: #ECECEC">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll">
                <div class="title">
                    <input name="title" type="text" placeholder="设置标题">
                </div>
                <div class="coverImg">
                    <img id="cover" src="../image/default_img.png"/>
                    <div class="cover-select">封面</div>
                </div>
                <%--<div class="muisic-botton">设置音乐</div>--%>
                <div class="item-content">
                    <%--<div class="item">
                        <div class="itemInnerWrapper">
                            <textarea rows="2" maxlength="180" placeholder="添加文字描述"></textarea>
                            <img class="img" src="../images/jiatingriji@2x.png"/>
                            <button class="removeItem"><span class="mui-icon mui-icon-closeempty"></span> </button>
                        </div>
                    </div>--%>
                </div>
                <div class="add-content">
                    <button class="item-add" type="button"><span class="mui-icon mui-icon-plusempty"></span></button>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="mui-backdrop">
    <div class="item-wrapper">
        <div class="loaditem" id="load">
            <div class="ball">
                <div></div>
                <div></div>
            </div>
            <div id="txt" style="margin-top: 10px;">loading...</div>
        </div>
    </div>
</div>
<!--图片替换页面-->
<div id="replaceImg" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
        <a class="mui-btn mui-btn-link mui-pull-right" id = "replaceconfirm">确定</a>
        <h1 class="mui-center mui-title">替换图片</h1>
    </div>
    <div class="mui-page-content" style="background-color: #ECECEC">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll">
                <%--替换图片详情--%>
                <div style="padding: 2%">
                    <div class="replacepic">
                        <div class="describe">
                            <textarea placeholder="请填写描述" width="100%" rows="6" maxlength="200" style="margin-bottom: 0;vertical-align: middle;border:0px;padding: 0px;height: 100%;"></textarea>
                        </div>
                        <div class="waitpic">
                            <img >
                        </div>
                    </div>
                </div>
                <div class="click">点击更换图片</div>
                <%--图片列表--%>
                <div class="piclist">
                    <%--<div class="listitem">
                        <img src="../images/tkx/peiban.png">
                    </div>
                    <div class="listitem">
                        <img src="../images/tkx/peiban.png">
                    </div>
                    <div class="listitem">
                        <img src="../images/tkx/peiban.png">
                    </div>
                    <div class="listitem">
                        <img src="../images/tkx/peiban.png">
                    </div>
                    <div class="listitem">
                        <img src="../images/tkx/title.png">
                    </div>--%>
                </div>
                <%--手机相册按钮--%>
                <div class="phoneclick">
                    手机相册<div class="mui-icon mui-icon-arrowup"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--多选图片页面-->
<div id="multipleImg" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
        <a class="mui-btn mui-btn-link mui-pull-right" id="confirm">确定</a>
        <h1 class="mui-center mui-title">图片选择列表</h1>
    </div>
    <div class="mui-page-content" style="background-color: #ECECEC">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll">
                <%--图片列表--%>
                <div class="mulpiclist">
                    <%--<div class="mullistitem">
                        <img src="../images/tkx/peiban.png">
                        <div class="mui-checkbox" style="position: absolute;top: -6px;right: -22px;">
                            <input name="checkbox" data-value="item1" type="checkbox" >
                        </div>
                    </div>--%>
                </div>
                <div class="fromPhoneSelect"><p>从手机中选择</p></div>
            </div>
        </div>
    </div>
</div>
<%--音乐选择页面--%>
<div id="music" class="mui-page">
    <div class="mui-navbar-inner mui-bar mui-bar-nav" style="box-shadow: 0 1px 3px rgb(170, 165, 165),0 4px 9px rgb(170, 165, 165);
         -webkit-box-shadow: 0 1px 3px rgb(170, 165, 165),0 4px 9px rgb(170, 165, 165);
         -moz-box-shadow: 0 1px 3px rgb(170, 165, 165),0 4px 9px rgb(170, 165, 165);">
        <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
        <a class="mui-btn mui-btn-link mui-pull-right" href="#coverChoose">确定</a>
        <h1 class="mui-center mui-title">设置音乐</h1>
    </div>
    <div class="mui-page-content" style="background-color: #ECECEC">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll">
                <ul id="musicList" class="mui-table-view">
                    <li class="mui-table-view-cell">
                        <a data-music="">无音乐</a>
                    </li>
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
<audio id="audio" style="opacity:0" loop hidden="hidden"></audio>
</body>
<script src="<%=basePath%>js/mui.zoom.js"></script>
<script src="<%=basePath%>js/mui.previewimage1.js"></script>
<script>
    /**
     *
     */
    var uploadimg_I=0;
    function ImgObj(id, type, src, targetId,des) {
        this.id = id;
        //type(user:用户手机选择 ,order:订单图片,Service:已上传至服务器)
        this.type = type;
        this.src = src;
        /*当type等于user时,targetid为上传至微信服务器的serviceid
         * 当type等于order是,targetid为订单图片的编号
         * 当type等于Service时,targetid为影集图片的编号
         * */
        this.targetId = targetId;
        this.des=des;
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
            if (this.type == "user" && this.targetId == null) {
                wx.uploadImage({
                    localId: that.src, // 需要上传的图片的本地ID，由chooseImage接口获得
                    isShowProgressTips: 0, // 默认为1，显示进度提示
                    success: function (res) {
                        var serverId = res.serverId; // 返回图片的服务器端ID
                        that.targetId = serverId;
                        that.uploadState = true;
                        $("#" + that.id).attr("data-target", that.toString());
                        var items = $(".item-content .item");
                        for(var i = 0;i<items.length;i++){
                            if(i!==uploadimg_I&&$(items[i]).find(".img").attr("src")==that.src){
                                var obj= JSON.parse($(items[i]).attr("data-target"));
                                obj.targetId = serverId;
                                obj.uploadState = true;
                                $(items[i]).attr("data-target",JSON.stringify(obj));
                            }
                        }
                        uploadimg_I++;
                        uploadImg(uploadimg_I)
                    },
                    fail:function (res) {
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
            var str = "<div class=\"item\" id=\""+this.id+"\" data-target=" + this.toString() + ">"+
                    "<div class=\"itemInnerWrapper\">";
            str+=("<div class='img-warp'><img class=\"img\" src=\""+this.src+"\"/></div><button class=\"removeItem\"><span class=\"mui-icon mui-icon-closeempty\"></span> </button>");
            if(this.des!=null) {
                str+="<textarea rows=\"2\" maxlength=\"180\" placeholder=\"添加文字描述\">"+this.des+"</textarea>";
            }else{
                str+="<textarea rows=\"2\" maxlength=\"180\" placeholder=\"添加文字描述\"></textarea>";
            }
            str+="</div></div>";
            return str;
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
        prop._init = function () {
            /* container.empty(".quater");
             for (var i = 0; i < prop.imglist.length; i++) {
             var imgitem = $(imglist[i].toHTML());
             $(".item-content").append(imgitem);
             imgitem.find(".img").on("load", function (e) {
             var $this = $(e.target);
             if ($this.width() < $this.height()) {
             $this.css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
             } else {
             $this.css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
             }
             });
             }*/
        };
        /**
         * 添加一张图片
         * @param type 图片类型 user（用户手机选择） order(订单图片)
         * @param src 图片url路径
         * @param targetId type为user时为上传至微信的图片servid ,type为order时为图片id
         * */
        prop.addImg = function (type, src, targetId,des) {
            var obj = new ImgObj(this.uuid(), type, src, targetId,des);
            var imgitem = $(obj.toHTML());
            $(".item-content").append(imgitem);
            imgitem.find(".img").on("load", function (e) {
                var $this = $(e.target);
                if ($this.width() < $this.height()) {
                    $this.css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
                    $this.css({"margin-top": "-" + ($this.height() - $this.width()) / 2,"margin-left": "0px"});
                } else {
                    $this.css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
                    $this.css({"margin-left": "-" + ($this.width() - $this.height()) / 2,"margin-top": "0px"});
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
            /*            var imgitem = $("<div class=\"quarter\">" + obj.toHTML() + "</div>");
             container.prepend(imgitem);
             imgitem.css("height", imgitem.width() + "px");
             imgitem.children("img").on("load", function (e) {
             var $this = $(e.target);
             if ($this.width() < $this.height()) {
             $this.css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
             } else {
             $this.css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
             }
             });*/
        };
        /**
         * 通过id删除img
         * */
        prop.deleteImg = function (id) {
            $("#" + id).remove();
        };
        /**
         * 将指定id的img移到第一位
         * */
        prop.moveToFirst = function (id) {
            /*            var data = JSON.parse($("#" + id).attr("data-target"));
             var imgObj;
             if (data.targetId) {
             imgObj = new ImgObj(data.id, data.type, data.src, data.targetId);
             } else {
             imgObj = new ImgObj(data.id, data.type, data.src, null);
             }

             console.log(imgObj);
             this.deleteImg(id);
             this.unshift(imgObj)*/
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
            var imgs = $(".item-content .item");
            for (var i = 0; i < imgs.length; i++) {
                var obj=JSON.parse($(imgs[i]).attr("data-target"));
                var text=$(imgs[i]).find("textarea").val();
                if(text!=null&&text!=undefined&&text!=""){
                    obj.des=text;
                }
                $(imgs[i]).attr("data-target",JSON.stringify(obj));
                arry.push(obj);
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
</script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="../js/getParam.js"></script>
<script>
    var id = "${id}";
    var orderid = "${orderid}";
    //var id = "297e9e795980e376015981044554000a";
    //var orderid = '297e9e7958fbf8fc0158fc479868000b';
    var coverfncbtn = ["添加图片", "保存修改"];
    var defaultvalueArray = ["添加标题", "添加文字描述"];
    var wxready=true,jqueryready=false;
    var yingji = $.yingji();
    var MaxImageNum=20;
    var replacedImg=null;
    var audio=document.getElementById("audio");
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
    (function (mui) {
        //处理view的后退与webview后退
        var oldBack = mui.back;
        mui.back = function () {
            if (viewApi.canBack()) { //如果view可以后退，则执行view的后退
                viewApi.back();
            } else { //执行webview后退
                oldBack();
            }
        };
        //监听页面切换事件方案1,通过view元素监听所有页面切换事件，目前提供pageBeforeShow|pageShow|pageBeforeBack|pageBack四种事件(before事件为动画开始前触发)
        //第一个参数为事件名称，第二个参数为事件回调，其中e.detail.page为当前页面的html对象
        view.addEventListener('pageBeforeShow', function (e) {
            if(e.detail.page.id=="music"){
                audio.src = $("#musicList>li.mui-table-view-cell>a.selected").attr("data-music");
                audio.play();
            }
        });
        view.addEventListener('pageShow', function (e) {
            var pageId = e.detail.page.id;
            if(e.detail.page.id!="music"){
                audio.pause();
            }
            if(e.detail.page.id=="multipleImg"){
                //设置下一页“图片选择列表”图片居中显示
                if(mullistitemMark == 0) {
                    var $this = $(".mullistitem").find("img");
                    //console.log($this);
                    for(var i=0;i<$this.length;i++)
                    {
                        if ($this[i].naturalWidth <= $this[i].naturalHeight) {
                            $($this[i]).css({"margin-top": "-" + ($this[i].height - $this[i].width) / 2,"margin-left": "0px"});
                        } else {
                            $($this[i]).css({"margin-left": "-" + ($this[i].width - $this[i].height) / 2,"margin-top": "0px"});
                        }
                    }
                    $this.trigger("load");
                    mullistitemMark++;
                }
            }
            if(e.detail.page.id=="coverChoose") {
                reSizeCoverChooseImg();
                //设置下一页“设置影集”图片居中显示
                /*var $this = $(".itemInnerWrapper").find(".img");
                 console.log($this);
                 for (var i = 0; i < $this.length; i++) {
                 if ($this[i].naturalWidth <= $this[i].naturalHeight) {
                 $($this[i]).css({"width": "100%","height": "auto"});
                 $($this[i]).css({"margin-top": "-" + ($($this[i]).height() - $($this[i]).width()) / 2,"margin-left": "0px"});
                 } else {
                 $($this[i]).css({"height": "100%","width": "auto"});
                 $($this[i]).css({"margin-left": "-" + ($($this[i]).width() - $($this[i]).height()) / 2,"margin-top": "0px"});
                 }
                 }*/
            }
            if(e.detail.page.id=="replaceImg"){
                //设置下一页“图片替换列表”图片居中显示
                if(replaceListMark == 0) {
                    //待替换图片
                    /*var $this = $(".waitpic").find("img");
                     //console.log($this);
                     for(var i=0;i<$this.length;i++)
                     {
                     if ($this[i].naturalWidth <= $this[i].naturalHeight) {
                     $($this[i]).css({"margin-top": "-" + ($this[i].height - $this[i].width) / 2,"margin-left": "0px"});
                     } else {
                     $($this[i]).css({"margin-left": "-" + ($this[i].width - $this[i].height) / 2,"margin-top": "0px"});
                     }
                     }*/
                    $(".waitpic").children("img").trigger("load");
                    //可替换列表图片
                    var $this = $(".listitem").find("img");
                    //console.log($this);
                    for(var i=0;i<$this.length;i++)
                    {
                        if ($this[i].naturalWidth <= $this[i].naturalHeight) {
                            $($this[i]).css({"margin-top": "-" + ($this[i].height - $this[i].width) / 2,"margin-left": "0px"});
                        } else {
                            $($this[i]).css({"margin-left": "-" + ($this[i].width - $this[i].height) / 2,"margin-top": "0px"});
                        }
                    }
                    $this.trigger("load");
                    replaceListMark++;
                }
            }
        });
        view.addEventListener('pageBeforeBack', function (e) {
        });
        view.addEventListener('pageBack', function (e) {
        });
    })(mui);
    wx.config({
        debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
        appId: '${appId}', // 必填，公众号的唯一标识
        timestamp: '${timestamp}', // 必填，生成签名的时间戳
        nonceStr: '${nonceStr}', // 必填，生成签名的随机串
        signature: '${signature}',// 必填，签名，见附录1
        jsApiList: ['getLocation', 'downloadImage', 'onMenuShareTimeline', 'onMenuShareAppMessage', 'hideMenuItems', 'chooseImage', 'uploadImage'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });
    wx.ready(function () {
        wxready=true;
        if(jqueryready){
            $(".mui-backdrop").hide();
            pageReady();
        }
    });
    //封面加载事件
    $("#cover").on("load",function(e){
        var width = $(this).parent().width();
        var height = $(this).parent().height();
        if(width/height>=$(this).width()/$(this).height()){
            $(this).css({width:"100%",height:"auto"});
            $(this).css({"margin-top":(height-$(this).height())/2+"px"});
            $(this).css({"margin-left":0+"px"});
        }else{
            $(this).css({height:"100%",width:"auto"});
            $(this).css({"margin-top":0+"px"});
            $(this).css({"margin-left":(width-$(this).width())/2+"px"});
        }
    }).on("tap",function(e){
        coverselect();
    });
    //点击从手机中添加图片
    $(".fromPhoneSelect").on("tap click",function (e) {
        chooseWxImage();
    })
    //组件触发事件
    $(".item-content").on("tap",".removeItem",function(e){
        $(e.target).parents(".item").remove();
        e.preventDefault();
        e.stopPropagation();
    }).on("tap",".img",function(e){
        var obj = JSON.parse($(e.target).parents(".item").attr("data-target"));
        var des = $(e.target).parents(".item").find("textarea").val();
        if(des!=null){
            obj.des = des;
        }
        if(orderid!=null&&orderid!=""){
            //跳转到替换图片页面
            $(".replacepic").attr("data-target",JSON.stringify(obj));
            $(".replacepic").find("textarea").val(obj.des);
            $(".replacepic").find("img").attr("src",obj.src);
            viewApi.go("#replaceImg");
        }else{
            replaceImg(obj);
        }
        e.preventDefault();
        e.stopPropagation();
    });
    //添加按钮触发事件
    $(".item-add").on("tap",function (e) {
        if(orderid!=null&&orderid!=""){
            chooseOrderImg();
        }else{
            chooseWxImage();
        }
    });
    //音乐设置音乐按钮触发事件
    $(".muisic-botton").on("tap",function(e){
        viewApi.go("#music");
    });
    //音乐选项触发事件
    $("#musicList>li.mui-table-view-cell>a").on("tap",function(){
        $("#musicList>li.mui-table-view-cell>a").removeClass("selected");
        $(this).addClass("selected");
        audio.src = $("#musicList>li.mui-table-view-cell>a.selected").attr("data-music");
        if(currentPage()=="music")
            audio.play();
    });
    //音乐选择页面“确定”
    $("#music-cnfirm").on("tap",function(e){
        audio.pause();
    });
    //完成影集触发
    $("#finish").on("tap",function(e){
        var imgsrc = $("#cover").attr("src");
        if(imgsrc==undefined||imgsrc==null||imgsrc==""||imgsrc.indexOf("/image/default_img.png")>=0){
            mui.toast("请选择封面图片！");
        }else if(yingji.getImgList()==0){
            mui.toast("请添加图片！");
        }else if($(".title input").val()==null||$(".title input").val()==""){
            mui.toast("请填写标题！");
        }
        else {
            $(".mui-backdrop").show();
            $("#txt").text("处理中请稍后...");
            var yingjiList = yingji.getImgList();
            for (var i=0;i < yingjiList.length;i++) {
                var obj=yingjiList[i];
                var coverobj = JSON.parse($("#cover").attr("data-cover"));
                if(obj.src==coverobj.src){
                    obj.targetId=coverobj.targetId;
                    obj.uploadState=true;
                    $("#"+obj.id).attr("data-target",JSON.stringify(obj));
                    obj=yingji.getImgList()[i];
                }
            }
            uploadImg(uploadimg_I)
        }
    });
    //替换页面从相册替换
    $(".piclist").on('tap','.listitem img',function (e) {
        $(".waitpic").find('img').attr("src",e.target.src);
        $(".waitpic").find('img').css({"width":e.target.width,"height":e.target.height,"margin-top":e.target.marginTop,"margin-left":e.target.marginLeft});
        var obj = JSON.parse($(".replacepic").attr("data-target"));
        obj.type="order";
        obj.targetId=$(e.target).attr("data-id");
        obj.uploadState=false;
        obj.src=e.target.src;
        $(".replacepic").attr("data-target",JSON.stringify(obj));
    });
    //图片替换页面“确定”
    $("#replaceconfirm").on('tap',function () {
        var obj = JSON.parse($(".replacepic").attr("data-target"));
        var des = $(".describe").find("textarea").val();
        obj.des=des;
        $("#"+obj.id).find("textarea").val(des);
        $("#"+obj.id).find(".img").attr("src",obj.src);
        $("#"+obj.id).attr("data-target",JSON.stringify(obj));
        viewApi.go("#coverChoose");
    });
    //替换页面从手机替换
    $(".phoneclick").on('tap',function () {
        replaceImgpage();
    });
    //图片替换页面待替换图片居中显示
    $(".waitpic").children("img").on("load", function (e) {
        $(e.target).css({"margin-top":0,"margin-left":0});
        if (e.target.naturalWidth <= e.target.naturalHeight) {
            $(e.target).css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
            $(e.target).css({"margin-top": "-" + ($(e.target).height() - $(e.target).width()) / 2,"margin-left": "0px"});
        } else {
            $(e.target).css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
            $(e.target).css({"margin-left": "-" + ($(e.target).width() - $(e.target).height()) / 2,"margin-top": "0px"});
        }
    });
    //多选页面确定完成点击事件
    $("#confirm").on('tap',function () {
        // var $imglist = $(".mulpiclist").find("img");
        var $checkedlist = $(".mulpiclist").find("input:checked");
        var length = yingji.getImgList().length;
        for (var i = 0; i < $checkedlist.length; i++) {
            var $img =  $($checkedlist[i]).parents(".mullistitem").find("img");
            yingji.addImg("order", $img[0].currentSrc,$img[0].id);
            /*console.log($checkedlist[i]);
             console.log($checkedlist[i].checked);*/
            $checkedlist[i].checked = false;
            if(length+i==MaxImageNum){
                mui.toast("最多可以添加20张图片");
                break;
            }
        }
        viewApi.go("#coverChoose");
    });
    $(function(){
        jqueryready=true;
        if(wxready){
            $(".mui-backdrop").hide();
            pageReady();
        }
        if($("#cover").height()!==0){
            $("#cover").trigger("load");
        }
    });
    /**
     * 初始化页面
     */
    function pageReady(){
        if(id!=null&&id!=''){
            loadYingjiDat();
        }else if(orderid!=null&&orderid!="") {
            getIndexData();
        }
//        }else {
//            chooseWxImage();
//        }
    }
    /**
     * 加载影集原数据
     */
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
                        yingji.addImg("service", imgpre + (JSON.parse(yingjidata.tlkYingjipicEntities[i].itemImgurl))[0].path, yingjidata.tlkYingjipicEntities[i].id,yingjidata.tlkYingjipicEntities[i].itemDescription);
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
                    //初始化封面图片
                    if(yingjidata.itemCover!=undefined&&yingjidata.itemCover!=null){
                        var dataO = {"type":"service","src":imgpre+JSON.parse(yingjidata.itemCover)[0].path,"targetId":yingjidata.itemCover};
                        $("#cover").attr("src",imgpre+JSON.parse(yingjidata.itemCover)[0].path).attr("data-cover",JSON.stringify(dataO));
                    }else{
                        var dataO = {"type":"service","src":imgpre+JSON.parse(yingjidata.tlkYingjipicEntities[0].itemImgurl)[0].path,"targetId":yingjidata.tlkYingjipicEntities[0].itemImgurl};
                        $("#cover").attr("src",imgpre+JSON.parse(yingjidata.tlkYingjipicEntities[0].itemImgurl)[0].path).attr("data-cover",JSON.stringify(dataO));
                    }
                } else {
                    mui.toast("加载数据失败!");
                    history.go(-1);
                }
            }
        })
    }
    /**
     * 通过微信接口选择图片
     */
    function chooseWxImage(){
        wx.chooseImage({
            count: 9, // 默认9
            sizeType: ['compressed'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function (res) {
                var length = yingji.getImgList().length;
                if(res.localIds.length>0&&length<=MaxImageNum){
                    for (var i = 0; i < res.localIds.length; i++) {
                        yingji.addImg("user", res.localIds[i], null);
                        if(length+i==MaxImageNum){
                            mui.toast("最多可以添加20张图片");
                            break;
                        }
                    }
                    if(currentPage()!="coverChoose"){
                        viewApi.go("#coverChoose");
                    }
                }else if(res.localIds.length<=0){
                    chooseWxImageNull()
                }else if(yingji.getImgList().length>MaxImageNum){
                    mui.toast("最多可以添加20张图片");
                }
                reSizeCoverChooseImg();
            },
            cancel: function () {
            }
        });
    }
    /**
     * 选择订单图片
     */
    function chooseOrderImg(){
        viewApi.go("#multipleImg");
    }
    /**
     * 没有选择任何图片
     */
    function chooseWxImageNull(){
        if(yingji.getImgList().length>0){
            return;
        }else if(orderid==""){
            mui.alert("还未选择图片请重新添加","添加图片失败","确定");
        }
    }
    /**
     * 自动转换列表为正方形并居中显示
     */
    //替换图片页面待替换图片
    /*changeImg("waitpic");*/
    //替换图片页面列表
    /*changeImg("listitem");*/
    //调用初始化选片页面方法
    /*    if (orderid != '') {
     getIndexData();
     }*/
    /**
     * 初始化选片页面(多选页面)和替换页面
     */
    function getIndexData() {
        $.getJSON("../userPort/getOrderInfoById?id=" + orderid, function (data) {
            $("#loadd").hide();
            if (data.orderproductimgEntities.length == 0) {
                var paths = "<div style='text-align: center;margin-top: 20%;'>暂无图片</div>";
                $('.mulpiclist').append(paths);
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
                var paths = $("<div class='mullistitem'><img id ='" + pics[i].id + "' src='" + imgpre + pa[0].path + "'  data-preview-src='" + imgpre + tp[0].path + "' data-preview-group='1'>\
                    <div class='mui-checkbox' style='position: absolute;top: -6px;right: -22px;'>\
                    <input name='checkbox' type='checkbox' >\
                    </div></div>");
                $(".mulpiclist").append(paths);

                //图片替换页面加载
                var pa = pics[i].itemImgurl;
                pa = JSON.parse(pa);
                var html = $("<div class='listitem'>\
                <img data-id ='" + pics[i].id + "' src='" + imgpre + pa[0].path + "'></div>");
                $(".piclist").append(html);
            }
            //多选页面样式控制
            $(".mullistitem").css("height",$(window).width()*0.96*0.25+"px");
            $(".mullistitem").children("img").on("load", function (e) {
                if (e.target.naturalWidth<=e.target.naturalHeight) {
                    $(e.target).css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
                    /*$(e.target).css({"margin-top":"-" + ($(e.target).height() - $(e.target).width()) / 2});*/
                } else {
                    $(e.target).css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
                    /*$(e.target).css({"margin-left": "-" + ($(e.target).width() - $(e.target).height()) / 2});*/
                }
            });
            //替换页面待替换图片样式控制
            $(".waitpic").css("height",$(".waitpic").width()+"px");
            //替换页面列表样式控制
            $(".listitem").css("height",$(window).width()*0.96*0.25+"px");
            $(".listitem").children("img").on("load", function (e) {
                if (e.target.naturalWidth<=e.target.naturalHeight) {
                    $(e.target).css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
                    /*$(e.target).css({"margin-top":"-" + ($(e.target).height() - $(e.target).width()) / 2});*/
                } else {
                    $(e.target).css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
                    /*$(e.target).css({"margin-left": "-" + ($(e.target).width() - $(e.target).height()) / 2});*/
                }
            });
            mui.previewImage({header: '<span id="mHeader"></span>'});
            $("#mHeader").on("tap", function (e) {
                if ($(this).attr("data-index")) {
                    var index = parseInt($(this).attr("data-index"));
                    var index = parseInt($(this).attr("data-index"));
                    var $target = $($(".mullistitem").get(index)).find("input");
                    //console.log($target);
                    if($target[0].checked){
                        $target[0].checked=false;
                    }else{
                        $target[0].checked=true;
                    }
                    initImgViewer(index);
                }
                e.stopPropagation();
            });
        });
    }
    //放大时滑动切换触发
    function perimgChanged(index) {
        $("#mHeader").attr("data-index", index);
        initImgViewer(index);
    }
    //列表中点击图片触发
    function initImgViewer(index) {
        var $target = $($(".mullistitem").get(index)).find("input");
        if($target[0].checked){
            $("#mHeader").addClass("selected");
        }else{
            $("#mHeader").removeClass("selected");
        }
    }
    /**
     * 选择封面
     */
    function coverselect(){
        wx.chooseImage({
            count: 1, // 默认9
            sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function (res) {
                if(res.localIds.length>=1){
                    $("#cover").attr("src",res.localIds[0]).attr("data-cover",JSON.stringify({type:"user",src:res.localIds[0]}));
                    uploadCover();
                }
            }
        });
    }
    /**
     * 替换图片
     * @param object
     */
    function replaceImg(object){
        wx.chooseImage({
            count: 1, // 默认9
            sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function (res) {
                $("#"+object.id).find(".img").attr("src",res.localIds[0]);
                object.src=res.localIds[0];
                object.type = "user";
                object.targetId=null;
                object.uploadState = false;
                var text = $("#"+object.id).find("textarea").val();
                if(text!=null&&text!=""){
                    object.des=$("#"+object.id).find("textarea").val();
                }
                $("#"+object.id).attr("data-target",JSON.stringify(object));
            },
            cancel: function () {
            }
        });
    }
    /**
     * 替换页面替换图片
     * @param object
     */
    function replaceImgpage(){
        wx.chooseImage({
            count: 1, // 默认9
            sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function (res) {
                $(".waitpic").find('img').attr("src",res.localIds[0]);
                var obj = JSON.parse($(".replacepic").attr("data-target"));
                obj.type="user";
                obj.targetId=null;
                obj.uploadState=false;
                obj.src=res.localIds[0];
                $(".replacepic").attr("data-target",JSON.stringify(obj));
            },
            cancel: function () {
            }
        });
    }
    function currentPage(){
        return $(".mui-page.mui-page-center").attr("id");
    }
    /**
     * 设置coverChoose页面图片大小
     */
    function reSizeCoverChooseImg(){
        $(".itemInnerWrapper").find(".img").on("load", function (e) {
            console.log(e.target);
            console.log("111");
            console.log($(e.target));
            console.log("2222");
            if (e.target.naturalWidth<=e.target.naturalHeight) {
                $(e.target).css({"width": "100%","height": "auto"});
                console.log("宽小");
                $(e.target).css({"margin-top": "-" + ($(e.target).height() - $(e.target).width()) / 2,"margin-left": "0px"});
                console.log("宽小居中");
            } else {
                $(e.target).css({"height": "100%","width": "auto"});
                console.log("高小");
                $(e.target).css({"margin-left": "-" + ($(e.target).width() - $(e.target).height()) / 2,"margin-top": "0px"});
                console.log("高小居中");
            }
        })
    }
    /**
     * 上传封面
     * */
    function uploadCover(){
        var coverData = JSON.parse($("#cover").attr("data-cover"));
        if(coverData.type=="user"){
            wx.uploadImage({
                localId: coverData.src, // 需要上传的图片的本地ID，由chooseImage接口获得
                isShowProgressTips: 1, // 默认为1，显示进度提示
                success: function (res) {
                    var serverId = res.serverId; // 返回图片的服务器端ID
                    $("#cover").attr("data-cover",JSON.stringify({type:"user",src:coverData.src,targetId:serverId}));
                }
            });
        }else{
            $("#cover").attr("data-cover",JSON.stringify({type:"user",src:coverData.src,targetId:coverData.src}));
        }
    }
    /**
     * 上传图片
     * */
    function uploadImg(i) {
        var list = yingji.getImgList();
        if (i < list.length) {
            var obj=list[i];
            new ImgObj(obj.id,obj.type, obj.src, obj.targetId).uploadImg();
        }else{
            uploadYingji();
        }
    }
    /**
     * 上传数据
     */
    function uploadYingji(){
        var data ;
        var music = $("#musicList>li.mui-table-view-cell>a.selected").attr("data-music");
            data = {
                title: $(".title input").val(),
//                music: $("#musicList>li.mui-table-view-cell>a.selected").attr("data-music"),
                cover: JSON.parse($("#cover").attr("data-cover")),
                Yingjipics: yingji.getImgList()

        }
        var xhr = new XMLHttpRequest();
        xhr.open("post", "../sysPort/savezuopin", true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                if (xhr.status >= 200 && xhr.status < 400) {
                    $(".mui-backdrop").find("#txt").text("数据处理完成..");
                    var o = JSON.parse(xhr.responseText);
                    if (o.errorCode == 400) {
                        $(".mui-backdrop").hide();
                        mui.toast("您太长时间未操作,请刷新页面");
                    } else if (o.errorCode == 200) {
                        mui.toast("作品创建成功!");
                        setTimeout(function () {
                            window.location.href = "../photographer/zuoping_list.html?id=" + id;
                        }, 2000);
                    }
                    uploadimg_I=0;
                } else {
                    $(".mui-backdrop").hide();
                    mui.toast("网络错误,保存失败");
                    uploadimg_I=0;
                }
            }
        };
        xhr.send(JSON.stringify(data));
    }
    /**
     * 全局变量
     */
    //跳转时更改图片居中样式
    var mullistitemMark = 0;//用于执行一次居中显示
    var replaceListMark = 0;
</script>
</html>