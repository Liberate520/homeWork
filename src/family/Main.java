package family;

import family.human.Human;

import java.io.Serializable;
import java.util.Scanner;
import java.io.*;
public class Main implements Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree familyTolstoy = new FamilyTree();
        Scanner scn = new Scanner(System.in);
        int key = 0;
        String nameFather;
        String nameMather;
        String nameTemp;
        int i = 0;

        while (key != 4) {
            System.out.println(
                    " Введите:\n 0 - Вывести список членов семьи\n 1 - Добавить члена семьи\n 2 - Загрузить семью из файла\n 3 - Вывести детей члена семьи \n 4 - Выйти");
            key = scn.nextInt();
            switch (key) {
                case 0:
                    System.out.println(familyTolstoy.getInfo());
                    break;
                case 1:

                    System.out.println("Введите имя:");
                    nameTemp=scn.next();
                    System.out.println("Введите имя отца:");
                    nameFather = scn.next();
                    System.out.println("Введите имя матери:");
                    nameMather = scn.next();
                    familyTolstoy.addMember(new Human(nameTemp,familyTolstoy.getByName(nameFather),familyTolstoy.getByName(nameMather)));

                    System.out.println(familyTolstoy);
                    break;

                case 2:

                    familyTolstoy= FileHandler.LoadfromFile("person.out");
                    System.out.println(familyTolstoy);
                    break;

                case 3:
                    System.out.println("Введите имя Отца:");
                    nameFather = scn.next();
                    boolean found = false;
                    for (Human human : familyTolstoy) {
                        if (human.getName().equals(nameFather)) {
                            System.out.println("Дети отца " + nameFather + " :" + human.getChildrenInfo());
                            found = true;
                            break;
                        }
                        if (!(found)) {
                            System.out.println("Отец не найден");
                        }
                    }
                    break;
                case 4:
                    FileHandler.SaveInFile(familyTolstoy,"person.out");
                    scn.close();
                    break;
                default:
                    break;
            }

            familyTolstoy.sortByName();
            System.out.println("по имени:"+familyTolstoy);
            familyTolstoy.sortByChild();
            System.out.println("по количеству детей:"+familyTolstoy);

        }

    }
}

/*         Person member1 = new Person (1685, 1728, "ИванПетровичТолстой", Gender.Male,null, null);
        Person  member2 = new Person (1693, 1748, "ПрасковьяМихайловнаРтищева",
         Gender.Female, null, null);
         Person  member3 = new Person (1727, 1811, "АлександраИвановнаЩетинина",
         Gender.Female, member1, member2);
         Person  member4 = new Person (1721, 1803, "АндрейИвановичТолстой",
         Gender.Male, member1, member2);
         Person  member5 = new Person (1724, 1811, "НиколайИвановичГорчаков",
         Gender.Male, member1, member2);
         Person  member6 = new Person (1757, 1820, "ПрасковьяВасильевнаТолстая",
         Gender.Female, null, null);
         Person  member7 = new Person (1757, 1820, "ИльяАндреевичТолстой",
         Gender.Male, member4, null);
         Person  member8 = new Person (1757, 1820, "ПолагеяНиколаевнаГорчакова",
         Gender.Female, member5, null); */
//familyTolstoy.addAllMember(family);