import java.util.ArrayList;

public class Model {
    public Presenter presenter;
    private ArrayList<String> notes;
    private static final String WAITING_COMMAND = "Введите номер команды:\n\t1. Показать записи\n\t2. Ввести новую запись";
    private static final String WAITING_NOTE = "Введите запись:";
    private static final String SHOW_NOTES = "1";
    private static final String INPUT_NOTE = "2";
    private static final String EXIT = "3";
    public boolean keepWorking;

    public Model() {
        notes = new ArrayList<>();
        keepWorking = true;
    }

    public void start() {
        presenter.message(WAITING_COMMAND);
    }

    public String putUserInput(String userString) {
        if (userString.equals(SHOW_NOTES)) {
            return notes.toString();
        } else if (userString.equals(INPUT_NOTE)) {
            return WAITING_NOTE;
        } else if (userString.equals(EXIT)) {
            keepWorking = false;
        } else {
            notes.add(userString);
            return WAITING_COMMAND;
        }
        return WAITING_COMMAND;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
