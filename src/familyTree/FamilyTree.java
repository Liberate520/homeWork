package familyTree;

import human.Human;
import human.sort.sortByAge;
import human.sort.sortByBornDate;
//import human.sort.sortByFirstName;
import human.sort.sortByLastName;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human>{

    private  long humansId;
    private List<Human> humanList;
    public FamilyTree(){this(new ArrayList<>());}
    public FamilyTree(List<Human> listHuman){this.humanList = listHuman;}

    public boolean add(Human human){
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

    public Human getById(long id){
        for(Human person : humanList){
            if(person.getId() == id){
                return person;
            }
        }
        return null;
    }

    public List<Human> getByName(String name){
        List<Human> list = new ArrayList<>();
        for(Human human : humanList){
            if(human.getLstName().equals(name)){
                list.add(human);
            }
        }
        return list;
    }

    public List<Human> getByFamily(String family){
        List<Human> list = new ArrayList<>();
        for(Human human : humanList){
            if(human.getFstName().equals(family)){
                list.add(human);
            }
        }
        return list;
    }

    public List<Human> getByFIO(String name, String family){
        List<Human> list = new ArrayList<>();
        for(Human human : humanList){
            if((human.getLstName().equals(name)) && (human.getFstName().equals(family))){
                list.add(human);
            }
        }
        return list;
    }

    public List<Human> getList(){
        List<Human> list = new ArrayList<>();
        for(Human human : humanList){
            list.add(human);
        }
        return list;
    }

    private void addToChildrens(Human human){
        for(Human child : human.getChildrens()){
            child.addParent(human);
        }
    }


    private void addToParents(Human human){
        Human mother = human.getMother();
        Human father = human.getFather();
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
        for(Human human : humanList){
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
        for(Human human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public Iterator<Human> iterator(){
        return new FamilyTreeIterator(humanList);
    }

    @Override
    public String toString() {return info();}

//    public void sortByFirstName(){
//        humanList.sort(new sortByFirstName());
//    }

    public void sortByFirstName(){
        Collections.sort(humanList);
    }

    public void sortByLastName(){
        humanList.sort(new sortByLastName());
    }

    public void sortByAge(){
        humanList.sort(new sortByAge());
    }

    public void sortByBornDate(){
        humanList.sort(new sortByBornDate());
    }

}
