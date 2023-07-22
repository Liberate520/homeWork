package faminly_tree.view.add_human;

import faminly_tree.view.ConsoleUI;

public class Finish extends HumanData{

    public Finish(ConsoleUI console, Container container) {
        super(console, container);
        description = "Завершить ввод данных и добавить человека";
    }

    @Override
    public void execute() {
        console.finishAddHuman(container.getName(), container.getSurname(), container.getPatronymic(),
                container.getSex(), container.getBirth(), container.getDeath());
    }
}
