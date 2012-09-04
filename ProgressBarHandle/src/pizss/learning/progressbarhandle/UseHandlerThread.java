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

		// HandlerThread�̳���Thread
		HandlerThread handlerThread = new HandlerThread("Handler_Thread");
		handlerThread.start();
		// ʹ��HandlerThread���Looper֮ǰ�������ȵ���HandlerThread��start()����
		// ����get����Looper������null
		MyHandler myHandler = new MyHandler(handlerThread.getLooper());
		Message msg = myHandler.obtainMessage();
		// arg1, arg2�ǽ�С�����Ĵ�������
		msg.arg1 = 0;
		// �����obj����
		msg.obj = "0";
		// Bundle�൱��Map, ����Bundle����������KEY����String����
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
