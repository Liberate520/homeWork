package Tree.ui.commands;

// интерфейс указывает какие методы нужно реализовать при вызове каждой команды
public interface Option {

    // методы для реализации
    String description();

    void execute();
}
