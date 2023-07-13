package familyTree;
 public class Main {
     public static void main(String[] args) {
         FamilyTree<Human> familyTree = new FamilyTree<>();
         familyTree.addFamilyTree(new Human("Алекс", "муж", 27));
         familyTree.addFamilyTree(new Human("Владимир Владимирович Путин", "муж", 70));
         familyTree.getByName("алекс");

     }
 }
