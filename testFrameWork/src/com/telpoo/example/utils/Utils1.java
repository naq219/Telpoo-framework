package com.telpoo.example.utils;


import android.content.Context;
import android.widget.Toast;
/**
 * @author NAQ219
 *
 */
public class Utils1  {
	
	public static void showBolean(boolean re,Context context){
		if (re)
			Toast.makeText(context, "success	", 1).show();
		else
		Toast.makeText(context, "fail!", 1).show();
	}
	
	public static void showBolean(boolean re,String ifTrue,String ifFalse,Context context){
		if (re)
			Toast.makeText(context, ifTrue, 1).show();
		else
		Toast.makeText(context, ifFalse, 1).show();
	}

}
