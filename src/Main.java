public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        Human natalia = new Human("Наталия");
        Human alexandr = new Human("Александр");
        Human svetlana = new Human("Светлана");
        Human sergey = new Human("Сергей");
        Human nikita = new Human("Никита", sergey, svetlana);
        Human ksenia = new Human("Ксения", alexandr, natalia);
        Human mira = new Human("Мирослава", nikita, ksenia);

        natalia.addChildren(ksenia);
        alexandr.addChildren(ksenia);
        svetlana.addChildren(nikita);
        sergey.addChildren(nikita);
        ksenia.addChildren(mira);
        nikita.addChildren(mira);


        familyTree.addHuman(mira);
        familyTree.addHuman(nikita);
        familyTree.addHuman(ksenia);
        familyTree.addHuman(svetlana);
        familyTree.addHuman(sergey);
        familyTree.addHuman(alexandr);
        familyTree.addHuman(natalia);

        // natalia.gender = Gender.Male;

        System.out.println(svetlana);

    }
}
