import model.*;
import view.Console;
import view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println("-".repeat(10));
        View view = new Console();
        view.start();

  }
}