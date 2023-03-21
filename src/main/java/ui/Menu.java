package ui;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> items;
    private ConsoleUI consoleUI;

    public Menu(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        items = new ArrayList<>();
    }

    public String printMenu(){
        StringBuilder sb= new StringBuilder();
        sb.append("\n");

        for (int i = 0; i < items.size(); i++) {
            sb.append(i);
            sb.append("| ");
            sb.append(items.get(i).description());
            sb.append("\n");
        }
        return sb.toString();
    }
    public void addItem(MenuItem item){
        items.add(item);
    }

    void run(int index){
        MenuItem menuItem = items.get(index);
        menuItem.run();
    }



}
