DateUtil = {
		
		/**
		 * 日期对象转为"yyyy-mm-dd"格式文本
		 * @param {Date} oDate
		 * @return {String} yyyy-mm-dd
		 */
		toYYYYMMDD: function(oDate) {
			if(StringUtil.isNull(oDate)) return "";
			if(oDate.length == 0) return "";
			var regEx = new RegExp("\\-","gi");
			oDate=oDate.replace(regEx,"/");
			var sDate = new Date(oDate);
			  var sMonth = (sDate.getMonth() + 1).toString();
			  var sDay = (sDate.getDate()).toString();
			  if(sMonth.length < 2) sMonth = '0' + sMonth; 
			  if(sDay.length < 2) sDay = '0' + sDay; 
			  
			  return sDate.getFullYear() + '-' + sMonth + '-' + sDay;
		},
		
		toYYYYMMDDHHmmss: function(oDate) {
			if(StringUtil.isNull(oDate))return "";
			var regEx = new RegExp("\\-","gi");
			oDate=oDate.replace(regEx,"/");
			var sDate = new Date(oDate);
			  var sMonth = (sDate.getMonth() + 1).toString();
			  var sDay = (sDate.getDate()).toString();
			  var sHour = (sDate.getHours()).toString();
			  var sMinute = (sDate.getMinutes()).toString();
			  var sSecond = (sDate.getSeconds()).toString();
			  if(sMonth.length < 2) sMonth = '0' + sMonth; 
			  if(sDay.length < 2) sDay = '0' + sDay; 
			  if(sHour.length<2) sHour ='0'+sHour;
			  if(sMinute.length<2) sMinute ='0'+sMinute;
			  if(sSecond.length<2) sSecond ='0'+sSecond;
			  return sDate.getFullYear() + '-' + sMonth + '-' + sDay + ' '+sHour+':'+sMinute+':'+sSecond;
		},
		
		toHHmmss: function(oDate) {
			if(StringUtil.isNull(oDate))return "";
			var regEx = new RegExp("\\-","gi");
			oDate=oDate.replace(regEx,"/");
			var sDate = new Date(oDate);
			  var sMonth = (sDate.getMonth() + 1).toString();
			  var sDay = (sDate.getDate()).toString();
			  var sHour = (sDate.getHours()).toString();
			  var sMinute = (sDate.getMinutes()).toString();
			  var sSecond = (sDate.getSeconds()).toString();
			  if(sMonth.length < 2) sMonth = '0' + sMonth; 
			  if(sDay.length < 2) sDay = '0' + sDay; 
			  if(sHour.length<2) sHour ='0'+sHour;
			  if(sMinute.length<2) sMinute ='0'+sMinute;
			  if(sSecond.length<2) sSecond ='0'+sSecond;
			  return sHour+':'+sMinute+':'+sSecond;
		},
		/**
		 * 取得年份
		 * @param {Date|String} oDate，支持yyyy-mm-dd格式
		 * @return {Int} 四位年份
		 */
		getYear: function(oDate) {
			if (typeof oDate == 'string') return parseInt(oDate.split('-')[0],10);
			
			return oDate.getFullYear();
		},
		
		/**
		 * 取得月份值(0-11)
		 * @param {Date|String} oDate，支持yyyy-mm-dd格式
		 * @return {Int} 月份值
		 */
		getMonth: function(oDate) {
			if(typeof oDate == 'string') return parseInt(oDate.split('-')[1],10)-1;
			
			return oDate.getMonth();
		},
		
		/**
		 * 取得月的天数(1-31)
		 * @param {Date|String} oDate，支持yyyy-mm-dd格式
		 * @return {Int} 天数
		 */
		getMonthDay: function(oDate) {
			if(typeof oDate == 'string') return parseInt(oDate.split('-')[2],10);
			
			return oDate.getDate();
		},
		
		/**
		 * 取得小时数(0-23)
		 * @param {Date} oDate
		 * @return {Int} 小时数
		 */
		getHours:function(oDate) {
			
			return oDate.getHours();
		},
		
		/**
		 * 取得分钟数(0-59)
		 * @param {Date} oDate
		 * @return {Int} 分钟数
		 */
		getMinutes:function(oDate) {
			
			return oDate.getMinutes();
		},
		
		/**
		 * 是否是“yyyy=mm-dd”日期字符串
		 * @param {String} sDate
		 * @return {Boolean} 是或否
		 */
		isYYYYMMDD: function(sDate) {
			if(!sDate || typeof sDate != 'string') return false;
			//fuck,js不支持yyyy-MM-dd格式的parse，支持yyyy/MM/dd的格式
			if(!(new RegExp (/^(\d{1,4})(-)(\d{1,2})\2(\d{1,2})$/)).test(sDate)) return false;
			
			var y = this.getYear(sDate);
			if(y < 1970) return false;
			var m = this.getMonth(sDate);
			if(m < 0 || m > 11) return false;
			var d = this.getMonthDay(sDate);
			if(d < 1 || d > 31) return false;
			
			return true;
		},
		
		/**
		 * "yyyy-mm-dd"转换为日期对象。
		 * @param {Object} sYMD "yyyy-mm-dd"格式日期
		 * @return {Date}
		 */
		toDate: function(sYMD) {
			if(!this.isYYYYMMDD(sYMD)) return null;
			
			return new Date(this.getYear(sYMD), this.getMonth(sYMD), this.getMonthDay(sYMD));
		},
		
		/**
		 * 比较两个日期的数值差
		 * @param {Date|String} oDate1
		 * @param {Date|String} oDate2
		 * @return {Int} 两个日期的毫秒差值
		 */
		compare: function(oDate1, oDate2) {
			if(!oDate1 || !oDate2) return null;
			var o1 = (typeof oDate1 == 'string')?this.toDate(oDate1):oDate1;
			var o2 = (typeof oDate2 == 'string')?this.toDate(oDate2):oDate2;
			
			return Date.parse(o1) - Date.parse(o2);
		},
		
		/**
		 * 取得某年某月的最大天数：[1-31]
		 * @param {Int} iYear 四位整数
		 * @param {Int} iMonth 整数：[0-11]
		 * @return {Int} 最大天数
		 */
		getMaxDay:function(iYear,iMonth) {
			
			return new Date(iYear, iMonth+1, 0).getDate();
		},
		/*
		 * 获取某月第一天
		 */
		getFirstDay:function(iYear,iMonth){
			return new Date(iYear, iMonth+1, 0);
		},
		
		getThisMonthFirstDayString:function(){
			var oDate = new Date();
			return oDate.getFullYear()+"-"+(oDate.getMonth()+1)+"-1";
		},
		getNowFormatDate:function () {
		    var date = new Date();
		    var seperator1 = "-";
		    var seperator2 = ":";
		    var month = date.getMonth() + 1;
		    var strDate = date.getDate();
		    if (month >= 1 && month <= 9) {
		        month = "0" + month;
		    }
		    if (strDate >= 0 && strDate <= 9) {
		        strDate = "0" + strDate;
		    }
		    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
		            + " " + date.getHours() + seperator2 + date.getMinutes()
		            + seperator2 + date.getSeconds();
		    return currentdate;
		}
		
	};

//用法(new Date()).pattern("yyyy-MM-dd HH:mm:ss.S")
Date.prototype.pattern=function(fmt) {           
    var o = {           
    "M+" : this.getMonth()+1, //月份           
    "d+" : this.getDate(), //日           
    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时           
    "H+" : this.getHours(), //小时           
    "m+" : this.getMinutes(), //分           
    "s+" : this.getSeconds(), //秒           
    "q+" : Math.floor((this.getMonth()+3)/3), //季度           
    "S" : this.getMilliseconds() //毫秒           
    };           
    var week = {           
    "0" : "/u65e5",           
    "1" : "/u4e00",           
    "2" : "/u4e8c",           
    "3" : "/u4e09",           
    "4" : "/u56db",           
    "5" : "/u4e94",           
    "6" : "/u516d"          
    };           
    if(/(y+)/.test(fmt)){           
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));           
    }           
    if(/(E+)/.test(fmt)){           
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);           
    }           
    for(var k in o){           
        if(new RegExp("("+ k +")").test(fmt)){           
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));           
        }           
    }           
    return fmt;           
};