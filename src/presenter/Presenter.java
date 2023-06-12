package presenter;

import model.HumanService;
import model.members.Gender;
import model.members.Member;

import java.io.Serializable;

/**
 * Класс Presenter служит посредником между представлением (UI) и моделью (HumanService).
 * <p>
 * Он обрабатывает взаимодействие с пользователем, обрабатывает ввод и соответствующим образом обновляет модель.
 */
public class Presenter implements Serializable {
    private HumanService humanService;

    /**
     * Создает новый объект Presenter.
     * Инициализирует HumanService.
     */
    public Presenter() {
        this.humanService = new HumanService();
    }

    /**
     * Возвращает объект HumanService, связанный с Presenter.
     *
     * @return Объект HumanService.
     */
    public HumanService getHumanService() {
        return humanService;
    }

    /**
     * Импортирует файл с указанным путем filePath в HumanService.
     *
     * @param filePath Путь к импортируемому файлу.
     */
    public void importFile(String filePath) {
        humanService.importFile(filePath);
    }

    /**
     * Сохраняет данные в HumanService в файл.
     */
    public void saveFile() {
        humanService.saveFile();
    }

    /**
     * Добавляет запись в HumanService с указанными именем, полом и годом рождения.
     *
     * @param name        Имя человека.
     * @param gender      Пол человека.
     * @param dateOfBirth Год рождения человека.
     */
    public void addRecord(String name, String gender, String dateOfBirth) {
        int year = Integer.parseInt(dateOfBirth);

        if (Gender.fromStringValue(gender) != null) {
            humanService.addRecord(name, Gender.fromStringValue(gender), year);
        } else {
            System.out.println("Неверно указан пол");
        }
    }

    /**
     * Возвращает запись из HumanService по указанному имени и году рождения.
     *
     * @param name Имя человека.
     * @param year Год рождения человека.
     * @return Объект Member с соответствующим именем и годом рождения, или null, если запись не найдена.
     */
    public Member getRecord(String name, String year) {
        int num = Integer.parseInt(year);
        return humanService.getRecord(name, num);
    }

    /**
     * Выводит все записи из HumanService.
     */
    public void getAllRecord() {
        humanService.getAllRecord();
    }

    /**
     * Выводит родителей человека из HumanService по указанному имени и году рождения.
     *
     * @param name        Имя человека.
     * @param yearOfBirth Год рождения человека.
     */
    public void getParents(String name, String yearOfBirth) {
        int num = Integer.parseInt(yearOfBirth);
        humanService.getParents(name, num);
    }

    /**
     * Сортирует дерево в HumanService в соответствии с указанным выбором.
     *
     * @param choice Выбор типа сортировки.
     */
    public void sortTree(String choice) {
        humanService.sortTree(choice);
    }
}
