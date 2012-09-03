package pizss.learning.progressbarhandle;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarHandle extends Activity {

	Runnable run = null;
	Handler handler = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_handle);
        
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        final Button button = (Button) findViewById(R.id.button);
        button.setText(R.string.startButton);
        button.setOnClickListener(new OnClickListener(){
        	
        	public void onClick(View v) {
        		progressBar.setVisibility(View.VISIBLE);
        		button.setEnabled(false);
        		handler.post(run);
        	}});
        
        handler = new Handler() {
        	@Override
        	public void handleMessage (Message msg) {
        		progressBar.setProgress(msg.arg1);
        		progressBar.setSecondaryProgress(msg.arg1 + 10);
        		handler.post(run);
        	}};
        
        run = new Runnable() {
        	
        	int i = 0;
        	
        	public void run() {
        		i = i + 10;
        		Message msg = handler.obtainMessage();
        		msg.arg1 = i;
        		try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
        		handler.sendMessage(msg);
        		if (i >= progressBar.getMax()) {
        			button.setEnabled(true);
        			handler.removeCallbacks(run);
        		}
        	}};
        	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_progress_bar_handle, menu);
        return true;
    }
}
