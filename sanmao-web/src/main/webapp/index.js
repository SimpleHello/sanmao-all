var localUrl = "http://localhost:8080/sanmao-web/";
var deleteBy = function(){
	$.messager.confirm('004', "请 确认 是否 删除 boo ode 111 为：by  的数据", function(r){
        if (r){
        	$.ajax({
    			url: localUrl+"student/insert.do",
    			dataType: 'json', 
    			success: function(mes){
    				$.messager.alert("结果",mes.result);
    			}
    		});
        	alert("2222 by deleteBy")
        }
    });

}

var deletAll = function(){
	$.messager.confirm('确认删除', "全部 删除", function(r){
        if (r){
        	$.ajax({
    			url: localUrl+"student/insert.do",
    			dataType: 'json', 
    			success: function(mes){
    				$.messager.alert("结果",mes.result);
    			}
    		});
        	alert("1111111111111 by deletAll")
        }
    });
	
}