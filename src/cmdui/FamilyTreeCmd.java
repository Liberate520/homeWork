package cmdui;

import java.io.IOException;
import java.util.Scanner;
import java.util.function.Consumer;
import cmdui.commands.ICmdAdd;
import cmdui.commands.ICmdGet;
import cmdui.commands.ICommand;
import cmdui.commands.ICommandFactory;
import cmdui.commands.IOnCommand;
import presenter.PresenterFactory;

public class FamilyTreeCmd implements IView, IOnCommand {
    private ICommandFactory commFactory;
    private Scanner _sc;
    private ICommand[] commands;
    private Consumer<ICmdGet> cmdGetHandler;
    private Consumer<ICmdAdd> cmdAddHandler;
    private String printOut;

    public FamilyTreeCmd(ICommandFactory commFactory, PresenterFactory presenterFactory) throws IOException {
        try {
            this.commFactory = commFactory;
            _sc = new Scanner(System.in, System.console().charset());
            setCommands();
            for (int i = 0; i < commands.length; i++)
                System.out.printf("%s:\n    %s\n", commands[i].description(), commands[i].syntax());
            presenterFactory.createPresenter(this);
            Run();
        } finally {
            if (_sc != null)
                _sc.close();

        }
    }

    public void setCmdGetHandler(Consumer<ICmdGet> handler) {
        cmdGetHandler = handler;
    }

    public void setCmdAddHandler(Consumer<ICmdAdd> handler) {
        cmdAddHandler = handler;
    }

    public void setPrintOut(String out) {
        printOut = out;
    }
    
    @Override
    public void OnCmdGet(ICmdGet cmdGet) {
        if(cmdGetHandler != null)
            cmdGetHandler.accept(cmdGet);
    }

    @Override
    public void OnCmdAdd(ICmdAdd cmdAdd) {
        if(cmdAddHandler != null)
            cmdAddHandler.accept(cmdAdd);
    }
    
    private void setCommands() {
        commands = new ICommand[] { commFactory.commGet(this), commFactory.commAdd(this)};
    }

    private void Run() throws IOException {
        while (true) {
            String input = _sc.nextLine();
            if (input.length() == 0)
                break;
            String out = "Неизвестная команда";
            for (ICommand command : commands) {
                if (!command.processCommand(input))
                    continue;
                if(command.error() != null)
                    out = command.error();
                else
                    out = printOut;
                break;
            }
            if (out == "")
                break;
            System.out.println(out);
        }
    }
}
