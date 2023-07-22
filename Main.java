import javax.management.StringValueExp;

// Main class Main
public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Ivan", Sex.Male, "08.11.1970");
        Human human2 = new Human("Maria", Sex.Female, "27.06.1975");
        Human human3 = new Human("Stepan", Sex.Male, "03.10.1996");
        Human human4 = new Human("Katya", Sex.Female, "30.12.1998");
        Human human5 = new Human("Lena", Sex.Female, "12.03.1998");
        Human human6 = new Human("Galina", Sex.Female, "17.09.1996");
        Human human7 = new Human("Dasha", Sex.Female, "24.07.2020");

        Family family1 = new Family();
        family1.father(human1);
        family1.mother(human2);
        family1.son(human3);
        family1.daughter(human4);

        Family family2 = new Family();
        family2.father(human3);
        family2.mother(human6);
        family2.daughter(human7);

        System.out.println(human5.getName() + " - " + human5.getSex() + ", DOB - " + human5.getDob());
        System.out.println(human7.getName() + " - " + human7.getSex() + ", DOB - " + human7.getDob());
        System.out.println(family2.daughter.getSex());

//        System.out.println(var);
        
    }
//    public String getFamilyMembers(Family family) {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Family members: \n");
//        for (family) {
//            stringBuilder.append(family);
//            stringBuilder.append("\n");
//        }
//    }
}
