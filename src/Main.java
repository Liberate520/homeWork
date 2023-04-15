import java.util.List;

public class Main {
    public static void main(String[] args) {

        FamilyTree Romanovs = new FamilyTree();
        Human Nikolai_II = new Human("Nikolai_II", 18,5,1868, Gender.Male);
        Human Aleksandra = new Human("Aleksandra Fedorovna", 11, 2, 1899, Gender.Female,
                Nikolai_II);
        Romanovs.addMember(Nikolai_II);
        Romanovs.addMember(Aleksandra);
        Human Olga = new Human("Olga", 15,11,1895, Gender.Female, Nikolai_II, Aleksandra);
        Human Aleksei = new Human("Aleksei", 12,8,1904, Gender.Male, Nikolai_II, Aleksandra);
        Human Maria = new Human("Maria", 26,6,1899, Gender.Female, Nikolai_II, Aleksandra);
        Human Tatyana = new Human("Tatyana", 10,6,1897, Gender.Female, Nikolai_II, Aleksandra);
        Human Anastasia = new Human("Anastasia", 18,6,1901, Gender.Female, Nikolai_II,
                Aleksandra);
        Nikolai_II.setChildren(Olga);
        Nikolai_II.setChildren(Aleksei);
        Nikolai_II.setChildren(Maria);
        Nikolai_II.setChildren(Tatyana);
        Nikolai_II.setChildren(Anastasia);
        Aleksandra.setChildren(Olga);
        Aleksandra.setChildren(Aleksei);
        Aleksandra.setChildren(Maria);
        Aleksandra.setChildren(Tatyana);
        Aleksandra.setChildren(Anastasia);
        Aleksei.setFather(Nikolai_II);
        Aleksei.setMother(Aleksandra);
        Olga.setFather(Nikolai_II);
        Olga.setMother(Aleksandra);
        Maria.setFather(Nikolai_II);
        Maria.setMother(Aleksandra);
        Tatyana.setFather(Nikolai_II);
        Tatyana.setMother(Aleksandra);
        Anastasia.setFather(Nikolai_II);
        Anastasia.setMother(Aleksandra);
        Nikolai_II.setIn_marriage_with(Aleksandra);
        Aleksandra.setIn_marriage_with(Nikolai_II);
        System.out.println(Nikolai_II);
        List<Human> children = Romanovs.getChildren(Aleksandra);
        System.out.println("мать: " + Aleksandra);
        for (Human child : children) {
            System.out.println("\tдети: " + child.toString());
        }

        List<Human> childList = Romanovs.getChildren(Nikolai_II);

        for (Human child : childList) {
            System.out.println(child.toString());
        }

        List<Human> descendants = Romanovs.getDescendants(Aleksandra);

        for (Human descendant : descendants) {
            System.out.println();
            System.out.println(descendant.toString());

        }

        List<Human> relatives = Romanovs.getRelatives(Aleksei);

        for (Human relative : relatives) {

            System.out.println(relative.toString());

        }

        List<Human> searchResult = Romanovs.searchByName("Ольга");


        for (Human human : searchResult) {
            System.out.println();
            System.out.println(human.toString());
        }
    }
    }
