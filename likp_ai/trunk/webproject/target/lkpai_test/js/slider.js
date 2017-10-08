var IMGSRCP = ['shouye', 'dingdan', 'xiangce', 'yingji','geren', 'shoucang'];
//var IMGSRC = ['shouye1','dingdan1','xiangce1','yingji@31','xiaoxi1','wode1','heart'];
var TITLE = ['首页', '拍摄订单', '订单相册', '创建影集','个人资料', '我的收藏'];
var ID = ['MainInterface', 'ordercenter', 'albumlist', ' YingjiList', 'gerenziliao', 'collectionlist'];

function addSlide(n) {
    var slider = '<div id="offCanvasSideScroll" class="mui-scroll-wrapper bg">\
            <div class="mui-scroll">\
                <ul class="mui-table-view mui-table-view-chevron cehuye">';

    for (var i = 0; i < IMGSRCP.length; i++) {
        slider += '<li class="mui-table-view-cell" style="padding: 18px 15px;">';
        if (i == n) {
            slider += '<a id="' + ID[i] + '" class="mui-navigate-right" style="background-color: #ffe33e;height: 60px;    margin: -20px -15px;">\
                            <img src="../cehua/' + IMGSRCP[i] + '1.png" style="height: 22px;margin-right: 8px;vertical-align: middle;">\
                            <span style="color: #000000">' + TITLE[i] + '</span>\
                        </a>';
        } else {
            slider += '<a id="' + ID[i] + '" class="mui-navigate-right" style="height: 60px;    margin: -20px -15px;" >\
                            <img src="../cehua/' + IMGSRCP[i] + '.png" style="height: 22px;margin-right: 8px;vertical-align: middle;">\
                            <span  style="color: rgb(151,151,151)">' + TITLE[i] + '</span>\
                        </a>';
        }

        slider += ' </li>';
    }

    slider += '</ul>\
            </div>\
        </div>';
    $("#offCanvasSide").append(slider);
    $(".cehua li:nth-child(" + n + ")").css({'background-color': 'rgb(235,185,125)'});
    //点击侧滑首页返回

//侧滑容器父节点
    var offCanvasWrapper = mui('#offCanvasWrapper');
//主界面容器
    var offCanvasInner = offCanvasWrapper[0].querySelector('.mui-inner-wrap');
//菜单容器
    var offCanvasSide = document.getElementById("offCanvasSide");
//移动效果是否为整体移动
    var moveTogether = false;
//侧滑容器的class列表，增加.mui-slide-in即可实现菜单移动、主界面不动的效果；
    var classList = offCanvasWrapper[0].classList;
    document.getElementById(ID[n]).addEventListener('tap', function () {
          ("close");
        offCanvasWrapper.offCanvas('close');
    });

    mui('#offCanvasSide').on('tap', '.bg ul li a', function () {
        var id = this.id;
        if (ID[n] != id) {
            window.location.href = id + ".html";
        }
    });

}
mui(".mui-scroll-wrapper").scroll();
//主界面和侧滑菜单界面均支持区域滚动；
mui('#offCanvasSideScroll').scroll();
mui('#offCanvasContentScroll').scroll();




