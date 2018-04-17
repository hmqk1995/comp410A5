package DiGraph_A5;

import java.util.HashMap;
import java.util.Map;

public class DiGraph implements DiGraphInterface {

  // in here go all your data and methods for the graph
	/* A HashMap to store all nodes */
	Map<Long, String> nodes = new HashMap<Long, String>();
	
	
  public DiGraph ( ) { // default constructor
    // explicitly include this
    // we need to have the default constructor
    // if you then write others, this one will still be there
  }

@Override
public boolean addNode(long idNum, String label) {
	// returns false if node number is not unique, or less than 0
	if (idNum < 0 || nodes.containsKey(idNum)) {
		return false;
	}
	// returns false if label is not unique (or is null)
	if (label == null || nodes.containsValue(label)) {
		return false;
	}
	// returns true if node is successfully added 
	nodes.put(idNum, label);
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
}