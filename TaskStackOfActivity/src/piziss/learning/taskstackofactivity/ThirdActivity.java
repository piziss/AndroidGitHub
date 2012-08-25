package piziss.learning.taskstackofactivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        
        ((TextView) findViewById(R.id.thirdTextView)).setText(R.string.thirdTextView);
        Button button = (Button) findViewById(R.id.thirdButton);
        button.setText(R.string.thirdButton);
        button.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				// how to use the msg in strings.xml
				// use Activity.getString(int id) to get
				Uri uri = Uri.parse("smsto:" + getString(R.string.myTel));
				Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
				intent.putExtra("sms_body", "the default SMS text");
				ThirdActivity.this.startActivity(intent);
			}});
    }

}
