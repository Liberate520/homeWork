package src;

import src.FamilyTree.FTService;
import src.FamilyTree.FamilyTree;
import src.FamilyTree.Person;
import src.FamilyTree.Sex;
import src.Presenter.Presenter;
import src.UI.Console;
import src.UI.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("\nThe Romanov family tree\n");

        FamilyTree<Person> family = new FamilyTree<>();

        family.addPerson(new Person("Михаил Федорович", 1596, 1645, Sex.Male, 1, "1613-1645"));
        family.addWifeToHusband("Михаил Федорович", new Person("Евдокия Лукьяновна Стрешнева", 1608, 1645, Sex.Female, 1));
        family.addChildToMother("Евдокия Лукьяновна Стрешнева", new Person("Алексей Михайлович", 1629, 1676, Sex.Male, 2, "1645-1676"));
        family.addWifeToHusband("Алексей Михайлович", new Person("Наталья Кирилловна Нарышкина", 1651, 1694, Sex.Female, 2));
        family.addChildToMother("Наталья Кирилловна Нарышкина", new Person("Петр I", 1672, 1725, Sex.Male,3,"1682-1725"));
        family.addChildToMother("Евдокия Лукьяновна Стрешнева", new Person("Анна Михайловна", 1630, 1692, Sex.Female, 2));
        family.addChildToMother("Евдокия Лукьяновна Стрешнева", new Person("Марфа Михайловна", 1631, 1632, Sex.Female, 2));
        family.addChildToMother("Евдокия Лукьяновна Стрешнева", new Person("Софья Михайловна", 1634, 1636, Sex.Female, 2));
        family.addChildToMother("Евдокия Лукьяновна Стрешнева", new Person("Марфа Михайловна", 1636, 1706, Sex.Female, 2));
        family.addChildToMother("Евдокия Лукьяновна Стрешнева", new Person("Татьяна Михайловна", 1636, 1706, Sex.Female, 2));
        family.addChildToMother("Евдокия Лукьяновна Стрешнева", new Person("Ирина Михайловна", 1627, 1679, Sex.Female, 2));
        family.addChildToMother("Евдокия Лукьяновна Стрешнева", new Person("Пелагея Михайловна", 1628, 1629, Sex.Female, 2));
        family.addChildToMother("Наталья Кирилловна Нарышкина", new Person("Наталья Алексеевна", 1673, 1716, Sex.Female, 3));
        family.addChildToMother("Наталья Кирилловна Нарышкина", new Person("Федора Алексеевна", 1674, 1678, Sex.Female, 3));
        family.addWifeToHusband("Алексей Михайлович", new Person("Мария Ильинична Миллославская", 1625, 1669, Sex.Male, 1, "1613-1645"));
        family.addChildToMother("Мария Ильинична Миллославская", new Person("Алексей Алексеевич", 1654, 1670, Sex.Male, 2));
        family.addChildToMother("Мария Ильинична Миллославская", new Person("Евдокия Алексеевна", 1650, 1649, Sex.Female, 2));
        family.addChildToMother("Мария Ильинична Миллославская", new Person("Дмитрий Алексеевич", 1648, 1649, Sex.Male, 2));
        family.addChildToMother("Мария Ильинична Миллославская", new Person("Марфа Алексеевна", 1652, 1707, Sex.Female, 2));
        family.addChildToMother("Мария Ильинична Миллославская", new Person("Софья Алексеевна", 1657, 1704, Sex.Female, 2, "1682-1689"));
        family.addChildToMother("Мария Ильинична Миллославская", new Person("Екатерина Алексеевна", 1658, 1718, Sex.Female, 2));
        family.addChildToMother("Мария Ильинична Миллославская", new Person("Мария Алексеевна", 1660, 1723, Sex.Female, 2));
        family.addChildToMother("Мария Ильинична Миллославская", new Person("Анна Алексеевна", 1655, 1659, Sex.Female, 2));
        family.addChildToMother("Мария Ильинична Миллославская", new Person("Феодосия Алексеевна", 1662, 1713, Sex.Female, 2));
        family.addChildToMother("Мария Ильинична Миллославская", new Person("Симеон Алексеевич", 1665, 1669, Sex.Male, 2));
        family.addChildToMother("Мария Ильинична Миллославская", new Person("Иоанн V", 1666, 1696, Sex.Male, 2, "1682-1696"));
        family.addChildToMother("Мария Ильинична Миллославская", new Person("Федор Алексеевич", 1629, 1676, Sex.Male, 2, "1654-1676"));
        family.addWifeToHusband("Федор Алексеевич", new Person("Марфа Матвеевна Апраксина", 1664, 1715, Sex.Female, 3));
        family.addChildToMother("Марфа Матвеевна Апраксина", new Person("Илья Федорович", 1681, 1681, Sex.Male, 4));
        family.addWifeToHusband("Петр I", new Person("Евдокия Федоровна Лопухина", 1669, 1731, Sex.Female, 3));
        family.addWifeToHusband("Петр I", new Person("Екатерина Алексеевна Скавронская", 1684, 1727, Sex.Female, 3, "1725-1727"));
        family.addChildToMother("Евдокия Федоровна Лопухина", new Person("Алексей Петрович",1690, 1718, Sex.Male, 4));
        family.addChildToMother("Евдокия Федоровна Лопухина", new Person("Александр Петрович",1691, 1692, Sex.Male, 4));
        family.addChildToMother("Екатерина Алексеевна Скавронская", new Person("Павел Петрович", 1704, 1707, Sex.Male, 4));
        family.addChildToMother("Екатерина Алексеевна Скавронская", new Person("Анна Петровна", 1708, 1728, Sex.Female, 4));
        family.addChildToMother("Екатерина Алексеевна Скавронская", new Person("Елизавета Петровна", 1709, 1761, Sex.Female, 4, "1741-1761"));
        family.addChildToMother("Екатерина Алексеевна Скавронская", new Person("Наталья Петровна", 1718, 1725, Sex.Female, 4));
        family.addWifeToHusband("Иоанн V", new Person("Прасковья Федоровна Салтыкова", 1664, 1723, Sex.Female, 3));
        family.addChildToMother("Прасковья Федоровна Салтыкова", new Person("Мария Иоанновна", 1689, 1692, Sex.Female, 4));
        family.addChildToMother("Прасковья Федоровна Салтыкова", new Person("Феодосия Иоанновна", 1690, 1691, Sex.Female, 4));
        family.addChildToMother("Прасковья Федоровна Салтыкова", new Person("Екатерина Иоанновна", 1691, 1733, Sex.Female, 4));
        family.addChildToMother("Прасковья Федоровна Салтыкова", new Person("Анна Иоанновна", 1693, 1740, Sex.Female, 4, "1730-1740"));
        family.addChildToMother("Прасковья Федоровна Салтыкова", new Person("Прасковья Иоанновна", 1694, 1730, Sex.Female, 4));



//       family.sortByName();
//       for (Object human: family){
//           System.out.print("Iteration obj ---- ");
//           System.out.println(human);
//       }

        System.out.println(family.sortByBirthday());
        System.out.println(family.sortByYearOfReigh());

        View view = new Console();
        FTService ftService = new FTService();
        new Presenter(view,ftService);
        view.start();



    }
}
