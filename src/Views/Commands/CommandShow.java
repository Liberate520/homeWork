package Views.Commands;

import Views.Executable;

public class CommandShow implements Command{

    private Executable view;
    public CommandShow(Executable view){
        this.view = view;
    }

    @Override
    public String getInfo() {
        return "Show";
    }

    @Override
    public void execute() {
        view.show();
    }
    
     @Override
    public String getHelp(int number) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%d. Menu item \'%s\':\n", number, getInfo()));
        builder.append(String.format("\tfor show all notes\n\tENTER: \'%d\'\n", number));
        builder.append(String.format("\tfor show sorted notes\n\tENTER: \'%d/[SORT]\'\n", number));
        builder.append(String.format("\t\t - \'si\'  - sorted by index\n"));
        builder.append(String.format("\t\t - \'sh\'  - sorted by header\n"));
        builder.append(String.format("\t\t - \'sa\'  - sorted by author\n"));
        builder.append(String.format("\t\t - \'scr\' - sorted by date of creation\n"));
        builder.append(String.format("\t\t - \'sch\' - sorted by date of change\n"));
        builder.append(String.format("\tfor show sorted notes from concrete [AUTHOR]\n\tENTER: \'%d/[SORT]/[AUTHOR]\'\n", number));
        return builder.toString();
    }
}
