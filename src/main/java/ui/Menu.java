package ui;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> items;
    private View view;

    public Menu(View view) {
        this.view = view;
        items = new ArrayList<>();
    }

    public String printMenu(){
        StringBuilder sb= new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < items.size(); i++) {
            sb.append(i+1);
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
        MenuItem menuItem = items.get(index-1);
        menuItem.run();
    }
}
