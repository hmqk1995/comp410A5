package DiGraph_A5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiGraph implements DiGraphInterface {

  // in here go all your data and methods for the graph
  Map<String, List<Edge>> nodes;
  Map<Long, String> node_ids;
  List<String> _nodes;
  List<String> _nodes_removed;
  Map<Long, Edge> edge_ids;

  public DiGraph ( ) { // default constructor
    // explicitly include this
    // we need to have the default constructor
    // if you then write others, this one will still be there
	nodes = new HashMap<String, List<Edge>>();
	node_ids = new HashMap<Long, String>();
	_nodes = new ArrayList<String>();
	_nodes_removed = new ArrayList<String>();
	edge_ids = new HashMap<Long, Edge>();
  }

@Override
public boolean addNode(long idNum, String label) {
//    returns false if node number is not unique, or less than 0
	if (idNum < 0 || node_ids.containsKey(idNum)) {return false;}
//    returns false if label is not unique (or is null)
	if (label == null || nodes.containsKey(label)) {return false;}
//    returns true if node is successfully added
	node_ids.put(idNum, label);
	nodes.put(label, new ArrayList<Edge>());
	_nodes.add(label);
	return true;
}

@Override
public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
//    returns false if edge number is not unique or less than 0
	if (idNum < 0 || edge_ids.containsKey(idNum)) {return false;}
//    returns false if source node is not in graph
	if (!nodes.containsKey(sLabel)) {return false;}
//    returns false if destination node is not in graph
	if (!nodes.containsKey(dLabel)) {return false;}
//    returns false is there already is an edge between these 2 nodes
	for (Edge edge : nodes.get(sLabel)) {
		if (edge.dLabel == dLabel) {return false;}
	}
//    returns true if edge is successfully added 
	Edge edge = new Edge(idNum, sLabel, dLabel, weight, eLabel);
	nodes.get(sLabel).add(edge);
	return true;
}

@Override
public boolean delNode(String label) {
//    return false if the node does not exist
	if (!nodes.containsKey(label)) {return false;}
//    return true if the node is found and successfully removed
	/* does not remove id from node_ids hashmap */
	nodes.remove(label);
	_nodes_removed.add(label);
	return true;
}

@Override
public boolean delEdge(String sLabel, String dLabel) {
//    return false if the edge does not exist
	if (!nodes.containsKey(sLabel) || !nodes.containsKey(dLabel)) {return false;}

//    return true if the edge is found and successfully removed
	return false;
}

@Override
public long numNodes() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public long numEdges() {
	// TODO Auto-generated method stub
	return 0;
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