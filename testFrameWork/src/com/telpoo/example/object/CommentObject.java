package com.telpoo.example.object;

import com.telpoo.frame.object.BaseObject;

public class CommentObject extends BaseObject {
	public static final String[] keys = { "commentId", "commentText", "createOn", "createBy", "passWord", "folderId", };

	public static final String[] keysSent = { "commentText", "sessionId", "folderId" };
	public static final String[] keysGet = { "commentId", "commentText", "createOn", "createBy" };
	
	public static final String COMMENTID = keys[0];
	public static final String COMMENTTEXT = keys[1];
	public static final String CREATEDATE = keys[2];
	public static final String CREATEBY = keys[3];
	public static final String PASSWORD = keys[4];
	public static final String FOLDERID = keys[5];
	
	
}
