var u = sessionStorage.getItem("user");
if(u==null){
	$("#operatorer").text("登录")
}
else{
	$("#operatorer").text(u)
}


var add = document.getElementById("add")
		add.onclick = function(){
			$.post("http://localhost:8080/JavaWeb_Day3/AddDrug",{
				
				durgcode:$("#drugcode").val(),
				durgname:$("#drugname").val(),
				drugspec:$("#drugspec").val(),
				drugunit:$("#disabledSelect").val(),
				drughelpid:$("#drughelpid").val(),
				drugprice:$("#drugprice").val(),
				
			},
			function(flag){
				if(flag==1){
            		confirm("添加成功")
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
		