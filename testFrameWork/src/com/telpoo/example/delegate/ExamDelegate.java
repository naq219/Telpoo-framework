package com.telpoo.example.delegate;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.testframework.R;
import com.telpoo.frame.ui.BaseActivity;
import com.telpoo.frame.utils.Mlog;

public class ExamDelegate extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);
		LinearLayout layout= (LinearLayout) findViewById(R.id.root);
		
		
		/*
		 * #1 : khai bao thong thuong
		 */
		Button btn=new Button(getBaseContext());
		btn.setText("Default button");
		
		OnClickListener clickListener=new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				showToast("Button clicked");
				
			}
		};
		
		btn.setOnClickListener(clickListener);
		
		layout.addView(btn);
		
		
		
		/*
		 * #2: khai bao custom
		 * buoc 1: tao 1 class extend từ Button, 
		 * Buoc 2: tạo 1 hàm để truyền 1 listener vào (chính là hàm setOnclickListener)
		 * Buoc 3: bắt sự kiện khi chạm vào Mybutton (onTouch) để gọi phương thức listener1.onClick(this);
		 * Buoc 4: khi được gọi thì sẽ đưuọc thực thi ở đây :
		 * @Override
			public void onClick(View arg0) {
				
				showToast("MyButton clicked");
				
			}
		 */
		
		
		MyButton btn1=new MyButton(getBaseContext());
		btn1.setText("custom button");
		
		OnclickListener1 listener1=new OnclickListener1() {
			
			@Override
			public void onClick(View arg0) {
				
				showToast("MyButton clicked");
				Mlog.D(" 3 : khai bao 1 lister va xac dinh cong viec se lam sau khi nhan duocj ");
				
			}
		};
		
		btn1.setOnclickListener1(listener1);
		
		layout.addView(btn1);
		
	}

}
