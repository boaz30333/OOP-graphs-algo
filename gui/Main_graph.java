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
		node n1 = new node(p1,200);
		node n2 = new node(p2, 359);
		g.addNode(n1);
		g.addNode(n2);
		g.connect(n1.getKey(), n2.getKey(), 2);
		g.connect(n2.getKey(), n1.getKey(), 10);
		
		gui_graph a = new gui_graph(g);
		a.setVisible(true);
		  
	}

}