package tree;

import java.util.List;

public class FamilyTree implements Service  {
    public static void FamilyTree (String[] args) {

    }



    /*
    Human human2 = new Human("Natalya",20.04.1959, "Vera", "Victor", Gender.Female);
    Human human3 = new Human("Mikhail",15.12.1960, "Vladimir", "Galina", Gender.Male);
    Human human4 = new Human("Vladimir", 06.06.1931, new Human(), new Human(), new ArrayList<>(), Gender.Male);
    Human human5 = new Human("Galina", 15.12.1937, new Human(), new Human(), new ArrayList<>(), Gender.Female);
    Human human6 = new Human("Victor", 15.02.1930, new Human(), new Human(), new ArrayList<>(), Gender.Male);
    Human human7 = new Human("Vera", 09.08.1934, new Human(), new Human(), new ArrayList<>(), Gender.Female);
    Human human8 = new Human("Daria", 08.08.1990, new Human(), new Human(), new ArrayList<>(), Gender.Female);
    Human human9 = new Human("Evgeniy", 23.07.1987, new Human(), new Human(), new ArrayList<>(), Gender.Male);
    Human human10 = new Human("Filippa", 10.09.2022, new Human(), new Human(), new ArrayList<>(), Gender.Female);

        human1.setFather(human3);
        human1.setMother(human2);
        human2.setMother(human7);
        human2.setFather(human6);
        human3.setFather(human4);
        human3.setMother(human5);
        human9.setMother(human2);
        human9.setFather(human3);
        human9.setChild(human10);
*/
    @Override
    public void saveTree() {
        List<Human> fullList = Human.fullList;
    }

    @Override
    public void readTree() {
        List<Human> fullList = Human.fullList;
    }




}
