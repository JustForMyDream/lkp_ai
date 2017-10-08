
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
    <title>立可拍</title>
    <link type="text/css" rel="stylesheet" href="../css/mui.min.css"/>
    <link type="text/css" rel="stylesheet" href="../css/base.css">
    <style>
        .mui-content{
            background-color: #FFFFFF;
        }
        .bottom{
            padding: 51px 0;
            text-align: center;
        }
        .bottom>img{
            width: 70px;
            height: auto;
            display: block;
            margin: 0 auto;
        }
        .main,.top-img{
            position: absolute;
            top:0;
            right:0;
            left:0;
            bottom:0;
            overflow: hidden;
        }
        .printScreen{
            position: relative;
            width: 100%;
            height: 100%;
        }
        .printScreen img{
            width: 100%;
        }
        .top-img{
            display: -webkit-flex;
            display: flex;
            align-items: center;
            justify-content: center;
            -webkit-box-align: center;
            -webkit-align-items: center;
            -webkit-box-pack: center;
            -webkit-justify-content: center;
        }
        .body{
            z-index: 0;
            position: absolute;
            display: inline-block;
            overflow: hidden;
        }

        .back{
            width:100%;
            height: 100%;
            display: -webkit-flex;
            display: flex;
            align-items: center;
            justify-content: center;
            -webkit-box-align: center;
            -webkit-align-items: center;
            -webkit-box-pack: center;
            -webkit-justify-content: center;
            background-color: rgba(0,0,0,0.2);
        }
        .back img{
            width: 100%;
        }
        .mui-bar .mui-btn-link{
            color: #000;
        }
        .mui-bar-nav.mui-bar .mui-icon{
            color: #000;
        }

        .muban{
            z-index: 0;
            position: relative;
            display: inline-block;
            overflow: hidden;
        }
        #targetimg {position:absolute;}
    </style>
</head>
<body class="mui-fullscreen">
<header class="mui-bar mui-bar-nav">
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
    <button id="submit" type="button" class="mui-btn mui-btn-blue mui-btn-link mui-pull-right">完成</button>

    <div class="mui-title">分享图片</div>
</header>
<div class="mui-content main">
    <div class="printScreen">
        <div class="top-img">
            <div id="target" class="body">
                <div class="muban" style="
    width: 100%;
    height: 100%;
    overflow: hidden;
    border: 0;
">
                    <img id="targetimg" src="../images/pic._071.png">
                </div>
            </div>
            <img id="template"  src="http://www.91lkp.com:8080/Z22629/uploads/item/2017/ba1d7aab-6a6b-4856-9589-ba56a31b4a9b.png">
            <div class="back" style="display: none">
                <img id="result" src="">
            </div>
        </div>
    </div>
</div>
<script src="../js/hidpi-canvas.min.js"></script>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/mui.min.js"></script>
<script src="../js/html2canvas.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
    var imgpre="http://www.91lkp.com:8080/Z22629";
    mui.init({});
    var orderid="${orderid}";
    var imgsrc=null;
    var templetId = "11e6-d64a-bd178d3f-8d96-bf6bc9d71250";
    var start={"x1":0,"y1":278,"x2":1502,"y2":1668};
    var i=0;
    var temload=false;
    var targetload=false;
    wx.config({
        debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
        appId: '${appId}', // 必填，公众号的唯一标识
        timestamp: ${timestamp}, // 必填，生成签名的时间戳
        nonceStr: '${nonceStr}', // 必填，生成签名的随机串
        signature: '${signature}',// 必填，签名，见附录1
        jsApiList: ['getLocation', 'downloadImage', 'onMenuShareTimeline', 'onMenuShareAppMessage', 'hideMenuItems', 'chooseImage', 'uploadImage'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });
    var top1 = 0.0;
    var left1 = 0.0;

    $("#targetimg").on("load",function(e){
        var thisWidth=$(e.target).width();
        var thisHeight = $(e.target).height();
        var targetHeight=Math.abs(start.y1-start.y2)*$("#template").height()/$("#template")[0].naturalHeight;
        var targetWidth = Math.abs(start.x1-start.x2)*$("#template").height()/$("#template")[0].naturalHeight;
        $(e.target).css("margin","0px");
        if(thisWidth/thisHeight>=targetWidth/targetHeight) {
            $(e.target).css({width: "auto", height: "100%"});
            thisWidth=$(e.target).width();
            $(e.target).css({"left": (targetWidth - thisWidth) / 2 + "px","top":"0"});
        }else {
            $(e.target).css({height: "auto", width: "100%"});
            thisHeight = $(e.target).height();
            $(e.target).css({"top": (targetHeight - thisHeight) / 2+"px","left":"0"});
        }

    });
    $("#template").on("load",function (e) {
        var thisWidth = $(e.target).width();
        var thisHeight = $(e.target).height();
        var parentWidth = e.target.parentNode.offsetWidth;
        var parentHeight = e.target.parentNode.offsetHeight;
        var naturalWidth = e.target.naturalWidth;
        var naturalHeight = e.target.naturalHeight;
        if(thisWidth/thisHeight>=parentWidth/parentHeight){
            $(this).css({height:"auto",width:"100%"});
        }else{
            $(this).css({height:"100%",width:"auto"});
        }
        $("#target").css("padding-top",$(e.target).height()/naturalHeight*start.y1+"px");
        $("#target").css("padding-right",$(e.target).width()/naturalWidth*(naturalWidth-start.x2)+"px");
        $("#target").css("padding-bottom",$(e.target).height()/naturalHeight*(naturalHeight-start.y2)+"px");
        $("#target").css("padding-left",$(e.target).width()/naturalWidth*start.x1+"px");
        $("#target").css({width:$(e.target).width()+"px",height:$(e.target).height()+"px"});
        if(document.querySelector("#targetimg").clientHeight!==0){
            $("#targetimg").trigger("load");
        }
    });
    if(document.querySelector("#template").clientHeight!==0&&!temload){
        $("#template").trigger("load");
    }


    $("#result").on("load",function(e){
        var thisWidth=$(e.target).width();
        var thisHeight = $(e.target).height();
        var parentWidth = e.target.parentNode.offsetWidth;
        var parentHeight = e.target.parentNode.offsetHeight;
        if(thisWidth/thisHeight>=parentWidth/parentHeight){
            $(this).css({height:"auto",width:"100%"});
        }else{
            $(this).css({height:"100%",width:"auto"});
        }
    });
    $("#targetimg").on("tap",function(){
        if($("#submit").text()=='处理中.'){
            mui.toast("正在处理请耐心等待..");
            return;
        }else if($("#submit").text()=="分享成功"){
            mui.alert("您已经成功分享给用户");
            return;
        }
        wx.chooseImage({
            count: 1, // 默认9
            sizeType: ['original'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function (res) {
                imgsrc=res.localIds[0];
                $("#targetimg").attr("src",res.localIds[0]).trigger("load");
                wx.uploadImage({
                    localId: $("#targetimg").attr("src"), // 需要上传的图片的本地ID，由chooseImage接口获得
                    isShowProgressTips: 1, // 默认为1，显示进度提示
                    success: function (res) {
                        var serverId = res.serverId; // 返回图片的服务器端ID
                        $("#targetimg").attr("src","../util/media?id="+serverId).attr("data-target",serverId).trigger("load");
                    },
                    fail:function (res) {
                        mui.toast("图片上传失败:"+JSON.parse(res));
                    }
                });
            },
            cancel: function () {
                mui.toast("还未选择任何图片！");
            }
        });
    });
    //添加touch事件
    var oldX,oldY,oldDistance,i1,oldPositionX,oldPositionY,oldHeight,oldWidth,oldScale;
    i1=0;
    var targetIMG = document.getElementById("targetimg");
    var MUBAN = document.getElementsByClassName("muban")[0];
    targetIMG.addEventListener("touchstart",function(e){
        e.preventDefault();
        var touch = e.touches;
        oldX = parseFloat(touch[0].pageX);
        oldY =  parseFloat(touch[0].pageY);
        oldPositionX = parseFloat(targetIMG.style.left);
        oldPositionY =  parseFloat(targetIMG.style.top);
        var MATRIX = $(targetIMG).css("transform");
        var transform =  MATRIX.replace("matrix(","").replace(")","").split(",");
        oldScale = transform[2];
        if(!oldScale||oldScale<=0){
            oldScale=1;
        }
        if(!oldPositionY){
            oldPositionY=0;
        }
        if(!oldPositionX){
            oldPositionX=0;
        }
        if(touch.length >= 2){
            var x1 = parseFloat(touch[0].pageX);
            var x2 = parseFloat(touch[1].pageX);
            var y1 = parseFloat(touch[0].pageY);
            var y2 = parseFloat(touch[1].pageY);
            oldDistance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 2)
        }
        return true;
    },{capture:true,passive:false});
    document.body.addEventListener("touchmove",function(e){
        e.preventDefault();
    },{capture:true,passive:false});
    targetIMG.addEventListener("touchmove",function(e){
        e.preventDefault();
        e.stopPropagation();
        var touch = e.touches;
        if(touch.length == 1){
            if(null==oldX||null==oldY){
                oldX = touch[0].pageX;
                oldY =  touch[0].pageY;
            }
            var transX = parseFloat(targetIMG.style.left);
            var transY =  parseFloat(targetIMG.style.top);
            if(!transY){
                transY=0;
            }
            if(!transX){
                transX=0;
            }
            var moveX = touch[0].pageX - oldX  + oldPositionX;
            var moveY = touch[0].pageY - oldY + oldPositionY;
            if((targetIMG.clientHeight-MUBAN.clientHeight)<Math.abs(moveY)||moveY>0){
                moveY = transY;
            }
            if((targetIMG.clientWidth-MUBAN.clientWidth)<Math.abs(moveX)||moveX>0){
                moveX = transX;
            }
            $(targetIMG).css({top:moveY+"px",left:moveX+"px"});
        }else if(touch.length >= 2){
            var step = 2 ;
            var x1 = touch[0].pageX;
            var x2 = touch[1].pageX;
            var y1 = touch[0].pageY;
            var y2 = touch[1].pageY;
            var newDistance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 2);
                var MATRIX = $(targetIMG).css("transform");
                var transform =  MATRIX.replace("matrix(","").replace(")","").split(",");
                if(targetIMG.style.width=="auto"){
                    var height = parseInt(targetIMG.clientHeight)+newDistance-oldDistance;
                    if(newDistance-oldDistance>0){
                        height +=step;
                    }else  if(newDistance-oldDistance<0){
                        height -=step;
                    }
                    if(height>=targetIMG.parentNode.clientHeight){
                        targetIMG.style.height=height;
                    }
                }else if(targetIMG.style.height=="auto"){
                    var width = parseInt(targetIMG.clientWidth)+newDistance-oldDistance;
                    if(newDistance-oldDistance>0){
                        width +=step;
                    }else  if(newDistance-oldDistance<0){
                        width -=step;
                    }
                    if(width>=targetIMG.parentNode.clientWidth){
                        targetIMG.style.width=width;
                    }
                }
                oldDistance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 2);
        }
        return false;
    },{capture:true,passive:true});
    targetIMG.addEventListener("touchend",function(e){
            oldX = null;
            oldY = null;
            oldDistance = null;
    },{capture:true,passive:false});
    $("#submit").on("tap",function(){
        if($(this).text()=='处理中.'){
            mui.toast("正在处理请耐心等待..")
            return;
        }else if($(this).text()=="分享成功"){
            mui.alert("您已经成功分享给用户")
            return;
        }
        if(imgsrc){
            var serverId = $("#targetimg").attr("data-target");
            var $temp = $("#template");
            $("#submit").text("处理中.");
            mui.toast("正在生成图片请等待...");
            var zoom = 1;
            var times = targetIMG.naturalWidth/targetIMG.clientWidth;
            if(targetIMG.style.height=="auto"){
                zoom = $("#template")[0].naturalHeight/$("#template").height()/times;
            }else{
                zoom = $("#template")[0].naturalHeight/$("#template").height()/times;
            }
            var locationX = -(parseFloat(targetIMG.style.left)*$("#template")[0].naturalHeight/$("#template").height());
            var locationY = -(parseFloat(targetIMG.style.top)*$("#template")[0].naturalHeight/$("#template").height());
            console.log([targetIMG.style.left,targetIMG.style.top]);
            if(!locationX){
                locationX = 0;
            }
            if(!locationY){
                locationY = 0;
            }
            $.ajax({
                url:"../quickShare/shareToUserByOrderId",
                data:{
                    orderid:orderid,
                    templetId:templetId,
                    serverId:serverId,
                    scale:zoom.toFixed(2),
                    transX:locationX.toFixed(2),
                    transY:locationY.toFixed(2)
                },
                type:"post",
                dataType:"json",
                success:function(data){
                    if(data.errorCode==200){
                        $("#submit").text("分享成功");
                        $("#result").attr("src",imgpre+data.data);
                        $(".back").show();
                        $("#target").hide();
                        $("#template").hide();
                        mui.alert("图片分享成功，长按可保存图片..")
                    }else{
                        mui.toast(data.errorMsg);
                    }
                },
                error:function(data){

                }
            });
        }else{
            mui.toast("还未选择任何图片！");
        }
    });
</script>
</body>
</html>