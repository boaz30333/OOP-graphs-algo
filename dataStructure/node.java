package dataStructure;

import java.util.ArrayList;
import java.util.HashMap;

import utils.Point3D;

public class node implements node_data
{

	public static int keyMaker=0;

	//Node Parameters:
	private int key, tag;
	private Point3D location;
	private double weight;
	private String info;
		
	//Constructors:
	public node () {
		this.key=keyMaker;
		this.tag=0;
		this.weight=0;
		this.info="";
		keyMaker++;
	}
	
	
	/**
	 * for details only
	 * @param o
	 */
	protected node (node_data o) {
		this.key=o.getKey();
		this.tag=o.getTag();
		this.weight=o.getWeight();
		this.info=o.getInfo();
		this.location=o.getLocation();
	}

	public node (Point3D loc, double weight) {
		this.key=keyMaker;
		this.location=loc;
		this.tag=0;
		this.weight=weight;
		this.info="";
		keyMaker++;
	}

	//Getters/Setters:
	@Override
	public int getKey() { return this.key; }

	@Override
	public Point3D getLocation() { return new Point3D(this.location.x(),this.location.y(),this.location.z()); }

	@Override
	public void setLocation(Point3D p) { this.location = p; }

	@Override
	public double getWeight() { return this.weight; }

	@Override
	public void setWeight(double w) { this.weight = w; }

	@Override
	public String getInfo() { return this.info; }

	@Override
	public void setInfo(String s) { this.info = s; }

	@Override
	public int getTag() { return this.tag; }

	@Override
	public void setTag(int t) { this.tag = t; }

}