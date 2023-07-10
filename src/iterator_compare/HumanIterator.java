package iterator_compare;

import java.util.Iterator;
import java.util.*;
import human.*;

public abstract class HumanIterator implements Iterator<Human> {
	private int id;
	private List<Human> humanList;
	public HumanIterator(List<Human> humanList){
		this.humanList = humanList;}
	public boolean hasNext(){return id < humanList.size();}
	public Human next() {return humanList.get(id++);}

}
