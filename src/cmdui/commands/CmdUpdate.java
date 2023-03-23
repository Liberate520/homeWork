package cmdui.commands;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CmdUpdate extends Command implements ICmdUpdate {
    private int id = 0;
    private String name;
    private Date deathDay;

    CmdUpdate(IOnCommand onCommand) {
        super(onCommand);
    }

    @Override
    public String syntax() {
        return "UPDATE /id <id> [/n <новое имя>] [/d <дата смерти>]";
    }

    @Override
    public String description() {
        return "Изменить данные члена древа";
    }

    @Override
    public String toString() {
        return "UPDATE";
    }

    @Override
    protected String processCommand() throws Exception {
        ArrayList<String> id = params.get("/id");
        ArrayList<String> n = params.get("/n");
        ArrayList<String> d = params.get("/d");
        if (id == null)
            return syntaxError();
        this.id = Integer.parseInt(id.get(0));
        if (n != null)
            name = n.get(0);
        if (d != null)
            deathDay = new SimpleDateFormat("dd.MM.yyyy").parse(d.get(0));
        onCommand.onCmdUpdate(this);
        return null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDeathDay() {
        return deathDay;
    }
}
