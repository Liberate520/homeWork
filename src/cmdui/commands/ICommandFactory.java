package cmdui.commands;

public interface ICommandFactory {
    ICommand commGet(IOnCommand onCommand);

    ICommand commAdd(IOnCommand onCommand);
}
