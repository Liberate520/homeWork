import java.io.IOException;

public class ComandRead implements Option {
    Presenter presenter;

    @Override
    public String dicription() {
        String read = "Прочитать ваше дерево";
        return read;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        presenter.comandRead();
    }

}
