/*
 * Copyright (C) 2016  HangZhou YuShi Technology Co.Ltd  Holdings Ltd. All rights reserved
 *
 * 本代码版权归杭州宇石科技所有，且受到相关的法律保护。
 * 没有经过版权所有者的书面同意，
 * 任何其他个人或组织均不得以任何形式将本文件或本文件的部分代码用于其他商业用途。
 *
 */
package com.jonas.util.logging;

/**
 * gws日志枚举类
 *
 * @version 
 * @author liuyi  2016年4月19日 下午11:45:05
 * 
 */
public enum LoggerEnum {

	GWS("GWS"),
	SQLTRACE("SQLTRACE"),
	ACCESSTRACE("ACCESSTRACE");

	private String logerName;

	LoggerEnum(String logerName) {
		this.logerName = logerName;
	}

	public String getLogerName() {
		return logerName;
	}
}
