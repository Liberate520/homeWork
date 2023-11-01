package model_app;

import family_tree.base.TreeHub;
import family_tree.human.Human;
import family_tree.family_tree.FamilyTree;

public class Main {
    public static void main(String[] args) {
        System.out.println("Фамильное Дерево : ");
        party();
        System.out.println("                    FAMILY TREE");
        System.out.println("===============================");
    }

    private static <E extends TreeHub<E>> void party() {

        FamilyTree<E> familyTree = new FamilyTree<E>(123);
        Human<E> human1 = new Human<E>("Ивановский", "Иван Семенович", "Муж.", "Отец", "В браке", "Формальное",350000.0, 32, 0.1);
        Human<E> human2 = new Human<E>("Семенова", "Марианна Петровна", "Жен.", "Мать", "В браке", "Формальное",350000.0, 30, 0.2);
        Human<E> human3 = new Human<E>("Семенов", "Денис Петрович", "Муж.", "Ребенок", "Не в браке", "Специальное",950000.0, 27, 0.3);
        Human<E> human4 = new Human<E>("Савельев", "Петр Сергеевич", "Муж.", "Отец", "Не в браке", "Специальное",50000.0, 43, 0.4);
        Human<E> human5 = new Human<E>("Живнов", "Марат Клементьевич", "Муж.", "Отец", "В браке", "Специальное",600000.0, 50, 0.5);
        Human<E> human6 = new Human<E>("Алябьева", "Маргарита Васильевна", "Жен.", "Мать", "Не в браке", "Специальное",135000.0, 39, 0.6);
        Human<E> human7 = new Human<E>("Ивановский", "Михаил Иванович", "Муж.", "Ребенок", "Не в браке", "Формальное",5000.0, 14, 0.7);
        Human<E> human8 = new Human<E>("Алябьев", "Петр Маратович", "Муж.", "Ребенок", "Не в браке", "Формальное",10000.0, 20, 0.8);

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);
        familyTree.addHuman(human8);


        System.out.println(familyTree.getRelativeInfo());


    }


}

