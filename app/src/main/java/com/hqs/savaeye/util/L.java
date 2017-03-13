package com.hqs.savaeye.util;

import android.util.Log;

public class L {
	/**
	 * 调试模式：开启
	 */
	public static boolean DEV_MODE = true;
	
	/**
	 * 调试模式 e级 ：开启
	 */
	public static boolean DEV_MODE_E = true;
	
	/**
	 * 调试模式 d级：开启
	 */
	public static boolean DEV_MODE_D = true;
	
	/**
	 * 调试模式 i级：开启
	 */
	public static boolean DEV_MODE_I = true;
	
	/**
	 * 调试模式 v级：开启
	 */
	public static boolean DEV_MODE_V = true;
	
	public static final String TAG = L.class.getSimpleName();
	
	/**
	 * 如果DEV_MODE 和 DEV_MODE_E都开启，则打印log.e
	 * @param tag
	 * @param msg
	 */
	public static void e(String tag,String msg)
	{
		if(DEV_MODE && DEV_MODE_E)
		{
			Log.e(tag,msg);
		}
	}
	
	public static void d(String tag,String msg)
	{
		if(DEV_MODE && DEV_MODE_E)
		{
			Log.d(tag,msg);
		}
	}
	
	public static void i(String tag,String msg)
	{
		if(DEV_MODE && DEV_MODE_E)
		{
			Log.i(tag,msg);
		}
	}
	
	public static void v(String tag,String msg)
	{
		if(DEV_MODE && DEV_MODE_E)
		{
			Log.v(tag,msg);
		}
	}
	
	public static void e(String msg)
	{
		if(DEV_MODE && DEV_MODE_E)
		{
			Log.e(TAG,msg);
		}
	}
	
	public static void d(String msg)
	{
		if(DEV_MODE && DEV_MODE_D)
		{
			Log.d(TAG,msg);
		}
	}
	
	public static void i(String msg)
	{
		if(DEV_MODE && DEV_MODE_I)
		{
			Log.i(TAG,msg);
		}
	}
	
	public static void v(String msg)
	{
		if(DEV_MODE && DEV_MODE_V)
		{
			Log.v(TAG,msg);
		}
	}
	
	
	public static void e(Class<?> clz,String msg)
	{
		if(DEV_MODE && DEV_MODE_E)
		{
			Log.e(clz.getSimpleName(),msg);
		}
	}
	
	
	public static void v(Class<?> clz,String msg)
	{
		if(DEV_MODE && DEV_MODE_E)
		{
			Log.v(clz.getSimpleName(),msg);
		}
	}
	
	public static void d(Class<?> clz,String msg)
	{
		if(DEV_MODE && DEV_MODE_E)
		{
			Log.d(clz.getSimpleName(),msg);
		}
	}
	
	public static void i(Class<?> clz,String msg)
	{
		if(DEV_MODE && DEV_MODE_E)
		{
			Log.i(clz.getSimpleName(),msg);
		}
	}
	
	
	
}
