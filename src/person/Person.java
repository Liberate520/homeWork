package person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable, Comparable<Person> {
	private final int id;
	private final String name;
	private final String lastname;
	private int fatherId;
	private int motherId;
	private final List<Person> children;
	
	public Person(int id, String name, String lastname) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		children = new ArrayList<>();
	}
	
	public Person(int id, String name, String lastname, int fatherId, int motherId) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.fatherId = fatherId;
		this.motherId = motherId;
		children = new ArrayList<>();
	}
	
	/*public boolean addChild(Person child) {
		if (! children.contains(child)) {
			children.add(child);
			return true;
		}
		return false;
	}*/
	
	
	//Геттеры и сеттеры для всех полей
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public int getMotherId() {
		return motherId;
	}
	
	public int getFatherId() {
		return fatherId;
	}
	
	@Override
	public String toString(){
		return "id %d, %s %s".formatted(id, name, lastname);
	}
	
	public String getChildrenInfo() {
		StringBuilder res = new StringBuilder();
		res.append("Child: ");
		if (children.size() > 0) {
			res.append(children.get(0).getName());
			for (int i = 1; i < children.size(); i++) {
				res.append(", ");
				res.append(children.get(i).getName());
			}
		} else {
			res.append("no data");
		}
		return res.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (! (obj instanceof Person person)) {
			return false;
		}
		return person.getName().equals(getName());
	}
	
	@Override
	public int compareTo(Person o) {
		return name.compareTo(o.name);
	}
	
}
