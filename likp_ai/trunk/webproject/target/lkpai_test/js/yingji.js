/**
 * Created by 审判之月 on 2017/1/2.
 */
function ImgObj(id, type, src, targetId) {
    this.id = id;
    //type(user:用户手机选择 ,order:订单图片,Service:已上传至服务器)
    this.type = type;
    this.src = src;
    /*当type等于user时,targetid为上传至微信服务器的serviceid
     * 当type等于order是,targetid为订单图片的编号
     * 当type等于Service时,targetid为影集图片的编号
     * */
    this.targetId = targetId;
    this.des='';
    this.uploadState = false;
    this.uploadImg = function () {
        /*
         *
         * var uploadimg_I=0;
         function uploadImg() {
         if (uploadimg_I < yingji.getImgList().length) {
         new ImgObj(yingji.getImgList()[i].id, yingji.getImgList()[i].type, yingji.getImgList()[i].src, yingji.getImgList()[i].targetId).uploadImg();
         }
         }
         * */
        var that = this;
        if (this.type == "user" && targetId == null) {
            wx.uploadImage({
                localId: that.src, // 需要上传的图片的本地ID，由chooseImage接口获得
                isShowProgressTips: 0, // 默认为1，显示进度提示
                success: function (res) {
                    var serverId = res.serverId; // 返回图片的服务器端ID
                    that.targetId = serverId;
                      (that.src);
                    that.uploadState = true;
                    $("#" + that.id).attr("data-target", that.toString());
                    uploadimg_I++;
                    uploadImg(uploadimg_I)
                }

            });
        } else if (this.type == "user" && targetId != null) {
            this.uploadState = true;
            $("#" + this.id).attr("data-target", that.toString());
            uploadimg_I++;
            uploadImg(uploadimg_I)
        } else if (this.type == 'order') {
            this.uploadState = true;
            $("#" + this.id).attr("data-target", that.toString());
            uploadimg_I++;
            uploadImg(uploadimg_I)
        } else if (this.type == 'service') {
            this.uploadState = true;
            $("#" + this.id).attr("data-target", that.toString());
            uploadimg_I++;
            uploadImg(uploadimg_I)
        }else{
            uploadimg_I++;
            uploadImg(uploadimg_I)
        }
    };
    this.toString = function () {
        return JSON.stringify(this);
    };
    this.toHTML = function () {
        return "<div class=\"item\" data-target=" + this.toString() + ">"+
            "<div class=\"itemInnerWrapper\">"+
            "<textarea rows=\"2\" maxlength=\"180\" placeholder=\"添加文字描述\"></textarea>"+
            "<img class=\"img\" src=\"../images/jiatingriji@2x.png\"/>"+
            "<button class=\"removeItem\"><span class=\"mui-icon mui-icon-closeempty\"></span> </button>"+
            "</div>"+
            "</div>";
    }
}
//影集数据操作
(function ($, window) {
    var yingji = function (options) {
        this.options = $.extend(true, {
            imglist: []
        }, options || {});
    };
    var container = $("#allChoosedImg");
    var prop = yingji.prototype;
    prop._init = function () {
        container.empty(".quater");
        for (var i = 0; i < prop.imglist.length; i++) {
            var imgitem = $(imglist[i].toHTML());
            $("#clear").before(imgitem);
            imgitem.find(".img").on("load", function (e) {
                var $this = $(e.target);
                if ($this.width() < $this.height()) {
                    $this.css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
                } else {
                    $this.css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
                }
            });
        }
    };
    /**
     * 添加一张图片
     * @param type 图片类型 user（用户手机选择） order(订单图片)
     * @param src 图片url路径
     * @param targetId type为user时为上传至微信的图片servid ,type为order时为图片id
     * */
    prop.addImg = function (type, src, targetId) {
        var obj = new ImgObj(this.uuid(), type, src, targetId);
        var imgitem = $("<div class=\"quarter\">" + obj.toHTML() + "</div>");
        $("item-content").append(imgitem);
        imgitem.children(".img").on("load", function (e) {
            var $this = $(e.target);
            if ($this.width() < $this.height()) {
                $this.css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
            } else {
                $this.css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
            }
        });
    };
    /**
     * 类型判断 是否为定义的imgobject
     * */
    prop.isImgObj = function (obj) {
        return (obj.hasOwnProperty("id") && obj.hasOwnProperty("type") && obj.hasOwnProperty("src") && obj.hasOwnProperty("targetId"));
    };
    /**
     * 通过id移除img
     * */
    prop.removeImgObj = function (id) {
        var arry = [];
        $("#" + id).parents(".quarter").remove();
    };
    /**
     * 在最前面添加img
     * */
    prop.unshift = function (obj) {
        var imgitem = $("<div class=\"quarter\">" + obj.toHTML() + "</div>");
        container.prepend(imgitem);
        imgitem.css("height", imgitem.width() + "px");
        imgitem.children("img").on("load", function (e) {
            var $this = $(e.target);
            if ($this.width() < $this.height()) {
                $this.css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
            } else {
                $this.css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
            }
        });
    };
    /**
     * 通过id删除img
     * */
    prop.deleteImg = function (id) {
        $("#" + id).parent().remove();
    };
    /**
     * 将指定id的img移到第一位
     * */
    prop.moveToFirst = function (id) {
        var data = JSON.parse($("#" + id).attr("data-target"));
        var imgObj;
        if (data.targetId) {
            imgObj = new ImgObj(data.id, data.type, data.src, data.targetId);
        } else {
            imgObj = new ImgObj(data.id, data.type, data.src, null);
        }

          (imgObj);
        this.deleteImg(id);
        this.unshift(imgObj)
    };
    /**
     * 生成随机id
     * */
    prop.uuid = function () {
        var s = [];
        var hexDigits = "0123456789abcdef";
        for (var i = 0; i < 36; i++) {
            s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
        }
        s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
        s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
        s[8] = s[13] = s[18] = s[23] = "-";
        var uuid = s.join("");
        return uuid;
    };
    prop.getImgList = function () {
        var arry = [];
        var imgs = container.find("img");
        for (var i = 0; i < imgs.length; i++) {
            arry.push(JSON.parse($(imgs.get(i)).attr("data-target")));
        }
        return arry;
    };
    prop.setTargetId = function (id, targetId) {
        for (var i = 0; i < this.options.imglist.length; i++) {
            if (this.options.imglist[i].id == id) {
                this.options.imglist[i].targetId = targetId;
            }
        }
    };
    var yingjiApi = null;
    $.yingji = function (options) {
        if (!yingjiApi) {
            yingjiApi = new yingji(options);
        }
        return yingjiApi;
    };
    $.getYingji = function () {
        return yingjiApi;
    }
})($, window);