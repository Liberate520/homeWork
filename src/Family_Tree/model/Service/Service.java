package Family_Tree.model.Service;

import Family_Tree.model.Writer.FileHandler;
import Family_Tree.model.Human.Human;
import Family_Tree.model.Human.Gender;
import Family_Tree.model.Tree.FamilyTree;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> tree;
    private FileHandler<Human> storage = new FileHandler();

    public Service() {
        tree = new FamilyTree<>();
    }

    public boolean add(String name, LocalDate birthday, Gender gender) {
        Human human = new Human(name, birthday, gender);
        tree.add(human);
        return true;
    }

    public String getHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список родственников: \n");
        for (Human human: tree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByBirthday(){
        tree.sortByBirthday();
    }
    public boolean read(String filePath){
        FamilyTree<Human> tmpTree = storage.read(filePath);
        if (tmpTree.equals(null)){
            return false;
        }
        tree = tmpTree;
        return true;
    }

    public boolean save(String fileName){
        return storage.write(tree, fileName);

    }

//    public boolean setWedding(Human human1, Human human2) {
//        if (human1.getSpouse() == null && human2.getSpouse() == null) {
//            human1.setSpouse(human2);
//            human2.setSpouse(human1);
//            return true;
//        } else {
//            return false;
//        }
//    }

    @Override
    public String toString(){
        return getHumanListInfo();
    }

}
