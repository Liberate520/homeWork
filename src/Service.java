import FamTree.FamTree;
import Human.Human;
import Human.Gender;
import java.io.Serializable;
import Human.HumanBuilder;
public class Service implements Serializable {
    private HumanBuilder humanbuilder;
    private FamTree famtree;

    public Service(){
        humanbuilder = new HumanBuilder();
        famtree = new FamTree();
    }
    public void addHuman(String firstName, String lastName, Gender sex, int age){
        Human human;
                human = humanbuilder.createHuman(firstName, lastName, sex, age);
                famtree.addHum(human);
    }
    public String getHumanListInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Family tree \n");
        for (Object human : famtree){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
    public void sortName(){
        famtree.sortName();
    }
    public void sortAge(){
        famtree.sortAge();
    }
}
