package P3;

import static org.junit.Assert.*;
import org.junit.Test;

public class FriendshipGraphTest {
	
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false;
    }


	@Test
	public void mainTest() {
		FriendshipGraph graph = new FriendshipGraph();
        Person rachel = new Person("Rachel"); 
        Person ross = new Person("Ross"); 
        Person ben = new Person("Ben"); 
        Person kramer = new Person("Kramer"); 
        Person emma = new Person("emma"); 
        graph.addVertex(rachel); 
        graph.addVertex(ross); 
        graph.addVertex(ben); 
        graph.addVertex(kramer);
        graph.addVertex(emma);
        graph.addEdge(rachel, ross); 
        graph.addEdge(ross, rachel); 
        graph.addEdge(ross, ben); 
        graph.addEdge(ben, ross); 
        graph.addEdge(emma, ross); 
        graph.addEdge(emma, rachel);
        assertEquals(1, graph.getDistance(rachel, ross)); 
        assertEquals(2, graph.getDistance(rachel, ben)); 
        assertEquals(0, graph.getDistance(rachel, rachel)); 
        assertEquals(-1, graph.getDistance(rachel, kramer));
        assertEquals(-1, graph.getDistance(emma, kramer));
	}

}
