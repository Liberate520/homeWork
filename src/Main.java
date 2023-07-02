import human.Person;
import human.GenealogyTree;
public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Виктор", "1");
        Person person2 = new Person("Галина", "1");
        Person person3 = new Person("Николай", "2");
        Person person4 = new Person("Валентина", "2");
        Person person5 = new Person("Елена", "Фамилия");
        Person person6 = new Person("Александр", "Фамилия");
        Person person7 = new Person("Сын", "Фамилия");

        person1.addChild(person5);
        person2.addChild(person5);
        person3.addChild(person6);
        person4.addChild(person6);
        person5.addChild(person7);
        person6.addChild(person7);

//        person1.setDateOfBirth("01.01.1937");
//        person1.setGender("Male");
//
//        person2.setDateOfBirth("01.01.1955");
//        person2.setDateOfDeath("01.01.2010");
//        person2.setGender("Female");
//
//        person3.setDateOfBirth("01.01.1975");
//        person3.setGender("Male");
//
//        GenealogyTree tree = new GenealogyTree();
//        tree.addPerson(person1);
//        tree.addPerson(person2);
//        tree.addPerson(person3);
//
//        tree.showTree();
//        tree.findPerson("Папа");
//        tree.printGenealogyTree(person1, 0);
    }
}
