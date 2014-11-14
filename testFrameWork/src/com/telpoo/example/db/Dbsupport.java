package com.telpoo.example.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;

import com.telpoo.frame.database.BaseDBSupport;
import com.telpoo.frame.utils.Mlog;

public class Dbsupport extends BaseDBSupport{
	static String TAG="Dbsupport";
	protected Dbsupport(Context context) {
		super(context);
		
	}
	
	public static int mCount(String tableName, String selection, String[] selectionArgs) {
		try {
			openDB();
			String sql = "SELECT count(*) FROM " + tableName + " WHERE " + selection;
			Cursor mcursor = mSqliteDatabase.rawQuery(sql, selectionArgs);
			mcursor.moveToFirst();
			int icount = mcursor.getInt(0);
			mcursor.close();
			closeDB();
			return icount;
		} catch (SQLiteException ex) {
			Mlog.E(TAG+"-mCount- =23456234="+ex);
		}
		return 0;
	}

	
	

}
