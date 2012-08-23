package piziss.learning.activity_02;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity03 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_activity03);
		
		TextView textView = (TextView) findViewById(R.id.myTextView);
//		textView.setText(this.getIntent().getStringExtra("key"));
		textView.setText(this.getIntent().getExtras().getString("key"));
	}

}
