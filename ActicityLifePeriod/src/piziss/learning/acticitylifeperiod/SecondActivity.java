package piziss.learning.acticitylifeperiod;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

	@Override
	public void onCreate (Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_second);
		
		System.out.println("SecondActivity.onCreate()");
		((TextView) findViewById(R.id.secondTextView)).setText(R.string.secondTextView);
	}
	
	@Override
	public void onStart () {
		super.onStart();
		System.out.println("SecondActivity.onStart()");
	}
	
	@Override
	public void onResume () {
		super.onResume();
		System.out.println("SecondActivity.onResume()");
	}
	
	@Override
	public void onPause () {
		super.onPause();
		System.out.println("SecondActivity.onPause()");
	}
	
	@Override
	public void onRestart () {
		super.onRestart();
		System.out.println("SecondActivity.onRestart()");
	}
	
	@Override
	public void onStop () {
		super.onStop();
		System.out.println("SecondActivity.onStop()");
	}
	
	@Override
	public void onDestroy () {
		super.onDestroy();
		System.out.println("SecondActivity.onDestroy()");
	}
	
}
