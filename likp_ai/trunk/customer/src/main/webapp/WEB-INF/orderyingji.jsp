<%--
  Created by IntelliJ IDEA.
  User: 审判之月
  Date: 2016/11/27
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path ;
%>
<html>
<head>
    <title>影集设置</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>/css/likepai.css">
    <script src="<%=basePath%>/js/jquery-3.1.1.min.js"></script>
    <script src="<%=basePath%>/js/sockjs-0.3.4.min.js"></script>
    <script src="<%=basePath%>/js/weburl.js"></script>
    <style>

        ::-webkit-scrollbar{width:0;}
        html,body{
            width: 100%;
            height: 100%;
            font-family: "Microsoft YaHei UI", "微软雅黑";
        }
        .content{
            overflow: hidden;
            height: 100%;
        }
        .content>div{
            float: left;
        }
        .content .userinfo{
            text-align: center;
            height: 100%;
            width: 270px;
            background-color: #DCDCDC;
        }
        .item-content{
            border: 2px solid #D4D4D4;
            box-shadow: 0.3px 2px 3px 0px #D4D4D4;
            border-radius: 31px;
            margin-top: 100px;
            margin-top: 80px;
            width: 400px;
            height: 410px;
            display: none;
            overflow: hidden;
        }
        .item-content.active{
            display: block;
        }
        .item-content .item-head{
            padding: 10px;
            width: 100%;
            text-align: center;
        }
        .item-content .item-body{
            height: calc(100% - 40px);
            border: 1px solid #D4D4D4;
            overflow: auto;
        }
        .oprate{
            width: calc(100% - 270px);
            height: 100%;
            background-color: #ffffff;
        }
        .oprate>div{
            display: inline-block;
            height: 100%;
            overflow: auto;
        }
        @media screen and(max-width:1064px ){
            .oprate>div:nth-child(1){
                display: inline-block;
                min-width: 203px;
                width: 35%;
                height: 100%;
            }
            .oprate>div:nth-child(2){
                min-width: 400px;
                width: 64%;
            }
        }
        @media screen and (min-width: 1065px){
            .oprate>div:nth-child(1){
                display: inline-block;
                min-width: 300px;
                width: 40%;
                height: 100%;
            }
            .oprate>div:nth-child(2){
                min-width: 400px;
                width: 56%;
            }
        }
        .phone-content{
            height: 390px;
            width: 203px;
            border: 2px solid #D4D4D4;
            box-shadow: 0.3px 2px 3px 0px #D4D4D4;
            border-radius: 31px;
            float: right;
            margin-top: 100px;
        }
        .phone-head>.tuxing1{
            width: 6px;
            height: 6px;
            background: #121212;
            -moz-border-radius: 3px;
            -webkit-border-radius: 3px;
            border-radius: 3px;
            margin-left: 101px;
            margin-top: 5px;
        }
        .phone-head > .tuxing2 {
            width: 10px;
            height: 10px;
            background: #121212;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            margin-left: 55px;
            margin-top: 9px;
            float: left;
        }

        .phone-head> .tuxing3 {
            width: 50px;
            height: 10px;
            background: #121212;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            border-radius: 5px;
            margin-left: 80px;
            margin-top: 9px;
        }
        .phone-body{
            width: 100%;
            height: calc(100% - 60px);
            border: 1px solid #D4D4D4;
            margin-top: 10px;
            overflow: auto;
        }
        .phone-body img{
            width: 100%;
            vertical-align: middle;
        }
        .phone-body input,.phone-body textarea{
            width: 100%;
        }
        .btn-switch{
            width: 40px;
            height: 80px;
            margin-top: 245px;
        }
        .btn-switch>a{
            display: block;
        }
        .img_music>div{
            float:left;
        }
        .phone-body .cover{
            position: relative;
        }
        .phone-body .cover>input{
            position: absolute;
            bottom: 5px;
        }
        .img-item {
            background-color: #ffffff;
            display: inline-block;
            width: 94px;
            height: 94px;
            padding: 1px;
            border:1px solid  #DCDCDC;
            overflow: hidden;
            position: relative;
        }
        #piccontent{
        }
        .img-item>img{
            max-height: 94px;
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
        .img-item:before{
            content: '';
            display: block;
            position: absolute;
            width: 20px;
            height: 20px;
            background: rgba(0,0,0,0) url('<%=basePath%>/image/unselect_gray_small.png') no-repeat center;
            background-size: contain;
            z-index: 1;
        }
        .img-item.selected:before{
            background-image: url('<%=basePath%>/image/select_yellow_small.png');
        }
        .music-item{
            list-style: none;
            display: block;
            padding: 5px 20px;
            border-bottom:1px solid  #DCDCDC;
        }
        .music-item>a{
            color: #CDCDCD;
            cursor: pointer;
        }
        .music-item.active{
            color: #ffffff;
            background-color: rgb(235, 185, 125);
        }
        .music-item.active>a{
            color: #ffffff;
        }
        #headImgurl{
            text-align: center;
            margin: 40px auto 20px;
            border-radius: 100%;
        }
        #nickname{
            margin: 10px auto;
            text-align: center;
        }
        #save{
            border: 0;
            padding: 0 15px;
            margin: 0 auto;
            height: 30px;
            line-height: 30px;
            vertical-align: middle;
            color: white;
            font-size: 16px;
            text-align: center;
            background-color: rgb(235, 185, 125);
        }
        #orderlist{
            margin-top: 20px;
            display: block;
            color: #000000;
        }
        .bttn{
            background-color: #5C5B59;
            opacity: 0.6;
            border-radius: 0px;
            position: absolute;
            top: 56px;
            width: 92px;
            margin-left: 0px;
            height: 37px;
            display: none;
        }
        .bttn>.wenzi{
            color: white;
            font-size: 12px;
            margin-top: 10px;
            padding-left: 22px;
        }

    </style>
<body>
<div class="content">
    <div class="userinfo">
        <img style="width: 40px" id="headImgurl" />
        <div id="nickname">
            <%--昵称--%>
        </div>
        <button id="save">
            保存
        </button>
        <a id="orderlist" href="order?id=${id}">返回订单列表</a>
    </div>
    <div class="oprate">
        <div class="phone">
            <div class="phone-content">
                <div class="phone-head">
                    <div class="tuxing1"></div>
                    <div class="tuxing2"></div>
                    <div class="tuxing3"></div>
                </div>
                <div class="phone-body">
                    <div class="cover">
                        <img src="http://placehold.it/400x300?text=请选择图片"/>
                        <input type="text" placeholder="请输入标题"/>
                    </div>
                    <div class="des">
                        <textarea rows="3" placeholder="请输入描述"></textarea>
                    </div>
                    <div class="pic"></div>
                </div>
            </div>
        </div>
        <div class="img_music">
            <div class="btn-switch">
                    <a href="#pics" class="showpic">
                        <img id="showpic" style="margin-left: 2px;" width="30px" src="<%=basePath%>/image/tupianshezhi.png">
                    </a>
                    <a  href="#musics" class="showimg">
                        <img id="showmusic" style="margin-left: 2px;" width="30px" src="<%=basePath%>/image/yinyuesehzhi.png">
                    </a>
            </div>
            <div id="pics" class="item-content active">
                <div class="item-head">
                    图片设置
                </div>
                <div id="piccontent" class="item-body">

                </div>
            </div>
            <div id="musics" class="item-content">
                <div class="item-head">
                    音乐选择
                </div>
                <div class="item-body">
                    <li class="music-item active">
                        <a data-music="http://www.91lkp.com:80/lkpai_test/bgm/Peerless 2x2 - Canon (Over a Basso Ostinato)  钢琴二重奏版卡农.mp3">钢琴二重奏版卡农</a>
                    </li>
                    <li class="music-item">
                        <a data-music="http://www.91lkp.com:80/lkpai_test/bgm/summer.mp3">summer</a>
                    </li>
                    <li class="music-item">
                        <a data-music="http://www.91lkp.com:80/lkpai_test/bgm/四季 音色 - 春日.mp3">四季 音色 - 春日</a>
                    </li>
                    <li class="music-item">
                        <a data-music="http://www.91lkp.com:80/lkpai_test/bgm/文武贝 - 冬之韵.mp3">文武贝 - 冬之韵</a>
                    </li>
                    <li class="music-item">
                        <a data-music="http://www.91lkp.com:80/lkpai_test/bgm/晚秋.mp3">晚秋</a>
                    </li>
                    <li class="music-item">
                        <a data-music="http://www.91lkp.com:80/lkpai_test/bgm/爱情转移.mp3">爱情转移</a>
                    </li>
                    <li class="music-item">
                        <a data-music="http://www.91lkp.com:80/lkpai_test/bgm/秋日的私语.mp3">秋日的私语</a>
                    </li>
                    <li class="music-item">
                        <a data-music="http://www.91lkp.com:80/lkpai_test/bgm/骆集益 - 1945.mp3">骆集益 - 1945</a>
                    </li>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script>
    var id='${id}';
    $(function(){
        loadData();
        $(".btn-switch img").on("click",function(e){
            e.preventDefault();
            e.stopPropagation();
            var target = e.target.parentNode.href.substring(this.parentNode.href.lastIndexOf("#"));
            $(".item-content").hide();
            $(target).show();
        });
        var newimage1 = new Image();
        var newimage2 = new Image();
        var oldimage1 = $("#showpic").attr('src');
        var oldimage2 = $("#showmusic").attr('src');
        newimage1.src = "<%=basePath%>/image/tupianshezhi-1.png";
        newimage2.src = "<%=basePath%>/image/yinyueshezhi-1.png"
        $("#showpic").mouseover(function (e) {
            $("#showpic").attr('src',newimage1.src);
        })
        $("#showpic").mouseout(function (e) {
            $("#showpic").attr('src',oldimage1);
        })
       $("#showmusic").mouseover(function (e) {
           $("#showmusic").attr('src',newimage2.src);
       })
        $("#showmusic").mouseout(function (e) {
           $("#showmusic").attr('src',oldimage2);
        })
        $("#piccontent").on("click",".img-item img",function(e){
            var $target = $(e.target).parent();
            $target.toggleClass("selected");
            if($target.hasClass("selected")){
                $(".pic").append($("<img id=\""+$(e.target).parent().attr("data-id")+"\" src=\""+$(e.target).attr("src")+"\" />"));
                console.log($(".pic>img").length);
                if($(".pic>img").length==1){
                    $(".cover img").attr("src",$(e.target).attr("src"));
                }
            }else{
                $("#"+$(e.target).parent().attr("data-id")).remove();
                $(".cover img").attr("src",$(".pic>img").attr("src"));
            }
        });
        $(".music-item").on("click",function(e){
            $(".music-item").removeClass("active");
            $(e.target).addClass("active");
        });
        $("#save").on("click",function(){
            var title = $(".cover input").val();
            var des = $(".des textarea").val();
            if(title==null||title.trim(" ")==""){
                alert("请输入标题!");
                return;
            }else  if(des==null||des.trim(" ")==""){
                alert("请输入描述!");
                return;
            }else{
                var pic = $(".pic img");
                if(pic.length==0){
                    alert("请输入选择图片!");
                    return;
                }
                else{
                    var arr = [];
                    for(var i=0;i<pic.length;i++){
                        arr.push(pic[i].id);
                    }
                    $.ajax({
                        url:"ajax/createYingji",
                        data:{
                            id:id,
                            title:title,
                            des:des,
                            pic:arr,
                            music:$(".music-item.active").children("a").attr("data-music")
                        },
                        traditional:true,
                        dataType:"json",
                        type:"post",
                        success:function(data){
                            if(data.result == "success"){
                                alert("创建影集成功");
                            }
                            else{
                                alert("创建影集失败");
                            }
                            console.log(data);
                        },
                        error:function (e){

                        }
                    });
                }
            }
        });
    });
    function loadData(){
        $.get(ajaxurl.orderdetail, {id: id}, function (data) {
            var d = data.data;
            console.log(data);
            var name = d.itemSysid.itemName;
            var touxiang = d.itemSysid.itemOpenid.headimgurl;
            $("#headImgurl").attr("src",""+touxiang);
            $("#nickname").append(name);
            for(var i=0;i<d.orderproductimgEntities.length;i++){
                var $imgcontainer = $("#piccontent");
                var imgitem = $("<div class=\"img-item\" data-id=\""+d.orderproductimgEntities[i].id+"\" ><img src=\""+imgpre+JSON.parse(d.orderproductimgEntities[i].itemImgurl)[0].path+"\">" +
                        "<div class='bttn' id='bttn"+i+"'><P class='wenzi'>设为封面</P></div></div>");
                $imgcontainer.append(imgitem);
            }
            $(".img-item").css("cursor","pointer").mouseover(function(e) {
                if ($(e.currentTarget).hasClass("selected")){
                    $(e.currentTarget).children("div").css("display", "block");
                }
            });
            $(".img-item").css("cursor","pointer").mouseout(function(e) {
                $(e.currentTarget).children("div").css("display", "none");
            });
            $(".bttn").css("cursor","pointer").on("click", function (e) {
                var cover =  $(e.target).parent().parent().find("img")[0].src;
                var coverid = $(e.target).parent().parent().attr("data-id");
                console.log(coverid);
                $(".cover img").attr("src", cover);
               var firstpic = $(".pic").find("img").first().attr("id");
                console.log(firstpic);
                swap(coverid,firstpic);
            });
            function swap(id1,id2) {
                var node1 = $(".pic img[id='"+id1+"']")[0];
                var node2 = $(".pic img[id='"+id2+"']")[0];
                nodeTmpe = node1.outerHTML;
                node1.outerHTML = node2.outerHTML;
                node2.outerHTML = nodeTmpe;
            }
        }, "json");
    }
</script>