<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html>

<head>
    <meta charset="UTF-8">
    <title>立可拍</title>
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <link href="../css/mui.min.css" rel="stylesheet"/>
    <style>
        body, html {
            background-color: white;
        }

        .mui-bar-nav {
            background-color: black;
        }

        .mui-title {
            font-family: "微软雅黑";
        }

        .mui-icon-arrowleft {
        }

        .mui-pull-right, .mui-btn-link {
            font-family: "微软雅黑";
        }

        .tupian {
            width: 100%;
            height: 250px;
        }

        .tupian img {
            width: 100%;
            height: 100%;
        }

        .edit_list {
            width: 100%;
            height: 60px;
            border-bottom: 2px solid #EEEEEE;
            clear: both;
            background-color: white;
        }

        .star {
            padding-left: 5%;
            padding-top: 25px;
            color: red;
            /*font-weight: bolder;*/
            font-size: 30px;
            font-family: "微软雅黑";
            float: left;
        }

        .name {
            font-family: "微软雅黑";
            font-size: 16px;
            color: black;
            float: left;
            padding-top: 20px;
            padding-left: 8px;
        }

        .mui-icon-arrowright {
            float: right;
            color: #AAAAAA;
            font-size: 30px;
            float: right;
            padding-top: 15px;
        }

        .touxiang1 {
            line-height: 60px;
            float: right;
            height: 60px;
        }

        .touxiang1 img {
            width: 55px;
            height: 55px;
            border-radius: 50%;
            padding-top: 2.5px;
        }

        .nicheng {
            line-height: 65px;
            float: right;
            height: 60px;
            border: none;
        }

        .nicheng input {
            height: 40px !important;
            padding-top: 30px;
            text-align: right;
            width: 150px !important;
            border: none !important;
            float: right;
            margin-right: 8%;
            font-family: "微软雅黑";
            font-size: 15px;
            margin-right: -10px;
        }

        #xingbie {
            font-family: "微软雅黑";
            font-size: 15px;

        }

        .edit_jianjie {
            background-color: white;
            width: 100%;
            text-align: right;

        }

        .xingbiehight {
            line-height: 15px!important;
        }

        .tt {
            width: 82%;
            border: none;
            padding: 15px 0px;
        }

        .titleright {
            margin-top: 13px;
            font-size: 16px;
        }
    </style>
    <script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>
</head>

<body>
<%--<header class="mui-bar mui-bar-nav">--%>
<%--<a><span class="mui-icon mui-action-back mui-icon-arrowleft"></span></a>--%>
<%--<button id="save" class="mui-btn-link mui-pull-right">保存</button>--%>
<%--<h1 class="mui-title">资料编辑</h1>--%>
<%--</header>--%>
<header class="mui-bar mui-bar-nav" style="border-bottom: 1px solid #dcdcdc;color:black;background-color: white;">
    <a class="mui-icon mui-action-back mui-icon-arrowleft" style="color:black;">
    </a>
    <h1 class="mui-title" style="width: 80%">资料编辑</h1>
    <a class="mui-pull-right titleright" id="save" style="color:black;">保存</a>
</header>
<div class="mui-content">
    <div class="tupian">
        <img src="../img/BG.png"/>
    </div>
    <div class="edit_list">
        <span class="star">*</span>
        <span class="name">头像</span>
        <span class="mui-icon mui-icon-arrowright"></span>
        <span class="touxiang1"><img src="../img/logo-ai_03.png" id="sysheadimg"/></span>
    </div>
    <div class="edit_list">
        <span class="star">*</span>
        <span class="name">昵称</span>
        <span class="nicheng" style="margin-right: 30px;" ><input id="nicheng1" type="text" placeholder="" disabled maxlength="10"></span>
    </div>
    <div class="edit_list">
        <span class="star">*</span>
        <span class="name">性别</span>
        <span class="mui-icon mui-icon-arrowright"></span>
        <span class="nicheng"><select name="itemSex" id="xingbie" class="xingbiehight" style="margin-top: 0px!important;">
						<option value="1" selected="selected">女</option>
						<option value="0">男</option>
					</select>
						 </span>

    </div>
    <div class="edit_list">
        <span class="star">*</span>
        <span class="name">真实姓名</span>
        <span class="mui-icon mui-icon-arrowright"></span>
        <span class="nicheng"><input id="xingming" type="text" placeholder="您的姓名" maxlength="10"></span>
    </div>
    <div class="edit_list">
        <span class="star">*</span>
        <span class="name">联系电话</span>
        <span class="mui-icon mui-icon-arrowright"></span>
        <span class="nicheng"><input id="dianhua" type="text" placeholder="请输入联系电话" maxlength="11"></span>
    </div>
    <div class="edit_jianjie">
        <div>
            <span class="star">&nbsp;</span>
            <span class="name">个人简介</span>
            <span class="mui-icon mui-icon-arrowright"></span>
        </div>
        <div style="width: 100%;">
            <textarea class="tt" rows="5" id="jianjie" placeholder="您的一段个人简介" maxlength="300"></textarea>
        </div>
    </div>
</div>
<script src="../js/mui.min.js"></script>
<script src="../js/server.js"></script>
<script src="../js/date.js"></script>
<script src="../js/commen.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script>
    mui.init()
    wx.config({//配置微信
        debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
        appId: '${appId}', // 必填，公众号的唯一标识
        timestamp: '${timestamp}', // 必填，生成签名的时间戳
        nonceStr: '${nonceStr}', // 必填，生成签名的随机串
        signature: '${signature}',// 必填，签名，见附录1
        jsApiList: ['downloadImage', 'chooseImage', 'uploadImage'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });
    window.onload = function () {
        mainLoad();
    }
    /**
     * 检查电话号码
     * @param parm
     * @constructor
     */
    function DhhmCheck(parm) {
        var dhhm = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        return dhhm.test(parm);
    }

    function mainLoad() {
        $.ajax({
            url: "../sysPort/GetSysInfoByOpenid",
            type: "post",
            dataType: "json",
            timeout: "10000",
            success: function (data) {
                if (data.errorCode == "200") {
                    var sysinfo = data.sysinfo;
                    if(sysinfo.itemOpenid.nickname){
                        $("#nicheng1").val(sysinfo.itemOpenid.nickname);
                    }
                    if (sysinfo.itemHeadimg) {
                        $(".touxiang1 img").attr("src", imgpre + JSON.parse(sysinfo.itemHeadimg)[0].path).attr("data-itembh", sysinfo.itemBh);
                    } else {
                        if (sysinfo.itemOpenid) {
                            if (sysinfo.itemOpenid.headimgurl) {
                                $(".touxiang1 img").attr("src", sysinfo.itemOpenid.headimgurl).attr("data-itembh", sysinfo.itemBh);
                            } else {
                                $(".touxiang1 img").attr("src", "").attr("data-itembh", sysinfo.itemBh);
                            }
                        }
                        else {
                            $(".touxiang1 img").attr("src", "").attr("data-itembh", sysinfo.itemBh);
                        }

                    }
                    if (sysinfo.itemSex) {
                        if (sysinfo.itemSex == 0) {
                            $("#xingbie option:last-child").attr("selected", "selected")
                        } else {
                            $("#xingbie option:first-child").attr("selected", "selected")
                        }
                    }
                    if (sysinfo.itemName) {
                        $("#xingming").val(sysinfo.itemName);
                    }
                    if (sysinfo.itemPhone) {
                        $("#dianhua").val(sysinfo.itemPhone);
                    }
                    if (sysinfo.itemGrjj) {
                        $("#jianjie").val(sysinfo.itemGrjj);
                    }
                    $("#save").on("click", function () {
                        if (DhhmCheck($("#dianhua").val())){
                            change();
                        }
                        else {
                            mui.toast("请输入正确的电话号码！");
                        }
                    });
                    $("#sysheadimg").click(function () {
                        coverselect();
                    });

                } else {
                    mui.toast(data.errorMsg);
                }
            }
        });
    }

    function coverselect() {
        wx.chooseImage({
            count: 1, // 默认9
            sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function (res) {
                if (res.localIds.length >= 1) {
                    $("#sysheadimg").attr("src", res.localIds[0]);
                    uploadCover(res.localIds[0]);
                }
            },
            fail: function (res) {
                mui.toast("头像上传失败，请重试")
            }
        });
    }

    function uploadCover(localid) {
        wx.uploadImage({
            localId: localid, // 需要上传的图片的本地ID，由chooseImage接口获得
            isShowProgressTips: 1, // 默认为1，显示进度提示
            success: function (res) {
                var serverId = res.serverId; // 返回图片的服务器端ID
                mui.toast("更新中")
                $.ajax({
                    url: "../sysPort/updateImg",
                    type: "post",
                    data: {
                        itemBh: $("#sysheadimg").attr("data-itembh"),
                        serverId: serverId
                    },
                    timeout: "10000",
                    success: function (data) {
                        mui.toast(data);
                    }
                });
            },
            fail: function () {
                mui.toast("头像上传失败，请重试")
            }
        });
    }

    function change() {
        mui.toast("正在为你保存")
        $.ajax({
            url: "../sysPort/UpdateSysInfo",
            type: "post",
            data: {
                sex: $("#xingbie").val(),
                name: $("#xingming").val(),
                phone: $("#dianhua").val(),
                grjj: $("#jianjie").val()
            },
            dataType: "json",
            timeout: "10000",
            success: function (data) {
                if (data.errorCode == "200") {
                    mui.alert("保存成功！");
                } else {
                    mui.toast(data.errorMsg);
                }
            }
        });
    }
</script>
</body>

</html>