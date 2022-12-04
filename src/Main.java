public class Main {
    public static void main(String[] args) {
        GenealogicalTree genealogicalTree = new GenealogicalTree();

        Person person1 = new Person("Александр Иванов", PersonGender.male);
        Person person2 = new Person("Пётр Иванов", PersonGender.male);
        Person person3 = new Person("Иван Иванов", PersonGender.male);
        Person person4 = new Person("Анастасия Иванова", PersonGender.female);

        genealogicalTree.addPerson(person1);
        genealogicalTree.addPerson(person2);
        genealogicalTree.addPerson(person3);
        genealogicalTree.addPerson(person4);

        person4.addConnection(person1, FamilyConnectionType.son);
        person4.addConnection(person2, FamilyConnectionType.son);
        person3.addConnection(person1, FamilyConnectionType.son);
        person3.addConnection(person2, FamilyConnectionType.son);

        person1.showConnection(FamilyConnectionType.father);
        System.out.println(genealogicalTree);
    }
}
