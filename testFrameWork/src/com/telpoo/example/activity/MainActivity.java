package com.telpoo.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.testframework.R;
import com.telpoo.example.db.Dbsupport;
import com.telpoo.example.delegate.ExamDelegate;
import com.telpoo.example.object.TableName;
import com.telpoo.example.utils.Utils1;
import com.telpoo.frame.ui.BaseActivity;

public class MainActivity extends BaseActivity implements OnClickListener {
	Button button1, button2, button3, button4, button5, button6, button7, button8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.only_button);

		/*
		 * create database. only use in the first time
		 */
		String dbPath = Environment.getExternalStorageDirectory() + "/testnaq";
		boolean init = Dbsupport.init(TableName.tables, TableName.keys, getBaseContext(), dbPath, 1);
		Utils1.showBolean(init, "Database created", "create Database false", getBaseContext());

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

		button1.setText("how to use BaseObject");
		button2.setText("Example with Database");
		button3.setText("use task");
		button4.setText("Example Delegate");

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:

			startActivity(new Intent(getBaseContext(), HelpUseObject.class));

			break;

		case R.id.button2:
			startActivity(new Intent(getBaseContext(), DbWithNewObject.class));

			break;

		case R.id.button3:
			startActivity(new Intent(getBaseContext(), UseTask.class));

			break;

		case R.id.button4:
			startActivity(new Intent(getBaseContext(), ExamDelegate.class));
			break;

		case R.id.button5:

			break;

		default:
			break;
		}

	}

}
