import java.time.LocalDate;

public class Service {
    FamilyTree<Human> familyList;

    Service(){
        familyList= new FamilyTree();

    }

    void addFamily(String name, Gender gender, Human Father, Human Mather, Human children, LocalDate birthday, LocalDate deathday){
        Human member = new Human(name, gender, Father, Mather, children, birthday, deathday);
        familyList.familyAdd(member);
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список семьи: \n");

        for (Object members : familyList) {
            stringBuilder.append(members);

        }
        return stringBuilder.toString();
    }

    public  void sortByName(){
        familyList.sortByName();
    }

    public  void sortByAge(){
        familyList.sortByAge();
    }






}
