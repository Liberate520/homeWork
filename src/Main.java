public class Main {
    public static void main(String[] args) {
        Person Prs_1 = new Person("Иванов", "Семён", "Матвеевич", "М");

        Prs_1.setYearOfBirth(1984);
        Prs_1.setMonthOfBirth(10);
        Prs_1.setDayOfBirth(23);

        System.out.println(Prs_1.getAge());


    }
}
