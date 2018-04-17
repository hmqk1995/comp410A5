package A5_Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiGraph implements DiGraph_Interface {

	// in here go all your data and methods for the graph
	Map<String, Map<String, Edge>> nodes;
	Map<Long, String> node_ids;
	Map<Long, Edge> edge_ids;
	List<String> _nodes;
	List<String> _nodes_removed;
	int num_of_edges;

	public DiGraph() { // default constructor
		// explicitly include this
		// we need to have the default constructor
		// if you then write others, this one will still be there
		nodes = new HashMap<String, Map<String, Edge>>();
		node_ids = new HashMap<Long, String>();
		edge_ids = new HashMap<Long, Edge>();
		_nodes = new ArrayList<String>();
		_nodes_removed = new ArrayList<String>();
		num_of_edges = 0;
	}

	@Override
	public boolean addNode(long idNum, String label) {
		// returns false if node number is not unique, or less than 0
		if (idNum < 0) {
			return false;
		}
		if (node_ids.containsKey(idNum)) {
			if (nodes.containsKey(node_ids.get(idNum))) {
				return false;
			}
		}
		// returns false if label is not unique (or is null)
		if (label == null || nodes.containsKey(label)) {
			return false;
		}
		// returns true if node is successfully added
		node_ids.put(idNum, label);
		nodes.put(label, new HashMap<String, Edge>());
		_nodes.add(label);
		return true;
	}

	@Override
	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		// returns false if edge number is not unique or less than 0
		if (idNum < 0) {
			return false;
		}
		if (edge_ids.containsKey(idNum)) {
			if (nodes.get(edge_ids.get(idNum).sLabel).containsKey(edge_ids.get(idNum).dLabel)) {
				return false;
			}
		}
		// returns false if source node is not in graph
		if (!nodes.containsKey(sLabel)) {
			return false;
		}
		// returns false if destination node is not in graph
		if (!nodes.containsKey(dLabel)) {
			return false;
		}
		// returns false is there already is an edge between these 2 nodes
		if (nodes.get(sLabel).get(dLabel) != null) {
			return false;
		}
		// returns true if edge is successfully added
		Edge edge = new Edge(idNum, sLabel, dLabel, weight, eLabel);
		nodes.get(sLabel).put(dLabel, edge);
		edge_ids.put(idNum, edge);
		num_of_edges += 1;
		return true;
	}

	@Override
	public boolean delNode(String label) {
		// return false if the node does not exist
		if (!nodes.containsKey(label)) {
			return false;
		}
		// return true if the node is found and successfully removed
		/* does not remove id from node_ids hashmap */
		num_of_edges -= nodes.get(label).size();
		nodes.remove(label);
		_nodes_removed.add(label);
		return true;
	}

	@Override
	public boolean delEdge(String sLabel, String dLabel) {
		// return false if the edge does not exist
		if (!nodes.containsKey(sLabel) || !nodes.containsKey(dLabel)) {
			return false;
		}
		if (nodes.get(sLabel).get(dLabel) == null) {
			return false;
		}
		// return true if the edge is found and successfully removed
		nodes.get(sLabel).remove(dLabel);
		num_of_edges -= 1;
		return true;
	}

	@Override
	public long numNodes() {
		return nodes.size();
	}

	@Override
	public long numEdges() {
		return num_of_edges;
	}

	@Override
	public ShortestPathInfo[] shortestPath(String label) {
		// TODO Auto-generated method stub
		return null;
	}

	// rest of your code to implement the various operations
}

class Edge {
	long idNum;
	String sLabel;
	String dLabel;
	long weight;
	String eLabel;

	Edge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		this.idNum = idNum;
		this.sLabel = sLabel;
		this.dLabel = dLabel;
		this.weight = weight;
		this.eLabel = eLabel;
	}
}