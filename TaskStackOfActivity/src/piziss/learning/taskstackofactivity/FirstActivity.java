package piziss.learning.taskstackofactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        
        ((TextView) findViewById(R.id.firstTextView)).setText(R.string.firstTextView);
        Button button = (Button) findViewById(R.id.firstButton);
        button.setText(R.string.firstButton);
        button.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				FirstActivity.this.startActivity(new Intent().setClass(FirstActivity.this, SecondActivity.class));
			}});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_first, menu);
        return true;
    }
}
