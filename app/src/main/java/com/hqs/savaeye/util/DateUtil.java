package com.hqs.savaeye.util;

/**
 * Created by Administrator on 2017/3/13.
 */
public class DateUtil {

    /**
     * 格式化时间，将毫秒转换为分:秒格式
     *
     * @param time
     * @return
     */
    public static String formateTimeByMill(long time) {
        String min = time / (1000 * 60) + "";
        String sec = time % (1000 * 60) + "";
        if (min.length() < 2) {
            min = "0" + time / (1000 * 60) + "";
        } else {
            min = time / (1000 * 60) + "";
        }
        if (sec.length() == 4) {
            sec = "0" + (time % (1000 * 60)) + "";
        } else if (sec.length() == 3) {
            sec = "00" + (time % (1000 * 60)) + "";
        } else if (sec.length() == 2) {
            sec = "000" + (time % (1000 * 60)) + "";
        } else if (sec.length() == 1) {
            sec = "0000" + (time % (1000 * 60)) + "";
        }
        return min + ":" + sec.trim().substring(0, 2);
    }


    /**
     * 根据秒得到mm:ss数据
     * @param seconds
     * @return
     */
    public static String formateTimeBySecond(long seconds) {
        StringBuffer sb = new StringBuffer();
        if (seconds<60) {
            sb.append("00:");
            sb.append(getString(seconds));
        }else{
            int min = (int) Math.floor(seconds/60f);
            long second = seconds%60;
            if (min<60) {
                       sb.append(getString(min))
                        .append(":")
                        .append(getString(second));
            }else{
                int hour =(int) Math.floor(min/60f);
                int newMin = min%60;
                sb.append(getString(hour))
                        .append(":")
                        .append(getString(newMin))
                        .append(":")
                        .append(getString(second));
            }
        }
        return sb.toString();
    }

    public static String getString(long value){
        String valueOf = String.valueOf(value);
        if (valueOf.length()==1) {
            return "0"+valueOf;
        }
        return valueOf;
    }

}
