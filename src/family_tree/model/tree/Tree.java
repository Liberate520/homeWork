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

    public boolean wedding(E husband, E wife){
        if(husband.isMarried() || wife.isMarried()){
            return false;
        }
        else {
            husband.setSpouse(wife);
            wife.setSpouse(husband);
            return true;
        }
    }

    public boolean divorce(E husband, E wife){
        if (!husband.isMarried() || !wife.isMarried()) return false;
        else if (husband.getSpouse().equals(wife) && wife.getSpouse().equals(husband)) {
            husband.removeSpouse();
            wife.removeSpouse();
            return true;
        }
        return false;
    }

    public String getSiblings(E child)
    {
        StringBuilder stringBuilder = new StringBuilder();
        List<E> siblings = new ArrayList<>();
        for (E parent : child.getParents().keySet()) {
            for (E sibling : parent.getChildren().keySet()) {
                if(!child.equals(sibling)
                        && !siblings.contains(sibling)) siblings.add(sibling);
            }
        }
        for (E sibling : siblings) {
            if(sibling.getGender().equals(Gender.female)){
                stringBuilder.append(sibling.getName());
                stringBuilder.append(" - ");
                stringBuilder.append("Сестра");
            }
            else if(sibling.getGender().equals(Gender.male)){
                stringBuilder.append(sibling.getName());
                stringBuilder.append(" - ");
                stringBuilder.append("Брат");
            }
        }
        return stringBuilder.toString();
    }

    public void sortByName() {family.sort(new HumanComparatorByName<E>());}

    public void sortByAge() {family.sort(new HumanComparatorByAge<E>());}
    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<>(family);
    }
}
