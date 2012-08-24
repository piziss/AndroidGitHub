package piziss.learning.acticitylifeperiod;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DialogActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        
        System.out.println("DialogActivity.onCreate()");
        Button button = (Button) findViewById(R.id.dialogButton);
        button.setText(R.string.dialogButton);
        button.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				DialogActivity.this.startActivity(new Intent().setClass(DialogActivity.this, FirstActivity.class));
			}});
    }
    
    @Override
    public void onStart () {
    	super.onStart();
    	System.out.println("DialogActivity.onStart()");
    }
  
    @Override
    public void onResume () {
    	super.onResume();
    	System.out.println("DialogActivity.onResume()");
    }
    
    @Override
    public void onRestart () {
    	super.onRestart();
    	System.out.println("DialogActivity.onRestart()");
    }
    
    @Override
    public void onPause () {
    	super.onPause();
    	System.out.println("DialogActivity.onPause()");
    }
    
    @Override
    public void onStop () {
    	super.onStop();
    	System.out.println("DialogActivity.onStop()");
    }
    
    @Override
    public void onDestroy () {
    	super.onDestroy();
    	System.out.println("DialogActivity.onDestroy()");
    }

}
