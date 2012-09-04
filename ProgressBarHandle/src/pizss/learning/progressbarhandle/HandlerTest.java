package pizss.learning.progressbarhandle;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class HandlerTest extends Activity {

	Runnable run = new Runnable() {

		public void run() {
			System.out.println("ThreadId: " + Thread.currentThread().getId());
			System.out.println("ThreadName: " + Thread.currentThread().getName());
		}};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progress_bar_handle);
		
		// ʹ��Handler��post()������ʵ�����ǵ���run()��������û������һ��Thread
		new Handler().post(run);
		// ����һ��Thread������һ���µ��߳���Ϊ�Ա�
		new Thread(run).start();
		
		System.out.println("ActivityId: " + Thread.currentThread().getId());
		System.out.println("ActivityName: " + Thread.currentThread().getName());
	}

}
