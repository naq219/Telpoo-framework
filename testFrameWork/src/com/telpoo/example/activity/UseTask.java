package com.telpoo.example.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.testframework.R;
import com.telpoo.example.task.TaskType;
import com.telpoo.example.task.TaskUser1;
import com.telpoo.frame.model.TaskParams;
import com.telpoo.frame.ui.BaseActivity;

public class UseTask extends BaseActivity implements OnClickListener, TaskType {
	AsyncTask<TaskParams, Void, Boolean> taskUser1;
	Button button1, button2, button3, button4, button5, button6, button7, button8;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);

		setContentView(R.layout.only_button);

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

		button1.setText("get text from a website");

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.button1:
			String[] url = { "http://vnexpress.net/rss/tin-moi-nhat.rss" };
			TaskParams params = new TaskParams(url);
			taskUser1 = new TaskUser1(model, TaskType.TASK_GET_DATA, null, getBaseContext());
			showProgressDialog(UseTask.this);
			model.exeTask(params, taskUser1);
			/*
			 * an asyntask is starting
			 * when finish, data will return at function onsuccess() or onfail()
			 */

			break;

		case R.id.button2:

			break;

		case R.id.button3:

			break;

		case R.id.button4:

			break;

		case R.id.button5:

			break;

		default:
			break;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void onSuccess(int taskType, ArrayList<?> list, String msg) {
		
		/*
		 * if you return TASK_DONE at TaskUser1, data will return here
		 */
		
		switch (taskType) {
		case TASK_GET_DATA:
			List<String> content = (List<String>) list;
			String value = content.get(0);
			closeProgressDialog();
			showToast(value);
			break;

		default:
			break;
		}
		super.onSuccess(taskType, list, msg);
	}

	@Override
	public void onFail(int taskType, String msg) {
		
		/*
		 * if you return TASK_FAIL at TaskUser1, data will return here
		 */
		
		switch (taskType) {
		case TASK_GET_DATA:
			closeProgressDialog();
			showToast(msg);
			break;

		default:
			break;
		}
		super.onFail(taskType, msg);
	}

}
