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
		
		// 使用Handler的post()方法，实际上是调用run()方法，并没有新起一个Thread
		new Handler().post(run);
		// 构造一个Thread，启动一个新的线程作为对比
		new Thread(run).start();
		
		System.out.println("ActivityId: " + Thread.currentThread().getId());
		System.out.println("ActivityName: " + Thread.currentThread().getName());
	}

}
