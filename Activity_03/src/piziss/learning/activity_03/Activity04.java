package piziss.learning.activity_03;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity04 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final EditText firstNum = (EditText) findViewById(R.id.firstNum);
        TextView textView = (TextView) findViewById(R.id.myTextView);
        final EditText secondNum = (EditText) findViewById(R.id.secondNum);
        Button button = (Button) findViewById(R.id.myButton);
        
        textView.setText(R.string.symbol);
        button.setText(R.string.calculate);
        
        button.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				String one = firstNum.getText().toString();
				String two = secondNum.getText().toString();
				if (isEmptyString(one) || isEmptyString(two)) {
					toastShowMsg(R.string.noticeInput);
					return;
				}
				Intent intent = new Intent();
				intent.setClass(Activity04.this, Activity05.class);
				intent.putExtra("result", String.valueOf(Integer.valueOf(one) * Integer.valueOf(two)));
				Activity04.this.startActivity(intent);
			}});
    }

    private boolean isEmptyString (String s) {
    	return (null == s || s.length() == 0);
    }
    
    private void toastShowMsg (int msg) {
    	toastShowMsg(getApplicationContext(), msg);
    }
    
    private void toastShowMsg (Context cxt, int msg) {
    	Toast.makeText(cxt, msg, Toast.LENGTH_SHORT).show();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add(0, 0, 1, R.string.exit);
    	menu.add(0, 1, 1, R.string.about);
    	menu.add(0, 2, 1, R.string.other);
    	return super.onCreateOptionsMenu(menu);
//      getMenuInflater().inflate(R.menu.activity_main, menu);
//    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
    	switch (item.getItemId()) {
    	case 0: 
    		finish();
    		return true;
    	case 1:
    		toastShowMsg(R.string.about);
    		return true;
    	case 2:
    		toastShowMsg(R.string.other);
    		return true;
    	default:
    		toastShowMsg(R.string.not);
    		return true;
    	}
//    	return super.onOptionsItemSelected(item);
    }
}
