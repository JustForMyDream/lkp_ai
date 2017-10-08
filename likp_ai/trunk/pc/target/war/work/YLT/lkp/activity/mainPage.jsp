<%--
  Created by IntelliJ IDEA.
  User: 王玉粮
  Date: 2016/12/31
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>立可拍活动</title>
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <link href="../css/mui.min.css" rel="stylesheet"/>
    <link href="../css/base.css" rel="stylesheet">
    <link href="../css/mui.picker.css" rel="stylesheet"/>
    <link href="../css/mui.poppicker.css" rel="stylesheet"/>
    <link href="<%=basePath%>activity/Common.css" rel="stylesheet"/>
    <style>
        .activity-name{
            font-size: 16px;
            font-weight:bold;
        }
        body{
            overflow-x: hidden;
        }
        .content{
            overflow-x: hidden;
        }
        .content p{
            width: 100% !important;
            word-wrap:break-word;
            word-break:normal;
            white-space: normal;
        }
        .content img{
            width: 100% !important;
        }
        .tishi{
            bottom: 0;
            position: absolute;
            width: 100%;
            height: 100%;
            background: rgba(0,0,0,0.5);
            display: none;
        }
        .erweima{
            width: 80%;
            position: relative;
            text-align: center;
            background-color: #FFF;
            margin: 0 auto;
            padding: 12px 6px;
            border-radius: 5px;
        }
        .shuaxin{
            width: 100%;
            text-align: center;
        }
        .shuaxin > button{
            width: 50%;
            color: black;
            background-color: #ffe33e;
            line-height: 24px;
            border: 0;
            box-shadow: 0 1.5px 1px 0 rgba(41, 51, 43, 0.43)
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
        .button-row{
            width: 100%;
            text-align: center;
            z-index: 1;
        }

        a.button{
            margin: 0;
            text-align: center;
            color: #000000;
            z-index: 1;
            border-radius: 5px;
            width: 28%;
        }
        .ii{
            height: 20px;
            width: 20px;
            margin-top: -10px;
        }
        .jiantou{
            z-index: 100;
            height: 50px;
            width: 45px;
            position: fixed;
            margin-bottom: 50px;
            bottom: -50px;
            margin-left: 85%;
            display: none;
        }
        .jiantou img{
            width: 100%;
            height: auto;
        }

    </style>
</head>
<body>
<header id="top">
     <div class="header-content">

     </div>
</header>
<div class="content">
    <div class="activity-name" style="height: 35px;text-align:left">
    </div>
    <div id="activity-add">
    </div>
</div>
<div class="button-row">
    <a id="baoming" href="hdbm?id=${id}" class="button">我要报名</a>
</div>
<div class="activity-divider" style="text-align:left">
    <img src="../img/info.svg" class="ii">
    <P>活动详情</P>
</div>
<div class="jiantou">
   <a href="#top"><img src="../img/top.svg"></a>
</div>
<div id="content" class="content">
</div>
<div class="tishi">
    <div class="erweima">
        <img style="width: 100%;" src="../image/er_Wei.jpg">
        <p style=" color: gray;text-align: center;overflow: hidden;">你还没有关注该公众号,请长按二维码，关注后即可报名。</p>
        <div class="shuaxin">
            <button>刷新页面</button>
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

<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../js/server.js"></script>
<script>
var id = "${id}";
//var id = "11e6-d891-56a4d823-aff6-6ff166f31966";
    $.ajax({
        url:"../ActivityTemplate/hdmainpage",
        data:{id:id},
        type:"post",
        dataType:"json",
        success:function (data) {
            if(data.subscribe==false){
                //如果没有关注则弹出二维码
                $(".tishi").css("display","block");
                var windowHeight = $(window).height();
                var picHeight = $(".erweima").height();
                var height = (windowHeight - picHeight)/2;
                $(".erweima").css("margin-top",height);

            } else {
                //加载数据
                var img = JSON.parse(data.data1.itemBmtp);
                var imgpath = img[0].path;
                var itemName = data.data1.itemName;
                var itemDetail = data.data1.itemDetail;
                $(".header-content").append("<img style='width: 100%; height: auto;' src=" + imgpre + imgpath + ">");
                $(".activity-name").append(itemName);
                for (var i in data.data2) {
                    var itemHdzdmc = data.data2[i].itemHdzdmc;
                    var itemHdzdnr = data.data2[i].itemHdzdnr;
                    var html = "<hr><div class='activity-info-row' style='background-color: white!important;' ><div class='activity-info-key'style='color: black!important;background-color: white!important;'>" + itemHdzdmc + " :</div>" +
                            "<div class='activity-info-value' style='margin-left: 15px;background-color: white!important;'>" + itemHdzdnr + "</div></div>";

                    $("#activity-add").append(html);
                }
                $("#activity-add").append("<hr>");
                var picPre = "http://www.91lkp.com:8080";
                //var reg = /[i][m][g][\s]*[s][r][c][\s]*=[\s]*['"]([\s\S]*?)['"]/gi;
                //var reg = /<img src=\"([^\"]*?)\">/gi;
                var reg = /<img [^>]*src=['"]([^'"]+)[^>]*>/gi;
                var s = itemDetail.replace(reg,function (match,capture) {
                      (capture);
                    return match.replace(capture,picPre+capture);
                });
                $("#content").append(s);
                if (data.length == 0) {
                    html = '<div class="mui-card">\
								<h3 class="cp_title">暂无信息</h3>\
							</div>';
                }
            }
            $(".mui-backdrop").hide();
        }
    });
  $(".shuaxin button").on("tap",function () {
      window.location.reload();
  })
$.ajax({
    url:"../ActivityTemplate/isjoined",
    data:{id:id},
    type:"post",
    dataType:"json",
    success:function (data) {
        if(data.result=="success"){
            $("#baoming").on("tap click touch",function (e) {
                e.preventDefault();
            }).css("backgroundColor","#EEEEEE").text("报名成功");
        }
    }
});
//设置箭头的出现
$(function () {
    $(window).scroll(function () {
        if ($(window).scrollTop() > 100) {
            $('.jiantou').css('display','block');    //<div id-'top'></div>假如有这么个div是那个向上图标的div。css默认none
        }
        else {
            $('.jiantou').css('display','none');
        }
    });
});
//$.ajax({
//    url:"../ActivityTemplate/firstpage",
//    data:{id:id},
//    type:"post",
//    dataType:"json",
//    success:function (data) {
//          (data);
//
//    }
//})
</script>
</body>
</html>
