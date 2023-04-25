import java.util.List;

public class Main {
    public static void main(String[] args) {

        Human me = new Human("Екатерина", "Хованская", Gender.Female, 19, 07,1985);
        Human myMom = new Human("Елена", "Якубюк", Gender.Female, 28, 12,1959);
        Human myDad = new Human("Константин", "Якубюк", Gender.Male, 17, 2,1961);
        Human myBrother = new Human("Евгений", "Якубюк", Gender.Male, 9, 8,1987);
        Human myBrother2 = new Human("Евгений", "Якубюк", Gender.Male, 9, 8,1987);
        String path = "src/myFamily.txt";
        FileHandler fileHandler = new FileHandler();
        // fileHandler.save(myFamily, path);
        // FamilyTree myFamily = fileHandler.load(path);
        FamilyTree myFamily = new FamilyTree();
        myFamily.addMember(myMom, null, null);
        myFamily.addMember(myDad, null, null);
        myFamily.addMember(me, myMom, myDad);

        // for(Human human:myFamily){
        //     System.out.println(human.toString());
        // }
        System.out.println(myFamily.getAllMembers());
        myFamily.sortByName();
        System.out.println(myFamily.getAllMembers());
        myFamily.sortByAge();
        System.out.println(myFamily.getAllMembers());
    }
}
