package piziss.learning.activity_03;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity05 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity05);
		
		TextView textView = (TextView) findViewById(R.id.myTextView);
		textView.setText(getIntent().getStringExtra("result"));
	}

}
