package familyTree;

import familyTree.iterator.FamilyTreeIterator;
import obj.human.sort.SortByAge;
import obj.human.sort.SortByBornDate;
import obj.human.sort.SortByFirstName;
import obj.human.sort.SortByLastName;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Iterable<E>,Serializable{

    private  long humansId;
    private List<E> humanList;
    public FamilyTree(){this(new ArrayList<>());}
    public FamilyTree(List<E> listHuman){this.humanList = listHuman;}

    public boolean add(E human){
        if(human == null){return false;}
        else if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);
            addToParents(human);
            addToChildrens(human);
            return true;
        }
        return false;
    }

    public E getById(long id){
        for(E person : humanList){
            if(person.getId() == id){
                return person;
            }
        }
        return null;
    }

    public List<E> getByName(String name){
        List<E> list = new ArrayList<>();
        for(E human : humanList){
            if(human.getLstName().equals(name)){
                list.add(human);
            }
        }
        return list;
    }

    public List<E> getByFamily(String family){
        List<E> list = new ArrayList<>();
        for(E human : humanList){
            if(human.getFstName().equals(family)){
                list.add(human);
            }
        }
        return list;
    }

    public List<E> getByFIO(String name, String family){
        List<E> list = new ArrayList<>();
        for(E human : humanList){
            if((human.getLstName().equals(name)) && (human.getFstName().equals(family))){
                list.add(human);
            }
        }
        return list;
    }

    public List<E> getList(){
        List<E> list = new ArrayList<>();
        for(E human : humanList){
            list.add(human);
        }
        return list;
    }

    private void addToChildrens(E human){
        for(E child : human.getChildrens()){
            child.addParent(human);
        }
    }



    private void addToParents(E human){
        E mother = human.getMother();
        E father = human.getFather();
        if(mother != null){
            mother.addChild(human);
        }
        if(father != null){
            father.addChild(human);
        }
    }

    private boolean checkId(long id){
        if(id >= humansId || id <0){
            return false;
        }
        for(E human : humanList){
            if(human.getId() == id){
                return true;
            }
        }
        return false;
    }

    public String info(){
        StringBuilder sb = new StringBuilder();
        sb.append("Семейное дерево: \n");
        sb.append(humanList.size()).append(" - Объектов находящихся в дереве!\n");
        sb.append("Перечисление:\n");
        for(E human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public Iterator<E> iterator(){
        return new FamilyTreeIterator(humanList);
    }

    @Override
    public String toString() {return info();}

    public void sortByFirstName(){
        humanList.sort(new SortByFirstName());
    }

    public void sortByLastName(){
        humanList.sort(new SortByLastName());
    }

    public void sortByAge(){
        humanList.sort(new SortByAge());
    }

    public void sortByBornDate(){
        humanList.sort(new SortByBornDate());
    }

}
