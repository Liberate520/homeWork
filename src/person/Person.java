package person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Person implements Serializable, Comparable<Person>{
	private int id;
	private String name;
	private Gender gender;
	private Person mother;
	private Person father;
	private List<Person> children;
	
	public Person(int id ,String name, Gender gender) {
		this.id = id;
		this.name = name;
		this.father = null;
		this.mother = null;
		children = new ArrayList<>();
	}
	
	public Person(int id, String name, Gender gender, Person father, Person mother) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.father = father;
		this.mother = mother;
		children = new ArrayList<>();
	}
	
	public boolean addChild(Person child) {
		if (!children.contains(child)){
			children.add(child);
			return true;
		}
		return false;
	}
	
	//Геттеры и сеттеры для всех полей
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Person getMother() {
		return mother;
	}
	
	public Person getFather() {
		return father;
	}
	
	public List<Person> getChildren() {
		return children;
	}
	
	public String getInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Имя ");
		sb.append(name);
		sb.append(", ");
		sb.append(getMotherInfo());
		sb.append(", ");
		sb.append(getFatherInfo());
		sb.append(", ");
		sb.append(getChildrenInfo());
		return sb.toString();
	}
	
	public String getMotherInfo() {
		String res = "Mother: ";
		if (mother != null) {
			res += mother.getName();
		} else {
			res += "no data";
		}
		return res;
	}
	
	public String getFatherInfo() {
		String res = "Father: ";
		if (father != null) {
			res += father.getName();
		} else {
			res += "no data";
		}
		return res;
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
