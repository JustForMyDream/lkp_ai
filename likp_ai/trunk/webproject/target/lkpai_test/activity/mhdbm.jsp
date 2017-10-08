<%--
  Created by IntelliJ IDEA.
  User: 审判之月
  Date: 2017/1/2
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>活动报名页面</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <link href="../css/mui.min.css" rel="stylesheet"/>
    <link href="../css/base.css" rel="stylesheet">
    <link href="../css/mui.picker.css" rel="stylesheet"/>
    <link href="../css/mui.poppicker.css" rel="stylesheet"/>
    <link href="<%=basePath%>activity/Common.css" rel="stylesheet"/>
    <style type="text/css">
        .button-extend {
            width: 50%;
            float: left;
            background-color: white!important;
        }

        .buttongroup {
            width: 100%;
            height: auto;
            display: none;
        }
        .input-row.select:after{
            top: 10px;
        }
        .mui-btn:enabled:active{
            color: #333;
            background-color: rgb(255,227,62);
        }
        .input-row > label{
            vertical-align: middle;
        }
        .tishi{
            bottom: 0;
            position: fixed;
            width: 100%;
            height: 100%;
            background: rgba(0,0,0,0.5);
            display: none;
        }
        .erweima{
            width: 80%;
            position: relative;
            text-align: center;
            background-color: #FFF;
            margin: 0 auto;
            padding: 12px 6px;
            border-radius: 5px;
        }
        .shuaxin{
            width: 100%;
            text-align: center;
        }
        .shuaxin > button{
            width: 50%;
            color: black;
            background-color: #ffe33e;
            line-height: 24px;
            border: 0;
            box-shadow: 0 1.5px 1px 0 rgba(41, 51, 43, 0.43)
        }
        .mark{
            display: none;
            position: fixed;
            top:0;;
            right: 0;
            left: 0;
            bottom: 0;
            background-color: rgba(0,0,0,0.2);
            z-index: 999;
        }
        .protocol{
            position: absolute;
            top: 50%;
            right: 50%;
            background:white;
            width: 280px;
            margin: -50% -140px;
            border-radius: 5px;
        }
        .protocol_header,.protocol-bottom{
            padding: 10px;
            text-align: center;
            margin: 0 auto;
        }
        .protocol_body{
            overflow: auto;
            background: #ffffff;
            padding: 5px 10px;
            text-align: left;
            word-wrap: break-word;
            height: 125px;
        }
        .protocol_body p{
            overflow: auto;
            font-size: 14px;
            color: black;
            word-wrap:break-word;
            word-break:normal;
        }
        .text-textarea{
            width: 78%;
            margin-left: 22%;
            resize:vertical;
            padding: 6px;
            margin-top: -32px;
            font-size: 13px;
            color: black;
            font-family: 微软雅黑;

        }
        button.yellow, #agree.yellow {
            color: black;
            background-color: #ffe33e;
            line-height: 19px;
            border: 0;
            box-shadow: 0 1.5px 1px 0 rgba(41, 51, 43, 0.43)
        }
    </style>
</head>
<body>

<div id="report" class="mark">
    <div class="protocol">
        <div class="protocol_header">
            报名须知
        </div>
        <div class="protocol_body">

        </div>
        <div class="protocol-bottom">
            <button id="disagree">不同意</button>
            <button id="agree" class="yellow">同意</button>
        </div>
    </div>
</div>


<header>
    <div class="header-content">

    </div>
</header>
<div class="content">
    <div class="title">·报名信息·</div>
    <div class="input-list">
        <div class="input-row">
            <label>您的姓名</label>
            <input type="text" name="itemName"  data-check='{"type":"text","voidCheck":true,"valueCheck":false}'/>
        </div>
        <div class="input-row">
            <label>您的性别</label>
            <select name="itemSex" data-check='{"type":"text","voidCheck":true,"valueCheck":false}'>
                <option value="1">女士</option>
                <option value="0">先生</option>
            </select>
        </div>
        <div class="input-row">
            <label>您的电话</label>
            <input name="itemLxfs" type="tel" data-check='{"type":"tel","voidCheck":true,"valueCheck":false}'/>
        </div>
    </div>
    <div class="input-list-extend" style="display: none">

    </div>
    <div class="button-row" >
        <button id="next" type="button" class="button">下一步</button>
    </div>
    <div class="buttongroup">
        <div class="button-row button-extend" ><button id="prev" type="button" class="button">上一步</button></div>
        <div class="button-row button-extend" ><button id="submit" type="button" class="button">提交报名</button></div>
    </div>
</div>
<div class="tishi">
    <div class="erweima">
        <img style="width: 100%;" src="../image/er_Wei.jpg">
        <p style=" color: gray;text-align: center;overflow: hidden;">你还没有关注该公众号,请长按二维码，关注后即可自动报名。</p>
        <%--<div class="shuaxin">--%>
            <%--<button>刷新页面</button>--%>
        <%--</div>--%>
    </div>
</div>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../js/mui.min.js"></script>
<script type="text/javascript" src="../js/getParam.js"></script>
<script type="text/javascript" src="../js/date.js"></script>
<script type="text/javascript" src="../js/server.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript">
    var id = GetQuery("id");
    //var id = "11e6-d891-56a4d823-aff6-6ff166f31966";
    //判断用户是否同意协议
    $("#agree").on("tap click",function () {
       $(".mark").hide();
    })
    $("#disagree").on("tap click",function () {
        $("#report").hide();
        window.location.href="../wechatuser/index.html";
    })
    wx.config({
        debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
        appId: '${appId}', // 必填，公众号的唯一标识
        timestamp: '${timestamp}', // 必填，生成签名的时间戳
        nonceStr: '${nonceStr}', // 必填，生成签名的随机串
        signature: '${signature}',// 必填，签名，见附录1
        jsApiList: ['downloadImage','chooseImage','uploadImage'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });
    function coverselect(obj){
        wx.chooseImage({
            count: 1, // 默认9
            sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function (res) {
                if(res.localIds.length>=1){
                    $(obj).parent().next("img").attr("src",res.localIds[0]).attr("data-cover",JSON.stringify({type:"user",src:res.localIds[0]}));
                    uploadCover($(obj).parent().next("img")[0]);
                }
            },
            fail: function (res) {

            }
        });
    }

    function uploadCover(obj){
        var coverData = JSON.parse($(obj).attr("data-cover"));
        if(coverData.type=="user"){
            wx.uploadImage({
                localId: coverData.src, // 需要上传的图片的本地ID，由chooseImage接口获得
                isShowProgressTips: 1, // 默认为1，显示进度提示
                success: function (res) {
                    var serverId = res.serverId; // 返回图片的服务器端ID
                    $(obj).attr("data-cover",JSON.stringify({type:"user",src:coverData.src,targetId:serverId}));
                }
            });
        }else{
            $(obj).attr("data-cover",JSON.stringify({type:"user",src:coverData.src,targetId:coverData.src}));
        }
    }
    $(function () {
        $.ajax({
            url: "../ActivityTemplate/hdmainpage",
            data: {id: id},
            type: "post",
            dataType: "json",
            timeout: "10000",
            success: function (data) {
                var itemHdxy = data.data1.itemHdxy;
                  (itemHdxy);
                if(itemHdxy==""){
                }
                else {
                    $(".mark").show();
                    $(".protocol_body").append("<p>"+itemHdxy+"</p>");
                }
                $(".header-content").html('<img id="poster" style="width: 100%" src="'+imgpre+ JSON.parse(data.data1.itemBmtp)[0].path+'" />');
            },
            error: function (e) {
                mui.toast(e);
            }
        });
        $.ajax({
            url: "../ActivityTemplate/firstpage",
            data: {id: id},
            type: "post",
            dataType: "json",
            timeout: "10000",
            success: function (data) {
                if(data.result == "null"){
                      ("1111111111");
                    $("#next").hide();
                    $(".content").append('<div class="button-row" ><button id="submitt" type="button" class="button">提交报名</button></div>');
                    $("#submitt").on("tap",function(){
                          ("111111111");
                        var items = $("input[type='text'],input[type='tel'],input[type='date'],input[type='datetime'],input[type='datetime-local'],input[type='number'],input[type='tel'],input[type='email'],input[type='radio']:selected,input[type='checkbox']:checked,textarea,select,img");
                        var flag = true;
                        for(var i=0;i<items.length;i++){
                            var dataCheck = $(items[i]).data("check");
                            if(dataCheck){
                                if(dataCheck.voidCheck){  ($(items[i]).get(0).tagName);

                                    if($(items[i]).get(0).tagName=="INPUT"&&$(items[i]).attr("type")){
                                        switch ($(items[i]).attr("type")){
                                            case "text":
                                                if($(items[i]).val() == null || $(items[i]).val() == undefined || $(items[i]).val() == '') {
                                                    mui.toast("为了更好地沟通和服务，请您完善以上信息，谢谢。");
                                                    flag=false;
                                                    return false;
                                                }
                                                break;
                                            case "number" :
                                                var re = /^[0-9]+.?[0-9]*$/;
                                                if (!re.test($(items[i]).val())){
                                                    mui.toast("为了更好地沟通和服务，请正确的填写"+$(items[i]).prev("label").text()+"，谢谢。");
                                                    flag=false;
                                                    return false;
                                                }
                                                break;
                                            case "tel":
                                                var re = /^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
                                                if (!re.test($(items[i]).val()))
                                                {
                                                    mui.toast("为了更好地沟通和服务，请正确的填写"+$(items[i]).prev("label").text()+"，谢谢。");
                                                    flag=false;
                                                    return false;
                                                }
                                                break;
                                            case "email":
                                                var re=/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
                                                if (!re.test($(items[i]).val()))
                                                {
                                                    mui.toast("为了更好地沟通和服务，请正确的填写"+$(items[i]).prev("label").text()+"，谢谢。");
                                                    flag=false;
                                                    return false;
                                                }
                                                break;
                                            default :
                                                if($(items[i]).val() == null || $(items[i]).val() == undefined || $(items[i]).val() == '') {
                                                    mui.toast("为了更好地沟通和服务，请您完善以上信息，谢谢。");
                                                    flag=false;
                                                    return false;
                                                }
                                                break;
                                        }
                                    }else if($(items[i]).get(0).tagName=="SELECT"){
                                        if($(items[i]).val() == null || $(items[i]).val() == undefined || $(items[i]).val() == '') {
                                            mui.toast("为了更好地沟通和服务，请您完善以上信息，谢谢。");
                                            flag=false;
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                        if(flag){
                            var data = {
                                id:id
                            };
                            var items = $("input[type='text'],input[type='tel'],input[type='date'],input[type='datetime'],input[type='datetime-local'],input[type='number'],input[type='tel'],input[type='email'],input[type='radio']:selected,input[type='checkbox']:checked,textarea,select,.input-row img.fileList");
                            var bmxq = [];/*报名详情*/
                            for(var i=0;i<items.length;i++){
                                  (items[i].tagName);
                                if($(items[i]).val() != null && $(items[i]).val() != undefined && $(items[i]).val() != ''&&items[i].tagName!="IMG")
                                {
                                    if($(items[i]).attr("name") != null && $(items[i]).attr("name") != undefined && $(items[i]).attr("name") != '')
                                    {
                                        data[$(items[i]).attr("name")]=$(items[i]).val();
                                    }else{
                                        bmxq.push({name:$(items[i]).attr('data-name'),val:$(items[i]).val(),type:"string"});
                                    }
                                }else if(items[i].tagName=="IMG"){
                                    bmxq.push({name:$(items[i]).attr('data-name'),val:JSON.parse($(items[i]).attr("data-cover")).targetId,type:"img"});
                                }
                            }
                            data["itemBmxq"] =JSON.stringify(bmxq);
                            $.ajax({
                                url:"../ActivityTemplate/savebmxx",
                                type:"get",
                                data:data,
                                dataType:"json",
                                success:function (data) {
                                      ("555555555555555555");
                                    if(data.subscribe == false){
                                        $(".tishi").css("display","block");
                                        var windowHeight = $(window).height();
                                        var picHeight = $(".erweima").height();
                                        var height = (windowHeight - picHeight)/2;
                                        $(".erweima").css("margin-top",height);
                                    }
                                    if(data.result=="success"){
                                        mui.alert("客服将尽快与您联系，感谢您的支持","报名成功","确定",function(){
                                            window.location.href="http://www.91lkp.com<%=path%>/ActivityTemplate/info?id="+id;
                                        });
                                    }else{
                                        if(data.resultcode=="404"){
                                            mui.alert("您已经太长时间未操作了，请重新进入此页面","操作失败","确定");
                                        }else if(data.resultcode=="302"){
                                            mui.alert("重复报名，您已经报名过了","报名结果","确定",function(){
                                                window.location.href="http://www.91lkp.com<%=path%>/ActivityTemplate/info?id="+id;
                                            });
                                        }
                                    }
                                },
                                error:function(){
                                      ("444444444444444444");
                                    mui.alert("网络错误，提交信息失败","网络错误","确定");
                                }
                            })
                        }
                    });
                }
                else
                {
                    var clicknum = 0;
                    $("#next").on('tap',function () {
                        $(".input-list").hide();
                        $("#next").hide();
                        $(".input-list-extend").show();
                        $(".buttongroup").show();
                        var html ="";
                        for(var i in data)
                        {
                            /*{"type":"text","voidCheck":true,"valueCheck":false}*/
                              ("419"+i);
                            html += '<div class="input-row"><label  style="margin-right: 3px; margin-top: -9px;">'+data[i].itemBmzdmc+'</label>';
                            html += getLX(data[i].itemBmzdmc,data[i].itemBmzdlx,data[i].itemSfbt)+'</div>';
                        }
                        if(clicknum ==0) {
                            $(".input-list-extend").append(html);
                            clicknum++;
                        }
                       $(".fileElem button").on("tap",function (e) {
                           coverselect(e.target);
                       })
                    });
                    $("#prev").on('tap',function () {
                        $(".input-list").show();
                        $("#next").show();
                        $(".input-list-extend").hide();
                        $(".buttongroup").hide();
                    });
                }
            },
            error: function (e) {
             mui.toast(e);
            }
        });
    });
    /*得到联系方式():名称，类型，是否必填*/
    var getLX =  function (name,lx,sfbt) {
        var ht='';
        /*[type='text'][type='tel'][type='date'][type='datetime'][type='datetime-local'][type='number'][type='tel'][type='email'][type='radio']:selected,input[type='checkbox']:checked,textarea,select");*/
        if(lx == "string")
        {
            if(sfbt == "true") {
                ht += '<input type="text" data-name="'+name+'"  data-check=' + '{"type":"text","voidCheck":true,"valueCheck":false}"' + '/>'
            }else{
                ht += '<input type="text" data-name="'+name+'"  data-check=' + '{"type":"text","voidCheck":false,"valueCheck":false}"' + '/>'
            }
        }else if(lx == "date") {
            if(sfbt == "true") {
                ht += '<input type="date" data-name="'+name+'"  data-check=' + '{"type":"text","voidCheck":true,"valueCheck":false}"' + '/>'
            }else{
                ht += '<input type="date" data-name="'+name+'"  data-check=' + '{"type":"text","voidCheck":false,"valueCheck":false}"' + '/>'
            }
        }else if(lx == "datetime") {
            if(sfbt == "true") {
                ht += '<input type="datetime" data-name="'+name+'"  data-check=' + '{"type":"text","voidCheck":true,"valueCheck":false}"' + '/>'
            }else{
                ht += '<input type="datetime" data-name="'+name+'"  data-check=' + '{"type":"text","voidCheck":false,"valueCheck":false}"' + '/>'
            }
        }else if(lx == "datetime-local") {
            if(sfbt == "true") {
                ht += '<input type="datetime-local" data-name="'+name+'"  data-check=' + '{"type":"text","voidCheck":true,"valueCheck":false}"' + '/>'
            }else{
                ht += '<input type="datetime-local" data-name="'+name+'"  data-check=' + '{"type":"text","voidCheck":false,"valueCheck":false}"' + '/>'
            }
        }
        else if(lx == "number") {
            if(sfbt == "true") {
                ht += '<input type="number" data-name="'+name+'"  data-check=' + '{"type":"text","voidCheck":true,"valueCheck":false}"' + '/>'
            }else{
                ht += '<input type="number" data-name="'+name+'"  data-check=' + '{"type":"text","voidCheck":false,"valueCheck":false}"' + '/>'
            }
        }else if(lx == "tel") {
            if(sfbt == "true") {
                ht += '<input type="tel" data-name="'+name+'"  data-check=' + '{"type":"text","voidCheck":true,"valueCheck":false}"' + '/>'
            }else{
                ht += '<input type="tel" data-name="'+name+'"  data-check=' + '{"type":"text","voidCheck":false,"valueCheck":false}"' + '/>'
            }
        }else if(lx == "email") {
            if(sfbt == "true") {
                ht += '<input type="email" data-name="'+name+'"  data-check=' + '{"type":"text","voidCheck":true,"valueCheck":false}"' + '/>'
            }else{
                ht += '<input type="email" data-name="'+name+'"  data-check=' + '{"type":"text","voidCheck":false,"valueCheck":false}"' + '/>'
            }
        }
        else if(lx == "text"){
            if(sfbt == "true"){
                ht +='<textarea class="text-textarea" placeholder="描述不低于200字"  rows="3" cols="20" data-name="'+name+'"  data-check=' + '{"type":"text","voidCheck":true,"valueCheck":false}"'+'></textarea>'
//                ht +='<textarea style="width: 78%;margin-left: 21%;resize:vertical;margin-top: -18px;font-size: 13px;color: black"  rows="3" cols="20" data-name="'+name+'"  data-check=' + '{"type":"text","voidCheck":true,"valueCheck":false}"'+'></textarea>'
            }else {
//                ht +='<textarea style="width: 78%;margin-left: 21%;resize:vertical;margin-top: -18px;font-size: 13px;color: black"   rows="3" cols="20" data-name="'+name+'"  data-check=' + '{"type":"text","voidCheck":true,"valueCheck":false}"'+'></textarea>'
                ht +='<textarea class="text-textarea" placeholder="描述不低于200字" rows="3" cols="20" data-name="'+name+'"  data-check=' + '{"type":"text","voidCheck":true,"valueCheck":false}"'+'></textarea>'
            }
        }
        else if(lx == "img"){
            if(sfbt == "true"){
                ht += '<div class="fileElem" ' + '><button style="margin-left: 17%;position: absolute;top: 0px;' +
                        'width: 65%;background: white;border-radius: 7px;border: none">从手机中选择</button></div><img src=""  class="fileList" style="width: 200px;margin-left: 24%;" data-name="'+name+'"  data-check=' + '{"type":"text","voidCheck":true,"valueCheck":false}"' + '/>'
            }
            else {
                ht += '<div class="fileElem" ' + '><button style="margin-left: 17%;position: absolute;top: 0px;' +
                        'width: 65%;background: white;border-radius: 7px;border: none">从手机中选择</button></div><img src=""  class="fileList" style="width: 200px;margin-left:24%;" data-name="'+name+'"  data-check=' + '{"type":"text","voidCheck":true,"valueCheck":false}"' + '/>'
            }
        }
        return ht ;
    }


    //var hdbh="11e6-c44c-2c9e0275-9fa2-219460512774";
    var inputRoww=$(".input-row");
    for(var i=0;i<inputRoww.length;i++){
        if($(inputRoww[i]).find("select").length>0){
            $(inputRoww[i]).addClass("select");
        }
    }

       $("#submit").on("tap",function(){
             ("111111111");
           var items = $("input[type='text'],input[type='tel'],input[type='date'],input[type='datetime'],input[type='datetime-local'],input[type='number'],input[type='tel'],input[type='email'],input[type='radio']:selected,input[type='checkbox']:checked,textarea,select,img");
           var flag = true;
           for(var i=0;i<items.length;i++){
               var dataCheck = $(items[i]).data("check");
               if(dataCheck){
                   if(dataCheck.voidCheck){  ($(items[i]).get(0).tagName);

                       if($(items[i]).get(0).tagName=="INPUT"&&$(items[i]).attr("type")){
                           switch ($(items[i]).attr("type")){
                               case "text":
                                   if($(items[i]).val() == null || $(items[i]).val() == undefined || $(items[i]).val() == '') {
                                       mui.toast("为了更好地沟通和服务，请您完善以上信息，谢谢。");
                                       flag=false;
                                       return false;
                                   }
                                   break;
                               case "number" :
                                   var re = /^[0-9]+.?[0-9]*$/;
                                   if (!re.test($(items[i]).val())){
                                       mui.toast("为了更好地沟通和服务，请正确的填写"+$(items[i]).prev("label").text()+"，谢谢。");
                                       flag=false;
                                       return false;
                                   }
                                   break;
                               case "tel":
                                   var re = /^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
                                   if (!re.test($(items[i]).val()))
                                   {
                                       mui.toast("为了更好地沟通和服务，请正确的填写"+$(items[i]).prev("label").text()+"，谢谢。");
                                       flag=false;
                                       return false;
                                   }
                                   break;
                               case "email":
                                   var re=/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
                                   if (!re.test($(items[i]).val()))
                                   {
                                       mui.toast("为了更好地沟通和服务，请正确的填写"+$(items[i]).prev("label").text()+"，谢谢。");
                                       flag=false;
                                       return false;
                                   }
                                   break;
                               default :
                                   if($(items[i]).val() == null || $(items[i]).val() == undefined || $(items[i]).val() == '') {
                                       mui.toast("为了更好地沟通和服务，请您完善以上信息，谢谢。");
                                       flag=false;
                                       return false;
                                   }
                                   break;
                           }
                       }else if($(items[i]).get(0).tagName=="SELECT"){
                           if($(items[i]).val() == null || $(items[i]).val() == undefined || $(items[i]).val() == '') {
                               mui.toast("为了更好地沟通和服务，请您完善以上信息，谢谢。");
                               flag=false;
                               return false;
                           }
                       }
                   }
               }
           }
           if(flag){
               var data = {
                   id:id
               };
               var items = $("input[type='text'],input[type='tel'],input[type='date'],input[type='datetime'],input[type='datetime-local'],input[type='number'],input[type='tel'],input[type='email'],input[type='radio']:selected,input[type='checkbox']:checked,textarea,select,.input-row img.fileList");
               var bmxq = [];/*报名详情*/
               for(var i=0;i<items.length;i++){
                     (items[i].tagName);
                   if($(items[i]).val() != null && $(items[i]).val() != undefined && $(items[i]).val() != ''&&items[i].tagName!="IMG")
                   {
                       if($(items[i]).attr("name") != null && $(items[i]).attr("name") != undefined && $(items[i]).attr("name") != '')
                       {
                           data[$(items[i]).attr("name")]=$(items[i]).val();
                       }else{
                           bmxq.push({name:$(items[i]).attr('data-name'),val:$(items[i]).val(),type:"string"});
                       }
                   }else if(items[i].tagName=="IMG"){
                       bmxq.push({name:$(items[i]).attr('data-name'),val:JSON.parse($(items[i]).attr("data-cover")).targetId,type:"img"});
                   }
               }
               data["itemBmxq"] =JSON.stringify(bmxq);
               $.ajax({
                   url:"../ActivityTemplate/savebmxx",
                   type:"get",
                   data:data,
                   dataType:"json",
                   success:function (data) {
                       if(data.subscribe == false){
                           $(".tishi").css("display","block");
                           var windowHeight = $(window).height();
                           var picHeight = $(".erweima").height();
                           var height = (windowHeight - picHeight)/2;
                           $(".erweima").css("margin-top",height);
                       }
                       if(data.result=="success"){
                           mui.alert("客服将尽快与您联系，感谢您的支持","报名成功","确定",function(){
                               window.location.href="http://www.91lkp.com<%=path%>/ActivityTemplate/info?id="+id;
                           });
                       }else{
                           if(data.resultcode=="404"){
                               mui.alert("您已经太长时间未操作了，请重新进入此页面","操作失败","确定");
                           }else if(data.resultcode=="302"){
                               mui.alert("重复报名，您已经报名过了","报名结果","确定",function(){
                                   window.location.href="http://www.91lkp.com<%=path%>/ActivityTemplate/info?id="+id;
                               });
                           }
                       }
                   },
                   error:function(){
                       mui.alert("网络错误，提交信息失败","网络错误","确定");
                   }
               })
           }
       });

//    $(".shuaxin button").on("tap",function () {
//        window.location.reload();
//    })

</script>
</body>
</html>
