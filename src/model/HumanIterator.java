package model;
import java.util.*;

public class HumanIterator<E extends FTImpersonal<E>> implements Iterator<E> {
	private int id;
	private List<E> humanList;
	public HumanIterator(List<E> humanList){
		this.humanList = humanList;}
	public boolean hasNext(){return id < humanList.size();}
	public E next() {return humanList.get(id++);}

}
