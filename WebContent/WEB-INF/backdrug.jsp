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
			.form-control:focus {
				border-color: #fff;
				webkit-box-shadow: none;
				box-shadow: none;
			}
			.table tbody tr td {
	vertical-align: middle;
  }
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
						<li><a id="operatorer" href="#"></a></li>
				        <li><a href="#">帮助</a></li>
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
							<a href="/JavaWeb_Day3/index.jsp">&nbsp;&nbsp;&nbsp;药&nbsp;&nbsp;&nbsp;品&nbsp;&nbsp;&nbsp;管&nbsp;&nbsp;&nbsp;理
					</a></li>
					<li><a href="#">&nbsp;&nbsp;&nbsp;退&nbsp;&nbsp;&nbsp;药&nbsp;&nbsp;&nbsp;管&nbsp;&nbsp;&nbsp;理</a></li>
					<li><a href="/JavaWeb_Day3/senddrug.jsp">&nbsp;&nbsp;&nbsp;发&nbsp;&nbsp;&nbsp;药&nbsp;&nbsp;&nbsp;管&nbsp;&nbsp;&nbsp;理</a></li>

					</ul>

				</div>
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<h1 class="page-header">退药系统</h1>
					

					<!--面板 开始-->
					<div class="panel panel-default">
						<div class="panel-body">
						<!--表格上面的那一行-->
						<div class="row">
							<div class="col-md-3">
								<div class="input-group">
									<input type="text" id="caseId" class="form-control"
										placeholder="请输入病历号" name="helpId"
										formaction="FindDrugInfo"> <span
										class="input-group-btn">
										<button class="btn btn-default" type="submit" id="search">查询</button>
									</span>
								</div>
								<!-- /input-group -->
							</div>
						</div>
						<!--表格上面那一行 结束-->
						<!--表格 开始-->
						<div class="table-box">
							<table class="table table-bordered table-striped" id="table">
								<thead>
									<tr>
									<th scope="col" class="text-center">病历号</th>
									<th scope="col" class="text-center">姓名</th>
									<th scope="col" class="text-center">年龄</th>
									<th scope="col" class="text-center">性别</th>
									<th scope="col" class="text-center">科室</th>
									<th scope="col" class="text-center">收票时间</th>
									<th scope="col" class="text-center">状态</th>
									<th scope="col" class="text-center">操作</th>
									</tr>
								</thead>
								<tbody id="tuiyao">

								</tbody>
							</table>
						</div>
					</div>

					<h5 class="page-header"></h5>
					<div class="panel panel-default">
						<div class="panel-body">
						<table class="table table-bordered table-striped" id="table2">
							<thead>
								<tr>
									<th scope="col" class="text-center">病历号</th>
									<th scope="col" class="text-center">姓名</th>
									<th scope="col" class="text-center">年龄</th>
									<th scope="col" class="text-center">性别</th>
									<th scope="col" class="text-center">科室</th>
									<th scope="col" class="text-center">收票时间</th>
									<th scope="col" class="text-center">状态</th>
									
								</tr>
							</thead>
							<tbody id="yifa">
							</tbody>
						</table>
					</div>
					</div>
					<!--面板 结束-->
				</div>
			</div>
			</div>
		</div>
		<!-- Modal -->
		<div class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						 <h5 class="modal-title" id="staticBackdropLabel">发药清单</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
					</div>
					<div class="modal-body">
						<table class="table table-bordered table-striped" id="table">
							<thead>
								<tr>
									<th scope="col" class="text-center">病历号</th>
									<th scope="col" class="text-center">药品名称</th>
									<th scope="col" class="text-center">药品编码</th>
									<th scope="col" class="text-center">药品数量</th>
									<th scope="col" class="text-center">退药操作</th>	
								</tr>
							</thead>
							<tbody id="druglist">
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal" id="close">关闭</button>
						<button type="button" class="btn btn-primary">保存修改</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Bootstrap core JavaScript
================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="./static/jquery-3.3.1.js"></script>
		<script src="./static/bootstrap-3.3.7/js/bootstrap.js"></script>
	</body>
	<script type="text/javascript">
	$(function() {
		
		
		$.ajax({
            url: "http://localhost:8080/JavaWeb_Day3/ShowPatient",
            dataType: "json",
           success: function(patientdata){
               /*这个方法里是ajax发送请求成功之后执行的代码*/
               ShowPatient(patientdata);//我们仅做数据展示
           },
           error: function(msg){
               alert("ajax连接异常："+msg);
           }
       })   
       
       
       
       
       
       
		
		
	});
	
	var search = document.getElementById("search")
	search.onclick = function() {
		var caseId = document.getElementById('caseId').value;
		var parm = {
				caseId : caseId
		}
				$.get(
						"http://localhost:8080/JavaWeb_Day3/GetPatient",
						parm,
						function FindData(d) {
							console.log(d)
							var id = d.caseId
							var str = "";
							str = '<tr><td align="center">'
									+ d.caseId
									+ '</td><td align="center">'
									+ d.name
									+ '</td><td align="center">'
									+ d.age
									+ '</td><td align="center">'
									+ d.sex
									+ '</td><td align="center">'
									+ d.dept
									+ '</td><td align="center">'
									+ d.date
									+ '</td><td align="center">'+d.isTakeMedicine+'</td><td align="center"><a style="margin-bottom: 5px;" onclick=func('
									+ d.caseId
									+ ') class="btn btn-info btn-sm" data-toggle="modal" data-target="#staticBackdrop">查看</a></td></tr>';
							console.log(str)
							$("#tuiyao").html(str);
							

						}, "json");
	}
	
	
	func =function(id){
		var arm = {
				caseid : id
			}
		$.get(
				"http://localhost:8080/JavaWeb_Day3/NotUseDrug",
				arm,
				function GetDrug(datalist) {
					var str = "";
					
					for(var i=0;i<datalist.length;i++)
						{
						
						str =  '<tr><td align="center">' + datalist[i].caseID + 
						'</td><td align="center">' + datalist[i].drugname + 
						'</td><td align="center">' + datalist[i].drugcode + 
						'</td><td align="center">'+ datalist[i].drugcount + 
						'</td><td align="center"><a class="btn btn-danger btn-sm" href="/JavaWeb_Day3/BackDrug?drugcode='
										+  datalist[i].drugcode
										+ ' &drugid='
										+  datalist[i].caseID
										+ '">'+ datalist[i].status + 
						'</a></td></tr>';
						
						$("#druglist").append(str);
						}
				}, "json");
	}
	
	$('.close').click(function(){
	    $("#druglist").empty();
	})
	
	$('#close').click(function(){
	    $("#druglist").empty();
	})
	
	
	
	function ShowPatient(patientdata){
		var str = "";
		for(var i=0;i<patientdata.length;i++)
		{
		str = '<tr><td align="center">'
				+ patientdata[i].caseId
				+ '</td><td align="center">'
				+ patientdata[i].name
				+ '</td><td align="center">'
				+ patientdata[i].age
				+ '</td><td align="center">'
				+ patientdata[i].sex
				+ '</td><td align="center">'
				+ patientdata[i].dept
				+ '</td><td align="center">'
				+ patientdata[i].date
				+ '</td><td align="center">'+patientdata[i].isTakeMedicine+'</td><td align="center"><a style="margin-bottom: 5px;" onclick=func('
				+ patientdata[i].caseId
				+ ') class="btn btn-info btn-sm" data-toggle="modal" data-target="#staticBackdrop">查看</a></td></tr>';
		console.log(str)
		$("#weifa").append(str);
		}
	}
	
	
	
	
	
	
	
	
	
	</script>

</html>