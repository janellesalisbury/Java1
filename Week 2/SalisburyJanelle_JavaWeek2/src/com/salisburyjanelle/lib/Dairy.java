package com.salisburyjanelle.lib;




public class Dairy implements Grocery {
	String name;

	//private FoodType category = FoodType.DAIRY;
	
	public Dairy(String name){
		setName(name);
	}

	@Override
	public boolean setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
		return true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getCategory() {
		// TODO Auto-generated method stub
		return this.getCategory();
	}
}

