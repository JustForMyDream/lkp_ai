<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html lang="en">
<head>
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <meta charset="UTF-8">
    <link href="../css/mui.min.css" rel="stylesheet" />
    <link href="../css/sheyingshi.css" rel="stylesheet" />
    <link href="../css/base.css" rel="stylesheet">
    <title>摄影师-简介</title>
</head>
<style>
    .content{
        width: 100%;
        text-align: center;
        height: auto;
        background: white;
        padding-top: 20px;
        z-index: 1;
        line-height: 13px;
    }
    .guanyu{
        height: 40px;
        font-size: 16px;
        color: black;
        font-weight: bold;
    }
    .yuanquan{
        height:20px;
        width:23px;
        margin-bottom: -5px;
    }
    .pingjia{
        height: 60px;
        width: 100%;
        padding-top: 10px;
    }
    h2 {
        height: 2rem;
        line-height: 2rem;
        font-size: 16px;
        color: #222;
        position: relative;
    }
    h2>font {
        display: inline-block;
        width: 20%;
        height: 0.05rem;
        background: #AAAAAA;
        position: relative;
        top: 0.95rem;
        vertical-align: top;
    }
    h2>span {
        display: inline-block;
        margin: 0 auto;
        color: rgb(158,158,158);
        font-size: 15px;
        font-weight: normal;
    }
    .font2{
        font-size: 15px;
        color: rgb(158,158,158);
    }
    .touxiang2{
        width: 50px;
        height: 50px;
        border-radius: 50%;
    }

    .wujiaoxing{
        width: 15px;
        height:15px;
        margin-left: 1px;
        white-space:nowrap;
    }
    .gengduo{
        border: 1px #cccccc solid;
        border-radius: 25px;
        width: 116px;
        height: 37px;
        font-size: 15px;
        color: rgb(138,138,138);
        font-weight: bold;
    }

    .Triangle{
        width:0px;
        height:0px;
        border-top:14px solid  rgb(238,238,238);
        border-left:10px solid transparent;
        border-right:10px solid transparent;
        z-index:30;
        /*position: absolute;*/
        margin: -6px auto;
        position: absolute;
        margin: 0 -10px;
        left: 50%;
    }
    .pjxj{
        width: 100%;
        text-align: center;
    }
    .moddile>p{
        font-size: 15px;
        margin-top: 0;
        margin-bottom: 10px;
        color: #8f8f94;
        margin-top: 30px;
    }
    .detail{
        width: 85%;
        line-height: normal;
        margin: 0 auto;
    }
    .p1 {
        font-family: "微软雅黑";
        color: #fff;
        font-size: 16px;
         font-weight: normal;
    }
</style>
<body>
<div class="mui-content">
    <div class="up">
        <div class="mengban">
        </div>
        <div class="bg">
        </div>
        <div class="con_up1">
            <img src="../img/logo-ai_03.png" class="yuantu" />
            <p class="p1"></p>
        </div>
        <div class="con_up2">
            <ul>
                <li class="l2 fuwu">
                    <p class="pp2">服务</p>
                </li>

                <li class="l2 jianjie">
                    <p class="pp2 change_p" style="color: black;">简介</p>
                    <div class="Triangle"></div>
                </li>

                <li class="l2 zuoping">
                    <p class="pp2">作品</p>
                </li>

            </ul>
        </div>
        <div style="clear: both"></div>
    </div>
    <div class="content">
        <div class="guanyu">关于TA</div>
        <span class="font2 type"></span><span><img class="yuanquan" src=""></span>
        <div style="width: 100%; height: 10px;"></div>
        <p class="font2 detail"></p>
        <div class="pingjia">
            <h2>
                <font>&nbsp;</font>
                &nbsp;&nbsp;
                <span ></span>
                &nbsp;&nbsp;
                <font >&nbsp;</font>
            </h2>
        </div>
        <div class="pingjianeirong">
        <img class="touxiang2" src="../images/sheyingshi/fengjing.png">
        <div style="width: 100%; height: 10px;"></div>
        <p class="font2 name">静静</p>
        <p class="font2 time"></p>
        <div class="pjxj">
        </div>
        <div style="width: 100%; height: 15px;"></div>
        <p class="font2 leirong"></p>
        </div>
        <div style="width: 100%; height: 20px;"></div>
        <button class="gengduo">点击查看更多</button>
        <div style="width: 100%; height: 30px;"></div>

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

</div>

<script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="../js/mui.min.js"></script>
<script type="text/javascript" src="../js/getParam.js"></script>
<script type="text/javascript" src="../js/server.js"></script>
<script type="text/javascript" src="../js/date.js"></script>
<script>
    mui.init();
    var $mask = $(".mui-backdrop");
    var id = GetQueryString("id");
    var bh = "";
    $(".fuwu").on("tap",function () {
        window.location.href = "../MainPage/SysInfor?id=" + id;
    });
    $(".zuoping").on("tap",function () {
        window.location.href = "../wechatuser/sheyingshi-zuoping.jsp?id=" + id;
    });
      (id+"  "+bh);

    $(function () {
        jiazaitouxiang();
//        jiazaijianjie();
    });
    function jiazaitouxiang() {
        var html = "";
        $.ajax({
            url: "../sysPort/getSysinforBySysid",
            data: {"id": id},
            type: "post",
            dataType: "json",
            success: function (data) {
                var name = data.itemName;
                var img = data.itemHeadimg;
                var path = "";
                var type = data.itemSyshdlx;
                var sex = data.itemSex;
                var jianjie = data.itemGrjj;
                var Bgimg = data.Fmbjtp;
                var Bgimgpath = "";

                if(img){
                    path = imgpre + JSON.parse(img)[0].path;
                }else {
                    path = "../images/photographer.png";
                }

                bh = data.itemBh;
                  ("ascds"+bh);
                if(Bgimg){
                    Bgimgpath = imgpre + JSON.parse(Bgimg)[0].path;
                }else {
                    Bgimgpath = "../images/SysBg.jpg";
                }
                $(".bg").css("background","url("+Bgimgpath+")");
                $(".bg").css("background-size","100% 100%");
                $(".yuantu").attr("src",path);
                $(".p1").text(name);
                $(".type").text(type);

                $(".detail").text(jianjie);
                if(sex == '0') {
                      ("woshinamde");
                    $(".yuanquan").attr("src","../images/man.svg");
                } else{
                      ("wdhihcd");
                    $(".yuanquan").attr("src","../images/woman.svg");
                }

                  ("ascds1"+bh);
                $.ajax({
                    url: "../sysPort/getOrderBySysId",
                    data: {"id":bh},
                    type: "post",
                    dataType: "json",
                    success: function (data) {
                            $(".pingjia span").text(data.length + "条评价");
                        var pjnr = "";
                        var pjxj = "";
                        var pjsj = "";
                           if(data.length != 0) {
                                pjnr = data[0].itemPjnr;
                                pjxj = data[0].itemPjxj;
                                pjsj= new Date(data[0].itemPjsj).format("yyyy年MM月dd日") + "";
                                var userwx = data[0].itemUserid.wechatInfo[0].tlkWechatuserEntity;
                                $(".font2.name").text(userwx.nickname);
                                $(".touxiang2").attr("src",userwx.headimgurl);
                            }
                            else {
                               $(".pingjianeirong").css("display","none");

                            }
                            $(".time").text(pjsj);
                            $(".leirong").text(pjnr);
                              (pjxj);
                            for (var i = 0; i < pjxj; i++) {
                                $(".pjxj").append('<img class="wujiaoxing" src="../images/sheyingshi/star-full.svg">');
                            }
                        $mask.hide();
                    }
                });
                $(".gengduo").on("tap",function () {
                    window.location.href = "../wechatuser/SysComment.jsp?bh=" + bh;
                });
            }
        });
    }

</script>
</body>
</html>