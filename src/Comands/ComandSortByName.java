package Comands;
import java.io.IOException;
import Presenter.Presenter;
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
