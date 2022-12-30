package homeWorkSem1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable{
    
    List<Human> humans;
    private Human father;
    private Human mother;
    List<Human> children = new ArrayList<>();

    
    /**Инициализация humans */
    public FamilyTree(List<Human> humans) {
        this.humans = humans;
    }

    /**Добавление нового human в список */
    public FamilyTree() {
        this(new ArrayList<>());
    }

    /**Добавление нового Human */
    public void add(Human human) {
        humans.add(human);
        if (father != null) {
            father.children.add(human);  
        }
        if (mother != null)  {
            mother.children.add(human);
        } 
    }

    /**Поиск по имени */
    public List<Human> getHumanbyName(String findByName) {
        List<Human> list = new ArrayList<>();
        for (Human human : humans ) {
            if (findByName.equals(human.getName())) {
                list.add(human);
            }
        }
        return list;
    }

    /**Переопределение метода toString */
    @Override
    public String toString() {
        return "\n" + humans + " ";
    }

    Writeble fileSaver;
    public void save(Serializable serializable) {
        fileSaver.save(serializable);
    }
}
