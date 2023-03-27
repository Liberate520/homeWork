// Реализовать, с учетом ооп подхода, приложение.
// Для проведения исследований с генеалогическим древом.
// Идея: описать некоторое количество компонент, например: модель человека и дерева
// Под “проведением исследования” можно понимать например получение всех детей выбранного человека.

public class Main {
    public static void main(String[] args) {
        Person personOne = new Person("Фио", "10.09.1992");
        Relation personTwo = new Relation();
        personTwo.setBirthDate("10.09.1992");
        personTwo.addKid(personOne);
        System.out.println(personTwo);
    }
}
