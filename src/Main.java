import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        int humanId = 0;
        FamilyTree tree = new FamilyTree();

        Human father = new Human(humanId++, "Антон", LocalDate.of(1990, 10, 16), Gender.Male);
        Human mother = new Human(humanId++, "Елена", LocalDate.of(1993, 04, 01), Gender.Female);
        Human son = new Human(humanId++, "Андрей", LocalDate.of(2012, 12, 31), Gender.Male);
        tree.addHuman(father);
        tree.addHuman(mother);
        tree.addHuman(son);

        //Добавляем связи
        father.addChild(son);
        mother.addChild(son);

        // Регистрируем брак
        Marriage m = tree.addMarriage(LocalDate.of(2011, 10, 16), mother, father);

        //Андрей развелся с Еленой и женился на Маше
        m.finish(LocalDate.of(2015, 1, 16));
        Human masha = new Human(humanId++, "Маша", LocalDate.of(1994, 11, 5), Gender.Female);
        tree.addHuman(masha);
        tree.addMarriage(LocalDate.of(2016, 1, 1), masha, father);

        System.out.println(String.format("tree info: \n%s", tree.toString()));
    }
}