package com.telpoo.example.delegate;

import com.telpoo.frame.utils.Mlog;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.Button;

public class MyButton extends Button {
	OnclickListener1 listener1;

	public MyButton(Context context) {
		super(context);
		Mlog.D("  1: khai bao MyButton");
	}

	public void setOnclickListener1(OnclickListener1 listener1) {
		Mlog.D("  2: truyen listener vao MyButton de giam sat");
		this.listener1 = listener1;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		if(event.getAction()==MotionEvent.ACTION_DOWN){
			
			listener1.onClick(this);
			Mlog.D(" 4: MyButton bi click");
		}

		return true;

	}

}
