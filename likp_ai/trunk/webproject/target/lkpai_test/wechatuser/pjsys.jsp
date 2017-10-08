<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/1/21
  Time: 19:01
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
    <title>评价摄影师</title>
    <%@include file="../share/jsAndCss.jspf" %>
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
</head>
<style type="text/css">
    body, html {
        background-color: #FFFFFF;
        font-family: "微软雅黑";
    }

    .ds_dj {
        width: 98%;
        margin: 0 auto;
        text-align: center;
        font-size: 15px;
        padding: 15px;
        margin-bottom: 24px;
        border-bottom: 1px solid gainsboro;
    }

    .ds_dp {
        text-align: center;
        font-size: 15px;
        margin: 27px;
    }

    .headimg {
        width: 80px;
        height: 80px;
        border-radius: 100%;
        display: block;
        margin: 0px auto 18px;
        border: 2px solid #B5B3B3;
    }

    .name {
        text-align: center;
        font-size: 14px;
    }

    .star-group {
        text-align: center;
        margin-bottom: 24px;
        margin-top: 12px;
    }

    .star-group {
        text-align: center;
        margin-bottom: 20px;
    }

    .star {
        font-family: Muiicons;
        display: inline-block;
        font-size: 25px;
    }

    .star:before {
        content: "\e408";
        color: #6d6d72;
    }

    .star.select:before {
        content: "\e438";
        color: rgba(255, 227, 62, 1);
    }

    .icom_star {
        line-height: 36px;
        height: 36px;
    }

    .icom_star1 {
        float: left;
    }

    .icom_star2 {
        float: right;
    }

    .icom_star2 .star {
        font-size: 18px;
    }

    .ds_btn1 {
        display: inline-block;
        width: 42%;
        margin-left: 2.6%;
        margin-bottom: 10px;
        height: 38px;
        text-align: center;
        line-height: 35px;
        border-radius: 2px;
        border: 1px solid #d8d5d5;
        font-size: 13px;
        color: #7e7d7d;
    }

    .words {
        display: block;
        width: 84.4%;
        margin-left: 9%;
    }

    .btn {
        height: 60px;
        font-size: 16px;
        width: 100%;
        padding: 6px 30px;
        background-color: rgba(255, 227, 62, 1);
        position: fixed;
        bottom: 0;
    }

    .ds_btn2 {
        background-color: rgba(255, 227, 62, 1);
        color: black;
    }
</style>
<body>
<div class="ds_dj">评价摄影师</div>
<div class="sysinfo">
    <img class="headimg" src=""/>

    <div class="name">
        摄影师
    </div>
    <div class="star-group" id="xuanstar">
        <div class="star select"></div>
        <div class="star select"></div>
        <div class="star select"></div>
        <div class="star select"></div>
        <div class="star select"></div>
    </div>
    <div class="ds_dp">点评下哪些方面做的好?</div>
    <div class="ds_btn" style="width: 100%;padding: 2% 2%;text-align: center;">
        <div class="ds_btn1">快速交付</div>
        <div class="ds_btn1">拍摄价格</div>
        <div class="ds_btn1">照片质量</div>
        <div class="ds_btn1">摄影体验</div>
        <div class="ds_btn1">服务态度</div>
        <div class="ds_btn1">其他方面</div>
    </div>
    <textarea class="words" placeholder="输入其他评价..." rows="3"></textarea>
</div>
<button class="btn">提交</button>
</body>
<script src="../js/getParam.js"></script>
<script>
    var id = GetQuery("id");
    //var id = "297e9e795991b86c01599274b9bc0000";
    //评价和打赏的判断
    $.ajax({
        url: "<%=basePath%>ORDER/pjsys",
        data: {"id": id},
        dataType: "json",
        type: "GET",
        success: function (data) {
            console.log(data);
            if (data.errorCode != "200") {
                mui.toast("没有用户相关信息！")
            } else {
                var sys = data.sys;
                var xm = sys.itemName;
                $(".name").append(xm);
                var img = sys.itemHeadimg;
                if (img) {
                    var imgpath = imgpre + JSON.parse(img)[0].path;
                    $(".headimg").attr("src", imgpath);
                }else {
                    $(".headimg").attr("src", "../images/photographer.png");
                }
                select();
                btnselect();
                $(".btn").on("click", function () {
                    comit();
                });
            }
        },
        error: function (err) {
            console.log(err);
            mui.toast("出错啦:" + err);
            //请求出错处理
        }
    });

    //让星星可以点
    function select() {
        $(".star-group").on("click", ".star", function () {
            $(".star").addClass("select");
            $(this).nextAll().removeClass("select");
        });
    }

    //让按钮可以点
    function btnselect() {
        $(".ds_btn1").click(function () {
            if ($(this).hasClass("ds_btn2")) {
                $(this).removeClass("ds_btn2");
            } else {
                $(this).addClass("ds_btn2");
            }
        });
    }
    function comit() {
        var data = {};
        data.id = id;
        data.num = $("#xuanstar>.star.select").length;
        var xuanbtn = "";
        for (var i = 0; i < 6; i++) {
            if ($($(".ds_btn1").get(i)).hasClass("ds_btn2")) {
                xuanbtn += $($(".ds_btn1").get(i)).text() + ";";
            }
        }
        data.btn = xuanbtn;
        if ($(".words").val()) {
            data.words = $(".words").val();
        } else {
            date.words = "";
        }
        $.ajax({
            url: "<%=basePath%>ORDER/savepjsys",
            data: data,
            dataType: "json",
            type: "get",
            success: function (data) {
                console.log(data);
                if (data.errorCode == "200") {
                    /*mui.toast(data.msg);*/
                    window.location.href = "orderdetail.html?id=" + id;
                } else {
                    mui.toast(data.errorMsg);
                }
            }
        });
    }
</script>
</html>
