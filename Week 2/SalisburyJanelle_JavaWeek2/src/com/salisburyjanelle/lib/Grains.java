package com.salisburyjanelle.lib;

public class Grains implements Grocery {
	String name;

//	private FoodType category = FoodType.GRAINS;
	
	public Grains(String name){
		setName(name);
	}


	@Override
	public boolean setName(String name) {
		// TODO Auto-generated method stub
		this.name= name;
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getCategory() {
		// TODO Auto-generated method stub
		return getCategory();
	}

}
