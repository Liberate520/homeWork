package cmdui.commands;

public interface ICommand {
    String processCommand(String input);

    String syntax();

    String description();
}
