var websocket;
var wssocket = "ws://"+domain+"/pc/ws/webSocketServer";
var jssocket = "http://"+domain+"/pc/ws/sockjs/webSocketServer";
var loginsuccessurl = "http://"+domain+"/pc/list";
function open(){
    if ('WebSocket' in window) {
        websocket = new WebSocket(wssocket);
    } else if ('MozWebSocket' in window) {
        websocket = new MozWebSocket(wssocket);
    } else {
        websocket = new SockJS(jssocket);
    }
    websocket.onopen = function (evnt) {
        console.log("onopen");
    };
    websocket.onmessage = function (evnt) {
        var data = JSON.parse(evnt.data);
        console.log("获取到消息！");
        if(data.action="scan"){
            console.log("正在登录！");
            console.log("id==="+data.id);
            console.log("ticket==="+data.ticket);
            $.post(ajaxurl.loginUrl, { id: data.id, ticket: data.ticket} ,function(data){
                if(data.result=="success"){
                    console.log("登录成功！");
                    window.location.href=loginsuccessurl;
                    websocket.close();
                    return false;
                }else{
                    console.log(data.des);
                }
            },"json");
        }
    };
    websocket.onerror = function (evnt) {
        console.log("onerror");
    };
    websocket.onclose = function (evnt) {
        console.log("onclose");
    }
}

