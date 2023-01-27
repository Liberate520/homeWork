import java.io.IOException;

public class ComandSearchByName implements Option {
    Presenter presenter;

    @Override
    public String dicription() {
        String search = "Поис человека по имени";
        return search;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        presenter.comandSearchByName();

    }

}
