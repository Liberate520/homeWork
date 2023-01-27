import java.io.IOException;

public class ComandSortByBirth implements Option {
    Presenter presenter;

    @Override
    public String dicription() {
        String sortBirth = "Сортировка по дню рождения";
        return sortBirth;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        presenter.comandSortByBirth();
    }

}
