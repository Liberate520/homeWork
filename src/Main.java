import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person prs_1 = new Person("Иванов", "Семён", "Матвеевич", "М");
        prs_1.setDateOfBirth(LocalDate.of(1984,10,23));
        System.out.println(prs_1.getAge());

        Person prs_2 = new Person("Иванова", "Анна", "Андреевна", "F");
        prs_2.setDateOfBirth(LocalDate.of(1993,3,20));
        System.out.println(prs_2.getAge());

        Person prs_3 = new Person("Иванова", "Марина", "Семёновна", "F");
        prs_3.setDateOfBirth(LocalDate.of(2013,7,10));
        System.out.println(prs_3.getAge());

        prs_1.addChild(prs_3);
        prs_1.showChildren();

        prs_2.showChildren();

        System.out.println(prs_3.getInfo());



    }
}
