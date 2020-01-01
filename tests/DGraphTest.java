package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import static java.time.Duration.ofMillis;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dataStructure.DGraph;
import dataStructure.graph;
import dataStructure.node;

class DGraphTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testDGraph() {

		
		 assertTimeoutPreemptively(Duration.ofMillis(10000), () -> {
		        // Simulate task that takes more than 10 ms.
				graph d= new DGraph();
				int i=1;
				for(i=0;i<1000000;i++) {
			    	d.addNode(new node(i));// TODO
				}
				for(i=0;i<1000;i++)  {
					int j=0;
					for(j=0;j<10000;j++) {
						if(i!=j)
					d.connect(i, i+j, 20);
					}
				}
		    });

	}

	@Test
	void testDGraphGraph() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetNode() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetEdge() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testAddNode() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testConnect() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetV() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetE() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testRemoveNode() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testRemoveEdge() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testNodeSize() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testEdgeSize() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetMC() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testEquals() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testToString() {
		fail("Not yet implemented"); // TODO
	}

}
