package service;

import person.Person;
import tree.FamilyTree;
import write_read.FileHandler;
import write_read.Saveable;

public class Service {
	private int id;
	private FamilyTree<Person> familyGroup;
	
	public Service(FamilyTree<Person> familyGroup) {
		this.familyGroup = familyGroup;
	}
	
	public FamilyTree<Person> getFamilyGroup() {
		return familyGroup;
	}
	
	public void addPerson(String name, String lastname, Person mother, Person father) {
		familyGroup.add(new Person(id++, name, lastname, mother.getMotherId(), father.getFatherId()));
	}
	
	public void addPerson(String name, String lastname) {
		familyGroup.add(new Person(id++, name, lastname));
	}
	
	public void sortById(){
		familyGroup.sortById();
	}
	public void sortByName() {
		familyGroup.sortByName();
	}
	public void sortByLastname(){
		familyGroup.sortByLastname();
	}
	public boolean removePerson(int id){
		familyGroup.removePerson(id);
		return true;
	}
	public void saveFamilyGroup(String str) {
		FileHandler save = new FileHandler();
		save.saveFile(this.familyGroup, str);
	}
	
	public void loadFamilyGroup(String str) {
		Saveable load = new FileHandler();
		this.familyGroup = load.loadFile(str);
		id = 1;
		for (Person item : this.familyGroup) {
			if (id < item.getId()) id = item.getId();
		}
	}
	public Object searchPerson(String lastName) {
		return familyGroup.searchPerson(lastName);
	}
}
