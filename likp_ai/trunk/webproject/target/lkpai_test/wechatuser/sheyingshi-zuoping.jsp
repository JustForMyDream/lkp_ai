<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>

	<head>
		<meta charset="UTF-8">
		<title>摄影师-作品</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link href="../css/mui.min.css" rel="stylesheet" />
		<link href="../css/sheyingshi.css" rel="stylesheet" />
		<link href="../css/base.css" rel="stylesheet">
		<style>
			.mui-content,
			.moddile {
				width: 100%;
				text-align: center;
				height: auto;
				z-index: 1;
				background-color: white;
			}
			
			.m1 {
				width: 100%;
				text-align: center;
				height: auto;
				background-color: white;
			}
			
			.m1 img {
				width: 90%;
				height: auto;
			}
			
			.mp_1 {
				font-family: "微软雅黑";
				color: black;
				font-size: 15px;
				font-weight: bold;
				padding-top: 10px;
			}
			
			.mp_2 {
				font-family: "微软雅黑";
				color: rgb(148,148,148);
				font-size: 14px;
				margin-top: -8px;
			}
			
			.Triangle {
				width: 0px;
				height: 0px;
				border-top: 14px solid rgb(238, 238, 238);
				border-left: 10px solid transparent;
				border-right: 10px solid transparent;
				z-index: 30;
				position: absolute;
				margin: 0 -10px;
				left: 50%;
			}
			.moddile>p{
				font-size: 15px;
				margin-top: 0;
				margin-bottom: 10px;
				color: #8f8f94;
				margin-top: 30px;
			}

		</style>
	</head>

	<body>
		<div class="mui-content">
			<div class="up">
				<div class="mengban">
				</div>
				<div class="bg">
				</div>
				<div class="con_up1">
					<img src="../img/logo-ai_03.png" class="yuantu" />
					<p class="p1"></p>
				</div>
				<div class="con_up2">
					<ul>
							<li class="l2">
								<p class="pp2 fuwu">服务</p>
							</li>
							<li class="l2 jianjie">
								<p class="pp2">简介</p>
							</li>
						<li class="l2">
							<p class="pp2 change_p">作品</p>
							<div class="Triangle"></div>
						</li>
					</ul>
				</div>
				<div style="clear: both;"></div>
			</div>
			<div class="moddile">

			</div>


			<div class="mui-backdrop">
				<div class="item-wrapper">
					<div class="item" id="load">
						<div class="ball">
							<div></div>
							<div></div>
						</div>
						<div id="txt" style="margin-top: 10px;">loading...</div>
					</div>
				</div>
			</div>
		</div>

		<script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script>
		<script type="text/javascript" src="../js/mui.min.js"></script>
		<script type="text/javascript" src="../js/getParam.js"></script>
		<script type="text/javascript" src="../js/server.js"></script>
		<script type="text/javascript" src="../js/date.js"></script>
		<script>
			mui.init();
			var $mask = $(".mui-backdrop");
			var id = GetQueryString("id");
			  (id);
			$(".fuwu").on("tap",function () {
				window.location.href = "../MainPage/SysInfor?id=" + id;
			});
			$(".jianjie").on("tap",function () {
				window.location.href = "../wechatuser/sheyingshi-jianjie.jsp?id=" + id;
			});
			$(function () {
				jiazaitouxiang();
				jiazaizuoping();
			});
			function jiazaitouxiang() {
				var html = "";
				$.ajax({
					url: "../sysPort/getSysinforBySysid",
					data: {"id": id},
					type: "post",
					dataType: "json",
					success: function (data) {
						var name = data.itemName;
						var img = data.itemHeadimg;
						var path = "";
						if(img){
							path = imgpre + JSON.parse(img)[0].path;
						}else {
							path = "../images/photographer.png";
						}
						var Bgimg = data.Fmbjtp;
						var Bgimgpath = "";
						if(Bgimg){
							Bgimgpath = imgpre + JSON.parse(Bgimg)[0].path;
						}else {
							Bgimgpath = "../images/SysBg.jpg";
						}
						$(".bg").css("background","url("+Bgimgpath+")");
						$(".bg").css("background-size","100% 100%");
						$(".yuantu").attr("src",path);
						$(".p1").text(name);
					}
				});
			}


			function jiazaizuoping() {
				var html = "";
				$.ajax({
					url: "../product/ProductShow",
					data: {"id": id},
					type: "post",
					dataType: "json",
					success: function (data) {
						if(data.length !=0){
                        for(var i=0;i<data.length;i++)
						{
							var name = data[i].itemTitle;
							var imgpath = imgpre + JSON.parse(data[i].itemZpfm)[0].path;
							var time = new Date(data[i].created).format("yyyy年MM月dd日") + "";
							html = '<div class="m1" id="'+data[i].id+'">'+
									'<img src="'+imgpath+'" /><p class="mp_1">'+name+'</p><p class="mp_2">'+time+'</p></div>'
							$(".moddile").append(html);
								$(".m1").on("tap", function () {
									window.location.href = "../MainPage/Zuoping?id=" + $(this).attr("id");
								});
							}
						}else {
							$(".moddile").append('<p>&nbsp;&nbsp;&nbsp;暂无作品信息</p>')
						}
						$mask.hide();
					}
				});
			}

		</script>
	</body>

</html>