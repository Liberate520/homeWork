package service;

import person.Gender;
import person.Person;
import tree.FamilyTree;

public class Service {
	private int id;
	private FamilyTree familyGroup;
	
	public Service(FamilyTree familyGroup) {
		this.familyGroup = familyGroup;
	}
	
	public FamilyTree getFamilyGroup(){
		return familyGroup;
	}
	
	public void addPerson(String name, Gender gender, Person mother, Person father){
		familyGroup.addPerson(new Person(id++, name, gender, mother.getMother(), father.getFather()));
	}
	public void addPerson(String name, Gender gender){
		familyGroup.addPerson(new Person(id++, name, gender));
	}
	
	public void sortByName(){
		familyGroup.sortByName();
	}
}
