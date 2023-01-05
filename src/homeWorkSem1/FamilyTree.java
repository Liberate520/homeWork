package homeWorkSem1;
import homeWorkSem1.Service.FamilyTreeIterator;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    
    private List<Human> humans;
    private Human father;
    private Human mother;
    private static int id;
    //private List<Human> children = new ArrayList<>();

    private Writeble fileHandler; //работа с файлами
 
    
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

    /**Создать Human с id и добавить в список humans */
    public void createHuman(String name, int age, Gender gender, Human father, Human mother) {
        Human human = new Human(name, age, gender, father, mother, id++);
        humans.add(human);
        if (father != null) {
            father.children.add(human);  
        }
        if (mother != null)  {
            mother.children.add(human);
        } 
    }

    //*возвращает список humans */
    public List<Human> getHumans() {
        return humans;
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

    /** сохранение */
    public void save(Serializable serializable) throws IOException {
        fileHandler.save(serializable);
    }

    //* создаем объект кдасса итератор */
    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(humans);
    }
}