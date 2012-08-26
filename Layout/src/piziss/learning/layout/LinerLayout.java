package piziss.learning.layout;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LinerLayout extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liner_layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_liner_layout, menu);
        return true;
    }
}
