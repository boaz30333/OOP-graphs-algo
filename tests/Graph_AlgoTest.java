package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.graph;
import dataStructure.node;
import dataStructure.node_data;
import utils.Point3D;

class Graph_AlgoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testInitGraph() {
		Graph_Algo alg = new Graph_Algo();
		DGraph g = new DGraph();
		
		Point3D p1 = new Point3D(15,8,2);
		Point3D p2 = new Point3D(10,2,18);
		
		node n1 = new node(p1,1);
		node n2 = new node(p2,2);
		
		g.addNode(n1);
		g.addNode(n2);
		
		alg.init(g);
		alg.save("try");

		Graph_Algo ans = new Graph_Algo();
		ans.init("try");
	}

	@Test
	void testSave() {
		Graph_Algo alg = new Graph_Algo();
		DGraph g = new DGraph();
		
		Point3D p1 = new Point3D(15,8,2);
		Point3D p2 = new Point3D(10,2,18);
		
		node n1 = new node(p1,1);
		node n2 = new node(p2,2);
		
		g.addNode(n1);
		g.addNode(n2);

		alg.save("try");
	}

	@Test
	void testIsConnected() {
		 Graph_Algo alg = new Graph_Algo();
	        DGraph g = new DGraph();
	        
	        Point3D p1 = new Point3D(15,8,2);
			Point3D p2 = new Point3D(10,2,18);
			
			node n1 = new node(p1,1);
			node n2 = new node(p2,2);
			
	        g.connect(n1.getKey(),n2.getKey(),9);
	        g.connect(n2.getKey(),n1.getKey(),2);
	        alg.init(g);
	        assertEquals(true,alg.isConnected());
	}

	@Test
	void testShortestPathDist() 
	{
		Graph_Algo alg = new Graph_Algo();
		DGraph g = new DGraph();
		Point3D p1 = new Point3D(15,8,2);
		Point3D p2 = new Point3D(10,2,18);
		Point3D p3 = new Point3D(10,12,2);
		
		node n1 = new node(p1,1);
		node n2 = new node(p2,2);
		node n3 = new node(p3,3);
		
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		
		g.connect(1, 2, 6);
		g.connect(2, 3, 8);
		
		assertTrue(alg.shortestPathDist(1,2)==2);
	}

	@Test
	void testShortestPath() {
		Graph_Algo alg = new Graph_Algo();
		DGraph g = new DGraph();
		
		Point3D p1 = new Point3D(15,8,2);
		Point3D p2 = new Point3D(10,2,18);
		Point3D p3 = new Point3D(10,12,2);
		Point3D p4 = new Point3D(14,7,8);
				
		node n1 = new node(p1,1);
		node n2 = new node(p2,2);
		node n3 = new node(p3,3);
		node n4 = new node(p4,4);

		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);

		
		g.connect(1, 2, 6);
		g.connect(2, 3, 8);
		g.connect(3, 4, 10);
		
		List<node_data> ans1 = alg.shortestPath(1,4);
		List<node_data> ans2 = new ArrayList<>();
		ans1.add(n1);
		ans1.add(n2);
		ans1.add(n3);
		ans1.add(n4);
		
		boolean path = true;
		int size = ans1.size();
		int k = 0;
		while(size>0)
		{
			if(ans1.get(k).getKey()!=ans2.get(k).getKey())
			{
				path = false;
			}
			size--;
			k++;
		}
		assertTrue(path);
	}
	
	@Test
	void testTSP() {
		Graph_Algo alg = new Graph_Algo();
		DGraph g = new DGraph();
		
		Point3D p1 = new Point3D(15,8,2);
		Point3D p2 = new Point3D(10,2,18);
		Point3D p3 = new Point3D(10,12,2);
		Point3D p4 = new Point3D(14,7,8);
				
		node n1 = new node(p1,1);
		node n2 = new node(p2,2);
		node n3 = new node(p3,3);
		node n4 = new node(p4,4);

		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);

		g.connect(1, 2, 6);
		g.connect(2, 3, 8);
		g.connect(3, 4, 10);
		
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(1);
		ans.add(2);
		ans.add(3);
		int k = 0;
		int size = ans.size();
		boolean path = true;
		while(size>0)
		{
			if(ans.get(k) != alg.TSP(ans).get(k).getKey())
			{
				path = false;
			}
			size--;
			k++;
		}
		assertTrue(path);
	}

	@Test
	void testCopy() {
		Graph_Algo alg = new Graph_Algo();
		DGraph g = new DGraph();
		
		Point3D p1 = new Point3D(15,8,2);
		Point3D p2 = new Point3D(10,2,18);
		
		node n1 = new node(p1,1);
		node n2 = new node(p2,2);
		
		g.addNode(n1);
		g.addNode(n2);
		
		 g.connect(n1.getKey(),n2.getKey(),22);
		 
		 alg.init(g);
		 
		 graph temp = new DGraph();
		
		 temp = alg.copy();
		 
		 assertEquals(2,temp.nodeSize());
	}
}