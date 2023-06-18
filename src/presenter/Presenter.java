package presenter;

import model.members.Human;
import model.services.HumanService;
import model.members.Gender;
import model.members.Member;

import java.util.List;

/**
 * Класс Presenter служит посредником между представлением (UI) и моделью (model.service.HumanService).
 * <p>
 * Он обрабатывает взаимодействие с пользователем, обрабатывает ввод и соответствующим образом обновляет модель.
 */
public class Presenter {

    boolean importFileLoaded;
    private HumanService humanService;

    /**
     * Создает новый объект Presenter.
     */
    public Presenter() {
        importFileLoaded = false;

        this.humanService = new HumanService();
    }


    public boolean isImportFileLoaded() {
        return importFileLoaded;
    }




    /**
     * Возвращает bool значение создано ли семейное древо или нет
     *
     * @return boolean
     */
    public boolean checkCreateFamilyTree() {
        return humanService.checkCreateFamilyTree();
    }

    public String getNameFamilyTree() {
        return humanService.getNameFamilyTree();
    }

    /**
     * Импортирует файл с указанным путем filePath в model.service.HumanService.
     *
     * @param filePath Путь к импортируемому файлу.
     */
    public void loadFile(String filePath) {
        humanService.loadFile(filePath);
        if (checkCreateFamilyTree()){
            importFileLoaded = true;
        }
    }

    /**
     * Сохраняет данные в model.service.HumanService в файл.
     */
    public void saveFile() {
        humanService.saveFile();
    }

    /**
     * Добавляет запись в model.service.HumanService с указанными именем, полом и годом рождения.
     *
     * @param name        Имя человека.
     * @param gender      Пол человека.
     * @param yearOfBirth Год рождения человека.
     */
    public void addRecord(String name, Gender gender, int yearOfBirth) {
        humanService.addRecord(name, gender, yearOfBirth);
    }


    public void addRecord(String name, Gender gender, int dateOfBirth,
                          String fatherName, int yearOfBirthFather,
                          String motherName, int yearOfBirthMother) {
        humanService.addRecord(
                name, gender, dateOfBirth,
                fatherName, yearOfBirthFather,
                motherName, yearOfBirthMother);
    }

    /**
     * Возвращает запись из model.service.HumanService по указанному имени и году рождения.
     *
     * @param name        Имя человека.
     * @param yearOfBirth Год рождения человека.
     * @return Объект Member с соответствующим именем и годом рождения, или null, если запись не найдена.
     */
    public Member getRecord(String name, int yearOfBirth) {
        return humanService.getRecord(name, yearOfBirth);
    }

    /**
     * Выводит все записи из model.service.HumanService.
     */
    public List<Human> getAllRecord() {
        return humanService.getAllRecord();
    }

    /**
     * Выводит родителей человека из model.service.HumanService по указанному имени и году рождения.
     *
     * @param name        Имя человека.
     * @param yearOfBirth Год рождения человека.
     */
    public List<Human> getParents(String name, int yearOfBirth) {
        return humanService.getParents(name, yearOfBirth);
    }

    public List<Human> getChildren(String name, int yearOfBirth) {
        return humanService.getChildren(name, yearOfBirth);

    }

    public void sortByAlphabeticalOrder() {
        humanService.sortByAlphabeticalOrder();
    }


    public void sortByDateBirth() {
        humanService.sortByDateBirth();
    }

    public void sortByNameLength() {
        humanService.sortByNameLength();
    }
}
