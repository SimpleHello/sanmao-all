$(function(){
	payTypeDataLoad();
	var doa = DateUtil.getNowFormatDate(); 
	$("#payDetail_payDate").val(doa)
	window.payDetail = {
			addPayDetail:function(){
				addPayDetail();
			},
			update:function(){
				updatePayDetail();
			},
			Delete:function(){
				Delete();
			},
			payTypeDataLoad:function(){
				payTypeDataLoad();
			}
	};
	 $('#payDetail_table').bootstrapTable("destroy").bootstrapTable({
            method: 'get',
//      	contentType: "application/x-www-form-urlencoded",//必须的，
            url: Url.payDetail.query,
            striped: true,
            height: $(window).height() - 150,  
            pagination: true,
            singleSelect: true,//复选框只能选择一条记录
            clickToSelect: true,//点击行即可选中单选/复选框
            search: false, //不显示 搜索框
            showColumns: false, //不显示下拉框（选择显示的列）
            sidePagination: "server", //服务端请求
            toolbar: "#exampleToolbar",
//          queryParams: queryParams,
            columns: [{
                field: 'state',
                checkbox: true

            }, {
                field: 'id',
                title: 'ID',
                width: 100
            }, {
                field: 'typeFaName',
                title: '大类1',
                width: 80

            }, {
                field: 'typeName',
                title: '小类',
                width: 80
            }, {
                field: 'payNum',
                title: '金额',
                width: 80

            }, {
                field: 'payDate',
                title: '支出时间',
                width: 80,
                formatter:function(value, row, index){
                	return DateUtil.toYYYYMMDD(value);
                }

            }, {
                field: 'bake',
                title: '吐槽点4',
                width: 200

            }],
            onLoadError: function () {
                mif.showErrorMessageBox("数据加载失败！");
            }
        });

//	payDetail_typeTop 大类
//	payDetail_typeLit 小类
 function payTypeDataLoad(){
	 $.ajax({
			url: Url.payType.query,
			type: "post",
	        dataType: "json",
	        data:{"faId":-1},
			success: function(data){
				BindSelectBox("payDetail_typeTop",data);
				payTypeLit();
			}
		});
	    $("#payDetail_typeTop").on("change", function (e) {
	        payTypeLit();
	    });
 }
 

 function payTypeLit(){
	 var faId = $("#payDetail_typeTop").val();
	 $.ajax({
 		url: Url.payType.query,
 		type: "post",
 		data:{"faId":faId},
         dataType: "json",
 		success: function(data){
 			BindSelectBox("payDetail_typeLit",data);
 		}
 	});
 }

 function updatePayDetail(){
	 var obj =  new Object();
	 obj.typeId = $("#payDetail_typeLit").val();
	 obj.bake = $("#payDetail_bake").val();
	 obj.payNum =$("#payDetail_payNum").val();
	 obj.payDate =DateUtil.toDate($("#payDetail_payDate").val());
	 $.ajax({
	 		url: Url.payDetail.add,
	 		type: "post",
	 		data:obj,
	        dataType: "json",
	 		success: function(data){
	 			alert("");
	 		}
	 	});
 }
 
 function addPayDetail(){
	 var obj =  new Object();
	 obj.typeId = $("#payDetail_typeLit").val();
	 obj.bake = $("#payDetail_bake").val();
	 obj.payNum =$("#payDetail_payNum").val();
	 obj.payDate = $("#payDetail_payDate").val();
	 $.ajax({
	 		url: Url.payDetail.add,
	 		type: "post",
	 		data:obj,
	        dataType: "json",
	 		success: function(data){
	 			alert("");
	 		}
	 	});
 }
});