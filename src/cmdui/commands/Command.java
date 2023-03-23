package cmdui.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Command implements ICommand {
    private static Pattern commandPattern = Pattern.compile(
            "^([a-zA-Z]+)(?:\\s|$)");
    private static Pattern paramPattern = Pattern.compile(
            "(/[a-zA-Z]+)\\s([^/]+)");

    private String error;
    protected IOnCommand onCommand;
    protected String input;
    protected String command;
    protected HashMap<String, ArrayList<String>> params = new HashMap<String, ArrayList<String>>();

    Command(IOnCommand onCommand) {
        this.onCommand = onCommand;
    }

    public boolean processCommand(String input) {
        this.input = input;
        searchCommand();
        if (!command.equalsIgnoreCase(this.toString()))
            return false;
        searchParams();
        try {
            error = processCommand();
        } catch (Exception e) {
            error = syntaxError();
        }
        params.clear();
        return true;
    }

    private void searchCommand() {
        Matcher match = commandPattern.matcher(input);
        if (match.find())
            command = match.group(1);
    }

    private void searchParams() {
        Matcher match = paramPattern.matcher(input);
        while (match.find()) {
            String param = match.group(1);
            String value = match.group(2).trim();
            if (!params.containsKey(param))
                params.put(param, new ArrayList<String>());
            params.get(param).add(value);
        }
    }

    public String error() {
        return error;
    }

    protected String syntaxError() {
        return String.format("Неверный синтаксис для команды %s:\n%s", this, syntax());
    }

    public abstract String syntax();

    public abstract String description();

    protected abstract String processCommand() throws Exception;
}
