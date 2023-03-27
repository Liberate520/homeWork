/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Human human1 = new Human("Екатерина", "ж");
        Human human2 = new Human("Галина", "ж");
        Human human3 = new Human("Владимир", "м");
        Human human4 = new Human("Иван", "м");
        Human human5 = new Human("Евфалия", "ж");
        Human human6 = new Human("Дарья", "ж");
        Human human0 = new Human("", "");

        human1.setMother(human2);
        human1.setFather(human3);
        human6.setFather(human3);
        human6.setMother(human2);
        human2.setMother(human5);
        human2.setFather(human0);
        human3.setFather(human4);
        human3.setMother(human0);
        human4.setMother(human0);
        human4.setFather(human0);
        human5.setMother(human0);
        human5.setFather(human0);

        human2.addchildren(human6);
        human2.addchildren(human1);
        human3.addchildren(human6);
        human3.addchildren(human1);
        human5.addchildren(human2);
        human4.addchildren(human3);
    
        FamilyTree famailytree = new FamilyTree();

        famailytree.addpeople(human1);
        famailytree.addpeople(human2);
        famailytree.addpeople(human3);
        famailytree.addpeople(human4);
        famailytree.addpeople(human5);
        famailytree.addpeople(human6);

        System.out.println(famailytree);
    }
}