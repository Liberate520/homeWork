import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Family extends FamilyMember implements Serializable {
    private List<FamilyMember> family;
    public Family() {
        family = new ArrayList<>();
    }
    public void addFamilyMember(String status, Human human) {
        FamilyMember familyMember = setFamilyMember(status, human);
        family.add(familyMember);
    }
    public String getFamilyInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Состав семьи: " + "\n");
        stringBuilder.append(family);
//        for (FamilyMember familyMember: family) {  Здесь не понял как перебирать объекты добавленные в класс family?
//            stringBuilder.append(family);
//            stringBuilder.append("\n");
//        }
        return stringBuilder.toString();
    }
}