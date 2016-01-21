package com.ab.util.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wolf on 2015/8/28.
 * 计算时间差
 */
public class JudgeTime {
    public static String getWords(String time) {
        try {
            SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date begin = dfs.parse(time);
            long between = (new Date().getTime() - begin.getTime()) / 1000;//除以1000是为了转换成秒
            long day1 = between / (24 * 3600);
            long hour1 = between % (24 * 3600) / 3600;
            long minute1 = between % 3600 / 60;
            if (day1 > 0) {
                return day1 + "天前";
            }
            if (hour1 > 0) {
                return hour1 + "小时前";
            }
            if (minute1 > 0) {
                return minute1 + "分钟前";
            }
            return "刚刚";

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
