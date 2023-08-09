package familytree.view.comands;

import familytree.view.Console;

public class PrintInfo extends Comand {

    public PrintInfo(Console console) {
        super(console);

        description = "Вывести информациб";

    }

    public void execute() {
        console.printInfo();
    }

}