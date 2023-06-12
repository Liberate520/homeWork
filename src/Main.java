import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        Person prs_1 = new Person("Иванов", "Семён", "Матвеевич", "М");
        prs_1.setDateOfBirth(LocalDate.of(1984,10,23));
        tree.add(prs_1);

        Person prs_2 = new Person("Иванова", "Анна", "Андреевна", "F");
        prs_2.setDateOfBirth(LocalDate.of(1993,3,20));
        tree.add(prs_2);

        Person prs_3 = new Person("Иванова", "Марина", "Семёновна", "F");
        prs_3.setDateOfBirth(LocalDate.of(2013,7,10));
        tree.add(prs_3);
        prs_3.setFather(prs_1);
        prs_3.setMother(prs_2);

        prs_1.showChildren();
        prs_2.showChildren();

        System.out.println(tree.getTreeInfo());

        FileHandler FH = new FileHandler("SampleFree.txt");
        FH.saveFile(tree);

        FH.loadFile();
    }
}
