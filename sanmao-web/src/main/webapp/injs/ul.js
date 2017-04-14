var localUrl = "http://localhost:8080/sanmao-web/";
var Url = {
		payDetail:{
			  add:localUrl+"web/payDetail/insert.do",
			query:localUrl+"web/payDetail/getList.do"	
		},
		payType:{
			query:localUrl+"web/payType/getList.do"	
		}
		
}

//绑定字典内容到指定的Select控件
function BindSelectBox(ctrlName, data) {
    var control = $('#' + ctrlName);
    control.empty();//清空 下拉框
    for (var i = 0; i < data.length; i++) {
    	control.append("<option value=" + data[i].id + ">" + data[i].name + "</option>");
    }
}