package P3;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
public class FriendshipGraph {
    public static void main(String[] args)
    {
        FriendshipGraph graph = new FriendshipGraph();
        Person rachel = new Person("Rachel"); 
        Person ross = new Person("Ross"); 
        Person ben = new Person("Ben"); 
        Person kramer = new Person("Kramer"); 
        graph.addVertex(rachel); 
        graph.addVertex(ross); 
        graph.addVertex(ben); 
        graph.addVertex(kramer);
        graph.addEdge(rachel, ross); 
        graph.addEdge(ross, rachel); 
        graph.addEdge(ross, ben); 
        graph.addEdge(ben, ross); 
        System.out.println(graph.getDistance(rachel, ross)); 
        System.out.println(graph.getDistance(rachel, ben)); 
        System.out.println(graph.getDistance(rachel, rachel)); 
        System.out.println(graph.getDistance(rachel, kramer)); 
    }
	ArrayList<Person> Vertexbox = new ArrayList<>();

    FriendshipGraph(){
    	
    }
    
    public void addEdge(Person a, Person b) {
    	a.addVertex(b);
    	
    }
    public void addVertex(Person a) {
    	Vertexbox.add(a);
    }
    
    public int getDistance(Person a, Person b) {
    	Queue<Person> queue = new ConcurrentLinkedDeque<Person>();
    	queue.add(a);
        a.pace = 0;
    	while(!queue.isEmpty())
    	{
    		Person w = queue.remove();
    		if (w == b) 
    		{
    			int p = w.pace; 
    			this.reset();
    			return p;
    		}
    		for (int i = 0; i < w.contact.size(); i++) 
    		{
    			Person v = w.contact.get(i);
    			if(v.visited == false)
    			{
    				v.pace = w.pace + 1;
    				v.visited = true;
    				queue.add(v);	
    			}
    		}
    		
    	}
    	this.reset();
    	return -1;
    }
    public void reset() 
    {
        for (int i = 0; i < Vertexbox.size(); i++) {
        	Vertexbox.get(i).visited = false;
        	Vertexbox.get(i).pace = 0;
        }
    }

}
