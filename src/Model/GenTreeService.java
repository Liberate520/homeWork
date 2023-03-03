package Model;

import java.io.Serializable;
import java.util.Collections;

import Model.GenealogicalTree.GenealogicalTree;
import Model.GenealogicalTree.Human;
import Model.GenealogicalTree.Sex;
import Model.GenealogicalTree.Comporator.IndividualComporatorByAge;

public class GenTreeService implements Serializable {
    private GenealogicalTree<Human> genealogicalTree;
    private static int idIndividual;

    public GenTreeService(GenealogicalTree<Human> genealogicalTree) {
        this.genealogicalTree = genealogicalTree;
        idIndividual = 0;
    }
    
    public void addHuman(String name, Sex sex, int birthYear){
        Human individual = new Human(idIndividual++, name, sex, birthYear);
        genealogicalTree.addIndividual(individual);
    }

    public void addHuman(String name, Sex sex, int birthYear,
        Human father, Human mother){
        Human individual = new Human(idIndividual++, name, sex, birthYear, 
            father, mother);
        genealogicalTree.addIndividual(individual);
    } 
    
    public void sortByName() { 
        Collections.sort(genealogicalTree.getAllListTree());
    }

    public void sortByAge() {
        Collections.sort(genealogicalTree.getAllListTree(), 
            new IndividualComporatorByAge<Human>());        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Human human : genealogicalTree) {
            sb.append(human.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String search(String nameSearch) {
        return genealogicalTree.searchForName(nameSearch);
    }

    public Human searchGetHuman (String nameSearch) {
        return genealogicalTree.searchGetHuman(nameSearch);
    }

    public void getMarried(Human o1, Human o2) {
        genealogicalTree.getMarried(o1, o2);
    }
}
