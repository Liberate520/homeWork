package FamTree;

import Human.Human;
import Human.ComparatorName;
import Human.ComparatorAge;
import java.io.Serializable;
import java.util.*;

public class FamTree<E extends TreeMembers<E>> implements Serializable, Iterable<E> {

    private long humId;
    private List<E> humanList;

    public FamTree() {
        this(new ArrayList<>());
    }
    public FamTree(List<E> humanList) {
        this.humanList = humanList;
    }
   public void setId(long id){
        this.humId = id;

    }
    long getId(){
        return humId;
    }


    public boolean addHum(E human){
        if (human == null) {
            return false;
        }

        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humId++);
            addToPerents(human);
            addToChildren(human);
        }
        return true;
    }

    private void addToPerents(E human){
        E mother = human.getMother();
        E father = human.getFather();
        if(mother != null){
            mother.addChildren(human);
        }
        if(father != null){
            father.addChildren(human);
        }
    }

    private void addToChildren(E human){
        for (E child: human.getChildren()){
            addToPerents(human);
        }
    }
    public E getHumahById(long id){
        for (E human: humanList){
            if (human.getId() == id){
                return human;
            }
        }
    return null;
    }

    public List<E> getByFullName(String name, String soname){
        List<E> res = new ArrayList<>();
        for (E human: humanList) {
            if (human.getFirstName().equals(name) && human.getLastName().equals(soname)){
                res.add(human);

            }

        }
        return res;
    }
//    public List<E> getGrandFathers(E human) {
//        ArrayList<E> grandFathers;
//        grandFathers = new ArrayList<>();
//        if (human.getMother() != null) {
//            grandFathers.get(0) = human.getMother().getFather();
//        }
//        if(human.getFather() != null) {
//            grandFathers.get(1) = human.getFather().getFather();
//        }
//        return grandFathers;
//    }
//    public Human[] getGrandMothers(Human human) {
//        Human[] grandMothers = new Human[2];
//        if (human.getMother() != null) {
//            grandMothers[0] = human.getMother().getMother();
//        }
//        if(human.getFather() != null) {
//            grandMothers[1] = human.getFather().getMother();
//        }
//        return grandMothers;
//    }

    String getInfo(E human){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(humId);
        sb.append(" Name: ");
        sb.append(human.getFirstName());
        sb.append(" Famil: ");
        sb.append(human.getLastName());
        sb.append("Age: ");
        sb.append(human.getAge());
        sb.append(" Father: ");
        if (human.getFather()!= null) {

            sb.append(human.getFather().getFirstName());
        }
        else {
            sb.append(" n/a");
        }
        sb.append(" Mother: ");
        if (human.getMother()!= null) {

            sb.append(human.getMother().getFirstName());
        }
        else {
            sb.append(" n/a");
        }

        sb.append(human.getChildrenInf());
        return sb.toString();
    }
@Override
    public String toString(){
    return getTreeInf();
    }

    public String getTreeInf(){
        StringBuilder sb = new StringBuilder();
        sb.append("Family Try ");
        sb.append('\n');
        for (E human: humanList) {
            sb.append(human.getInfo());
            sb.append('\n');
        }
        return sb.toString();
    }

       public void sortName(){
        humanList.sort(new ComparatorName());

    }

    public void sortAge(){
        humanList.sort(new ComparatorAge());
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}

