package tree;

import comparers.ComparatorFamilyByBirthDay;
import comparers.ComparatorFamilyByChildrenAmount;
import comparers.ComparatorFamilyByName;
import filework.CapableOfPreserving;
import filework.CapableOfRestore;
import members.Member;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Family tree
 */
public class FamilyTree<T extends Member> implements Serializable, Iterable<T>{
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
    private Boolean contains(Member search) {
        for (Member member : family) {
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
        for (Member member : family) {
            builder.append(member);
            builder.append("\n");
        }
        return builder.toString();
    }

    /** сохранение */
    public void save(String path, CapableOfPreserving<FamilyTree<T>> preserve){
        preserve.save(path, this);
    }
    
    /** чтение */
    public FamilyTree<T> read(String path, CapableOfRestore<FamilyTree<T>> restore){
        return restore.read(path);
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator();       
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


    class FamilyTreeIterator implements Iterator<T>{
        private int index = 0;
            
        @Override
        public boolean hasNext(){
            return index < family.size() && family.get(index) != null;
        }
        
        @Override
        public T next() {
            return family.get(index++);
        }
    }
}


