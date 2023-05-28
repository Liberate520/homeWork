package Tree;

public class Main {
    public static void main(String[] args) {

        Human Sasha = new Human("Sasha", "man");
        Human Masha = new Human("Masha", "woman");
        Human Olga = new Human("Olga", "woman", Sasha, Masha);
        Human Misha = new Human("Misha", "man", Sasha, Masha);

        Human Oleg = new Human("Oleg", "man");
        Human Natasha = new Human("Natasha", "woman");
        Human Nikita = new Human("Nikita", "man", Oleg, Natasha);
        Human Vika = new Human("Vika", "woman", Oleg, Natasha);

        Human Roma = new Human("Roma", "man", Nikita, Olga);
        Human Anna = new Human("Anna", "woman", Misha, Vika);

        Human Zhora = new Human("Zhora", "man", Roma, Anna);

        Human Alena = new Human("Alena", "woman");


        FamilyTree Ivanovi = new FamilyTree("Ivanovi");
        Ivanovi.setFamily(Sasha, Masha, Olga, Misha, Oleg, Natasha, Nikita, Vika, Roma, Anna, Zhora);

        System.out.println(Sasha);
        System.out.println(Sasha.GetParent());
        System.out.println(Sasha.GetChild());
        System.out.println("--------------");
        System.out.println(Alena.GetParent());
        System.out.println(Alena.GetChild());
        System.out.println("--------------Добавление родителей для Alena-------------");
        Sasha.AddChild(Alena);
        Alena.AddParent(Masha);
        System.out.println(Alena.GetParent());
        System.out.println(Sasha.GetChild());
        System.out.println("--------------");
        Ivanovi.setFamily(Alena);
        System.out.println(Ivanovi);
    }
}
