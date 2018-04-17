package DiGraph_A5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiGraph implements DiGraphInterface {

  // in here go all your data and methods for the graph
  /* A HashMap to store all nodes */
  Map<Long, Node> nodes;
  /* A record of nodes in an array list */
  List<Node> _nodes;
	
	
  public DiGraph ( ) { // default constructor
    // explicitly include this
    // we need to have the default constructor
    // if you then write others, this one will still be there
	  nodes = new HashMap<Long, Node>();
	  _nodes = new ArrayList<Node>();
  }

@Override
public boolean addNode(long idNum, String label) {
	// returns false if node number is not unique, or less than 0
	if (idNum < 0 || nodes.containsKey(idNum)) {
		return false;
	}
	// returns false if label is not unique (or is null)
	if (label == null || containsLabel(label)) {
		return false;
	}
	// returns true if node is successfully added 
	Node new_node = new Node(idNum, label);
	nodes.put(idNum, new_node);
	_nodes.add(new_node);
	return true;
}

@Override
public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean delNode(String label) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean delEdge(String sLabel, String dLabel) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public long numNodes() {
	return nodes.size();
}

@Override
public long numEdges() {
	// TODO Auto-generated method stub
	return 0;
}
  
  // rest of your code to implement the various operations
/* print the graph */
public void print() {
	for (Node node : _nodes) {
		System.out.println(node.idNum + " " + node.label);
	}
}

/* check if label is in nodes */
private boolean containsLabel(String label) {
	boolean contains = false;
	for (Node node : _nodes) {
		if (node.label == label) contains = true;
		break;
	}
	return contains;
}

}

class Node {
	long idNum;
	String label;
	List<Edge> edges;
	
	public Node(long idNum, String label) {
		this.idNum = idNum;
		this.label = label;
		this.edges = new ArrayList<Edge>();
	}
}

class Edge {
	long idNum;
	Node src;
	Node des;
	long weight;
	String eLabel;
}