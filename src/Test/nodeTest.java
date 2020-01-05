package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dataStructure.DGraph;
import dataStructure.node;
import utils.Point3D;

class nodeTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}



	@Test
	void testGetKey()
	{
		Point3D p1 = new Point3D(15,8,2);
		Point3D p2 = new Point3D(10,2,18);

		node n1 = new node(p1,1);
		node n2 = new node(p2,2);

		assertNotEquals(n1.getKey(),n2.getKey());
	}

	@Test
	void testGetLocation() {
		Point3D p1 = new Point3D(15,8,2);

		node n1 = new node(p1,1);

		assertEquals(p1,n1.getLocation());
	}

	@Test
	void testSetLocation() 
	{
		Point3D p1 = new Point3D(15,8,2);
		Point3D p2 = new Point3D(10,2,18);

		node n1 = new node(p1,1);
		node n2 = new node(p2,2);

		n1.setLocation(p2);
		n2.setLocation(p1);

		assertEquals(p1,n2.getLocation());
		assertEquals(p2,n1.getLocation());
	}

	@Test
	void testGetWeight() {
		Point3D p1 = new Point3D(15,8,2);
		Point3D p2 = new Point3D(10,2,18);

		node n1 = new node(p1,1);
		node n2 = new node(p2,2);

		n1.setWeight(180);
		n2.setWeight(200);

		assertEquals(200,n2.getWeight());
		assertEquals(180,n1.getWeight());
	}

	@Test
	void testSetWeight() {
		testGetWeight();
	}

	@Test
	void testGetInfo() {
		Point3D p1 = new Point3D(15,8,2);

		node n1 = new node(p1,1);

		n1.setInfo("ex2");

		assertEquals("ex2",n1.getInfo());
	}

	@Test
	void testSetInfo() {
		Point3D p1 = new Point3D(15,8,2);

		node n1 = new node(p1,1);

		n1.setInfo("sunday");

		assertEquals("sunday",n1.getInfo());

	}

	@Test
	void testGetTag() {
		Point3D p1 = new Point3D(15,8,2);

		node n1 = new node(p1,1);

		n1.setTag(200);

		assertEquals(200,n1.getTag());
	}

	@Test
	void testSetTag() {
		Point3D p1 = new Point3D(15,8,2);

		node n1 = new node(p1,1);

		n1.setTag(100);

		assertEquals(100,n1.getTag());
	}

	@Test
	void testToString() {
		Point3D p1 = new Point3D(15,8,2);

		node n1 = new node(p1,1);
		int key = n1.getKey();
		int tag = n1.getTag();
		Point3D point = n1.getLocation();
		double weight = n1.getWeight();
		String info = n1.getInfo();
		
		
		String s = "	key="+key+" tag="+tag +"\r" + 
				"\n location="+point+
				"\n weight=" +weight+
				"\n	info="+info;
		
		assertEquals(s,n1.toString());
	}



}