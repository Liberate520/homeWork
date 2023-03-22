import Storage.Storage;

public class Model {
    public Presenter presenter;
    private Storage storage;
    private static final String WAITING_COMMAND = "Введите номер команды:\n\t1. Показать записи\n\t2. Ввести новую запись\n\t3. Выход";
    private static final String WAITING_NOTE = "Введите запись:";
    private static final String SHOW_NOTES = "1";
    private static final String INPUT_NOTE = "2";
    private static final String EXIT = "3";

    public Model(Storage storage) {
        this.storage = storage;
    }

    public void start(){
        presenter.message(WAITING_COMMAND);
    }

    public String putUserInput(String userString){
        if (userString.equals(SHOW_NOTES)) {
            return storage.read();
        } else if (userString.equals(INPUT_NOTE)) {
            return WAITING_NOTE;
        } else if (userString.equals(EXIT)) {
            System.exit(0);

        } else {
            storage.save(userString);
            return WAITING_COMMAND;
        }
        return WAITING_COMMAND;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
