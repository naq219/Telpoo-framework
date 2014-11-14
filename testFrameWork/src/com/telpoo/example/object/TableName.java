/**
 * 
 */
package com.telpoo.example.object;

/**
 * @author khach
 *
 */
public class TableName {
	public static String[] tables = { "table_member", "table_cat", "table_comment" };
	public static String[][] keys = { MemberObject.keys ,CatObject.keys , CommentObject.keys };
	public static String MEMBER=tables[0];
	public static String CAT=tables[1];
	public static String COMMENT=tables[2];

}
