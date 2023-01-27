import java.io.IOException;

public class ComandAddNewHuman implements Option {
    Presenter presenter;

    @Override
    public String dicription() {
        String newHuman = "Добавить человека в дерево";
        return newHuman;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        presenter.comandAddNewHuman();
    }

}
