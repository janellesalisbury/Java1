package com.weektwojava_jsalisbury;

public class CensusRecords implements StateInfo {
	
	//create variables
	String name;
	double population;
	float percentW;
	
	public CensusRecords(String name, double population, float wpmen){
		setName(name);
		setPopulation(population);
		setPercentW(percentW);
	}

	

	@Override
	public boolean setName(String name) {
		this.name = name;
		return true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setPopulation(double population) {
		this.population = population;
		return true;
	}

	@Override
	public double getPopulation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean setPercentW(float percentW) {
		this.percentW = percentW;
		return true;
	}

	@Override
	public float getPercentW() {
		// TODO Auto-generated method stub
		return 0;
	}

}
