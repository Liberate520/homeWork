public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree1 = new FamilyTree();

        Human human1 = new Human("Иван", Gender.male);
        Human human2 = new Human("Мария", Gender.female);
        Human human3 = new Human("Анна", Gender.female, human1, human2);
        Human human4 = new Human("Пётр", Gender.male, human1, human2);
        Human human5 = new Human("Владимир", Gender.male, human1, human2);
        Human human6 = new Human("Александр", Gender.male);
        Human human7 = new Human("Николай", Gender.male,human6,human3);

        // familyTree1.add(human1);
        // human3(AddChild("Иван"; Gender.male; human11; human12));
    }
}
