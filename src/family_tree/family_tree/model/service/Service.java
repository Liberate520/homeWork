package family_tree.family_tree.model.service;

import family_tree.family_tree.model.*;
import family_tree.family_tree.model.human.Human;
import java.time.LocalDate;

public class Service{
//    private int index;
    private FamilyTree<Human> novoeTree;
    private Writable<FamilyTree<Human>> writable;

    public Service() {
        novoeTree = new FamilyTree<>();
        this.writable = writable;
//        FamilyTree<Human> familyTree;
//        List<Human> humanList;
    }
public boolean save(String filePath){
        if (writable == null){
            return false;
        }
        return writable.save(novoeTree, filePath);
}
public boolean read(String filePath){
        FamilyTree<Human> tempTree = new FamilyTree<>();
        tempTree = writable.read(filePath);
        if (writable == null){
            return false;
        }
        novoeTree = tempTree;
        return true;
}


//    public String getInfo() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Семейное дерево:\n");
//
////        Iterable<? extends Human> humanList;               // ???
////        humanList = null;
//
//        for (Human human : humanList) {
//            stringBuilder.append(human.getInfo());
//            stringBuilder.append("\n");
//        }
////        return stringBuilder.toString();
//    }
    public String getHumanListInfo() {
        return novoeTree.getInfo();

}

    public String addHuman(String name,  String genderString, String birthDate){
        Gender gender = Gender.valueOf(genderString);
        LocalDate humanBirthDare = LocalDate.parse(birthDate);
        Human human = new Human(name, gender, humanBirthDare);
        novoeTree.addHuman(human);
        return "Человек добавлен";
    }
    public void sortByName() {
        novoeTree.sortByName();
    }
    public void sortByAge() {
        novoeTree.sortByAge();
    }
    public void sortById() {
        novoeTree.sortById();
    }

    public void setParent(int person_id, int parent_id){
        Human human = novoeTree.getById(person_id);
        human.addParent(novoeTree.getById(parent_id));
        novoeTree.getById(parent_id).addChild(human);
    }

    public boolean checkId(int id){
        return novoeTree.checkId(id);
    }


}
