<%--
Created by IntelliJ IDEA.
User: 审判之月
Date: 2016/12/22
Time: 15:38
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
    <title>立可拍</title>
    <link type="text/css" rel="stylesheet" href="../css/mui.min.css">
    <link type="text/css" rel="stylesheet" href="../css/base.css">
    <style>
        body, html{margin:0; padding:0; overflow:hidden;}
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
        .haha{
            z-index: 1;
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
        #img1 {position:absolute;}



    </style>
</head>
<body unselectable="on" onselectstart="return false;" class="mui-fullscreen">
<header class="mui-bar mui-bar-nav">
    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
    <button id="submit" type="button" class="mui-btn mui-btn-blue mui-btn-link mui-pull-right">完成</button>

    <div class="mui-title">分享图片</div>
</header>
<div class="mui-content main">
    <div class="printScreen">
        <div class="top-img">
            <div id="target" class="body">
                <div  style="
    width: 100%;
    height: 100%;
    overflow: hidden;
    border: 0;
">
                    <img id="img1" src="../images/test3.jpg" />
                </div>
            </div>
            <%--<div id="target" class="body" style="text-align: center;">--%>
            <%--<img id="targetimg" src="../images/fengjing.png" style="text-align:center;height: auto; width: auto;top: 0px;left: 0px; " />--%>
            <%--</div>--%>
            <%--</div>--%>
            <img id="template" src="http://www.91lkp.com:8080/Z22629/uploads/item/2017/ba1d7aab-6a6b-4856-9589-ba56a31b4a9b.png" style="height: auto; width: 100%;">
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
<script type="text/javascript">
    var imgpre="http://www.91lkp.com:8080/Z22629";
    mui.init({});
    var orderid="297e9e7959500e4e015961f03a61001a";
    var imgsrc=null;
    var templetId = "11e6-d64a-bd178d3f-8d96-bf6bc9d71250";
    var start={"x1":0,"y1":278,"x2":1502,"y2":1668};
    var i=0;
    var temload=false;
    var targetload=false;
    wx.config({
        debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
        appId: 'wx41ae02856c6d39a6', // 必填，公众号的唯一标识
        timestamp: 1486902141, // 必填，生成签名的时间戳
        nonceStr: 'rFufYPIZbZ', // 必填，生成签名的随机串
        signature: '8915976A63C024269C2EBF333E41A5B376375236',// 必填，签名，见附录1
        jsApiList: ['getLocation', 'downloadImage', 'onMenuShareTimeline', 'onMenuShareAppMessage', 'hideMenuItems', 'chooseImage', 'uploadImage'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });


    $("#img1").on("load",function(e){
        var thisWidth=$(e.target).width();
        var thisHeight = $(e.target).height();
        var targetHeight=Math.abs(start.y1-start.y2)*$("#template").height()/$("#template")[0].naturalHeight;
        var targetWidth = Math.abs(start.x1-start.x2)*$("#template").height()/$("#template")[0].naturalHeight;
        $(e.target).css("margin","0px");
        if(thisWidth/thisHeight>=targetWidth/targetHeight) {
            $(e.target).css({width: "100%", height: "auto"});
            thisWidth=$(e.target).width();
            thisHeight = $(e.target).height();
            $(e.target).css({"margin-top": (targetHeight - thisHeight) / 2 + "px"})
        }else {
            $(e.target).css({height: "100%", width: "auto"});
            thisWidth=$(e.target).width();
            thisHeight = $(e.target).height();
            $(e.target).css({"margin-left": (targetWidth - thisWidth) / 2 + "px"})
        }



        var userAgent = navigator.userAgent.toLowerCase();
        // var isIpad = userAgent.match(/ipad/i) == "ipad";

        // if (!isIpad) alert('不是IPAD！');

        var oldX, oldY, startX, startY, startWidth, startHeight;
        var moveD;
        var isMove = false;
        var isZoom = false;
        var lastClickTime = 0;

        // 获取两点之间的距离
        function get_distance(x1, y1, x2, y2)
        {
            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 2);
        }

        function img_mousedown(e)
        {
            console.log("touchstart")
            if (e.target.id != 'img1') return;

            if (e.touches.length == 1)
            {
                var nowTime = Math.round(new Date().getTime() / 1000);
                x = $('#img1').position().left;
                y = $('#img1').position().top;
                if (nowTime - lastClickTime < 1 && Math.abs(x - startX) < 20 && Math.abs(y - startY) < 20)
                {
                    // 在1秒内连续点击同一地方。
                    alert('双击事件');
                }
                lastClickTime = nowTime;
            }
            else if (e.touches.length >= 2)
            {
                isMove = false;
                isZoom = true;
                x1 = e.touches[0].pageX;
                y1 = e.touches[0].pageY;
                x2 = e.touches[1].pageX;
                y2 = e.touches[1].pageY;

                startX = $('#img1').position().left;
                startY = $('#img1').position().top;
                startWidth = $('#img1').width();
                startHeight = $('#img1').height();

                moveD = get_distance(x1, y1, x2, y2);

                return;
            }
            isMove = true;
            oldX = e.touches[0].pageX;
            oldY = e.touches[0].pageY;
            startX = $('#img1').position().left;
            startY = $('#img1').position().top;
            e.preventDefault();
            e.stopPropagation();
            return false;
        }

        function img_mouseup(e)
        {
            console.log("touchend")
            if (e.target.id != 'img1') return;

            isZoom = false;
            isMove = false;
        }

        function img_mousemove(e)
        {
            console.log("touchmove")
            if (isZoom)
            {
                //targetTouches changedTouches touches
                if (e.touches.length >= 2)
                {
                    var x1, y1, x2, y2, d1;
                    x1 = e.touches[0].pageX;
                    y1 = e.touches[0].pageY;
                    x2 = e.touches[1].pageX;
                    y2 = e.touches[1].pageY;
                    d1 = get_distance(x1, y1, x2, y2);
                    var rate = d1 / moveD;
                    var w = startWidth * rate;
                    var h = startHeight * rate;
                    $('#img1').width(w);
                    $('#img1').height(h);
                    $('#img1').css('left', (startWidth - w) / 2 + startX + 'px');
                    $('#img1').css('top', (startHeight - h) / 2 + startY + 'px');
                }
                return;
            }
            if (!isMove) return;
            x = e.changedTouches[0].pageX - oldX;
            y = e.changedTouches[0].pageY - oldY;
            $('#img1').css('top', y + startY + 'px');
            $('#img1').css('left', x + startX + 'px');
        }
        $(function(){
            document.onmousemove = function (e)
            {
                var e = e || event;
                e.cancelBubble = true;
                e.returnValue = false;
            }
            // 防止触发浏览器的整体拖动
            document.body.addEventListener('touchmove', function (e)
            {
                e.preventDefault();
            }, false);

            document.addEventListener('touchstart', img_mousedown, false);
            document.addEventListener('touchend', img_mouseup, false);
            document.addEventListener('touchmove', img_mousemove, false);
        });



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
        if(document.querySelector("#img1").clientHeight!==0){
            $("#img1").trigger("load");
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
    $(".printScreen").on("tap",function(){
        if($("#submit").text()=='处理中.'){
            mui.toast("正在处理请耐心等待..");
            return;
        }else if($("#submit").text()=="分享成功"){
            mui.toast("您已经成功分享给用户");
            return;
        }
        wx.chooseImage({
            count: 1, // 默认9
            sizeType: ['original'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function (res) {
                imgsrc=res.localIds[0];
                $("#img1").attr("src",res.localIds[0]).trigger("load");
            },
            cancel: function () {
                mui.toast("还未选择任何图片！");
            }
        });
    });
    $("#submit").on("tap",function(){
        if($(this).text()=='处理中.'){
            mui.toast("正在处理请耐心等待..")
            return;
        }else if($(this).text()=="分享成功"){
            mui.toast("您已经成功分享给用户")
            return;
        }
        if(imgsrc){
            wx.uploadImage({
                localId: $("#img1").attr("src"), // 需要上传的图片的本地ID，由chooseImage接口获得
                isShowProgressTips: 1, // 默认为1，显示进度提示
                success: function (res) {
                    var serverId = res.serverId; // 返回图片的服务器端ID
                    (res);
                    $("#submit").text("处理中.");
                    mui.toast("正在生成图片请等待...");
                    $.ajax({
                        url:"../quickShare/shareToUserByOrderId",
                        data:{
                            orderid:orderid,
                            templetId:templetId,
                            serverId:serverId
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
                                mui.toast("图片分享成功，长按可保存图片..")
                            }else{
                                mui.toast(data.errorMsg);
                            }
                        },
                        error:function(data){

                        }
                    });
                },
                fail:function (res) {
                    mui.toast("图片上传失败:"+JSON.parse(res));
                    (res);
                }
            });
        }else{
            mui.toast("还未选择任何图片！");
        }
    });
</script>
</body></html>