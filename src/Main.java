import java.util.List;

public class Main {
    public static void main(String[] args) {
        Family family = new Family();

        Human granA = new Human("Ekaterina", "female", 80, null, null);
        Human dadA = new Human("Ivan", "male", 53, null,granA);
        Human granB = new Human("Mikhail", "male", 61, null,null);
        Human granC = new Human("Anastasia", "female", 49, null,null);
        Human momA = new Human("Julia", "female", 29, granB,granC);
        Human momB = new Human("Vika", "female", 35, granB,null);
        Human momD = new Human("Maria", "female", 56, null,null);
        Human sonA = new Human("Petr", "male", 30, dadA,momD);
        Human granson1 = new Human("Daria", "female", 2, sonA,momA);
        Human granson2 = new Human("Vasia", "male", 5, sonA,momA);
        Human granson3 = new Human("Jurii", "male", 8, sonA,momA);
        family.add(granA);
        family.add(dadA);
        family.add(granB);
        family.add(granC);
        family.add(momA);
        family.add(momB);
        family.add(momD);
        family.add(sonA);
        family.add(granson2);
        family.add(granson3);
        family.add(granson1);

        System.out.println(family);

        System.out.println(family.search("Ivan"));

        List<String> broAndSis = family.getBroAndSis("Vasia");
        System.out.println(broAndSis);
        List<String> broAndSis2 = family.getBroAndSis("Julia");
        System.out.println(broAndSis2);
        List<String> broAndSis3 = family.getBroAndSis("Ivan");
        System.out.println(broAndSis3);


    }
}
