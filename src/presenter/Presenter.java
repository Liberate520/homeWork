package presenter;

import Tree.*;
import Tree.interfaces.Writable;
import UI.interfaces.View;

import java.io.IOException;


import static Tree.MyFamily.myFamily;

public class Presenter {
    private View view;
    private FamilyTree familyTree = new FamilyTree();
    private Writable handler = new Handler();
    

    public Presenter(View view) {
        this.view = view;
        // this.familyTree = familyTree;
        myFamily(familyTree);
        view.setPresenter(this);
    }

    public String treeList() {
        return familyTree.getInfo();
    }
   
    public String searchByFirstName(String string) {
        return familyTree.searchByFirstName(string);
    }

    public String searchBySecondName(String string) {
        return familyTree.searchBySecondName(string);
    }

    public String searchByFullName(String string) {
        return familyTree.searchByFullName(string);
    }

    public String searchByDateOfBirth(String string) {
        return familyTree.searchByDateOfBirth(string);
    }

    public String searchByAliveOrNot(Integer i) {
        return familyTree.searchByAliveOrNot(i);
    }

    public String searchByDateOfDeath(String string) {
        return familyTree.searchByDateOfDeath(string);
    }

    public String sortByName() {
        return familyTree.sortByName();
    }


    public String sortBySecondName() {
        return familyTree.sortBySecondName();
    }


    public String sortByAlive() {
        return familyTree.sortByAlive();
    }


    public String sortByChild() {
        return familyTree.sortByChild();
    }

    public void save() throws IOException {
        handler.save(familyTree);
    }
    
    public void read() throws IOException, ClassNotFoundException {
        familyTree = handler.read();
        System.out.println();
    }
    
    public void getAllPersonFromList() {
        for (int i = 0; i < familyTree.getPersonList().size(); i++) {
            System.out.println((i+1) + ". " + ((Person) familyTree.getPersonList().get(i)).getFullName());
        }
    }

	public void add(Person new_person) {
        familyTree.add(new_person);
	}

    public String setFather(int father, int child) {
        return familyTree.setFather(father, child);
    }

    public String setMother(int mother, int child) {
        return familyTree.setMother(mother, child);
    }

    public String addChild(int person, int child) {
        return familyTree.addChild(person, child);
    }

}
