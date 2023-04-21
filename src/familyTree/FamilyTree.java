package familyTree;

import java.util.LinkedHashMap;
import java.util.Map;

public class FamilyTree {

    private static LinkedHashMap<String, Human> wholeGenus;

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
        this.wholeGenus.putIfAbsent(human.getFullName(), human);
    }

    /**
     * Демонстрация всех членов древа
     */
    public String showAll() {
        String str = "";
        int id = 1;
        for (Map.Entry<String, Human> human: wholeGenus.entrySet()) {
            str += String.format("%d. %s", id, human.getValue());
            id++;
        }
        return str + "\n";
    }

    public static Human searchHuman(String fullName) {
        if (wholeGenus.containsKey(fullName)) return wholeGenus.get(fullName);
        else return null;
    }
}
