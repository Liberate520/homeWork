package familytree.model.family_tree;

import java.io.Serializable;

/*
 * 
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import familytree.model.human.comporatop.HumanComporatorByBirthDate;
import familytree.model.human.comporatop.HumanComporatorBySurname;

public class FamilyTree<P extends FamilyTreeItem<P>> implements Serializable, Iterable<P> {
    private List<P> ListHumans;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<P> ListHuman) {
        this.ListHumans = ListHuman;
    }

    


    public void add (P human){
        if (!ListHumans.contains(human)){
            ListHumans.add(human);
            addParents(human);
            addChildren(human);
            addToSpouse(human);

        }

    }

   
    // public void printFamilyTree() {
    //     printFamilyTree(ListHumans);
    // }

    private void addParents (P human){
        for (P parent : human.getParents()) {
            parent.addChild(human);
           
        }

    }

    private void addChildren(P human){
        for (P child : human.getChildren()) {
            child.addParent(human);          
        }
    }

    private void addToSpouse(P human){
        if (human.getSpouse()!= null){
            human.addSpouse(human.getSpouse());
        }       
    }


    public String getInfo(){
        StringBuilder info = new StringBuilder();
        info.append("В дереве " + ListHumans.size() + " людей\n");
        for (P human : ListHumans) {
            info.append( human +"\n");           
        }
        return info.toString();
    }

    public void  getByName(String name){
        List <P> findlist = new ArrayList<>();
        for (P human : ListHumans) {
            if(human.getName().equals(name)){
                findlist.add(human);                
            }   
        }

        for (P human : findlist) {
            System.out.println(human);          
        }       
    }

    
    
    public List<P> getListHumans() {
        return this.ListHumans;
    }

    @Override
    public Iterator <P> iterator(){
        return new HumanIterator<>(ListHumans);
    }

    public void sortBySurname(){

        ListHumans.sort(new HumanComporatorBySurname<>());
    }

    public void sortByBirthDate(){
        ListHumans.sort(new HumanComporatorByBirthDate<>());

    }



    // private void printFamilyTree(Human person, int level) {
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < level; i++) {
    //         sb.append("  ");
    //     }
    //     sb.append("- ");
    //     sb.append(person.getName());
    //     System.out.println(sb.toString());

    //     List<Human> children = person.getChildren();
    //     for (Human child : children) {
    //         printFamilyTree(child, level + 1);
    //     }
    // }

}