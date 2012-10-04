package com.salisburyjanelle.lib;

public class Meat implements Grocery {
	String name;
	private FoodType category = FoodType.MEAT;
	
	public Meat(String name, double price){
		setName(name);
	
	}

	@Override
	public boolean setName(String name) {
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
