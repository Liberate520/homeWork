package familyTree.tree;

import familyTree.human.Human;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class FamilyTree implements Serializable {

    private final Map<String, Human> wholeGenus;

    /**
     * Конструктор. Создаёт новое генеалогическое древо
     */
    public FamilyTree() {
        this.wholeGenus = new LinkedHashMap<>();
    }

    /**
     * Добавление в древо нового человека
     * Ключ - полное имя
     * @param human новый человек
     */
    public void addNewHuman(Human human) {
        if (human.hashCode() != 0){
            this.wholeGenus.putIfAbsent(human.getFullName(), human);
        }
    }

    /**
     * Демонстрация всех членов древа
     * @return список всех членов древа
     */
    public String showAll() {
        StringBuilder str = new StringBuilder();
        int id = 1;
        for (Map.Entry<String, Human> human: this.wholeGenus.entrySet()) {
            str.append(String.format("%d%s", id, human.getValue()));
            id ++;
        }
        return str + "\n";
    }

    /**
     * Поиск человека по полному имени
     * @param fullName строка вида Фамилия Имя Отчество
     * @return объект Human или null
     */
    public Human searchHuman(String fullName){
        return this.wholeGenus.getOrDefault(fullName, new Human(""));
    }
}
