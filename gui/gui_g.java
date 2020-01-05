package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.LinkedList;

import javax.swing.JFrame;

import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node;
import dataStructure.node_data;
import utils.Point3D;

public class gui_g extends JFrame implements ActionListener, MouseListener
{
	
	graph g;
	Collection<node_data> nodes;
	Container con = getContentPane();
	public gui_g()
	{
		initGUI();
	}
	
	public void print(graph g2) {
		// TODO Auto-generated constructor stub
		this.g=g2;
		nodes= this.g.getV();
		revalidate();
		repaint();
	}

	private void initGUI() 
	{
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
con.setBackground(Color.WHITE);
con.setLayout(new FlowLayout());
con.setLocation((int)(this.getWidth()/2),(int)(this.getHeight()/2));;
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Menu");
		menuBar.add(menu);
		this.setMenuBar(menuBar);
		
		MenuItem item1 = new MenuItem("Item 1");
		item1.addActionListener(this);
		
		MenuItem item2 = new MenuItem("Item 2");
		item2.addActionListener(this);
		
		menu.add(item1);
		menu.add(item2);
		
		this.addMouseListener(this);

	}

	public void paint(Graphics g)
	{
		super.paint(g);
		
//		Point3D prev = null;

		for (node_data b : nodes) {
			g.setColor(Color.BLUE);
			g.fillOval(b.getLocation().ix(), b.getLocation().iy(), 10, 10);
				Collection<edge_data> nodes_edges= this.g.getE(b.getKey());
				for (edge_data c : nodes_edges) {
					int x1= this.g.getNode(c.getSrc()).getLocation().ix();
					int y1=this.g.getNode(c.getSrc()).getLocation().iy();
					int x2=this.g.getNode(c.getDest()).getLocation().ix();
					int y2=this.g.getNode(c.getDest()).getLocation().iy();
					g.setColor(Color.RED);
					g.drawLine(x1,y1,x2,y2);
					int dx=x2-x1;
					int dy= y2-y1;
					g.setColor(Color.YELLOW); 
					g.fillOval(x2- (int)(30*dx/Math.hypot(dx, dy))-5, y2- (int)(30*dy/Math.hypot(dx, dy))-5, 10, 10);
				}
//			if(prev != null)
//			{
//				g.setColor(Color.RED);
//				g.drawLine((int)p.x(), (int)p.y(), 
//						(int)prev.x(), (int)prev.y());
//				
//				g.drawString("5", (int)((p.x()+prev.x())/2),(int)((p.y()+prev.y())/2));
//			}
//			
//			prev = p;
		}
	}
	


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String str = e.getActionCommand();
		
		if(str.equals("Item 1"))
		{

			revalidate();
			repaint();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
//		int x = e.getX();
//		int y = e.getY();
//		Point3D p = new Point3D(x,y);
//		points.add(p);
		repaint();
		System.out.println("mousePressed");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}
  public static void main(String[] args) {
	graph g= new DGraph();
	g.addNode(new node(1));
	g.addNode(new node(2));
	g.addNode(new node(3));
	g.addNode(new node(4));
	g.getNode(1).setLocation(new Point3D(100,100));
	g.getNode(2).setLocation(new Point3D(50,300));
	g.getNode(3).setLocation(new Point3D(400,150));
	g.getNode(4).setLocation(new Point3D(300,300));

	g.connect(1, 4, 15);
	g.connect(4, 2, 12);
	g.connect(2, 3, 4);
	g.connect(3, 1, 9);
	g.connect(3, 2, 9);
	g.connect(4, 3, 15);
	
	gui_graph b= new gui_graph(g);
	b.setVisible(true);
//
//		graph g = new DGraph();
//		Point3D p1 = new Point3D(500,600);
//		Point3D p2 = new Point3D(289,450);
//		node n1 = new node(p1,200);
//		node n2 = new node(p2, 359);
//		g.addNode(n1);
//		g.addNode(n2);
//		g.connect(n1.getKey(), n2.getKey(), 2);
//		g.connect(n2.getKey(), n1.getKey(), 10);
//		gui_g a = new gui_g();
//		a.print(g);
//		a.setVisible(true);

}
}

