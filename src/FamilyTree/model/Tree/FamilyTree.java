package FamilyTree.model.Tree;

import FamilyTree.model.Person.Person;
import FamilyTree.model.Person.comparators.CompareByPersonAge;
import FamilyTree.model.Person.comparators.CompareByPersonName;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeElements<E>> implements Serializable, Iterable<E> {
    private List<E> tree;
    private String family;

    public FamilyTree(String str){
        this.tree = new ArrayList<>();
        this.family = str;
    }

    // 1 Добавление человека
    public void addPerson(E person){
        if (!tree.contains(person)){
            tree.add(person);
        }
    }

    // 3 Добавление детей (ссылки на родителей уже внутри класса) (у родителей прописать так же детей)
//    public void addChild(E child){
//        addPerson(child);
//        if (child.getMother() != null) { child.getMother().addChild(child); }
//        if (child.getFather() != null) { child.getFather().addChild(child); }
//
//    }
//    public void addChild(E child, E mother){
//        child.addMother(mother);
//        addChild(child);
//    }
//    public void addChild(E child, E father){
//        child.addFather(father);
//        addChild(child);
//    }

    public E getElementById(int id){
        for (E el: tree) {
            if (el.getId() == id) {return el;}
        }
        return null;
    }

    public void addParent(E child, E mother, E father){
        if(tree.contains(child)){
            child.addFather(father);
            child.addMother(mother);
        }
    }
    // 4 Свадьба
    public void setMarriage(E spouse1, E spouse2, LocalDate marriageDate ){
        if (!tree.contains(spouse1)) { addPerson(spouse1); }
        if (!tree.contains(spouse2)) { addPerson(spouse2); }
        spouse1.setMarriage(spouse2, marriageDate);
        spouse2.setMarriage(spouse1, marriageDate);
    }
    // 5 Развод
    public void setDivorce(E spouse1, E spouse2, LocalDate divorceDate ){
        if (tree.contains(spouse1) && tree.contains(spouse2)) {
            spouse1.setDivorce(spouse2, divorceDate);
            spouse2.setDivorce(spouse1, divorceDate);
        }
    }
    // 6 Смерть
    public void setDeath(E person, LocalDate deathDate){
        if (tree.contains(person)){ person.setDead(deathDate); }
    }
    // 7 Напечатать дерево
    // 8 Найти человека

    // *9 Ссылка на дерево
    public List<E> getListFamilyTree() { return tree; }

    public void sortByName(){
        tree.sort(new CompareByPersonName());
    }

    public void sortByAge(){
        tree.sort(new CompareByPersonAge());
    }
    @Override
    public Iterator<E> iterator() {
        return new PersonIterator<>(tree);
    }

    @Override
    public String toString(){
        String ret_str = "";
        for (E el: tree) {
            ret_str += el.toString();
            ret_str += "\n";
        }
        return ret_str;
    }
}