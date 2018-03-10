package P3;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class FriendshipGraph {
	public static void main(String[] args) {
		FriendshipGraph graph = new FriendshipGraph();
		Person rachel = new Person("Rachel");
		Person ross = new Person("Ross");
		Person ben = new Person("Ben");
		Person kramer = new Person("kramer");
		//Person emma = new Person("emma");
		graph.addVertex(rachel);
		graph.addVertex(ross);
		graph.addVertex(ben);
		graph.addVertex(kramer);
		//graph.addVertex(emma);
		graph.addEdge(rachel, ross);
		graph.addEdge(ross, rachel);
		graph.addEdge(ross, ben);
		graph.addEdge(ben, ross);
		//graph.addEdge(emma, ross);
		//graph.addEdge(emma, rachel);
		System.out.println(graph.getDistance(rachel, ross));
		System.out.println(graph.getDistance(rachel, ben));
		System.out.println(graph.getDistance(rachel, rachel));
		System.out.println(graph.getDistance(rachel, kramer));
		//System.out.println(graph.getDistance(emma, kramer));
	}

	ArrayList<Person> Vertexbox = new ArrayList<>();

	FriendshipGraph() {

	}

	public void addEdge(Person a, Person b) {
		a.addVertex(b);

	}

	public void addVertex(Person a) {
		for( int i = 0; i < Vertexbox.size(); i++)
		{
			if(a.getPersonname().equals(Vertexbox.get(i).getPersonname()))
			{
				System.out.println("Please input unique name");
				return ;
			}
		}
		Vertexbox.add(a);
	}

	public int getDistance(Person a, Person b) {
		Queue<Person> queue = new ConcurrentLinkedDeque<Person>();
		queue.add(a);
		a.setPace(0);
		while (!queue.isEmpty()) {
			Person w = queue.remove();
			if (w == b) {
				int p = w.getPace();
				this.reset();
				return p;
			}
			for (int i = 0; i < w.getContact().size(); i++) {
				Person v = w.getContact().get(i);
				if (v.getVisited() == false) {
					v.setPace(w.getPace() + 1);
					v.setVisited(true);
					queue.add(v);
				}
			}

		}
		this.reset();
		return -1;
	}

	public void reset() {
		for (int i = 0; i < Vertexbox.size(); i++) {
			Vertexbox.get(i).setVisited(false);
			Vertexbox.get(i).setPace(0);
		}
	}

}
