import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FamilyTree {
   private List<Human> family;

   public FamilyTree() {
      family = new ArrayList<>();
   }

   public void addMember(Human human) {
      family.add(human);
   }

   public List<Human> getPeopleList() {
      return family;
   }

   public List<Human> getChildren(Human human) {
      return human.getChildren();
   }

   public Human getFather(Human human) {
      return human.getFather();
   }

   public Human getMother(Human human) {
      return human.getMother();
   }

   public List<Human> getDescendants(Human Human) {
      List<Human> descendants = new ArrayList<>();
      for (Human child : Human.getChildren()) {
         descendants.add(child);
         descendants.addAll(getDescendants(child));
      }
      return descendants;
   }

   public List<Human> getAncestors(Human Human) {
      List<Human> ancestors = new ArrayList<>();
      ancestors.add(Human.getFather());
      ancestors.add(Human.getMother());
      return ancestors;
   }

   public List<Human> getRelatives(Human Human) {
      List<Human> relatives = new ArrayList<>();
      relatives.addAll(getAncestors(Human));
      relatives.addAll(getDescendants(Human));
      return relatives;
   }

   public List<Human> searchByName(String name) {
      List<Human> result = new ArrayList<>();
      for (Human Human : family) {
         if (Human.toString().contains(name)) {
            result.add(Human);
         }
      }
      return result;
   }
}
