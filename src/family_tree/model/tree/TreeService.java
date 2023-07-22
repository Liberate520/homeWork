package family_tree.model.tree;

import family_tree.model.file_handler.FileHandler;
import family_tree.model.human.Child_type;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;

import java.time.LocalDate;

public class TreeService {
    private Tree<Human> family;
    private FileHandler fileHandler;
    public TreeService() {
        family = new Tree<>();
        fileHandler = new FileHandler();
    };
    public void addFamilyMember(String name, LocalDate dateOfBirth, Gender gender){
        Human human = new Human(name, dateOfBirth, gender);
        family.addFamilyMember(human);
    }
    public void setParentChild(int id_parent, int id_child, Child_type type){
        family.getFamilyMember(id_parent).addChild(family.getFamilyMember(id_child), type);
    }
    public void setHusbandWife(int id_husband, int id_wife){
        family.wedding(family.getFamilyMember(id_husband), family.getFamilyMember(id_wife));
    }
    public void unsetHusbandWife(int id_husband, int id_wife){
        family.divorce(family.getFamilyMember(id_husband), family.getFamilyMember(id_wife));
    }
    public void showSiblings(int id_human){
        family.getSiblings(family.getFamilyMember(id_human));
    }
    public void sortByAge(){
        family.sortByAge();
    }
    public void sortByName(){
        family.sortByName();
    }
    public void getFamilyMemberInfo(int id){
        System.out.println(family.getFamilyMember(id).toString());
    }
    public void setDateOfDeath(int id, LocalDate dateOfDeath){
        family.getFamilyMember(id).setDateOfDeath(dateOfDeath);
    }

    public void getFamilyInfo(){
        StringBuilder sb = new StringBuilder();
        for (Human member : this.family) {
            sb.append(member.getId()).append(". ").append(member.getName()).append("\n");
            sb.append(member);
            sb.append("______________________________").append("\n");
        }
        System.out.println(sb.toString());
    }

    public void saveFamily(String fileName){
        fileHandler.save(family, fileName);
    }
    public void loadFamily(String fileName){
        family = fileHandler.read(fileName);
    }
}
