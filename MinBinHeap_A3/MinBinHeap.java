package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
	private EntryPair[] array; // load this array
	private int size = 0;
	private static final int arraySize = 10000; // Everything in the array will initially
												// be null. This is ok! Just build out
												// from array[1]

	public MinBinHeap() {
		this.array = new EntryPair[arraySize];
		array[0] = new EntryPair(null, -100000); // 0th will be unused for simplicity
													// of child/parent computations...
													// the book/animation page both do this.
	}

	// Please do not remove or modify this method! Used to test your entire Heap.
	@Override
	public EntryPair[] getHeap() {
		return this.array;
	}

	@Override
	public void insert(EntryPair entry) {
		array[size + 1] = entry;
		size++;
		int node_index = size;
		final EntryPair inserted_node = array[node_index];
		while (node_index != 1) {
			if (array[node_index].priority < array[node_index / 2].priority) {
				array[node_index] = array[node_index / 2];
				array[node_index / 2] = inserted_node;
				node_index = node_index / 2;
				continue;
			}
			break;
		}
	}

	@Override
	public void delMin() {
		if (size == 0) {
			return;
		}
		array[1] = array[size];
		array[size] = null;
		size--;
		int node_index = 1;
		final EntryPair hole = array[1];
		while (node_index < size) {
			// leaf node
			if (node_index * 2 > size) {
				break;
			}
			// only left node
			if (node_index * 2 + 1 > size) {
				if (array[node_index].priority > array[node_index * 2].priority) {
					array[node_index] = array[node_index * 2];
					array[node_index * 2] = hole;
				}
				break;
			}
			// two nodes
			if (array[node_index * 2].priority < array[node_index * 2 + 1].priority) {
				if (hole.priority > array[node_index * 2].priority) {
					array[node_index] = array[node_index * 2];
					array[node_index * 2] = hole;
					node_index = node_index * 2;
				} else {
					break;
				}
			} else {
				if (hole.priority > array[node_index * 2 + 1].priority) {
					array[node_index] = array[node_index * 2 + 1];
					array[node_index * 2 + 1] = hole;
					node_index = node_index * 2 + 1;
				} else {
					break;
				}
			}
		}
	}

	@Override
	public EntryPair getMin() {
		if (size == 0) {
			return null;
		}
		return array[1];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void build(EntryPair[] entries) {
		/*
		 * It receives an array of element objects as input. The effect is to produce a
		 * valid heap that contains exactly those input elements. This means when done
		 * the heap will have both a proper structure and will exhibit heap order.
		 */
		
		size = entries.length;
		// build entries into load array
		for (int i = 1; i <= size; i++) {
			array[i] = entries[i-1];
		}
		// bubble down 
		// start with first non-leaf that has a child
		// (get length of the build array and count the parent of last node n = floor(i / 2))
		int index_last_node = entries.length;
		int index_parent_of_last_node = index_last_node / 2;
		for (int i = index_parent_of_last_node; i > 0; i--) {
			int node_index = i;
			final EntryPair hole = array[i];
			while (node_index < size) {
				// leaf node
				if (node_index * 2 > size) {
					break;
				}
				// only left node
				if (node_index * 2 + 1 > size) {
					if (array[node_index].priority > array[node_index * 2].priority) {
						array[node_index] = array[node_index * 2];
						array[node_index * 2] = hole;
					}
					break;
				}
				// two nodes
				if (array[node_index * 2].priority < array[node_index * 2 + 1].priority) {
					if (hole.priority > array[node_index * 2].priority) {
						array[node_index] = array[node_index * 2];
						array[node_index * 2] = hole;
						node_index = node_index * 2;
					} else {
						break;
					}
				} else {
					if (hole.priority > array[node_index * 2 + 1].priority) {
						array[node_index] = array[node_index * 2 + 1];
						array[node_index * 2 + 1] = hole;
						node_index = node_index * 2 + 1;
					} else {
						break;
					}
				}
			}
		}
	}
}