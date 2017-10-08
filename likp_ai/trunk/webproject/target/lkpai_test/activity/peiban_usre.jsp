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
    <title>陪伴-家庭征集</title>
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <link href="../css/mui.min.css" rel="stylesheet"/>
    <link href="../css/base.css" rel="stylesheet">
    <link href="../css/mui.picker.css" rel="stylesheet"/>
    <link href="../css/mui.poppicker.css" rel="stylesheet"/>
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
                <span class="font4 red">家庭·报名信息</span>
            </div>--%>
        <div class="font5 red">
            【家庭·报名信息】
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
        <button id="next" class="red">下一步</button>
    </div>
</div>
<div class="dialog" style="display: none">
    <div class="dialog-body">
        <div class="param-row"><p class="info">为了更好地沟通和服务，</p><p class="info">需要您填写以下信息：</p></div>
        <div class="param-row">
            <label>
                您的年龄段
            </label>
            <select name="age">
                <option value="">请选择</option>
                <option value="60后">60后</option>
                <option value="70后">70后</option>
                <option value="80后">80后</option>
                <option value="90后">90后</option>
            </select>
            <%--<input name="age" type="text" placeholder="如：80后、90后" />--%>
        </div>
        <div class="param-row">
            <label>
                您的住家地址
            </label>
            <input id="dz" name="dz" type="text" placeholder="请选择" />
        </div>
        <div class="param-row">
            <label>
                详细位置
            </label>
            <input name="detail" type="text" placeholder="如：xx街xx小区xx号" />
        </div>
        <div class="param-row">
            <label>
                主要拍摄人物
            </label>
            <input name="dx" type="text" placeholder="如：父亲" />
        </div>
        <div class="param-row">
            <label>
                TA的特点爱好
            </label>
            <input name="faver" type="text" placeholder="如：性格温和，喜欢花鸟，擅长绘画"/>
        </div>
        <div class="param-row">
            <label>
                陪伴感悟
            </label>
            <input name="story" type="text" placeholder="如：我觉得陪伴是...，2017年我想给家人.."/>
        </div>
    </div>
    <div class="dialog-foot">
        <button id="submit" class="red">提交报名</button>
        <button id="perv">上一步</button>
    </div>
</div>
<div id="report" class="mark">
    <div class="protocol">
        <div class="protocol_header">
            报名须知
        </div>
        <div class="protocol_body">
            <p>亲：</p>
            <p>首先感谢有爱的您！</p>
            <p>立可拍启动“like陪伴”的主题摄影活动旨在能唤起人们心中陪伴家人的愿望并记录这温馨时光，摄影师将为您提供免费服务；拍摄成品（含电子档）将会免费提供给参加者，您的部分照片会用于立可拍平台网络推广（包括但不限于微信平台、网站、APP、微博等）及社区线下推广包括但不限于海报、演示视频、演示PPT等），选用推广宣传的家庭可获电子相册作为肖像使用报酬，我们会恪守职业道德，保护您的隐私权，不会署具家庭真实姓名及信息，不会将拍摄的图片、视频和个人资料外泄用于其他目的，立可拍及立可拍摄影师拥有为您拍摄照片的著作署名权</p>
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
       <%-- <div class="qrcode-content">
            <img src="../images/2015.11.30logo-ai_03.png">
        </div>
        <p>该活动由立可拍主办</p>--%>
    </div>
</footer>
<div id="map" style="width: 100%;height: 100px;display: none"></div>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/mui.min.js"></script>
<script src="../js/mui.zoom.js"></script>
<script src="../js/mui.picker.js"></script>
<script src="../js/mui.poppicker.js"></script>
<script src="../js/city.data.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/city.data-3.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Hc7QMTt5b5treV5Q4KsCYSni"></script>
<script src="../js/mui.previewimage.js"></script>
<script src="../js/server.js"></script>
<script src="../js/getParam.js"></script>
<script>
    var isagree=false;
    var cityPicker3 = new mui.PopPicker({
        layer: 3
    });
    $("#report").show();
    cityPicker3.setData(cityData3);
    var dz1 = document.getElementById('dz');
    dz1.addEventListener('tap', function (event) {
        event.preventDefault();
        cityPicker3.show(function (items) {
            dz1.value = (items[0] || {}).text + " " + (items[1] || {}).text + " " + (items[2] || {}).text;
            //返回 false 可以阻止选择框的关闭
            //return false;
        });
    }, false);
    var hdbh="11e6-beda-742fdad8-8401-4b9f5d257afc";
    $("#john_in").on("tap",function(){
        $("#report").show();
    });
    $("#agree").on("tap",function(){
        isagree=true;
        $("#report").hide();
       // submitform();
    });
    $("#disagree").on("tap",function(){
        $("#report").hide();
        window.location.href="../wechatuser/index.html";
    });
    $("#next").on("tap",function(){
        var flag=true;
        var username = $("input[name='name']").val();
        var sex = $("select[name='sex']").val();
        var phonenum = $("input[name='phonenum']").val();
        var age=$("input[name='age']").val();
        var dz = $("input[name='dz']").val();
        var faver = $("input[name='faver']").val();
        var story=$("input[name='story']").val();
        var photoObj = $("input[name='dx']").val();
        var re = /^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
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
        else if(!re.test(phonenum)){
            mui.toast("为了更好地沟通和服务，请您填写正确的电话信息，谢谢。");
            flag=false;
            return;
        }
        if(flag){
            var $target=$(this).parents(".dialog").addClass("hide");
            $target.height();
            var next=$($(".dialog")[1]).css("display","block").addClass("show");
            setTimeout(function(){$target.removeClass("hide").css("display","none");next.removeClass("show")},1000);
        }
    });
    $("#perv").on("tap",function(){
        var $target=$(this).parents(".dialog").addClass("hide");
        var perv=$($(".dialog")[0]).css("display","block").addClass("show");
        setTimeout(function(){$target.removeClass("hide").css("display","none");perv.removeClass("show")},1000);
    });
    function weizhi() {              //获取位置信息
        // 百度地图API功能
        var map = new BMap.Map("map");
        var point = new BMap.Point(103.962722, 30.782822);
        map.centerAndZoom(point, 12);
        var geolocation = new BMap.Geolocation();
        geolocation.getCurrentPosition(function (r) {
            if (this.getStatus() == BMAP_STATUS_SUCCESS) {
                var mk = new BMap.Marker(r.point);
                map.addOverlay(mk);
                map.panTo(r.point);
                var geoc = new BMap.Geocoder();
                geoc.getLocation(r.point, function (rs) {
                    var addComp = rs.addressComponents;
                    var positionstr = addComp.province + "," + addComp.city + "," + addComp.district;
                    var postions = positionstr.split(",");
                    for (var i in cityData3) {
                        if (cityData3[i].text == postions[0]) {
                            cityPicker3.pickers[0].setSelectedIndex(i);
                            var childrens = cityData3[i].children;
                            for (var j in childrens) {
                                if (childrens[j].text == postions[1]) {
                                    cityPicker3.pickers[1].setSelectedIndex(j);
                                    var childrens2 = childrens[j].children;
                                    for (var k in childrens2) {
                                        if (childrens2[k].text == postions[2]) {
                                            cityPicker3.pickers[2].setSelectedIndex(k);
                                        }
                                    }
                                }
                            }
                        }
                    }
//                    $("#car_tongzhi1").append("你现在的位置是:" + addComp.province + addComp.city + addComp.district + addComp.street + addComp.streetNumber);
                });
            }
            else {
                mui.toast('获取位置信息failed:' + this.getStatus());
            }
        }, {enableHighAccuracy: true})
    }
    $("#submit").on("tap",function(){
        var flag=true;
        var username = $("input[name='name']").val();
        var sex = $("select[name='sex']").val();
        var phonenum = $("input[name='phonenum']").val();
        var age=$("select[name='age']").val();
        var dz = $("input[name='dz']").val();
        var detail = $("input[name='detail']").val();
        var faver = $("input[name='faver']").val();
        var story=$("input[name='story']").val();
        var photoObj = $("input[name='dx']").val();
        var re = /^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
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
        }else if(!re.test(phonenum)){
            mui.toast("为了更好地沟通和服务，请您填写正确的电话信息，谢谢。");
            flag=false;
            return;
        }
        else if(age==null||age==''){
            mui.toast("为了更好地沟通和服务，请您完善以上信息，谢谢。");
            flag=false;
            return;
        }
        else if(dz==null||dz==''){
            mui.toast("为了更好地沟通和服务，请您完善地址信息，谢谢。");
            flag=false;
            return;
        }
        else if(detail==null||detail==''){
            mui.toast("为了更好地沟通和服务，请您完善详细地址信息，谢谢。");
            flag=false;
            return;
        }
        else if(faver==null||faver==''){
            mui.toast("为了更好地沟通和服务，请您完善以上信息，谢谢。");
            flag=false;
            return;
        }
        else if(story==null||story==''){
            mui.toast("为了更好地沟通和服务，请您完善以上信息，谢谢。");
            flag=false;
            return;
        }
        else if(photoObj==null||photoObj==''){
            mui.toast("为了更好地沟通和服务，请您完善以上信息，谢谢。");
            flag=false;
            return;
        }
        else if(flag){
                submitform();
        }


    });
    function submitform(){
        var username = $("input[name='name']").val();
        var sex = $("select[name='sex']").val();
        var phonenum = $("input[name='phonenum']").val();
        var age=$("select[name='age']").val();
        var dz = $("input[name='dz']").val();
        var detail = $("input[name='detail']").val();
        var faver = $("input[name='faver']").val();
        var story=$("input[name='story']").val();
        var photoObj = $("input[name='dx']").val();
        var data={
            itemName:username,
            itemSex:sex,
            itemLxfs:phonenum,
            itemHdbh:hdbh,
            itemAge:age,
            itemDz:dz+detail,
            itemAihao:faver,
            itemGs:story,
            itemPsdx:photoObj
        };
        $.ajax({
            url:'../HONGDONG/saveyhhdbm',
            data:data,
            type:"post",
            dataType:"json",
            success:function(data){
                if(data.result=="success"){
                    mui.alert("客服将尽快与您联系，感谢您的支持","报名成功","确定");
                }else{
                    if(data.resultcode=="404"){
                        mui.alert("您已经太长时间未操作了，请重新进入此页面","操作失败","确定");
                    }else if(data.resultcode=="302"){
                        mui.alert("重复报名，您已经报名过了","报名结果","确定");
                    }
                }
            }
        });
    }
    weizhi();
</script>
</body>
</html>
