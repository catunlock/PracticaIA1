package aima.datastructures;

import aima.util.AbstractQueue;

import java.util.ArrayList;
import java.util.List;

public class LIFOQueue extends AbstractQueue {

	public void add(Object anItem) {
		super.addToFront(anItem);
	}

	public void add(List items) {
		List reversed = new ArrayList();
		for (int i = items.size() - 1; i > -1; i--) {
			reversed.add(items.get(i));
		}
		super.addToFront(reversed);
	}

	public Object remove() {
		return super.removeFirst();
	}

	public Object get() {
		return super.getFirst();
	}
}