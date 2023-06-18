package Views;

import java.util.Scanner;

import Presenters.NotesPresenter;

public class ConsoleView implements View, Executable {

    private boolean isWork;
    private Menu menu;
    private Scanner scanner;
    private NotesPresenter presenter;
    private String[] parameters;
    private Integer choice;

    public ConsoleView() {
        isWork = true;
        menu = new Menu(this);
        scanner = new Scanner(System.in);
        presenter = new NotesPresenter();
    }

    // #region implements view
    @Override
    public void print(String text) {
        System.out.print(text);
    }

    @Override
    public void start() {
        showMenu();
        showInputField();
        do {
            Dialog();
        } while (isWork);
    }
    // #endregion

    // #region dialogs
    private void showTitle() {
        print("\u2591\u2591\u2592\u2593\u2588\u001B[47mPOWERFUL NOTE APPLICATION\u001B[0m\u2588\u2593\u2592\u2591\u2591\n");
    }

    private void showMenu() {
        clearScreen();
        showTitle();
        print(this.menu.toString());
        print("\n-----------------------------------------------------\n");
    }

    private void Dialog() {
        do{
            showInputField();
        }while(!getInput(scanner.nextLine()));
        showMenu();
        menu.execute(this.choice);    
    }

    private boolean getInput(String line) {
        parameters = line.split("/");
        if(isDigit(parameters[0]))
        {
            choice = Integer.parseInt(parameters[0]) - 1;
            return true;
        }
        return false;
    }

    private boolean isDigit(String data) {
        return data.matches("[0-9]+");
    }

    private void showInputField() {
        print("\n-----------------------------------------------------\n");
        print("> ");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    // #endregion

    // #region implements executable
    @Override
    public void show() {
        if(parameters.length == 1)
            print(presenter.show(null, null));
        else if(parameters.length == 2)    
            print(presenter.show(parameters[1], null));
        else if(parameters.length > 3) 
            print(presenter.show(parameters[1], parameters[2]));
        else {
            print("wrong input, enter \"1\" or \"1/[sort]\" or \"1/[sort]/[author name]\"\n");
            print("(si - sort by id, sh - sort by header, sa - sort by author)\n");
            print("(scr - sort by date of creation, sch - sort by date of change)\n");
        }
    }

    @Override
    public void read() {
        if(parameters.length < 2) {
            print("wrong input, enter \"2/[id]\" or \"2/[header name]\"\n");
            return;
        }
        if(isDigit(parameters[1])){        
            print(presenter.getNote(Integer.parseInt(parameters[1])));
        } else {
            print(presenter.getNote(parameters[1]));
        }

    }

    @Override
    public void create() {
         if(parameters.length < 4) {
            print("wrong input, enter \"3/[header]/[content]/[author]\"");
            return;
        }
        if(presenter.addNote(parameters[1], parameters[2], parameters[3])){
            print("new note was added successful");
        } else {
            print("something went wrong new note was not added");
        }
    }

    @Override
    public void remove() {
        if(parameters.length < 2) {
            print("wrong input, enter \"4/[id]\"");
            return;
        }
        if(isDigit(parameters[1]) && presenter.remove(Integer.parseInt(parameters[1]))){
            print("note was removed successful");
        } else {
            print("something went wrong new note was not removed");
        }
        
    }

    @Override
    public void update() {
        if(parameters.length < 5) {
            print("wrong input, enter \"5/[id]/[header]/[content]/[author]\"");
            return;
        }
        if(isDigit(parameters[1]) && presenter.updateNote(Integer.parseInt(parameters[1]), parameters[2], parameters[3], parameters[3])){
            print("new note was updated successful");
        } else {
            print("something went wrong new note was not updated");
        }
    }

    
    @Override
    public void clear() {
        if(presenter.clear()){
            print("notes was cleared");
        } else {
            print("something went wrong notes was not cleared");
        }
    }
    
    @Override
    public void save() {
        if(presenter.save()){
            print("notes was saved");
        } else {
            print("something went wrong notes was not saved");
        }
    }

    @Override
    public void quit() {
        print("thank's for using this application!\n");
        isWork = false;
    }


    // #endregion
}