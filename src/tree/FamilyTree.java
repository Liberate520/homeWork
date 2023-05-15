package tree;

import comparators.PersonComparatorByName;
import person.Person;
import person.PersonIterator;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends Person> implements Serializable, Iterable<E>{
	private List<E> personList;
	
	public FamilyTree(){
		this(new ArrayList<>());
	}
	
	public FamilyTree(List<E> personList) {
		this.personList = personList;
	}
	
	public boolean addPerson(E person){
		if (person == null) {
			return false;
		}
		if (!personList.contains(person)){
			personList.add(person);
			if (person.getFather() != null) {
				person.getFather().addChild(person);
			}
			if (person.getMother() != null) {
				person.getMother().addChild(person);
			}
			return true;
		}
		return false;
	}
	
	public Person getByName(String name){
		for (Person person : personList){
			if (person.getName().equals(name)){
				return person;
			}
		}
		return null;
	}
	
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("В дереве ");
		sb.append(personList.size());
		sb.append(" Объектов: \n");
		for (Person person : personList){
			sb.append(person.getInfo());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	@Override
	public Iterator<E> iterator() {
		return new PersonIterator<E>(personList);
	}
	
//	public void sortById(){
//		personList.sort(new PersonComparatorById());
//	}
	
	public void sortByName(){
		personList.sort(new PersonComparatorByName());
	}
}