package homeWorkSem1;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import homeWorkSem1.Service.FamilyTreeIterator;
import homeWorkSem1.Service.Writeble;


public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {
    
    private List<T> humans;
    private Human father;
    private Human mother;
 
    
    /**Инициализация humans */
    public FamilyTree(List<T> humans) {
        this.humans = humans;
    }

    /**Добавление нового human в список */
    public FamilyTree() {
        this(new ArrayList<>());
    }

    /**Добавление нового Human */
    public void add(T human) {
        humans.add(human);
        if (father != null) {
            father.children.add(human);  
        }
        if (mother != null)  {
            mother.children.add(human);
        } 
    }


    //*возвращает список humans */
    public List<T> getHumans() {
        return humans;
    }

    /**Поиск по имени */
    public List<T> getHumanbyName(String findByName) {
        List<T> list = new ArrayList<>();
        for (T human : humans ) {
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