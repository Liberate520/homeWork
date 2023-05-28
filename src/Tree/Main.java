package Tree;

public class Main {
    public static void main(String[] args) {

            Human Misha = new Human("Misha", "man");
            Human Olga = new Human("Olga", "woman");
            Human Masha = new Human("Masha", "woman");
            Human Sasha = new Human("Sasha", "man");
            Human Nikita = new Human("Nikita", "man", Sasha, Masha);
            Human Vika = new Human("Vika", "woman");
        System.out.println(Nikita);
        System.out.println("------------->");

        Nikita.AddChild(Misha);
        Nikita.AddChild(Olga);

        System.out.println(Nikita.GetParent());
        System.out.println(Misha.GetParent());

        System.out.println(Nikita.GetChild());
        System.out.println("------------->");
        Olga.AddParent(Vika);
        System.out.println(Olga);
        System.out.println(Olga.GetParent());

        Olga.AddParent(Misha);
        System.out.println(Olga.GetParent());
        System.out.println(Misha.GetChild());
        System.out.println(Nikita.GetChild());

        FamilyTree pipkins = new FamilyTree("Pipkins");

        pipkins.setFamily(Sasha, Masha, Nikita, Olga, Misha, Vika);

        System.out.println(pipkins);







    }
}
