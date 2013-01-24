package com.projectthree_java;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

public class StatesProvider extends ContentProvider {

	public static final String PROVIDER_NAME = "com.projectthree_java.provider.StatesProvider";

	public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/state");

	public static final String _ID = "_id";
	public static final String STATES = "state";
	public static final String ABBREVIATION = "abbreviation";
	public static final String POPULATION = "population";

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
	@SuppressWarnings("unused")
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

		//UPGRADE DATABASE VERSION
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
	public int delete(Uri arg0, String arg1, String[] arg2) {
		  // arg0 = uri 
	      // arg1 = selection
	      // arg2 = selectionArgs
	      int count=0;
	      switch(uriMatcher.match(arg0)){
	      case STATE:
	    	  count = stateDB.delete(DATABASE_TABLE, arg1, arg2);
	    	  break;
	      case STATE_ID:
	    	  String id = arg0.getPathSegments().get(1);
	    	  count = stateDB.delete(
	    	  DATABASE_TABLE,                        
              _ID + " = " + id + 
              (!TextUtils.isEmpty(arg1) ? " AND (" + 
              arg1 + ')' : ""), 
              arg2);
           break;
        default: throw new IllegalArgumentException(
           "Unknown URI " + arg0);    
     }       
     getContext().getContentResolver().notifyChange(arg0, null);
     return count;      
  }

	@Override
	public String getType(Uri uri) {
		switch(uriMatcher.match(uri)){
		case STATE:
			return "vnd.android.cursor.dir/vnd.projecthree_java.state";
		//single item return
		case STATE_ID:
			return "vnd.android.cursor.item/vnd.projectthree_java.state";
		default:
			throw new IllegalArgumentException("unsupported URI:" + uri);
		}

	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		//ADD STATE TO DATABASE
		long rowID = stateDB.insert(DATABASE_TABLE, "", values);
		//SUCCESS
		if(rowID>0){
			Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
			getContext().getContentResolver().notifyChange(_uri, null);
			return _uri;	
		}
		throw new SQLException("Failed to insert row into" + uri);

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
		SQLiteQueryBuilder sqlBuilder = new SQLiteQueryBuilder();
		sqlBuilder.setTables(DATABASE_TABLE);
		if(uriMatcher.match(uri) == STATE_ID)
			//particular state
			sqlBuilder.appendWhere(
					_ID + "=" + uri.getPathSegments().get(1));
		if(sortOrder == null || sortOrder == "")
			sortOrder = STATES;
		Cursor c = sqlBuilder.query(stateDB, projection, selection, selectionArgs, null, null, sortOrder);
		//REGISTER TO WATCH CONTENT FOR CHANGES
		c.setNotificationUri(getContext().getContentResolver(), uri);
		return c;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int count = 0;
		switch(uriMatcher.match(uri)){
		case STATE:
			count = stateDB.update(DATABASE_TABLE, values, selection, selectionArgs);
			break;
		case STATE_ID:
			count = stateDB.update(DATABASE_TABLE, values, _ID + " = " + uri.getPathSegments().get(1) + 
		               (!TextUtils.isEmpty(selection) ? " AND (" + 
		                       selection + ')' : ""), 
		                     selectionArgs);
		                 break;
		              default: throw new IllegalArgumentException(
		                 "Unknown URI " + uri);    
		           }       
		           getContext().getContentResolver().notifyChange(uri, null);
		           return count;
		        }

	}


	