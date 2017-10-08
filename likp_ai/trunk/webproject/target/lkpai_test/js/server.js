var domain = "http://121.40.255.15:8080";
var project = "/Z22629";
/*var domain = "http://192.168.1.202";
var project = "/Z22629";*/
var imgpre = domain + project;

function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)return unescape(r[2]);
    return null;
}