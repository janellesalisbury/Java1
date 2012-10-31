package com.weektwojava_jsalisbury;

public enum States {
	
	ALABAMA("Alabama"),
	ALASKA("Alaska"),
	GEORGIA("Georgia"),
	IOWA("Iowa"),
	NEWJERSEY("New_Jersey"),
	WYOMING("Wyoming");
	
	private States (final String text){
		this.text = text;
	}
	private final String text;
	
	public String toText(){
		return text;
	}
	
	
	

}
