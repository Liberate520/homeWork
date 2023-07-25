package family_tree.model.tree;

import family_tree.model.file_handler.FileHandler;
import family_tree.model.human.Child_type;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;

import java.time.LocalDate;

public class TreeService {
    private Tree<Human> family;
    private FileHandler fileHandler;
    private Connection_Manager<Human> connectionManager;
    private Connection_Info<Human> connectionInfo;
    public TreeService() {
        family = new Tree<>();
        fileHandler = new FileHandler();
        connectionManager = new Connection_Manager<>();
        connectionInfo = new Connection_Info<>();
    };
    public void addFamilyMember(String name, LocalDate dateOfBirth, Gender gender){
        Human human = new Human(name, dateOfBirth, gender);
        family.addFamilyMember(human);
    }
    public void setParentChild(int id_parent, int id_child, Child_type type){
        connectionManager.addChild(family.getFamilyMember(id_child), family.getFamilyMember(id_parent), type);
    }
    public boolean setHusbandWife(int id_husband, int id_wife){
        return connectionManager.wedding(family.getFamilyMember(id_husband), family.getFamilyMember(id_wife));
    }
    public boolean unsetHusbandWife(int id_husband, int id_wife){
        return connectionManager.divorce(family.getFamilyMember(id_husband), family.getFamilyMember(id_wife));
    }
    public String showSiblings(int id_human){
        return connectionInfo.getSiblings(family.getFamilyMember(id_human));
    }
    public void sortByAge(){
        family.sortByAge();
    }
    public void sortByName(){
        family.sortByName();
    }
    public String getFamilyMemberInfo(int id){
        return family.getFamilyMember(id).toString();
    }
    public void setDateOfDeath(int id, LocalDate dateOfDeath){
        family.getFamilyMember(id).setDateOfDeath(dateOfDeath);
    }

    public String getFamilyInfo(){
        StringBuilder sb = new StringBuilder();
        for (Human member : this.family) {
            sb.append(member.getId()).append(". ").append(member.getName()).append("\n");
            sb.append(member);
            sb.append("______________________________").append("\n");
        }
        return sb.toString();
    }

    public boolean saveFamily(String fileName){
        return fileHandler.save(family, fileName);
    }
    public boolean loadFamily(String fileName){
        if (fileHandler.read(fileName) == null){
            return false;
        }
        else {
            family = fileHandler.read(fileName);
            return true;
        }
    }
}
