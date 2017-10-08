<%--
  Created by IntelliJ IDEA.
  User: 审判之月
  Date: 2016/12/16
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>立可拍「爱与陪伴」家庭影像分享会</title>
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <link href="../css/mui.min.css" rel="stylesheet"/>
    <link href="../css/base.css" rel="stylesheet">
    <link href="../css/mui.picker.css" rel="stylesheet"/>
    <link href="../css/mui.poppicker.css" rel="stylesheet"/>
    <link href="Common.css" rel="stylesheet"/>
    <style>
        .activity-name{
            font-size: 15px;
        }
    </style>
</head>
<body>
<header>
<div class="header-content">
    <img id="poster" src="../images/fengxianghui.png" />
  <%--  <div class="bottom-img">
        <img id="poster-bottom" class="blur" src="../image/support_2.jpg"/>
    </div>--%>
</div>
</header>
<div class="content">
   <div class="activity-name">
       立可拍「爱与陪伴」家庭影像分享会
   </div>
    <div class="activity-info-row">
        <div class="activity-info-key">活动时间：</div>
        <div class="activity-info-value">2016年12月23日 周五晚 19：00-21：00</div>
    </div>
    <div class="activity-info-row">
        <div class="activity-info-key">活动地点：</div>
        <div class="activity-info-value">成都市•武侯区•玉林北街一号玉林品上2栋2单元105（汤舍）</div>
    </div>
    <div class="activity-info-row">
        <div class="activity-info-key">活动费用：</div>
        <div class="activity-info-value">0元</div>
    </div>
    <div class="button-row">
        <a id="baoming" href="http://www.91lkp.com/lkpai_test/activityShortUrl/fengxianghui" class="button">立即报名</a>
    </div>
</div>
<div class="activity-divider">
    活动详情
</div>
<div class="content">
    <p>如果说家是世间最美的风景，</p>
    <p>万千风景就有万千故事。</p>
    <p>从镜头里流淌出来的故事，</p>
    <p>和故事中正在发生的爱与陪伴，</p>
    <p>是摄影师给每个家庭最珍贵的礼物。</p>
    <p>风景里，故事中，摄影本就纯粹。</p>
    <br/>
    <p style="font-weight: bold">【分享嘉宾】</p>
    <p><span style="font-size: 16px">王重阳</span>(自由独立摄影师)</p>
    <p><span style="font-size: 16px">鲁西西</span>(自由家庭摄影师)</p>
    <p>在平淡中找寻小确幸</p>
    <p>镜头之后，从心出发</p>
    <p>分享家庭摄影的感悟</p>
    <br/>
    <p style="color: rgb(164,0,0)">摄影师|鲁西西</p>
    <p style="font-weight: bold">个人介绍：</p>
    <p>自由家庭摄影师</p>
    <p>喜欢记录旅行中那些有意思的人与风景，喜欢记录孩子成长</p>
    <p>与家庭之间的爱的瞬间。</p>
    <p style="font-weight: bold">个人感悟：</p>
    <p>摄影不只是拍照，而是我们带到摄影中去的，所有我们读过</p>
    <p>的书、看过的电影、听过的音乐、走过的路、爱过的人。</p>
    <p style="font-weight: bold">摄影作品：</p>
    <img src="fenxianghui/1.jpg"/>
    <img src="fenxianghui/2.jpg"/>
    <p>孩子的眼睛是最干净的，豆豆就像来到世间的天使。父子的对视里满满的都是爱。亲爱的豆豆，爸爸妈妈会好好陪伴你守护你长大的。</p>
    <img src="fenxianghui/3.jpg"/>
    <img src="fenxianghui/4.jpg"/>
    <img src="fenxianghui/5.jpg"/>
    <p>美美妞和爸爸妈妈的家庭生活记录。我喜欢拍这样的家庭记录。没有过多的技巧和套路，只有满满的爱和暖意。用照片记录生活，不是出几个外景、给孩子换几套衣服，而是爸爸妈妈的陪伴和摄影师安静的记录。</p>
    <br/>
    <p style="color: rgb(164,0,0)">
        温暖的夜晚/温暖的分享/温暖的家庭影像
    </p>
    <br/>
    <p style="font-weight: bold">【分享流程】</p>
    <p>19:00签到入座</p>
    <p>19:20主题分享</p>
    <p>20:40沟通交流</p>
    <p>20:55暖心礼物</p>
    <br/>
    <p  style="font-size: 12px;color:rgb(151,151,151)">温馨提示：由于分享会在晚高峰堵车时段开始，我们建议您搭乘地铁出行，地铁1号线/3号线至省体育馆站，F1出口向西步行10分钟，左转入玉林北街即到。</p>
</div>
<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script>
    var id="11e6-c44c-2c9e0275-9fa2-219460512774";
    var inputRoww=$(".input-row");
    for(var i=0;i<inputRoww.length;i++){
        if($(inputRoww[i]).find("select").length>0){
            $(inputRoww[i]).addClass("select");
        }
    }
    $.ajax({
        url:"../HONGDONG/isJoined",
        data:{id:id},
        type:"post",
        dataType:"json",
        success:function(d){
            if(d.result=="success"&&d.data){
                $("#baoming").on("tap click touch",function(e){
                    e.preventDefault();
                }).css("backgroundColor","#DEDEDE").text("报名成功");
            }
        }
    });
</script>
</body>
</html>
