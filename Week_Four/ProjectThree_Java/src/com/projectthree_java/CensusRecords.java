package com.projectthree_java;

public class CensusRecords implements IStateInfo {
	
	//create variables
			String name;
			double population;
			double jail;
			
			public CensusRecords(String name, double population, double jail){
				setName(name);
				setPopulation(population);
				setTotaljail(jail);
			}

	@Override
	public boolean setName(String name) {
		this.name = name;
		return true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean setPopulation(double population) {
		this.population = population;
		return true;
	}

	@Override
	public double getPopulation() {
		// TODO Auto-generated method stub
		return population;
	}

	@Override
	public boolean setTotaljail(double jail) {
		this.jail = jail;
		return true;
	}

	@Override
	public double getTotalJail() {
		// TODO Auto-generated method stub
		return jail;
	}

	

	

}
