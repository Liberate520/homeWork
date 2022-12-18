public class Main {
    public static void main(String[] args) {
        FamilyTree myFamilyTree = new FamilyTree();
        Person person1 = new Person("Anna", 30, "female");
        Person person2 = new Person("Sergey", 31, "male");
        Person person3 = new Person("Andrey", 14, "male", person1, person2);
        Person person4 = new Person("Anna", 13, "female", person1, person2);
        Person person5 = new Person("Olga", 19, "female", person1);


        myFamilyTree.addPerson(person1);
        myFamilyTree.addPerson(person2);
        myFamilyTree.addPerson(person3);
        myFamilyTree.addPerson(person4);
        myFamilyTree.addPerson(person5);


//        System.out.println(myFamilyTree.getPersonByName("Anna"));
//        System.out.println(person1.toString());
//        System.out.println(person2.toString());
//        System.out.println(person3.toString());
//        System.out.println(person4.toString());
//        System.out.println(person5.toString());

        System.out.println(myFamilyTree.getAllPersons());
    }
}