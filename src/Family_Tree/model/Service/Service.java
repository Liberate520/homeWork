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

    @Override
    public String toString(){
        return getHumanListInfo();
    }

}
