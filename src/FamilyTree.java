import java.io.Serializable;
import java.util.ArrayList;
 import java.util.List;
 import java.util.Objects;

 public class FamilyTree implements Serializable {
     private List<Human> humans;

     public FamilyTree() {
         humans = new ArrayList<>();
     }

     public void addHuman(Human human) {
         humans.add(human);
         if (human.getMother() != null) {
             human.getMother().addChild(human);
         }
         if (human.getFather() != null) {
             human.getFather().addChild(human);
         }
     }

     public List<Human> getHumans() {
         return humans;
     }

     public List<Human> getParents(Human human) {
         List<Human> parents = new ArrayList<>();

         Human mother = human.getMother();
         if (mother != null) {
             parents.add(mother);
         }

         Human father = human.getFather();
         if (father != null) {
             parents.add(father);
         }

         return parents;
     }

     public List<Human> getSiblings(Human human) {
         List<Human> siblings = new ArrayList<>();
         List<Human> parents = getParents(human);
         for (Human parent : parents) {
             List<Human> parentSiblings = getChildren(parent);
             parentSiblings.remove(human);
             siblings.addAll(parentSiblings);
         }

         return siblings;
     }

     public List<Human> getChildren(Human human) {
         return human.getChildren();

     }

     public List<Human> getDescendants(Human human) {
         List<Human> descendants = new ArrayList<>();

         List<Human> children = getChildren(human);
         descendants.addAll(children);

         for (Human child : children) {
             descendants.addAll(getDescendants(child));
         }

         return descendants;
     }

     public List<Human> getAncestors(Human human) {
         List<Human> ancestors = new ArrayList<>();

         List<Human> parents = getParents(human);
         ancestors.addAll(parents);

         for (Human parent : parents) {
             ancestors.addAll(getAncestors(parent));
         }

         return ancestors;
     }

     @Override
     public boolean equals(Object o) {
         if (this == o)
             return true;
         if (o == null || getClass() != o.getClass())
             return false;
         FamilyTree that = (FamilyTree) o;
         return Objects.equals(humans, that.humans);
     }

     @Override
     public int hashCode() {
         return Objects.hash(humans);
     }

     @Override
     public String toString(){
         StringBuilder sb = new StringBuilder();
         sb.append("В дереве ");
         sb.append(humans);
         sb.append(" объектов: /n");
         for (Human human: humans){
             sb.append(humans.toString());           
         }
         return sb.toString();
     }
 }