package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Загружаем из файла информацию о людях их связях из файла csv базы
 * Создаем список объектов типа Person
 * Все изменения так же будут записываться в файл
 * 
 * @param <E>
 */
public class Tree<E extends Person> implements Iterable<E> {
    private Map<Integer, E> persons_list;

    public Tree() {
        persons_list = new HashMap<>();
    }

    public List<E> getThePersonsList() {
        List<E> pers_list = new LinkedList<>();
        for (E pers : this)
            pers_list.add(pers);
        return pers_list;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (E pers : this) {
            res.append(pers.toString());
        }
        return res.toString();
    }

    public void add(int id, E pers) {
        this.persons_list.put(id, pers);
    }

    public ArrayList<E> searchByName(String name) {
        ArrayList<E> res_array = new ArrayList<>();
        for (E pers : this) {
            if (pers.getPerson_name().toLowerCase().contains(name.toLowerCase()))
                res_array.add(pers);
        }
        return res_array;
    }

    public int size() {
        return this.persons_list.size();
    }

    public E get(int id) {
        return this.persons_list.get(id);
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<E>(this.persons_list);
    }

    public void addFather(int son_id, int father_id) {
        this.get(son_id).setFather(this.get(father_id));
        this.get(father_id).setFather(this.get(son_id));
    }

    public void addMother(int son_id, int mother_id) {
        this.get(son_id).setMother(this.get(mother_id));
        this.get(mother_id).setFather(this.get(son_id));
    }
}
