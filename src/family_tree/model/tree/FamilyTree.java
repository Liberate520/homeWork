package family_tree.model.tree;

import family_tree.model.creatures.comparators.CreaturesComparatorByAge;
import family_tree.model.creatures.comparators.CreaturesComparatorByDateOfBirth;
import family_tree.model.creatures.comparators.CreaturesComparatorById;
import family_tree.model.creatures.interfaces.Creatures;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class FamilyTree<E extends Creatures> implements Serializable, Iterable<E>{
    private List<E> tree = new LinkedList<>();
    public void addCreature(E creature) {
       this.tree.add(creature);
    }
    public String addMother(int idCreature, int idMother){
        for (E creature: this.tree){
            if (creature.getId()==idCreature)
            {
                for (E mother: this.tree){
                    if (mother.getId()==idMother)
                    {
                      creature.setMother(mother);
                      return "Родственная связь обновлена.";
                    }
                }
            }
        }
        return "Вы ввели неверное значение!";
    }
    public String addFather(int idCreature, int idFather){
        for (E creature: this.tree){
            if (creature.getId()==idCreature)
            {
                for (E father: this.tree){
                    if (father.getId()==idFather)
                    {
                        creature.setFather(father);
                        return "Родственная связь обновлена.";
                    }
                }
            }
        }
        return "Вы ввели неверное значение!";
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (E creature: this.tree) {
            stringBuilder.append(this.tree.indexOf(creature)+1);
            stringBuilder.append(") ");
            stringBuilder.append(creature.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public String viewAllFamily (int id){
        for (E creature: this.tree){
            if (creature.getId()==id)
            {
                return creature.viewAllFamily();
            }
        }
        return "Вы ввели неверное значение!";
    }
    public void sortById(){
        Collections.sort(this.tree, new CreaturesComparatorById<>());
    }
    public void sortByDateOfBirth(){
      Collections.sort(this.tree, new CreaturesComparatorByDateOfBirth<>());
    }
    public void sortByDateOfAge(){
        Collections.sort(this.tree, new CreaturesComparatorByAge<>());
    }
    public int getLastId(){
        return tree.size();
    }
    public Iterator<E> iterator() {
        return new CreaturesIterator<>(this.tree);
    }
}
