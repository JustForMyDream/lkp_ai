<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

	<head>
		<meta charset="UTF-8">
		<title>立可拍</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link href="../css/mui.min.css" rel="stylesheet" />
		<link href="../css/base.css" rel="stylesheet">
		<style>
			body,
			html,
			.mui-content {
				background-color: white;
			}

			header {
				height: 40px;
				background-color: white;
			}

			.mui-icon-arrowleft{
				font-weight: lighter;
				font-size: 30px !important;
				color: #797979;
			}

			.moddile {
				width: 100%;
				height: auto;
			}

			.mo2 {
				padding-left: 10px;
				padding-right: 10px;
			}

			.mo1 {
				width: 100%;
				height: auto;
			}

			.mo1 img {
				width: 100% !important;
				height: auto !important;
			}

			.mo2 img {
				width: 100%;
				/*margin-left: 5%;*/
				height: auto;
			}

			.pp {
				font-family: "微软雅黑";
				padding-left: 5%;
				font-size: 15px;
			}

			.pp2 {
				font-family: "微软雅黑";
				padding-left: 5%;
				font-size: 15px;
				color: black;
			}

			.mo2_1 {
				margin-top: 10px;
				margin-bottom: 10px;
			}

			.pp1 {
				color: black;
				margin-top: -25px;
				margin-left: 25px;
				font-size: 20px;
				font-family: "微软雅黑";
			}

			.pp_2 {
				font-family: "微软雅黑";
				font-size: 15px;
			}

			.mm {
				text-align: center;
			}

			.mo2_11 img {
				width: 42%;
			}

			.mr {
				margin-top: -25px;
				background-color: white;
			}

			.mr2 {
				margin-top: 20px;
			}

			h2 {
				height: 2rem;
				line-height: 2rem;
				font-size: 16px;
				font-weight: bold;
				color: #222;
				position: relative;
			}

			h2 > font {
				display: inline-block;
				width: 20%;
				height: 0.05rem;
				background: #AAAAAA;
				position: relative;
				top: 0.95rem;
				vertical-align: top;
			}

			h2 > span {
				display: inline-block;
				margin: 0 auto;
				font-weight: bold;
				color: #000000;
			}

			.mo3 {
				margin-top: 5px;
				text-align: center;
			}

			ul {
				width: 100%;
				float: left;
				padding-left: 0%;
				overflow: hidden;
				padding-right: 5%;
			}

			.l1 {
				width: 50%;
				float: left;
				overflow: hidden;
				padding-left: 5%;
			}

			.l2 {
				width: 33.3%;
				float: left;
				overflow: hidden;
				padding-left: 5%;
				text-align: center;
				padding-top: 25px;
			}

			.l_i2 {
				width: 100px;
			}
			.yuantu {
				width: 70px;
				height: 70px;
				border-radius: 50%;
			}
		</style>
	</head>

	<body>
		<div class="mui-content">
			<header class="mui-bar mui-bar-nav" style="border-bottom: 1px solid #dcdcdc;    background-color: white;">
				<a class="mui-icon mui-action-back mui-icon-arrowleft">
				</a>
				<h1 class="mui-center mui-title"></h1>
			</header>
			<div class="moddile">
				<div class="mo1">
					<!--<img src="../img/t1.jpg" />-->
				</div>
				<div class="mo2">
			</div>
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
		<script src="../js/mui.min.js"></script>
		<script src="../js/jquery-2.1.4.min.js"></script>
		<script src="../js/getParam.js"></script>
		<script src="../js/server.js"></script>
		<script type="text/javascript">
			mui.init()
			var $mask = $(".mui-backdrop");
			var html = "";
			var id = GetQuery("id")
			window.onload = function () {
				mainLoad();
			}
			function mainLoad() {

				$.ajax({
					url: "../tlksctj/find",
					type: "post",
					data: {id: id},
					dataType: "json",
					timeout: "10000",
					success: function (data) {
						  (data);
						if (data.itemSfzs == 1 && data.itemSfwl == 0) {
							var name = data.itemName;
							$(".mui-title").text(name);
							var img = JSON.parse(data.itemCover)[0].path;
							html = '<img class="mo1" src="' + imgpre + img + '">';
							  ($(".mo1"));
							$(".mo1").append(html);
							var src = domain;
							var reg = /[iI][mM][gG][\s]*[sS][rR][cC][\s]*=[\s]*['"]([\s\S]*?)['"]/gi;
							var s = data.itemDetail.replace(reg, function (match, capture) {
								return match.replace(capture, src + capture);
							});
							$('.mo2').append(s);
						} else if (data.itemSfwl == 1) {
							window.location.href = data.itemwllj;
						}
						$mask.hide();
					},
					error: function (e) {
						  ("查询失败");
					}
				});
			}
		</script>
	</body>

</html>