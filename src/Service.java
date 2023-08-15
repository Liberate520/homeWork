import java.time.LocalDate;

public class Service {
    FamilyTree familyList;

    Service(){
        familyList= new FamilyTree();

    }

    void addFamily(String name, Gender gender, Human Father, Human Mather, String children, LocalDate birthday, LocalDate deathday){
        Human member = new Human(name, gender, Father, Mather, children, birthday, deathday);
        familyList.familyAdd(member);
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список семьи: \n");

        for (Human members : familyList) {
            stringBuilder.append(members);

        }
        return stringBuilder.toString();
    }






}
