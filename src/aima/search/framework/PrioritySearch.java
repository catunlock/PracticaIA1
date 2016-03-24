package aima.search.framework;

import aima.search.nodestore.PriorityNodeStore;

import java.util.Comparator;
import java.util.List;

/**
 * @author Ravi Mohan
 *  
 */
public abstract class PrioritySearch implements Search {
	protected QueueSearch search;

	public List search(Problem p) throws Exception {
		return search.search(p, new PriorityNodeStore(getComparator(p)));
	}

	protected abstract Comparator getComparator(Problem p);

	public Metrics getMetrics() {
		return search.getMetrics();
	}

}