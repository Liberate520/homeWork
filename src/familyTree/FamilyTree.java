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
     * Демонстрация всех членов древа
     */
    public void showAll() {
        int id = 1;
        for (Map.Entry<String, Human> human: wholeGenus.entrySet()) {
            System.out.printf("%d. %s\n__________\n", id, human.getValue());
            id++;
        }
    }

    public void showHuman(String partFullName) {
        int res = 0;
        for (Map.Entry<String, Human> human: wholeGenus.entrySet()) {
            if (human.getKey().contains(partFullName)){
                System.out.printf("%s\n__________\n", human.getValue());
                res ++;
            }
        }
        if (res == 0) System.out.println("Такого человека не найдено.");
    }
}
