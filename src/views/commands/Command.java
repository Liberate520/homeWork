package views.commands;

public interface Command {
    /** описание действия */
    String getDescription();
    /** выполнение действия */
    void execute();
}
