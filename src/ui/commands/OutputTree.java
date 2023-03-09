package ui.commands;

import presenter.Presenter;

public class OutputTree implements Option{
    private Presenter presenter;

    public OutputTree(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String description() {
        return "Вывести на экран все дерево";
    }

    @Override
    public String execute() {
        return presenter.outputTree();
    }
    
}
