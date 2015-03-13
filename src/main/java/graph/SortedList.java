package graph;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class SortedList<E> extends AbstractList<E> implements Iterable<E> {

    private ArrayList<E> internalList = new ArrayList<E>();

    @Override 
    public void add(int position, E e) {
        internalList.add(e);
        Collections.sort(internalList, null);
    }

    @Override
    public E get(int i) {
        return internalList.get(i);
    }

    @Override
    public int size() {
        return internalList.size();
    }
    
    @Override
	public Iterator<E> iterator() {
		return internalList.iterator();
	}

}
