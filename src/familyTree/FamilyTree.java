package familyTree;

import java.util.LinkedHashMap;
import java.util.Map;

public class FamilyTree {

    private LinkedHashMap<String, Human> wholeGenus;

    /**
     * Конструктор. Создаёт новое генеалогическое древо
     */
    public FamilyTree() {
        wholeGenus = new LinkedHashMap<>();
    }

    /**
     * Добавление в древо нового человека
     * Ключ - полное имя
     * @param human новый человек
     */
    public void addNewHuman(Human human) {
        wholeGenus.putIfAbsent(human.getFullName(), human);
    }

    /**
     * Демонстрация всех членов
     */
    public void showAll() {
        int id = 1;
        for (Map.Entry<String, Human> human: wholeGenus.entrySet()) {
            System.out.printf("%d. %s\n", id, human.getValue());
            id++;
            System.out.println("----------");
        }
    }
}
