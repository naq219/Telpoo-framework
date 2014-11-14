/**
 * 
 */
package com.telpoo.example.task;

import java.util.ArrayList;

import android.content.Context;

import com.telpoo.frame.model.BaseTask;
import com.telpoo.frame.model.TaskListener;
import com.telpoo.frame.model.TaskParams;
import com.telpoo.frame.net.BaseNetSupport;

/**
 * @author NAQ219
 * @version 1.0
 */
public class TaskUser1 extends BaseTask implements TaskType {

	public TaskUser1(TaskListener taskListener, int taskType, ArrayList<?> list, Context context) {
		super(taskListener, taskType, list, context);
	}

	@Override
	protected Boolean doInBackground(TaskParams... params) {
		if (taskListener == null)
			return TASK_FAILED;

		switch (taskType) {

		case TASK_GET_DATA:
			
			String url= params[0].getStringParams()[0];
			return get_url_content(url);

		default:

			break;
		}

		if ((dataReturn != null && dataReturn.size() > 0)) {
			return TASK_DONE;
		}
		return TASK_FAILED;

	}

	private Boolean get_url_content(String url) {
		String content= BaseNetSupport.method_GET(url, null);
		if(content==null) {
			msg="connect error";
			return TASK_FAILED;
			/*
			 * when return TASK_FAILED , data will return on Activity at function : 
			  @Override
			  public void onFail()
			 */
			
		}
		msg="success";
		ArrayList<String> data=new ArrayList<String>();
		data.add(content);
		dataReturn=data;
		return TASK_DONE;
		/*
		 * when return TASK_DONE , data will return on Activity at function : 
		  @Override
		  public void onSuccess()
		 */
		
		/*
		 * String msg will get from onsuccess or onfail
		 * dataReturn will get from onsuccess
		 */
	}

}
