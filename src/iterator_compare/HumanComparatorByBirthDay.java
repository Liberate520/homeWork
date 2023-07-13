package iterator_compare;

import java.util.Comparator;

import common.FTImpersonal;

public class HumanComparatorByBirthDay<E extends FTImpersonal<E>> implements Comparator<E> {
	@Override
	public int compare(E o1, E o2) {
		return o1.getBirthDay().compareTo(o2.getBirthDay());
	}
}
