package com.telpoo.frame.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;

public class AppSupport {
	
	public static boolean isPackageInstalled(String packagename, Context context) {
	    PackageManager pm = context.getPackageManager();
	    try { 
	        pm.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
	        return true; 
	    } catch (NameNotFoundException e) {
	        return false; 
	    } 
	}
	
	
	public static void unInstall(String packageName, Context mContext) {
		Uri packageURI = Uri.parse("package:" + packageName);
		Intent intent = new Intent(Intent.ACTION_DELETE, packageURI);
		mContext.startActivity(intent);

	}
	
	public static void install(String path, Context content){
		 Intent promptInstall = new Intent(Intent.ACTION_VIEW)
         .setData(Uri.parse(path))
         .setType("application/android.com.app");
         content.startActivity(promptInstall);
	}
}
