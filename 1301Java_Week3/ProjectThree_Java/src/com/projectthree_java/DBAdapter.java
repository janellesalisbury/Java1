package com.projectthree_java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DBAdapter {
	
	public static final String KEY_ROWID= "_id";
	public static final String KEY_STATES= "state";
	public static final String KEY_ABBREVIATION= "abbreviation";
	public static final String KEY_POPULATION= "population";
	
	private static final String TAG= "DBAdapter";
	private static final String DATABASE_STATE= "state";
	private static final String DATABASE_TABLE= "population";
	private static final String DATABASE_ABBREVIATION= "abbreviation";
	private static final int DATABASE_VERSION= 2;
	
	private static final String DATABASE_CREATE = "create table titles(_id integer primary key autoincrement," 
	+ "state text not null, population text not null, abbreviation text not null);";
	
	private final Context context;
	
	private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx) 
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
        
    private static class DatabaseHelper extends SQLiteOpenHelper 
    {
        DatabaseHelper(Context context) 
        {
            super(context, DATABASE_STATE, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) 
        {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, 
        int newVersion) 
        {
        	Log.w(TAG, "Upgrading database from version " + oldVersion 
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS titles");
            onCreate(db);
        }
    }  

    
    //---opens the database---
    public DBAdapter open() throws SQLException 
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---    
    public void close() 
    {
        DBHelper.close();
    }
    
    //---insert state---//
    public long insertState(String name, String abbreviation, String population)
    {
    	ContentValues initialValues = new ContentValues();
    	initialValues.put(KEY_STATES, name);
    	initialValues.put(KEY_ABBREVIATION, abbreviation);
    	initialValues.put(KEY_POPULATION, population);
    	return db.insert(DATABASE_TABLE, null, initialValues);
    }
    
    //---delete state---//
    public boolean deleteState(long rowId){
    	 return db.delete(DATABASE_TABLE, KEY_ROWID + 
         		"=" + rowId, null) > 0;
     }
    
    //--get all states saved---//
    public Cursor getAllStates(){
    	return db.query(DATABASE_TABLE, new String[] {
        		KEY_ROWID, 
        		KEY_STATES,
        		KEY_ABBREVIATION,
        		KEY_POPULATION},
        		null,   
                null, 
                null,
                null, 
                null);
    }
    
    //---retrieve particular state---//
    public Cursor getState(long rowId) throws SQLException{
    	Cursor mCursor =
                db.query(DATABASE_TABLE, new String[] {
                		KEY_ROWID,
                		KEY_STATES,
                		KEY_ABBREVIATION,
                		KEY_POPULATION},
                		null,
                		null,
                		null,
                		null,
                		null);
    	if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public boolean updateState(long rowId, String name, String abbreviation, String population){
    	ContentValues args = new ContentValues();
    	args.put(KEY_STATES, name);
    	args.put(KEY_ABBREVIATION, abbreviation);
    	args.put(KEY_POPULATION, population);
    	return db.update(DATABASE_TABLE, args, KEY_ROWID + "=", null) > 0;
    }
    
}
 
    
 
	


