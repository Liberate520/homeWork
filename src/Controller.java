import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    ArrayList<String> notebook = new ArrayList<>();
    String text;
    public void addText(String text){
        Scanner scan = new Scanner(System.in);
        notebook.add(text);
    }
    public void delText(int dell){
        notebook.remove(dell);
    }

    public ArrayList<String> getNotebook() {
        return notebook;
    }
    public void printText(){
        for (int i = 0; i < notebook.size(); i++) {
            System.out.println(notebook.get(i));
        }
        System.out.println("\n");
    }
}
