package com.web.Job;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentJob {
	
	public static int i = 1;
	
	public void exe(){
		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
			System.out.println(i+"执行了此方法"+myFmt.format(new Date()));
			i++;
	}
}
