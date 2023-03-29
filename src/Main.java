import java.util.Date;

public class Main {
    public static void main(String[] args) {
        FamilyTree testFamily = new FamilyTree();
/**
 *  1. Дерево должно строиться относительно какой-либо персоны, таким образом для всех остальных объектов можно
 *  будет указывать степень родства.
 *  2. ВСЕ экземпляры Human должны иметь уникальные ID для возможности привязки мамы, папы, супруга
 *
 *  на будущее:
 *  - ничто не мешает одного и того же Human добавить в разные "семьи" (экземпляры FamilyTree). Например, у человека
 *  новая семья. Тогда можно будет строить целые сети семей.
 */
        // create Humans for Tree
        Human human1 = new Human(0, "Алексей", "Яковлев", new Date(54, 1, 1), new Date(114, 5, 1), null, null, 1);
        Human human2 = new Human(1, "Алевтина", "Яковлева", new Date(64, 2, 2), null, null, null, 0);

        Human human12_1 = new Human(2, "Борис", "Яковлев", new Date(91, 1, 1), null, 1, 0, 6);
        Human human12_2 = new Human(3, "Бьянка", "Юргент", new Date(92, 2, 2), null, 1, 0, 7);
        Human human12_3 = new Human(4, "Богдан", "Яковлев", new Date(93, 3, 3), null, 1, 0, 8);
        Human human12_4 = new Human(5, "Белла", "Юшкова", new Date(94, 4, 4), null, 1, 0, 9);

        Human human12_12 = new Human(6, "Белка", "Яковлева", new Date(91, 5, 5), null, null, null, 2);
        Human human12_22 = new Human(7, "Билл", "Юргент", new Date(92, 6, 5), null, null, null, 3);
        Human human12_32 = new Human(8, "Бибигуль", "Яковлева", new Date(93, 7, 5), null, null, null, 4);
        Human human12_42 = new Human(9, "Булат", "Юшков", new Date(94, 8, 5), null, null, null, 5);

        Human human12_1_12_12_1 = new Human(10, "Валера", "Яковлев", new Date(11, 1, 1), null, 6, 2, null);
        Human human12_1_12_12_2 = new Human(11, "Виолетта", "Яковлева", new Date(12, 2, 1), null, 6, 2, null);
        Human human12_2_12_22_1 = new Human(12, "Вилор", "Юргент", new Date(13, 3, 2), null, 3, 7, null);
        Human human12_2_12_22_2 = new Human(13, "Валя", "Юргент", new Date(14, 4, 3), null, 3, 7, null);
        Human human12_3_12_32_1 = new Human(14, "Веня", "Яковлев", new Date(15, 5, 4), null, 8, 4, null);
        Human human12_3_12_32_2 = new Human(15, "Вера", "Яковлева", new Date(16, 6, 5), null, 8, 4, null);
        Human human12_4_12_42_1 = new Human(16, "Вано", "Юшков", new Date(17, 7, 6), null, 5, 9, null);
        Human human12_4_12_42_2 = new Human(17, "Вета", "Юшкова", new Date(18, 8, 7), null, 5, 9, null);

        // add Humans to FamilyTree
        testFamily.add(human1);
        testFamily.add(human2);
        testFamily.add(human12_1);
        testFamily.add(human12_2);
        testFamily.add(human12_3);
        testFamily.add(human12_4);
        testFamily.add(human12_12);
        testFamily.add(human12_22);
        testFamily.add(human12_32);
        testFamily.add(human12_42);
        testFamily.add(human12_1_12_12_1);
        testFamily.add(human12_1_12_12_2);
        testFamily.add(human12_2_12_22_1);
        testFamily.add(human12_2_12_22_2);
        testFamily.add(human12_3_12_32_1);
        testFamily.add(human12_3_12_32_2);
        testFamily.add(human12_4_12_42_1);
        testFamily.add(human12_4_12_42_2);

        System.out.println(human12_3.inFamily(testFamily));
        System.out.println(human12_32.inFamily(testFamily));

    }
}
