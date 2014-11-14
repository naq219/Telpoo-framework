/**
 * 
 */
package com.telpoo.example.activity;

import java.util.ArrayList;
import java.util.Vector;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.testframework.R;
import com.telpoo.example.db.Dbsupport;
import com.telpoo.example.object.CommentObject;
import com.telpoo.example.object.TableName;
import com.telpoo.example.utils.Utils1;
import com.telpoo.frame.object.BaseObject;
import com.telpoo.frame.ui.BaseActivity;

/**
 * @author NAQ219
 * 
 */
public class DbWithNewObject extends BaseActivity implements OnClickListener {

	Button button1, button2, button3, button4, button5, button6, button7, button8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.only_button);
		super.onCreate(savedInstanceState);

	init();

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.button1:

			CommentObject oj = new CommentObject();
			oj.set(CommentObject.COMMENTID, "123");
			oj.set(CommentObject.COMMENTTEXT, "new 12");

			ArrayList<BaseObject> objs = new ArrayList<BaseObject>();
			 
			objs.add(oj);

			boolean re = Dbsupport.addToTable(objs,TableName.COMMENT, false, null);
			Utils1.showBolean(re, "addToTable success",  "addToTable fail", getBaseContext());
			
			
			break;

		case R.id.button2:
			
			ArrayList<BaseObject> base1 = Dbsupport.getAllOfTable(TableName.COMMENT, CommentObject.keys);
			Toast.makeText(getBaseContext(), base1.get(0).get(CommentObject.COMMENTTEXT), 1).show();
			
			break;

		case R.id.button3:
			String[] sl={};
			int count= Dbsupport.mCount(TableName.COMMENT, CommentObject.COMMENTID, sl);
			showToast("have: "+count+" row in table");
			
			break;
			

		case R.id.button4:

			break;

		case R.id.button5:

			break;

		default:
			break;
		}

	}
	
	void init(){
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		button4 = (Button) findViewById(R.id.button4);
		button5 = (Button) findViewById(R.id.button5);
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
		button5.setOnClickListener(this);

		button1.setText("add a object to table");
		button2.setText("get all object from table");
		button3.setText("dbsuport extend BaseDbSupport");
	}

}
