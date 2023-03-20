package cmdui;

import java.io.IOException;
import java.util.Scanner;
import java.util.function.Consumer;
import cmdui.commands.ICmdAdd;
import cmdui.commands.ICmdGet;
import cmdui.commands.ICommand;
import cmdui.commands.ICommandFactory;
import cmdui.commands.IOnCommand;

public class FamilyTreeCmd implements IView, IOnCommand {
    private ICommandFactory commFactory;
    private Scanner _sc;
    private ICommand[] commands;
    private Consumer<ICmdGet> cmdGetHandler;
    private Consumer<ICmdAdd> cmdAddHandler;
    private String printOut;

    public FamilyTreeCmd(ICommandFactory commFactory) throws IOException {
            this.commFactory = commFactory;
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
    public void onCmdGet(ICmdGet cmdGet) {
        if(cmdGetHandler != null)
            cmdGetHandler.accept(cmdGet);
    }

    @Override
    public void onCmdAdd(ICmdAdd cmdAdd) {
        if(cmdAddHandler != null)
            cmdAddHandler.accept(cmdAdd);
    }
    
    private void setCommands() {
        commands = new ICommand[] { commFactory.commGet(this), commFactory.commAdd(this)};
    }

    public void run() throws IOException {
        try {
            _sc = new Scanner(System.in, System.console().charset());
            setCommands();
            for (int i = 0; i < commands.length; i++)
                System.out.printf("%s:\n    %s\n", commands[i].description(), commands[i].syntax());
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
        } finally {
            if (_sc != null)
                _sc.close();

        }

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
