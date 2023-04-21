import java.util.List;

public class Main {
    public static void main(String[] args) {

        Human me = new Human("Екатерина", "Хованская", Gender.Female, 19, 07,1985);
        Human myMom = new Human("Елена", "Якубюк", Gender.Female, 28, 12,1959);
        Human myDad = new Human("Константин", "Якубюк", Gender.Male, 17, 2,1961);
        // // System.out.println(me.getFullName());
        // // System.out.println(myDad.getGender());
        // me.setMother(myMom);
        // // System.out.println(me.getMother().toString());
        // // me.setMother(myDad);
        // me.setFather(myDad);
        // // System.out.println(me.getFather().toString());
        // myMom.addChild(me);
        // System.out.println(myMom.getChildren());
        // me.setBirthday(3, 6, 1990);
        // System.out.println(me.getBirthday());
        // me.setDethday(6, 10, 2090);
        // System.out.println(me.getDethday());
        Human myBrother = new Human("Евгений", "Якубюк", Gender.Male, 9, 8,1987);
        Human myBrother2 = new Human("Евгений", "Якубюк", Gender.Male, 9, 8,1987);
        // myDad.addChild(myBrother);
        // myDad.addChild(me);
        // System.out.println(myDad.getChildren());
        // System.out.println(myBrother.equals(myBrother2));
        // System.out.println(myBrother.equals(me));
        // FamilyTree myFamily = new FamilyTree(List.of(me, myMom, myDad, myBrother));
        // System.out.println(myFamily.getAllMembers());
        String path = "src/myFamily.txt";
        FileHandler fileHandler = new FileHandler();
        // fileHandler.save(myFamily, path);
        // FamilyTree myFamily = fileHandler.load(path);
        // System.out.println(myFamily.getAllMembers());
    }
}
