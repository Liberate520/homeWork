package model;

import model.familyTrees.FamilyTree;
import model.fileManage.FileManager;
import model.members.Gender;
import model.members.Human;
import model.members.Member;

import java.util.Optional;

/**
 * Класс HumanService предоставляет функциональность для работы с семейным древом (FamilyTree) и файловым менеджером (FileManager).
 * <p>
 * Он обеспечивает импорт и экспорт данных, добавление новых записей в древо, получение информации о записях и сортировку древа.
 */
public class HumanService {
    private FamilyTree<Human> familyTree;
    private FileManager fileManager;

    /**
     * Создает новый объект HumanService.
     * Инициализирует семейное древо и файловый менеджер.
     */
    public HumanService() {
        this.familyTree = null;
    }

    /**
     * Возвращает семейное древо, связанное с HumanService.
     *
     * @return Семейное древо.
     */
    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }

    /**
     * Возвращает файловый менеджер, связанный с HumanService.
     *
     * @return Файловый менеджер.
     */
    public FileManager getFileManager() {
        return fileManager;
    }

    /**
     * Импортирует файл с указанным путем filePath с помощью файлового менеджера.
     * Загружает данные в семейное древо.
     *
     * @param filePath Путь к импортируемому файлу.
     */
    public void importFile(String filePath) {
        this.fileManager = new FileManager(filePath);
        this.familyTree = fileManager.loadFile();
    }

    /**
     * Сохраняет данные из семейного древа в файл с помощью файлового менеджера.
     */
    public void saveFile() {
        fileManager.saveFile(familyTree);
    }

    /**
     * Добавляет новую запись в семейное древо с указанным именем, полом и годом рождения.
     *
     * @param name        Имя человека.
     * @param gender      Пол человека.
     * @param dateOfBirth Год рождения человека.
     */
    public void addRecord(String name, Gender gender, int dateOfBirth) {
        familyTree.addPersonInFamilyTree(new Human(name, gender, dateOfBirth));
    }

    /**
     * Возвращает запись из семейного древа по указанному имени и году рождения.
     *
     * @param name Имя человека.
     * @param year Год рождения человека.
     * @return Объект Member с указанным именем и годом рождения, или null, если запись не найдена.
     */
    public Member getRecord(String name, int year) {
        return familyTree.getHumanFromTree(name, year);
    }

    /**
     * Выводит все записи из семейного древа.
     * Если древо пусто, выводит соответствующее сообщение.
     */
    public void getAllRecord() {
        if (familyTree.getFamilyTree().isEmpty()) {
            System.out.println("Семейное древо пусто.");
        } else {
            System.out.println("Семейное древо:");
            for (Human person : familyTree) {
                System.out.println(person.getName() + " (" + person.getYearOfBirth() + ")");
            }
        }
    }

    /**
     * Выводит родителей человека из семейного древа по указанному имени и году рождения.
     * Если родители неизвестны, выводит соответствующее сообщение.
     *
     * @param name        Имя человека.
     * @param yearOfBirth Год рождения человека.
     */
    public void getParents(String name, int yearOfBirth) {
        Member child = familyTree.getHumanFromTree(name, yearOfBirth);
        if (child != null) {
            String father = Optional.ofNullable(child.getFather()).
                    map(Member::getName).orElse("Неизвестно");
            String mother = Optional.ofNullable(child.getMother()).
                    map(Member::getName).orElse("Неизвестно");
            System.out.printf("Ребенок -> %s, отец -> %s, мать %s\n",
                    child.getName(), father, mother);
        } else {
            System.out.println("Не найден в древе");
        }
    }

    /**
     * Сортирует семейное древо в соответствии с выбранным вариантом сортировки.
     *
     * @param choice Выбранный вариант сортировки (1 - по алфавиту, 2 - по длине имени, 3 - по дате рождения).
     */
    public void sortTree(String choice) {
        switch (choice) {
            case "1" -> familyTree.sortTreeByAlphabeticalOrder();
            case "2" -> familyTree.sortTreeByNameLength();
            case "3" -> familyTree.sortTreeByDateBirth();
            default -> System.out.println("Ошибка ввода");
        }
    }
}
