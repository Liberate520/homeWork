public class Main {
    public static void main(String[] args) {
        Human humanOne = new Human("Иван", "Иванов", "21.11.1994");
        Human humanTwo = new Human("Анастасия", "Иванова", "15.06.1995");
        Human humanThree = new Human("Алия", "Иванова", "08.03.2018", humanTwo.getId(), humanOne.getId());

        FamilyTree test = new FamilyTree();
        test.add(humanOne);
        test.add(humanTwo);
        test.add(humanThree);
        System.out.println(test);
        test.parentsHuman(humanTwo);
        test.childrensHuman(humanTwo);

    }
}
