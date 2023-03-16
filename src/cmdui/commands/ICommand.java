package cmdui.commands;

public interface ICommand {
    boolean processCommand(String input);

    String error();

    String syntax();

    String description();
}
