//侧滑点击跳转
function cehuandj(thid) {
    mui(".mui-off-canvas-left").on("tap",".bg li a", function () {
        var id = this.id;
        console.log(id);
        if (id) {
            switch (id) {
                case "order": {
                    if(thid != id){
                        window.location.href = "ordercenter.html";
                    }
                    break;
                }
                case "message": {
                    if(thid != id){
                        window.location.href = "messagecenter.html";
                    }
                    break;
                }
                case "userInfo": {
                    if(thid != id){
                        window.location.href = "gerenziliao.html";
                    }
                    break;
                }
                case  "yingji": {
                    if(thid != id){
                        window.location.href = "YingjiList.html";
                    }
                    break;
                }
                case  "xiangce": {
                    if(thid != id){
                        window.location.href = "albumlist.html";
                    }
                    break;
                }
                case  "back": {
                    if(thid != id){
                        window.location.href = "index.html";
                    }
                    break;
                }
                case  "collection": {
                    if(thid != id){
                        window.location.href = "collectionlist.html";
                    }
                    break;
                }
            }
        }
    });
}