package model;


import java.util.Comparator;

public class HumanComparatorByName<E extends FTImpersonal<E>> implements Comparator<E> {

	@Override
	public int compare(E o1, E o2) {
		return o2.getLastName().compareTo(o1.getLastName());
	}
}
