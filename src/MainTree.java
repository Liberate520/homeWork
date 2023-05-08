import java.io.IOException;

public class MainTree {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree familyTree = new FamilyTree();
        WriterFile writerFile = new WriterFile();

        Human human1 = new Human("Ivan", "Ivanov", Gender.Male);
        Human human2 = new Human("Petr", "Petrov", Gender.Male);
        Human human3 = new Human("Maria", "Sidorova", Gender.Female);
        Human human4 = new Human("Olga", "Smirnova", Gender.Female);
        Human human5 = new Human("Oleg", "Orlov", Gender.Male);

        writerFile.loaderObject(familyTree);
        familyTree.addPerson(human1);
        familyTree.addPerson(human2);
        familyTree.addPerson(human3);
        familyTree.addPerson(human4);
        familyTree.addPerson(human5);

        // System.out.println(familyTree.getInfoList());
        // familyTree.delPerson(human5);
        // System.out.println(familyTree.getInfoList());
        // familyTree.addPerson(human5);

        // System.out.println(human1);
        human1.setParents(human2);
        // human1.setParents(human4);
        // human1.setParents(human3);
        // human1.setChilds(human3);
        human1.setChilds(human4);
        System.out.println(human1);

        System.out.println(familyTree.getInfoPerson(human3));

        human1.setMother(human3);
        human1.setFather(human5);

        // System.out.println(human1);

        writerFile.saverObject(familyTree);

        // куда надо вставить???

    }

}
