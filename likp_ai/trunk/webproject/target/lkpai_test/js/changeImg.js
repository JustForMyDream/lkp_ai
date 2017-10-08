/**
 * Created by user on 2017/1/5.
 */
//传入图片父元素class(父元素宽度定死超出隐藏)
function changeImg(e) {
    var imgitem = $("."+e);
    imgitem.height(imgitem.width());
    var replacelist = $(imgitem.children("img"));
    for(var i=0;i < replacelist.length;i++){
        var $this = $(replacelist[i]);
        if ($this.width() < $this.height()) {
            $this.css({"width": "100%", "height": "auto", "max_height": "auto", "max_width": "auto"});
            $this.css("margin-top", "-" + ($this.height() - $this.width()) / 2);
        } else {
            $this.css({"width": "auto", "height": "100%", "max_height": "auto", "max_width": "auto"});
            $this.css("margin-left", "-" + ($this.width() - $this.height()) / 2);
        }
    }
}
