package model;
import java.util.Comparator;

 public class ChildrenComparatorByAge<T extends FamalyTreeItem> implements Comparator<T> {

     @Override
     public int compare(T o1, T o2) {
         return Integer.compare(o1.getAge(), o2.getAge());
     }
 }