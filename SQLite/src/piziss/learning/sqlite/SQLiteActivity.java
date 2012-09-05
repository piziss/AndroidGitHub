package piziss.learning.sqlite;

import piziss.learning.sqlite.db.SQLiteDataBaseHelper;
import piziss.learning.sqlite.db.bean.User;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SQLiteActivity extends Activity {

	private SQLiteDataBaseHelper helper = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        
        Button createDBBtn = (Button) findViewById(R.id.createDBBtn);
        createDBBtn.setText(R.string.createDBBtn);
        createDBBtn.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				helper = new SQLiteDataBaseHelper(getApplicationContext(), "SQLite_USER");
				helper.getReadableDatabase();
			}});
        
        Button updateDBBtn = (Button) findViewById(R.id.updateDBBtn);
        updateDBBtn.setText(R.string.updateDBBtn);
        updateDBBtn.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				helper = new SQLiteDataBaseHelper(getApplicationContext(), "SQLite_USER", 2);
				helper.getReadableDatabase();
			}});
        
        Button insertBtn = (Button) findViewById(R.id.insertBtn);
        insertBtn.setText(R.string.insertBtn);
        insertBtn.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				helper.insert(helper, new User(1, "INSERT"));
			}});
        
        Button updateBtn = (Button) findViewById(R.id.updateBtn);
        updateBtn.setText(R.string.updateBtn);
        updateBtn.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				helper.update(helper, new User(1, "UPDATE"));
			}});
        
        Button queryBtn = (Button) findViewById(R.id.queryBtn);
        queryBtn.setText(R.string.queryBtn);
        queryBtn.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				helper.query(helper, 1);
			}});
        
        Button deleteBtn = (Button) findViewById(R.id.deleteBtn);
        deleteBtn.setText(R.string.deletBtn);
        deleteBtn.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				helper.delete(helper, new User(1, "XXX"));
			}});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_sqlite, menu);
        return true;
    }
}
