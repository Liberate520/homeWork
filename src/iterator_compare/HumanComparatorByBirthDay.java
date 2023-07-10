package iterator_compare;

import human.*;

import java.util.Comparator;

public class HumanComparatorByBirthDay implements Comparator<Human> {
	@Override
	public int compare(Human o1, Human o2) {
		return o1.getBirthDay().compareTo(o2.getBirthDay());
	}
}
