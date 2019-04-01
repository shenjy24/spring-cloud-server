/*
 * Copyright (C) 2016  HangZhou YuShi Technology Co.Ltd  Holdings Ltd. All rights reserved
 *
 * 本代码版权归杭州宇石科技所有，且受到相关的法律保护。
 * 没有经过版权所有者的书面同意，
 * 任何其他个人或组织均不得以任何形式将本文件或本文件的部分代码用于其他商业用途。
 *
 */
package com.jonas.util.logging;

import lombok.Data;

/**
 * 用户访问日志
 *
 * @author liuyi  2016年4月19日 下午5:14:38
 */
@Data
public class AccessLog {

    /**
     * 用户访问ip地址
     */
    private String ip;

    /**
     * 用户访问action
     */
    private String action;

    /**
     * 请求端ua信息
     */
    private String ua;

    /**
     * 请求来源
     */
    private String referer;

    /**
     * 设备唯一标识
     */
    private String sid;

    /**
     * 用户id
     */
    private String uid;

    /**
     * app版本
     **/
    private String appVersion;

    /**
     * 包名/程序id
     */
    private String appId;

    /**
     * 设备操作系统类型
     */
    private String osType;

    /**
     * 设备操作系统版本
     */
    private String osVersion;

    /**
     * 设备型号
     */
    private String deviceModel;

    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * 网络类型
     */
    private String networkType;

    /**
     * 厂商
     */
    private String vendor;

    /**
     * CPU
     */
    private String cpu;

    /**
     * 开始处理时间
     */
    private Long startTime = 0L;

    /**
     * 处理完成时间
     */
    private Long finishTime = 0L;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ip").append("=").append(ip).append("`");
        sb.append("ua").append("=").append(ua).append("`");
        sb.append("referer").append("=").append(referer).append("`");
        sb.append("networkType").append("=").append(networkType).append("`");

        sb.append("action").append("=").append(action).append("`");

        sb.append("sid").append("=").append(sid).append("`");
        sb.append("uid").append("=").append(uid).append("`");

        sb.append("appId").append("=").append(appId).append("`");
        sb.append("appVersion").append("=").append(appVersion).append("`");

        sb.append("osType").append("=").append(osType).append("`");
        sb.append("osVersion").append("=").append(osVersion).append("`");

        sb.append("deviceId").append("=").append(deviceId).append("`");
        sb.append("deviceModel").append("=").append(deviceModel).append("`");

        sb.append("vendor").append("=").append(vendor).append("`");
        sb.append("cpu").append("=").append(cpu).append("`");

        sb.append("useTime").append("=").append(finishTime - startTime).append("ms");

        return sb.toString();
    }

}
