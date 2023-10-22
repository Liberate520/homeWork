package model.familyTree.comparators;

import java.util.Comparator;

import model.human.Human;

public class FamilyTreeComparatorById<H> implements Comparator<Human> {
   @Override
   public int compare(Human human_1, Human human_2){
      return human_1.getId() - human_2.getId();
   }
   
}
