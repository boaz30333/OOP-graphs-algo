package algorithms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import dataStructure.DGraph;
import dataStructure.HeapMin;
import dataStructure.edge;
import dataStructure.edge_data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import dataStructure.graph;
import dataStructure.node;
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
// TODO do diaxtra from all and chacked in each diaxtra thre isnt infinty node wight
	@Override
	public double shortestPathDist(int src, int dest) {
		// TODO Auto-generated method stub
		//TODO dixtra and than get wight of dest
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		List<node_data> a= new ArrayList<node_data>();
		dijkstra(src);
                                                //TODO  if weight of dest not infinty there is path so go to dest and find who is dad until get to src

		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
//	TODO find with who to start and make hash of nodes in target(or copy list) than do diaxtra with first node find the minimum node wight and choose him for next until get all 
		return null;
	}

	@Override
	public graph copy() {
		// TODO Auto-generated method stub
		return null;
	}
																																									//	public void depthFirstSearch(int key) {
																																									//	    this.grph.getNode(key).setTag(1);
																																									//	    System.out.print(this.grph.getNode(key)+ " ");
																																									//
																																									//	    Collection<edge_data> allNeighbors = this.grph.getE( key);
																																									//	    if (allNeighbors == null)
																																									//	        return;
																																									//
																																									//	    for (edge_data neighbor : allNeighbors) {
																																									//	        if (this.grph.getNode(neighbor.getDest()).getTag()==0)
																																									//	            depthFirstSearch(neighbor.getDest());
																																									//	        
																																									//	    }
																																									//	}
																																									//	public boolean allvisited() {
																																									//    Collection<node_data> all = this.grph.getV();
																																									//
																																									//    for (node_data node : all) {
																																									//        if (node.getTag()==0)  
																																									//        	return false;
																																										//    }
																																										  //  return true;
																																											//}
    public void dijkstra(int start) {
        if (grph.getNode(start)==null) {
            System.err.printf("Graph doesn't contain start vertex \"%s\"\n", startName);
            return;
        }
		HeapMin NodeWeight= new HeapMin();
		Collection<node_data> nodes= grph.getV();
		for (node_data b : nodes) {
			NodeWeight.minHeapInsert(b);
			b.setWeight(Integer.MAX_VALUE);
			b.setInfo("");
			b.setTag(0);
		}
		grph.getNode(start).setWeight(0);
		grph.getNode(start).setTag(0);
		NodeWeight.heapDecreaseKey(grph.getNode(start));
		int key=start;
		node_data next =grph.getNode(start);
		while(next!=null) {
			key= next.getKey();
		Collection<edge_data> edegspernode= grph.getE(key);
		for (edge_data c : edegspernode) { ;
			if(grph.getNode(c.getDest()).getWeight()>grph.getNode(c.getSrc()).getWeight()+c.getWeight()) {
				grph.getNode(c.getDest()).setWeight(grph.getNode(c.getSrc()).getWeight()+c.getWeight())	;
				NodeWeight.heapDecreaseKey(grph.getNode(c.getDest()));
				grph.getNode(c.getDest()).setInfo(""+c.getSrc());//set fater
			}
			}
		 next= NodeWeight.heapExtractMin();
		}
    }
}
