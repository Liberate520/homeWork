package familyTree;

import java.util.LinkedHashMap;
import java.util.Map;

public class FamilyTree {

    LinkedHashMap<String, Human> wholeGenus;

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
            str += String.format("%d. %s\n__________\n", id, human.getValue());
            id++;
        }
        return "\n__________\n" + str + "\n";
    }

    public Human searchHuman(String fullName) {
        if (wholeGenus.containsKey(fullName)) return wholeGenus.get(fullName);
        else return null;
    }
}
