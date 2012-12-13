package com.javaweek2_fragmentproject;


public class Actor {
	
	public Actor(){
		
	}
	
	public Actor(String firstName, String lastName){
		SetFirstname(firstName);
		SetLastname(lastName);
		
	}
	//CREATE GETTER/SETTER FOR ACTORS NAME
	private String FirstName;
	
	public String GetFirstName(){
		return FirstName;
	}
	
	public void SetFirstname(String inFirstName){
		FirstName = inFirstName;
	}
	
	private String LastName;
	
	public String GetLastName(){
		return LastName;
	}
	
	public void SetLastname(String inLastName){
		LastName = inLastName;
	}

	@Override
	public boolean equals(Object inObject){
		if(inObject instanceof Actor){
			Actor inActor = (Actor)inObject;
			return this.FirstName.equalsIgnoreCase(inActor.FirstName)
			&& this.LastName.equalsIgnoreCase(inActor.LastName);
				
			
		}
		return false;
		
 }
}