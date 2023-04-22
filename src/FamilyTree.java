import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree<H extends Human> implements Serializable {
    private List<H> familyTree;

    public FamilyTree() {
        this.familyTree = new ArrayList<H>();
    }

    List<H> getFamilyTree() {
        return familyTree;
    }

    void sortByParameter(int sortNumber) {
        switch (sortNumber) {
            case 1:
                sortByName();
                System.out.println("Сортировка по имени");
                print();
                break;
            case 2:
                sortByBirth();
                System.out.println("Сортировка по году рождения");
                print();
                break;
            default:
                System.out.println("Вы ввели некорректный номер сортировки!");
        }
    }

    void addHuman(H human) {
        familyTree.add(human);
        if (human.getMother() != null) {
            human.getMother().addChild(human);
        }
        if (human.getFather() != null) {
            human.getFather().addChild(human);
        }
    }

    Human getHumanByName(String name) {
        String nameFull = name.replace(",", " ");
        for (Human human : familyTree) {
            if (human.getName().equals(nameFull)) {
                return human;
            }
        }
        return null;
    }

    Gender getGender(String gender) {
        if (gender.equals("M")) {
            return Gender.Male;
        } else if (gender.equals("F")){
            return Gender.Female;
        }
        return null;
    }

    void sortByName() {
        familyTree.sort(new HumanComparatorByName());
    }

    void sortByBirth() {
        familyTree.sort(new HumanComparatorByBirth());
    }

    public void print() {
        for (H h : familyTree) {
            System.out.println(h.toString());
        } 
    }
}
