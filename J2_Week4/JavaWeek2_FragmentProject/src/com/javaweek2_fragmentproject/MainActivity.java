package com.javaweek2_fragmentproject;

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity implements MainActivityFragment.ListItemSelectedListener{
	//called when activity is first created
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Log.d("step debug","activity on create");
		setContentView(R.layout.main);
	
	}
		@Override
		public void onListItemSelected(int item){
			ActorDetailsFragment imageViewer = (ActorDetailsFragment) getFragmentManager().findFragmentById(R.id.image_viewer_fragment);
			
			if(imageViewer == null || !imageViewer.isInLayout()){
				Intent showImage = new Intent(getApplicationContext(), ActorDetailsView.class);
				showImage.putExtra("item", item);
				startActivity(showImage);
			} else {
				imageViewer.update(item);
			}
		
	
	//CREATE PERSON OBJECT 
	Actor actor1 = new Actor("Jim", "Carrey");
	
	//CREATE A FILE TO SAVE USING PATH PROVIDED THROUGH GETFILESFIRECORY().GETPATH();
	File xmlFile = new File(getFilesDir().getPath() + "/actors_array.xml");
	
	//SERIALIZE ACTOR
	try{
		Serializer serializer = new Persister();
		serializer.write(actor1, xmlFile);
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
	//CREATE A SECOND PERSON
	Actor actor2 = new Actor("Penelope", "Cruz");
	
	//SERIALIZE
	try{
		Serializer serializer = new Persister();
		serializer.write(actor2, xmlFile);
	}
	catch(Exception exc){
		exc.printStackTrace();
	}
	//FINISH CREATING LIST OF ACTORS
	Actor actor3 = new Actor("Chevy", "Chase");
	Actor actor4 = new Actor("Marilyn", "Monroe");
	Actor actor5 = new Actor("Judy", "Garland");
	Actor actor6 = new Actor("John", "Wayne");
	Actor actor7 = new Actor("Johnny", "Depp");
	Actor actor8 = new Actor("Matthew", "McConaughey");
	Actor actor9 = new Actor("Clint", "Eastwood");
	
	//SERIALIZE REMAINING ACTORS
	try{
		Serializer serializer = new Persister();
		serializer.write(actor3, xmlFile);
		serializer.write(actor4, xmlFile);
		serializer.write(actor5, xmlFile);
		serializer.write(actor6, xmlFile);
		serializer.write(actor7, xmlFile);
		serializer.write(actor8, xmlFile);
		serializer.write(actor9, xmlFile);
	}
	catch(Exception e){
		e.printStackTrace();
		
	}
	//DESERIALIZE ACTORS
	if(xmlFile.exists()){
		try{
			Serializer serializer = new Persister();
			serializer.read(Actor.class, xmlFile);
		}
		catch(Exception boo){
			boo.printStackTrace();
			
		}
	}
	
	boolean b = actor1.equals(actor1);
	
	
	
	
	}
		
}


	
 
 

