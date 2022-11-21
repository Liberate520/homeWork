import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person misha = new Person("Михаил", "Иванов", 60, Sex.MEN);
        Person olesya = new Person("Олеся", "Иванова", 61, Sex.WOMEN);

        Person zahar = new Person("Захар", "Аникин", 62, Sex.MEN);
        Person pavla = new Person("Павла", "Аникина", 58, Sex.WOMEN);

        Person maria = new Person("Мария", "Иванова", 35, Sex.WOMEN);
        Person ivan = new Person("Иван", "Иванов", 36, Sex.MEN);

        Person petr = new Person("Пётр", "Иванов", 10, Sex.MEN);
        Person alice = new Person("Алиса", "Иванова", 7, Sex.WOMEN);

        Person goga = new Person("Георгий", "Аникин", 30, Sex.MEN);
        Person martin = new Person("Мартин", "Аникин", 32, Sex.MEN);

        Person anna = new Person("Анна", "Рускова", 25, Sex.WOMEN);
        Person marta = new Person("Марта", "Иванова", 21, Sex.WOMEN);
        Person justin = new Person("Джастин", "Иванов", 28, Sex.MEN);

        misha.addRelative(new Relative(olesya, FamilyStatus.SPOUSE))
                .addRelative(new Relative(ivan, FamilyStatus.CHILD))
                .addRelative(new Relative(anna, FamilyStatus.CHILD))
                .addRelative(new Relative(marta, FamilyStatus.CHILD))
                .addRelative(new Relative(justin, FamilyStatus.CHILD))
                .addRelative(new Relative(petr, FamilyStatus.GRANDCHILD))
                .addRelative(new Relative(alice, FamilyStatus.GRANDCHILD))
        ;

        olesya.addRelative(new Relative(misha, FamilyStatus.SPOUSE))
                .addRelative(new Relative(ivan, FamilyStatus.CHILD))
                .addRelative(new Relative(anna, FamilyStatus.CHILD))
                .addRelative(new Relative(marta, FamilyStatus.CHILD))
                .addRelative(new Relative(justin, FamilyStatus.CHILD))
                .addRelative(new Relative(petr, FamilyStatus.GRANDCHILD))
                .addRelative(new Relative(alice, FamilyStatus.GRANDCHILD))
        ;

        zahar.addRelative(new Relative(pavla, FamilyStatus.SPOUSE))
                .addRelative(new Relative(maria, FamilyStatus.CHILD))
                .addRelative(new Relative(goga, FamilyStatus.CHILD))
                .addRelative(new Relative(martin, FamilyStatus.CHILD))
                .addRelative(new Relative(petr, FamilyStatus.GRANDCHILD))
                .addRelative(new Relative(alice, FamilyStatus.GRANDCHILD))
        ;

        pavla.addRelative(new Relative(zahar, FamilyStatus.SPOUSE))
                .addRelative(new Relative(maria, FamilyStatus.CHILD))
                .addRelative(new Relative(goga, FamilyStatus.CHILD))
                .addRelative(new Relative(martin, FamilyStatus.CHILD))
                .addRelative(new Relative(petr, FamilyStatus.GRANDCHILD))
                .addRelative(new Relative(alice, FamilyStatus.GRANDCHILD))
        ;

        maria.addRelative(new Relative(ivan, FamilyStatus.SPOUSE))
                .addRelative(new Relative(zahar, FamilyStatus.FATHER))
                .addRelative(new Relative(pavla, FamilyStatus.MOTHER))
                .addRelative(new Relative(petr, FamilyStatus.CHILD))
                .addRelative(new Relative(alice, FamilyStatus.CHILD))
                .addRelative(new Relative(goga, FamilyStatus.BROTHER))
                .addRelative(new Relative(martin, FamilyStatus.BROTHER))
        ;

        ivan.addRelative(new Relative(maria, FamilyStatus.SPOUSE))
                .addRelative(new Relative(misha, FamilyStatus.FATHER))
                .addRelative(new Relative(olesya, FamilyStatus.MOTHER))
                .addRelative(new Relative(petr, FamilyStatus.CHILD))
                .addRelative(new Relative(alice, FamilyStatus.CHILD))
                .addRelative(new Relative(justin, FamilyStatus.BROTHER))
                .addRelative(new Relative(anna, FamilyStatus.SISTER))
                .addRelative(new Relative(marta, FamilyStatus.SISTER))
        ;

        petr.addRelative(new Relative(ivan, FamilyStatus.FATHER))
                .addRelative(new Relative(maria, FamilyStatus.MOTHER))
                .addRelative(new Relative(alice, FamilyStatus.SISTER))
                .addRelative(new Relative(anna, FamilyStatus.AUNT))
                .addRelative(new Relative(marta, FamilyStatus.AUNT))
                .addRelative(new Relative(goga, FamilyStatus.UNCLE))
                .addRelative(new Relative(martin, FamilyStatus.UNCLE))
                .addRelative(new Relative(justin, FamilyStatus.UNCLE))
                .addRelative(new Relative(misha, FamilyStatus.GRAND_FATHER))
                .addRelative(new Relative(zahar, FamilyStatus.GRAND_FATHER))
                .addRelative(new Relative(olesya, FamilyStatus.GRAND_MOTHER))
                .addRelative(new Relative(pavla, FamilyStatus.GRAND_MOTHER))
        ;

        alice.addRelative(new Relative(ivan, FamilyStatus.FATHER))
                .addRelative(new Relative(maria, FamilyStatus.MOTHER))
                .addRelative(new Relative(petr, FamilyStatus.BROTHER))
                .addRelative(new Relative(anna, FamilyStatus.AUNT))
                .addRelative(new Relative(marta, FamilyStatus.AUNT))
                .addRelative(new Relative(goga, FamilyStatus.UNCLE))
                .addRelative(new Relative(martin, FamilyStatus.UNCLE))
                .addRelative(new Relative(justin, FamilyStatus.UNCLE))
                .addRelative(new Relative(misha, FamilyStatus.GRAND_FATHER))
                .addRelative(new Relative(zahar, FamilyStatus.GRAND_FATHER))
                .addRelative(new Relative(olesya, FamilyStatus.GRAND_MOTHER))
                .addRelative(new Relative(pavla, FamilyStatus.GRAND_MOTHER))
        ;

        goga.addRelative(new Relative(zahar, FamilyStatus.FATHER))
                .addRelative(new Relative(pavla, FamilyStatus.MOTHER))
                .addRelative(new Relative(martin, FamilyStatus.BROTHER))
                .addRelative(new Relative(maria, FamilyStatus.SISTER))
        ;

        martin.addRelative(new Relative(zahar, FamilyStatus.FATHER))
                .addRelative(new Relative(pavla, FamilyStatus.MOTHER))
                .addRelative(new Relative(goga, FamilyStatus.BROTHER))
                .addRelative(new Relative(maria, FamilyStatus.SISTER))
        ;

        anna.addRelative(new Relative(misha, FamilyStatus.FATHER))
                .addRelative(new Relative(olesya, FamilyStatus.MOTHER))
                .addRelative(new Relative(justin, FamilyStatus.BROTHER))
                .addRelative(new Relative(ivan, FamilyStatus.BROTHER))
                .addRelative(new Relative(marta, FamilyStatus.SISTER))
        ;

        marta.addRelative(new Relative(misha, FamilyStatus.FATHER))
                .addRelative(new Relative(olesya, FamilyStatus.MOTHER))
                .addRelative(new Relative(justin, FamilyStatus.BROTHER))
                .addRelative(new Relative(ivan, FamilyStatus.BROTHER))
                .addRelative(new Relative(anna, FamilyStatus.SISTER))
        ;

        justin.addRelative(new Relative(misha, FamilyStatus.FATHER))
                .addRelative(new Relative(olesya, FamilyStatus.MOTHER))
                .addRelative(new Relative(anna, FamilyStatus.SISTER))
                .addRelative(new Relative(ivan, FamilyStatus.BROTHER))
                .addRelative(new Relative(marta, FamilyStatus.SISTER))
        ;

        FamilyTree familyTree = new FamilyTree(maria);
        // Получение всей информации
//        System.out.println(familyTree.getInfo());

        // Список детей
//        System.out.println(familyTree.getRelativesFullNameByFamilyStatus(null, java.FamilyStatus.CHILD));

//        Вывод простой информации о челоовеке
//        System.out.println(maria);

        String fileName = "persons.txt";

        // Запись в файл
//        PersonFileUtil.write(petr, fileName);

        // чтение
//        List<Person> personList = PersonFileUtil.read(fileName);
//        personList.forEach(System.out::println);

//        System.out.println("personList.get(0).getFullName() = " + personList.get(0).getFullName());
    }


}
