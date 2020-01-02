package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

import utils.Point3D;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.File;
import algorithms.Graph_Algo;
import dataStructure.graph;
import dataStructure.node_data;
import dataStructure.DGraph;
import dataStructure.edge_data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class gui_graph extends JFrame implements ActionListener
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
		this.setTitle("the maze of waze");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		MenuBar menuBar = new MenuBar();
		this.setMenuBar(menuBar);

		Menu menu = new Menu("menu");
		menuBar.add(menu);
		
		Menu algo = new Menu("algo");
		menuBar.add(algo);

		MenuItem saveing = new MenuItem("save the graph");
		saveing.addActionListener(this);

		MenuItem loading = new MenuItem("load the graph");
		loading.addActionListener(this);

		MenuItem Drawgraph = new MenuItem("Draw graph");
		Drawgraph.addActionListener(this);

		MenuItem shortestPathDist = new MenuItem("shortest Path Dist");
		shortestPathDist.addActionListener(this);
		MenuItem shortestPathTrace = new MenuItem("shortest Path route");
		shortestPathTrace.addActionListener(this);
		
		MenuItem connect = new MenuItem("connect");
		connect.addActionListener(this);
		

		menu.add(saveing);
		menu.add(loading);
		algo.add(Drawgraph);
		algo.add(shortestPathDist);
		algo.add(connect);
		algo.add(shortestPathTrace);
		
	}


	@Override
	public void actionPerformed(ActionEvent Command)
	{
		String str = Command.getActionCommand();		
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
		case "shortest Path route":
			shortpath(this.getGraphics());
			break;
		case "shortest Path Dist":
			JFrame in = new JFrame();
			try 
			{
				String source = JOptionPane.showInputDialog(in,"the key of source = ");
				String dest = JOptionPane.showInputDialog(in,"the key of dest = ");

				Graph_Algo a = new Graph_Algo();
				a.init(this.g);
				if(this.g.getNode(Integer.parseInt(source))==null||this.g.getNode(Integer.parseInt(dest))==null) 
				{
			    JOptionPane.showMessageDialog(in, "one or more frome vertex are givven not exist");
			    break;

				}
				double ans = a.shortestPathDist(Integer.parseInt(source), Integer.parseInt(dest));
				String out = Double.toString(ans);	
				JOptionPane.showMessageDialog(in, "shortest Path Dist = " + out);
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			break;
		case "connect":
			isConnected();
			
			break;
		}
	}

	public void paint(Graphics d)
	{
		super.paint(d);
		if(this.g != null)
		{
			Collection <node_data> node = g.getV();
			for (node_data node_data : node)
			{
				Point3D p = node_data.getLocation();
				d.setColor(Color.gray);
				d.fillOval(p.ix(),p.iy(),9,9);

				d.setColor(Color.RED);
				d.drawString(Integer.toString(node_data.getKey()), p.ix()-3, p.iy()-3);

				
				Collection<edge_data> edges = g.getE(node_data.getKey());
				if(edges!=null) {
					for (edge_data e : edges)
					{	
						d.setColor(Color.GREEN);
						((Graphics2D) d).setStroke(new BasicStroke(2,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
						Point3D p2 = g.getNode(e.getDest()).getLocation();
						d.drawLine(p.ix()+5, p.iy()+5, p2.ix()+5, p2.iy()+5);
						d.setColor(Color.MAGENTA);
						d.fillOval((int)((p.ix()*0.2)+(0.8*p2.ix()))+2, (int)((p.iy()*0.2)+(0.8*p2.iy())), 9, 9);
						String sss = ""+String.valueOf(e.getWeight());
						d.drawString(sss, 1+(int)((p.ix()*0.2)+(0.8*p2.ix())), (int)((p.iy()*0.2)+(0.8*p2.iy()))-2);
					}
				}
			}	
		}
	}
	public void isConnected()
	{
		JFrame in = new JFrame();
		Graph_Algo graph = new Graph_Algo();
		graph.init(this.g);
		boolean connect = graph.isConnected();
		if (connect == true) {
			JOptionPane.showMessageDialog(in, "connect");
		}
		else {
			JOptionPane.showMessageDialog(in, "no connect");
		}
		
	}
	public void shortpath(Graphics d)
	{
		JFrame in = new JFrame();
		try 
		{
			String source = JOptionPane.showInputDialog(in,"the key of source = ");
			String dest = JOptionPane.showInputDialog(in,"the key of dest = ");

			Graph_Algo a = new Graph_Algo();
			a.init(this.g);
			if(this.g.getNode(Integer.parseInt(source))==null||this.g.getNode(Integer.parseInt(dest))==null) 
			{
		    JOptionPane.showMessageDialog(in, "one or more frome vertex are givven not exist");

			}
			else {
				((Graphics2D) d).setStroke(new BasicStroke(8,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
			List<node_data> b= a.shortestPath(Integer.parseInt(source), Integer.parseInt(dest));
			Iterator<node_data> iter= b.iterator();
			node_data first = iter.next();
			System.out.println(first);

			while(iter.hasNext())
			{
				Point3D p = first.getLocation();
				d.setColor(Color.gray);
				d.fillOval(p.ix(),p.iy(),16,16);

				node_data second = iter.next();
				System.out.println(second);

				Point3D p2 = second.getLocation();
				d.setColor(Color.ORANGE);
				d.drawLine(p.ix()+5, p.iy()+5, p2.ix()+5, p2.iy()+5);
				d.setColor(Color.BLACK);
				d.setFont(new Font("Default", 2, 30) );
				d.drawString(Integer.toString(first.getKey()), p.ix()-3, p.iy()-3);
				d.setColor(Color.gray);
				d.fillOval(p2.ix(),p2.iy(),16,16);
				d.setColor(Color.BLACK);
				d.drawString(Integer.toString(second.getKey()), p2.ix()-3, p2.iy()-3);

				d.setColor(Color.MAGENTA);
				d.fillOval((int)((p.ix()*0.2)+(0.8*p2.ix()))+2, (int)((p.iy()*0.2)+(0.8*p2.iy())), 12, 12);
				String sss = ""+String.valueOf(this.g.getEdge(first.getKey(), second.getKey()).getWeight());
				d.drawString(sss, 1+(int)((p.ix()*0.2)+(0.8*p2.ix())), (int)((p.iy()*0.2)+(0.8*p2.iy()))-2);
				first=second;
		} }}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

