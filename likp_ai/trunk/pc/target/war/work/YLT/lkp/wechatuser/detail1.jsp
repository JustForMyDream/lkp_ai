<%--
  Created by IntelliJ IDEA.
  User: OWNER1
  Date: 2017/1/18
  Time: 20:13
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
    <title>${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <!--标准mui.css-->
    <link rel="stylesheet" href="../css/mui.min.css">
    <link rel="stylesheet" href="../css/base.css">
    <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
    <!--App自定义的css-->
    <style type="text/css">
        body {
            font-family: Microsoft YaHei;
            height: 100%;
            overflow: hidden;
        }

        img {
            width: 100%;
            height: auto;
            vertical-align: middle;
        }

        .mui-content {
            background-color: #ffffff;
        }

        .product-show-cover {
            font-size: 17px;
            line-height: 36px;
            letter-spacing: 0.2px;
        }

        .product-detail-text {
            padding: 15px;
        }

        .product-show-title {
            font-weight: bold;
        }

        .product-detail-price {
            color: rgb(244,81,85);
            font-size: 14px;
        }

        .product-detail-price > span {
            font-size: 17px;
            font-weight: 500;
        }

        #sliderSegmentedControl {
            border-top: 1px solid rgb(205, 205, 205);
        }

        #slider {
            height: 100%;
        }

        #slider .mui-slider-group {
            height: calc(100% - 41px);
        }

        #sliderProgressBar {
            background-color: #ffffff;
        }

        #sliderProgressBar:before {
            content: '';
            display: block;
            width: 80px;
            height: 0;
            border-top: 1px solid #000000;
            margin: 0 50%;
            top: -6px;
            left: -40px;
            position: absolute;
        }

        #sliderProgressBar:after {
            content: '';
            display: block;
            width: 0;
            height: 0;
            border-left: 10px solid transparent;
            border-right: 10px solid transparent;
            border-top: 15px solid rgb(205, 205, 205);
            margin: 0 50%;
            left: -10px;
            top: 2px;
            position: absolute;
        }

        a.mui-control-item.mui-active {
            color: #000000;
        }

        .mui-segmented-control.mui-segmented-control-inverted .mui-control-item.mui-active {
            color: #000000;
        }

        .mui-slider-item.mui-control-content .mui-scroll {
            padding-top: 15px;
            padding-bottom: 64px;
        }

        .product-example {
            text-align: center;
            color: rgb(98, 98, 98);
            padding: 10px;
        }

        .product-show-des {
            line-height: 20px;
            padding-bottom: 10px;
        }

        .product-show-pic span {
            display: block;
            line-height: 20px;
            padding: 10px 0;
        }

        .divide-title {
            width: 100%;
            background-color: inherit;
            position: relative;
            text-align: center;
        }

        .divide-title > div:nth-child(1) {
            width: 100%;
            height: 50%;
            box-sizing: border-box;
            border-bottom: 1px solid rgb(205, 205, 205);
            position: absolute;
            padding: 0;
            background-color: rgba(0, 0, 0, 0);
            z-index: -1;
        }

        .divide-title > div:nth-child(2) {
            font-size: 15px;
            text-align: center;
            line-height: 15px;
            padding: 10px;
            background-color: #ffffff;
            display: inline-block;
            margin: 0 auto;
        }

        .product-yingji-cover {
            position: relative;
            padding: 10px;
        }

        .product-yingji-cover > img:nth-child(1) {
            position: absolute;
            width: 94px !important;
            height: 94px;
            border-radius: 100%;
            left: 50%;
            top: 50%;
            margin: -47px;
        }

        .product-yingji-cover > img:nth-child(2) {
            border-radius: 5px;
        }

        .recommend-item {
            width: 50%;
            padding: 5px 10px;
            display: inline-block;
            margin: -1.5px;
        }

        .recommend-item .reconmmend-title {
            color: black;
            font-size: 12px;
            padding: 5px 0 0;
        }

        .recommend-item .reconmmend-title > span {
            font-size: 15px;
        }

        .recommend-item .reconmmend-des {
            color: #000000;
            font-size: 12px;
        }

        .product-service-name {
            font-size: 15px;
            font-weight: bold;
            line-height: 20px;
        }

        .product-service-price {
            font-size: 12px;
            color: rgb(244, 81, 85);
            line-height: 20px;
        }

        .product-service-list {
            padding-top: 10px;
            text-align: center;
        }

        .product-service-imglist {
            padding-top: 10px;
        }

        .product-service-imglist-item {
            width: 33.333333%;
            display: inline-block;
            margin: -1.5px;
            text-align: center;
        }

        .product-service-imglist-item > img {
            max-width: 22px;
        }

        .product-service-imglist-item > div {
            padding: 10px;
            color: rgb(147, 147, 147);
        }

        .divider {
            display: block;
            width: 100%;
            height: 0;
            margin: 10px 0;
            border-bottom: 1px solid #c8c7cc;
        }

        .product-service-other {

            padding: 0 10px;
            text-align: center;
            color: rgb(147, 147, 147);
        }

        .product-handover {
            text-align: center;
            color: rgb(147, 147, 147);
        }

        .product-album, .product-calendar {
            color: rgb(147, 147, 147);
            font-size: 13px;
            line-height: 20px;
        }

        .product-service-other-title, .product-handover-title {
            padding: 10px 0 5px;
            color: #000000;
        }

        .product-album-item {
            width: 50%;
            padding: 10px;
            display: inline-block;
            margin: -1.5px;
        }

        .product-album-item > img {

        }

        .product-calendar {
            padding: 10px 10px 0;
        }

        .product-calendar-item {

        }

        .product-album-des {
            padding: 10px 10px 0;
        }

        .bottom {
            height: 64px;
            position: fixed;
            z-index: 2;
            width: 100%;
            background-color: #ffffff;
            bottom: -1px;
            padding: 14px;
        }

        .bottom > div {
            text-align: center;
            float: left;
        }

        .bottom .item-1 {
            width: 25%;
        }

        .bottom .item-2 {
            width: 50%;
        }

        .item-1 {
            height: 40px;
        }

        .item-1 > img {
            width: 23px;
            height: 23px;
        }

        .item-1 > div {
            font-size: 10px;
            color: #999999;
        }

        .bottom .item-2 > button {
            width: 100%;
            color: black;
            background-color: #ffe33e;
            line-height: 24px;
            border: 0;
            box-shadow: 0 1.5px 1px 0 rgba(41, 51, 43, 0.43);
        }

        .mui-scroll-wrapper {
            overflow-y: auto;
        }

        #sharepic p {
            color: #FFF;
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

        .product-detail-info {
            height: auto;
            transition: height 1s;
            -moz-transition: height 1s; /* Firefox 4 */
            -webkit-transition: height 1s; /* Safari 和 Chrome */
            -o-transition: height 1s;
        }
    </style>

</head>

<body>
<div class="mui-content">
    <div class="product-detail-info">
        <div class="product-show-cover">
            <img src="http://placehold.it/400x300?text=加载中..."/>
            <div class="product-detail-text">
                <div class="product-show-title">
                    标题
                </div>
                <div class="product-detail-price">
                    <span>$$$</span>/套
                </div>
            </div>
        </div>
    </div>
    <div id="slider" class="mui-slider" style="background-color: #ffffff">
        <!--标题-->
        <div id="sliderSegmentedControl"
             class="mui-slider-indicator mui-segmented-control mui-segmented-control-inverted">
            <div class="scorll" style="color: rgb(133,131,131);">
                <a class="mui-control-item mui-active" id="title0" href="#product1">
                    套餐样片
                </a>
                <a class="mui-control-item" id="title1" href="#product2">
                    服务详情
                </a>
            </div>
        </div>
        <!--选择条-->
        <div id="sliderProgressBar" class="mui-slider-progress-bar mui-col-xs-6"></div>
        <!--图片-->
        <div class="mui-slider-group">
            <div id="product1" class="mui-slider-item mui-control-content mui-active">
                <div id="scroll1" class="mui-scroll-wrapper">
                    <div class="mui-scroll">
                        <div class="product-example">
                            <div class="product-show-des">
                            </div>

                        </div>
                        <div class="recommend" style="padding: 10px"></div>
                    </div>
                </div>
            </div>
            <div id="product2" class="mui-slider-item mui-control-content">
                <div class="mui-scroll-wrapper">
                    <div class="mui-scroll">
                        <div id="product-service">
                            <div class="product-service-list">
                                <div class="product-service-name"><span></span></div>
                                <div class="product-service-price">￥￥￥元/套</div>
                                <div class="product-service-imglist">

                                </div>
                                <div class="divider"></div>
                            </div>
                        </div>
                        <div class="product-service-other">
                            <div class="product-service-other-title">
                                【服务说明】
                            </div>
                            <div class="product-service-other-detail">
                            </div>
                        </div>
                        <div class="product-handover">
                            <div class="product-handover-title">
                                【成品交付】
                            </div>
                            <div class="product-handover-detail">
                            </div>
                            <div class="product-album">
                                <div class="product-album-item">
                                    <img src="../example/1.png"/>
                                </div>
                                <div class="product-album-item">
                                    <img src="../example/2.png"/>
                                </div>
                                <div class="product-album-des">
                                    * 定制家庭精装相册效果展示 *
                                </div>
                            </div>
                            <div class="product-calendar">
                                <div class="product-calendar-item">
                                    <img src="../example/3.png"/>
                                </div>
                                <div class="product-album-des">
                                    * 定制家庭台历效果展示 *
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="bottom mui-row">
        <div class="item-1" id="fenxiang1">
            <img src="../image/fenxiang.png"/>
            <div>分享</div>
        </div>
        <div class="item-1" id="collection">
            <img src="../image/shoucang.png"/>
            <div>收藏</div>
        </div>
        <div class="item-2">
            <button>即刻约拍</button>
        </div>
    </div>

</div>
<div class="mui-backdrop">
    <div class="item" id="sharepic" style="position: absolute; right: 7px; top: 7px;width: inherit; height: inherit;margin-top: 0;">
        <img style="width: 270px;" src="../image/click_right_to_share_3.png"/>
    </div>
</div>
</body>
<script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="../js/mui.min.js"></script>
<script type="text/javascript" src="../js/getParam.js"></script>
<script type="text/javascript" src="../js/server.js"></script>
<script>
    var title="${title}";
    var id = "${id}";
    <%--wx.config({--%>
        <%--debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。--%>
        <%--appId: '${appId}', // 必填，公众号的唯一标识--%>
        <%--timestamp: ${timestamp}, // 必填，生成签名的时间戳--%>
        <%--nonceStr: '${nonceStr}', // 必填，生成签名的随机串--%>
        <%--signature: '${signature}',// 必填，签名，见附录1--%>
        <%--jsApiList: ['getLocation', 'downloadImage', 'onMenuShareTimeline', 'onMenuShareAppMessage', 'hideMenuItems'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2--%>
    <%--});--%>
      (id);
    var $mask = $(".mui-backdrop");
    $(function () {
        loadProductDetail(id);
        loadCollection(id);
        shareCanpin();
        loadfwxq();
        var lastscroll = 0;
        $(".mui-scroll-wrapper").on("scroll", function () {
            var header = $(".product-detail-info");
            var scrolltop = $(this).scrollTop();
            if (scrolltop - lastscroll > 0 && header.height() > 0) {
                header.height(0);
            } else if (scrolltop - lastscroll <= 0 && scrolltop == 0) {
                header.height($(".product-show-cover").height());
            }
        });
    });
    function loadProductDetail(id) {
        $.ajax({
            url: "../common/index/productDetail",
            data: {"id": id},
            type: "post",
            dataType: "json",
            success: function (data) {
                if (data) {
                    var $productExample = $(".product-example");
                    var productShow = data.tlkProductshowEntities[0];
                    var productService = data.tlkCpfwxqEntitys[0];
                    $(".product-detail-price>span").text(data.itemPrice + "元");
                    $(".product-service-price").text(data.itemPrice + "/套");
                    $(".product-detail-price>span").text(data.itemPrice);
                    $(".product-service-price").text(data.itemPrice + "元/套");

                    $(".item-2 button").on("tap", function (e) {
                        window.location.href = "../wechatuser/placeAnOrder.html?id=" + id;
                    });
                    if (productShow) {
                        $(".product-show-cover>img").attr("src", imgpre + (JSON.parse(productShow.itemZpfm)[0].path));
                        $(".product-show-cover .product-show-title").text(productShow.itemTitle);
                        $(".product-service-name span").text(productShow.itemTitle);
                        $(".product-show-des").html(productShow.itemZpms.replace("\n", "<br>"));
                        /**添加展示图片和文字**/
                        /**
                         * <div class="product-show-pics">
                         <div class="product-show-pic">
                         <img src="../example/05-2.jpg">
                         <span>872365r298736529834dlfkgjdesl </span>
                         </div>
                         <div class="product-show-pic">
                         <img src="../example/05-2.jpg">
                         <span>872365r298736529834dlfkgjdesl </span>
                         </div>
                         <div class="product-show-pic">
                         <img src="../example/05-2.jpg">
                         <span>872365r298736529834dlfkgjdesl </span>
                         </div>
                         </div>
                         */
                        var productShowpics = productShow.tlkProductshowpicEntities;
                        if (productShowpics) {
                            var $productShowPicContent = $("<div class=\"product-show-pics\"></div>");
                            $productExample.append($productShowPicContent);
                            for (var i = 0; i < productShowpics.length; i++) {
                                var des = "";
                                if (productShowpics[i].itemDescript) {
                                    des = productShowpics[i].itemDescript.replace("\n", "<br>");
                                }
                                var productShowItem = $("<div class=\"product-show-pic\"><img src=\"" + imgpre + JSON.parse(productShowpics[i].itemPicurl)[0].path + "\"><span>" + des + "</span></div>");
                                $productShowPicContent.append(productShowItem);
                            }
                        }
                        /**影集设置**/
                        /*
                         <div class="product-yingji">
                         <div class="divide-title">
                         <div></div><div>影集</div>
                         </div>
                         <div class="product-yingji-cover">
                         <img src="../image/play_white_all.png"/>
                         <img src=""/>
                         </div>
                         </div>*/
                        var yingji = data.itemZsyj;
                        if (yingji) {
                            var $yingjiItem = $("<div class=\"product-yingji\"><div class=\"divide-title\"><div></div><div style='color: black'>影集</div></div><div class=\"product-yingji-cover\"><img src=\"../image/play_white_all.png\"/><img src=\"" + imgpre + JSON.parse(yingji.tlkYingjipicEntities[0].itemImgurl)[0].path + "\"/></div></div>");
                            $productExample.append($yingjiItem);
                            $yingjiItem.data("id", yingji.id);
                            $yingjiItem.on("tap", function () {
                                window.location.href = "../YINGJI/newYingji?id=" + $(this).data("id");
                            });
                        }
                        /**服务详情**/
                        /**
                         *
                         * <div class="product-service-imglist-item">
                         <img src="../image/time@2x.png">
                         <div>3小时拍摄</div>
                         </div>
                         <div class="product-service-imglist-item">
                         <img src="../image/view.png">
                         <div>100张原片</div>
                         </div>
                         <div class="product-service-imglist-item">
                         <img src="../image/demoin.png">
                         <div>20张精修</div>
                         </div>
                         <div class="product-service-imglist-item">
                         <img src="../image/clouth.png">
                         <div>服装自备</div>
                         </div>
                         <div class="product-service-imglist-item">
                         <img src="../image/makeup.png">
                         <div>化妆自备</div>
                         </div>
                         <div class="product-service-imglist-item">
                         <img src="../image/gift.png">
                         <div>提供成品</div>
                         </div>
                         * **/
                        if (productService) {
                            var $imglist = $(".product-service-imglist");
                            var detailStr = "";
                            var hanldStr = "";
                            if (productService.itemTime) {
                                var $time = $("<div class=\"product-service-imglist-item\"><img src=\"../image/time@2x.png\"><div>" + productService.itemTime + "</div></div>");
                                $imglist.append($time);
                                detailStr += "拍摄时长：" + productService.itemTime + "<br>";
                            }
                            if (productService.itemPicturenumber) {
                                var $picture = $("<div class=\"product-service-imglist-item\"><img src=\"../image/view.png\"><div>" + productService.itemPicturenumber + "</div></div>");
                                $imglist.append($picture);
                                hanldStr += "精选原片：" + productService.itemPicturenumber + "<br>";
                            }
                            if (productService.itemJingxiunumber) {
                                var $jingxiu = $("<div class=\"product-service-imglist-item\"><img src=\"../image/demoin.png\"><div>" + productService.itemJingxiunumber + "</div></div>");
                                $imglist.append($jingxiu);
                                hanldStr += "精选修片：" + productService.itemJingxiunumber + "<br>";
                            }
                            if (productService.itemDress) {
                                var $dress = $("<div class=\"product-service-imglist-item\"><img src=\"../image/clouth.png\"><div>" + productService.itemDress + "</div></div>");
                                $imglist.append($dress);
                            }
                            if (productService.itemMakeup) {
                                var $makeup = $("<div class=\"product-service-imglist-item\"><img src=\"../image/makeup.png\"><div>" + productService.itemDress + "</div></div>");
                                $imglist.append($makeup);
                            }
                            if (productService.itemSupply) {
                                var $supply = $("<div class=\"product-service-imglist-item\"><img src=\"../image/gift.png\"><div>" + productService.itemSupply + "</div></div>");
                                $imglist.append($supply);
                            }
                            detailStr += "拍摄人数：主拍父母，辅助可若干<br>";
                            detailStr += "拍摄场景：" + productService.itemSection + "<br>";
                            detailStr += "其他费用:" + productService.itemAddfee + "<br>";
                            hanldStr += "定制家庭专属电子影集：1个<br>";
                            hanldStr += "定制家庭精装相册：1本<br>";
                            hanldStr += "专属家庭台历：一套12张<br>";
                            $(".product-service-other-detail").append(detailStr);
                            $(".product-handover-detail").append(hanldStr);
                        }
                        /**相关推荐**/
                        /**<div class="recommend">
                         <div class="divide-title">
                         <div></div>
                         <div>相关推荐</div>
                         </div>
                         <div class="recommend-list">
                         <div class="recommend-item">
                         <img src="../example/16.jpg"/>
                         <div class="reconmmend-title"><span>$$$元</span>/套</div>
                         <div class="reconmmend-des">dfhe</div>
                         </div>
                         <div class="recommend-item">
                         <img src="../example/16.jpg"/>
                         <div class="reconmmend-title"><span>$$$元</span>/套</div>
                         <div class="reconmmend-des">wqgfgh</div>
                         </div>
                         </div>
                         </div>**/
                    }

                }
            }
        });
    }
    function loadfwxq() {
        $.ajax({
            url: "../common/index/getOrderByProductCount",
            data: {},
            type: "post",
            dataType: "json",
            success: function (data) {
                var imgpath0 = JSON.parse(data[0].itemCover)[0].path;
                var price0 = data[0].itemPrice;
                var itemName0 = data[0].itemName;
                var imgpath1 = JSON.parse(data[1].itemCover)[0].path;
                var price1 = data[1].itemPrice;
                var itemName1 = data[1].itemName;
                $(".recommend").append('<div class="divide-title">\
                        <div></div>\
                        <div>相关推荐</div>\
                        </div>\
                        <div class="recommend-list">\
                        <div class="recommend-item" data-id ="' + data[0].id + '">\
                        <img src="' + imgpre + imgpath0 + '"/>\
                        <div class="reconmmend-title"><span>' + price0 + '元</span>/套</div>\
                        <div class="reconmmend-des">' + itemName0 + '</div>\
                        </div>\
                        <div class="recommend-item" data-id ="' + data[1].id + '">\
                        <img src="' + imgpre + imgpath1 + '"/>\
                        <div class="reconmmend-title"><span>' + price1 + '元</span>/套</div>\
                        <div class="reconmmend-des">' + itemName1 + '</div>\
                        </div>\
                        </div>');
                $(".recommend-item").on('tap', function () {
                    window.location.href = "detail.html?id=" + $(this).attr("data-id");
                });
            }
        });
    }
    /*        $(".mui-scroll-wrapper").on("touchmove scroll",function(e){
     var $mainContainer = $("body");
     var $productContainer = $(".mui-scroll-wrapper");
       ($productContainer.scrollTop());
       ($mainContainer.scrollTop());
     if(($mainContainer.scrollTop()-$(".product-detail-info").height())<=0){
     $mainContainer.scrollTop($(".product-detail-info").height());
     }
     /!*if($mainContainer)*!/
     });*/
    function loadCollection(id) {
        $.ajax({
            url: "../userPort/Collection/getCollectionByZpUs",
            data: {"zpmc": id},
            type: "post",
            dataType: "json",
            success: function (data) {
                if (data.errorCode == "200") {
                    if (data.shoucang == true) {
                        $("#collection img").attr("src", "../image/shoucang2.png");
                        $("#collection>div").text("已收藏");
                    } else {
                        $("#collection img").attr("src", "../image/shoucang.png");
                        $("#collection>div").text("收藏");
                    }
                } else {
//                    mui.toast(data.errorMsg);
                }
                addOrdeleteCollection();
            }
        });
    }
    function addOrdeleteCollection() {
        $("#collection").on('tap', function () {
            if ($("#collection img").attr("src") == "../image/shoucang2.png") {
                mui.toast("取消收藏中...");
            } else {
                mui.toast("添加收藏中...");
            }
            $.ajax({
                url: "../userPort/Collection/addOrDeleteCollectionByZpUs",
                data: {"zpmc": id},
                type: "post",
                dataType: "json",
                success: function (data) {
                    if (data.errorCode == "200") {
                        mui.toast(data.message);
                        if (data.shoucang == true) {
                            $("#collection>div").text("已收藏");
                            $("#collection img").attr("src", "../image/shoucang2.png");
                        } else {
                            $("#collection>div").text("收藏");
                            $("#collection img").attr("src", "../image/shoucang.png");
                        }
                    } else {
                        mui.toast(data.errorMsg);
                    }
                }
            });
        });
    }
    $mask.showItem = function (item) {
        $(this).children("div.item").hide();
        $(this).show();
        $(this).children("#" + item).show();
    };
    $mask.hideItem = function () {
        $(this).hide();
    };
    function shareCanpin() {
        $("#fenxiang1").on("tap", function (e) {
            e.stopPropagation();
            $mask.showItem("sharepic");
        });
        $mask.on("tap", function (e) {
            e.stopPropagation();
            $mask.hideItem();
        });
    }


</script>
</html>
