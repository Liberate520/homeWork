public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("John", "Doe", Sex.Male, true, 25, null, null, null, null);
        Person person2 = new Person("Anna", "Doe", Sex.Female, true, 24, null, null, null, null);
        Person person3 = new Person("Diana", "Doe", Sex.Female, true, 4, null, null, null, null);
        person1.setSpouse(person2);
        person3.setFather(person1);
        person3.setMother(person2);
        Tree test = new Tree();
        System.out.println(test.getInfo(person1));
    }
}
