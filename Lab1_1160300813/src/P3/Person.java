package P3;

import java.util.*;
public class Person {
	String personname;
	ArrayList<Person> contact = new ArrayList<>();
	boolean visited = false;
	int pace = 0;
	
	Person(String s){
		personname = s;
	}
	
	public void addVertex(Person vertex) {
		contact.add(vertex);
		
	}

}
