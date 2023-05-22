package model.familyTree;
import java.util.Collections;

import model.human.Human;
import model.familyTree.*;

public class TreeService {

    private Tree tree;
    public TreeService(Tree tree) {
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
        Human person = new Human(inp_firstname, 
        inp_lastname, 
        inp_birth_date, 
        inp_deth_date, 
        inp_gender, 
        inp_person_id, 
        inp_father_id, 
        inp_mother_id);
        if(person != null){
        tree.addHuman(person);
    }
   
}
    public void addHuman(Human person) {
        Human person_1 = new Human(person.getFirstName(), 
        person.getLastName(), 
        person.getBirthDate(), 
        person.getDethDate(), 
        person.getgender(), 
        person.getPerson_id(), 
        person.getFather_id(), 
        person.getMother_id());
        
        if (person_1 != null)
    {
        tree.addHuman(person_1);
    }
    
    }

    public void sortByLastname(){
        Collections.sort(tree.getHumanList());
    }


}