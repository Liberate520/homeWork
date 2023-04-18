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

    public void treeList() {
        System.out.println(familyTree.getInfo());
        System.out.println();
    }
   
    public void searchByFirstName(String string) {
        familyTree.searchByFirstName(string);
        System.out.println();
    }
    public void searchBySecondName(String string) {
        familyTree.searchBySecondName(string);
        System.out.println();
    }
    public void searchByFullName(String string) {
        familyTree.searchByFullName(string);
        System.out.println();
    }
    public void searchByDateOfBirth(String string) {
        familyTree.searchByDateOfBirth(string);
        System.out.println();
    }
    public void searchByAliveOrNot(Integer i) {
        familyTree.searchByAliveOrNot(i);
        System.out.println();
    }
    public void searchByDateOfDeath(String string) {
        familyTree.searchByDateOfDeath(string);
        System.out.println();
    }

    public void sorting(Integer i) {
    if(i == 1){familyTree.sortByName();}
    if(i == 2){familyTree.sortBySecondName();}
    if(i == 3){familyTree.sortByAlive();}
    if(i == 4){familyTree.sortByChild();}
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
   
	public void dateOfBirth(int nextInt) {
        familyTree.dateOfBirth(nextInt);
	}


	public void add(Person new_person) {
        familyTree.add(new_person);
	}

    public void setFather(int father, int child) {
        familyTree.setFather(father, child);
    }

    public void setMother(int mother, int child) {
        familyTree.setMother(mother, child);
    }

    public void addChild(int person, int child) {
        familyTree.addChild(person, child);
    }

}
