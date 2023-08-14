package FamilyTree.Tree.model.HumanGroup.Human;

import FamilyTree.Tree.model.HumanGroup.HumanGroup;
import FamilyTree.Tree.model.HumanGroup.HumanGroupItem;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human <E extends Human> implements Serializable, HumanGroupItem {
    private List<E> children = new ArrayList<>();


    private String name;
    private String patronymic;
    private LocalDate dateOfBirth;
    private Gender gender;
    private E mother;
    private E father;
    private List<E> parents;
    private List<E> childrens = new ArrayList<E>();



    public Human(String name, String patronymic, Gender gender, LocalDate dateOfBirth, E father, E mother) {

        this.name = name;
        this.patronymic = patronymic;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }
    }


    public boolean addParent(E parent) {
        if (!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
    }

    public E getFather(Human<E> father){
        for (E parent: parents){
            if (parent.getGender() == Gender.Male){
                return parent;
            }
        }
        return null;
    }

    public E getMother(Human<E> mother){
        for (E parent: parents){
            if (parent.getGender() == Gender.Female){
                return parent;
            }
        }
        return null;
    }
    public void setMother(E humanGroup){
        if(mother==null || !mother.equals(humanGroup)) {
            this.mother = humanGroup;
            humanGroup.addChildren(this);
            HumanGroup.addHuman(humanGroup);
        }

    }
    public void setFather(E humanGroup){
        if(father==null || !father.equals(humanGroup)){
            this.father = humanGroup;
            humanGroup.addChildren(this);
            HumanGroup.addHuman(humanGroup);
        }

    }



    public void addChildren(E E){
        if(!childrens.contains(E)){
            this.childrens.add(E);
            if (gender.equals("Женский")){
                E.getMother(this);
            }
            if (gender.equals("Мужской")){
                E.getFather(this);
            }
            HumanGroup.addHuman(E);
        }


    }


    public String getName() {
        return name;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public String getPatronymic(){
        return patronymic;
    }

    @Override
    public Comparable<Object> readSave() {
        return null;
    }


    public Gender getGender() {
        return gender;
    }



    @Override
    public String toString() {
        return getInfo();

    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(" ");
        sb.append(getPatronymic());
        sb.append("; ");
        sb.append(getDateOfBirth());
        sb.append("; ");
        sb.append(getGender());
        return sb.toString();
    }

}
