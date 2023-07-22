package family_tree.tree;


import family_tree.human.Gender;
import family_tree.human.comparators.HumanComparatorByAge;
import family_tree.human.comparators.HumanComparatorByFathersName;
import family_tree.human.comparators.HumanComparatorByFirstName;
import family_tree.human.comparators.HumanComparatorBySecondName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree<E extends Entity<E>> implements Serializable, Iterable<E> {
    private int memberId;
    private String familyName;
    private List<E> family;

    public Tree(String familyName) {
        this.family = new ArrayList<>();
        this.familyName = familyName;
    }

    public void addFamilyMember(E member){
        if (!(member == null)
                && !family.contains(member)){
            family.add(member);
            member.setId(memberId++);
        }
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
            if(sibling.getGender().equals(Gender.female)) System.out.printf("%s - Сестра\n", sibling.getFullName());
            else if(sibling.getGender().equals(Gender.male)) System.out.printf("%s - Брат\n", sibling.getFullName());
        }
    }

    public String getFamilyName() {
        return familyName;
    }

    public void sortByFirstName() {family.sort(new HumanComparatorByFirstName<E>());}
    public void sortBySecondName() {family.sort(new HumanComparatorBySecondName<E>());}
    public void sortByFathersName() {family.sort(new HumanComparatorByFathersName<E>());}

    public void sortByAge() {family.sort(new HumanComparatorByAge<E>());}

    @Override
    public String toString() {
        return treeInfo();
    }
    public String treeInfo(){
        StringBuilder sb = new StringBuilder();
        for (E member : this.family) {
            sb.append(member.getId()).append(". ").append(member.getFullName()).append("\n");
            sb.append(member);
            sb.append("______________________________").append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator(family);
    }
}
