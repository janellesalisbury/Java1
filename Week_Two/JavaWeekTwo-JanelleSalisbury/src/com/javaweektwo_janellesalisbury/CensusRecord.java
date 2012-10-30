package com.javaweektwo_janellesalisbury;

public class CensusRecord {
	
	//private variables
	private int totalPopulation;
	private int totalMen;
	private int totalWomen;
	private String location;

	
	//default constructor
	CensusRecord(){
		this.totalPopulation = 0;
		this.totalMen = 0;
		this.totalWomen = 0;
		this.location = "";
		//user sets private values by using setters
	}
	
	//parameterized constructor
	CensusRecord(int myTotalPopulation, int myTotalMen, int myTotalWomen, String myLocation){
		this.totalPopulation = myTotalPopulation;
		this.totalMen = myTotalMen;
		this.totalWomen = myTotalWomen;
		this.location = myLocation;
	}
	
	
	
	//get/set information
	public int getTotalPopulation() {
		return totalPopulation;
	}

	public void setTotalPopulation(int totalPopulation) {
		this.totalPopulation = totalPopulation;
	}

	public int getTotalMen() {
		return totalMen;
	}

	public void setTotalMen(int totalMen) {
		this.totalMen = totalMen;
	}

	public int getTotalWomen() {
		return totalWomen;
	}

	public void setTotalWomen(int totalWomen) {
		this.totalWomen = totalWomen;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	public String toString()
	{
		
		String myResults =   "Population =" + this.totalPopulation + 
				           ", Men ="        + this.totalMen        +
				           ", Women ="      + this.totalWomen      +
				           ", Location"     + this.location;
	
		return myResults;
	}
	
	
	
}
