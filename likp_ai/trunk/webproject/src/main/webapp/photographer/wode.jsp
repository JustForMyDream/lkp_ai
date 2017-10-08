<%--


  Date: 2016/10/18
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>影集</title>
    <script src="../js/jquery-3.1.1.min.js"></script>
    <%@include file="../share/jsAndCss.jspf" %>

</head>
<body>
<button id="xuanze">選擇圖片</button>
<img src="" id="img">
<button id="shangchuan">上傳圖片</button>
</body>
<script src="<%=basePath%>js/mui.zoom.js"></script>
<script src="<%=basePath%>js/mui.previewimage1.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script>
    wx.config({
        debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
        appId: '${appId}', // 必填，公众号的唯一标识
        timestamp: ${timestamp}, // 必填，生成签名的时间戳
        nonceStr: '${nonceStr}', // 必填，生成签名的随机串
        signature: '${signature}',// 必填，签名，见附录1
        jsApiList: ['chooseImage', 'uploadImage'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });

    var imgid = "";

    $(function () {
        $("#xuanze").click(function () {
            wx.chooseImage({
                count: 1, // 默认1
                sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
                sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
                success: function (res) {
                      (res);
                    // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
                    $("#xuanze").attr("src",res.localIds[0]);
                    imgid = res.localIds[0];
                    alert("imgid"+imgid);
                    wx.uploadImage({
                        localId: imgid, // 需要上传的图片的本地ID，由chooseImage接口获得
                        isShowProgressTips: 1, // 默认为1，显示进度提示
                        success: function (res) {
                            var serverId = res.serverId; // 返回图片的服务器端ID

                        },

                    });
                },
                cancel: function () {
                    mui.toast("还未选择任何图片！");
                }
            });
        })
    })



</script>
</html>