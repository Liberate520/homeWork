import Human.Human;

public interface View {
    void setPresenter(Presenter presenter); // связывает View с  Presenter

    void start();

    /*Human getRecord(); //ввод данных о субъекте дерева в консоль для создания новой записи

    void getData(); // ввод дополнительных данных о субъекте в консоль

    void getQuery(); // ввод пользователем поискового запроса в консоль

    void getTransmitRequest(); // Запрос на передачу данных в заданном формате*/

    void print(String text); // вывод информации по запросу в консоль

}

