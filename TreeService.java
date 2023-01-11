package Семинар1.homeWork;

import java.util.Collections;

public class TreeService {

    private Tree<Human> tree;
    public TreeService(Tree<Human> tree) {
        this.tree = tree;

    }
    public void addHuman(String inp_firstname, 
                         String inp_lastname, 
                         String inp_birth_date, 
                         String inp_deth_date, 
                         String inp_gender, 
                         String inp_person_id, 
                         String inp_father_id, 
                         String inp_mother_id) {
        tree.addHuman(new Human(inp_firstname, 
        inp_lastname, 
        inp_birth_date, 
        inp_deth_date, 
        inp_gender, 
        inp_person_id, 
        inp_father_id, 
        inp_mother_id) );
    }
    public void addHuman(Human person) {
        tree.addHuman(new Human(person.getFirstName(), 
        person.getLastName(), 
        person.getBirthDate(), 
        person.getDethDate(), 
        person.getgender(), 
        person.getPerson_id(), 
        person.getFather_id(), 
        person.getMother_id()) );
    }
    

    public void sortByLastname(){
        Collections.sort(tree.getHumanList());
    }
}
