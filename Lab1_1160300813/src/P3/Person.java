package P3;

import java.util.*;
public class Person {
	private String personname;
	private ArrayList<Person> contact = new ArrayList<>();
	private boolean visited = false;
	private int pace = 0;
	
	Person(String s){
		personname = s;
	}
	
	public String  getPersonname()
	{
		return personname;
	}
	public ArrayList<Person> getContact()
	{
		return contact;
	}
	public boolean getVisited()
	{
		return visited;
	}
	public void setVisited(boolean a)
	{
		visited = a;
	}
	public int getPace()
	{
		return pace;
	}
	public void setPace(int b)
	{
		pace = b;
	}
	
	
	public void addVertex(Person vertex) {
		contact.add(vertex);
		
	}

}
