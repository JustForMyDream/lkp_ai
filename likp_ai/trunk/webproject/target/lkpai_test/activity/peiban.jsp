<%--
  Created by IntelliJ IDEA.
  User: 审判之月
  Date: 2016/12/11
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>陪伴-摄影师征集</title>
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <link href="../css/mui.min.css" rel="stylesheet"/>
    <link href="../css/base.css" rel="stylesheet">
    <link href="peibancss.css" rel="stylesheet"/>
</head>
<body>
<header>
    <div class="activity-line"></div>
    <div class="activity-pic"><img src="../images/peiban.png"></div>
</header>
<div class="dialog">
    <div class="activity-body">
        <div class="font2" style="padding: 0 0 16px">
            #like陪伴#主题摄影活动
        </div>
        <%--    <div>
                <span class="font4 red"></span>
            </div>--%>
        <div class="font5 red">
            【摄影师·报名信息】
        </div>
    </div>
    <div class="dialog-body">
        <div class="param-row">
            <label>
                您的姓名
            </label>
            <input name="name" type="text" placeholder="请填入真实姓名" />
        </div>
        <div class="param-row">
            <label>
                您的性别
            </label>
            <select name="sex">
                <option value="1">女士</option>
                <option value="0">先生</option>
            </select>
        </div>
        <div class="param-row">
            <label>
                您的电话
            </label>
            <input type="tel" name="phonenum" placeholder="请填入手机号码" />
        </div>
    </div>
    <div class="dialog-foot">
        <button id="submit" class="red">提交报名</button>
    </div>
</div>

<div id="report" class="mark">
<div class="protocol">
    <div class="protocol_header">
        报名须知
    </div>
    <div class="protocol_body">
        <p>亲爱的摄影师：</p>
        <p>首先感谢您的爱心和手中的相机！</p>
        <p>本次主题拍摄旨在通过家庭照片拍摄及亲情故事分享和传播，唤起人们心中对家人的关爱，用陪伴来表达爱并用相机记录珍藏。报名参与本次活动，即代表您同意以下内容：</p>
        <p>一、您同意许可您本次活动拍摄的照片和视频用于立可拍平台的宣传使用，使用权壹年，许可内容如下：</p>
        <p>1、网络展示和推广 ，包括但不限于立可拍微信平台、网站、APP、微博等网络渠道进行产品展示、主题推广使用；</p>
        <p>2、线下推广活动 ，包括但不限于海报、展览、演示视频、演示PPT等；</p>
        <p>3、立可拍用于以上推广宣传时会对您拍摄的照片署名，并且不需要再支付任何费用。</p>
    </div>
    <div class="protocol-bottom">
        <button id="disagree">不同意</button>
        <button id="agree" class="red">同意</button>
    </div>
</div>
</div>
<footer>
<div class="footer-top"></div>
    <div class="footer-body">
<%--        <div class="qrcode-content">
            <img src="../images/2015.11.30logo-ai_03.png">
        </div>
        <p>该活动由立可拍主办</p>--%>
    </div>
</footer>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/mui.min.js"></script>
<script src="../js/mui.zoom.js"></script>
<script src="../js/mui.previewimage.js"></script>
<script src="../js/server.js"></script>
<script src="../js/getParam.js"></script>
<script>
    var isagree=false;
    var hdbh="11e6-beda-742fdad8-8401-4b9f5d257afc";
    $("#john_in").on("tap",function(){
        $("#report").show();
    });
    $("#report").show();
    $("#agree").on("tap",function(){
        isagree=true;
        $("#report").hide();
/*        var flag=true;
        var username = $("input[name='name']").val();
        var sex = $("select[name='sex']").val();
        var phonenum = $("input[name='phonenum']").val();
        /!*var photoObj = $("input[name='dx']").val();*!/
        if(username==null||username==''){
            mui.toast("请填写姓名");
            return;
        }
        else if(sex==null||sex==''){
            mui.toast("选择性别");
            flag=false;
            return;
        }
        else if(phonenum==null||phonenum==''){
            mui.toast("请填写电话");
            flag=false;
            return;
        }
        /!*        else if(photoObj==null||photoObj==''){
         mui.toast("请填写拍摄对象");
         flag=false;
         return;
         }*!/
        else if(flag){
            submintForm();
        }*/
    });
    $("#disagree").on("tap",function(){
        $("#report").hide();
        window.location.href="../wechatuser/index.html";
    });
    $("#submit").on("tap",function(){
        var flag=true;
        var username = $("input[name='name']").val();
        var sex = $("select[name='sex']").val();
        var phonenum = $("input[name='phonenum']").val();
        var re = /^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        /*var photoObj = $("input[name='dx']").val();*/
        if(username==null||username==''){
            mui.toast("为了更好地沟通和服务，请您完善以上信息，谢谢。");
            return;
        }
        else if(sex==null||sex==''){
            mui.toast("为了更好地沟通和服务，请您完善以上信息，谢谢。");
            flag=false;
            return;
        }
        else if(phonenum==null||phonenum==''){
            mui.toast("为了更好地沟通和服务，请您完善以上信息，谢谢。");
            flag=false;
            return;
        }
        else if(!re.test(phonenum)){
            mui.toast("为了更好地沟通和服务，请您填写正确的电话信息，谢谢。");
            flag=false;
            return;
        }
        if(flag){
                submintForm();
        }
    });
    function submintForm(){
        var flag=true;
        var username = $("input[name='name']").val();
        var sex = $("select[name='sex']").val();
        var phonenum = $("input[name='phonenum']").val();
        $.ajax({
            url:'../HONGDONG/savesyshdbbm',
            data:{
                itemName:username,
                itemSex:sex,
                itemLxfs:phonenum,
                itemHdbh:hdbh
            },
            type:"post",
            dataType:"json",
            success:function(data){
                if(data.result=="success"){
                    mui.alert("客服将尽快与您联系，感谢您的支持","报名成功","确定");
                }else{
                    if(data.resultcode=="404"){
                        mui.alert("请重新进入此页面","操作失败","确定");
                    }else if(data.resultcode=="302"){
                        mui.alert("重复报名，您已经报名过了","报名结果","确定");
                    }
                }
            }
        });
    }
</script>
</body>
</html>
