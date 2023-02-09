package homeWorkSem1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import homeWorkSem1.Service.FamilyTreeIterator;


public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {
    
    private List<T> humans;
 
    
    /**Инициализация humans */
    public FamilyTree(List<T> humans) {
        this.humans = humans;
    }

    /**создание нового списка */
    public FamilyTree() {
        this(new ArrayList<>());
    }

    /**Добавление нового Human */
    public void add(T human) {
        humans.add(human);
        human.addChild(human);
    }


    //*возвращает список humans */
    public List<T> getHumans() {
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

    
    //* создаем объект кдасса итератор */
    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<>(humans);
    }
}