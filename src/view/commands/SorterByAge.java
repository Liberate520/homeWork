package view.commands;

import presenter.Presenter;
import view.Text;

public class SorterByAge implements Command{

    String description = "Sort by age";

    public void start(Presenter presenter){
        presenter.sortByAge();
        Text.sortingComplete();
    }

    @Override
    public String getDescription() {
        return description;
    }
}
