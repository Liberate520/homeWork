package view.commands;

import presenter.Presenter;
import view.Text;

public class SorterByName implements Command{
    String description = "Sort by name";

    public void start(Presenter presenter){
        presenter.sortByName();
        Text.sortingComplete();
    }

    @Override
    public String getDescription() {
        return description;
    }
}
