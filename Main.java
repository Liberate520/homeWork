
import java.io.Serializable;
import java.io.*;
import java.util.Scanner;

import person.Person;
public class Main implements Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree<Person> familyTolstoy = new FamilyTree<>();

        // Person member1 = new Person(1685, 1728, "КуницинАлексей", Gender.Male, null, null);

        // Person member2 = new Person(1693, 1748, "ЕвгаповаНадежда", Gender.Female, null, null);

        // Person member3 = new Person(1727, 1811, "ЕвгаповаНина", Gender.Male, member1, member2);

        // Person member4 = new Person(1721, 1803, "ЕвгаповаОлеся", Gender.Female, member1, member2);

        // Person member5 = new Person(1724, 1811, "ЕвгаповаАнастасия", Gender.Female, member1, member2);

        // Person member6 = new Person(1757, 1820,, "КуликовКонстантин", Gender.Male, member4, null);

        // Person member7 = new Person(1757, 1820, "КуликовИван", Gender.Male, member5, null);
        
        Scanner scn = new Scanner(System.in);
        Writable writable = new FileHandler();
        int key = 0;
        String nameFather;
        String nameMather;
        String nameTemp;
        int i = 0;

        while (key != 5) {
            System.out.println(
                    " Введите:\n 0 - Вывести список членов семьи\n 1 - Добавить члена семьи\n 2 - Загрузить семью из файла\n 3 - Вывести детей члена семьи\n 4 - Найти члена семьи по имени \n 5 - Выйти");
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
                    familyTolstoy.addMember(new Person(nameTemp,familyTolstoy.getByName(nameFather),familyTolstoy.getByName(nameMather)));

                    System.out.println(familyTolstoy);
                    break;

                case 2:

                    familyTolstoy= (FamilyTree) writable.load("family.txt");
                    System.out.println(familyTolstoy);
                    break;

                case 3:
                    System.out.println("Введите имя Отца:");
                    nameFather = scn.next();
                    boolean found = false;
                    for (Person person : familyTolstoy) {
                        if (person.getName().equals(nameFather)) {
                            System.out.println("Дети отца " + nameFather + " :" + person.getChildrenInfo());
                            found = true;
                            break;
                        }
                        if (!(found)) {
                            System.out.println("Отец не найден");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Введите искомое имя");
                    familyTolstoy.find(scn.next());
                    break;
                case 5:
                    writable.save(familyTolstoy,"family.txt");
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