package Notebook.UI;

public class Menu {
    private String[] menu;
    private int size;
    private int index;

    public Menu() {
        size = 6;
        index = 0;
        menu = new String[size];
        menu[index++] = "Add new recording.";
        menu[index++] = "View all entries.";
        menu[index++] = "Edit the recording.";
        menu[index++] = "Delete the recording.";
        menu[index++] = "Save changes.";
        menu[index++] = "Exit.";
    }

    void printMenu() {
        System.out.println("\t\tMenu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println("\t" + (i + 1) + ". " + menu[i]);
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
