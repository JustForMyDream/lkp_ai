<%--
  Created by IntelliJ IDEA.
  User: 审判之月
  Date: 2016/12/16
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>立可拍「爱与陪伴」家庭影像分享会</title>
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <link href="../css/mui.min.css" rel="stylesheet"/>
    <link href="../css/base.css" rel="stylesheet">
    <link href="../css/mui.picker.css" rel="stylesheet"/>
    <link href="../css/mui.poppicker.css" rel="stylesheet"/>
    <link href="Common.css" rel="stylesheet"/>
</head>
<body>
<header>
<div class="header-content">
    <img id="poster" src="../images/fengxianghui.png" />
  <%--  <div class="bottom-img">
        <img id="poster-bottom" class="blur" src="../image/support_2.jpg"/>
    </div>--%>
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
    <div class="button-row">
        <button id="submit" type="button" class="button">提交报名</button>
    </div>
</div>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/mui.min.js"></script>
<script>
    var hdbh="11e6-c44c-2c9e0275-9fa2-219460512774";
    var inputRoww=$(".input-row");
    for(var i=0;i<inputRoww.length;i++){
        if($(inputRoww[i]).find("select").length>0){
            $(inputRoww[i]).addClass("select");
        }
    }
    $("#submit").on("tap",function(){
        var items = $("input[type='text'],input[type='tel'],input[type='date'],input[type='datetime'],input[type='datetime-local'],input[type='number'],input[type='tel'],input[type='email'],input[type='radio']:selected,input[type='checkbox']:checked,textarea,select");
        var flag = true;
        for(var i=0;i<items.length;i++){
            var dataCheck = $(items[i]).data("check");
            if(dataCheck){
                if(dataCheck.voidCheck){
                      ($(items[i]).get(0).tagName);
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
                itemHdbh:hdbh
            };
            var items = $("input[type='text'],input[type='tel'],input[type='date'],input[type='datetime'],input[type='datetime-local'],input[type='number'],input[type='tel'],input[type='email'],input[type='radio']:selected,input[type='checkbox']:checked,textarea,select");
            for(var i=0;i<items.length;i++){
                if($(items[i]).val() != null && $(items[i]).val() != undefined && $(items[i]).val() != '')
                {
                    if($(items[i]).attr("name") != null && $(items[i]).attr("name") != undefined && $(items[i]).attr("name") != '')
                        data[$(items[i]).attr("name")]=$(items[i]).val();
                }
            }
            $.ajax({
                url:"../HONGDONG/saveyhhdbm",
                type:"get",
                data:data,
                dataType:"json",
                success:function (data) {
                    if(data.result=="success"){
                        mui.alert("客服将尽快与您联系，感谢您的支持","报名成功","确定",function(){
                            window.location.href="http://www.91lkp.com/lkpai_test/activityShortUrl/fengxianghuiInfo";
                        });
                    }else{
                        if(data.resultcode=="404"){
                            mui.alert("您已经太长时间未操作了，请重新进入此页面","操作失败","确定");
                        }else if(data.resultcode=="302"){
                            mui.alert("重复报名，您已经报名过了","报名结果","确定",function(){
                                window.location.href="http://www.91lkp.com/lkpai_test/activityShortUrl/fengxianghuiInfo";
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
</script>
</body>
</html>
