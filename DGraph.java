package dataStructure;

import java.util.Collection;
import java.util.HashMap;

public class DGraph implements graph
{
	public HashMap<Integer, node> nodesMap = new HashMap<Integer, node>();
	public HashMap<Integer, HashMap<Integer,edge>> edgesMap = new HashMap<Integer, HashMap<Integer,edge>>();
	public int edgesCounter=0;
	public int mc_count=0;

	public DGraph()
	{
		this.nodesMap = new HashMap<Integer, node>();
		this.edgesMap = new HashMap<Integer, HashMap<Integer,edge>>();
		this.edgesCounter=0;
		this.mc_count=0;
	}
	public DGraph(DGraph G)
	{
		this.nodesMap=G.nodesMap;
		this.edgesMap=G.edgesMap;
		this.mc_count=G.mc_count;
		this.edgesCounter=G.edgesCounter;

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
			return  (edge_data)(this.edgesMap.get(src).get(dest)); 
		}
		return null;
	}

	@Override
	public void addNode(node_data n) 
	{
		int key = 	n.getKey();
		this.nodesMap.put(key, (node) n);
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
				this.edgesMap.put(src, new HashMap<Integer,edge>());
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
		return (Collection<node_data>) this.nodesMap;
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		return (Collection<edge_data>)this.edgesMap.get(node_id); 
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
