import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("\nThe Romanov family tree\n");
//        FamilyTree people = new FamilyTree();
//
//        people.addPerson(new Person("Михаил Федорович", 1596, 1645, Sex.Male, 1, "1613-1645"));
//        people.addWifeToHusband("Михаил Федорович", new Person("Евдокия Лукьяновна Стрешнева", null,null, Sex.Female, 1));
//        people.addChildToMother("Евдокия Лукьяновна Стрешнева", new Person("Алексей Михайлович", 1629, 1676, Sex.Male, 2, "(Тишайший) 1645-1676"));
//        people.addWifeToHusband("Алексей Михайлович", new Person("Наталья Кирилловна Нарышкина", 1651, 1694, Sex.Female, 2));
//        people.addChildToMother("Наталья Кирилловна Нарышкина", new Person("Петр I", 1672, 1725, Sex.Male,3,"(Петр Алексеевич) 1682-1725"));
//
//        people.getList();

//        SavingFT sFT = new SavingFT(people);
//        FileOutputStream fileOutStream = new FileOutputStream("sFT.ser");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutStream);
//        objectOutputStream.writeObject(sFT);
//        objectOutputStream.close();

//        family.addChildToMother("Евдокия Лукьяновна Стрешнева", new Person("Анна Михайловна", 1630, 1692, Sex.Female, 2));
//        family.addChildToMother("Евдокия Лукьяновна Стрешнева", new Person("Марфа Михайловна", 1631, 1632, Sex.Female, 2));
//        family.addChildToMother("Евдокия Лукьяновна Стрешнева", new Person("Софья Михайловна", 1634, 1636, Sex.Female, 2));
//        family.addChildToMother("Евдокия Лукьяновна Стрешнева", new Person("Марфа Михайловна", 1636, 1706, Sex.Female, 2));
//        family.addChildToMother("Евдокия Лукьяновна Стрешнева", new Person("Татьяна Михайловна", 1636, 1706, Sex.Female, 2));
//        family.addChildToMother("Евдокия Лукьяновна Стрешнева", new Person("Ирина Михайловна", 1627, 1679, Sex.Female, 2));
//        family.addChildToMother("Евдокия Лукьяновна Стрешнева", new Person("Пелагея Михайловна", 1628, 1629, Sex.Female, 2));
//
//        family.addChildToMother("Наталья Кирилловна Нарышкина", new Person("Наталья Алексеевна", 1673, 1716, Sex.Female, 3));
//        family.addChildToMother("Наталья Кирилловна Нарышкина", new Person("Федора Алексеевна", 1674, 1678, Sex.Female, 3));
//
//        family.addWifeToHusband("Алексей Михайлович", new Person("Мария Ильинична Миллославская", 1625, 1669, Sex.Male, 1, "1613-1645"));
//        family.addChildToMother("Мария Ильинична Миллославская", new Person("Алексей Алексеевич", 1654, 1670, Sex.Male, 2));
//        family.addChildToMother("Мария Ильинична Миллославская", new Person("Евдокия Алексеевна", 1650, 1649, Sex.Female, 2));
//        family.addChildToMother("Мария Ильинична Миллославская", new Person("Дмитрий Алексеевич", 1648, 1649, Sex.Male, 2));
//        family.addChildToMother("Мария Ильинична Миллославская", new Person("Марфа Алексеевна", 1652, 1707, Sex.Female, 2));
//        family.addChildToMother("Мария Ильинична Миллославская", new Person("Софья Алексеевна", 1657, 1704, Sex.Female, 2, "1682-1689"));
//        family.addChildToMother("Мария Ильинична Миллославская", new Person("Екатерина Алексеевна", 1658, 1718, Sex.Female, 2));
//        family.addChildToMother("Мария Ильинична Миллославская", new Person("Мария Алексеевна", 1660, 1723, Sex.Female, 2));
//        family.addChildToMother("Мария Ильинична Миллославская", new Person("Анна Алексеевна", 1655, 1659, Sex.Female, 2));
//        family.addChildToMother("Мария Ильинична Миллославская", new Person("Феодосия Алексеевна", 1662, 1713, Sex.Female, 2));
//        family.addChildToMother("Мария Ильинична Миллославская", new Person("Симеон Алексеевич", 1665, 1669, Sex.Male, 2));
//        family.addChildToMother("Мария Ильинична Миллославская", new Person("Иоанн V ", 1666, 1696, Sex.Male, 2, "Иоанн Алексеевич 1682-1696"));
//
//        family.getList();
//        saveToFile(family);

        restoreFromFile();

    }

    public static void saveToFile(FamilyTree tree) throws IOException {
        SavingFT sFT = new SavingFT(tree);
        FileOutputStream fileOutStream = new FileOutputStream("sFT.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutStream);
        objectOutputStream.writeObject(sFT);
        objectOutputStream.close();
        System.out.println("\nThe Family Tree is saved to sFT.ser");
    }

    public static FamilyTree restoreFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInStream = new FileInputStream("sFT.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInStream);
        SavingFT people = (SavingFT) objectInputStream.readObject();
        FamilyTree family = people.getPeople();
        family.getList();
        System.out.println("\nThe Family Tree has been restored");
        return family;
    }
}