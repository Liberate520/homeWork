package cmdui;

import java.io.IOException;
import java.util.Scanner;

import cmdui.commands.ICommand;
import cmdui.commands.ICommandFactory;

class FamilyTreeCmd
{
    private ICommandFactory commFactory;
    private Scanner _sc;
    private ICommand[] commands;
    
    FamilyTreeCmd(ICommandFactory commFactory) throws IOException
    {
        try
        {
            this.commFactory = commFactory;
            _sc = new Scanner(System.in, System.console().charset());
            setCommands();
            for (int i = 0; i < commands.length; i++)
                System.out.printf("%s:\n    %s\n", commands[i].description(), commands[i].syntax());
            Run();
        }
        finally
        {
            if(_sc != null)
                _sc.close();

        }
    }

    private void setCommands() {
        commands = new ICommand[] { commFactory.commGet() };
    }
    
    private void Run() throws IOException
    {
        while(true)
        {
            String input = _sc.nextLine();
            if(input.length() == 0) break;
            String out = "Неизвестная команда";
            for(ICommand command : commands)
            {
                String result = command.processCommand(input);
                if(result == null) continue;
                out = result;
                break;
            }
            if(out == "") break;
            System.out.println(out);
        }
    }
}
