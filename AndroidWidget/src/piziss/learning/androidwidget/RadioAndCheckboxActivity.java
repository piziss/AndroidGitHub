package piziss.learning.androidwidget;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class RadioAndCheckboxActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_and_checkbox);
        
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.maleRadioButton :
					toastMsgShow(getString(R.string.male));
					break;
				case R.id.femaleRadioButton :
					toastMsgShow(getString(R.string.female));
					break;
				case R.id.heheRadioButton :
					toastMsgShow(getString(R.string.hehe));
					break;
				}
			}});
        
        CheckBox swimCheckBox = (CheckBox) findViewById(R.id.swimCheckBox);
        CheckBox readCheckBox = (CheckBox) findViewById(R.id.readCheckBox);
        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				switch (buttonView.getId()) {
				case R.id.swimCheckBox :
					toastMsgShow(getString(R.string.swimCheckBox));
					break;
				case R.id.readCheckBox :
					toastMsgShow(getString(R.string.readCheckBox));
					break;
				}
			}};
		swimCheckBox.setOnCheckedChangeListener(listener);
		readCheckBox.setOnCheckedChangeListener(listener);
    }
    
    private void toastMsgShow(String msg) {
    	toastMsgShow(getApplicationContext(), msg);
    }
    
    private void toastMsgShow(Context con, String msg) {
    	Toast.makeText(con, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_radio_and_checkbox, menu);
        return true;
    }
}
