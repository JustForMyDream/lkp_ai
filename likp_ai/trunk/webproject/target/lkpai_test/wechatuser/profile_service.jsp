<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	System.out.println(basePath);
%>
<html>
	<head>
		<title>${name}de个人主界面</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link href="../css/mui.min.css" rel="stylesheet">
		<link href="../css/sheyingshi.css" rel="stylesheet" />
		<link href="../css/base.css" rel="stylesheet">
		<style>
			.mui-content,
			body {
				background-color: white;
			}

			.moddile {
				width: 100%;
				text-align: center;
				height: auto;
				z-index: 1;
			}
			
			.m1 {
				width: 100%;
				text-align: center;
				height: auto;
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
				padding-top: 4px;
			}
			
			.mp_2 {
				font-family: "微软雅黑";
				color: red;
				font-size: 12px;
				margin-top: -4px;

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

						<li class="l2">
							<p class="pp2 change_p">服务</p>
							<div class="Triangle"></div>
						</li>
						<a href="../wechatuser/sheyingshi-jianjie.jsp?id=${id}">
						<li class="l2">
							<p class="pp2">简介</p>
						</li>
							</a>
						<a href="../wechatuser/sheyingshi-zuoping.jsp?id=${id}">
						<li class="l2">
							<p class="pp2">作品</p>
						</li>
							</a>
					</ul>
				</div>
				<div style="clear: both;"></div>
			</div>
			<div class="moddile">
				<%--<div class="m1">--%>
					<%--<img src="../img/5.jpg" />--%>
					<%--<p class="mp_1">爱之陪伴</p>--%>
					<%--<p class="mp_2">￥999.00</p>--%>
				<%--</div>--%>
				<%--<div class="m1">--%>
					<%--<img src="../img/2.jpg" />--%>
					<%--<p class="mp_1">亲爱的宝贝</p>--%>
					<%--<p class="mp_2">￥799.00</p>--%>
				<%--</div>--%>
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

		<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
		<script type="text/javascript" src="../js/mui.min.js"></script>
		<script type="text/javascript" src="../js/server.js"></script>
		<script type="text/javascript" src="../js/slider.js"></script>
		<script type="text/javascript" src="../js/getParam.js"></script>

		<script>
			mui.init();
			var $mask = $(".mui-backdrop");
			var title="${name}";
			var id = "${id}";
			var img = '${img}';
			var Bgimg = '${Bgimg}';
			var bh = "${bh}";
			  ("cdvh"+bh)
			var Bgimgpath = "";
			var path = "";
			if(img){
				path = imgpre + JSON.parse(img)[0].path;
			}else {
				path = "../images/photographer.png";
			}

			if(Bgimg){
				Bgimgpath = imgpre + JSON.parse(Bgimg)[0].path;
			}else {
				Bgimgpath = "../images/SysBg.jpg";
			}

			  (title+"   "+id+"  "+path);
			$(".yuantu").attr("src",path);
			$(".p1").text(title);
			$(".bg").css("background","url("+Bgimgpath+")");
			$(".bg").css("background-size","100% 100%");
			$(function () {
				jiazaifuwu();
			});
			/*
			 * 加載服務信息*/
			function jiazaifuwu() {
				var html = "";
				$.ajax({
					url: "../product/ProductsBySysid",
					data: {"id": id},
					type: "post",
					dataType: "json",
					success: function (data) {
						$mask.hide();
						if(data.length !=0) {
							for (var i = 0; i < data.length; i++) {
								var id = data[i].id;
								var img = JSON.parse(data[i].itemCover);
								var path = img[0].path;
								var name = data[i].itemName;
								var price = data[i].itemPrice;
								var cpbh = data[i].itemCpbh;
								html = '<div class="m1" id="' + id + '"><img src="' + imgpre + path + '" /><p class="mp_1">' + name + '</p>' +
										'<p class="mp_2">' + '￥' + price + '.00' + '</p></div>';
								$(".moddile").append(html);
							}
							$(".m1").on("tap", function () {
								window.location.href = "../MainPage/ProductInfor?id=" + $(this).attr("id");
							});
						}else {
							$(".moddile").append('<p>&nbsp;&nbsp;&nbsp;暂无推荐</p>')
						}

//						$mask.hide();
					}
				});
			}

		</script>
	</body>

</html>