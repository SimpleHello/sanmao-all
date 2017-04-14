package com.second.Job;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.second.until.RedisUtil;

public class StudentJob {
	
	public static int i = 1;
	
	public void exe(){
		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
			System.out.println(i+" second 执行了此方法"+myFmt.format(new Date()));
			RedisUtil.getRu().hset("exe", String.valueOf(i), "exe"+i);
			i++;
	}
}
