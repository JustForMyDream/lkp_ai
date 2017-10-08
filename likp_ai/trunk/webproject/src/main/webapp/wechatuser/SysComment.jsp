<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>摄影师评价</title>
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <meta charset="UTF-8">
    <link href="../css/mui.min.css" rel="stylesheet" />
    <link href="../css/sheyingshi.css" rel="stylesheet" />
    <link href="../css/base.css" rel="stylesheet">
    <style>
        .list {
            position: relative;
            width: 100%;
            height: 100px;
            border-bottom: 2px solid #EEEEEE;
            clear: both;
            background-color: white;
        }
        .img {
            border-radius: 50%;
            width: 80px;
            height: 80px;
        }

        .content-left {
            width: 25%;
            height: 80px;
            padding: 10px 10px 10px;
            float: left;
            display: inline-block;
        }
        .content-right {
            width: 72%;
            height: 28px;
            margin-top: 26px;
            display: inline-block;
        }
        .xingxing {
            height: 20px;
            float: right;
            margin-right: 10px;
        }
        .nicheng {
            font-size: 17px;
            font-weight: bold;
            color: black;
            padding-left: 20px;
        }
        .leirong {
            color: rgb(188, 188, 188);
            font-size: 12px;
            margin-top: -6px;
        }
        .wujiaoxing {
            width: 15px;
            height: 15px;
            white-space: nowrap;
        }
        .bottom{
            height: 20px;
            float: right;
            margin-right: 10px;
        }
        .center{
            padding-left: 20px;
            margin-top: 4px;
        }
        p{
            margin-bottom: 0px;
        }
        .kong{
            font-size: 15px;
            background-color: white;
            padding-top: 29px;
            text-align: center;
            color: #9f9f9f;
        }
        .pingjialeirong{
            font-size: 15px;
            overflow: hidden;
            padding-right: 10px;
            text-overflow: ellipsis;
            white-space: nowrap;
        }


        /*.css2 {*/
            /*overflow: hidden; !*自动隐藏文字*!*/
            /*text-overflow: ellipsis;!*文字隐藏后添加省略号*!*/
            /*white-space: nowrap;!*强制不换行*!*/
            /*width: 20em;!*不允许出现半汉字截断*!*/
            /*color:#6699ff;border:1px #ff8000 dashed;*/
        /*}*/


        .time{
            font-size: 13px;
        }
    </style>
</head>
<body>
<header class="mui-bar mui-bar-nav" style="border-bottom: 1px solid #dcdcdc;color:black;background-color: white;">
    <a class="mui-icon mui-action-back mui-icon-arrowleft" style="color:black;">
    </a>
    <h1 class="mui-title" style="width: 80%">摄影师评价</h1>
</header>
<div class="mui-content">
    <!--<div class="list">-->
    <!--<div class="content-left"><img class="img" src="../images/MainInterface/s1.jpg"></div>-->
    <!--<div class="content-right">-->
    <!--<span class="nicheng">静静</span>-->
    <!--<div class="xingxing">-->
    <!--<img class="wujiaoxing" src="../images/sheyingshi/wujiaoxing.png">-->
    <!--<img class="wujiaoxing" src="../images/sheyingshi/wujiaoxing.png">-->
    <!--<img class="wujiaoxing" src="../images/sheyingshi/wujiaoxing.png">-->
    <!--<img class="wujiaoxing" src="../images/sheyingshi/wujiaoxing.png">-->
    <!--<img class="wujiaoxing" src="../images/sheyingshi/wujiaoxing.png">-->
    <!--</div>-->
    <!--<div class="center">-->
    <!--<p class="pingjialeirong">静静</p>-->
    <!--</div>-->
    <!--<div class="bottom">-->
    <!--<p class="time">2014年9云24号</p>-->
    <!--</div>-->
    <!--</div>-->
    <!--</div>-->
</div>



<script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="../js/mui.min.js"></script>
<script type="text/javascript" src="../js/getParam.js"></script>
<script type="text/javascript" src="../js/server.js"></script>
<script type="text/javascript" src="../js/date.js"></script>
<script>
    mui.init();
    var bh = GetQueryString("bh");
    $(function () {
        jiazaipinglun();
    });
      (bh);
    function jiazaipinglun() {
        $.ajax({
            url: "../sysPort/getOrderBySysId",
            data: {"id":bh},
            type: "post",
            dataType: "json",
            success: function (data) {
                  (data);
                $(".pingjia span").text(data.length + "条评价");
                var pjnr = "";
                var pjxj = "";
                var pjsj = "";
                if(data.length != 0) {
                    for (var i = 0; i < data.length; i++) {
                        pjnr = data[i].itemPjnr;
                        pjxj = data[i].itemPjxj;
                        pjsj = new Date(data[i].itemPjsj).format("yyyy年MM月dd日") + "";
                        var userwx = data[i].itemUserid.wechatInfo[0].tlkWechatuserEntity;

                        var html = '<div class="list">'+
                                ' <div class="content-left"><img class="img" src='+userwx.headimgurl+'></div> <div class="content-right">'+
                                ' <span class="nicheng">'+userwx.nickname+'</span>'+
                                '<div class="xingxing">';
                        for(var i=0;i<pjxj;i++)
                        {
                            html+='<img class="wujiaoxing" src="../images/sheyingshi/star-full.svg">';
                        }
                        html += '</div>'+
                                ' <div class="center"> <p class="pingjialeirong">'+pjnr+'</p>'+
                                ' </div> <div class="bottom"><p class="time">'+pjsj+'</p>'+
                                ' </div> </div> </div>';

                        $(".mui-content").append(html);
                    }
                }
                else {
                    $(".mui-content").append('<div class="kong">&nbsp;&nbsp;&nbsp;暂无评价信息</div>');

                }
            }
        });
    }
</script>

</body>
</html>
