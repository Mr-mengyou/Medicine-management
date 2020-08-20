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
		<style type="text/css">
    	
    </style>

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
						<li><a id="operatorer" href="/JavaWeb_Day3/login.html"></a></li>
						<li><a href="/JavaWeb_Day3/login.html">注销</a></li>
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
							<a href="/JavaWeb_Day3/index.html">&nbsp;&nbsp;&nbsp;药&nbsp;&nbsp;&nbsp;品&nbsp;&nbsp;&nbsp;管&nbsp;&nbsp;&nbsp;理
					</a></li>
					<li><a href="/JavaWeb_Day3/senddrug.html">&nbsp;&nbsp;&nbsp;发&nbsp;&nbsp;&nbsp;药&nbsp;&nbsp;&nbsp;管&nbsp;&nbsp;&nbsp;理</a></li>
					<li><a href="/JavaWeb_Day3/backdrug.html">&nbsp;&nbsp;&nbsp;退&nbsp;&nbsp;&nbsp;药&nbsp;&nbsp;&nbsp;管&nbsp;&nbsp;&nbsp;理</a></li>
						
					</ul>
				
				</div>
				<div class="col-sm-12 col-sm-offset-3 col-md-9 col-md-offset-2 main">
					<h1 class="page-header">药品修改</h1>	
					
					
					<form class="form-horizontal" role="form"  method="post">
					
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
							<input type="button" value="确认修改" class="btn btn-primary" id="update">
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
		var u = sessionStorage.getItem("user");
		if(u==null){
			$("#operatorer").text("登录")
		}
		else{
			$("#operatorer").text(u)
		}
	
		$(function(){
			
			
			$("#drugcode").val(<%=request.getAttribute("d")%>[0].code)
			$("#drugname").val(<%=request.getAttribute("d")%>[0].name)
			$("#drugspec").val(<%=request.getAttribute("d")%>[0].spec)
			$("#disabledSelect").val(<%=request.getAttribute("d")%>[0].unit)
			$("#drughelpid").val(<%=request.getAttribute("d")%>[0].helpId)
			$("#drugprice").val(<%=request.getAttribute("d")%>[0].price)
			//点击了编辑按钮<a ..... href="/JavaWeb_Day3/UpdateDrug?helpid='+ data[i].helpId + '">编辑</a>
			//发起一次get请求取到要编辑药物的基本信息，显示在update.jsp页面
			//当修改完成后，提交post请求表单，将表单提交给后台处理，执行sql语句，写入数据库
			
			
			var update = document.getElementById("update")
			update.onclick = function(){
				
				$.post("http://localhost:8080/JavaWeb_Day3/UpdateDrug",{
					
					drugid: <%=request.getAttribute("d")%>[0].id,
					durgcode:$("#drugcode").val(),
					durgname:$("#drugname").val(),
					drugspec:$("#drugspec").val(),
					drugunit:$("#disabledSelect").val(),
					drughelpid:$("#drughelpid").val(),
					drugprice:$("#drugprice").val(),
					
				},
				function(flag){
					if(flag==1){
	            		confirm("修改成功")
	                	window.location.href="/JavaWeb_Day3/index.html";
	            	}
					else if(flag==2){
						confirm("您只有发药和退药权限")
						window.location.href="/JavaWeb_Day3/senddrug.html";
					}
	            	else{
	            		confirm("您没有操作权限，请登录")
	            		window.location.href="/JavaWeb_Day3/login.html";
	            	}
				});
				
				
			}
			
		}
	);
		
		
		

		
		</script>
		
	

	</body>

</html>