package model;

import java.io.Serializable;

import java.util.ArrayList;

import java.util.List;

import model.familyTree.FamilyTreeIterator;
import model.familyTree.comparators.FamilyTreeComparatorByBirthDay;
import model.familyTree.comparators.FamilyTreeComparatorById;
import model.familyTree.comparators.FamilyTreeComparatorByName;
import model.human.Gender;
import model.human.Human;






public class FamilyTree <H extends Human> implements Serializable, FamilyTreeIterator<H> {
    private int id;
    private List<H> familyTree;

    public FamilyTree() {
        this.familyTree = new ArrayList<H>();
    }

    List<H> getFamilyTree(){
        return familyTree;
    }

    void sortByParameter(int sortNumber){
        switch (sortNumber){
            case 1: sortByName();
            System.out.println("Отсортировано по имени");
            break;
            case 2: sortBirthDay();
            System.out.println("По году рождения");
            break;
            case 3: sortById();
            System.out.println("Отсортировано по Id");
            break;
        default:
        System.out.println("Некорректный номер сортировки"); 
        }
    }
    void addHuman(H human){
        familyTree.add(human);
        if (human.getMother() != null){
            human.getMother().addChild(human);
        }
        if (human.getFather() != null){
            human.getFather().addChild(human);
        }
    }

    Human getHumanById(int id) {
        for (Human human: familyTree){
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    Human getHumanByName(String name){
        String nameFull = name.replace(","," ");
        for (Human human: familyTree){
            if (human.getFulName().equals(nameFull)){
                return human;
            }
        }
        return null;
    }

    Gender getGender(String gender){
        if (gender.equals("м")){
            return Gender.Male;
        } else if (gender.equals("ж")){
            return Gender.Female;
        }
        return null;
            
    }

     
    int getLastId() {
        if (familyTree == null){
            return -1;
        }
        return familyTree.size() - 1;
    }

    
   public int getId(){
    return id;
   }

   public int getBirthDate(){
    return getBirthDate();
   }

     
    void sortBirthDay(){
        familyTree.sort(new FamilyTreeComparatorByBirthDay<>());
    }

    void sortByName(){
        familyTree.sort(new FamilyTreeComparatorByName<>());
    }

    void sortById(){
        familyTree.sort(new FamilyTreeComparatorById<>());
    }

    @Override
    public boolean hasNext(){
        return this.id<familyTree.size();
    }

    @Override
    public H next(){
        return this.familyTree.get(id++);
    }
    
    
}
