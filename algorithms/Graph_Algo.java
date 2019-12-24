package algorithms;

import java.io.Serializable;
import java.util.List;

import dataStructure.DGraph;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import dataStructure.graph;
import dataStructure.node_data;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms , Serializable{
	graph grph;
	@Override
	public void init(graph g) {
		// TODO Auto-generated method stub
		this.grph= new DGraph(g);
	}

	@Override
	public void init(String file_name) {
        String filename = file_name; 
        
        try
        {    
            FileOutputStream file = new FileOutputStream(filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            out.writeObject(grph); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
        }   
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
		
	}

	@Override
	public void save(String file_name) {
	       
        try
        {    
            FileInputStream file = new FileInputStream("myObj.txt"); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            this.grph = (graph)in.readObject(); 
              
            in.close(); 
            file.close(); 
              
            System.out.println("Object has been deserialized"); 
            System.out.println(grph);
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
		
	}

	@Override
	public boolean isConnected() {

		return false;
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() {
		// TODO Auto-generated method stub
		return null;
	}

}
