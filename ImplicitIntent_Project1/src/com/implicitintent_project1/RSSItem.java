package com.implicitintent_project1;

public class RSSItem {
	
	String _title;
	String _link;
	String _description;
	String _date;
	
	
	public RSSItem(){
		
	}
	
	//CREATE THE ITEM
	public RSSItem(String title, String link, String description, String date){
		this._title = title;
		this._description = description;
		this._link = link;
		this._date = date;
	}
	
	//SET METHODS(setter)
	public void setTitle(String title){
		this._title = title;
	}
	
	public void setDescription(String description){
		this._description = description;
	}
	
	public void setLink(String link){
		this._link = link;
	}
	
	public void setDate(String date){
		this._date = date;
	}
	
	//GET METHODS(getter)
	public String getTitle(){
		return this._title;
	}
	
	public String getDescription(){
		return this._description;
	}
	
	public String getLink(){
		return this._link;
	}
	
	public String getDate(){
		return this._date;
	}

}
