package model.services;

import model.familyTrees.FamilyTree;
import model.familyTrees.comparators.ByDateBirth;
import model.familyTrees.comparators.NameAlphabetical;
import model.familyTrees.comparators.NameLength;
import model.fileManage.FileManager;
import model.members.Gender;
import model.members.Human;
import model.members.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс model.service.HumanService предоставляет функциональность для работы с семейным древом (FamilyTree) и файловым менеджером (FileManager).
 * <p>
 * Он обеспечивает импорт и экспорт данных, добавление новых записей в древо, получение информации о записях и сортировку древа.
 */
public class HumanService {
    private FamilyTree<Human> familyTree;
    private FileManager fileManager;


    /**
     * Создает новый объект model.service.HumanService.
     * Инициализирует семейное древо и файловый менеджер.
     */
    public HumanService() {
        this.familyTree = null;
    }

    /**
     * Возвращает семейное древо, связанное с model.service.HumanService.
     *
     * @return Семейное древо.
     */
    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }

    /**
     * Возвращает файловый менеджер, связанный с model.service.HumanService.
     *
     * @return Файловый менеджер.
     */


    public String getNameFamilyTree() {
        return familyTree.getNameFamilyTree();
    }

    /**
     * Проверяет создано ли семейное древо
     *
     * @return true если создано
     */
    public boolean checkCreateFamilyTree() {
        return familyTree != null;
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


    public void addRecord(String name, Gender gender, int dateOfBirth,
                          String fatherName, int yearOfBirthFather,
                          String motherName, int yearOfBirthMother) {
        familyTree.addPersonInFamilyTree(
                new Human(name, gender, dateOfBirth),
                fatherName, yearOfBirthFather,
                motherName, yearOfBirthMother);
    }

    /**
     * Возвращает запись из семейного древа по указанному имени и году рождения.
     *
     * @param name Имя человека.
     * @param year Год рождения человека.
     * @return Объект Member с указанным именем и годом рождения, или null, если запись не найдена.
     */
    public Member getRecord(String name, int year) {
        return familyTree.getPersonFromTree(name, year);
    }

    /**
     * Выводит все записи из семейного древа.
     * Если древо пусто, выводит соответствующее сообщение.
     */
    public List<Human> getAllRecord() {
        return familyTree.getFamilyTree();
    }

    /**
     * Выводит родителей человека из семейного древа по указанному имени и году рождения.
     * Если родители неизвестны, выводит соответствующее сообщение.
     *
     * @param name        Имя человека.
     * @param yearOfBirth Год рождения человека.
     */
    public List<Human> getParents(String name, int yearOfBirth) {
        return convertMemberToChildren(familyTree.getParents(name, yearOfBirth));
    }

    public List<Human> getChildren(String name, int yearOfBirth) {
        return convertMemberToChildren(familyTree.getChildren(name, yearOfBirth));
    }

    private List<Human> convertMemberToChildren(List<Member> memberList) {
        List<Human> humanList = new ArrayList<>();
        for (Member member : memberList) {
            if (member instanceof Human human) {
                humanList.add(human);
            }
        }
        return humanList;
    }


    public void sortByAlphabeticalOrder() {
        familyTree.sort(new NameAlphabetical<>());
    }

    public void sortByDateBirth() {
        familyTree.sort(new NameLength<>());
    }

    public void sortByNameLength() {
        familyTree.sort((new ByDateBirth<>()));

    }
}
