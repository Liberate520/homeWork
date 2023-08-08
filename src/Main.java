import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        FamilyTree familyTree = new FamilyTree();
        FileHandler fileHandler = new FileHandler();

        Human h1 = new Human("Валентин", LocalDate.of(1212,2,1),
                LocalDate.of(1212,5,5),Gender.MAN);
        Human h2 = new Human("Viktor",LocalDate.of(2333,5,1),
                LocalDate.of(1245,4,1),Gender.MAN);
        Human h3 = new Human("Viktorya",LocalDate.of(1923,2,2),
                LocalDate.of(1323,3,8),Gender.WOMAN);
        Dog d1 = new Dog("jack",LocalDate.of(1999,12,12),
                LocalDate.of(1929,10,12),Gender.MAN);

        familyTree.getTreeList().add(h1);
        familyTree.getTreeList().add(h2);
        familyTree.getTreeList().add(h3);
        familyTree.getTreeList().add(d1);


        familyTree.print();
        System.out.println("--------------------------");
        familyTree.reform(familyTree.getTreeList());
        System.out.println("-------------------------");

        fileHandler.save(familyTree.getTreeList());
        System.out.println("save");

        fileHandler.load();
        System.out.println("download");

        System.out.println("----------------------------");
        familyTree.sortBirthday(familyTree.getTreeList());
        System.out.println("-------------------------");
        familyTree.sortName(familyTree.getTreeList());
    }
}
