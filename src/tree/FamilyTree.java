package tree;

import comparers.ComparatorFamilyByBirthDay;
import comparers.ComparatorFamilyByChildrenAmount;
import comparers.ComparatorFamilyByName;
import members.FamilyMember;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Family tree
 */
public class FamilyTree<T extends FamilyMember> implements Serializable, Iterable<T>{
    private List<T> family;

    public FamilyTree() {
        family = new ArrayList<>();
    }

    /** added new member */
    public void addNewMember(T member) {
        if(!contains(member)){
            family.add(member);
            if(member.getFather() != null){
                member.getFather().addChild(member);
            }
            if(member.getMother() != null){
                member.getMother().addChild(member);
            }
        }
    }

    /** checked contains member in family list */
    private Boolean contains(T search) {
        for (T member : family) {
            if (member.equals(search)) {
                return true;
            }
        }
        return false;
    }

    /** representation */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T member : family) {
            builder.append(member);
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<T>(family);       
    }

    /** сортировка по имени*/
    public void sortByName() {
        family.sort(new ComparatorFamilyByName<>());
    }

    /** сортировка дню рождения*/
     public void sortByBirthday() {
        family.sort(new ComparatorFamilyByBirthDay<>());
    }

    /** сортировка по количеству детей*/
     public void sortByChildrenAmount() {
       family.sort(new ComparatorFamilyByChildrenAmount<>());
    }
}