package piziss.learning.taskstackofactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        
        ((TextView) findViewById(R.id.secondTextView)).setText(R.string.secondTextView);
        Button button = (Button) findViewById(R.id.secondButton);
        button.setText(R.string.secondButton);
        button.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				SecondActivity.this.startActivity(new Intent().setClass(SecondActivity.this, ThirdActivity.class));
				// until using finish(), this activity will not push to the task stack
				SecondActivity.this.finish();
			}});
    }
}
