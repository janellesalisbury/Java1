package com.javaweektwo_janellesalisbury;

public class CensusRecord {
	
	//private variables
	private Integer totalPopulation;
	private Integer totalMen;
	private Integer totalWomen;
	private String location;

	
	//default constructor
	CensusRecord(){
		this.totalPopulation = 0;
		this.totalMen = 0;
		this.totalWomen = 0;
		this.location = "";
		//user sets private values by using setters
	}
	
	//full parameterized constructor
	CensusRecord(int myTotalPopulation, int myTotalMen, int myTotalWomen, String myLocation){
		this.totalPopulation = myTotalPopulation;
		this.totalMen = myTotalMen;
		this.totalWomen = myTotalWomen;
		this.location = myLocation;
	}
	
	//uses api to fill data
	CensusRecord(String myLocation, String APIDeveloperKey){
		//turn zip into state
		//state name into numerical code from api
		//call api using state/developer key
		//results returned
		//parse results 
		//assign private variables based on parsing
		
	}
	
	//get/set information
	public Integer getTotalPopulation() {
		return totalPopulation;
	}

	public void setTotalPopulation(int totalPopulation) {
		this.totalPopulation = totalPopulation;
	}

	public Integer getTotalMen() {
		return totalMen;
	}

	public void setTotalMen(int totalMen) {
		this.totalMen = totalMen;
	}

	public Integer getTotalWomen() {
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

	public float getPercentMen(){	
		float manPercent; 
		try{
			manPercent = (this.totalMen/this.totalPopulation)*100;
		}catch(ArithmeticException error){
			manPercent = 0;
		}
		return manPercent;
	}
	
	public float getPercentWomen(){
		float ladyPercent;
		try{
			ladyPercent = (this.totalWomen/this.totalPopulation)*100;
		}catch(ArithmeticException error){
			ladyPercent = 0;
		}
		return ladyPercent;
		
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
