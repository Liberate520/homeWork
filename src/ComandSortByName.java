import java.io.IOException;

public class ComandSortByName implements Option {
    Presenter presenter;

    @Override
    public String dicription() {
        String sort = "Сортировка по имени";
        return sort;
    }

    @Override
    public void execute() throws IOException {
        presenter.comandSortByName();
    }

}
