import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * FamilyTree работает со списком людей, пока непонятно как)))
 */
public class FamilyTree implements Serializable {
    private final List<Human> people;

    public FamilyTree(List<Human> lstHumans) {
        this.people = lstHumans;
    }

    public FamilyTree(Human human) {
        this.people = new ArrayList<>();
        this.people.add(human);
    }

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    /**
     * Метод добавляет человека в семью.
     */
    public void addHuman(Human human) {
        this.people.add(human);
        if (human.getFather() != null) {
            human.getFather().addChild(human);
        }
        if (human.getMother() != null) {
            human.getMother().addChild(human);
        }
    }
    /**
     * Метод поиска человека по имени.
     */
    public Human getByName(String str) {
        List<String> lst = List.of(str.split(" "));
        for (Human human : this.people) {
            if (human.getName().equals(lst.get(0)) && human.getSecondName().equals(lst.get(1)) && human.getSurname().equals(lst.get(2))) {
                return human;
            }
        }
        return null;
    }
    /**
     * Метод вывода информации о детях.
     */
    public void printChildren(Human human) {
        if (human.getChildren() != null) {
            System.out.println(human);
            System.out.println("Дети:");
            for (Human child : human.getChildren()) {
                System.out.println(child);
            }
        }else{
            System.out.println(human);
            System.out.println("Детей нет.");
        }
    }
    /**
     * Метод сохранения дерева.
     */
    public void save(Writable writable) throws IOException {
        writable.save(this);
    }

}