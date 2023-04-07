
import java.util.ArrayList;
import java.util.List;
import java.lang.*;

public class FamilyTree {

   
   String name;
   private List<Human> humanList;

   public FamilyTree(String name, List<Human> humantList){
      this.name = name;
      this.humanList = humantList;
   }

   public FamilyTree(List<Human> humanList){
      this ("FamilyTree", humanList);
   }

   public FamilyTree(){
     this(new ArrayList<>());

   }

   public void addHuman(Human human){
      humanList.add(human);
   }
    
}
