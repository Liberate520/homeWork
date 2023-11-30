package ru.home_work.cherevichenko_sergey.familyTree;

import ru.home_work.cherevichenko_sergey.familyTree.FamilyTree;
import ru.home_work.cherevichenko_sergey.human.Human;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class HumanIterator implements  Iterator<Human> {
   private int index = 0;
   private List<Human> humans;
   public HumanIterator(List<Human> humans){
       this.humans = humans;
   }
    @Override
    public boolean hasNext() {
        return index < humans.size();
    }
    @Override
    public Human next() {
       return humans.get(index++);
    }
@Override
    public void remove(){
       humans.remove(humans.get(index));
}
}
