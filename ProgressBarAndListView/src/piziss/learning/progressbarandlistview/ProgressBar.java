package piziss.learning.progressbarandlistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ProgressBar extends Activity {

	android.widget.ProgressBar firstProgressBar = null;
	android.widget.ProgressBar secondProgressBar = null;
	private int progress = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progress_bar);

		firstProgressBar = (android.widget.ProgressBar) findViewById(R.id.progressBarHorizontal);
		secondProgressBar = (android.widget.ProgressBar) findViewById(R.id.progressBar);
		
		Button progressBarButton = (Button) findViewById(R.id.progressBarButton);
		progressBarButton.setText(R.string.progressBarButton);
		progressBarButton.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				if (progress <= 0) {
					firstProgressBar.setVisibility(View.VISIBLE);
					secondProgressBar.setVisibility(View.VISIBLE);
					firstProgressBar.setProgress(progress);
					firstProgressBar.setSecondaryProgress(progress);
				} else if (progress < firstProgressBar.getMax()) {
					firstProgressBar.setProgress(progress);
					firstProgressBar.setSecondaryProgress(progress + 10);
				} else {
					firstProgressBar.setVisibility(View.GONE);
					secondProgressBar.setVisibility(View.GONE);
					progress = -10;
				}
				progress += 10;
			}});
		
		Button listViewButton = (Button) findViewById(R.id.listViewButton);
		listViewButton.setText(R.string.listViewButton);
		listViewButton.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				startActivity(new Intent().setClass(getApplicationContext(), ListView.class));
			}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_progress_bar, menu);
		return true;
	}
}
