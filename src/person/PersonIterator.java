package person;

import java.util.Iterator;
import java.util.List;

public class PersonIterator<E> implements Iterator<E> {
	private int index;
	private List<E> personList;
	
	public PersonIterator(List<E> personList) {
		this.personList = personList;
	}
	
	@Override
	public boolean hasNext() {
		return index < personList.size();
	}
	
	@Override
	public E next() {
		return personList.get(index++);
	}
}
