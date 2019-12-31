package dataStructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

public class DGraph implements graph
{
	public HashMap<Integer, node_data> nodesMap = new HashMap<Integer, node_data>();
	public HashMap<Integer, HashMap<Integer,edge_data>> edgesMap = new HashMap<Integer, HashMap<Integer,edge_data>>();
	public int edgesCounter=0;
	public int mc_count=0;

	public DGraph()
	{
		this.nodesMap = new HashMap<Integer, node_data>();
		this.edgesMap = new HashMap<Integer, HashMap<Integer,edge_data>>();
		this.edgesCounter=0;
		this.mc_count=0;
	}
	public DGraph(graph G)
	{
		Collection<node_data> nodes= G.getV();
		for (node_data b : nodes) {
			node_data copynode= new node(b);
			this.addNode(copynode);
			Collection<edge_data> edegspernode= G.getE(b.getKey());
			this.edgesMap.put(b.getKey(),new HashMap<Integer,edge_data>() );
			for (edge_data c : edegspernode) {
				edge_data copyedge= new edge(c) ;
				this.edgesMap.get(b.getKey()).put(c.getDest(),copyedge);
			}
		}
	
		this.mc_count=G.getMC();
		this.edgesCounter=G.edgeSize();

	}

	@Override
	public node_data getNode(int key) 
	{
		if (this.nodesMap.get(key)==null)
			return null; 
		return this.nodesMap.get(key); 
	}

	@Override
	public edge_data getEdge(int src, int dest)
	{
		if (this.edgesMap.get(src).get(dest) != null)
		{
			return  (this.edgesMap.get(src).get(dest)); 
		}
		return null;
	}

	@Override
	public void addNode(node_data n) 
	{
		int key = 	n.getKey();
		this.nodesMap.put(key, n);
		this.mc_count++;
	}

	@Override
	public void connect(int src, int dest, double w)
	{
		if (this.nodesMap.get(src)==null || this.nodesMap.get(dest)== null)
		{
			System.out.println("eror");
		}
		else
		{
			edge newedge = new edge(src,dest,w);
			if (this.edgesMap.get(src) == null) 
			{
				this.edgesMap.put(src, new HashMap<Integer,edge_data>());
				this.edgesMap.get(src).put(dest, newedge);
				edgesCounter++;
				this.mc_count++;
			}
			else
			{
				this.edgesMap.get(src).put(dest, newedge);
				edgesCounter++;
				this.mc_count++;
			}
		}
	}

	@Override
	public Collection<node_data> getV()
	{
		return this.nodesMap.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		return this.edgesMap.get(node_id).values(); 
	}

	@Override
	public node_data removeNode(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edgeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		
		return 0;
	}

}
