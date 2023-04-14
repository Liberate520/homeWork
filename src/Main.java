
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

        natalia.addChildren(ksenia.getName());
        alexandr.addChildren(ksenia.getName());
        svetlana.addChildren(nikita.getName());
        sergey.addChildren(nikita.getName());
        ksenia.addChildren(mira.getName());
        nikita.addChildren(mira.getName());


        familyTree.addHuman(mira);
        familyTree.addHuman(nikita);
        familyTree.addHuman(ksenia);
        familyTree.addHuman(svetlana);
        familyTree.addHuman(sergey);
        familyTree.addHuman(alexandr);
        familyTree.addHuman(natalia);

        // natalia.gender = Gender.Male;

        System.out.println(ksenia);

    }
}
