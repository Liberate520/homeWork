
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {

    private List<Human> familyTree;


    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    /**
     * Добавить нового члена семьи в дерево
     */
    public void addHumanOfFamilyTree(Human human) {

        familyTree.add(human);
    }

    /**
     * Показать список имен и фамилий в генеалогическое дереве
     */
    public void listOfNames() {
        int count = 0;
        for (Human human : familyTree) {
            count++;
            System.out.println(count + " " + human.getFullName());
        }
    }

    /**Поиск по имени*/
    public void searchByName(String find){
        for (Human human : familyTree) {
            if (human.getFirstName().equals(find)){
                human.getInfo();
            }
        }
    }

}
