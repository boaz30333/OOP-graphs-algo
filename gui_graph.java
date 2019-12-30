package gui;

import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.awt.Color;
import utils.Point3D;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JFrame;


import java.io.File;
import algorithms.Graph_Algo;
import dataStructure.graph;
import dataStructure.node_data;
import dataStructure.edge_data;
import java.util.Collection;

public class gui_graph extends JFrame implements ActionListener, MouseListener
{
	graph g;

	public gui_graph()
	{
		this.g = null;
		init();
	}
	public gui_graph(graph n)
	{
		this.g = n;
		init();
	}
	public void init()
	{
		this.setSize(500, 500);
		this.setTitle("the maze");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		MenuBar menuBar = new MenuBar();
		this.setMenuBar(menuBar);

		Menu menu = new Menu("menu");
		menuBar.add(menu);

		MenuItem saveing = new MenuItem("save the graph");
		saveing.addActionListener(this);

		MenuItem loading = new MenuItem("load the graph");
		loading.addActionListener(this);

		MenuItem Drawgraph = new MenuItem("Draw graph");
		Drawgraph.addActionListener(this);

		MenuItem shortestPathDist = new MenuItem("shortest Path Dist");
		shortestPathDist.addActionListener(this);

		MenuItem shortestPath = new MenuItem("shortest Path");
		shortestPath.addActionListener(this);


		menu.add(saveing);
		menu.add(loading);
		menu.add(Drawgraph);
		menu.add(shortestPathDist);
		menu.add(shortestPath);


		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent Command)
	{
		String str = Command.getActionCommand();		
		/*Graph_Algo t=new Graph_Algo();
		JFileChooser j;
		 */
		switch(str) 
		{
		case "save the graph":
			Graph_Algo gg = new Graph_Algo();
			gg.init(this.g);
			JFrame parentFrame = new JFrame();
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Specify a file to save");   
			int userSelection = fileChooser.showSaveDialog(parentFrame);

			if (userSelection == JFileChooser.APPROVE_OPTION)
			{
				File fileToSave = fileChooser.getSelectedFile();
				String file= fileToSave.getAbsolutePath();
				gg.save(file);		
				System.out.println("Save as file: " + fileToSave.getAbsolutePath());
			}
			break;
		case "load the graph":
			Graph_Algo g = new Graph_Algo();
			JFrame parentFrame1 = new JFrame();
			JFileChooser fileChooser1 = new JFileChooser();
			fileChooser1.setDialogTitle("Specify a file to load");   
			int userSelection1 = fileChooser1.showOpenDialog(parentFrame1);
			if (userSelection1 == JFileChooser.APPROVE_OPTION) 
			{
				File fileToLoad = fileChooser1.getSelectedFile();
				String file= fileToLoad.getAbsolutePath();
				g.init(file);
				repaint();
				System.out.println("Load from file: " + fileToLoad.getAbsolutePath());
			}
			break;
		case "Draw graph":
			repaint();
			break;




		}

	}

	public void paint(Graphics d)
	{
		super.paint(d);
		if(this.g != null)
		{
			Collection <node_data> node = this.g.getV();
			for (node_data node_data : node) {
				Point3D p = node_data.getLocation();
				d.setColor(Color.gray);
				d.fillOval(p.ix(), p.iy(), 10, 10);
				d.setColor(Color.BLACK);
				d.drawString(Integer.toString(node_data.getKey()), p.ix()+1, p.iy()-2);
				Collection<edge_data> edge = this.g.getE(node_data.getKey());
				for (edge_data edge_data : edge)
				{
					if (edge_data.getTag() ==100)
					{
						edge_data.setTag(0);
						d.setColor(Color.RED);
					}
					else
					{
						d.setColor(Color.BLUE);
					}
					node_data dest = g.getNode(edge_data.getDest());
					Point3D p2 = dest.getLocation();
					if (p2 != null)
					{
						d.drawLine(p.ix(), p.iy(),
						p2.ix(), p2.iy());
						d.drawString(Double.toString(edge_data.getWeight()),(p.ix()+p2.ix())/2 , (p.iy()+p2.iy())/2);
						d.setColor(Color.MAGENTA);
						int x =((((((p.ix()+p2.ix())/2)+p2.ix())/2)+p2.ix())/2);
						int y = ((((((p.iy()+p2.iy())/2)+p2.iy())/2)+p2.iy())/2);
						d.fillOval(x,y, 5, 5);	
					}
				}	
			}
		}
	}
}
