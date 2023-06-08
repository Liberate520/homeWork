public class Main {
    public static void main(String[] args) {
        Person Prs_1 = new Person("Иванов", "Семён", "Матвеевич", "М");

        Prs_1.setYearOfBirth(1984);
        Prs_1.setMonthOfBirth(10);
        Prs_1.setDayOfBirth(23);

        System.out.println(Prs_1.getAge());

        Person Prs_2 = new Person("Иванова", "Анна", "Семёновна", "F");

        Prs_2.setYearOfBirth(2002);
        Prs_2.setMonthOfBirth(2);
        Prs_2.setDayOfBirth(4);

        System.out.println(Prs_2.getAge());




    }
}
