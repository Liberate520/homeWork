package model.famailyTree.comparators;



import java.util.Comparator;

import model.famailyTree.TreeNode;


public class FamilyTreeComparatorByBirthDay <T extends TreeNode> implements Comparator <T>{
   public int compare(T o1, T o2) { return o1.getBirthDate().compareTo(o2.getBirthDate());}
}
