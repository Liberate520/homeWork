import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree  {
       private List<Human> humanList;

       public FamilyTree(){
        this(new ArrayList<>());
       }

        public FamilyTree(List<Human> humanList) {
            this.humanList = humanList;
        }

        public String getInfo(){
            StringBuilder sb = new StringBuilder();
            for (Human human: humanList){
                sb.append(human.toString());
                sb.append("/n");
            }
            return sb.toString();
        }
       
        }
    





