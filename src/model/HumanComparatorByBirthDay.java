package model;

import java.util.Comparator;

public class HumanComparatorByBirthDay<E extends FTImpersonal<E>> implements Comparator<E> {
	@Override
	public int compare(E o1, E o2) {
		return o1.getBirthDay().compareTo(o2.getBirthDay());
	}
}
