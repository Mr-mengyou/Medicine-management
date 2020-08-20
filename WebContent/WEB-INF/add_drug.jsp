<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="icon" href="https://v3.bootcss.com/favicon.ico">
		<title>Dashboard Template for Bootstrap</title>
		<!-- Bootstrap core CSS -->
		<link href="./static/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet">
		<!-- 当前页面用到的自定义样式 -->
		<link href="./static/dashboard.css" rel="stylesheet">

	</head>

	<body>

		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
					<a class="navbar-brand" href="#">药品管理系统</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<!--<li><a href="#">Dashboard</a></li>
                <li><a href="#">Settings</a></li>-->
						<li>
							<a href="#">登录</a>
						</li>
						<li>
							<a href="#">帮助</a>
						</li>
					</ul>
					<form class="navbar-form navbar-right">
						<input class="form-control" placeholder="Search..." type="text">
					</form>
				</div>
			</div>
		</nav>

		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3 col-md-2 sidebar">
					<ul class="nav nav-sidebar">
						<li class="active">
							<a href="#">药品管理 <span class="sr-only">(current)</span></a>
						</li>
						<li>
							<a href="#">退药管理</a>
						</li>
						<li>
							<a href="#">发药管理</a>
						</li>
						
					</ul>
				
				</div>
				<div class="col-sm-12 col-sm-offset-3 col-md-9 col-md-offset-2 main">
					<h1 class="page-header">药品添加</h1>	
					
					
					<form class="form-horizontal" role="form"  method="post">
					<div class="form-group">
							<label for="firstname" class="col-sm-4 control-label">药品序列</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="drugid" name="drugid" placeholder="请输入药品编码">
							</div>
						</div>
						<div class="form-group">
							<label for="firstname" class="col-sm-4 control-label">药品编码</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="drugcode" name="drugcode" placeholder="请输入药品编码">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-4 control-label">药品名称</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="drugname" name="drugname" placeholder="请输入药品名称">
							</div>
						</div>
					   <div class="form-group">
							<label for="lastname" class="col-sm-4 control-label">药品规格</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="drugspec" name="drugspec" placeholder="请输入药品规格">
							</div>
						</div>	
						
						<div class="form-group">
							<label for="lastname" class="col-sm-4 control-label">药品单位</label>
							<div class="col-sm-5">
								<select id="disabledSelect" name="drugunit" class="form-control">
									<option style="display: none;"></option>
									<option>支</option>
									<option>盒</option>
									<option>瓶</option>
									<option>袋</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-4 control-label">药品助记码</label>
							<div class="col-sm-5">
								<input type="text" class="form-control"  id="drughelpid" name="drughelpid" placeholder="请输入药品助记码">
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-4 control-label">药品单价</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="drugprice" name="drugprice" placeholder="请输入药品单价">
							</div>
						</div>
						<div class="form-group">				
							<div class="col-sm-12" align="center">
							<input type="button" value="确认添加" class="btn btn-primary" id="add">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset"class="btn btn-primary"  value="重置">
								
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>

		<!-- Bootstrap core JavaScript
================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="./static/jquery-3.3.1.js"></script>
		<script src="./static/bootstrap-3.3.7/js/bootstrap.js"></script>
		<script type="text/javascript">
		
		var add = document.getElementById("add")
		add.onclick = function(){
			$.post("http://localhost:8080/JavaWeb_Day3/AddDrug",{
				id:$("#drugid").val(),
				durgcode:$("#drugcode").val(),
				durgname:$("#drugname").val(),
				drugspec:$("#drugspec").val(),
				drugunit:$("#disabledSelect").val(),
				drughelpid:$("#drughelpid").val(),
				drugprice:$("#drugprice").val(),
				
			},
			function(data){
				window.location.href="/JavaWeb_Day3/index.jsp";
			});
			
			
		}
		

		
		</script>
		
	

	</body>

</html>