import java.io.Serializable;

import views.ConsoleUI;
import views.View;

public class Main implements Serializable {
    
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}