import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args)
    {
        FamilyTree familytree = new FamilyTree();
        familytree = InitData();

        Scanner scan = new Scanner(System.in);
        String nameToSearch;
        Integer menu;

        System.out.printf("\nВас приветствует электронная версия генеалогического древа династии Романовых!\n");
        while(true)
        {
            System.out.println("Введите номер меню:");
            System.out.printf("\t0 выход из программы;\n");
            System.out.printf("\t1 печать информации о детях представителя династии.\n");
            System.out.printf("\t2 печать информации о всех представителях династии Романовых;\n");

            System.out.printf("> ");
            menu = Integer.parseInt(scan.nextLine());
            switch(menu)
            {
                case 0:
                {
                    System.out.println("До свидания!");
                    break;
                }
                case 1:
                {
                    System.out.printf("\nВведите имя, например: Михаил Федорович\n> ");
                    nameToSearch = scan.nextLine();
                    familytree.searchChildrenByFathersName(nameToSearch);
                    break;
                }
                case 2:
                {
                    familytree.printAll();
                    break;
                }
                default:
                {
                    System.out.println("Ошибка ввода!");
                }
            }
            if (menu==0)
            {
                break;
            }
        }
        scan.close();
    }

    public static FamilyTree InitData()
    {
        /*person 01*/
        Person person01 = new Tsar(
                "Михаил",
                "Федорович",
                "Романов",
                Gender.Male,
                1596,
                1645,
                1,
                1613,
                1645);

        /*person 02*/
        Person person02 = new Tsar(
                "Алексей",
                "Михайлович",
                "Романов",
                Gender.Male,
                1629,
                1676,
                2,
                1645,
                1676);
        person02.setFather(person01);

        /*person 03*/
        Person person03 = new Person(
                "Мария",
                "Ильинишна",
                "Милославская",
                Gender.Female,
                1625,
                1669);
        person03.addSpouse(person02);
        person02.addSpouse(person03);

        /*person 04*/
        Person person04 = new Person(
                "Наталья",
                "Кирриловна",
                "Нарышкина",
                Gender.Female,
                1651,
                1694);
        person04.addSpouse(person02);
        person02.addSpouse(person04);

        /*person 05*/
        Person person05 = new Tsar(
                "Федор",
                "Алексеевич",
                "Романов",
                Gender.Male,
                1661,
                1682,
                3,
                1676,
                1682);
        person05.setFather(person02);
        person05.setMother(person03);

        /*person 06*/
        Person person06 = new Tsar(
                "Иоанн 5",
                "Алексеевич",
                "Романов",
                Gender.Male,
                1666,
                1696,
                4,
                1682,
                1696);
        person06.setFather(person02);
        person06.setMother(person03);

        /*person 07*/
        Person person07 = new Person(
                "Софья",
                "Алексеевна",
                "Романова",
                Gender.Female,
                1657,
                1704);
        person07.setFather(person02);
        person07.setMother(person03);

        /*person 08*/
        Person person08 = new Tsar(
                "Петр 1",
                "Алексеевич",
                "Романов",
                Gender.Male,
                1672,
                1725,
                5,
                1696,
                1725);
        person08.setFather(person02);
        person08.setMother(person04);

        /*person 09*/
        Person person09 = new Tsar(
                "Екатерина 1",
                "Алексеевна",
                "Михайлова",
                Gender.Female,
                1684,
                1727,
                6,
                1725,
                10727);
        person09.addSpouse(person08);
        person08.addSpouse(person09);


        FamilyTree familytree = new FamilyTree();
        familytree.add(person01);
        familytree.add(person02);
        familytree.add(person03);
        familytree.add(person04);
        familytree.add(person05);
        familytree.add(person06);
        familytree.add(person07);
        familytree.add(person08);
        familytree.add(person09);

        return familytree;
    }


}
