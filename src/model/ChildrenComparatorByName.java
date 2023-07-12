package model;
import java.util.Comparator;

 public class ChildrenComparatorByName<T extends FamalyTreeItem> implements Comparator<T> {

     @Override
     public int compare(T o1, T o2) {
         return o1.getFirstName().compareTo(o2.getFirstName());
     }
 }