import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private int id;
    private String family;
    private List<Human> membersList;
    int memberId = 1;


    public FamilyTree(String family) {
        this.family = family;
        membersList = new ArrayList<>();
    }

    public void addMembers(Human human) {
        human.setId(memberId++);
        membersList.add(human);
    }

    public String getFamilyInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список родословной:\n");
        for (Human human: membersList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}

