package family_tree.presenter;

import family_tree.model.human.Child_type;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.tree.TreeService;
import family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private TreeService service;

    public Presenter(View view){
        this.view = view;
        service = new TreeService();

    }
    public void addFamilyMember(String name, LocalDate dateOfBirth, Gender gender){
        service.addFamilyMember(name, dateOfBirth, gender);
        getFamilyInfo();
    }
    public void setParentChild(int id_parent, int id_child, Child_type type){
        service.setParentChild(id_parent, id_child, type);
    }
    public void setHusbandWife(int id_husband, int id_wife){
        service.setHusbandWife(id_husband, id_wife);
    }
    public void unsetHusbandWife(int id_husband, int id_wife){
        service.unsetHusbandWife(id_husband, id_wife);
    }
    public void showSiblings(int id_human){
        service.showSiblings(id_human);
    }
    public void sortByAge(){
        service.sortByAge();
    }
    public void sortByName(){
        service.sortByName();
    }
    public void getFamilyMemberInfo(int id){
        service.getFamilyMemberInfo(id);
    }
    public void setDateOfDeath(int id, LocalDate dateOfDeath){
        service.setDateOfDeath(id, dateOfDeath);
    }

    public void getFamilyInfo(){
        service.getFamilyInfo();
    }

    public void saveFamily(String fileName){
        service.saveFamily(fileName);
    }
    public void loadFamily(String fileName) {
        service.loadFamily(fileName);
    }
}
