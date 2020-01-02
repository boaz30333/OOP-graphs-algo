package gui;

import dataStructure.DGraph;
import dataStructure.graph;
import dataStructure.node;
import utils.Point3D;

public class Main_graph {

	public static void main(String[] args) {
		
		graph g = new DGraph();
		Point3D p1 = new Point3D(500,600);
		Point3D p2 = new Point3D(289,450);
		Point3D p3 = new Point3D(200,400);
		Point3D p4 = new Point3D(189,250);
		Point3D p5 = new Point3D(689,750);
		Point3D p6 = new Point3D(789,680);
		node n1 = new node(p1,200);
		node n2 = new node(p2, 359);
		node n3 = new node(p3, 489);
		node n4 = new node(p4, 600);
		node n5 = new node(p5, 810);
		node n6 = new node(p6, 461);

		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
		g.addNode(n6);

		g.connect(n1.getKey(), n2.getKey(), 2);
		g.connect(n2.getKey(), n1.getKey(), 10);
		g.connect(n3.getKey(), n4.getKey(), 10);
		g.connect(n4.getKey(), n6.getKey(), 10);
		g.connect(n5.getKey(), n3.getKey(), 10);
		g.connect(n1.getKey(), n3.getKey(), 10);
		g.connect(n5.getKey(), n1.getKey(), 10);
		
		
		gui_graph a = new gui_graph(g);
		a.setVisible(true);
		  
	}

}