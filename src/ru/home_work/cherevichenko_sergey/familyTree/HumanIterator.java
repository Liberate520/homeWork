package ru.home_work.cherevichenko_sergey.familyTree;

import ru.home_work.cherevichenko_sergey.FamilyTreeItem;
import ru.home_work.cherevichenko_sergey.familyTree.FamilyTree;
import ru.home_work.cherevichenko_sergey.human.Human;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

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
       humans.remove(humans.get(index));
}
}
