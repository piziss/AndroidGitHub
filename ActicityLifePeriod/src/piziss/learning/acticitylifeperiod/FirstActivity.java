package piziss.learning.acticitylifeperiod;

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
        
        System.out.println("FirstActivity.onCreate()");
        ((TextView) findViewById(R.id.myTextView)).setText(R.string.firstTextView);
        Button button = (Button) findViewById(R.id.myButton);
        button.setText(R.string.myButton);
        button.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
//				FirstActivity.this.startActivity(new Intent().setClass(FirstActivity.this, SecondActivity.class));
				FirstActivity.this.startActivity(new Intent().setClass(FirstActivity.this, DialogActivity.class));
			}});
    }
    
    @Override
    public void onStart () {
    	super.onStart();
    	System.out.println("FirstActivity.onStart()");
    }
  
    @Override
    public void onResume () {
    	super.onResume();
    	System.out.println("FirstActivity.onResume()");
    }
    
    @Override
    public void onRestart () {
    	super.onRestart();
    	System.out.println("FirstActivity.onRestart()");
    }
    
    @Override
    public void onPause () {
    	super.onPause();
    	System.out.println("FirstActivity.onPause()");
    }
    
    @Override
    public void onStop () {
    	super.onStop();
    	System.out.println("FirstActivity.onStop()");
    }
    
    @Override
    public void onDestroy () {
    	super.onDestroy();
    	System.out.println("FirstActivity.onDestroy()");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_first, menu);
        return true;
    }
}
