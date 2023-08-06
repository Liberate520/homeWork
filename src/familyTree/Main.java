package familyTree;

public class Main {
    public static void main(String[] args) {
        FamilyTree myFamilyTree = new FamilyTree(123);

        Human human_1 = new Human("Иван", "Пупкин",  "05.05.1955");
        Human human_2 = new Human("Петр", "Глобусов",  "04.04.1944");
        Human human_3 = new Human("Виктор", "Лопатов",  "03.03.1933");
        Human human_4 = new Human("Бушар", "Комбарович",  "02.02.1922");
        Human human_5 = new Human("Анастасия", "Загоняева",  "01.01.1911");

        myFamilyTree.addHuman(human_1);
        myFamilyTree.addHuman(human_2);
        myFamilyTree.addHuman(human_3);
        myFamilyTree.addHuman(human_4);
        myFamilyTree.addHuman(human_5);

        System.out.println(myFamilyTree.getHumansInfo());
    }
}