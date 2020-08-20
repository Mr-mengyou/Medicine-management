var u = sessionStorage.getItem("user");
if(u==null){
	$("#operatorer").text("登录")
}
else{
	$("#operatorer").text(u)
}

         var pageTotal = 0;//总页数  
		var rowTotal = 0;//总行数  
		var currentPage = 0;//当前页数  
		var startRow = 0;//页开始行数  
		var endRow = 0;//页结束行数  
		var pageSize = 25;//每页行数  

		$(function() {

			$.ajax({
				url : "http://localhost:8080/JavaWeb_Day3/ShowDrug",
				dataType : "json",
				success : function(data) {
					/*这个方法里是ajax发送请求成功之后执行的代码*/
					//我们仅做数据展示		
					rowTotal = data.length;
					$('.text-primary').html("当前药品类型有"+rowTotal+"种")
					pageTotal = Math.ceil(rowTotal / pageSize);//上取整  
					currentPage = 1;
					if (pageTotal == 1) {
						for (var i = 0; i < pageSize; i++) {
							$("#table tbody").append(
									$('<tr><td align="center"><input style="zoom:30%;" type="checkbox" id="checkbox" name="checkbox" value='+ data[i].helpId
											+ '></td><td align="center">'
											+ data[i].code
											+ '</td><td align="center">'
											+ data[i].name
											+ '</td><td align="center">'
											+ data[i].spec
											+ '</td><td align="center">'
											+ data[i].unit
											+ '</td><td align="center">'
											+ data[i].helpId
											+ '</td> <td align="center">'
											+ data[i].price
											+ '</td> <td align="center"><a style="margin: 5px;" id ="del" class="btn btn-danger btn-sm" onclick=func("'
											+ data[i].helpId
											+ '")>删除</a><a id ="update" class="btn btn-info btn-sm" href="/JavaWeb_Day3/UpdateDrug?helpid='
											+ data[i].helpId + '">编辑</a></td></tr>'));
						}
					} else {
						for (var i = 0; i < pageSize; i++) {
							$("#table tbody").append(
									$('<tr><td align="center"><input style="zoom:30%;" type="checkbox" id="checkbox" name="checkbox" value='+ data[i].helpId
											+ '></td><td align="center">'
											+ data[i].code
											+ '</td><td align="center">'
											+ data[i].name
											+ '</td><td align="center">'
											+ data[i].spec
											+ '</td><td align="center">'
											+ data[i].unit
											+ '</td><td align="center">'
											+ data[i].helpId
											+ '</td> <td align="center">'
											+ data[i].price
											+ '</td> <td align="center"><a style="margin: 5px;" id ="del" class="btn btn-danger btn-sm" onclick=func("'
											+ data[i].helpId
											+ '")>删除</a><a id ="update" class="btn btn-info btn-sm" href="/JavaWeb_Day3/UpdateDrug?helpid='
											+ data[i].helpId + '">编辑</a></td></tr>'));
						}
						for (var i = 1; i < pageTotal + 1; i++) {
							$("#page_ul").append(
									
									$("<li><a href='#'>" + i + "</a><li>")

							);

						}

					}

				},
				error : function(msg) {
					alert("ajax连接异常：" + msg);
				}
			})

			

			$("#page_ul").on("click","a",function() {
				var pageNum = $(this).text();
				gotoPage(pageNum);
			});
			$("#page_prev").on("click","li", function() {
				if (currentPage == 1) {
				} else {
					gotoPage(--currentPage);
				}
			});
			$("#page_next").on("click","li", function() {
				if (currentPage == pageTotal) {
				} else {
					gotoPage(++currentPage);
				}
			})

		});

		

		function gotoPage(pageNum) {

			$.ajax({

				url : "http://localhost:8080/JavaWeb_Day3/ShowDrug",
				type : "POST",
				dataType : "json",
				timeout : 1000,
				error : function() {
					alert("ajax error");
				},
				success : function(data) {
					currentPage = pageNum;
					startRow = pageSize * (pageNum - 1);
					endRow = startRow + pageSize;
					endRow = (rowTotal > endRow)? endRow : rowTotal;
					$("#table tbody").empty();
					for (var i = startRow; i < endRow; i++) {
						$("#table tbody").append(
								$('<tr><td align="center"><input style="zoom:30%;" type="checkbox" id="checkbox" name="checkbox" value='+ data[i].helpId
										+ '></td><td align="center">'
										+ data[i].code
										+ '</td><td align="center">'
										+ data[i].name
										+ '</td><td align="center">'
										+ data[i].spec
										+ '</td><td align="center">'
										+ data[i].unit
										+ '</td><td align="center">'
										+ data[i].helpId
										+ '</td> <td align="center">'
										+ data[i].price
										+ '</td> <td align="center"><a style="margin: 5px;" id ="del" class="btn btn-danger btn-sm" onclick=func("'
										+ data[i].helpId
										+ '")>删除</a><a id ="update" class="btn btn-info btn-sm" href="/JavaWeb_Day3/UpdateDrug?helpid='
										+ data[i].helpId + '">编辑</a></td></tr>')

						);

					}

				}

			});

		}
		
		
		var spdelet = document.getElementById("deletes")
	       spdelet.onclick = function(){
				
		        var checkhelpid=[];
		        
		        $("input[name='checkbox']:checked").each(function(i){
		              str = $(this).val();
		              
		              checkhelpid[i]=str
		              
		             
		              
		        });
		        console.log(checkhelpid)
								$.ajax({
		                    type : "post",
							url : "http://localhost:8080/JavaWeb_Day3/DelteDrug",
							traditional: true,
		                	data:{'checkID':checkhelpid},
		                    dataType:"text",
		                    success : function(flag) {
		                    	if(flag==1){
		                    		confirm("删除成功")
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
							},
		                 	});
			}
		func = function(helpid){
			$.ajax({
                type : "get",
				url : "http://localhost:8080/JavaWeb_Day3/DelteDrug",
				traditional: true,
            	data:{'id':helpid,
            	},
                dataType:"text",
                success : function(flag) {
                	if(flag==1){
                		confirm("删除成功")
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
                	
				},
             	});	
		}
		
		

		var add = document.getElementById("add")
		add.onclick = function() {
			window.location.href = "/JavaWeb_Day3/add_drug.html";

		}