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

        misha.addRelative(olesya, FamilyStatus.SPOUSE)
                .addRelative(ivan, FamilyStatus.CHILD)
                .addRelative(anna, FamilyStatus.CHILD)
                .addRelative(marta, FamilyStatus.CHILD)
                .addRelative(justin, FamilyStatus.CHILD)
                .addRelative(petr, FamilyStatus.GRANDCHILD)
                .addRelative(alice, FamilyStatus.GRANDCHILD)
        ;

        olesya.addRelative(misha, FamilyStatus.SPOUSE)
                .addRelative(ivan, FamilyStatus.CHILD)
                .addRelative(anna, FamilyStatus.CHILD)
                .addRelative(marta, FamilyStatus.CHILD)
                .addRelative(justin, FamilyStatus.CHILD)
                .addRelative(petr, FamilyStatus.GRANDCHILD)
                .addRelative(alice, FamilyStatus.GRANDCHILD)
        ;

        zahar.addRelative(pavla, FamilyStatus.SPOUSE)
                .addRelative(maria, FamilyStatus.CHILD)
                .addRelative(goga, FamilyStatus.CHILD)
                .addRelative(martin, FamilyStatus.CHILD)
                .addRelative(petr, FamilyStatus.GRANDCHILD)
                .addRelative(alice, FamilyStatus.GRANDCHILD)
        ;

        pavla.addRelative(zahar, FamilyStatus.SPOUSE)
                .addRelative(maria, FamilyStatus.CHILD)
                .addRelative(goga, FamilyStatus.CHILD)
                .addRelative(martin, FamilyStatus.CHILD)
                .addRelative(petr, FamilyStatus.GRANDCHILD)
                .addRelative(alice, FamilyStatus.GRANDCHILD)
        ;

        maria.addRelative(ivan, FamilyStatus.SPOUSE)
                .addRelative(zahar, FamilyStatus.FATHER)
                .addRelative(pavla, FamilyStatus.MOTHER)
                .addRelative(petr, FamilyStatus.CHILD)
                .addRelative(alice, FamilyStatus.CHILD)
                .addRelative(goga, FamilyStatus.BROTHER)
                .addRelative(martin, FamilyStatus.BROTHER)
        ;

        ivan.addRelative(maria, FamilyStatus.SPOUSE)
                .addRelative(misha, FamilyStatus.FATHER)
                .addRelative(olesya, FamilyStatus.MOTHER)
                .addRelative(petr, FamilyStatus.CHILD)
                .addRelative(alice, FamilyStatus.CHILD)
                .addRelative(justin, FamilyStatus.BROTHER)
                .addRelative(anna, FamilyStatus.SISTER)
                .addRelative(marta, FamilyStatus.SISTER)
        ;

        petr.addRelative(ivan, FamilyStatus.FATHER)
                .addRelative(maria, FamilyStatus.MOTHER)
                .addRelative(alice, FamilyStatus.SISTER)
                .addRelative(anna, FamilyStatus.AUNT)
                .addRelative(marta, FamilyStatus.AUNT)
                .addRelative(goga, FamilyStatus.UNCLE)
                .addRelative(martin, FamilyStatus.UNCLE)
                .addRelative(justin, FamilyStatus.UNCLE)
                .addRelative(misha, FamilyStatus.GRAND_FATHER)
                .addRelative(zahar, FamilyStatus.GRAND_FATHER)
                .addRelative(olesya, FamilyStatus.GRAND_MOTHER)
                .addRelative(pavla, FamilyStatus.GRAND_MOTHER)
        ;

        alice.addRelative(ivan, FamilyStatus.FATHER)
                .addRelative(maria, FamilyStatus.MOTHER)
                .addRelative(petr, FamilyStatus.BROTHER)
                .addRelative(anna, FamilyStatus.AUNT)
                .addRelative(marta, FamilyStatus.AUNT)
                .addRelative(goga, FamilyStatus.UNCLE)
                .addRelative(martin, FamilyStatus.UNCLE)
                .addRelative(justin, FamilyStatus.UNCLE)
                .addRelative(misha, FamilyStatus.GRAND_FATHER)
                .addRelative(zahar, FamilyStatus.GRAND_FATHER)
                .addRelative(olesya, FamilyStatus.GRAND_MOTHER)
                .addRelative(pavla, FamilyStatus.GRAND_MOTHER)
        ;

        goga.addRelative(zahar, FamilyStatus.FATHER)
                .addRelative(pavla, FamilyStatus.MOTHER)
                .addRelative(martin, FamilyStatus.BROTHER)
                .addRelative(maria, FamilyStatus.SISTER)
        ;

        martin.addRelative(zahar, FamilyStatus.FATHER)
                .addRelative(pavla, FamilyStatus.MOTHER)
                .addRelative(goga, FamilyStatus.BROTHER)
                .addRelative(maria, FamilyStatus.SISTER)
        ;

        anna.addRelative(misha, FamilyStatus.FATHER)
                .addRelative(olesya, FamilyStatus.MOTHER)
                .addRelative(justin, FamilyStatus.BROTHER)
                .addRelative(ivan, FamilyStatus.BROTHER)
                .addRelative(marta, FamilyStatus.SISTER)
        ;

        marta.addRelative(misha, FamilyStatus.FATHER)
                .addRelative(olesya, FamilyStatus.MOTHER)
                .addRelative(justin, FamilyStatus.BROTHER)
                .addRelative(ivan, FamilyStatus.BROTHER)
                .addRelative(anna, FamilyStatus.SISTER)
        ;

        justin.addRelative(misha, FamilyStatus.FATHER)
                .addRelative(olesya, FamilyStatus.MOTHER)
                .addRelative(anna, FamilyStatus.SISTER)
                .addRelative(ivan, FamilyStatus.BROTHER)
                .addRelative(marta, FamilyStatus.SISTER)
        ;

        FamilyTree familyTree = new FamilyTree(maria);
        // Получение всей информации
//        System.out.println(familyTree.getInfo());

        // Список детей
//        System.out.println(familyTree.getRelativesFullNameByFamilyStatus(null, FamilyStatus.CHILD));

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
