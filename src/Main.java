import presenter.Presenter;
import view.ConsoleUI;

public class Main {
    public static void main(String[] args) {

        ConsoleUI v = new ConsoleUI();
        Presenter p = new Presenter(v);
        v.run();
    }

    /**
     * TODO
     * валидация имени объекта
     *      мы должны иметь возможность вводить только символы
     * валидация ConsoleUI.getGender
     *      1.при не правильном выборе пропускается шаг, значение - null
     * валидация даты
     *          пропускает шаг, при попытке вывода объекта в консоль,
     *          выдает DateTimeFormatter так как не может спарсить дату
     * валидация ConsoleUI.getParents
     *          пропускает шаг, в консоле выводится мое сообщение об ошибке
     *          объект не создается
     *
     * РАЗОБРАТСЯ В РЕГУЛЯРНЫХ ВЫРАЖЕНИЯХ
     */
}
