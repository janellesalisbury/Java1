package com.implicitintent_project1;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RSSDatabase extends SQLiteOpenHelper{
	
	//DATABASE VERSION
	private static final int DATABASE_VERSION = 1;
	
	//DATABASE NAME
	private static final String DATABASE_NAME = "sitesDB";
	
	//TABLE NAME
	private static final String TABLE_RSS = "pagesViewed";
	
	//TABLE COLUMNS
	private static final String KEY_ID = "id";
	private static final String KEY_TITLE = "title";
	private static final String KEY_LINK = "link";
	private static final String KEY_RSS_LINK = "rss_link";
	private static final String KEY_DESCRIPTION = "description";
	
	public RSSDatabase(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	//CREATE TABLE
	@Override
	public void onCreate(SQLiteDatabase db){
		String CREATE_TABLE = "CREATE TABLE" + TABLE_RSS + "(" + KEY_ID + "INTEGER PRIMARY KEY" + KEY_TITLE +
				"TEXT" + KEY_LINK + "TEXT" + KEY_RSS_LINK + "TEXT" + KEY_DESCRIPTION + "TEXT" + ")";
		db.execSQL(CREATE_TABLE);
	}
	
	//PERFORM UPGRADE TO DATABASE
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_RSS);
		onCreate(db);
	}
	
	//ADD WEBSITE
	public void addSite(Website site){
		SQLiteDatabase db = this.getReadableDatabase();
		ContentValues values = new ContentValues();
		//TITLE
		values.put(KEY_TITLE, site.getTitle());
		//LINK
		values.put(KEY_LINK, site.getLink());
		//RSS LINK
		values.put(KEY_RSS_LINK, site.getRSSLink());
		//DESCRIPTION
		values.put(KEY_DESCRIPTION, site.getDescription());
		
		//CHECK TO SEE IF ITEM IS ALREADY IN DATABASE
		if(!siteExists(db, site.getRSSLink())){
			//CREATE NEW ROW
			db.insert(TABLE_RSS, null, values);
			db.close();
		}else{
			//PRE-EXISITING/UPDATE
			updateSite(site);
			db.close();	
		}
	}
	
	//READ DATABASE ROWS
	public List<Website> getAllSites() {
        List<Website> siteList = new ArrayList<Website>();
        String selectQuery = "SELECT  * FROM " + TABLE_RSS
                + " ORDER BY id DESC";
 
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // LOOP AND ADD 
        if (cursor.moveToFirst()) {
            do {
                Website site = new Website();
                site.setId(Integer.parseInt(cursor.getString(0)));
                site.setTitle(cursor.getString(1));
                site.setLink(cursor.getString(2));
                site.setRSSLink(cursor.getString(3));
                site.setDescription(cursor.getString(4));
                // ADD TO LIST HERE
                siteList.add(site);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
 
        // RETURN LIST HERE
        return siteList;
    }
 
	//UPDATE ROW
	public int updateSite(Website site) {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_TITLE, site.getTitle());
		values.put(KEY_LINK, site.getLink());
		values.put(KEY_RSS_LINK, site.getRSSLink());
		values.put(KEY_DESCRIPTION, site.getDescription());
		
		//UPDATE
		int update = db.update(TABLE_RSS, values, KEY_RSS_LINK + " = ?",
                new String[] { String.valueOf(site.getRSSLink()) });
        db.close();
        return update;
		
	}
	
	//READ WEBSITE
	 public Website getSite(int id){
		 SQLiteDatabase db = this.getReadableDatabase();
		 Cursor c = db.query(TABLE_RSS, new String[] {KEY_ID, KEY_TITLE, KEY_LINK, KEY_RSS_LINK, KEY_DESCRIPTION}, 
				 KEY_ID + "=?", new String[] {String.valueOf(id) }, null, null, null, null);
		 if(c !=null)
			 c.moveToFirst();
		 
		 Website site = new Website(c.getString(1), c.getString(2), c.getString(3), c.getString(4));
		 site.setId(Integer.parseInt(c.getString(0)));
		 site.setTitle(c.getString(1));
		 site.setLink(c.getString(2));
		 site.setRSSLink(c.getString(3));
		 site.setDescription(c.getString(4));
		 c.close();
		 db.close();
		return site;	
	}
	
	 //DELETE A WEBSITE 
	 public void deleteSite(Website site){
		 SQLiteDatabase db = this.getWritableDatabase();
		 db.delete(TABLE_RSS, KEY_ID + " = ?", new String[] { String.valueOf(site.getId()) });
		 
	 }

	 //DOES WEBSITE ALREADY EXIST IS DATABASE?
	private boolean siteExists(SQLiteDatabase db, String rssLink) {
		Cursor c = db.rawQuery("SELECT 1 FROM" + TABLE_RSS + "WHERE rss_link = '" + rssLink + "'", new String[] {});
		boolean exists = (c.getCount() > 0);
		return exists;
	}
	
	

}
