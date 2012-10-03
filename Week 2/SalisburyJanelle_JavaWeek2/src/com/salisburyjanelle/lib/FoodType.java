package com.salisburyjanelle.lib;

public enum FoodType {
	
	MEAT("Meat"),
	DAIRY("Dairy"),
	PRODUCE("Produce"),
	FRUITS("Fruits"),
	GRAINS("Grains");
	
	private FoodType (final String text){
		this.text = text;
	}
	private final String text;
	
	@Override
	public String toString(){
		return text;
	}
}
