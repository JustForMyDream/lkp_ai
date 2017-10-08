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
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <link href="<%=basePath%>/css/mui.min.css" rel="stylesheet" />
    <link href="<%=basePath%>/css/base.css" rel="stylesheet">
    <style>

    </style>
</head>

<body>
<div class="mui-content">

</div>
<script src="<%=basePath%>/js/mui.min.js"></script>
<script src="<%=basePath%>/js/jquery-2.1.4.min.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript">
    wx.config({
        debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
        appId: '${appId}', // 必填，公众号的唯一标识
        timestamp: ${timestamp}, // 必填，生成签名的时间戳
        nonceStr: '${nonceStr}', // 必填，生成签名的随机串
        signature: '${signature}',// 必填，签名，见附录1
        jsApiList: ['closeWindow'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });
    wx.ready(function(){
        $(function () {
            var btnArray = ['否', '是'];
            mui.confirm('您还不是摄影师,是否跳转到用户界面？', '立可拍', btnArray, function(e) {
                if (e.index == 1) {
                    window.location.href = "<%=basePath%>wechatuser/index.html";
                } else {
                    wx.closeWindow();
                }
            });
        });
    });


</script>
</body>

</html>