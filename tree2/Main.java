package homeWork.tree2;

import homeWork.tree2.views.UserConnector;
import homeWork.tree2.views.View;


public class Main {
    public static void main(String[] args) {
        View view = new UserConnector();
        view.start();
    }
}
