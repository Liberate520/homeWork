package human;

import common.FTImpersonal;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human<E extends FTImpersonal<E>> implements Serializable, FTImpersonal {
	private int id;


	private String lastName;
	private String firstName;
	private String fullName;
	private LocalDate birthDay;

	private List<Human> parents;

	private List<Human> children;
	private Gender gender;

	public Human(){

	}

	public Human(String lastName, String firstName, Gender gender,LocalDate birthDay, Human father, Human mother) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.gender = gender;
		this.birthDay = birthDay;
		fullName = lastName + " " + firstName;
		parents = new ArrayList<>();
		if (father != null) {
			parents.add(father);
		}
		if (mother != null) {
			parents.add(mother);
		}
		children = new ArrayList<>();
	}
	public Human(String lastName, String firstName, Gender gender, LocalDate birthDay) {
		this(lastName, firstName, gender, birthDay, null, null);
		id++;
		fullName = lastName + " " + firstName;
	}
	public int getId() { return id; }
	public String getLastName() { return lastName; }
	public String getFirstName() { return firstName; }

	public String getFullName() { return fullName; }

	public LocalDate getBirthDay() { return birthDay; }

	public Gender getGender() { return gender; }

	public void addParent (Object parent){ if(!parents.contains(parent)) parents.add((Human) parent); }
	public void addChild(Object child){ if (!children.contains(child)) children.add((Human) child); }
	public List<Human> getParents(){ return parents; }
	public List<Human> getChildren(){ return children; }

	@Override
	public void sortByName() {

	}

	public Human getFather() {
		for (Human parent : parents) {
			if (parent.getGender() == Gender.Male)
				return parent;
		}
	return null;
	}
	public Human getMother() {
		for (Human parent: parents) {
			if (parent.getGender() == Gender.Female){
				return parent;
			}
		}
	return null;
	}

	public String getInfo (){
		StringBuilder builder = new StringBuilder();
		builder.append("Name: ");
		builder.append(fullName);
		builder.append(" | ");
		builder.append("Gender: ");
		builder.append(gender);
		builder.append(" | ");
		builder.append("Birth Day: ");
		builder.append(birthDay);
		builder.append(" | ");
		builder.append(getFatherInfo());
		builder.append(" | ");
		builder.append(getMotherInfo());
		builder.append(" | ");
		builder.append(getChildrenInfo());
		return builder.toString();
	}

	@Override
	public Object getByName() {
		return null;
	}

	public String getFatherInfo(){
		String dad;
		Human human = getFather();
		if (human != null){
			dad = "dad: " + human.getFullName();
		}
		else {
			dad = "dad: no";
		}
	return dad;
	}
	public String getMotherInfo(){
		String mom;
		Human mother = getMother();
		if (mother != null){
			mom = "mom: " + mother.getFullName();
		}
		else mom = "mom: no";
	return mom;
	}
	public String getChildrenInfo() {
		StringBuilder lst = new StringBuilder();
		lst.append("kids: ");
		if (children.size() != 0) {
			for (int i = 0; i < children.size(); i++) {
				if (i != children.size()-1) {
					lst.append(children.get(i).getFullName());
					lst.append(", ");
				}
				else lst.append(children.get(i).getFullName());
			}
		}
		else lst.append("no");
	return lst.toString();
	}
	@Override
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(!(obj instanceof Human)){
			return false;
		}
		Human human = (Human) obj;
		return human.getFullName().equals(getFullName());
	}
}
