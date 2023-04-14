package presenter;

import Tree.*;
import Tree.interfaces.Writable;
import ui.interfaces.View;

import java.io.IOException;

import static Tree.MyFamily.myFamily;

public class Presenter {
    private View view;
    private FamilyTree familyTree = new FamilyTree();
    private Writable handler = new Handler();

    public Presenter(View view) {
        this.view = view;
        myFamily(familyTree);
        view.setPresenter(this);
    }

    public void treeList() {
        familyTree.getInfo();
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
        familyTree.searchByDateOfBerth(string);
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
        handler.read();
        System.out.println();
    }
    
    public void getAllPersonFromList() {
        for (int i = 0; i < familyTree.getPersonList().size(); i++) {
            System.out.println((i+1) + ". " + ((Person) familyTree.getPersonList().get(i)).getFullName());
        }
    }
   
	public void dateOfBirth(Integer i) {
        familyTree.dateOfBirth(i);
	}

    
}
