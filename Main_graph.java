package gui;

import dataStructure.DGraph;
import dataStructure.graph;
import dataStructure.node;
import utils.Point3D;

public class Main_graph {

	public static void main(String[] args) {
		
		Point3D p1 = new Point3D(50,60);
		Point3D p2 = new Point3D(24,58);
		Point3D p3 = new Point3D(160,125);
		node n1 = new node(p1, 3);
		node n2 = new node(p2, 5);
		node n3 = new node(p3, 5);
		
		graph g = new DGraph();
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		
		g.connect(n1.getKey(), n2.getKey(), 2);
		g.connect(n2.getKey(), n1.getKey(), 10);
		g.connect(n2.getKey(), n3.getKey(), 2);
		
		gui_graph a = new gui_graph(g);
		a.setVisible(true);

	}

}