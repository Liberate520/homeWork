import mvp.ui.View;
import mvp.ui.ConsoleUI;

public class MainTest {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}
