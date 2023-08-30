package FamilyTree;

import Human.GroupItem;
import Human.PersonComporatorByBirthDate;
import Human.PersonComporatorByName;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree<E extends GroupItem<E>> implements Serializable, Iterable<E> {
    private long personID;
    private List<E> personList;

    public Tree(List<E> personList) {this.personList = personList;}
    public Tree(){this(new ArrayList<>());}

    public List<E> getPersonList() {
        return personList;
    }

    public boolean add(E person){
        if (person == null){
            return false;
        }
        if (!personList.contains(person)){
            personList.add(person);
            person.setId(personID++);

            addToParent(person);
            addToChildren(person);

            return true;
        }
        return false;
    }

    private void addToParent(E person) {
        for (E parent: person.getParents()){
            parent.addChild(person);
        }
    }

    private void addToChildren(E person){
        for(E child: person.getChildren()){
            child.addParent(person);
        }
    }

    public List<E> getSiblings(int id) {
        E person = getById(id);
        if (person == null){
            return null;
        }
        List<E> res = new ArrayList<>();
        for (E parent: person.getParents()){
            for (E child: parent.getChildren()){
                if (!child.equals(person) && !res.contains(child)){
                    res.add((E) child);
                }
            }
        }
        return res;
    }

    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for (E person: personList){
            if (person.getName().equalsIgnoreCase(name)){
                res.add(person);
            }
        }
        return res;
    }

    public boolean setWedding(long personID1, long personID2){
        if(checkId(personID1) && checkId(personID2)){
            E per1 = getById(personID1);
            E per2 = getById(personID2);
            return setWedding(per1, per2);
        }
        return false;
    }

    public boolean setWedding(E per1, E per2){
        if(per1.getSpouse()==null && per2.getSpouse()==null){
            per1.setSpouse(per2);
            per2.setSpouse(per1);
            return true;
        }else{
            return false;
        }
    }

    public boolean setDivorce(long personID1, long personID2){
        if(checkId(personID1) && checkId(personID2)) {
            E per1 = getById(personID1);
            E per2 = getById(personID2);
            if (per1.getSpouse() != null && per2.getSpouse() != null) {
                per1.setSpouse(null);
                per2.setSpouse(null);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean remove(long personID){
        if(checkId(personID)){
            E human = getById(personID);
            return personList.remove(human);
        }
        return false;
    }

    private boolean checkId(long id){
        if (id > personID || id < 0){
            return false;
        }
        for (E person: personList) {
            if (person.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public E getById(long id){
        for (E per: personList){
            if (per.getId()==id){
                return per;
            }
        }
        return null;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Tree contains ");
        sb.append(personList.size());
        sb.append(" objects: \n");
        for (E per: personList){
            sb.append(per);
            sb.append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString(){
        return getInfo();
    }

    public void sortByName() {personList.sort(new PersonComporatorByName<E>());}

    public void sortByBirthDate() {personList.sort(new PersonComporatorByBirthDate<>());}

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator(personList);
    }
}
