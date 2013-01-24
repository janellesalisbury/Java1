package com.projectthree_java;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

public class StatesProvider extends ContentProvider{
	
	public static final String PROVIDER_NAME = "com.projectthree_java.provider.States";
	
	public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "state");
	
	public static final String _ID = "_id";
	public static final String STATES = "state";
	public static final String ABBREVIATION = "abbreviation";
	
	private static final int STATE = 1;
	private static final int STATE_ID = 2;
	
	private static final UriMatcher uriMatcher;
	static{
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(PROVIDER_NAME, "state", STATE);
		uriMatcher.addURI(PROVIDER_NAME, "state/#", STATE_ID);
		
	}
	private SQLiteDatabase stateDB;
	private static final String DATABASE_STATE= "state";
	private static final String DATABASE_TABLE= "population";
	private static final String DATABASE_ABBREVIATION= "abbreviation";
	private static final int DATABASE_VERSION= 2;
	
	private static final String DATABASE_CREATE = "create table" + DATABASE_TABLE + " (_id integer primary key autoincrement, "
	         + "state text not null, abbreviation text not null, population text not null);";
	
	private static class DatabaseHelper extends SQLiteOpenHelper{
		DatabaseHelper(Context context){
			super(context, DATABASE_STATE, null, DATABASE_VERSION);
	
	}
		@Override
	      public void onCreate(SQLiteDatabase db) 
	      {
	         db.execSQL(DATABASE_CREATE);
	      }

	      @Override
	      public void onUpgrade(SQLiteDatabase db, int oldVersion, 
	      int newVersion) {
	         Log.w("Content provider database", 
	              "Upgrading database from version " + 
	              oldVersion + " to " + newVersion + 
	              ", which will destroy all old data");
	         db.execSQL("DROP TABLE IF EXISTS states");
	         onCreate(db);
	      }
	   }
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		switch(uriMatcher.match(uri)){
		case STATE:
			return "vnd.android.cursor.dir/com.projecthree_java.state";
		//single item return
		case STATE_ID:
			return "vnd.android.cursor.item/com.projectthree_java.state";
		default:
			throw new IllegalArgumentException("unsupported URI:" + uri);
		}
		
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreate() {
	Context context = getContext();
	DatabaseHelper dbHelper = new DatabaseHelper(context);
	stateDB = dbHelper.getWritableDatabase();
	return (stateDB == null)?false:true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
