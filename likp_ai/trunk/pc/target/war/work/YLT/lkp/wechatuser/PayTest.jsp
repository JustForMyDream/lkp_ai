<%--
  Created by IntelliJ IDEA.
  User: chenxuantong
  Date: 16-11-11
  Time: 上午10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单支付</title>
</head>
<body>

</body>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script>
    var appId = '${appId}';
    var timeStamp = '${timeStamp}';
    var nonceStr = '${nonceStr}';
    var signType = '${signType}';
    var prepay_id = '${prepay_id}';
    var paySign = '${paySign}';
    var id = '${id}';
    function pay() {
        WeixinJSBridge.invoke('getBrandWCPayRequest', {
                    "appId": appId, //公众号名称，由商户传入
                    "timeStamp": timeStamp, //时间戳，自1970年以来的秒数
                    "nonceStr": nonceStr, //随机串
                    "package": prepay_id,
                    "signType": signType, //微信签名方式：
                    "paySign": paySign //微信签名
                },
                function (res) {
                    if (res.err_msg == "get_brand_wcpay_request:ok") {
                        alert("支付成功！客服将稍后和您联系!");
                        /*paied = true;*/
                        window.location.href = "<%=basePath%>/wechatuser/orderStateShow.html?id="+id;
                    } else {
                        alert("支付失败!");
                        history.go(-1);
                    }
                }
        );
    }
    if (typeof WeixinJSBridge == "undefined"){
        if( document.addEventListener ){
            document.addEventListener('WeixinJSBridgeReady', pay, false);
        }else if (document.attachEvent){
            document.attachEvent('WeixinJSBridgeReady', pay);
            document.attachEvent('onWeixinJSBridgeReady', pay);
        }
    }else{
        pay();
    }
</script>
</html>
