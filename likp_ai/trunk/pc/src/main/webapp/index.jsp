<%--


  Date: 2016/9/11
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path ;
%>
<html lang="zh-CN">
<head>
    <title>立可拍</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>/css/likepai.css">
    <script src="<%=basePath%>/js/jquery-3.1.1.min.js"></script>
    <script src="<%=basePath%>/js/sockjs-0.3.4.min.js"></script>
    <script src="<%=basePath%>/js/weburl.js"></script>
    <script src="<%=basePath%>/js/SOCKET_OP.js"></script>
    <style>
        body {
            background-color: #000;
            background-image: url("image/indexbackground.jpg");
            background-size: 100% auto;
        }

        .container.main {
            padding-top: 100px;
        }

        .word-container {
            font-size: 30px;
            color: #FFF;
            float: left;
            padding-top: 30px;
        }

        .qrcodeimg-container {
            width: 430px;
            float: right;
            text-align: center;
            background-color: #FFF;
            padding: 20px;
        }

        .qrcode-img {
            width: 300px;
            text-align: center;
            margin: 0 auto;
        }

        .qrcod-des {
            font-size: 23px;
            font-weight: 700;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">

            <a class="navbar-brand" href="#"><img src="<%=basePath%>/image/logo.png"></a>
        </div>
    </div><!-- /.container-fluid -->
</nav>
<div class="container main">
    <div class="word-container">
        <div>扫一扫</div>
        <div>快速交付订单照片</div>
    </div>
    <div class="qrcodeimg-container">
        <img class="qrcode-img"/>

        <div class="qrcod-des">正在获取登录二维码</div>
        <button class="btn btn-default qrcod-reset" type="button">刷新二维码</button>
    </div>
</div>
<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
    <div class="container" style="text-align: center">
        <img src="image/footer-logo.png" style="margin: 5px auto">
    </div>
</nav>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script>
    var QRCodeurl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=";
    $(function () {
        getCRCode();
        $(".qrcod-reset").on("click", function () {
            $(".qrcod-des").text("正在获取登录二维码");
            getCRCode();
        });
    });
    function getCRCode() {
        $.get(ajaxurl.qrcode, function (data) {
            if (data.result == "success") {
                $(".qrcode-img").attr("src", QRCodeurl + data.qrcode);
                $(".qrcod-des").text("微信扫描登录");
                open();
            } else {
                switch (data.code) {
                    case ("500"):
                        setTimeout(getCRCode(), 1000);
                        break;
                    case ("100"):
                        window.location.href = loginsuccessurl;
                        break;
                }
            }
        }, "json");
    }
</script>
</body>
</html>
