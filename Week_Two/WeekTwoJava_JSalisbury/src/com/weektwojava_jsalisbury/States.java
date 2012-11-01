package com.weektwojava_jsalisbury;

public enum States {
	
	ALABAMA("Alabama"),
	ALASKA("Alaska"),
	ARIZONA("Arizona"),
	ARKANSAS("Arkansas"),
	CALIFORNIA("California"),
	COLORADO("Colorado"),
	CONNECTICUT("Connecticut"),
	DELAWARE("Delaware"),
	FLORIDA("Florida"),
	GEORGIA("Georgia"),
	HAWAII("Hawaii"),
	IDAHO("Idaho"),
	ILLINOIS("Illinois"),
	INDIANA("Indiana"),
	IOWA("Iowa"),
	KANSAS("Kansas"),
	KENTUCKY("Kentucky"),
	LOUISIANA("Louisiana"),
	MAINE("Maine"),
	MARYLAND("Maryland"),
	MASSACHUCETTS("Massachucetts"),
	MICHIGAN("Michigan"),
	MINNESOTA("Minnesota"),
	MISSISSIPPI("Mississippi"),
	MISSOURI("Missouri"),
	MONTANA("Montana"),
	NEBRASKA("Nebraska"),
	NEVADA("Nevada"),
	NEW_HAMPSHIRE("New_Hampshire"),
	NEW_JERSEY("New_Jersey"),
	NEW_MEXICO("New_Mexico"),
	NEW_YORK("New_York"),
	NORTH_CAROLINA("North_Carolina"),
	NORTH_DAKOTA("North_Dakota"),
	OHIO("Ohio"),
	OKLAHOMA("Oklahoma"),
	OREGON("Oregon"),
	PENNSYLVANIA("Pennsylvania"),
	RHODE_ISLAND("Rhode_Island"),
	SOUTH_CAROLINA("South_Carolina"),
	SOUTH_DAKOTA("South_Dakota"),
	TENNESSEE("Tennessee"),
	TEXAS("Texas"),
	UTAH("Utah"),
	VERMONT("Vermont"),
	VIRGINIA("Virginia"),
	WASHINGTON("Washington"),
	WEST_VIRGINIA("West_Virginia"),
	WISCONSIN("Wisconsin"),
	WYOMING("Wyoming");
	
	
	private States (final String text){
		this.text = text;
	}
	private final String text;
	
	public String toText(){
		return text;
	}
	
	
	

}
