package piziss.learning.progressbarandlistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

public class ListView extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);

		String[] from = getResources().getStringArray(R.array.listViewTitle);
		String[] valueRowOne = getResources().getStringArray(R.array.listViewValueRowOne);
		String[] valueRowTwo = getResources().getStringArray(R.array.listViewValueRowTwo);
		String[] valueRowThree = getResources().getStringArray(R.array.listViewValueRowThree);
		int[] to = new int[] { R.id.column0, R.id.column1, R.id.column2 };
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		data.add(makeMap(from, valueRowOne));
		data.add(makeMap(from, valueRowTwo));
		data.add(makeMap(from, valueRowThree));
		SimpleAdapter listAdapter = new SimpleAdapter(this, data,
				R.layout.layout_list_view, from, to);
		setListAdapter(listAdapter);
	}
	
	private Map<String, String> makeMap (String [] key, String [] value) {
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < key.length; i ++) {
			map.put(key[i], value[i]);
		}
		return map;
	}

}
