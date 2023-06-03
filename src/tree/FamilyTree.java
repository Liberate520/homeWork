package tree;

import comparators.PersonComparatorById;
import comparators.PersonComparatorByLastname;
import comparators.PersonComparatorByName;
import person.Person;
import person.PersonIterator;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends Person> implements Serializable, Iterable<E> {
	private List<E> personList;
	
	public FamilyTree() {
		this(new ArrayList<>());
	}
	
	public FamilyTree(List<E> personList) {
		this.personList = personList;
	}
	
	public List<E> getPersonList() {
		return personList;
	}
	
	public void add(E person) {
		this.personList.add(person);
	}
	
	public void parentsPerson(E person) {
		E mother = null;
		E father = null;
		for (E item : personList) {
			if (item.getId() == person.getMotherId()) mother = item;
			if (item.getId() == person.getFatherId()) father = item;
		}
		System.out.printf("Object:\n%s\nMother - %s\nFather - %s", person, mother, father);
	}
	
	public void childrensPerson(E person) {
		List<E> childrens = new ArrayList<>();
		for (E item : personList) {
			if (item.getFatherId() == person.getId() || item.getMotherId() == person.getId()) {
				childrens.add(item);
			}
		}
		if (childrens.size() > 0) {
			System.out.printf("\nObject:\n%s\nObject's childrens:\n", person);
			for (E item : childrens) System.out.print(item);
		} else System.out.printf("\nObject:\n%s\nObject has no childrens", person);
	}
	
	public Person getByName(String name) {
		for (Person person : personList) {
			if (person.getName().equals(name)) {
				return person;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		for (Person item : personList) {
			System.out.println(item);
		}
		return " ";
	}
	
	@Override
	public Iterator<E> iterator() {
		return new PersonIterator<E>(personList);
	}
	
	public void sortById() {
		personList.sort(new PersonComparatorById());
	}
	
	public void sortByName() {
		personList.sort(new PersonComparatorByName());
	}
	
	public void sortByLastname() {
		personList.sort(new PersonComparatorByLastname());
	}
	
	public void removePerson(int id) {
		for (E item : this) {
			if (item.getId() == id) {
				getPersonList().remove(item);
			}
		}
	}
	
	public List<E> searchPerson(String lastName) {
		List<E> searchTemp = new ArrayList<>();
		for (E item : personList) {
			if (item.getLastname().equals(lastName))
				searchTemp.add(item);
		}
		return searchTemp;
	}
}