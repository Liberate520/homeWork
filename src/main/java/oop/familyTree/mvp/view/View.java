package oop.familyTree.mvp.view;

public interface View {

    /**
     * Демонстрация всех сохранённых древ
     */
    void showNameFamilyTree();

    /**
     * Добавление нового древа
     */
    void addNewTree();

    /**
     * Информация о выбранном древе
     */
    void infoAboutSelectedTree();

    /**
     * Добавление нового человека в выбранное древо
     */
    void addNewHuman();

    /**
     * Удаление человека из древа
     */
    void deletingHuman();

    /**
     * Сортировка древа по имени
     */
    void sortByName();

    /**
     * Сортировка древа по возрасту
     */
    void sortByAge();

    /**
     * Информация о человеке
     */
    void fullInfoHuman();

    /**
     * Изменение поля
     */
    void changeField();

    /**
     * Закрытие приложения
     */
    void finish();
}
