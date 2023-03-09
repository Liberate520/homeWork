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

        FamilyTree<Person> family = new FamilyTree<>();
        View view = new Console();
        FTService ftService = new FTService();
        new Presenter(view,ftService);


        ftService.addPersonToTree("Михаил Федорович", 1596, 1645, Sex.Male ,"1613-1645");
        ftService.addWifeToHusband("Михаил Федорович", "Евдокия Лукьяновна Стрешнева", 1608, 1645, Sex.Female, "1613-1645");
        ftService.addChildToMother("Евдокия Лукьяновна Стрешнева","Алексей Михайлович", 1629, 1676, Sex.Male, "1645-1676");
        ftService.addWifeToHusband("Алексей Михайлович", "Наталья Кирилловна Нарышкина", 1651, 1694, Sex.Female, "1613-1645");
        ftService.addChildToMother("Наталья Кирилловна Нарышкина","Петр I", 1672, 1725, Sex.Male,"1682-1725");
        ftService.addChildToMother("Евдокия Лукьяновна Стрешнева", "Анна Михайловна", 1630, 1692, Sex.Female,  "1613-1645");
        ftService.addChildToMother("Евдокия Лукьяновна Стрешнева", "Марфа Михайловна", 1631, 1632, Sex.Female, "1613-1645");
        ftService.addChildToMother("Евдокия Лукьяновна Стрешнева", "Софья Михайловна", 1634, 1636, Sex.Female, "1613-1645");
        ftService.addChildToMother("Евдокия Лукьяновна Стрешнева", "Марфа Михайловна", 1636, 1706, Sex.Female, "1613-1645");
        ftService.addChildToMother("Евдокия Лукьяновна Стрешнева", "Татьяна Михайловна", 1636, 1706, Sex.Female, "1613-1645");
        ftService.addChildToMother("Евдокия Лукьяновна Стрешнева", "Ирина Михайловна", 1627, 1679, Sex.Female, "1613-1645");
        ftService.addChildToMother("Евдокия Лукьяновна Стрешнева", "Пелагея Михайловна", 1628, 1629, Sex.Female,  "1613-1645");
        ftService.addChildToMother("Наталья Кирилловна Нарышкина", "Наталья Алексеевна", 1673, 1716, Sex.Female,  "1613-1645");
        ftService.addChildToMother("Наталья Кирилловна Нарышкина", "Федора Алексеевна", 1674, 1678, Sex.Female, "1613-1645");
        ftService.addWifeToHusband("Алексей Михайлович", "Мария Ильинична Миллославская", 1625, 1669, Sex.Male,  "1613-1645");
        ftService.addChildToMother("Мария Ильинична Миллославская", "Алексей Алексеевич", 1654, 1670, Sex.Male, "1613-1645");
        ftService.addChildToMother("Мария Ильинична Миллославская", "Евдокия Алексеевна", 1650, 1649, Sex.Female, "1613-1645");
        ftService.addChildToMother("Мария Ильинична Миллославская", "Дмитрий Алексеевич", 1648, 1649, Sex.Male, "1613-1645");
        ftService.addChildToMother("Мария Ильинична Миллославская", "Марфа Алексеевна", 1652, 1707, Sex.Female, "1613-1645");
        ftService.addChildToMother("Мария Ильинична Миллославская", "Софья Алексеевна", 1657, 1704, Sex.Female, "1682-1689");
        ftService.addChildToMother("Мария Ильинична Миллославская", "Екатерина Алексеевна", 1658, 1718, Sex.Female, "1613-1645");
        ftService.addChildToMother("Мария Ильинична Миллославская", "Мария Алексеевна", 1660, 1723, Sex.Female, "1613-1645");
        ftService.addChildToMother("Мария Ильинична Миллославская", "Анна Алексеевна", 1655, 1659, Sex.Female, "1613-1645");
        ftService.addChildToMother("Мария Ильинична Миллославская", "Феодосия Алексеевна", 1662, 1713, Sex.Female, "1613-1645");
        ftService.addChildToMother("Мария Ильинична Миллославская", "Симеон Алексеевич", 1665, 1669, Sex.Male, "1613-1645");
        ftService.addChildToMother("Мария Ильинична Миллославская", "Иоанн V", 1666, 1696, Sex.Male, "1682-1696");
        ftService.addChildToMother("Мария Ильинична Миллославская", "Федор Алексеевич", 1629, 1676, Sex.Male, "1654-1676");
        ftService.addWifeToHusband("Федор Алексеевич", "Марфа Матвеевна Апраксина", 1664, 1715, Sex.Female, "1613-1645");
        ftService.addChildToMother("Марфа Матвеевна Апраксина", "Илья Федорович", 1681, 1681, Sex.Male, "1613-1645");
        ftService.addWifeToHusband("Петр I", "Евдокия Федоровна Лопухина", 1669, 1731, Sex.Female, "1613-1645");
        ftService.addWifeToHusband("Петр I", "Екатерина Алексеевна Скавронская", 1684, 1727, Sex.Female, "1725-1727");
        ftService.addChildToMother("Евдокия Федоровна Лопухина", "Алексей Петрович",1690, 1718, Sex.Male, "1613-1645");
        ftService.addChildToMother("Евдокия Федоровна Лопухина", "Александр Петрович",1691, 1692, Sex.Male, "1613-1645");
        ftService.addChildToMother("Екатерина Алексеевна Скавронская", "Павел Петрович", 1704, 1707, Sex.Male, "1613-1645");
        ftService.addChildToMother("Екатерина Алексеевна Скавронская", "Анна Петровна", 1708, 1728, Sex.Female, "1613-1645");
        ftService.addChildToMother("Екатерина Алексеевна Скавронская", "Елизавета Петровна", 1709, 1761, Sex.Female, "1741-1761");
        ftService.addChildToMother("Екатерина Алексеевна Скавронская", "Наталья Петровна", 1718, 1725, Sex.Female, "1613-1645");
        ftService.addWifeToHusband("Иоанн V", "Прасковья Федоровна Салтыкова", 1664, 1723, Sex.Female, "1613-1645");
        ftService.addChildToMother("Прасковья Федоровна Салтыкова", "Мария Иоанновна", 1689, 1692, Sex.Female, "1613-1645");
        ftService.addChildToMother("Прасковья Федоровна Салтыкова", "Феодосия Иоанновна", 1690, 1691, Sex.Female, "1613-1645");
        ftService.addChildToMother("Прасковья Федоровна Салтыкова", "Екатерина Иоанновна", 1691, 1733, Sex.Female, "1613-1645");
        ftService.addChildToMother("Прасковья Федоровна Салтыкова", "Анна Иоанновна", 1693, 1740, Sex.Female, "1730-1740");
        ftService.addChildToMother("Прасковья Федоровна Салтыкова", "Прасковья Иоанновна", 1694, 1730, Sex.Female, "1613-1645");

        view.start();

    }
}
