package piziss.learning.sqlite.db;

import piziss.learning.sqlite.db.bean.User;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDataBaseHelper extends SQLiteOpenHelper {

	public static int version = 1;
	private final String TABLE_NAME = "USER";
	private final String ID = "ID";
	private final String NAME = "NAME";

	public SQLiteDataBaseHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	public SQLiteDataBaseHelper(Context context, String name) {
		this(context, name, version);
	}

	public SQLiteDataBaseHelper(Context context, String name, int version) {
		this(context, name, null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE USER(ID INT, NAME VARCHAR(20))");
		System.out.println("create table");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("update table");
	}

	public void insert(SQLiteDataBaseHelper helper, User user) {
		ContentValues values = new ContentValues();
		values.put(ID, user.getId());
		values.put(NAME, user.getName());
		helper.getWritableDatabase().insert(TABLE_NAME, null, values);
	}

	public void update(SQLiteDataBaseHelper helper, User user) {
		ContentValues values = new ContentValues();
		values.put(NAME, user.getName());
		helper.getWritableDatabase().update(TABLE_NAME, values, ID + "= ?",
				new String[] { String.valueOf(user.getId()) });
	}

	public User query(SQLiteDataBaseHelper helper, int id) {
		Cursor cursor = helper.getReadableDatabase().query(TABLE_NAME,
				new String[] { NAME }, "ID = ?",
				new String[] { String.valueOf(id) }, null, null, null);
		if (cursor.moveToNext()) {
			String name = cursor.getString(cursor.getColumnIndex(NAME));
			return new User(id, name);
		} else {
			return null;
		}
	}

	public void delete(SQLiteDataBaseHelper helper, User user) {
		helper.getWritableDatabase().delete(TABLE_NAME, "ID = ?",
				new String[] { String.valueOf(user.getId()) });
	}

}
