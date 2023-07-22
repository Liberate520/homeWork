package family_tree.model.tree;


import family_tree.model.human.Gender;
import family_tree.model.human.comparators.HumanComparatorByAge;
import family_tree.model.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree<E extends Entity<E>> implements Serializable, Iterable<E> {
    private int memberId;
    private List<E> family;

    public Tree() {
        this.family = new ArrayList<>();
    }

    public void addFamilyMember(E member){
        if (!(member == null)
                && !family.contains(member)){
            family.add(member);
            member.setId(memberId++);
        }
    }
    public E getFamilyMember(int id){
        return family.get(id);
    }

    public int getFamilySize(){
        return family.size();
    }
    public void clearFamily(){
        family.clear();
    }

    public void wedding(E husband, E wife){
        if(husband.isMarried() || wife.isMarried()){
            System.out.println("Свадьба невозможна");
        }
        else {
            husband.setSpouse(wife);
            wife.setSpouse(husband);
        }
    }

    public void divorce(E husband, E wife){
        if (husband.getSpouse().equals(wife) && wife.getSpouse().equals(husband)) {
            husband.removeSpouse();
            wife.removeSpouse();
        }
        else System.out.println("Развод невозможен");
    }

    public void getSiblings(E child)
    {
        List<E> siblings = new ArrayList<>();
        for (E parent : child.getParents().keySet()) {
            for (E sibling : parent.getChildren().keySet()) {
                if(!child.equals(sibling)
                        && !siblings.contains(sibling)) siblings.add(sibling);
            }
        }
        for (E sibling : siblings) {
            if(sibling.getGender().equals(Gender.female)) System.out.printf("%s - Сестра\n", sibling.getName());
            else if(sibling.getGender().equals(Gender.male)) System.out.printf("%s - Брат\n", sibling.getName());
        }
    }

    public void sortByName() {family.sort(new HumanComparatorByName<E>());}

    public void sortByAge() {family.sort(new HumanComparatorByAge<E>());}
    @Override
    public Iterator<E> iterator() {
        return new TreeIterator(family);
    }
}
