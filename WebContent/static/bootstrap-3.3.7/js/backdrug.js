var u = sessionStorage.getItem("user");
if(u==null){
	$("#operatorer").text("登录")
}
else{
	$("#operatorer").text(u)
}


$(function() {
	$("#transform1").removeClass("active");
	$("#transform3").addClass("active");
	$("#transform2").removeClass("active");
		
		
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
       
       
       
       var bk = document.getElementById("back")
       bk.onclick = function(){
			
	        var checkID=[];
	        var caseId=[];
	        $("input[name='checkbox']:checked").each(function(i){
	              str = $(this).val();
	              arry = str.split("+")
	              checkID[i]=arry[0]
	              
	              caseId[i]=arry[1]
	              
	        });
	        console.log(checkID)
	        console.log(caseId)
							$.ajax({
	                    type : "post",
						url : "http://localhost:8080/JavaWeb_Day3/BackDrug",
						traditional: true,
	                	data:{'checkID':checkID,
	                		'caseId':caseId
	                		
	                	},
	                    dataType:"text",
	                    success : function(flag) {
	                    	if(flag==1){
	                    		confirm("退药成功")
		                    	window.location.href="/JavaWeb_Day3/backdrug.html";
	                    	}
	                    	else if(flag==2){
	        					confirm("您只有录药权限")
	        					window.location.href="/JavaWeb_Day3/index.html";
	        				}
	                    	else{
	                    		confirm("您没有操作权限，请登录")
	                    		window.location.href="/JavaWeb_Day3/login.html";
	                    	}
	                    	
						},
	                 	});
		}
       
       
       
       
       
       
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
					if(datalist.length==0){
						str =  '<tr><td align="center" colspan="6">暂无可退药药品清单</td></tr>';
						
						$("#druglist").append(str);
					}else{
						for(var i=0;i<datalist.length;i++)
						{
						
						str =  '<tr><td align="center"><input type="checkbox" id="checkbox" name="checkbox" value='+datalist[i].drugcode+'+'+datalist[i].caseID+'></td><td align="center">' + datalist[i].caseID + 
						'</td><td align="center">' + datalist[i].drugname + 
						'</td><td align="center">' + datalist[i].drugcode + 
						'</td><td align="center">'+ datalist[i].drugcount + 
						'</td><td align="center">'+ datalist[i].usestatus + 
						'</td></tr>';
						
						$("#druglist").append(str);
						}
						
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
		$("#tuiyao").append(str);
		
		}
	}