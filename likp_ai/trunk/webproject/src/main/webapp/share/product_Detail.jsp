<%--


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
            max-height: 200px;
            overflow: hidden;
        }

        .yjs_cen {
            height: auto;
            /*text-align: center;*/
            padding: 15px 15px 20px 15px;
        }

        .bottom_img {
            padding: 2px 0px;
        }

        #time {
            margin-bottom: 10px;
            font-size: 12px;
            color: rgb(124, 124, 124);
        }

        .miaoshu {
            text-align: left;
            color: #8d8b8b;
            font-size: 14px;
            padding-left: 2%;
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
    </style>
</head>
<body>
<div class="mui-navbar-inner mui-bar mui-bar-nav" style="background-color: black">
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left" style="color: white"></a>
    <%--<a id="rightbt" class="mui-btn mui-btn-link mui-pull-right" href="newSet?id=${id}" style="color: white">编辑</a>--%>
    <%--<h1 class="mui-center mui-title">选择图片</h1>--%>
</div>
<div class="mui-content">

    <div class="yjs_cen">
        <h3 id="title" style="    margin-bottom: 15px;
    font-size: 18px;
    font-weight: 500;
    color: #000;"></h3>
        <div id="time"></div>
    </div>
    <div class="yjs_top">
        <img id="top_img"/>
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

<script src="../js/getParam.js"></script>
<script>
    var preImg = "http://localhost:8080/Z22629";
    var id = GetQuery('id')
    loadImg();
    function loadImg() {
        var domain = "http://localhost:8080";
        var project = "/Z22629";
        var imgpre = domain + project;
        $.ajax({
            url: "<%=basePath%>productshow/find",
            data: {id: id},
            type: "GET",
            dataType: "json",
            success: function (data) {
                  (data);
                //加载封面
                var path = JSON.parse(data.itemZpfm);
                $("#top_img").attr("src", imgpre + path[0].path);

                //标题
                $("#title").text(data.itemTitle);
                document.title = data.itemTitle;
                //时间
                var time = new Date(data.created).format("yyyy-MM-dd");
                $("#time").append(time);
//                $("#time").html("<span>by " + data.user.nickname + "</span><br/>" + time);
                //加载图片和描述
                var yjgl_detail = data.tlkProductshowpicEntities;
                for (var i in yjgl_detail) {
                    var imsrc = imgpre + JSON.parse(yjgl_detail[i].itemPicurl)[0].path;
                    if (yjgl_detail[i].itemDescript != null && yjgl_detail[i].itemDescript != undefined && yjgl_detail[i].itemDescript != '') {
                        $("#ibottom").append('<div class="miaoshu">' + yjgl_detail[i].itemDescript + '</div>');
                    } else {
                        $("#ibottom").append('<div class="miaoshu"></div>');
                    }
                    $("#ibottom").append('<div class="bottom_img"><img src="' + imsrc + '"/></div>');
                }
            }
        })
        ;
    }
</script>
</body>
</html>
