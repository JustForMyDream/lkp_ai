<%--
  Created by IntelliJ IDEA.
  User: cccxt
  Date: 2016/9/11
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path ;
%>
<html>
<head>
    <title>摄影师订单列表</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>/css/likepai.css">
    <script src="<%=basePath%>/js/jquery-3.1.1.min.js"></script>
    <script src="<%=basePath%>/js/sockjs-0.3.4.min.js"></script>
    <script src="<%=basePath%>/js/weburl.js"></script>
    <style>
        body{
            background-color: #F6F6F6;
        }
        .navbar.header{
            margin-bottom: -50px;
        }
        .menu>li>a>span{
            padding-right: 10px;
        }
        .content{
            background-color: #FFF;
        }
        .table{
            font-family: "Microsoft YaHei UI","微软雅黑";
        }
        .orderlist .btn-default:hover,.orderlist .btn-default:focus{
            background-color:#FFE33E;
        }
        .nav > li > a:hover, .nav > li > a:focus {
            background-color: inherit;
        }
    </style>
</head>
<body>
<nav class="navbar .navbar-fixed-top header" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><img src="<%=basePath%>/image/logo.png"></a>
        </div>
        <%@include file="userinfo.jspf"%>
    </div><!-- /.container-fluid -->
</nav>
<div class="container-fluid banner">

</div>
<div class="container content" style="padding-bottom: 50px">
    <div class="row content">
        <div class="col-lg-2">
            <ul class="nav nav-pills nav-stacked menu" role="tablist">
                <li role="presentation" class="active"><a href="#"><span class="glyphicon glyphicon-list-alt"></span>我的订单</a></li>
            </ul>
        </div>
        <div class="col-lg-10 content">
            <ol class="breadcrumb">
                <li class="active">订单列表</li>
            </ol>
            <div class="panel panel-default">
                <table class="table">
                    <thead>
                    <tr>
                        <th>客户姓名</th>
                        <th>下单时间</th>
                        <th>产品名称</th>
                        <th>订单状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody class="orderlist">
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation" style="margin-bottom: 0">
    <div class="container" style="text-align: center">
        <img src="<%=basePath%>/image/footer-logo.png" style="margin: 5px auto">
    </div>
</nav>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script>
    $(function(){
        loadOrderList();
        $(".orderlist").on("click","button",function(e){
            var target = e.currentTarget;
            var $this = $(target);
            window.location.href="<%=basePath%>/order?id="+$this.attr("id");
            return false;
        });
    });
    function loadOrderList(){
        $.get(ajaxurl.orderList,function(data){
              (data);
            var d = data.data;
            for(var i=0;i< d.length;i++){
                var time = new Date(d[i].itemOrdertime).pattern('yyyy-MM-dd HH:mm:ss');
                var zhuangtai = "";
                var caozuo="";
                if(d[i].itemState == "WAITE_TO_PAY"){
                    zhuangtai="待用户支付";
                    caozuo="查看";
                }else if(d[i].itemState == "PAYED_WAITE_SET_PHOTOGRAPHER"){
                    zhuangtai="待分配摄影师";
                    caozuo="查看";
                }else if(d[i].itemState == "WAITE_TO_UPLOADIMG"){
                    zhuangtai="待上传图片";
                    caozuo="立即上传";
                }else if(d[i].itemState == "WAITE_TO_UPLOADIMG"){
                    zhuangtai="待邮寄";
                    caozuo="查看";
                }else if(d[i].itemState == "WAITE_TO_CONFIRM"){
                    zhuangtai="待用户确认";
                    caozuo="查看";
                }
                var liItem = $("<tr><td>"+d[i].itemName+"</td><td>"+time+"</td><td>"+d[i].itemProductid.itemName+"</td><td>"+zhuangtai+"</td><td><button id='"+d[i].id+"' type='button' class='btn btn-default'>"+caozuo+"</button></td></tr>");
                $(".orderlist").append(liItem);
            }
        },"json");
    }
</script>
</body>
</html>
