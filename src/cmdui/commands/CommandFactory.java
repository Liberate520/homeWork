package cmdui.commands;

public class CommandFactory implements ICommandFactory {
    public ICommand commGet(IOnCommand onCommand) {
        return new CmdGet(onCommand);
    }

    public ICommand commAdd(IOnCommand onCommand) {
        return new CmdAdd(onCommand);
    }

    public ICommand commUpdate(IOnCommand onCommand) {
        return new CmdUpdate(onCommand);
    }
}
