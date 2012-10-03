package com.salisburyjanelle.lib;

public class Items implements Grocery {
	String name;
	String category;
	
	public Items (String name, String category){
		setName(name);
		setCategory(category);
		
	}
	

	@Override
	public boolean setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
		return true;
	}

	@Override
	public boolean setCategory(String category) {
		// TODO Auto-generated method stub
		this.category = category;
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
		return this.category;
	}

}
