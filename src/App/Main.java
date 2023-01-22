package App;

import Controller.*;
import Model.*;
import View.*;

public class Main {
    public static void main(String[] args) {
        Service model = new Service();
        Presenter controller = new Presenter(model);
        View view = new View(controller);

        view.init();

        while (true){
            view.CallMenu();
        }
    }
}
