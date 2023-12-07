package ru.home_work.cherevichenko_sergey.model_family_tree.human_builder.familyTree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E extends FamilyTreeItem> implements  Iterator<E> {
   private int index = 0;
   private List<E> humans;
   public HumanIterator(List<E> humans){
       this.humans = humans;
   }
    @Override
    public boolean hasNext() {
        return index < humans.size();
    }
    @Override
    public E next() {
       return  humans.get(index++);
    }
@Override
    public void remove(){
       humans.remove(humans.get(index-1));
}
}
