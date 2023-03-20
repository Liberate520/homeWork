package cmdui.commands;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CmdAdd extends Command implements ICmdAdd {
    private String name;
    private String sex;
    private Date birthDay;
    private int[] parents;

    CmdAdd(IOnCommand onCommand) {
        super(onCommand);
        parents = new int[2];
    }

    @Override
    public String syntax() {
        return "ADD {/n <имя> /s <пол> /b <дата рождения> /f <id отца> /m <id матери>}";
    }

    @Override
    public String description() {
        return "Добавить нового члена в древо.";
    }

    @Override
    public String toString() {
        return "ADD";
    }

    @Override
    protected String processCommand() throws Exception {
        ArrayList<String> n = params.get("/n");
        ArrayList<String> s = params.get("/s");
        ArrayList<String> b = params.get("/b");
        ArrayList<String> f = params.get("/f");
        ArrayList<String> m = params.get("/m");
        if (n == null || s == null || b == null || f == null || m == null)
            return syntaxError();
        name = n.get(0);
        sex = s.get(0);
        birthDay = new SimpleDateFormat("dd.MM.yyyy").parse(b.get(0));
        parents[0] = Integer.parseInt(f.get(0));
        parents[1] = Integer.parseInt(m.get(0));
        onCommand.onCmdAdd(this);
        return null;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }
    
    public Date getBirthDay() {
        return birthDay;
    }

    public int[] getParents() {
        return parents;
    }
}
