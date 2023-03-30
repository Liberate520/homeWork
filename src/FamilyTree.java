import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> members;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> members) {
        this.members = members;
    }
    public  void  addMembers(Human member){
        this.members.add(member);
    }
    public void printMembers(){
        System.out.println("Members of Family");
        for (Human member: this.members
             ) {
            System.out.println(member.toString());

        }
    }
}
