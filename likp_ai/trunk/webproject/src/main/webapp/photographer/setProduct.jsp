<%--


  Date: 2017/1/15
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
    <title>产品设置</title>
    <link type="text/css" rel="stylesheet" href="../css/mui.min.css"/>
    <style>
        html,
        body {
            background-color: #FFF;
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
            background-color: #FFF;
        }

        .mui-pages {
            top: 44px;
            height: auto;
        }

        .mui-scroll-wrapper,
        .mui-scroll {
            background-color:  #FFF;
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
        }

        .mui-navbar .mui-bar {
            position: absolute;
            background: transparent;
            text-align: center;
            background-color:#FFF;
        }

        .mui-android .mui-navbar-inner.mui-navbar-left {
            opacity: 0;
        }

        .mui-ios .mui-navbar-left .mui-left,
        .mui-ios .mui-navbar-left .mui-center,
        .mui-ios .mui-navbar-left .mui-right {
            opacity: 0;
        }
        .mui-content{
            background-color: #FFF;
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
            color: #000;
            font-size: 15px;
        }
        .mui-bar .mui-btn-link,.mui-bar .mui-action-back{
            color: #000;
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
        .input{
            position: relative;
            height: inherit;

        }
        .input:after{
            content: '';
            display: block;
            position:absolute;
            bottom: 0;
            border: 0;
            margin: 0;
            padding: 0;
            right:0;
            width: 70%;
            background: rgba(0,0,0,0.1);
        }
        .input >label,.input>input,.input>.input-group,.input>select{
            display: inline-block;
            margin: 0 -2px 0 -1px;
        }
        .input >label{
            width: 24%;
            text-align: right;
            font-size: 16px;
        }
        .input>input,.input>select,.input>.input-group{
            width:75.8%;
            border: 0;
        }
        .input>input.text-right,.input>select,.input>.input-group.text-right{
            text-align: right;
        }
        .input-group{
            position: relative;
            background-color: #fff;
            clear: both;
        }
        .input-group>select,.input-group>.select{
            font-family: microsoft Yahei Light;
            padding: 9px;
            font-size: 17px;
            text-align: center;
            margin-bottom: 0;
        }
        .input-group>.select{
            font-family: Muiicons,Microsoft YaHei Light;
            width:100%;
            background-color: inherit;
            text-align: right;
            padding-right: 10%;
        }
        .input-group>.select:after{
            content:'\e583';
            display:block;
            position: absolute;
            right:0;
            top: 0;
            font-size: 17px;
            padding: 9px;
        }
        .input-group>select{
            top: 0;
            position: absolute;
            width: 100%;
            left: 0;
            background-color: transparent;
            opacity: 0;
        }
        .imgbutton{
            width: 100%;
            overflow-y: hidden;
            border:0;
            padding: 0;
        }
        .next{
            color: #000;
            background-color:#ffe33e;
            margin-top: 15px;
        }
        .input-group>input{
            margin:0;
            padding: 6px;
            width: 45px;
            border:0;
            text-align: center;
        }
        .input-group>button{

        }
        .input-sub,.input-add{
            border-radius: 100%;
            padding: 0!important;
            width: 23px;
            height: 23px;
            margin-top: 10px;
        }
        .self-define-group{
            position: relative;
            width: 100%;
        }
        .self-define-group:after{
            content: '';
            display: block;
            clear: both;
        }
        .self-define-group>.self-define-group-key,.self-define-group>.self-define-group-value{
            display: inline-block;
            float: left;
            margin: 0;
            text-align: center;
            border: 0;
        }
        .self-define-group-item{
            position: relative;
        }
        .self-define-group>.self-define-group-item:after{
            content: "";
            display: block;
            bottom:0;
            width: 80%;
            background-color: rgba(0,0,0,0.1);
            height: 0px;
            margin: 0 auto;
        }
        .self-define-group>.self-define-group-item.self-define-group-value:after{
            width: 100%;
        }
        .self-define-group>.self-define-group-item>input{
            margin: 0;
            border-radius: 0;
            border:0;
            text-align: right;
            font-size: 18px;
            padding-right: 10%;
        }
        .self-define-group>.self-define-group-key{
            width: 24%;
            border: 1px solid #c8ccc9;
        }
        .self-define-group>input:after{
            position: absolute;
            bottom: 0;
            content: '';
            display: block;
            width: 80%;
            height: 1px;
        }
        .self-define-group>.self-define-group-value{
            width: 76%;
            border: 1px solid #c8ccc9;
        }
        .pic-content>div.shiwuMain>img,.pic-content>div.shiwuMain{
            width:100%;
        }
        .pic-content >div.shiwuItem{
            width: 33.33333%;
            display: inline-block;
            padding: 2px;
            position: relative;
        }
        .shiwuItemImg{
            width: 100%;
            height: 100%;
            overflow: hidden;
        }
        .pic-content >div.shiwuItemMain{
            width: 33.33333%;
            display: inline-block;
            overflow: hidden;
            padding: 2px;
        }
        .pic-content >div.shiwuItem >div.shiwuItemImg>img{
            width: 100%;
        }
        .removeshiwuItem{
            position: absolute;
            top: -6px;
            left: 88%;
            padding: 0;
            border-radius: 100%;
            border: 0;
            background-color: rgba(0,0,0,0.5);
            color: #ffffff;
            z-index:1;
        }
        .removeshiwuItem>.mui-icon{
            font-size: 20px;
        }
        .coverImg>img{
            width: 100%;
        }
        .add-content{
            position: fixed;
            bottom: 0;
            width: 100%;
            text-align: center;
            z-index: 1;
        }
        .add-content .item-add{
            border:0;
            width: 100%;
            border-radius: 0;
        }
        .coverImg{
            padding: 5px;
            overflow-y: hidden;
        }
        .item-content{
            position: relative;
            padding-bottom: 44px;
        }
        .item-content>img{
            width: 100%;
        }

        .item textarea{
            display: inline-block;
            height: 80px;
            margin: 0 -2px 0 -20px;
            vertical-align: top;
        }
        .item .img{
            width: 100%;
            height: auto;
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
        .item .img-warp{
            width: 80px;
            height: 80px;
            display: inline-block;
            overflow: hidden;
        }
        .itemInnerWrapper{
            padding: 10px;
            position: relative;
            background-color: #FFF;
        }
        .removeItem{
            position: relative;
            top: -7px;
            left: -13px;
            padding: 0;
            border-radius: 100%;
            border: 0;
            background-color: rgba(0,0,0,0.5);
            color: #ffffff;
            z-index: 5000;
        }
        .removeItem>.mui-icon{
            font-size: 20px;
        }
        .itemInnerWrapper > textarea{
            padding-left: 12px;
        }
        .xiantiao {
            text-align: center;
        }

        h2 {
            font-weight: normal;
            height: 3rem;
            line-height: 3.5rem;
            font-size: 16px;
            color: #999999;
            position: relative;
        }

        h2 > font {
            display: inline-block;
            width: 25%;
            height: 0.05rem;
            background: RGB(153,153,153);
            position: relative;
            top: 1.8rem;
            vertical-align: top;
        }

        h2 > span {
            display: inline-block;
            margin: 0 auto;
            color: #000000;
            font-size: 18px;
        }
        .shiwu{
            padding: 5px 0!important;
        }
        .haveboder{
            border: 1px solid #c8ccc9;
        }
        .noboderbot{
            border-bottom: none;
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
        .self-define-group > div:nth-child(1){
            border-right: 0px;
        }
        .mui-content-padded > .productOrther:nth-child(n) > div.self-define-group>div
        ,.mui-content-padded > .cpjf:nth-child(n) > .self-define-group>div{
            border-top: 0px;
        }
        .moddile{
            text-align: center!important;
        }
    </style>
</head>
<body  class="mui-fullscreen">
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
<div id="productSetting" class="mui-page">
    <!--页面标题栏开始-->
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
        <a class="mui-btn mui-btn-link mui-pull-right save">保存</a>

        <h1 class="mui-center mui-title">产品设置</h1>
    </div>
    <!--页面标题栏结束-->
    <!--页面主内容区开始-->
    <div class="mui-page-content">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll">
                <div class="mui-content">
                        <div>
                            <button class="imgbutton">
                                <img id="coverimg" src="../image/selectproductimg.png" style="width: 100%;">
                            </button>
                        </div>
                        <div>
                            <div class="input ">
                                <label>产品名称:</label>
                                <input id="productName" type="text" placeholder="请输入产品名称">
                            </div>
                        </div>
                        <div>
                            <div class="input ">
                                <label>产品单价:</label>
                                <input id="productPrice" type="number" placeholder="请输入产品价格">
                            </div>
                        </div>
                        <div>
                            <div class="input ">
                                <label>产品描述:</label>
                                <input id="productDes"  type="text" placeholder="请输入产品描述">
                            </div>
                        </div>
                        <div style="text-align: center;padding: 100px 12px">
                            <a class="mui-btn mui-btn-link next" href="#productInfo">下一步</a>
                        </div>
                    </div>
            </div>
        </div>
    </div>
    <!--页面主内容区结束-->
</div>
<div id="productInfo" class="mui-page">
    <!--页面标题栏开始-->
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
        <a class="mui-btn mui-btn-link mui-pull-right save">保存</a>

        <h1 class="mui-center mui-title">服务详情</h1>
    </div>
    <!--页面标题栏结束-->
    <!--页面主内容区开始-->
    <div class="mui-page-content">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll">
                <div class="mui-content">
                    <div class="mui-content-padded">
                        <div class="mui-text-center" style="margin-bottom: 7px;">
                        第二步：填写产品服务详情
                        </div>
                        <div>
                            <div class="input noboderbot haveboder">
                                <label>拍摄时长:</label>
                                <div data-type="number" data-min="1" data-max="10" data-step="1" class="input-group text-right">
                                    <button class="input-sub">-</button>
                                    <input id="productTime"  type="number">
                                    <button class="input-add">+</button>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="input noboderbot haveboder">
                                <label>服&nbsp;&nbsp;&nbsp;装:</label>
                                <div class="input-group text-right">
                                    <div class="select"></div>
                                    <select id="productSute">
                                        <option>自备</option>
                                        <option>1套</option>
                                        <option>2套</option>
                                        <option>3套</option>

                                    </select>

                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="input noboderbot haveboder">
                                <label>化&nbsp;&nbsp;&nbsp;妆:</label>
                                <div class="input-group text-right">
                                    <div class="select"></div>
                                    <select id="productMakeUp">
                                        <option>不提供</option>
                                        <option>提供</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="input noboderbot haveboder">
                                <label>拍摄人数:</label>
                                <div data-type="number" data-min="1" data-max="100" data-step="1" class="input-group text-right">
                                    <button  class="input-sub">-</button>
                                    <input id="productPeople" type="number">
                                    <button class="input-add">+</button>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="input haveboder">
                                <label>拍摄场景:</label>
                                <div class="input-group text-right">
                                <div class="select"></div>
                                <select id="productSituation">
                                    <option>室内</option>
                                    <option>室外</option>
                                </select>
                                </div>
                            </div>
                        </div>


                        <div class="xiantiao"><h2>
                            <font>&nbsp;</font>&nbsp;
                            <span>自定义属性</span>
                            &nbsp;<font>&nbsp;</font>
                        </h2></div>
                        <div class="productOrther">
                            <div class="self-define-group">
                                <div class="self-define-group-item self-define-group-key noboderbot haveboder" style="border-top: 1px solid #c8ccc9;">
                                    <input type="text" placeholder="名称" class="moddile">
                                </div>
                                <div class="self-define-group-item self-define-group-value noboderbot haveboder" style="border-top: 1px solid #c8ccc9;">
                                    <input type="text" placeholder="详情">
                                </div>
                            </div>
                        </div>
                        <div class="productOrther">
                            <div class="self-define-group">
                                <div class="self-define-group-item self-define-group-key noboderbot haveboder">
                                    <input type="text" placeholder="名称" class="moddile">
                                </div>
                                <div class="self-define-group-item self-define-group-value noboderbot haveboder">
                                    <input type="text" placeholder="详情">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div style="text-align: center;padding: 6px 12px">
                        <a class="mui-btn mui-btn-link next" href="#productGive">下一步</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--页面主内容区结束-->
</div>
<div id="productGive" class="mui-page">
    <!--页面标题栏开始-->
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
        <a class="mui-btn mui-btn-link mui-pull-right save">保存</a>

        <h1 class="mui-center mui-title">成品交付</h1>
    </div>
    <!--页面标题栏结束-->
    <!--页面主内容区开始-->
    <div class="mui-page-content">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll">
                <div class="mui-content mui-content-padded">
                    <div class="mui-text-center" style="margin-bottom: 7px;">
                        第三步：填写交付内容
                    </div>
                    <div>
                        <div class="input noboderbot haveboder">
                            <label>原片数量：</label>
                            <div data-type="number" data-min="40" data-max="120" data-step="1" class="input-group text-right">
                                <button  class="input-sub">-</button>
                                <input id="orgPicNum" type="number">
                                <button class="input-add">+</button>
                            </div>
                        </div>
                    </div>
                    <div>
                        <div class="input haveboder">
                            <label>修片数量：</label>
                            <div data-type="number" data-min="10" data-max="120" data-step="1" class="input-group text-right">
                                <button  class="input-sub">-</button>
                                <input id="fixPicNum"  type="number">
                                <button class="input-add">+</button>
                            </div>
                        </div>
                    </div>

                    <div class="mui-text-center shiwu">
                        是否交付实物
                    </div>
                    <div class="pic-content">
                        <div class="shiwuMain"><img id="shiwu" src="../image/shiwu.png"/></div>
                    </div>
                    <div class="xiantiao"><h2>
                        <font>&nbsp;</font>&nbsp;
                        <span>自定义属性</span>
                        &nbsp;<font>&nbsp;</font>
                    </h2></div>
                    <div class="cpjf">
                        <div class="self-define-group">
                            <div class="self-define-group-item self-define-group-key noboderbot haveboder" style="border-top: 1px solid #c8ccc9;">
                                <input type="text" placeholder="名称" class="moddile">
                            </div>
                            <div class="self-define-group-item self-define-group-value noboderbot haveboder" style="border-top: 1px solid #c8ccc9;">
                                <input type="text" placeholder="详情">
                            </div>
                        </div>
                    </div>
                    <div class="cpjf">
                        <div class="self-define-group">
                            <div class="self-define-group-item self-define-group-key noboderbot haveboder">
                                <input type="text" placeholder="名称" class="moddile">
                            </div>
                            <div class="self-define-group-item self-define-group-value noboderbot haveboder">
                                <input type="text" placeholder="详情">
                            </div>
                        </div>
                    </div>
                    <div style="text-align: center;padding: 6px 12px">
                        <a class="mui-btn mui-btn-link next" href="#productShow">下一步</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--页面主内容区结束-->
</div>
<div id="productShow" class="mui-page">
    <!--页面标题栏开始-->
    <div class="mui-navbar-inner mui-bar mui-bar-nav">
        <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
        <a class="mui-btn mui-btn-link mui-pull-right save">保存</a>

        <h1 class="mui-center mui-title">产品展示</h1>
    </div>
    <!--页面标题栏结束-->
    <!--页面主内容区开始-->
    <div class="mui-page-content">
        <div class="mui-scroll-wrapper">
            <div class="mui-scroll">
                <div class="mui-content-padded">
                    <div>
                        <div class="input ">
                            <label>设置标题</label>
                            <input id="productShowTitle" name="title" type="text" placeholder="设置标题">
                        </div>
                    </div>
                    <div class="coverImg">
                        <img id="cover" src="../image/default_img.png"/>
                    </div>
                    <div class="item-content">
                    </div>
                </div>
            </div>
            <div class="add-content">
                <button class="item-add" type="button">
                    <span class="mui-icon mui-icon-plusempty"></span>
                    <div style="font-size: 10px;height: 12px;line-height: 12px;">最多可添加20张</div>
                </button>
            </div>
        </div>
        </div>
    </div>
</div>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/mui.min.js"></script>
<script src="../js/mui.view.js"></script>
<script src="../js/server.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script>
    var uploadimg_I=0;
    var MAXLENGTH = 20;
    var wxready = false,jqready = false;
    var id = "${id}";
    function ImgObj(id, type, src, targetId,des) {
        this.id = id;
        this.type = type;
        this.src = src;
        this.targetId = targetId;
        this.des=des;
        this.uploadState = false;
        this.uploadImg = function () {
            var that = this;
            if (this.type == "user" && this.targetId == null) {
                wx.uploadImage({
                    localId: that.src, // 需要上传的图片的本地ID，由chooseImage接口获得
                    isShowProgressTips: 0, // 默认为1，显示进度提示
                    success: function (res) {
                        var serverId = res.serverId; // 返回图片的服务器端ID
                        that.targetId = serverId;
                        that.uploadState = true;
                        var obj= JSON.parse($("#" + that.id).attr("data-target"));
                        obj.targetId = serverId;
                        obj.uploadState = true;
                        $("#" + that.id).attr("data-target",JSON.stringify(obj));
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
                str+="<textarea rows=\"2\" maxlength=\"100\" placeholder=\"添加文字描述\">"+this.des+"</textarea>";
            }else{
                str+="<textarea rows=\"2\" maxlength=\"100\" placeholder=\"添加文字描述\"></textarea>";
            }
            str+="</div></div>";
            return str;
        }
    }
    function currentPage(){
        return $(".mui-page.mui-page-center").attr("id");
    }
    var shiwuuploadImg_index = 0;
    function shiwuuploadImg(){
        $("#txt").text("正在处理实物交付图...");
        var pic = $(".pic-content img:not('#shiwu')");
        if(pic.length>shiwuuploadImg_index){
            var data = JSON.parse($(pic[shiwuuploadImg_index]).attr("data-target"))||null;
            if(data==null||data.targetId==null||data.targetId==undefined){
                wx.uploadImage({
                    localId: data.src, // 需要上传的图片的本地ID，由chooseImage接口获得
                    isShowProgressTips: 1, // 默认为1，显示进度提示
                    success: function (res) {
                        var serverId = res.serverId; // 返回图片的服务器端ID
                        data.type="user";
                        data.targetId=serverId;
                        $(pic[shiwuuploadImg_index]).attr("data-target",JSON.stringify(data));
                        ++shiwuuploadImg_index;
                        shiwuuploadImg();
                    }
                });
            }else{
                ++shiwuuploadImg_index;
                shiwuuploadImg();
            }
        }else{
            $("#txt").text("正在处理展示图片...");
            uploadImg(uploadimg_I);
        }
    }
    function uploadImg(i) {
        var list = $(".item-content .item");
        if (i < list.length) {
            var obj=JSON.parse($(list[i]).attr("data-target"));
            new ImgObj(obj.id,obj.type, obj.src, obj.targetId).uploadImg();
        }else{
            uploadData();
        }
    }
    var uuid = function () {
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
        defaultPage: '#productSetting',
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

            }
        });
        view.addEventListener('pageShow', function (e) {
            var pageId = e.detail.page.id;
            if(pageId=="productGive"){
                resize();
            }
            if(pageId=="productSetting"){
                resizeFm();
            }
            if(pageId=="productShow"){
                resizeCover();
            }
        });
        view.addEventListener('pageBeforeBack', function (e) {
        });
        view.addEventListener('pageBack', function (e) {
        });
    })(mui);
    (function($){
        var input = $(".input-group");
        var select = input.find("select");
        var number = input.find("input[type='number']");
        for(var i=0;i<select.length;i++){
            var index = select[i].selectedIndex;
            $(select[i]).prev(".select").text(select[i].options[index].text);
        }
        select.on("change",function(e){
            $(e.target).prev(".select").text($(e.target).val());
        });
        for(var i=0;i<number.length;i++){
            var p = $(number[i]).parent();
            $(number[i]).val(p.attr("data-default")||p.attr("data-min")||p.attr("data-max"))
        }
        input.on("tap","button.input-add",function(e){
            var numberinput = $(e.target).prev();
            var step = $(e.target).parent().attr("data-step")||1;
            var v = parseFloat(numberinput.val())+parseFloat(step);
            numberinput.val(v);
            numberinput.trigger("change");
        }).on("tap","button.input-sub",function(e){
            var numberinput = $(e.target).next();
            var step = $(e.target).parent().attr("data-step")||1;
            var v = parseFloat(numberinput.val())-parseFloat(step);
            numberinput.val(v);
            numberinput.trigger("change");
        });
        number.on("change",function(e){
            var input=$(e.target).parent();
            var max = input.attr("data-max")||null;
            var min = input.attr("data-min")||null;
            if(max!=null){
                if(max-$(e.target).val()<0){
                    $(e.target).val(max)
                }
            }
            if(min!=null){
                if(min-$(e.target).val()>0){
                    $(e.target).val(min);
                }
            }
        });
    })(jQuery);
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
        if(jqready){
            onloaded();
        }
    });
    $(function(){
        jqready=true;
        if(wxready){
            onloaded();
        }
    });
    $("#coverimg").on("tap",function(e) {
        wx.chooseImage({
            count:1, // 默认9
            sizeType: ['compressed'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function (res) {
                $("#coverimg").attr("src",res.localIds[0]);
                wx.uploadImage({
                    localId: res.localIds[0], // 需要上传的图片的本地ID，由chooseImage接口获得
                    isShowProgressTips: 1, // 默认为1，显示进度提示
                    success: function (res) {
                        var serverId = res.serverId; // 返回图片的服务器端ID
                        $("#coverimg").attr("data-cover",JSON.stringify({type:"user",targetId:serverId}));
                        resizeFm();
                    }
                });
            },
            cancel: function () {
            }
        });
    }).on("load",function(){
        resizeFm();
    });
    $("#shiwu").on("tap",function(){
        wx.chooseImage({
            count:9, // 默认9
            sizeType: ['compressed'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function (res) {
                for(var i=0;i<res.localIds.length;i++){
                    addSHIwuPic("user",res.localIds[i]);
                }
            },
            cancel: function () {
            }
        });
    });
    $(".pic-content").on("tap",".removeshiwuItem",function(e){
        $(e.target).parents(".shiwuItem").remove();
        if($(".shiwuItem").length == 0){
            $(".shiwuMain").removeClass("shiwuItemMain");
            $(".shiwuMain img").css({"width": "100%", "height": "auto", "margin-top": "0","margin-left": "0px"});
            $(".shiwuMain").css({"height":"auto"});
        }
    });
    $(".item-add").on("tap",function(e){
        wx.chooseImage({
            count:9, // 默认9
            sizeType: ['compressed'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function (res) {
                for(var i=0;i<res.localIds.length;i++){
                    if($(".item-content .item").length>MAXLENGTH){
                        mui.toast("最多不能超过"+MAXLENGTH+"张图片");
                        return;
                    }
                    var img = new ImgObj(uuid(),"user",res.localIds[i]);
                    addImgItem(img);
                }
            },
            cancel: function () {
            }
        });
    });
    $(".item-content").on("tap",".removeItem",function(e){
        $(e.target).parents(".item").remove();
    });
    $(".item-content").on("tap",".img",function(e){
        wx.chooseImage({
            count:1, // 默认9
            sizeType: ['compressed'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function (res) {
                e.target.src=res.localIds[0];
                var data={};
                data.id = uuid();
                data.type = "user";
                data.src = res.localIds[0];
                data.uploadState = false;
                $(e.target).parents(".item").attr("data-target",JSON.stringify(data)).attr("id",data.id);
            },
            cancel: function () {
            }
        });
    });
    $("#cover").on("tap",function(){
        wx.chooseImage({
            count:1, // 默认9
            sizeType: ['compressed'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function (res) {
                $("#cover")[0].src=res.localIds[0];
                wx.uploadImage({
                    localId: res.localIds[0], // 需要上传的图片的本地ID，由chooseImage接口获得
                    isShowProgressTips: 1, // 默认为1，显示进度提示
                    success: function (res) {
                        var serverId = res.serverId; // 返回图片的服务器端ID
                        $("#cover").attr("data-cover",JSON.stringify({type:"user",targetId:serverId}));
                        resizeCover();
                    }
                });
            },
            cancel: function () {
            }
        });
    }).on("load",function(){
        resizeCover();
    });
    $(".save").on("tap",function(){
        /*产品基本属性*/
        var productCover = $("#coverimg").attr("data-cover");
        var productName = $("#productName").val();
        var productPrice = $("#productPrice").val();
        var productDes = $("#productDes").val();
        var productTime = $("#productTime").val();
        var productSute = $("#productSute").val();
        var productMakeUp = $("#productMakeUp").val();
        var productPeople = $("#productPeople").val();
        var productSituation = $("#productSituation").val();
        var orgPicNum = $("#orgPicNum").val();
        var fixPicNum = $("#fixPicNum").val();
        /*展示基本属性*/
        var productShowTitle = $("#productShowTitle").val();
        var productShowMusic = $("#productShowMusic").val();
        var productShowCover = $("#cover").attr("data-cover");
        if(productCover==null||productCover==""){
            if(currentPage()!="productSetting")
            viewApi.go("#productSetting");
            mui.toast("请先选择产品图片");
            return;
        }
        if(productName==null||productName==""){
            if(currentPage()!="productSetting")
            viewApi.go("#productSetting");
            mui.toast("请先填写产品名称");
            return;
        }
        if(productPrice==null||productPrice==""||productPrice<=0){
            if(currentPage()!="productSetting")
            viewApi.go("#productSetting");
            mui.toast("请填写正确的产品价格");
            return;
        }
        if(productDes==null||productDes==""){
            if(currentPage()!="productSetting")
            viewApi.go("#productSetting");
            mui.toast("请先填写产品描述");
            return;
        }
        if(orgPicNum==null||orgPicNum==""){
            if(currentPage()!="productGive")
            viewApi.go("#productGive");
            mui.toast("请先填写原片数量");
            return;
        }
        if(fixPicNum==null||fixPicNum==""){
            if(currentPage()!="productGive")
            viewApi.go("#productGive");
            mui.toast("请先填写修片数量");
            return;
        }
        if(productShowCover==null||productShowCover==""){
            if(currentPage()!="productShow")
                viewApi.go("#productShow");
            mui.toast("请先选择产品展示封面图片");
            return;
        }
        if(productShowTitle==null||productShowTitle==""){
            if(currentPage()!="productShow")
            viewApi.go("#productShow");
            mui.toast("请先填写展示标题");
            return;
        }
        var item= $(".item-content .item");
        if(item.length<=0){
            if(currentPage()!="productShow")
                viewApi.go("#productShow");
            mui.toast("您还未选择作品图片");
            return;
        }
        var dataProduct={};
        dataProduct["productName"] = productName;
        dataProduct["productPrice"] = productPrice;
        dataProduct["productDes"] = productDes;
        dataProduct["productTime"] = productTime;
        dataProduct["productSute"] = productSute;
        dataProduct["productMakeUp"] = productMakeUp;
        dataProduct["productPeople"] = productPeople;
        dataProduct["productSituation"] = productSituation;
        dataProduct["orgPicNum"] = orgPicNum;
        dataProduct["fixPicNum"] = fixPicNum;
        dataProduct["productOrther"]=[];
        dataProduct["shiwu"]=[];
        dataProduct["productCover"]=productCover;
        var prodctoteher =  $("#productInfo .self-define-group");
        var productShiwu = $(".pic-content img:not('#shiwu')");
        var shiwujiaofu = $("#productGive .self-define-group");
        for(var i=0;i<prodctoteher.length;i++){
            var key = $(prodctoteher[i]).find(".self-define-group-key input").val();
            var value = $(prodctoteher[i]).find(".self-define-group-value input").val();
            if(key!=null&&key!=""){
                if(value!=null&&value!=""){
                    dataProduct["productOrther"].push({key:key,value:value});
                }else{
                    if(currentPage()!="productInfo")
                    viewApi.go("#productInfo");
                    mui.toast("您的产品自定义属性“"+key+"”没有添加值！");
                    return;
                }
            }else if(value!=null&&value!=""){
                if(currentPage()!="productInfo")
                 viewApi.go("#productInfo");
                mui.toast("您的产品自定义属性值“"+value+"”没有添加对应名称！");
                return;
            }
        }
        for(var i=0;i<shiwujiaofu.length;i++){
            var key = $(shiwujiaofu[i]).find(".self-define-group-key input").val();
            var value = $(shiwujiaofu[i]).find(".self-define-group-value input").val();
            if(key!=null&&key!=""){
                if(value!=null&&value!=""){
                    dataProduct["productOrther"].push({key:key,value:value});
                }else{
                    if(currentPage()!="productGive")
                        viewApi.go("#productGive");
                    mui.toast("您的实物交付属性“"+key+"”没有添加值！");
                    return;
                }
            }else if(value!=null&&value!=""){
                if(currentPage()!="productGive")
                    viewApi.go("#productGive");
                mui.toast("您的实物交付属性值“"+value+"”没有添加对应名称！");
                return;
            }
        }
        shiwuuploadImg_index=0;
        uploadimg_I=0;
        $(".mui-backdrop").show();
        $("#txt").text("处理中请稍后...");
        shiwuuploadImg();
    });
    function uploadData(){

        /*产品基本属性*/
        var productCover = $("#coverimg").attr("data-cover");
        var productName = $("#productName").val();
        var productPrice = $("#productPrice").val();
        var productDes = $("#productDes").val();
        var productTime = $("#productTime").val();
        var productSute = $("#productSute").val();
        var productMakeUp = $("#productMakeUp").val();
        var productPeople = $("#productPeople").val();
        var productSituation = $("#productSituation").val();
        var orgPicNum = $("#orgPicNum").val();
        var fixPicNum = $("#fixPicNum").val();
        /*展示基本属性*/
        var productShowTitle = $("#productShowTitle").val();
        var productShowMusic = $("#productShowMusic").val();
        var productShowCover = $("#cover").attr("data-cover");
        var dataProduct={};
        if($("#app").attr("data-id")){
            dataProduct["id"]=$("#app").attr("data-id");
        }
        if($("#productInfo").attr("data-id")){
            dataProduct["cpfwId"]=$("#productInfo").attr("data-id");
        }
        dataProduct["productName"] = productName;
        dataProduct["productPrice"] = productPrice;
        dataProduct["productDes"] = productDes;
        dataProduct["productTime"] = productTime;
        dataProduct["productSute"] = productSute;
        dataProduct["productMakeUp"] = productMakeUp;
        dataProduct["productPeople"] = productPeople;
        dataProduct["productSituation"] = productSituation;
        dataProduct["orgPicNum"] = orgPicNum;
        dataProduct["fixPicNum"] = fixPicNum;
        dataProduct["productOrther"]=[];
        dataProduct["shiwu"]=[];
        dataProduct["shiwujiaofu"]=[];
        dataProduct["productCover"]=JSON.parse(productCover);
        var prodctoteher =  $("#productInfo .self-define-group");
        var productShiwu = $(".pic-content img:not('#shiwu')");
        var shiwujiaofu = $("#productGive .self-define-group");
        var item= $(".item-content .item");
        for(var i = 0;i<prodctoteher.length;i++){
            var key = $(prodctoteher[i]).find(".self-define-group-key input").val();
            var value = $(prodctoteher[i]).find(".self-define-group-value input").val();
            dataProduct["productOrther"].push({key:key,value:value});
        }
        for(var i = 0;i<productShiwu.length;i++){
            dataProduct["shiwu"].push(JSON.parse(productShiwu.attr("data-target")));
        }
        for(var i = 0;i<shiwujiaofu.length;i++){
            var key = $(shiwujiaofu[i]).find(".self-define-group-key input").val();
            var value = $(shiwujiaofu[i]).find(".self-define-group-value input").val();
            dataProduct["shiwujiaofu"].push({key:key,value:value});
        }
        var productShow={};
        if($("#productShow").attr("data-id")){
            productShow["id"]=$("#productShow").attr("data-id");
        }
        productShow["productShowCover"]= JSON.parse(productShowCover);
        productShow['productShowTitle']=productShowTitle;
        productShow['productShowMusic']=productShowMusic;
        productShow['productShowItem']=[];
        for(var i=0;i<item.length;i++){
            var itemdata = JSON.parse($(item[i]).attr("data-target"));
            itemdata.des = $(item[i]).find("textarea").val();
            productShow['productShowItem'].push(itemdata);
        }
        var data={};
        data['product']=JSON.stringify(dataProduct);
        data["productShow"]=JSON.stringify(productShow);
        $.ajax({
            url:"save",
            type:"post",
            data:data,
            dataType:"json",
            timeout:10000,
            success:function(data){
                $(".mui-backdrop").hide();
                if(data.errorMsg=="success"){
                    $("#app").attr("data-id",data.msg);
                    var btnArray = ['否', '是'];
                    mui.confirm('是否立即提交审核？', '保存成功', btnArray, function (e) {
                        if (e.index == 1) {
                            updateProductState($("#app").attr("data-id"));
                            return;
                        } else {
                            window.location.href="<%=path%>/photographer/product-list.html";
                        }
                    })
                }else{
                    mui.alert("产品保存失败","系统信息","确定");
                }
            },
            error:function(){
                $(".mui-backdrop").hide();
            }
        });
    }
    function updateProductState(id){
        $.ajax({
            url:"commit",
            data:{id:id},
            type:"post",
            dataType:"json",
            tomeout:1000,
            success:function(data){
                var  result = data||null;
                if(result){
                    if(data.errorCode==200){
                        mui.alert("产品提交成功","成功","确定",function(){
                            window.location.href="<%=path%>/photographer/product-list.html";
                        });
                    }else{
                        mui.alert(data.msg,"失败","确定");
                    }
                }
            }
        });
    }
    function onloaded(){
        if(id==null||id==""){
            $(".mui-backdrop").hide();
        }else{
            $("#app").attr("data-id",id);
            loadProduct(id);
        }
    }
    function loadProduct(id){
        $.ajax({
            url:"getProduct",
            data:{id:id},
            type:"post",
            dataType:"json",
            timeout:10000,
            success:function(data){
                if(data.errorCode!="200"){
                    mui.alert(data.msg,"错误")
                }else{
                    if(data.msg.itemCover){
                        var path = JSON.parse(data.msg.itemCover);
                        $("#coverimg").attr("src",imgpre+path[0].path)
                            .attr("data-cover",JSON.stringify({type:"service",targetId:data.msg.itemCover}));
                    }
                    if(data.msg.itemName){
                        $("#productName").val(data.msg.itemName);
                    }
                    if(data.msg.itemPrice){
                        $("#productPrice").val(data.msg.itemPrice);
                    }
                    if(data.msg.itemPrice){
                        $("#productPrice").val(data.msg.itemPrice);
                    }
                    if(data.msg.tlkCpfwxqEntitys.length){
                        var cpfw = data.msg.tlkCpfwxqEntitys[0];
                        $("#productInfo").attr("data-id",cpfw.id);
                        if(cpfw.itemTime){
                            $("#productTime").val(cpfw.itemTime);
                        }
                        if(cpfw.itemDress){
                            for(var i=0;i<$("#productSute")[0].options.length;i++){
                                if($("#productSute")[0].options[i].value==cpfw.itemDress){
                                    $("#productSute")[0].options[i].selected=true;
                                    $("#productSute").trigger("change");
                                }
                            }
                        }
                        if(cpfw.itemFjtp){
                            var pics = JSON.parse(cpfw.itemFjtp);
                            for(var i=0;i<pics.length;i++){
                                addSHIwuPic("service",imgpre+pics[i].path,JSON.stringify(pics[i]));
                            }
                            resize();
                        }
                        if(cpfw.itemMakeup){
                            for(var i=0;i<$("#productMakeUp")[0].options.length;i++){
                                if($("#productMakeUp")[0].options[i].value==cpfw.itemMakeup){
                                    $("#productMakeUp")[0].options[i].selected=true;
                                    $("#productMakeUp").trigger("change");
                                }
                            }
                        }
                        if(cpfw.itemPhotonumber){
                            $("#productPeople").val(cpfw.itemPhotonumber);
                        }
                        if(cpfw.itemSection){
                            $("#productSituation").val(cpfw.itemSection);
                        }
                        if(cpfw.itemZdyxq){
                            var cpfwxq = JSON.parse(cpfw.itemZdyxq);
                            for(var i=0;i<cpfwxq.length;i++){
                                if(i<2){
                                    $($(".productOrther")[i]).find("input")[0].value=cpfwxq[i].key;
                                    $($(".productOrther")[i]).find("input")[1].value=cpfwxq[i].value;
                                }
                            }
                        }
                        if(cpfw.itemPicturenumber){
                            $("#orgPicNum").val(cpfw.itemPicturenumber);
                        }
                        if(cpfw.itemJingxiunumber){
                            $("#fixPicNum").val(cpfw.itemJingxiunumber);
                        }
                        if(cpfw.itemFjswjf){
                            var cpfwxq = JSON.parse(cpfw.itemZdyxq);
                            for(var i=0;i<cpfwxq.length;i++){
                                if(i<2){
                                    $($(".cpjf")[i]).find("input")[0].value=cpfwxq[i].key;
                                    $($(".cpjf")[i]).find("input")[1].value=cpfwxq[i].value;
                                }
                            }
                        }
                    }
                    if(data.msg.tlkProductshowEntities){
                        if(data.msg.tlkProductshowEntities.length>0){
                            var show = data.msg.tlkProductshowEntities[0];
                            $("#productShow").attr("data-id",show.id);
                            if(show.itemTitle){
                                $("#productShowTitle").val(show.itemTitle);
                            }
                            if(show.itemZpfm){
                                var cpfm = JSON.parse(show.itemZpfm);
                                $("#cover").attr("src",imgpre+cpfm[0].path)
                                    .attr("data-cover",JSON.stringify({type:"service",targetId:show.itemZpfm}));
                            }
                            if(show.tlkProductshowpicEntities){
                                for(var i=0;i<show.tlkProductshowpicEntities.length;i++){
                                    var img = new ImgObj(show.tlkProductshowpicEntities[i].id,"service",imgpre+JSON.parse(show.tlkProductshowpicEntities[i].itemPicurl)[0].path,show.tlkProductshowpicEntities[i].id,show.tlkProductshowpicEntities[i].itemDescript);
                                    addImgItem(img);
                                }
                            }
                        }
                    }
                }
                $(".mui-backdrop").hide();
            },
            error:function(data){
                mui.alert("产品数据加载失败！","错误")
            }
        });
    }
    function addImgItem(img){
        var imgitem = $(img.toHTML());
        imgitem.attr("data-target",img.toString());
        imgitem.attr("id",img.id);
        imgitem.find("img.img").on("load",function(e){
            var $this = $(e.target);
            if ($this.width() < $this.height()) {
                $this.css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
                $this.css({"margin-top": "-" + ($this.height() - $this.width()) / 2,"margin-left": "0px"});
            } else {
                $this.css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
                $this.css({"margin-left": "-" + ($this.width() - $this.height()) / 2,"margin-top": "0px"});
            }
        });
        $(".item-content").append(imgitem);
        if(imgitem.find("img.img")[0].height>0){
            $(imgitem.find("img.img")[0]).trigger("load");
        }
    }
    function addSHIwuPic(type,src,target){
        var imgDiv = $("<div class='shiwuItem'><div class='shiwuItemImg'><img></div><button class='removeshiwuItem'><span class='mui-icon mui-icon-closeempty'></span> </button></div>");
        var img = imgDiv.find("img");
        if(target){
            img.attr("src",src).attr("data-target",JSON.stringify({type:type,src:src,targetId:target}));
        }else{
            img.attr("src",src).attr("data-target",JSON.stringify({type:type,src:src}));
        }
        $(".shiwuMain").before(imgDiv);
        $(".shiwuItemImg").find("img").on("load",function(e){
            var $this = $(e.target);
            if ($this.width() < $this.height()) {
                $this.css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
                $this.css({"margin-top": "-" + ($this.height() - $this.width()) / 2,"margin-left": "0px"});
            } else {
                $this.css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
                $this.css({"margin-left": "-" + ($this.width() - $this.height()) / 2,"margin-top": "0px"});
            }
        });
        resize();
    }
    function resize(){
        var img=$(".shiwuItem img");
        $(".shiwuItem").css("height", $(".shiwuItem").width() + "px");
        if($(".pic-content .shiwuItem").length > 0){
            $(".shiwuMain").addClass("shiwuItemMain");
            $(".shiwuItemMain").css({"height":$(".shiwuItemMain").width()+"px"});
            //最后一张图片
            var $this = $(".shiwuMain img");
            if ($this.width() < $this.height()) {
                $this.css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
                $this.css({"margin-top": "-" + ($this.height() - $this.width()) / 2,"margin-left": "0px"});
            } else {
                $this.css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
                $this.css({"margin-left": "-" + ($this.width() - $this.height()) / 2,"margin-top": "0px"});
            }
        }
        if(img[0].height != 0 ){
            img.trigger("load");
        }
    }
    function  resizeFm(){
        $(".imgbutton").height($(".imgbutton").width());
        var $this = $("#coverimg");
        if ($this.width() < $this.height()) {
            $this.css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
            $this.css({"margin-top": "-" + ($this.height() - $this.width()) / 2,"margin-left": "0px"});
        } else {
            $this.css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
            $this.css({"margin-left": "-" + ($this.width() - $this.height()) / 2,"margin-top": "0px"});
        }
    }
    function resizeCover(){
        $(".coverImg").height($(".coverImg").width());
        var $this = $("#cover");
        if ($this.width() < $this.height()) {
            $this.css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
            $this.css({"margin-top": "-" + ($this.height() - $this.width()) / 2,"margin-left": "0px"});
        } else {
            $this.css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
            $this.css({"margin-left": "-" + ($this.width() - $this.height()) / 2,"margin-top": "0px"});
        }
    }
</script>
</body>
</html>
