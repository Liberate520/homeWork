package cmdui.commands;

import java.util.ArrayList;
import familytree.SortMode;

class CmdGet extends Command implements ICmdGet {
    private SortMode sortMode;
    private int id = 0;
    private String name;

    CmdGet(IOnCommand onCommand) {
        super(onCommand);
    }

    @Override
    public String syntax() {
        return "GET [/sort <name|year>] [/id <id>|/name <имя>]";
    }

    @Override
    public String description() {
        return "Получить информацию о членах древа";
    }

    @Override
    public String toString() {
        return "GET";
    }

    @Override
    protected String processCommand() {
        ArrayList<String> sort = params.get("/sort");
        if (sort != null) {
            if(sort.get(0).equals("name"))
                sortMode = SortMode.name;
            else if(sort.get(0).equals("year"))
                sortMode = SortMode.birthDay;
            else
                return syntaxError();
        }
        else  sortMode = SortMode.noSort;

        ArrayList<String> pid = params.get("/id");
        ArrayList<String> pname = params.get("/name");
        if (pid != null)
            id = Integer.parseInt(pid.get(0));
        else if(pname != null)
            name = pname.get(0);
        onCommand.onCmdGet(this);
        return null;
    }

    public SortMode getSortMode() {
        return sortMode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
