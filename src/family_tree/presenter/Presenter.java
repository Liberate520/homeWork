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
    public boolean setHusbandWife(int id_husband, int id_wife){
        return service.setHusbandWife(id_husband, id_wife);
    }
    public boolean unsetHusbandWife(int id_husband, int id_wife){
        return service.unsetHusbandWife(id_husband, id_wife);
    }
    public String showSiblings(int id_human){
        return service.showSiblings(id_human);
    }
    public void sortByAge(){
        service.sortByAge();
    }
    public void sortByName(){
        service.sortByName();
    }
    public String getFamilyMemberInfo(int id){
        return service.getFamilyMemberInfo(id);
    }
    public void setDateOfDeath(int id, LocalDate dateOfDeath){
        service.setDateOfDeath(id, dateOfDeath);
    }

    public String getFamilyInfo(){
        return service.getFamilyInfo();
    }

    public boolean saveFamily(String fileName){
        return service.saveFamily(fileName);
    }
    public boolean loadFamily(String fileName) {
        return service.loadFamily(fileName);
    }
}
