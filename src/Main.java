public class Main {
    public static void main(String[] args) {

        Human human1 = new Human("Петр", "Сидоров", Gender.male, "11.11.1903");
        Human human2 = new Human("Вера", "Иванова", Gender.female, "1.04.1905");
        Human human3 = new Human("Павел", "Сидоров", Gender.male, "5.03.1925", human2, human1);
        Human human4 = new Human("Нина", "Сидорова", Gender.female, "15.12.1927", human2, human1);
        Human human5 = new Human("Инна", "Петрова", Gender.female, "3.04.1926");
        Human human6 = new Human("Иван", "Сидоров", Gender.female, "6.11.1947", human5, human3);

        FamilyTree tree1 = new FamilyTree(human1);
        FamilyTree tree2 = new FamilyTree(human2);
        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
        System.out.println(tree1);
        System.out.println(tree2);

    }
}