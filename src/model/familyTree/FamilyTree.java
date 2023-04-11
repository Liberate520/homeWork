package model.familyTree;


import model.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FamilyTree <E extends Human> implements Iterable<E>, Serializable {

    public  Object tree;
    public List<E> humanList;

   
    public FamilyTree(List<E> humanList) {
        this.humanList =humanList;
    }
    public FamilyTree(){
        this(new ArrayList<>());
    }
    public FamilyTree(Object tree){
        this.tree=tree;
    }
    

    // метод проверки наличия человека в листе и при его отсутствии добавление
    // человека

    public boolean addNewHuman(E human, List<Human> list) {

        if (human == null) {

            return false;

        }
        if (!humanList.contains(human)) {

            humanList.add((E) human);
            
            if (human.getFather() != null) {

                human.getFather().addChildren(human);
            }
            if (human.getMother() != null) {
                human.getMother().addChildren(human);
            }
            return true;
        }
        return false;
    }

    public E getByName(Object mother) {
        for (E human : humanList) {
            if (((E) human).getName().equals(mother)) {
                return (E) human;
            }
        }
        return null;
    }

    public E getByFamily(String fam) {
        for (E human : humanList) {
            if (((E) human).getFamily().equals(fam)) {
                return (E) human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder infoRes = new StringBuilder();
        infoRes.append("В дереве \n");
        infoRes.append(humanList.size() + " ");
        infoRes.append("объекта(ов)\n");
        for (E human : humanList) {
            infoRes.append(((E) human).getInfo());
        }

        return infoRes.toString();

    }
    
   
    

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator(humanList);
    }

    
       
    public List<E> getHumanList() {
        return (List<E>) humanList;
    }

        


}