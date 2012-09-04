package pizss.learning.progressbarhandle;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class UseHandlerThread extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progress_bar_handle);

		System.out.println("ActivityId: " + Thread.currentThread().getId());
		System.out.println("ActivityName: " + Thread.currentThread().getName());

		// HandlerThread继承自Thread
		HandlerThread handlerThread = new HandlerThread("Handler_Thread");
		handlerThread.start();
		// 使用HandlerThread获得Looper之前，必须先调用HandlerThread的start()方法
		// 否则get到的Looper将会是null
		MyHandler myHandler = new MyHandler(handlerThread.getLooper());
		Message msg = myHandler.obtainMessage();
		// arg1, arg2是较小的消耗传递数据
		msg.arg1 = 0;
		// 其次是obj对象
		msg.obj = "0";
		// Bundle相当于Map, 但是Bundle的特殊在于KEY都是String类型
		Bundle data = new Bundle();
		data.putString("key", "value");
		msg.setData(data);
		// send to who create it
		msg.sendToTarget();
	}

	class MyHandler extends Handler {

		public MyHandler() {

		}

		public MyHandler(Looper loop) {
			super(loop);
		}

		public void handleMessage(Message msg) {
			System.out.println("HandlerThreadId: "
					+ Thread.currentThread().getId());
			System.out.println("HandlerThreadName: "
					+ Thread.currentThread().getName());
		}

	}

}
