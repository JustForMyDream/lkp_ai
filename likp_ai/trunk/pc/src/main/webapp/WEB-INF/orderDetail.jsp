<%--


  Date: 2016/9/11
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <title>订单详情</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>/css/likepai.css">
    <script src="<%=basePath%>/js/jquery-3.1.1.min.js"></script>
    <script src="<%=basePath%>/js/sockjs-0.3.4.min.js"></script>
    <script src="<%=basePath%>/js/weburl.js"></script>
    <style>
        body {
            background-color: #F6F6F6;
        }

        .navbar.header {
            margin-bottom: -50px;
        }

        .menu > li > a > span {
            padding-right: 10px;
        }

        .content {
            background-color: #f6f6f6;
        }

        .table {
            font-family: "Microsoft YaHei UI", "微软雅黑";
        }

        .orderlist .btn-default:hover, .orderlist .btn-default:focus {
            background-color: #FFE33E;
        }

        .panel-default > .panel-heading {
            background-color: #FFF;
        }

        .nav > li > a:hover, .nav > li > a:focus {
            background-color: inherit;
        }

        .row > div {

        }

        .row > div > a {
            vertical-align: middle;
        }

        img.uploadImg {
            max-height: 163px;
            vertical-align: middle;
            margin: auto;
            text-align: center;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            display: block;
            position: absolute;
        }

        .row > div > .thumbnail {
            min-height: 163px;
            position: relative;
            overflow: hidden;
        }

        .row > div > .thumbnail > .caption >.progress{
            position: absolute;
            z-index: 1;
        }

        .my-navbar{
            float: right;
            margin-right: -210px;
        }
    </style>
</head>
<body>
<nav class="navbar .navbar-fixed-top header" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><img src="<%=basePath%>/image/logo.png"></a>
        </div>
        <%@include file="userinfo.jspf" %>
    </div><!-- /.container-fluid -->
</nav>
<div class="container-fluid banner">

</div>
<div class="container content" style="padding-bottom: 50px">
    <div class="row content">
        <div class="col-lg-2">
            <ul class="nav nav-pills nav-stacked menu" role="tablist">
                <li role="presentation" class="active"><a href="list"><span class="glyphicon glyphicon-list-alt"></span>我的订单</a>
                </li>
            </ul>
        </div>
        <div class="col-lg-10 content">
            <ol class="breadcrumb">
                <li><a href="list">订单列表</a></li>
                <li class="active">订单详情</li>
            </ol>
            <div class="panel panel-default">
                <div id="orderinfo" class="panel-body">
                    <ul id="userinfor">

                    </ul>
                </div>
            </div>
            <div class="panel panel-default" style="border:1px solid #E3E3E3;">
                <div class="panel-heading">
                    <span class="glyphicon glyphicon-chevron-down"></span>待交片数量
                </div>
                <div class="panel-body">
                    <ul id="ordersate">

                    </ul>
                </div>
            </div>

            <nav class="navbar navbar-default" role="navigation"
                 style="border-top-left-radius:3px;border-top-right-radius:3px;border:1px solid #E3E3E3;border-bottom-width:0;margin-bottom: 0;background-color: #F6F6F6">
                <div class="container-fluid">
                    <ul class="nav navbar-nav">
                        <li><a>已上传图片</a></li>
                    </ul>
                    <%--<form id="mform" class="navbar-form navbar-right" role="search">--%>
                    <form id="mform" class="navbar-form my-navbar" role="search">
                        <%--<button id="sub" type="button" class="btn btn-default">上传照片</button>--%>
                        <%--<button id="yingji" type="button" class="btn btn-default">影集设置</button>--%>
                        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal">提交</button>
                        <input id="fileChoose" type="file" accept="image/*" multiple="multiple"
                               style="width: 0;height: 0">
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a>已上传<span id="picnum"></span>张</a></li>
                    </ul>
                </div>
            </nav>
            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active"><a href="#home" role="tab" data-toggle="tab">原片</a></li>
                <li role="presentation"><a href="#profile" role="tab" data-toggle="tab">精修</a></li>
                <li role="presentation" id="yingji"><a href="" role="tab" data-toggle="tab">影集设置</a></li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane yuanpian active" id="home">
                    <div class="panel panel-default"
                         style="border-top-left-radius:0;border-top-right-radius:0;border:1px solid #E3E3E3;border-top-width:0">
                        <div class="panel-body">
                            <div class="row imgs_orig">
                                <div class="col-xs-6 col-md-3" id="sub"><a class="thumbnail"><img  src="<%=basePath%>/image/subPic.png" alt="上传照片"  class="uploadImg"></a></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane jingxiu" id="profile">
                    <div class="panel panel-default"
                         style="border-top-left-radius:0;border-top-right-radius:0;border:1px solid #E3E3E3;border-top-width:0">
                        <div class="panel-body">
                            <div class="row imgs_jingxiu">
                                <div class="col-xs-6 col-md-3" id="subjingxiu"><a class="thumbnail"><img  src="<%=basePath%>/image/subPic.png" alt="上传照片"  class="uploadImg"></a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
    <div class="container" style="text-align: center">
        <img src="<%=basePath%>/image/footer-logo.png" style="margin: 5px auto">
    </div>
</nav>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">提交确认</h4>
            </div>
            <div class="modal-body">
                提交后将无法继续上传操作，是否提交
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button id="commitUpdate" type="button" class="btn btn-primary">提交</button>
            </div>
        </div>
    </div>
</div>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script>
    var id = "${id}";
    var re = /image\/[A-z]{3,4}/i;
    $(function () {
        var orderBH;
        $.get(ajaxurl.orderdetail, {id: id}, function (data) {
            var d = data.data;
            var orderDetail = "<li>" + d.itemProductid.tlkCpfwxqEntitys[0].itemPicturenumber + "</li>" + "<li>" + d.itemProductid.tlkCpfwxqEntitys[0].itemJingxiunumber + "</li>";
            $("#ordersate").append(orderDetail);
            orderBH = d.itemOrderid;
            if (d.length > 0) {
                $("#orderinfo").text("客户信息:" + d.itemName + "|" + d.itemProductid.itemName + "|" + new Date(d.itemOrdertime).pattern('yyyy-MM-dd HH:mm:ss'));
            }
            if (d.itemState != "WAITE_TO_UPLOADIMG") {
                $("#mform").hide();
            }
            $.get(ajaxurl.userinfor, {id: id}, function (data) {
                var u = data.user;
                var userimg = u.headimgurl;
                var userInfor = "<li>微信头像：<img id='userimg' width='30px' src='" + userimg + "'></li><li>" + '微信名称：' + u.nickname + "</li><li>"
                        + '拍摄时间：' + new Date(u.created).pattern('yyyy-MM-dd HH:mm:ss') + "</li><li>订单编号：" + orderBH + "</li>";
                $("#userinfor").append(userInfor);
            }, "json");
            /*if (d.orderInfo) {
             var op = data.orderInfo;
             for (var i = 0; i < op.length; i++) {
             var liitem = $("<li>" + op[i].opType_des + "--------" + new Date(op[i].date).pattern('yyyy-MM-dd HH:mm:ss') + "</li>");
             $("#ordersate").append(liitem);
             }
             }*/
        }, "json");
        $('div[id^="sub"]').on("click", function (e) {
            $("#fileChoose").click();
        });
        $("#fileChoose").on("change", function (e) {
            for (var i = 0; i < this.files.length; i++) {
                (this.files[i]);
                var filetype = new String(this.files[i].type);
                if (filetype.match(re).index == 0) {
                    (i);
                    updateFile(this.files[i]);
                }
            }
        });

        $("#yingji").on("click", function () {
            window.location.href = "yingji?id=${id}";
        });
        $.get(ajaxurl.imglist, {id: id}, function (data) {
            console.log(data);
            var result = data.result;
            if (result == "success") {
                $("#picnum").text(data.data.orderproductimgEntities.length);
                if (data.data.orderproductimgEntities.length > 0) {
                    for (var i = 0; i < data.data.orderproductimgEntities.length; i++) {
                        var o = JSON.parse(data.data.orderproductimgEntities[i].itemImgurl);
                        var imgitem = $("<div class=\"col-xs-6 col-md-3\">" +
                                "<a class=\"thumbnail\">" +
                                "<img src=\"" + imgpre + o[0].path + "\" alt=\"\" class=\"uploadImg\">" +
                                "</a>" +
                                "</div>");
                        if (data.data.orderproductimgEntities[i].itemTplx == "精修") {
                            $(".row.imgs_jingxiu").append(imgitem);
                        }else{
                            $(".row.imgs_orig").append(imgitem);
                        }
                    }
                }
            }
        }, "json");
        $("#commitUpdate").on("click", function () {
            commite(id);
        });
    });
    function commite(id) {
        $.get(ajaxurl.commit, {id: id}, function (data) {
            if (data.judgeimg == "error") {
                alert("你还没有上传图片");
            }
            else {
                if (data.judge == "error") {
                    var r = confirm("你还没有创建相应的影集，是否跳转到创建影集界面");
                    if (r == true) {
                        window.location.href = "yingji?id=${id}";
                    }
                    else {
                        window.location.href = "order?id=${id}";
                    }
                }
            }

            if (data.result == "success") {
                $('#myModal').modal('hide');
                window.location.href = "list";
                return false;
            }
        }, "json");
    }

    function updateFile(file) {
        var data = new FormData();
        //传入订单编号
        data.append("id", id);
        data.append("file", file);
        var type = "yuanpian";
        if ($(".tab-pane.active").hasClass("jingxiu")) {
            type = "jingxiu";
        }
        data.append("type", type);
        var xhr = new XMLHttpRequest();
        xhr.imgid = uuid();
        var windowURL = window.URL || window.webkitURL;
        var imgitem = $("<div id='" + xhr.imgid + "' class=\"col-xs-6 col-md-3\">" +
                "<a class=\"thumbnail\">" +
                "<img src=\"" + windowURL.createObjectURL(file) + "\" alt=\"\" class=\"uploadImg\">" +
                "<div class=\"caption\">" +
                "<div class=\"progress\">" +
                "<div class=\"progress-bar progress-bar-warning\" role=\"progressbar\" aria-valuenow=\"60\" aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width: 0\">" +
                "</div>" +
                "</div>" +
                "</div>" +
                "</a>" +
                "</div>");
        if (type == "jingxiu") {
            $(".row.imgs_jingxiu").append(imgitem);
        } else {
            $(".row.imgs_orig").append(imgitem);
        }
        xhr.onreadystatechange = function () {
              (xhr.status);
            if (xhr.readyState == 4 && xhr.status == 200) {
                var data = JSON.parse(xhr.responseText);
                if (data.result = "success") {
                    $("#" + xhr.imgid + " .caption").remove();
                    $("#" + xhr.imgid + " img").attr("src", imgpre + data.files[0]);
                    var num = parseInt($("#picnum").text());
                    if (num) {
                        ++num;
                    } else {
                        num = 0;
                    }
                    $("#picnum").text(num);
                }

                // alert(xhr.responseText);
            }
        };

        //侦查当前附件上传情况
        xhr.upload.onprogress = function (evt) {
            //侦查附件上传情况
            //通过事件对象侦查
            //该匿名函数表达式大概0.05-0.1秒执行一次
            //  (evt);
            //  (evt.loaded);  //已经上传大小情况
            //evt.total; 附件总大小
            var loaded = evt.loaded;
            var tot = evt.total;
            var per = Math.floor(100 * loaded / tot);  //已经上传的百分比
            $("#" + xhr.imgid + " .progress-bar").css("width", per + "%");
        };

        xhr.open("post", ajaxurl.updateFile);
        xhr.send(data);
    }
</script>
</body>
</html>
