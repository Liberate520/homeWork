package ui.commands.setCommands;

public abstract class SetCommand {
    protected String option;
    public SetCommand(ui.Console console, String text){
        System.out.println("Введите "+ text +": ");
        option = console.getScanner().nextLine();
    }
    public String getOption(){
        return option;
    }
}
