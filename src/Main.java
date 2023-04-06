public class Main {
    public static void main(String[] args) {


        Human human1 = new Human("Пушкин Лев Александрович", 1723, 1790);
        Human human2 = new Human("Чичерина Ольга Васильевна", 1737, 1802);
        Human human3 = new Human("Пушкин Сергей Львович", 1770, 1848);
        Human human4 = new Human("Ганнибал Надежда Осиповна", 1775, 1836);
        Human human5 = new Human("Пушкина Ольга Сергеевна", 1797, 1868);
        Human human6 = new Human("Пушкин Александр Сергеевич", 1799, 1837);
        Human human7 = new Human("Пушкин Лев Сергеевич", 1805, 1852);
        Human human8 = new Human("Гончарова Наталья Николаевна", 1812, 1863);


        human1.setSpouse(human2);
        human2.setSpouse(human1);
        human2.addChildren(human3);
        human3.setFather(human1);
        human3.setMother(human2);

        human3.setSpouse(human4);
        human4.setSpouse(human3);
        human3.addChildren(human5);
        human3.addChildren(human6);
        human3.addChildren(human7);
        human4.addChildren(human5);
        human4.addChildren(human6);
        human4.addChildren(human7);
        human5.setFather(human3);
        human5.setMother(human4);
        human6.setFather(human3);
        human6.setMother(human4);
        human7.setFather(human3);
        human7.setMother(human4);
        human6.setSpouse(human8);
        human8.setSpouse(human6);

        human6.setSpouse(human8);
        human8.setSpouse(human6);


        GenealogicalTree pushkin = new GenealogicalTree();
        pushkin.addHuman(human1);
        pushkin.addHuman(human2);
        pushkin.addHuman(human3);
        pushkin.addHuman(human4);
        pushkin.addHuman(human5);
        pushkin.addHuman(human6);
        pushkin.addHuman(human7);
        pushkin.addHuman(human8);


        System.out.println(human4.getChildren());
        System.out.println();

        for (String human:
                pushkin.getFamily()) {
            System.out.println(human);
        }
        System.out.println();

        System.out.println(pushkin.findHuman("Пушкин Сергей Львович"));
        System.out.println();

        System.out.println(pushkin.findHuman("Пушкин Александр Сергеевич").getSpouse().getName());
    }
}
