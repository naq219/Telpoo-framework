package com.telpoo.example.activity;
/**
 * 
 */


import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.testframework.R;
import com.telpoo.example.db.Dbsupport;
import com.telpoo.example.object.CatObject;
import com.telpoo.example.object.TableName;
import com.telpoo.frame.object.BaseObject;
import com.telpoo.frame.ui.BaseActivity;

/**
 * @author NAQ219
 * 
 */
public class HelpUseObject extends BaseActivity implements OnClickListener {
	Button button1, button2, button3, button4, button5, button6, button7, button8;
	CatObject Catoj;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.only_button);
		super.onCreate(savedInstanceState);

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
		
		button1.setText("init object");
		button2.setText("get a value of object");
		button3.setText("important! ");
		
		 Catoj=new CatObject();
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.button1:
		
			
			// set value for all key
			for (String key : CatObject.keys) {
				Catoj.set(key, "bla bla");
			}
			
			//set 2 value
			Catoj.set(CatObject.NAME,"miu miu");
			Catoj.set(CatObject.AGE,"2");
			
			showToast("ok");
			
			break;

		case R.id.button2:
			String name=Catoj.get(CatObject.NAME);
			showToast("value="+name);
			break;

		case R.id.button3:
			
			/*
			 * many function of baseDbSupport, BaseNetSupport use BaseObject
			 * instead of CatObject or other object extend baseobject
			 */
			Catoj=new CatObject();
			Catoj.set(CatObject.ID, "1");
			//convert CatObject to baseobject
			BaseObject baseOj=new BaseObject();
			baseOj.setParams(Catoj.getParams());
			
			// and now: baseOj.get(CatObject.ID) equivalent Catoj.get(CatObject.ID) 
			
			showToast(baseOj.get(CatObject.ID));
			
			//you can use baseOj for this function
			ArrayList<BaseObject> baseOjs=new ArrayList<BaseObject>();
			baseOjs.add(baseOj);
			Dbsupport.addToTable(baseOjs, TableName.CAT, false, null);
			
			break;

		case R.id.button4:

			break;

		case R.id.button5:

			break;

		default:
			break;
		}

	}

}
