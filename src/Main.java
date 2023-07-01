import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Создаем объекты
        Human father = new Human("Антон", LocalDate.of(2000, 10, 16), Gender.Male);
        Human mother = new Human("Елена", LocalDate.of(2003, 04, 01), Gender.Female);
        Human son = new Human("Андрей", LocalDate.of(2020, 12, 31), Gender.Male);

        //Устанавливаем связи
        father.setChild(son);
        mother.setChild(son);

        //Добавляем в общество
        FamilyTree tree = new FamilyTree();
        tree.addHuman(father);
        tree.addHuman(mother);
        tree.addHuman(son);
        System.out.println(String.format("Состав дерева: %s", tree.toString()));
    }
}