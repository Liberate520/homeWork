package view;

import java.util.LinkedHashMap;
import java.util.Scanner;
import presenter.Presenter;
import view.command.Commands;

public class ConsoleUI implements UI {
    private Scanner scan;
    private String default_cursor = "$: ";
    private String curr_cursor = default_cursor;
    private Presenter presenter;
    private int current_id;
    private LinkedHashMap<String, Commands> command_list = new LinkedHashMap<>();
    private StringBuilder helper = new StringBuilder();

    public ConsoleUI() {
        this.scan = new Scanner(System.in);
    }

    @Override
    public void start() {
        this.print(this.helper.toString());
        String cmd = "";
        while (true) {
            LinkedHashMap<String, String> map = commandParse(commandFromConsole());

            if (map.entrySet().iterator().hasNext())
                cmd = map.entrySet().iterator().next().getKey();
            
            if (cmd.equals("break"))
                break;

            if (!command_list.containsKey(cmd))
                cmd = "notfound";

            command_list.get(cmd).execute(map);
        }
    }

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    public String getDefault_cursor() {
        return default_cursor;
    }

    public int getCurrent_id() {
        return current_id;
    }

    public void setCursor(String cursor) {
        this.curr_cursor = cursor;
    }

    public void setCurrent_id(int current_id) {
        this.current_id = current_id;
    }

    private void addToHelper(String help) {
        helper.append(help);
    }

    private String commandFromConsole() {
        System.out.print("\n" + this.curr_cursor);
        String command = scan.nextLine();
        return command;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public Presenter getPresenter() {
        return this.presenter;
    }

    public void addCommands(Commands command){
        this.command_list.put(command.getCommandName(),command);
        this.addToHelper(command.getCommandHelp());
    }

    private LinkedHashMap<String, String> commandParse(String command) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        String[] command_array = command.split(":");
        if (command_array.length > 2 | command_array.length == 0) {
            return map;
        }

        if (command_array.length == 2) {
            map.put(command_array[0], command_array[1]);
            return map;
        }

        if (command_array.length == 1) {
            map.put(command_array[0], null);
            return map;
        }
        return map;
    }

}