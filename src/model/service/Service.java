package model.service;
import model.*;
import write_read.WriteAndRead;
import java.io.IOException;
import java.time.LocalDate;

public class Service {
	private FamilyTree<Human> familyTree;
	public Service(){
		familyTree = new FamilyTree<>();
	}

	public void addM(String lastName, String firstName, Gender gender, LocalDate birthDay, Human dad, Human mom) {
		Human human = new Human(lastName, firstName, gender, birthDay, dad, mom);
		familyTree.add(human);
	}

	public String getInfo() {
		return  familyTree.getInfo();
	}

	public void sortByName(){
		familyTree.sortByName();}
	public void sortByBirthDay(){
		familyTree.sortByBirthDay();}

	public void writeF(String file) throws IOException {
		String path = "src/" + file;
		write_read.WriteAndRead war = new write_read.WriteAndRead();
        war.writeFile(path, familyTree);
	}

	public void readF(String file) throws IOException, ClassNotFoundException {
		String path = "src/" + file;
		WriteAndRead war = new WriteAndRead();
		this.familyTree = (FamilyTree) war.readFile(path);
	}
}
