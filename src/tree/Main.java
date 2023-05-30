package tree;

import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static tree.Gender.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
/*
        Human Sasha = new Human("Sasha", man);
        Human Masha = new Human("Masha", woman);
        Human Olga = new Human("Olga", woman, Sasha, Masha);
        Human Misha = new Human("Misha", man, Sasha, Masha);

        Human Oleg = new Human("Oleg", man);
        Human Natasha = new Human("Natasha", woman);
        Human Nikita = new Human("Nikita", man, Oleg, Natasha);
        Human Vika = new Human("Vika", woman, Oleg, Natasha);

        Human Roma = new Human("Roma", man, Nikita, Olga);
        Human Anna = new Human("Anna", woman, Misha, Vika);

        Human Zhora = new Human("Zhora", man, Roma, Anna);

        Human Alena = new Human("Alena", woman);


        FamilyTree Ivanovi = new FamilyTree("Ivanovi");
        List<Human> people = new ArrayList<>();
        people.addAll(Arrays.asList(Masha, Olga, Misha, Oleg, Natasha, Nikita, Vika, Roma, Anna, Zhora, Alena));

        Ivanovi.setFamily(people);
        System.out.println(Ivanovi);

        System.out.println("-------------Найти человека-------------");
        System.out.println(Ivanovi.findHuman("Masha"));
        System.out.println("Найти Alla ---> " + Ivanovi.findHuman("Alla"));
        System.out.println(Ivanovi.findHuman("Masha").getParent() + "\n" + Ivanovi.findHuman("Masha").getChild());
        System.out.println("------------Добавление Parents для Alena------------");
        System.out.println(Alena.getParent());
        Alena.addParent(Masha);
        Sasha.addChild(Alena);
        System.out.println(Alena.getParent());
        System.out.println(Masha.getChild());


        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("familytree.out"));
        objectOutputStream.writeObject(Ivanovi);

        objectOutputStream.close();
*/

        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("familytree.out"));
        FamilyTree IvanoviRestored = (FamilyTree) objectInputStream.readObject();

        objectInputStream.close();
        System.out.println(IvanoviRestored);
        System.out.println(IvanoviRestored.findHuman("Masha").getChild());





    }
}
