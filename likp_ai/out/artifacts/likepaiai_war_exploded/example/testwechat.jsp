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
        jsApiList: ['closeWindow','hideMenuItems','showMenuItems','hideOptionMenu','showOptionMenu'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });
    console.log('${appId}');
    console.log('${timestamp}');
    console.log('${nonceStr}');
    console.log('${signature}');
    wx.ready(function(){
        console.log('${appId}');
        console.log('${timestamp}');
        console.log('${nonceStr}');
        console.log('${signature}');
       console.log("ready");
    });


</script>

<body>
<div class="mui-content">
<div class="mui-btn" onclick="wx.hideOptionMenu();">隐藏右上角菜单接口</div>
<div class="mui-btn" onclick="wx.showOptionMenu();">显示右上角菜单接口</div>
<div class="mui-btn" onclick="wx.closeWindow();">关闭当前网页窗口接口</div>
<%--<div class="mui-btn" onclick="wx.hideMenuItems();">批量隐藏功能按钮接口</div>--%>
<%--<div class="mui-btn" onclick="wx.showMenuItems();">批量显示功能按钮接口</div>--%>
</div>
</body>

</html>