package family_tree.tree;


import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.human.comparators.HumanComparatorByAge;
import family_tree.human.comparators.HumanComparatorByFathersName;
import family_tree.human.comparators.HumanComparatorByFirstName;
import family_tree.human.comparators.HumanComparatorBySecondName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree implements Serializable, Iterable<Human> {
    private int memberId;
    private String familyName;
    private List<Human> family;

    public Tree(String familyName) {
        this.family = new ArrayList<>();
        this.familyName = familyName;
    }

    public void addFamilyMember(Human member){
        if (!(member == null)
                && !family.contains(member)){
            family.add(member);
            member.setId(memberId++);
        }
    }

    public void wedding(Human husband, Human wife){
        if(husband.isMarried() || wife.isMarried()){
            System.out.println("Свадьба невозможна");
        }
        else {
            husband.setSpouse(wife);
            wife.setSpouse(husband);
        }
    }

    public void divorce(Human husband, Human wife){
        if (husband.getSpouse().equals(wife) && wife.getSpouse().equals(husband)) {
            husband.removeSpouse();
            wife.removeSpouse();
        }
        else System.out.println("Развод невозможен");
    }

    public void getSiblings(Human child)
    {
        List<Human> siblings = new ArrayList<>();
        for (Human parent : child.getParents().keySet()) {
            for (Human sibling : parent.getChildren().keySet()) {
                if(!child.equals(sibling)
                        && !siblings.contains(sibling)) siblings.add(sibling);
            }
        }
        for (Human sibling : siblings) {
            if(sibling.getGender().equals(Gender.female)) System.out.printf("%s - Сестра\n", sibling.getFullName());
            else if(sibling.getGender().equals(Gender.male)) System.out.printf("%s - Брат\n", sibling.getFullName());
        }
    }

    public String getFamilyName() {
        return familyName;
    }

    public void sortByFirstName() {family.sort(new HumanComparatorByFirstName());}
    public void sortBySecondName() {family.sort(new HumanComparatorBySecondName());}
    public void sortByFathersName() {family.sort(new HumanComparatorByFathersName());}

    public void sortByAge() {family.sort(new HumanComparatorByAge());}

    @Override
    public String toString() {
        return treeInfo();
    }
    public String treeInfo(){
        StringBuilder sb = new StringBuilder();
        for (Human member : this.family) {
            sb.append(member.getId()).append(". ").append(member.getFullName()).append("\n");
            sb.append(member.infoFormat());
            sb.append("______________________________").append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new TreeIterator(family);
    }
}
