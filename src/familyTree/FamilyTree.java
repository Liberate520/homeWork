package familyTree;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class FamilyTree implements Serializable {

    @Serial
    private static final long serialVersionUID = 6042495868907328366L;
    private Map<String, Human> wholeGenus;
    private Human human;

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
        this.human = human;
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
        return this.wholeGenus.getOrDefault(fullName, null);
    }

    /**
     * Сохранение в файл
     * @param pathStr полный путь
     */
    public void savingTree(String pathStr) {
        try {
            ObjectOutputStream objOS = new ObjectOutputStream(new FileOutputStream(pathStr));
            objOS.writeObject(this);
            objOS.close();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
