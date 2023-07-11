package familyTree;


 import java.io.Serializable;
 import java.util.ArrayList;
 import java.util.List;

 public class FamilyTree implements Serializable
 {
     private static List<Human> familyTree;

     public FamilyTree() 
     {
         familyTree = new ArrayList<>();
     }

     public static void addFamilyTree(Human human)
     {
         familyTree.add(human);
     }

     @Override
     public String toString() 
     {
         String res = "В семье " + familyTree.size() + " человек:\n";
         for (int i = 0; i < familyTree.size(); i++) 
         {
             res += (i+1) + ") " + familyTree.get(i).toString() + "\n";
         }
         return res;
     }

     public static List<Human> getfamilyTree() 
     {
         return familyTree;
     }

 } 