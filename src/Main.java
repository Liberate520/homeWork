


import java.io.IOException;


public class Main {
    static Tree familyTree = new Tree();

    public static void createFamily(Human father, Human mother, Human child) {
        child.setFather(father);
        child.setMother(mother);
        mother.setWifeOrHusband(father);
        familyTree.add(mother);
        familyTree.add(father);
        familyTree.add(child);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human people1 = new Human("01,01,1686", "александр", "пушкин", "", "male");
        Human people2 = new Human("01/01/1703", "евдокия", "головина", "", "female");
        Human people3 = new Human("01.01/1723", "лев", "пушкин", "александрович", "male");

        Human people4 = new Human("01,01,1700", "василий", "чичерин", "", "male");
        Human people5 = new Human("01/01/1705", "лукерья", "приклонская", "", "female");
        Human people6 = new Human("01.01/1737", "ольга", "чичерина", "васильевна", "female");

        Human people7 = new Human("01,01,1770", "сергей", "пушкин", "львович", "male");

        Human people8 = new Human("01,01,1696", "абрам", "ганнибал", "", "male");
        Human people9 = new Human("01/01/1717", "христина", "шеберг", "", "female");
        Human people10 = new Human("01.01/1744", "осип", "ганнибал", "абрамович", "male");

        Human people11 = new Human("01,01,1717", "алексей", "пушкин", "", "male");
        Human people12 = new Human("01/01/1721", "сарра", "пушкина-ржевская", "", "female");
        Human people13 = new Human("01.01/1745", "мария", "пушкина", "алексеевна", "female");

        Human people14 = new Human("01,01,1775", "надежда", "пушкина-ганнибал", "осиповна", "female");

        Human people15 = new Human("01,01,1799", "александр", "пушкин", "сергеевич", "male");

        Human people16 = new Human("01,01,1812", "наталья", "пушкина-гончарова", "николаевна", "female");

        Human people17 = new Human("01,01,1832", "мария", "пушкина-гартунг", "александровна", "female");
        Human people18 = new Human("01,01,1836", "наталья", "пушкина-дубельт", "александровна", "female");
        Human people19 = new Human("01,01,1835", "григорий", "пушкин", "александрович", "male");
        Human people20 = new Human("01,01,1833", "александр", "пушкин", "александрович", "male");

        //family 1
        createFamily(people1, people2, people3);
        //family 2
        createFamily(people4, people5, people6);
        //family 3
        createFamily(people3, people6, people7);
        //family 4
        createFamily(people8, people9, people10);
        //family 5
        createFamily(people11, people12, people13);
        //family 6
        createFamily(people10, people13, people14);
        //family 7
        createFamily(people7, people14, people15);
        //family 8
        createFamily(people15, people16, people17);
        createFamily(people15, people16, people18);
        createFamily(people15, people16, people19);
        createFamily(people15, people16, people20);
        System.out.println(familyTree.getInfo());
        SaveTxt data = new SaveTxt();
        data.save(familyTree);
        System.out.println("Загрузка дерева из файла: ");
        Tree treeRestored= (Tree) data.load();
        System.out.println(treeRestored.getInfo());

    }
}
